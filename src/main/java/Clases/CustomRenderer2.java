/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author sopor
 */
public class CustomRenderer2 implements TableCellRenderer {

    JPanel jPanel1;
    javax.swing.JComboBox<String> jComboBox1;
    int[] arrPendientes;

    public CustomRenderer2(int[] arrPendientes) {
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        this.arrPendientes = arrPendientes;
        
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"PB", "VA", "OL"}));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        jComboBox1.setSelectedItem(value);

        if (arrPendientes[row] == 0) {
            jComboBox1.setEnabled(false);
        } else {
            jComboBox1.setEnabled(true);
        }

        return jPanel1;
    }
}
