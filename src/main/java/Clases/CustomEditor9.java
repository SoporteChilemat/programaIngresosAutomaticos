/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import DAO.IngresosDAO;
import DAO.PareoCodigoDAO;
import DAO.ProductoOrdenDeCompraDAO;
import Logica.LogicaPrincipal;
import static Logica.LogicaPrincipal.vd;
import Ventanas.VentanaAgregarCodigo1;
import Ventanas.VentanaDetalle;
import static Ventanas.VentanaDetalle.arrPoductoOrdenDeCompra;
import static Ventanas.VentanaDetalle.arrProductosIngresados;
import Ventanas.VentanaMain;
import static Ventanas.VentanaMain.numeroOC;
import static Ventanas.VentanaMain.proveedor;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

/**
 *
 * @author sopor
 */
public class CustomEditor9 extends AbstractCellEditor implements TableCellEditor {

    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    JTable jTable;

    @Override
    public Object getCellEditorValue() {
        return jLabel1.getText();
    }

    public CustomEditor9(JTable jTable, int num) {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        jLabel1.setText(value.toString());
        return jPanel1;
    }
}
