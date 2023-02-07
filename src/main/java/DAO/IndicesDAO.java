/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Clases.Indices;
import static Ventanas.VentanaMain.conex;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author sopor
 */
public class IndicesDAO {

    public static void updateIndiceEstado(String indice, String estado) {
        try (Statement estatuto = conex.getConnection().createStatement()) {
            System.out.println("UPDATE dbo.indices SET estado = '" + estado + "' WHERE indice = '" + indice + "'");
            estatuto.executeUpdate("UPDATE dbo.indices SET estado = '" + estado + "' WHERE indice = '" + indice + "'");
            estatuto.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Indices> selectIndices(int num, String ordenDeCompra) throws SQLException {
        ArrayList<Indices> arrIndices = new ArrayList<>();
        if (num == 0) {
            try (PreparedStatement estatuto = conex.getConnection().prepareStatement("SELECT * FROM dbo.indices"); ResultSet res = estatuto.executeQuery()) {
                while (res.next()) {
                    Indices indices = new Indices();
                    indices.setIndece(res.getInt("indice"));
                    indices.setOrdenDeCompra(res.getString("ordenDeCompra"));
                    indices.setEstado(res.getString("estado"));
                    indices.setLocal(res.getString("local"));
                    indices.setPdf(res.getBytes("pdf"));
                    indices.setFolio(res.getString("folio"));
                    arrIndices.add(indices);
                }
            }
        } else {
            try (PreparedStatement estatuto = conex.getConnection().prepareStatement("SELECT * FROM dbo.indices WHERE ordenDeCompra = '" + ordenDeCompra + "'"); ResultSet res = estatuto.executeQuery()) {
                while (res.next()) {
                    Indices indices = new Indices();
                    indices.setIndece(res.getInt("indice"));
                    indices.setOrdenDeCompra(res.getString("ordenDeCompra"));
                    indices.setEstado(res.getString("estado"));
                    indices.setLocal(res.getString("local"));
                    indices.setPdf(res.getBytes("pdf"));
                    indices.setFolio(res.getString("folio"));
                    arrIndices.add(indices);
                }
            }
        }
        return arrIndices;
    }

    public static boolean registraInidice(Indices indices) throws IOException, SQLException {
        try (Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("INSERT INTO dbo.indices (ordenDeCompra, estado, local) VALUES ('"
                    + indices.getOrdenDeCompra() + "', '"
                    + indices.getEstado() + "', '"
                    + indices.getLocal() + "')"
            );
//                JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro indice\n" + e);
            return false;
        }
    }

    public static int selectUltimoIndice() throws SQLException {
        int ultimo = 0;
        try (PreparedStatement estatuto = conex.getConnection().prepareStatement("SELECT MAX(indice) AS ultimo FROM dbo.indices"); ResultSet res = estatuto.executeQuery()) {
            if (res.next()) {
                ultimo = res.getInt("ultimo");
            }
            res.close();
            estatuto.close();
        }
        return ultimo;
    }

    public static void updateIndice(String indice) {
        try (Statement estatuto = conex.getConnection().createStatement()) {
            System.out.println("UPDATE dbo.indice SET estado = 'entregado' WHERE indice = '" + indice + "'");
            estatuto.executeUpdate("UPDATE dbo.indice SET estado = 'entregado' WHERE indice = '" + indice + "'");
            estatuto.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
