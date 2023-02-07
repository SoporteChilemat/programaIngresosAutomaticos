package Logica;

import Clases.CustomEditor2;
import Clases.CustomEditor3;
import Clases.CustomEditor4;
import Clases.CustomEditor5;
import Clases.CustomEditor7;
import Clases.CustomEditor8;
import Clases.CustomEditor9;
import Clases.CustomRenderer2;
import Clases.CustomRenderer3;
import Clases.CustomRenderer4;
import Clases.CustomRenderer5;
import Clases.CustomRenderer7;
import Clases.CustomRenderer8;
import Clases.CustomRenderer9;
import Clases.Excel;
import Clases.Excel2;
import Clases.Indices;
import Clases.Ingresos;
import Clases.OrdenDeCompra;
import Clases.PareoCodigo;
import Clases.ProductoOrdenDeCompra;
import DAO.IndicesDAO;
import DAO.IngresosDAO;
import DAO.OrdenDeCompraDAO;
import DAO.PareoCodigoDAO;
import DAO.ProductoOrdenDeCompraDAO;
import Ventanas.VentanaDetalle;
import static Ventanas.VentanaDetalle.jButton1;
import Ventanas.VentanaIngresos;
import Ventanas.VentanaLogin;
import Ventanas.VentanaMain;
import static Ventanas.VentanaMain.arrOrdenDeCompra;
import static Ventanas.VentanaMain.jTabbedPane1;
import static Ventanas.VentanaMain.jTabbedPane3;
import static Ventanas.VentanaMain.numeroOC;
import static Ventanas.VentanaMain.proveedor;
import static Ventanas.VentanaMain.proveedor1;
import static Ventanas.VentanaMain.ventanaPrincipal;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import net.coderazzi.filters.gui.AutoChoices;
import net.coderazzi.filters.gui.TableFilterHeader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LogicaPrincipal {

    public static ChromeDriver driver;

    public static VentanaDetalle vd;

    public static void ingresar() throws InterruptedException, MalformedURLException, IOException, SQLException, SQLException {
        try {
            VentanaDetalle.jTable1.getCellEditor().stopCellEditing();
        } catch (Exception exception) {
        }
        try {
            VentanaDetalle.jTable2.getCellEditor().stopCellEditing();
        } catch (Exception exception) {
        }

        ArrayList<Ingresos> arrProducto = new ArrayList<>();
        ArrayList<Ingresos> arrProductoNO = new ArrayList<>();

        for (int i = 0; i < VentanaDetalle.jTable2.getRowCount(); i++) {
            boolean seleccion = ((Boolean) VentanaDetalle.jTable2.getValueAt(i, 3));

            if (seleccion) {
                String cantidad = VentanaDetalle.jTable2.getValueAt(i, 0).toString();
                System.out.println("cantidad " + cantidad);

                if (!cantidad.equals("0@0@0")) {
                    boolean codigo = ((Boolean) VentanaDetalle.jTable2.getValueAt(i, 1));
                    String local = VentanaDetalle.jTable2.getValueAt(i, 2).toString();
                    String toString = VentanaDetalle.jComboBox1.getSelectedItem().toString();

//                    if (codigo) {
//                    } else {
//                        codigoString = VentanaDetalle.jTable1.getValueAt(i, 2).toString();
//                        rtu = VentanaDetalle.jTable1.getValueAt(i, 5).toString();
//                        operador = VentanaDetalle.jTable1.getValueAt(i, 6).toString();
//                    }
                    String codigoString = VentanaDetalle.jTable1.getValueAt(i, 1).toString();
                    String rtu = VentanaDetalle.jTable1.getValueAt(i, 3).toString();
                    String operador = VentanaDetalle.jTable1.getValueAt(i, 4).toString();

                    String codigoOriginalString = VentanaDetalle.jTable1.getValueAt(i, 0).toString();
                    System.out.println("cantidad " + cantidad);
                    System.out.println("codigo " + codigo);
                    System.out.println("local " + local);
                    System.out.println("toString " + toString);
                    System.out.println("codigoString " + codigoString);
                    System.out.println("rtu " + rtu);
                    System.out.println("operador " + operador);

                    String[] split = codigoString.split("@");

                    Ingresos producto = new Ingresos();
                    producto.setCodigo(split[0]);
                    producto.setCantidad(cantidad);
                    producto.setLocal(local);
                    producto.setRtu(rtu);
                    producto.setOperador(operador);
                    producto.setCodigoOriginal(codigoOriginalString);
                    producto.setOrdenDeCompra(VentanaDetalle.jLabel2.getText());
                    arrProducto.add(producto);
                }
            } else {
                String codigoOriginalString = VentanaDetalle.jTable1.getValueAt(i, 0).toString();
                String codigoString = VentanaDetalle.jTable1.getValueAt(i, 1).toString();
                String local = VentanaDetalle.jTable2.getValueAt(i, 2).toString();
                Ingresos producto = new Ingresos();

                String[] split = codigoString.split("@");

                producto.setCodigo(split[0]);
                producto.setCantidad("0@0@0");
                producto.setLocal(local);
                producto.setCodigoOriginal(codigoOriginalString);
                producto.setOrdenDeCompra(VentanaDetalle.jLabel2.getText());
                arrProductoNO.add(producto);
            }
        }
        System.out.println("arrProducto.size() " + arrProducto.size());
        System.out.println("arrProductoNO.size() " + arrProductoNO.size());

        if (!arrProducto.isEmpty()) {
            String ordenDeCompra = ((Ingresos) arrProducto.get(0)).getOrdenDeCompra();
            Indices indices = new Indices();
            indices.setOrdenDeCompra(ordenDeCompra);
            indices.setEstado("false");
            indices.setLocal(((Ingresos) arrProducto.get(0)).getLocal());
            IndicesDAO.registraInidice(indices);
            int selectUltimoIndice = IndicesDAO.selectUltimoIndice();
            int j;
            for (j = 0; j < arrProducto.size(); j++) {
                Ingresos get = arrProducto.get(j);
                Date date = new Date();
                Timestamp ts = new Timestamp(date.getTime());
                System.out.println(ts);
                get.setFecha(ts);
                get.setUsuario(VentanaLogin.nombre);
                get.setIndice(selectUltimoIndice);
                get.setEstado("false");
                get.setTipoDocumento(VentanaDetalle.jComboBox1.getSelectedItem().toString());
                get.setNumeroDocumento(VentanaDetalle.jTextField1.getText());
                IngresosDAO.registraProductoIngresado(get);
            }
            for (j = 0; j < arrProductoNO.size(); j++) {
                Ingresos get = arrProductoNO.get(j);
                Date date = new Date();
                Timestamp ts = new Timestamp(date.getTime());
                System.out.println(ts);
                get.setFecha(ts);
                get.setUsuario(VentanaLogin.nombre);
                get.setIndice(selectUltimoIndice);
                get.setOrdenDeCompra(ordenDeCompra);
                get.setEstado("false");
                get.setTipoDocumento(VentanaDetalle.jComboBox1.getSelectedItem().toString());
                get.setNumeroDocumento(VentanaDetalle.jTextField1.getText());
                IngresosDAO.registraProductoIngresado(get);
            }
        }
    }

    public static void compruebaComboBox() {
        ArrayList<Integer> arrIndex = new ArrayList<>();
        for (int i = 0; i < VentanaDetalle.jTable2.getRowCount(); i++) {
            boolean seleccion = ((Boolean) VentanaDetalle.jTable2.getValueAt(i, 3)).booleanValue();
            String toString = VentanaDetalle.jTable2.getValueAt(i, 0).toString();
            System.out.println("toString " + toString);
            String[] split = toString.split("@");
            if (seleccion) {
                int cont = 0;
                for (int k = 0; k < split.length; k++) {
                    int parseInt = Integer.parseInt(split[k]);
                    if (parseInt > 0) {
                        cont++;
                    }
                }
                if (cont > 0) {
                    arrIndex.add(Integer.valueOf(i));
                }
            }
        }
        String text = VentanaDetalle.jTextField1.getText();
        boolean bool = false;
        try {
            int valueOf = Integer.valueOf(text).intValue();
            bool = true;
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        }
        System.out.println("bool " + bool);
        for (int j = 0; j < VentanaDetalle.jTable2.getRowCount(); j++);
        if (!VentanaDetalle.jComboBox1.getSelectedItem().toString().equals("Selecione una opcion") && !arrIndex.isEmpty()) {
            if (bool) {
                VentanaDetalle.jButton1.setEnabled(true);
            } else {
                VentanaDetalle.jButton1.setEnabled(false);
            }
        } else {
            VentanaDetalle.jButton1.setEnabled(false);
        }
    }

    public static void procedimientoPreCargar() throws SQLException {
        ArrayList<String> selectDistinctFechaA = OrdenDeCompraDAO.selectDistinctFechaA();
        AtomicInteger at = new AtomicInteger();
        selectDistinctFechaA.forEach(a -> {
            JTabbedPane jTabbedPane2 = new JTabbedPane();
            int cont = 0;
            for (int i = 1; i < 13; i++) {
                try {
                    String mes;
                    String titleMes = "";
                    if (i < 10) {
                        mes = "0" + i;
                    } else {
                        mes = "" + i;
                    }
                    switch (i) {
                        case 1:
                            titleMes = "Enero";
                            break;
                        case 2:
                            titleMes = "Febrero";
                            break;
                        case 3:
                            titleMes = "Marzo";
                            break;
                        case 4:
                            titleMes = "Abril";
                            break;
                        case 5:
                            titleMes = "Mayo";
                            break;
                        case 6:
                            titleMes = "Junio";
                            break;
                        case 7:
                            titleMes = "Julio";
                            break;
                        case 8:
                            titleMes = "Agosto";
                            break;
                        case 9:
                            titleMes = "Septiembre";
                            break;
                        case 10:
                            titleMes = "Octubre";
                            break;
                        case 11:
                            titleMes = "Noviembre";
                            break;
                        case 12:
                            titleMes = "Diciembre";
                            break;
                    }
                    ArrayList<String> selectDistinctDiaMesA = OrdenDeCompraDAO.selectDistinctDiaMesA(mes, a);
                    if (!selectDistinctDiaMesA.isEmpty()) {
                        jTabbedPane3 = new JTabbedPane();
                        for (int j = 0; j < selectDistinctDiaMesA.size(); j++) {
                            String dia = selectDistinctDiaMesA.get(j);
                            arrOrdenDeCompra = OrdenDeCompraDAO.selectFechaDiaMesA(dia, mes, a);
                            cargaTablaPrincipal(j, dia + "/" + mes + "/" + a);
                        }
                        jTabbedPane2.add(jTabbedPane3);
                        jTabbedPane2.setTitleAt(cont, titleMes);
                        System.out.println(cont + " " + titleMes);
                        cont++;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(VentanaMain.class.getName()).log(Level.SEVERE, (String) null, ex);
                }
            }
            jTabbedPane1.add(jTabbedPane2);
            jTabbedPane1.setTitleAt(at.getAndIncrement(), a);
        });
    }

    public static void cargaTablaIndex(int num) throws SQLException {
        ArrayList<Indices> selectIndices;
        new TableFilterHeader(VentanaIngresos.jTable1, AutoChoices.ENABLED);
        DefaultTableModel modelTabla1 = (DefaultTableModel) VentanaIngresos.jTable1.getModel();
        Object[] fila = new Object[7];
        if (num == 0) {
            selectIndices = IndicesDAO.selectIndices(0, "");
        } else {
            selectIndices = IndicesDAO.selectIndices(1, VentanaDetalle.jLabel2.getText());
        }
        selectIndices.stream().forEach(indice -> {
            fila[0] = Integer.valueOf(indice.getIndece());
            fila[1] = indice.getOrdenDeCompra();
            fila[2] = indice.getEstado();
            fila[3] = indice.getLocal();
            fila[4] = indice.getFolio();
            fila[5] = indice.getPdf();
            fila[6] = indice.getPdf();
            modelTabla1.addRow(fila);
        });
        ((DefaultTableCellRenderer) VentanaIngresos.jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(0);
        resizeColumnWidth(VentanaIngresos.jTable1);
        VentanaIngresos.jTable1.setRowHeight(35);
        VentanaIngresos.jTable1.setShowHorizontalLines(true);
        VentanaIngresos.jTable1.setShowVerticalLines(true);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        int columnCount = VentanaIngresos.jTable1.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            VentanaIngresos.jTable1.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
        renderer.setHorizontalAlignment(0);
        VentanaIngresos.jTable1.getColumn("PDF").setCellRenderer((TableCellRenderer) new CustomRenderer7(VentanaIngresos.jTable1, 0));
        VentanaIngresos.jTable1.getColumn("PDF").setCellEditor((TableCellEditor) new CustomEditor7(VentanaIngresos.jTable1, 0));
        VentanaIngresos.jTable1.getColumn("Anular").setCellRenderer((TableCellRenderer) new CustomRenderer7(VentanaIngresos.jTable1, 1));
        VentanaIngresos.jTable1.getColumn("Anular").setCellEditor((TableCellEditor) new CustomEditor7(VentanaIngresos.jTable1, 1));
    }

    public static void cargaTablaPrincipal(int j, String fecha) {
        JTable jTable = new JTable();
        new TableFilterHeader(jTable, AutoChoices.ENABLED);
        JScrollPane jScrollPane1 = new JScrollPane();
        jTable.setModel(new DefaultTableModel(new Object[0][], (Object[]) new String[]{"Numero OC", "Proveedor", "Fecha Generacion", "Observaciones", "Direccion Despacho", "Generado Por", "Estado", "Proveedor"}));
        DefaultTableModel modelTabla1 = (DefaultTableModel) jTable.getModel();

        Object[] fila = new Object[8];
        arrOrdenDeCompra.stream().forEach(ordenDeCompra -> {
            fila[0] = ordenDeCompra.getNumeroOC();
            String razonSocial = ordenDeCompra.getRazonSocial();
            if (razonSocial == null || razonSocial.equals("")) {
                fila[1] = ordenDeCompra.getProveedor();
            } else {
                fila[1] = ordenDeCompra.getRazonSocial();
            }
            fila[2] = ordenDeCompra.getFechaGeneracion();
            fila[3] = ordenDeCompra.getObservaciones();
            fila[4] = ordenDeCompra.getDireccionDestinoDespacho();
            fila[5] = ordenDeCompra.getGeneradoPor();
            fila[6] = ordenDeCompra.getEstado();
            fila[7] = ordenDeCompra.getProveedor();
            modelTabla1.addRow(fila);
        });

        ((DefaultTableCellRenderer) jTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(0);
        resizeColumnWidth(jTable);

        jTable.setRowHeight(35);
        jTable.setShowHorizontalLines(true);
        jTable.setShowVerticalLines(true);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        int columnCount = jTable.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            jTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
        renderer.setHorizontalAlignment(0);

        int rowCount = jTable.getRowCount();
        System.out.println("rowCount " + rowCount);

        jTable.getColumnModel().getColumn(7).setMinWidth(0);
        jTable.getColumnModel().getColumn(7).setMaxWidth(0);
        jTable.getColumnModel().getColumn(7).setWidth(0);

        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem menu = new JMenuItem("Abrir OC");
        popupMenu.addPopupMenuListener(new PopupMenuListener() {
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        Point mousePoint = new Point();
                        mousePoint = MouseInfo.getPointerInfo().getLocation();
                        int rowAtPoint = jTable.rowAtPoint(SwingUtilities.convertPoint(popupMenu, new Point(0, 0), jTable));
                        if (rowAtPoint > -1) {
                            jTable.setRowSelectionInterval(rowAtPoint, rowAtPoint);
                        }
                    }
                });
            }

            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
            }

            public void popupMenuCanceled(PopupMenuEvent e) {
            }
        });
        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = jTable.getSelectedRow();
                    numeroOC = jTable.getValueAt(selectedRow, 0).toString();
                    proveedor = jTable.getValueAt(selectedRow, 7).toString();
                    proveedor1 = jTable.getValueAt(selectedRow, 1).toString();
                    System.out.println("numeroOC " + numeroOC);
                    LogicaPrincipal.vd = new VentanaDetalle((Frame) ventanaPrincipal, true);
                    LogicaPrincipal.vd.setLocationRelativeTo((Component) ventanaPrincipal);
                    VentanaDetalle.jLabel2.setText(numeroOC);
                    VentanaDetalle.jLabel4.setText(proveedor);
                    VentanaDetalle.jLabel5.setText(proveedor1);
                    VentanaDetalle.arrPoductoOrdenDeCompra = ProductoOrdenDeCompraDAO.selectproductoOrdenDeCompraWhere(numeroOC, proveedor);
                    VentanaDetalle.arrProductosIngresados = IngresosDAO.selectProductoIngresado(numeroOC);
                    System.out.println("arrProductosIngresados.size() " + VentanaDetalle.arrProductosIngresados.size());
                    LogicaPrincipal.cargaTablaDetalle();
                    LogicaPrincipal.vd.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(LogicaPrincipal.class.getName()).log(Level.SEVERE, (String) null, ex);
                }
            }
        });
        popupMenu.add(menu);
        jTable.setComponentPopupMenu(popupMenu);
        jScrollPane1.setViewportView(jTable);
        jTabbedPane3.add(jScrollPane1);
        jTabbedPane3.setTitleAt(j, fecha);
    }

    public static void cargaTablaDetalle() {
        try {
            ((DefaultTableModel) VentanaDetalle.jTable1.getModel()).setNumRows(0);
        } catch (Exception exception) {
        }

        DefaultTableModel modelTabla1 = (DefaultTableModel) VentanaDetalle.jTable1.getModel();
        DefaultTableModel modelTabla12 = (DefaultTableModel) VentanaDetalle.jTable2.getModel();

        Object[] fila = new Object[15];
        Object[] fila2 = new Object[4];

        int[] arrPendientes = new int[VentanaDetalle.arrPoductoOrdenDeCompra.size()];
        AtomicInteger at = new AtomicInteger(0);
        VentanaDetalle.arrPoductoOrdenDeCompra.stream().forEach(poductoOrdenDeCompra -> {

            fila[0] = poductoOrdenDeCompra.getCodigoItemComprador();

            String codigoItemComprador = poductoOrdenDeCompra.getCodigoItemComprador();
            ArrayList<PareoCodigo> selectCodigo1 = null;
            String codigo1 = "";
            try {
                selectCodigo1 = PareoCodigoDAO.selectCodigo1(codigoItemComprador, VentanaDetalle.jLabel4.getText());
                for (int i = 0; i < selectCodigo1.size(); i++) {
                    PareoCodigo get = selectCodigo1.get(i);
                    codigo1 = codigo1 + "@" + get.getCodigo1();
                }
                codigo1 = codigo1.replaceFirst("@", "");
            } catch (SQLException ex) {
                Logger.getLogger(LogicaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

            fila[1] = codigo1;
            fila[2] = poductoOrdenDeCompra.getCodigo2();
            try {
                fila[3] = selectCodigo1.get(0).getRtu1();
            } catch (Exception ex) {
                fila[3] = "";
            }
            try {
                fila[4] = selectCodigo1.get(0).getOperador1();
            } catch (Exception ex) {
                fila[4] = "";
            }
            fila[5] = poductoOrdenDeCompra.getRtu2();
            fila[6] = poductoOrdenDeCompra.getRtuFactor2();
            fila[7] = poductoOrdenDeCompra.getDescripcionItem();
            fila[8] = poductoOrdenDeCompra.getUnidadMedidaItem();
            fila[9] = poductoOrdenDeCompra.getCantidadItem();

            int cantidad = 0;
            for (int i = 0; i < VentanaDetalle.arrProductosIngresados.size(); i++) {
                Ingresos producto = VentanaDetalle.arrProductosIngresados.get(i);
                String codigoOriginal = producto.getCodigoOriginal();
                String codigo = producto.getCodigo();
                String cantidad1 = producto.getCantidad();
                String local = producto.getLocal();
                String rtu = producto.getRtu();
                String operador = producto.getOperador();
                String codigoOriginal1 = producto.getCodigoOriginal();
                Timestamp fecha = producto.getFecha();
                String usuario = producto.getUsuario();
                String ordenDeCompra = producto.getOrdenDeCompra();
                codigoItemComprador = poductoOrdenDeCompra.getCodigoItemComprador();

                if (codigoOriginal.equals(codigoItemComprador)) {
                    System.out.println("---> true");
                    System.out.println(codigoOriginal);
                    System.out.println(codigoItemComprador);
                    System.out.println("codigoOriginal " + codigoOriginal);
                    System.out.println("codigo " + codigo);
                    System.out.println("cantidad1 " + cantidad1);
                    System.out.println("local " + local);
                    System.out.println("rtu " + rtu);
                    System.out.println("operador " + operador);
                    System.out.println("codigoOriginal1 " + codigoOriginal1);
                    System.out.println("fecha " + fecha);
                    System.out.println("usuario " + usuario);
                    System.out.println("ordenDeCompra " + ordenDeCompra);
                    String[] split = cantidad1.split("@");
                    if (local.equals("PB")) {
                        cantidad = cantidad + Integer.parseInt(split[0]) + Integer.parseInt(split[1]) + Integer.parseInt(split[2]);
                    } else {
                        cantidad += Integer.parseInt(split[0]);
                    }
                }
            }

            int valueOf = Integer.parseInt(poductoOrdenDeCompra.getCantidadItem());
            int pendiente = valueOf - cantidad;
            System.out.println("valueOf " + valueOf);
            System.out.println("cantidad " + cantidad);
            arrPendientes[at.getAndIncrement()] = pendiente;

            fila[11] = Integer.valueOf(pendiente);
            fila[12] = poductoOrdenDeCompra.getPrecioUnitarioBrutoItem();
            fila[13] = poductoOrdenDeCompra.getPrecioFinalItem();

            modelTabla1.addRow(fila);
            fila2[0] = "0@0@0";
            fila2[1] = Boolean.valueOf(true);
            fila2[2] = "PB";
            fila2[3] = Boolean.valueOf(false);
            modelTabla12.addRow(fila2);
        });

        ((DefaultTableCellRenderer) VentanaDetalle.jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(0);

        resizeColumnWidth(VentanaDetalle.jTable1);
        VentanaDetalle.jTable1.setRowHeight(45);
        VentanaDetalle.jTable1.setShowHorizontalLines(true);
        VentanaDetalle.jTable1.setShowVerticalLines(true);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        int columnCount = VentanaDetalle.jTable1.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            VentanaDetalle.jTable1.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }

        renderer.setHorizontalAlignment(0);
        ((DefaultTableCellRenderer) VentanaDetalle.jTable2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(0);
        resizeColumnWidth(VentanaDetalle.jTable2);

        VentanaDetalle.jTable2.setRowHeight(45);
        VentanaDetalle.jTable2.setShowHorizontalLines(true);
        VentanaDetalle.jTable2.setShowVerticalLines(true);

        renderer = new DefaultTableCellRenderer();
        columnCount = VentanaDetalle.jTable2.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            VentanaDetalle.jTable2.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
        renderer.setHorizontalAlignment(0);

        VentanaDetalle.jTable1.getColumn("Codigo 1").setCellRenderer((TableCellRenderer) new CustomRenderer8(VentanaDetalle.jTable1, 0));
        VentanaDetalle.jTable1.getColumn("Codigo 1").setCellEditor((TableCellEditor) new CustomEditor8(VentanaDetalle.jTable1, 0));

//        VentanaDetalle.jTable1.getColumn("Codigo 2").setCellRenderer((TableCellRenderer) new CustomRenderer(VentanaDetalle.jTable1, 0));
//        VentanaDetalle.jTable1.getColumn("Codigo 2").setCellEditor((TableCellEditor) new CustomEditor(VentanaDetalle.jTable1, 0));
        VentanaDetalle.jTable1.getColumn("RTU1").setCellRenderer((TableCellRenderer) new CustomRenderer9(VentanaDetalle.jTable1, 0));
        VentanaDetalle.jTable1.getColumn("RTU1").setCellEditor((TableCellEditor) new CustomEditor9(VentanaDetalle.jTable1, 0));

//        VentanaDetalle.jTable1.getColumn("RTU2").setCellRenderer((TableCellRenderer) new CustomRenderer(VentanaDetalle.jTable1, 0));
//        VentanaDetalle.jTable1.getColumn("RTU2").setCellEditor((TableCellEditor) new CustomEditor(VentanaDetalle.jTable1, 0));
        VentanaDetalle.jTable1.getColumn("Operador 1").setCellRenderer((TableCellRenderer) new CustomRenderer9(VentanaDetalle.jTable1, 0));
        VentanaDetalle.jTable1.getColumn("Operador 1").setCellEditor((TableCellEditor) new CustomEditor9(VentanaDetalle.jTable1, 0));

//        VentanaDetalle.jTable1.getColumn("Operador 2").setCellRenderer((TableCellRenderer) new CustomRenderer6(VentanaDetalle.jTable1, 0));
//        VentanaDetalle.jTable1.getColumn("Operador 2").setCellEditor((TableCellEditor) new CustomEditor6(VentanaDetalle.jTable1, 0));
        VentanaDetalle.jTable2.getColumn("Cantidad").setCellRenderer((TableCellRenderer) new CustomRenderer5(VentanaDetalle.jTable1, VentanaDetalle.jTable2, arrPendientes));
        VentanaDetalle.jTable2.getColumn("Cantidad").setCellEditor((TableCellEditor) new CustomEditor5(VentanaDetalle.jTable1, VentanaDetalle.jTable2, arrPendientes));

        VentanaDetalle.jTable2.getColumn("Codigo").setCellRenderer((TableCellRenderer) new CustomRenderer3(arrPendientes));
        VentanaDetalle.jTable2.getColumn("Codigo").setCellEditor((TableCellEditor) new CustomEditor3(arrPendientes));

        VentanaDetalle.jTable2.getColumn("Local").setCellRenderer((TableCellRenderer) new CustomRenderer2(arrPendientes));
        VentanaDetalle.jTable2.getColumn("Local").setCellEditor((TableCellEditor) new CustomEditor2(VentanaDetalle.jTable2, arrPendientes));

        VentanaDetalle.jTable2.getColumn("Seleccion").setCellRenderer((TableCellRenderer) new CustomRenderer4(arrPendientes));
        VentanaDetalle.jTable2.getColumn("Seleccion").setCellEditor((TableCellEditor) new CustomEditor4(arrPendientes));

        VentanaDetalle.jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
        VentanaDetalle.jTable1.getColumnModel().getColumn(1).setPreferredWidth(400);
        VentanaDetalle.jTable1.getColumnModel().getColumn(2).setPreferredWidth(250);
        VentanaDetalle.jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
        VentanaDetalle.jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
        VentanaDetalle.jTable1.getColumnModel().getColumn(5).setPreferredWidth(150);
        VentanaDetalle.jTable1.getColumnModel().getColumn(6).setPreferredWidth(150);
        VentanaDetalle.jTable1.getColumnModel().getColumn(10).setPreferredWidth(200);
        VentanaDetalle.jTable1.getColumnModel().getColumn(14).setPreferredWidth(100);

        VentanaDetalle.jTable2.getColumnModel().getColumn(0).setPreferredWidth(200);
        VentanaDetalle.jTable2.getColumnModel().getColumn(1).setPreferredWidth(200);
        VentanaDetalle.jTable2.getColumnModel().getColumn(2).setPreferredWidth(60);
        VentanaDetalle.jTable2.getColumnModel().getColumn(3).setPreferredWidth(40);

        VentanaDetalle.jTable1.getColumnModel().getColumn(2).setMinWidth(0);
        VentanaDetalle.jTable1.getColumnModel().getColumn(2).setMaxWidth(0);
        VentanaDetalle.jTable1.getColumnModel().getColumn(2).setWidth(0);

        VentanaDetalle.jTable1.getColumnModel().getColumn(5).setMinWidth(0);
        VentanaDetalle.jTable1.getColumnModel().getColumn(5).setMaxWidth(0);
        VentanaDetalle.jTable1.getColumnModel().getColumn(5).setWidth(0);

        VentanaDetalle.jTable1.getColumnModel().getColumn(6).setMinWidth(0);
        VentanaDetalle.jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
        VentanaDetalle.jTable1.getColumnModel().getColumn(6).setWidth(0);

        VentanaDetalle.jTable1.getColumnModel().getColumn(10).setMinWidth(0);
        VentanaDetalle.jTable1.getColumnModel().getColumn(10).setMaxWidth(0);
        VentanaDetalle.jTable1.getColumnModel().getColumn(10).setWidth(0);

        VentanaDetalle.jTable1.getColumnModel().getColumn(13).setMinWidth(0);
        VentanaDetalle.jTable1.getColumnModel().getColumn(13).setMaxWidth(0);
        VentanaDetalle.jTable1.getColumnModel().getColumn(13).setWidth(0);

        VentanaDetalle.jTable1.getColumnModel().getColumn(14).setMinWidth(0);
        VentanaDetalle.jTable1.getColumnModel().getColumn(14).setMaxWidth(0);
        VentanaDetalle.jTable1.getColumnModel().getColumn(14).setWidth(0);

        VentanaDetalle.jTable2.getColumnModel().getColumn(1).setMinWidth(0);
        VentanaDetalle.jTable2.getColumnModel().getColumn(1).setMaxWidth(0);
        VentanaDetalle.jTable2.getColumnModel().getColumn(1).setWidth(0);

        Dimension size = VentanaDetalle.jTable1.getSize();
        double height = size.getHeight();
        double width = size.getWidth();
        System.out.println("height " + height);
        System.out.println("width " + width);
        System.out.println(VentanaDetalle.jTable1.getRowHeight());
        int name = 95 + VentanaDetalle.arrPoductoOrdenDeCompra.size() * VentanaDetalle.jTable1.getRowHeight() + 66 + 39 + 23;
        if (name >= 655) {
            name = 655;
        }
        vd.setSize(new Dimension(vd.getWidth(), name));
    }

    public static void ingresaChilematModificadas(String fechaDesde, String fechaHasta) throws InterruptedException {
        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        chromePrefs.put("safebrowsing.enabled", true);
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\OrdenesDeCompra\\");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--host-resolver-rules=MAP www.google-analytics.com 127.0.0.1");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("disable-infobars");
        options.addArguments("--safebrowsing-disable-download-protection");
        options.addArguments("safebrowsing-disable-extension-blacklist");
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(options);

        WebDriverWait wait = new WebDriverWait(driver, 10L);
        String baseURL = "https://asociado.chilemat.cl/";
        String rut = "17568448-4";
        String password = "qu4tfx";
        jButton1.setText("Cargando Chilemat");
        driver.get(baseURL);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"txtRut\"]")));
        driver.findElement(By.xpath("//*[@id=\"txtRut\"]")).sendKeys(rut);
        driver.findElement(By.xpath("//*[@id=\"objInpText_strClave\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"objButton_loginUsuario\"]")).click();
        driver.get("https://asociado.chilemat.cl/clientes/michilemat/informeDeOrdenes.aspx?intIdTipoNegocio=1");

        jButton1.setText("Pegando Fechas");
        System.out.println("fechaDesde " + fechaDesde);
        System.out.println("fechaHasta " + fechaHasta);

        for (int i = 0; i < 5; i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[3]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[2]/table/tbody/tr/td/contenttemplate/table/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[1]/td[4]/span[2]")));
            String numeroOCPre = driver.findElement(By.xpath("/html/body/form/div[3]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[2]/table/tbody/tr/td/contenttemplate/table/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[1]/td[4]/span[2]")).getText();
            System.out.println("numeroOCPre " + numeroOCPre);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_objDwnList_intIdSucursalCliente\"]")));
            Select select = new Select((WebElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_objDwnList_intIdSucursalCliente\"]"))));
            select.selectByIndex(i);
            if (i == 0) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_ASPxDateEdit_fechaDesde_I\"]")));
                driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_ASPxDateEdit_fechaDesde_I\"]")).clear();
                driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_ASPxDateEdit_fechaDesde_I\"]")).sendKeys(fechaDesde);

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_ASPxDateEdit_fechaHasta_I\"]")));
                driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_ASPxDateEdit_fechaHasta_I\"]")).clear();
                driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_ASPxDateEdit_fechaHasta_I\"]")).sendKeys(fechaHasta);

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder_Centro_btnBuscar")));
                driver.findElement(By.id("ctl00_ContentPlaceHolder_Centro_btnBuscar")).click();
                driver.findElement(By.id("ctl00_ContentPlaceHolder_Centro_btnBuscar")).click();
            }
            String numeroOCPost = "";
            numeroOCPost = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_objLbl_dbltotalOrdenes\"]")).getText();
            System.out.println("numeroOCPost " + numeroOCPost);
            while (numeroOCPre.equals(numeroOCPost)) {
                numeroOCPost = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_objLbl_dbltotalOrdenes\"]")).getText();
                System.out.println("numeroOCPre " + numeroOCPre);
                System.out.println("numeroOCPost " + numeroOCPost);
            }
            int parseInt = 1;
            try {
                String cantidad = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_ASPxGridView_ordenes_tcPagerBarB\"]/table/tbody/tr/td[4]/span")).getText().replace("de", "").trim();
                System.out.println("cantidad  " + cantidad);
                parseInt = Integer.parseInt(cantidad);
            } catch (Exception ex) {
                System.out.println("No hay mas paginas...");
            }
            System.out.println("parseInt " + parseInt);
            String num = "";
            String numero = "";
            for (int t = 0; t < parseInt; t++) {
                int cont = 2;
                boolean bool = true;
                if (cont == 2) {
                    System.out.println("numero " + numero);
                    System.out.println("num " + num);
                    while (numero.equals(num)) {
                        numero = driver.findElement(By.xpath("/html/body/form/div[3]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[2]/table/tbody/tr/td/contenttemplate/table/tbody/tr[2]/td/table/tbody/tr[5]/td/div/table/tbody/tr/td/table[1]/tbody/tr[" + cont + "]/td[2]/a")).getText();
                        Thread.sleep(500L);
                    }
                    num = numero;
                    System.out.println("numero " + numero);
                    System.out.println("num " + num);
                }
                while (bool) {
                    try {
                        wait = new WebDriverWait(driver, 4L);
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[3]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[2]/table/tbody/tr/td/contenttemplate/table/tbody/tr[2]/td/table/tbody/tr[5]/td/div/table/tbody/tr/td/table[1]/tbody/tr[" + cont + "]/td[2]/a")));
                        String numeroOC = driver.findElement(By.xpath("/html/body/form/div[3]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[2]/table/tbody/tr/td/contenttemplate/table/tbody/tr[2]/td/table/tbody/tr[5]/td/div/table/tbody/tr/td/table[1]/tbody/tr[" + cont + "]/td[2]/a")).getText();
                        System.out.println("numeroOC " + numeroOC);
                        String estado = driver.findElement(By.xpath("/html/body/form/div[3]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[2]/table/tbody/tr/td/contenttemplate/table/tbody/tr[2]/td/table/tbody/tr[5]/td/div/table/tbody/tr/td/table[1]/tbody/tr[" + cont + "]/td[8]")).getText();
                        if (estado.equals("MODIFICADA")) {
                            String generadoPor = driver.findElement(By.xpath("/html/body/form/div[3]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[2]/table/tbody/tr/td/contenttemplate/table/tbody/tr[2]/td/table/tbody/tr[5]/td/div/table/tbody/tr/td/table[1]/tbody/tr[" + cont + "]/td[9]")).getText();
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[2]/table/tbody/tr/td/contenttemplate/table/tbody/tr[2]/td/table/tbody/tr[5]/td/div/table/tbody/tr/td/table[1]/tbody/tr[" + cont + "]/td[1]/center/a/img")));
                            driver.findElement(By.xpath("/html/body/form/div[3]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[2]/table/tbody/tr/td/contenttemplate/table/tbody/tr[2]/td/table/tbody/tr[5]/td/div/table/tbody/tr/td/table[1]/tbody/tr[" + cont + "]/td[1]/center/a/img"))
                                    .click();
                            File file = new File(System.getProperty("user.dir") + "\\OrdenesDeCompra\\oc_" + numeroOC + ".xml");
                            while (!file.exists()) {
                                file = new File(System.getProperty("user.dir") + "\\OrdenesDeCompra\\oc_" + numeroOC + ".xml");
                            }
                            OrdenDeCompra ordenDeCompra = new OrdenDeCompra();
                            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                            Document doc = null;
                            boolean boolx = false;
                            while (!boolx) {
                                try {
                                    doc = dBuilder.parse(file);
                                    boolx = true;
                                } catch (Exception exception) {
                                }
                            }
                            doc.getDocumentElement().normalize();
                            NodeList nList = doc.getElementsByTagName("cabecera");
                            ordenDeCompra = leerOC(nList, ordenDeCompra, generadoPor);
                            ordenDeCompra.setEstado(estado);
                            System.out.println("||||||||||||||||||||||| MODIFICADA |||||||||||||||||||||||");
                            boolean deleteProductoOC = OrdenDeCompraDAO.deleteProductoOC(ordenDeCompra.getNumeroOC());
                            System.out.println("deleteProductoOC " + deleteProductoOC);
                            boolean deleteOrdenDeCompra = OrdenDeCompraDAO.deleteOrdenDeCompra(ordenDeCompra.getNumeroOC());
                            System.out.println("deleteOrdenDeCompra " + deleteOrdenDeCompra);
                            boolean insertOrdenDeCompra = OrdenDeCompraDAO.insertOrdenDeCompra(ordenDeCompra);
                            if (insertOrdenDeCompra) {
                                nList = doc.getElementsByTagName("detalle");
                                leerProductoOC(nList, numeroOC);
                            }
                        }
                        jButton1.setText("Descargando: " + num);
                        cont++;
                        System.out.println("cont " + cont);
                        if (cont == 52) {
                            bool = false;
                        }
                    } catch (Exception ex) {
                        bool = false;
                    }
                }
                wait = new WebDriverWait(driver, 10L);
                try {
                    driver.findElement(By.xpath("/html/body/form/div[3]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[2]/table/tbody/tr/td/contenttemplate/table/tbody/tr[2]/td/table/tbody/tr[5]/td/div/table/tbody/tr/td/div[3]/table/tbody/tr/td[5]/div/div/span"))
                            .click();
                } catch (Exception exception) {
                }
                cont = 2;
            }
        }
        driver.quit();
    }

    public static void ingresaChilematTodas(String fechaDesde, String fechaHasta) throws InterruptedException {
        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        chromePrefs.put("safebrowsing.enabled", true);
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\OrdenesDeCompra\\");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--host-resolver-rules=MAP www.google-analytics.com 127.0.0.1");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("disable-infobars");
        options.addArguments("--safebrowsing-disable-download-protection");
        options.addArguments("safebrowsing-disable-extension-blacklist");
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(options);

        WebDriverWait wait = new WebDriverWait(driver, 10L);
        String baseURL = "https://asociado.chilemat.cl/";

        String rut = "17568448-4";
        String password = "qu4tfx";

        jButton1.setText("Cargando Chilemat");

        driver.get(baseURL);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"txtRut\"]")));
        driver.findElement(By.xpath("//*[@id=\"txtRut\"]")).sendKeys(rut);
        driver.findElement(By.xpath("//*[@id=\"objInpText_strClave\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"objButton_loginUsuario\"]")).click();
        driver.get("https://asociado.chilemat.cl/clientes/michilemat/informeDeOrdenes.aspx?intIdTipoNegocio=-1");

        jButton1.setText("Pegando Fechas");
        System.out.println("fechaDesde " + fechaDesde);
        System.out.println("fechaHasta " + fechaHasta);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_objLbl_dbltotalOrdenes\"]")));
        String numeroOCPre = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_objLbl_dbltotalOrdenes\"]")).getText();
        System.out.println("numeroOCPre " + numeroOCPre);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_ASPxDateEdit_fechaDesde_I\"]")));
        driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_ASPxDateEdit_fechaDesde_I\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_ASPxDateEdit_fechaDesde_I\"]")).sendKeys(fechaDesde);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_ASPxDateEdit_fechaHasta_I\"]")));
        driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_ASPxDateEdit_fechaHasta_I\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_ASPxDateEdit_fechaHasta_I\"]")).sendKeys(fechaHasta);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder_Centro_btnBuscar")));
        driver.findElement(By.id("ctl00_ContentPlaceHolder_Centro_btnBuscar")).click();
        driver.findElement(By.id("ctl00_ContentPlaceHolder_Centro_btnBuscar")).click();
        String numeroOCPost = "";
        numeroOCPost = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_objLbl_dbltotalOrdenes\"]")).getText();
        System.out.println("numeroOCPost " + numeroOCPost);

        while (numeroOCPre.equals(numeroOCPost)) {
            numeroOCPost = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_objLbl_dbltotalOrdenes\"]")).getText();
            System.out.println("numeroOCPre " + numeroOCPre);
            System.out.println("numeroOCPost " + numeroOCPost);
        }
        int parseInt = 1;
        try {
            String cantidad = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_ASPxGridView_ordenes_tcPagerBarB\"]/table/tbody/tr/td[4]/span")).getText().replace("de", "").trim();
            System.out.println("cantidad  " + cantidad);
            parseInt = Integer.parseInt(cantidad);
        } catch (Exception ex) {
            System.out.println("No hay mas paginas...");
        }
        System.out.println("parseInt " + parseInt);
        for (int i = 0; i < parseInt; i++) {
            int cont = 0;
            boolean bool = true;
            while (bool) {
                try {
                    wait = new WebDriverWait(driver, 4L);

                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_ASPxGridView_ordenes_DXDataRow" + (50 * i + cont) + "\"]/td[2]/a")));
                    String numeroOC = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_ASPxGridView_ordenes_DXDataRow" + (50 * i + cont) + "\"]/td[2]/a")).getText();
                    System.out.println("numeroOC " + numeroOC);
                    String generadoPor = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_ASPxGridView_ordenes_DXDataRow" + (50 * i + cont) + "\"]/td[8]")).getText();

                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_ASPxGridView_ordenes_tccell" + (50 * i + cont) + "_1\"]/center/a/img")));
                    driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_ASPxGridView_ordenes_tccell" + (50 * i + cont) + "_1\"]/center/a/img")).click();
                    File file = new File(System.getProperty("user.dir") + "\\OrdenesDeCompra\\oc_" + numeroOC + ".xml");
                    while (!file.exists()) {
                        file = new File(System.getProperty("user.dir") + "\\OrdenesDeCompra\\oc_" + numeroOC + ".xml");
                    }
                    OrdenDeCompra ordenDeCompra = new OrdenDeCompra();
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = null;
                    boolean boolx = false;
                    while (!boolx) {
                        try {
                            doc = dBuilder.parse(file);
                            boolx = true;
                        } catch (Exception exception) {
                        }
                    }
                    doc.getDocumentElement().normalize();
                    NodeList nList = doc.getElementsByTagName("cabecera");
                    ordenDeCompra = leerOC(nList, ordenDeCompra, generadoPor);
                    ordenDeCompra.setEstado("VIGENTE");
                    boolean insertOrdenDeCompra = OrdenDeCompraDAO.insertOrdenDeCompra(ordenDeCompra);
                    if (insertOrdenDeCompra) {
                        nList = doc.getElementsByTagName("detalle");
                        leerProductoOC(nList, numeroOC);
                    }
                    cont++;
                    System.out.println("cont " + cont);
                    if (cont == 50) {
                        bool = false;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(LogicaPrincipal.class.getName()).log(Level.SEVERE, (String) null, ex);
                    bool = false;
                }
            }
            try {
                driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder_Centro_ASPxGridView_ordenes_PagerBarB_NextButton_CD\"]/span")).click();
            } catch (Exception exception) {
            }
            cont = 0;
        }
        driver.quit();
    }

    public static void leerProductoOC(NodeList nList, String numeroOC) {
        for (int temp = 0; temp < nList.getLength(); temp++) {
            ProductoOrdenDeCompra productoOrdenDeCompra = new ProductoOrdenDeCompra();
            Node node = nList.item(temp);
            if (node.getNodeType() == 1) {
                Element eElement = (Element) node;
                String codigo_item_proveedor = eElement.getElementsByTagName("codigo_item_proveedor").item(0).getTextContent();
                productoOrdenDeCompra.setCodigoItemProveedor(codigo_item_proveedor);
                String codigo_item_comprador = eElement.getElementsByTagName("codigo_item_comprador").item(0).getTextContent();
                productoOrdenDeCompra.setCodigoItemComprador(codigo_item_comprador);
                String descripcion_item = eElement.getElementsByTagName("descripcion_item").item(0).getTextContent();
                productoOrdenDeCompra.setDescripcionItem(descripcion_item);
                String cantidad_item = eElement.getElementsByTagName("cantidad_item").item(0).getTextContent();
                productoOrdenDeCompra.setCantidadItem(cantidad_item);
                String unidad_medida_item = eElement.getElementsByTagName("unidad_medida_item").item(0).getTextContent();
                productoOrdenDeCompra.setUnidadMedidaItem(unidad_medida_item);
                String precio_unitario_bruto_item = eElement.getElementsByTagName("precio_unitario_bruto_item").item(0).getTextContent();
                productoOrdenDeCompra.setPrecioUnitarioBrutoItem(precio_unitario_bruto_item);
                String precio_final_item = eElement.getElementsByTagName("precio_final_item").item(0).getTextContent();
                productoOrdenDeCompra.setPrecioFinalItem(precio_final_item);
                String observaciones_item = eElement.getElementsByTagName("observaciones_item").item(0).getTextContent();
                productoOrdenDeCompra.setObservacionesItem(observaciones_item);
                productoOrdenDeCompra.setNumeroOC(numeroOC);
                ProductoOrdenDeCompraDAO.insertProductoOrdenDeCompra(productoOrdenDeCompra);
            }
        }
    }

    public static OrdenDeCompra leerOC(NodeList nList, OrdenDeCompra ordenDeCompra, String generadoPor) {
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == 1) {
                Element eElement = (Element) node;
                String numero_oc = eElement.getElementsByTagName("numero_oc").item(0).getTextContent();
                ordenDeCompra.setNumeroOC(numero_oc);
                String proveedor = eElement.getElementsByTagName("proveedor").item(0).getTextContent();
                ordenDeCompra.setProveedor(proveedor);
                String fecha_generacion = eElement.getElementsByTagName("fecha_generacion").item(0).getTextContent();
                ordenDeCompra.setFechaGeneracion(fecha_generacion);
                String observaciones = eElement.getElementsByTagName("observaciones").item(0).getTextContent();
                ordenDeCompra.setObservaciones(observaciones);
                String idSucursalCliente = eElement.getElementsByTagName("IdSucursalCliente").item(0).getTextContent();
                ordenDeCompra.setIdSucursalCliente(idSucursalCliente);
                String descripcion_forma_pago = eElement.getElementsByTagName("descripcion_forma_pago").item(0).getTextContent();
                ordenDeCompra.setDescripcionFormaPago(descripcion_forma_pago);
                String precio_total_oc = eElement.getElementsByTagName("precio_total_oc").item(0).getTextContent();
                ordenDeCompra.setPrecioTotal(precio_total_oc);
                String direccion_destino_despacho = eElement.getElementsByTagName("direccion_destino_despacho").item(0).getTextContent();
                ordenDeCompra.setDireccionDestinoDespacho(direccion_destino_despacho);
            }
        }
        ordenDeCompra.setGeneradoPor(generadoPor);
        return ordenDeCompra;
    }

    public static void resizeColumnWidth(JTable table) {
        TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15;
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max((comp.getPreferredSize()).width + 1, width);
            }
            width = Math.max(width, table.getColumnModel().getColumn(column).getPreferredWidth());
            if (width > 300) {
                width = 300;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    public static ArrayList<Excel> transformarExcelaArray() throws FileNotFoundException, IOException {
        InputStream ExcelFileToRead = new FileInputStream(new File(System.getProperty("user.dir") + "\\ERP_SAF2_PRODUCTOS_INGRESADOS.xlsx"));

        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
        XSSFSheet sheet = wb.getSheetAt(0);
        Row row;
        Cell cell;
        Iterator rows = sheet.rowIterator();
        rows.next();

        ArrayList<Excel> arrExcel = new ArrayList<>();

        while (rows.hasNext()) {
            Excel excel = new Excel();
            int cont = 0;
            row = (Row) rows.next();
            Iterator cells = row.cellIterator();
            while (cells.hasNext()) {
//                System.out.println(cont);
                cell = (Cell) cells.next();
                switch (cont) {
                    case 3: {
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                excel.setRut(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("1 " + String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                excel.setRut(cell.getStringCellValue());
//                                System.out.println("2 " + cell.getStringCellValue());
                            }
                        } else {
                            try {
                                excel.setRut(cell.getStringCellValue());
//                                System.out.println("3 " + cell.getStringCellValue());
                            } catch (Exception e) {
                                excel.setRut(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("4 " + String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                    }
                    case 6: {
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                excel.setCodigoOriginal(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("1 " + String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                excel.setCodigoOriginal(cell.getStringCellValue());
//                                System.out.println("2 " + cell.getStringCellValue());
                            }
                        } else {
                            try {
                                excel.setCodigoOriginal(cell.getStringCellValue());
//                                System.out.println("3 " + cell.getStringCellValue());
                            } catch (Exception e) {
                                excel.setCodigoOriginal(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("4 " + String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                    }
                    case 14: {
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                excel.setCodigo(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("1 " + String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                excel.setCodigo(cell.getStringCellValue());
//                                System.out.println("2 " + cell.getStringCellValue());
                            }
                        } else {
                            try {
                                excel.setCodigo(cell.getStringCellValue());
//                                System.out.println("3 " + cell.getStringCellValue());
                            } catch (Exception e) {
                                String valueOf = String.valueOf(cell.getNumericCellValue());
                                excel.setCodigo(valueOf);
//                                System.out.println("4 " + String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                    }
                }
                cont++;
            }
            arrExcel.add(excel);
        }

        ExcelFileToRead.close();

        return arrExcel;
    }

    public static ArrayList<Excel2> transformarExcelaArray2() throws FileNotFoundException, IOException {
        InputStream ExcelFileToRead = new FileInputStream(new File(System.getProperty("user.dir") + "\\Libro1.xlsx"));

        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
        XSSFSheet sheet = wb.getSheetAt(0);
        Row row;
        Cell cell;
        Iterator rows = sheet.rowIterator();
        rows.next();

        ArrayList<Excel2> arrExcel2 = new ArrayList<>();

        while (rows.hasNext()) {
            Excel2 excel2 = new Excel2();
            int cont = 0;
            row = (Row) rows.next();
            Iterator cells = row.cellIterator();
            while (cells.hasNext()) {
//                System.out.println(cont);
                cell = (Cell) cells.next();
                switch (cont) {
                    case 0: {
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                excel2.setRut(String.valueOf(cell.getNumericCellValue()));
                                System.out.println("1 " + String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                excel2.setRut(cell.getStringCellValue());
                                System.out.println("2 " + cell.getStringCellValue());
                            }
                        } else {
                            try {
                                excel2.setRut(cell.getStringCellValue());
                                System.out.println("3 " + cell.getStringCellValue());
                            } catch (Exception e) {
                                double numericCellValue = cell.getNumericCellValue();
                                DecimalFormat df = new DecimalFormat("#");
                                df.setMaximumFractionDigits(8);
                                System.out.println(df.format(numericCellValue));
                                excel2.setRut(df.format(numericCellValue));
                                System.out.println("4 " + String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                    }
                    case 1: {
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                excel2.setRazonSocial(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("1 " + String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                excel2.setRazonSocial(cell.getStringCellValue());
//                                System.out.println("2 " + cell.getStringCellValue());
                            }
                        } else {
                            try {
                                excel2.setRazonSocial(cell.getStringCellValue());
//                                System.out.println("3 " + cell.getStringCellValue());
                            } catch (Exception e) {
                                excel2.setRazonSocial(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("4 " + String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                    }
                }
                cont++;
            }
            arrExcel2.add(excel2);
        }

        ExcelFileToRead.close();

        return arrExcel2;
    }
}
