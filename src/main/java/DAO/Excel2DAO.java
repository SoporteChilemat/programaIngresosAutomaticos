/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Clases.Excel2;
import static Ventanas.VentanaMain.conex;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sopor
 */
public class Excel2DAO {

    public static boolean registraExcel2(Excel2 excel2) throws IOException, SQLException {
        System.out.println("INSERT INTO dbo.proveedores (proveedor, razonSocial) VALUES ('"
                + excel2.getRut() + "', '"
                + excel2.getRazonSocial() + "')"
        );
        try (Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("INSERT INTO dbo.proveedores (proveedor, razonSocial) VALUES ('"
                    + excel2.getRut() + "', '"
                    + excel2.getRazonSocial() + "')"
            );
//            JOptionPane.showMessageDialog(null, "Se ha Registrado Ingreso Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
//            JOptionPane.showMessageDialog(null, "No se Registro la Ingresos\n" + e);
            return false;
        }
    }
}
