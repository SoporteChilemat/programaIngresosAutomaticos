/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author sopor
 */
public class CustomEditor2 extends AbstractCellEditor implements TableCellEditor, ActionListener {

    JPanel jPanel1;
    javax.swing.JComboBox<String> jComboBox1;
    JTable jTable;
    int[] arrPendientes;

    @Override
    public Object getCellEditorValue() {
        return jComboBox1.getSelectedItem();
    }

    public CustomEditor2(JTable jTable, int[] arrPendientes) {
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        this.jTable = jTable;
        this.arrPendientes = arrPendientes;

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"PB", "VA", "OL"}));

        jComboBox1.addActionListener(this);

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

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        jComboBox1.setSelectedItem(value);

        if (arrPendientes[row] == 0) {
            jComboBox1.setEnabled(false);
        } else {
            jComboBox1.setEnabled(true);
        }

        return jPanel1;
    }

    public void actionPerformed(ActionEvent e) {
        String toString = jComboBox1.getSelectedItem().toString();
        System.out.println("toString " + toString);

        if (toString.equals("VA")) {
            for (int i = 0; i < jTable.getRowCount(); i++) {
                jTable.setValueAt("VA", i, 2);
            }
        } else if (toString.equals("OL")) {
            for (int i = 0; i < jTable.getRowCount(); i++) {
                jTable.setValueAt("OL", i, 2);
            }
        } else if (toString.equals("PB")) {
            for (int i = 0; i < jTable.getRowCount(); i++) {
                jTable.setValueAt("PB", i, 2);
            }
        }

        stopCellEditing();
    }
}
