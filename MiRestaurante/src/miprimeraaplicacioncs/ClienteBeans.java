package miprimeraaplicacioncs;

/**
 *
 * @author Usuario
 */
import java.sql.*;


public class ClienteBeans {
    
    private int Id_Cliente;
    private String Nombres;
    private String Direccion;
    private String Telefono;
    private String Correo;
    accesobd bd;

    public ClienteBeans() throws Exception {
        bd = new accesobd("localhost", "root", "", "restaurantesj");
        bd.conectarBD();
    }

    public void setId_Cliente(int Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
     public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }
    
     public String getCorreo() {
        return Correo;
    }

    public int Incremento_CLiente() throws SQLException {
        int inc;
        ResultSet rs;
        rs = bd.consultaBD("SELECT max(idcliente) as num FROM clientes;");
        if (rs.next()) {
            inc = rs.getInt(1) + 1;
        } else {
            inc = 1;
        }
        return inc;
    }

    public void Insertar_Cliente() throws SQLException {
        String cadena = "insert into clientes values('" + Incremento_CLiente() + "','" + getNombres() + "','"  + getDireccion() + "','" + getTelefono() + "','" + getCorreo() + "')";
        bd.ActualizarBD(cadena);

    }

    public void Actualizar_Cliente() throws SQLException {
        String cadena = "update clientes set nombre='"+ getNombres()+"', direccion= '" + getDireccion() +"',telefono= '" + getTelefono() +"',correo= '" +getCorreo()+ "'where idcliente='" + getId_Cliente()+ "' ";
        bd.ActualizarBD(cadena);
    }

    public void Eliminar_Cliente() throws SQLException{
        String cadena = "delete from clientes where idcliente ='" + getId_Cliente()+ "'";
        bd.ActualizarBD(cadena);
    }
    
    public ResultSet buscarClientePorId(int Id_Cliente) throws SQLException {
    String consulta = "SELECT * FROM clientes WHERE idcliente = " + Id_Cliente;
    return bd.consultaBD(consulta);
}



    public ResultSet consultaTabla(String sql) throws SQLException {
        return bd.consultaBD(sql);
    }

    public void Consultar_Cliente() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("select * from clientes");
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
