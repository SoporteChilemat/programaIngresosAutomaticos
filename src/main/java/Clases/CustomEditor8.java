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
public class CustomEditor8 extends AbstractCellEditor implements TableCellEditor {

    javax.swing.JButton jButton1;
    javax.swing.JButton jButton2;
    javax.swing.JComboBox<String> jComboBox1;
    javax.swing.JPanel jPanel1;
    VentanaAgregarCodigo1 popup;
    JTable jTable;

    @Override
    public Object getCellEditorValue() {
        System.out.println("------------- OUTPUT --------------");
        String codigo1 = "";
        try {
            ComboBoxModel<String> model = jComboBox1.getModel();
            for (int i = 0; i < model.getSize(); i++) {
                String elementAt = model.getElementAt(i);
                codigo1 = codigo1 + "@" + elementAt;
            }
            codigo1 = codigo1.replaceFirst("@", "");

            String toString = jComboBox1.getSelectedItem().toString();
            codigo1 = codigo1.replace(toString, "");
            codigo1 = toString + "@" + codigo1;
            codigo1 = codigo1.replaceAll("@@", "@");
        } catch (Exception ex) {

        }

        return codigo1;
    }

    public CustomEditor8(JTable jTable, int num) {
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        this.jTable = jTable;

        jButton1.setText("Agregar");
        jButton2.setText("Quitar");

        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jTable.getSelectedRow();
                Point p = jPanel1.getLocationOnScreen();
                stopCellEditing();

                String toString = jTable.getValueAt(selectedRow, 0).toString();

                popup = new VentanaAgregarCodigo1(VentanaMain.ventanaPrincipal, true, toString);
                popup.setTitle("Codigo Original: " + toString);
                popup.setLocation(p.x, p.y + jPanel1.getSize().height);

                TableColumn column = jTable.getColumnModel().getColumn(1);
                popup.setSize(column.getWidth(), popup.getHeight());
                popup.setVisible(true);
            }
        });

        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jTable.getSelectedRow();
                stopCellEditing();

                String codigoOriginal = jTable.getValueAt(selectedRow, 0).toString();
                String codigo1 = jTable.getValueAt(selectedRow, 1).toString();

                String[] split = codigo1.split("@");

                PareoCodigo pareoCodigo = new PareoCodigo();
                pareoCodigo.setCodigoOriginal(codigoOriginal);
                pareoCodigo.setCodigo1(split[0]);
                pareoCodigo.setProveedor(VentanaMain.proveedor);
                PareoCodigoDAO.deleteCodigo1(pareoCodigo);

                vd.dispose();

                vd = new VentanaDetalle(VentanaMain.ventanaPrincipal, true);
                vd.setLocationRelativeTo(VentanaMain.ventanaPrincipal);

                VentanaDetalle.jLabel2.setText(numeroOC);
                VentanaDetalle.jLabel4.setText(proveedor);

                try {
                    arrPoductoOrdenDeCompra = ProductoOrdenDeCompraDAO.selectproductoOrdenDeCompraWhere(numeroOC, proveedor);
                    arrProductosIngresados = IngresosDAO.selectProductoIngresado(numeroOC);
                } catch (SQLException ex) {
                    Logger.getLogger(CustomEditor8.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println("arrProductosIngresados.size() " + arrProductosIngresados.size());
                LogicaPrincipal.cargaTablaDetalle();

                vd.setVisible(true);
            }
        });

        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String toString = jComboBox1.getSelectedItem().toString();
                System.out.println("toString " + toString);
                int selectedRow = jTable.getSelectedRow();
                stopCellEditing();

                String codigoOriginal = jTable.getValueAt(selectedRow, 0).toString();
                String codigo1 = jTable.getValueAt(selectedRow, 1).toString();
                String selectCodigo1RTUOperador = "";
                try {
                    selectCodigo1RTUOperador = PareoCodigoDAO.selectCodigo1RTUOperador(codigoOriginal, VentanaDetalle.jLabel4.getText(), toString);
                    System.out.println("selectCodigo1RTUOperador " + selectCodigo1RTUOperador);
                    String[] split = selectCodigo1RTUOperador.split("@");
                    jTable.setValueAt(split[0], selectedRow, 3);
                    jTable.setValueAt(split[1], selectedRow, 4);
                } catch (SQLException ex) {
                    Logger.getLogger(CustomEditor8.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // center-aligned items
        jComboBox1.setRenderer(listRenderer);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox1)))
        );
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//        System.out.println("value " + value);
        String toString = value.toString();
        String[] split = toString.split("@");
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(split));

        return jPanel1;
    }
}
