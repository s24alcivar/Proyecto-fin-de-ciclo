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

public class Platos {
    private int Id_Platos;
    private int Id_Pedido;
    private String nombres;
    private String descripcion;
    private int precio;
    accesobd bd;

    public Platos() throws Exception {
        bd = new accesobd("localhost", "root", "", "restaurantesj");
        bd.conectarBD();
    }

    public int getId_Platos() {
        return Id_Platos;
    }

    public void setId_Platos(int Id_Platos) {
        this.Id_Platos = Id_Platos;
    }

    public int getId_Pedido() {
        return Id_Pedido;
    }

    public void setId_Pedido(int Id_Pedido) {
        this.Id_Pedido = Id_Pedido;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public accesobd getBd() {
        return bd;
    }

    public void setBd(accesobd bd) {
        this.bd = bd;
    }

  
    public int Incremento_Platos() throws SQLException {
        int inc;
        ResultSet rs;
        rs = bd.consultaBD("SELECT max(idplatos) as num FROM platos;");
        if (rs.next()) {
            inc = rs.getInt(1) + 1;
        } else {
            inc = 1;
        }
        return inc;
    }

    
    public void Insertar_Platos() throws SQLException {
        String cadena = "insert into platos values('" + Incremento_Platos() + "','" + getId_Pedido() + "','" + getNombres() + "','"  + getDescripcion() + "','" + getPrecio() + "')";
        bd.ActualizarBD(cadena);

    }

    public void Actualizar_Platos() throws SQLException {
        String cadena = "update platos set idpedido='"+ getId_Pedido()+"', nombre= '" + getNombres() +"',descripcion= '" + getDescripcion() +"',precio= '" +getPrecio()+ "'where idplatos='" + getId_Platos()+ "' ";
        bd.ActualizarBD(cadena);
    }

    public void Eliminar_Platos() throws SQLException{
        String cadena = "delete from platos where idplatos ='" + getId_Platos()+ "'";
        bd.ActualizarBD(cadena);
    }

    public ResultSet consultaTabla(String sql) throws SQLException {
        return bd.consultaBD(sql);
    }

    public void Consultar_Platos() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("select * from platos");
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
