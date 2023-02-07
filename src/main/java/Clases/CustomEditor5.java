package Clases;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class CustomEditor5 extends AbstractCellEditor implements TableCellEditor, ActionListener {

    JComboBox<String> jComboBox1;

    JComboBox<String> jComboBox2;

    JComboBox<String> jComboBox3;

    JLabel jLabel1;

    JLabel jLabel2;

    JLabel jLabel3;

    JPanel jPanel1;

    JPanel jPanel2;

    JPanel jPanel3;

    JPanel jPanel4;

    JTable jTable1;

    JTable jTable2;

    int[] arrPendientes;

    public Object getCellEditorValue() {
        return this.jComboBox1.getSelectedItem() + "@" + this.jComboBox2.getSelectedItem() + "@" + this.jComboBox3.getSelectedItem();
    }

    public CustomEditor5(JTable jTable1, JTable jTable2, int[] arrPendientes) {
        this.jPanel1 = new JPanel();
        this.jPanel2 = new JPanel();
        this.jComboBox1 = new JComboBox<>();
        this.jLabel1 = new JLabel();
        this.jPanel3 = new JPanel();
        this.jComboBox2 = new JComboBox<>();
        this.jLabel2 = new JLabel();
        this.jPanel4 = new JPanel();
        this.jComboBox3 = new JComboBox<>();
        this.jLabel3 = new JLabel();
        this.jTable1 = jTable1;
        this.jTable2 = jTable2;
        this.arrPendientes = arrPendientes;
        this.jComboBox1.addActionListener(this);
        this.jComboBox2.addActionListener(this);
        this.jComboBox3.addActionListener(this);
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("PB");
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(this.jLabel1, -1, -1, 32767)
                                .addComponent(this.jComboBox1, 0, 0, 32767))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(this.jLabel1, -1, -1, 32767)
                        .addGap(0, 0, 0)
                        .addComponent(this.jComboBox1)
                        .addGap(0, 0, 0)));
        this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("CD");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(this.jLabel2, -1, -1, 32767)
                                .addComponent(this.jComboBox2, 0, 0, 32767))));
        jPanel3Layout.setVerticalGroup(jPanel3Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(this.jLabel2, -1, -1, 32767)
                        .addGap(0, 0, 0)
                        .addComponent(this.jComboBox2)
                        .addGap(0, 0, 0)));
        this.jPanel4.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel3.setHorizontalAlignment(0);
        this.jLabel3.setText("LS");
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(this.jLabel3, -1, -1, 32767)
                                .addComponent(this.jComboBox3, 0, 0, 32767))));
        jPanel4Layout.setVerticalGroup(jPanel4Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(this.jLabel3, -1, -1, 32767)
                        .addGap(0, 0, 0)
                        .addComponent(this.jComboBox3)
                        .addGap(0, 0, 0)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(this.jPanel2, -1, -1, 32767)
                        .addGap(0, 0, 0)
                        .addComponent(this.jPanel3, -1, -1, 32767)
                        .addGap(0, 0, 0)
                        .addComponent(this.jPanel4, -1, -1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(this.jPanel3, GroupLayout.Alignment.LEADING, -1, -1, 32767)
                                .addComponent(this.jPanel4, GroupLayout.Alignment.LEADING, -1, -1, 32767)
                                .addComponent(this.jPanel2, -1, -1, 32767))));
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        int cantidad = Integer.parseInt(this.jTable1.getValueAt(row, 11).toString());
        System.out.println("---> " + cantidad);
        String[] name = new String[cantidad + 1];
        name[0] = "0";
        for (int i = 1; i < name.length; i++) {
            name[i] = "" + i;
        }
        System.out.println("value " + value);
        String[] split = value.toString().split("@");
        this.jComboBox1.setModel(new DefaultComboBoxModel<>(name));
        try {
            this.jComboBox1.setSelectedItem(split[0]);
        } catch (Exception exception) {
        }
        this.jComboBox2.setModel(new DefaultComboBoxModel<>(name));
        try {
            this.jComboBox2.setSelectedItem(split[1]);
        } catch (Exception exception) {
        }
        this.jComboBox3.setModel(new DefaultComboBoxModel<>(name));
        try {
            this.jComboBox3.setSelectedItem(split[2]);
        } catch (Exception exception) {
        }
        String toString = this.jTable2.getValueAt(row, 2).toString();
        if (toString.equals("PB")) {
            this.jLabel1.setText("PB");
            this.jPanel4.setVisible(true);
            this.jPanel3.setVisible(true);
        } else if (toString.equals("VA")) {
            this.jLabel1.setText("VA");
            this.jPanel4.setVisible(false);
            this.jPanel3.setVisible(false);
        } else if (toString.equals("OL")) {
            this.jLabel1.setText("OL");
            this.jPanel4.setVisible(false);
            this.jPanel3.setVisible(false);
        }
        if (this.arrPendientes[row] == 0) {
            this.jComboBox1.setEnabled(false);
            this.jComboBox2.setEnabled(false);
            this.jComboBox3.setEnabled(false);
        } else {
            this.jComboBox1.setEnabled(true);
            this.jComboBox2.setEnabled(true);
            this.jComboBox3.setEnabled(true);
        }
        return this.jPanel1;
    }

    public void actionPerformed(ActionEvent e) {
        stopCellEditing();
    }
}
