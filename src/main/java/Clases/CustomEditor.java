package Clases;

import DAO.PareoCodigoDAO;
import Logica.LogicaPrincipal;
import Ventanas.VentanaDetalle;
import Ventanas.VentanaMain;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

public class CustomEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

    JPanel jPanel1;
    JTextField jTextField1;
    JButton jButton1;
    JTable tabla;

    public Object getCellEditorValue() {
        return this.jTextField1.getText();
    }

    public CustomEditor(JTable jTable, int num) {
        this.jPanel1 = new JPanel();
        this.jButton1 = new JButton();
        this.jTextField1 = new JTextField();
        this.jTextField1.setHorizontalAlignment(0);
        this.tabla = jTable;
        this.jButton1.setText("G");
        this.jButton1.addActionListener(this);
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

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton
                && JOptionPane.showConfirmDialog((Component) LogicaPrincipal.vd, "Quieres guardar los cambios?", "Quieres guardar?", 0) == 0) {
            PareoCodigo pareoCodigo;
            boolean bool;
            int selectedColumn = this.tabla.getSelectedColumn();
            int selectedRow = this.tabla.getSelectedRow();
            System.out.println("selectedRow " + selectedRow);
            System.out.println("selectedColumn " + selectedColumn);
            String codigo = this.tabla.getValueAt(selectedRow, 0).toString();
            String variasOpciones = this.jTextField1.getText();
            System.out.println("//////////////////");
            System.out.println("variasOpciones " + variasOpciones);
            System.out.println("//////////////////");
            ProductoOrdenDeCompra get = VentanaDetalle.arrPoductoOrdenDeCompra.get(selectedRow);
            switch (selectedColumn) {
                case 1:
                    pareoCodigo = new PareoCodigo();
                    pareoCodigo.setCodigoOriginal(codigo);
                    pareoCodigo.setCodigo1(variasOpciones);
                    pareoCodigo.setProveedor(VentanaMain.proveedor);
                    bool = PareoCodigoDAO.insertPareoCodigoCodigo1(pareoCodigo);
                    if (!bool) {
                        PareoCodigoDAO.updatePareoCodigoCodigo1(pareoCodigo);
                    }
                    get.setCodigo1(variasOpciones);
                    break;
                case 2:
                    pareoCodigo = new PareoCodigo();
                    pareoCodigo.setCodigoOriginal(codigo);
                    pareoCodigo.setCodigo2(variasOpciones);
                    pareoCodigo.setProveedor(VentanaMain.proveedor);
                    bool = PareoCodigoDAO.insertPareoCodigoCodigo2(pareoCodigo);
                    if (!bool) {
                        PareoCodigoDAO.updatePareoCodigoCodigo2(pareoCodigo);
                    }
                    get.setCodigo2(variasOpciones);
                    break;
                case 3:
                    pareoCodigo = new PareoCodigo();
                    pareoCodigo.setCodigoOriginal(codigo);
                    pareoCodigo.setRtu1(variasOpciones);
                    pareoCodigo.setProveedor(VentanaMain.proveedor);
                    bool = PareoCodigoDAO.insertPareoCodigoRTU1(pareoCodigo);
                    if (!bool) {
                        PareoCodigoDAO.updatePareoCodigoRTU1(pareoCodigo);
                    }
                    get.setRtu1(variasOpciones);
                    break;
                case 4:
                    pareoCodigo = new PareoCodigo();
                    pareoCodigo.setCodigoOriginal(codigo);
                    pareoCodigo.setOperador1(variasOpciones);
                    pareoCodigo.setProveedor(VentanaMain.proveedor);
                    bool = PareoCodigoDAO.insertPareoCodigoRtuFactor1(pareoCodigo);
                    if (!bool) {
                        PareoCodigoDAO.updatePareoCodigoFactor1(pareoCodigo);
                    }
                    get.setRtuFactor1(variasOpciones);
                    break;
                case 5:
                    pareoCodigo = new PareoCodigo();
                    pareoCodigo.setCodigoOriginal(codigo);
                    pareoCodigo.setRtu2(variasOpciones);
                    pareoCodigo.setProveedor(VentanaMain.proveedor);
                    bool = PareoCodigoDAO.insertPareoCodigoRTU2(pareoCodigo);
                    if (!bool) {
                        PareoCodigoDAO.updatePareoCodigoRTU2(pareoCodigo);
                    }
                    get.setRtu2(variasOpciones);
                    break;
                case 6:
                    pareoCodigo = new PareoCodigo();
                    pareoCodigo.setCodigoOriginal(codigo);
                    pareoCodigo.setOperador2(variasOpciones);
                    pareoCodigo.setProveedor(VentanaMain.proveedor);
                    bool = PareoCodigoDAO.insertPareoCodigoRtuFactor2(pareoCodigo);
                    if (!bool) {
                        PareoCodigoDAO.updatePareoCodigoFactor2(pareoCodigo);
                    }
                    get.setRtuFactor2(variasOpciones);
                    break;
            }
        }
    }
}
