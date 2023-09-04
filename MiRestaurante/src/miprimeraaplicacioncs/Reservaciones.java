/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miprimeraaplicacioncs;

import java.sql.*;

/**
 *
 * @author USUARIO
 */
public class Reservaciones {
    private int Id_Reservaciones;
    private int Id_Cliente;
    private String Fecha;
    private String Hora;
    private int Num_Persona;
    accesobd bd;

    public Reservaciones() throws Exception {
        bd = new accesobd("localhost", "root", "", "restaurantesj");
        bd.conectarBD();
    }

    public void setId_Reservaciones(int Id_Reservaciones) {
        this.Id_Reservaciones = Id_Reservaciones;
    }
    
    public void setId_Cliente(int Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public void setNum_Persona(int Num_Persona) {
        this.Num_Persona = Num_Persona;
    }

    public int getId_Reservaciones() {
        return Id_Reservaciones;
    }
    
    public int getId_Cliente() {
        return Id_Cliente;
    }

    public String getFecha() {
        return Fecha;
    }

    public String getHora() {
        return Hora;
    }

    public int getNum_Persona() {
        return Num_Persona;
    }
   

    public int Incremento_Reservaciones() throws SQLException {
        int inc;
        ResultSet rs;
        rs = bd.consultaBD("SELECT max(idreservaciones) as num FROM reservaciones;");
        if (rs.next()) {
            inc = rs.getInt(1) + 1;
        } else {
            inc = 1;
        }
        return inc;
    }
    

    public void Insertar_Reservaciones() throws SQLException {
        String cadena = "insert into reservaciones values('" +Incremento_Reservaciones() + "','" +getId_Cliente() + "','" + getFecha() + "','"  + getHora() + "','" + getNum_Persona() + "')";
        bd.ActualizarBD(cadena);

    }

    public void Actualizar_Reservaciones() throws SQLException {
        String cadena = "update reservaciones set idcliente='"+ getId_Cliente()+"', fecha= '" + getFecha() +"',hora= '" + getHora() +"',numpersona= '" +getNum_Persona()+ "'where idreservaciones='" + getId_Reservaciones()+ "' ";
        bd.ActualizarBD(cadena);
    }

    public void Eliminar_Reservaciones() throws SQLException{
        String cadena = "delete from reservaciones where idreservaciones ='" + getId_Reservaciones()+ "'";
        bd.ActualizarBD(cadena);
    }

    public ResultSet consultaTabla(String sql) throws SQLException {
        return bd.consultaBD(sql);
    }

    public void Consultar_Reservaciones() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("select * from reservaciones");
        while (rs.next()) {
            System.out.print(rs.getInt(1) + " ");
            System.out.print(rs.getString(2) + " ");
            System.out.print(rs.getString(3) + " ");
            System.out.print(rs.getString(4) + " ");
            System.out.print(rs.getString(5) + " ");
            System.out.print(rs.getString(6) + " ");
            System.out.println("");
        }
    }
    
}
