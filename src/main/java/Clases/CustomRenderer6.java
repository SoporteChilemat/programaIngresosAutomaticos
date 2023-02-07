/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import static Ventanas.VentanaDetalle.arrPoductoOrdenDeCompra;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author sopor
 */
public class CustomRenderer6 implements TableCellRenderer {

    javax.swing.JButton jButton1;
    javax.swing.JComboBox<String> jComboBox1;
    javax.swing.JPanel jPanel1;
    JTable jTable;

    public CustomRenderer6(JTable jTable, int num) {
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        this.jTable = jTable;

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"*", "/", "+", "-"}));

        jButton1.setText("G");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox1))
                                .addGap(0, 0, 0))
        );

        if (num == 1) {
            jButton1.setVisible(false);
        }
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        try {
            ProductoOrdenDeCompra get = arrPoductoOrdenDeCompra.get(row);

            if (column == 4) {
                String codigo = get.getRtuFactor1();

                if (!codigo.equals(value.toString())) {
                    jPanel1.setBackground(Color.red);
                } else {
                    jPanel1.setBackground(Color.white);
                }
            }
            if (column == 6) {
                String codigo = get.getRtuFactor2();

                if (!codigo.equals(value.toString())) {
                    jPanel1.setBackground(Color.red);
                } else {
                    jPanel1.setBackground(Color.white);
                }
            }
        } catch (Exception ex) {

        }
        
        try {
            jComboBox1.setSelectedItem(value.toString());
        } catch (Exception ex) {
            jComboBox1.setSelectedIndex(0);
        }

        return jPanel1;
    }
}
