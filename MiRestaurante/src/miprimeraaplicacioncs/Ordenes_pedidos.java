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

public class Ordenes_pedidos {
    private int Id_Pedido;
    private String fecha;
    private String hora;
    private int mesa;
    
    accesobd bd;

    public Ordenes_pedidos() throws Exception {
        bd = new accesobd("localhost", "root", "", "restaurantesj");
        bd.conectarBD();
    }

    public int getId_Pedido() {
        return Id_Pedido;
    }

    public void setId_Pedido(int Id_Pedido) {
        this.Id_Pedido = Id_Pedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public accesobd getBd() {
        return bd;
    }

    public void setBd(accesobd bd) {
        this.bd = bd;
    }

    public int Incremento_Ordenes_pedidos() throws SQLException {
        int inc;
        ResultSet rs;
        rs = bd.consultaBD("SELECT max(idpedido) as num FROM ordenespedidos;");
        if (rs.next()) {
            inc = rs.getInt(1) + 1;
        } else {
            inc = 1;
        }
        return inc;
    }

    public void Insertar_Ordenes_pedidos() throws SQLException {
        String cadena = "insert into ordenespedidos values('" + Incremento_Ordenes_pedidos() + "','" + getFecha() + "','"  + getHora() + "','"+ getMesa()+ "')";
        bd.ActualizarBD(cadena);

    }

    public void Actualizar_Ordenes_pedidos() throws SQLException {
        String cadena = "update ordenespedidos set fecha='"+ getFecha()+"', hora= '" + getHora() +"', mesa= '" + getMesa()+"'where idpedido='" + getId_Pedido()+ "' ";
        bd.ActualizarBD(cadena);
    }

    public void Eliminar_Ordenes_pedidos() throws SQLException{
        String cadena = "delete from ordenespedidos where idpedido ='" + getId_Pedido()+ "'";
        bd.ActualizarBD(cadena);
    }

    public ResultSet consultaTabla(String sql) throws SQLException {
        return bd.consultaBD(sql);
    }

     public void Consultar_Ordenes_pedidos() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("select * from ordenespedidos");
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
