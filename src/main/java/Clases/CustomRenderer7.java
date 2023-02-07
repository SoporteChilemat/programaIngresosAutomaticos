package Clases;

import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CustomRenderer7 implements TableCellRenderer {

    JPanel jPanel1 = new JPanel();

    JButton jButton1 = new JButton();

    public CustomRenderer7(JTable jTable, int num) {
        if (num == 0) {
            this.jButton1.setText("PDF");
        } else {
            this.jButton1.setText("ANULAR");
        }
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(this.jButton1, -1, -1, 32767)
                        .addGap(0, 0, 0)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(this.jButton1, -1, -1, 32767)
                        .addGap(0, 0, 0)));
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value == null) {
            this.jButton1.setEnabled(false);
        } else {
            this.jButton1.setEnabled(true);
        }
        return this.jPanel1;
    }
}