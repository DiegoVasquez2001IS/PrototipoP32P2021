/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

import Dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego Vásquez
 */
public class ClienteDAO extends Conexion {

    private static final String SQL_SELECT = "SELECT * FROM cliente";
    private static final String SQL_INSERT = "INSERT INTO cliente VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE cliente SET Nombre_Cliente = ?, Dpi_Cliente = ?, Telefono_Cliente = ?, Dirreccion_Cliente = ?, Correo_Cliente = ? WHERE Numero_Tarjeta = ?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE Numero_Tarjeta = ?";
    private static final String SQL_QUERY = "SELECT * FROM cliente WHERE Numero_Tarjeta = ?";

    public List<Cliente> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setNumeroTarjeta(rs.getString(1));
                cliente.setNombreCliente(rs.getString(2));
                cliente.setDpiCliente(rs.getString(3));
                cliente.setTelefonoCliente(rs.getString(4));
                cliente.setDireccionCliente(rs.getString(5));
                cliente.setCorreoCliente(rs.getString(6));
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return clientes;
    }

    public int insert(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNumeroTarjeta());
            stmt.setString(2, cliente.getNombreCliente());
            stmt.setString(3, cliente.getDpiCliente());
            stmt.setString(4, cliente.getTelefonoCliente());
            stmt.setString(5, cliente.getDireccionCliente());
            stmt.setString(6, cliente.getCorreoCliente());
            stmt.setString(7, cliente.getMoraAcumulada());
            stmt.setString(8, cliente.getRentaAcumulada());
            stmt.setString(9, cliente.getBonosAcumulados());

            System.out.println("Ejecutando Query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros Afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombreCliente());
            stmt.setString(2, cliente.getDpiCliente());
            stmt.setString(3, cliente.getTelefonoCliente());
            stmt.setString(4, cliente.getDireccionCliente());
            stmt.setString(5, cliente.getCorreoCliente());
            stmt.setString(6, cliente.getNumeroTarjeta());

            rows = stmt.executeUpdate();
            System.out.println("Registros Actualizados:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando Query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, cliente.getNumeroTarjeta());
            rows = stmt.executeUpdate();
            System.out.println("Registros Eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public Cliente query(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando Query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, cliente.getNumeroTarjeta());
            rs = stmt.executeQuery();
            cliente = new Cliente();
            while (rs.next()) {

                cliente.setNumeroTarjeta(rs.getString(1));
                cliente.setNombreCliente(rs.getString(2));
                cliente.setDpiCliente(rs.getString(3));
                cliente.setTelefonoCliente(rs.getString(4));
                cliente.setDireccionCliente(rs.getString(5));
                cliente.setCorreoCliente(rs.getString(6));

            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return cliente;
    }

}
