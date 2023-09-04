/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miprimeraaplicacioncs;

/**
 *
 * @author USUARIO
 */
import java.sql.*;

public class Empleados {

    private int id_empleado;
    private int id_reservaciones;
    private int id_pedido;
    private String nombre;
    private String rol;
    private int salario;
    accesobd bd;

    public Empleados() throws Exception {
        bd = new accesobd("localhost", "root", "", "restaurantesj");
        bd.conectarBD();
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_reservaciones() {
        return id_reservaciones;
    }

    public void setId_reservaciones(int id_reservaciones) {
        this.id_reservaciones = id_reservaciones;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public accesobd getBd() {
        return bd;
    }

    public void setBd(accesobd bd) {
        this.bd = bd;
    }

    public int Incremento_Empleados() throws SQLException {
        int inc;
        ResultSet rs;
        rs = bd.consultaBD("SELECT max(idempleado) as num FROM empleados;");
        if (rs.next()) {
            inc = rs.getInt(1) + 1;
        } else {
            inc = 1;
        }
        return inc;
    }
    

    public void Insertar_Empleados() throws SQLException {
        String cadena = "insert into empleados values('" + Incremento_Empleados() + "','" + getId_reservaciones() + "','" + getId_pedido() + "','" + getNombre() + "','" + getRol() + "','" + getSalario() + "')";
        bd.ActualizarBD(cadena);

    }

    public void Actualizar_Empleados() throws SQLException {
        String cadena = "update empleados set idreservaciones='"+ getId_reservaciones()+"', idpedido= '" + getId_pedido() +"',nombre= '" + getNombre() +"',rol= '" +getRol()+"',salario= '" +getSalario()+ "'where idempleado='" + getId_empleado()+ "' ";
        bd.ActualizarBD(cadena);
    }

    public void Eliminar_Empleados() throws SQLException{
        String cadena = "delete from empleados where idempleado ='" + getId_empleado()+ "'";
        bd.ActualizarBD(cadena);
    }
    

    public ResultSet consultaTabla(String sql) throws SQLException {
        return bd.consultaBD(sql);
    }

    public void Consultar_Empleados() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("select * from empleados");
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

    
    

