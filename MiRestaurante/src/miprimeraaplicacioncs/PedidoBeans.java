/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miprimeraaplicacioncs;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class PedidoBeans {
    private int id_pedido;
    private int id_plato;
    private int cantidad;
    private double precio;
    private double total;
    private accesobd bd;

    public PedidoBeans() throws Exception {
        bd = new accesobd("localhost", "root", "", "restaurantesj");
        bd.conectarBD();
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
     public int Incremento_Pedido() throws SQLException {
        int inc = 0;
        ResultSet rs = bd.consultaBD("SELECT max(idpedido) as num FROM pedido;");
        if (rs.next()) {
            inc = rs.getInt(1) + 1;
        } else {
            inc = 1;
        }
        return inc;
    }

    
    public void Insertar_Pedido() throws SQLException {
        String cadena = "insert into pedido values('" + Incremento_Pedido()+ "','" + getId_plato()+ "','" + getCantidad()+ "','"  + getPrecio()+ "','" + getTotal()+ "')";
        bd.ActualizarBD(cadena);
    }

    public void Actualizar_Pedido() throws SQLException {
        // Implementar la lógica para actualizar el pedido
    }

    public void Eliminar_Pedido() throws SQLException{
        // Implementar la lógica para eliminar el pedido
    }

    public ResultSet consultaTabla(String sql) throws SQLException {
        return bd.consultaBD(sql);
    }

    public void Consultar_Pedido() throws SQLException {
        ResultSet rs = bd.consultaBD("select * from pedido");
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

