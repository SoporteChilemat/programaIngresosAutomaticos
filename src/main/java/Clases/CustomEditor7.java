package Clases;

import DAO.IndicesDAO;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class CustomEditor7 extends AbstractCellEditor implements TableCellEditor, ActionListener {

    JButton jButton1;

    JPanel jPanel1;

    JTable jTable;

    byte[] name;

    int num;

    public Object getCellEditorValue() {
        return this.name;
    }

    public CustomEditor7(JTable jTable, int num) {
        this.jPanel1 = new JPanel();
        this.jButton1 = new JButton();
        this.jTable = jTable;
        this.num = num;
        if (num == 0) {
            this.jButton1.setText("PDF");
        } else {
            this.jButton1.setText("ANULAR");
        }
        this.jButton1.addActionListener(this);
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

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.name = (byte[]) value;
        if (this.name == null) {
            this.jButton1.setEnabled(false);
        } else if (this.name.length > 0) {
            this.jButton1.setEnabled(true);
        } else {
            this.jButton1.setEnabled(false);
        }
        return this.jPanel1;
    }

    public void actionPerformed(ActionEvent e) {
        int selectedRow = this.jTable.getSelectedRow();
        String indice = this.jTable.getValueAt(selectedRow, 0).toString();
        stopCellEditing();
        if (this.num == 0) {
            try {
                OutputStream out = new FileOutputStream("out.pdf");
                try {
                    out.write(this.name);
                    File file = new File("out.pdf");
                    Desktop desktop = Desktop.getDesktop();
                    if (file.exists()) {
                        desktop.open(file);
                    }
                    out.close();
                } catch (Throwable throwable) {
                    try {
                        out.close();
                    } catch (Throwable throwable1) {
                        throwable.addSuppressed(throwable1);
                    }
                    throw throwable;
                }
            } catch (IOException ex) {
                Logger.getLogger(CustomEditor7.class.getName()).log(Level.SEVERE, (String) null, ex);
            }
        } else {
            IndicesDAO.updateIndiceEstado(indice, "anular");
        }
    }
}
