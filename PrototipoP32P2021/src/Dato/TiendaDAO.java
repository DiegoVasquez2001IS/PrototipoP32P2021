/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

import Dominio.Tienda;
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
public class TiendaDAO {
    private static final String SQL_SELECT = "SELECT * FROM tienda";
    private static final String SQL_INSERT = "INSERT INTO tienda VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tienda SET Nombre_Tienda = ?, Ubicacion_Tienda = ?, Estado_Tienda = ? WHERE Codigo_Tienda = ?";
    private static final String SQL_DELETE = "DELETE FROM tienda WHERE Codigo_Tienda = ?";
    private static final String SQL_QUERY = "SELECT * FROM tienda WHERE Codigo_Tienda = ?";

    public List<Tienda> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tienda tienda = null;
        List<Tienda> tiendas = new ArrayList<Tienda>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                tienda = new Tienda();
                tienda.setCodigoTienda(rs.getString(1));
                tienda.setNombreTienda(rs.getString(2));
                tienda.setUbicacionTienda(rs.getString(3));
                tienda.setEstadoTienda(rs.getString(4));
                
                tiendas.add(tienda);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return tiendas;
    }

    public int insert(Tienda tienda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, tienda.getCodigoTienda());
            stmt.setString(2, tienda.getNombreTienda());
            stmt.setString(3, tienda.getUbicacionTienda());
            stmt.setString(4, tienda.getEstadoTienda());

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

    public int update(Tienda tienda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, tienda.getNombreTienda());
            stmt.setString(2, tienda.getUbicacionTienda());
            stmt.setString(3, tienda.getEstadoTienda());
            stmt.setString(4, tienda.getCodigoTienda());

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

    public int delete(Tienda tienda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando Query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, tienda.getCodigoTienda());
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

    public Tienda query(Tienda tienda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando Query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, tienda.getCodigoTienda());
            rs = stmt.executeQuery();
            tienda = new Tienda();
            while (rs.next()) {

                tienda.setCodigoTienda(rs.getString(1));
                tienda.setNombreTienda(rs.getString(2));
                tienda.setUbicacionTienda(rs.getString(3));
                tienda.setEstadoTienda(rs.getString(4));
                

            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return tienda;
    }
}
