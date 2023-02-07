/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Logica.LogicaPrincipal;
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
public class CustomEditor4 extends AbstractCellEditor implements TableCellEditor, ActionListener {

    JPanel jPanel1;
    javax.swing.JCheckBox jCheckBox1;
    int[] arrPendientes;

    @Override
    public Object getCellEditorValue() {
        return jCheckBox1.isSelected();
    }

    public CustomEditor4(int[] arrPendientes) {
        jPanel1 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        this.arrPendientes = arrPendientes;

        jCheckBox1.addActionListener(this);

        jCheckBox1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        jCheckBox1.setSelected((boolean) value);

        if (arrPendientes[row] == 0) {
            jCheckBox1.setEnabled(false);
        } else {
            jCheckBox1.setEnabled(true);
        }

        return jPanel1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        stopCellEditing();
        
        LogicaPrincipal.compruebaComboBox();
    }
}
