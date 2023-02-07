/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Clases.Ingresos;
import static Ventanas.VentanaMain.conex;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sopor
 */
public class IngresosDAO {

    public static boolean registraProductoIngresado(Ingresos ingreso) throws IOException, SQLException {
        System.out.println("INSERT INTO dbo.ingresos (codigo, cantidad, local, rtu, operador, codigoOriginal, fecha, usuario, ordenDeCompra, indice, estado, tipoDocumento, numeroDocumento) VALUES ('"
                + ingreso.getCodigo() + "', '"
                + ingreso.getCantidad() + "', '"
                + ingreso.getLocal() + "', '"
                + ingreso.getRtu() + "', '"
                + ingreso.getOperador() + "', '"
                + ingreso.getCodigoOriginal() + "', '"
                + "CONVERT(DateTime,'" + ingreso.getFecha() + "',121), '"
                + ingreso.getUsuario() + "', '"
                + ingreso.getIndice() + "', '"
                + ingreso.getEstado() + "', '"
                + ingreso.getTipoDocumento() + "', '"
                + ingreso.getNumeroDocumento() + "')"
        );
        try (Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("INSERT INTO dbo.ingresos (codigo, cantidad, local, rtu, operador, codigoOriginal, fecha, usuario, ordenDeCompra, indice, estado, tipoDocumento, numeroDocumento) VALUES ('"
                    + ingreso.getCodigo() + "', '"
                    + ingreso.getCantidad() + "', '"
                    + ingreso.getLocal() + "', '"
                    + ingreso.getRtu() + "', '"
                    + ingreso.getOperador() + "', '"
                    + ingreso.getCodigoOriginal() + "', "
                    + "CONVERT(DateTime,'" + ingreso.getFecha() + "',121), '"
                    + ingreso.getUsuario() + "', '"
                    + ingreso.getOrdenDeCompra() + "', '"
                    + ingreso.getIndice() + "', '"
                    + ingreso.getEstado() + "', '"
                    + ingreso.getTipoDocumento() + "', '"
                    + ingreso.getNumeroDocumento() + "')"
            );
//            JOptionPane.showMessageDialog(null, "Se ha Registrado Ingreso Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
//            JOptionPane.showMessageDialog(null, "No se Registro la Ingresos\n" + e);
            return false;
        }
    }

    public static ArrayList<Ingresos> selectProductoIngresado(String ordenDeCompra) throws SQLException {
        ArrayList<Ingresos> arrProducto = new ArrayList<>();
        try (PreparedStatement estatuto = conex.getConnection().prepareStatement("select a.indice, a.estado, b.codigo, b.cantidad, b.local ,b.rtu, b.operador, b.codigoOriginal, "
                + "b.fecha, b.usuario, b.ordenDeCompra from [ingresoAutomatico].[dbo].[indices] as a inner join [ingresoAutomatico].[dbo].[ingresos] as b on a.[indice] = b.[indice] "
                + "WHERE b.ordenDeCompra = '" + ordenDeCompra + "' AND  a.estado = 'entregado'"); ResultSet res = estatuto.executeQuery()) {
            while (res.next()) {
                Ingresos ingreso = new Ingresos();
                ingreso.setCodigo(res.getString("codigo"));
                ingreso.setCantidad(res.getString("cantidad"));
                ingreso.setLocal(res.getString("local"));
                ingreso.setRtu(res.getString("rtu"));
                ingreso.setOperador(res.getString("operador"));
                ingreso.setCodigoOriginal(res.getString("codigoOriginal"));
                ingreso.setFecha(res.getTimestamp("fecha"));
                ingreso.setUsuario(res.getString("usuario"));
                ingreso.setOrdenDeCompra(res.getString("ordenDeCompra"));
                ingreso.setEstado(res.getString("estado"));
                ingreso.setIndice(res.getInt("indice"));
                arrProducto.add(ingreso);
            }
            res.close();
            estatuto.close();
        }
        return arrProducto;
    }
}
