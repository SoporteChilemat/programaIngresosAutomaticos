package Clases;

import Ventanas.VentanaDetalle;
import java.awt.Color;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

public class CustomRenderer implements TableCellRenderer {

    JPanel jPanel1;

    JTextField jTextField1;

    JButton jButton1;

    public CustomRenderer(JTable jTable, int num) {
        this.jPanel1 = new JPanel();
        this.jButton1 = new JButton();
        this.jTextField1 = new JTextField();
        this.jTextField1.setHorizontalAlignment(0);
        this.jButton1.setText("G");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(this.jTextField1)
                        .addGap(0, 0, 0)
                        .addComponent(this.jButton1)
                        .addGap(0, 0, 0)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(this.jButton1, -1, -1, 32767)
                                .addComponent(this.jTextField1))));
        if (num == 1) {
            this.jButton1.setVisible(false);
        }
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        try {
            ProductoOrdenDeCompra get = VentanaDetalle.arrPoductoOrdenDeCompra.get(row);
            if (column == 1) {
                String codigo = get.getCodigo1();
                if (!codigo.equals(value.toString())) {
                    this.jPanel1.setBackground(Color.red);
                } else {
                    this.jPanel1.setBackground(Color.white);
                }
            }
            if (column == 2) {
                String codigo = get.getCodigo2();
                if (!codigo.equals(value.toString())) {
                    this.jPanel1.setBackground(Color.red);
                } else {
                    this.jPanel1.setBackground(Color.white);
                }
            }
            if (column == 3) {
                String codigo = get.getRtu1();
                if (!codigo.equals(value.toString())) {
                    this.jPanel1.setBackground(Color.red);
                } else {
                    this.jPanel1.setBackground(Color.white);
                }
            }
            if (column == 5) {
                String codigo = get.getRtu2();
                if (!codigo.equals(value.toString())) {
                    this.jPanel1.setBackground(Color.red);
                } else {
                    this.jPanel1.setBackground(Color.white);
                }
            }
        } catch (Exception exception) {
        }
        this.jTextField1.setText((String) value);
        return this.jPanel1;
    }
}
