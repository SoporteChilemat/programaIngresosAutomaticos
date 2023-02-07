package DAO;

import Clases.OrdenDeCompra;
import Ventanas.VentanaMain;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrdenDeCompraDAO {

    public static ArrayList<String> selectDistinctFecha() throws SQLException {
        ArrayList<String> arrFechas = new ArrayList<>();
        PreparedStatement estatuto = VentanaMain.conex.getConnection().prepareStatement("select CAST(fechaGeneracion AS date) as fecha FROM [ingresoAutomatico].[dbo].[ordenDeCompra] group by CAST(fechaGeneracion AS date) order by fecha asc");
        try {
            ResultSet res = estatuto.executeQuery();
            try {
                while (res.next()) {
                    String string = res.getString("fecha");
                    String[] split = string.split("-");
                    arrFechas.add(split[2] + "-" + split[1] + "-" + split[0]);
                }
                res.close();
                estatuto.close();
                if (res != null) {
                    res.close();
                }
            } catch (Throwable throwable) {
                if (res != null)
          try {
                    res.close();
                } catch (Throwable throwable1) {
                    throwable.addSuppressed(throwable1);
                }
                throw throwable;
            }
            if (estatuto != null) {
                estatuto.close();
            }
        } catch (Throwable throwable) {
            if (estatuto != null)
        try {
                estatuto.close();
            } catch (Throwable throwable1) {
                throwable.addSuppressed(throwable1);
            }
            throw throwable;
        }
        return arrFechas;
    }

    public static ArrayList<OrdenDeCompra> selectFechaDiaMesA(String dia, String mes, String a) throws SQLException {
        ArrayList<OrdenDeCompra> arrOrdenDeCompra = new ArrayList<>();
        PreparedStatement estatuto = VentanaMain.conex.getConnection().prepareStatement("SELECT * FROM dbo.ordenDeCompra WHERE (DAY(CAST(fechaGeneracion AS date))) = '" + dia + "' AND (MONTH(CAST(fechaGeneracion AS date))) = '" + mes + "' AND (YEAR(CAST(fechaGeneracion AS date))) = '" + a + "' order by (DAY(CAST(fechaGeneracion AS date))) asc");
        try {
            ResultSet res = estatuto.executeQuery();
            try {
                while (res.next()) {
                    OrdenDeCompra ordenDeCompra = new OrdenDeCompra();
                    ordenDeCompra.setNumeroOC(res.getString("numeroOC"));
                    ordenDeCompra.setProveedor(res.getString("proveedor"));
                    ordenDeCompra.setFechaGeneracion(res.getString("fechaGeneracion"));
                    ordenDeCompra.setObservaciones(res.getString("observaciones"));
                    ordenDeCompra.setIdSucursalCliente(res.getString("idSucursalCliente"));
                    ordenDeCompra.setDescripcionFormaPago(res.getString("descripcionFormaPago"));
                    ordenDeCompra.setPrecioTotal(res.getString("precioFinal"));
                    ordenDeCompra.setDireccionDestinoDespacho(res.getString("direccionDestinoDespacho"));
                    ordenDeCompra.setGeneradoPor(res.getString("generadoPor"));
                    ordenDeCompra.setEstado(res.getString("estado"));
                    arrOrdenDeCompra.add(ordenDeCompra);
                }
                res.close();
                estatuto.close();
                if (res != null) {
                    res.close();
                }
            } catch (Throwable throwable) {
                if (res != null)
          try {
                    res.close();
                } catch (Throwable throwable1) {
                    throwable.addSuppressed(throwable1);
                }
                throw throwable;
            }
            if (estatuto != null) {
                estatuto.close();
            }
        } catch (Throwable throwable) {
            if (estatuto != null)
        try {
                estatuto.close();
            } catch (Throwable throwable1) {
                throwable.addSuppressed(throwable1);
            }
            throw throwable;
        }
        return arrOrdenDeCompra;
    }

    public static ArrayList<String> selectDistinctFechaA() throws SQLException {
        ArrayList<String> arrFechas = new ArrayList<>();
        PreparedStatement estatuto = VentanaMain.conex.getConnection().prepareStatement("SELECT DISTINCT (YEAR(CAST(fechaGeneracion AS date))) as fecha FROM [ingresoAutomatico].[dbo].[ordenDeCompra] GROUP BY (YEAR(CAST(fechaGeneracion AS date))) ORDER BY fecha asc");
        try {
            ResultSet res = estatuto.executeQuery();
            try {
                while (res.next()) {
                    arrFechas.add(res.getString("fecha"));
                }
                res.close();
                estatuto.close();
                if (res != null) {
                    res.close();
                }
            } catch (Throwable throwable) {
                if (res != null)
          try {
                    res.close();
                } catch (Throwable throwable1) {
                    throwable.addSuppressed(throwable1);
                }
                throw throwable;
            }
            if (estatuto != null) {
                estatuto.close();
            }
        } catch (Throwable throwable) {
            if (estatuto != null)
        try {
                estatuto.close();
            } catch (Throwable throwable1) {
                throwable.addSuppressed(throwable1);
            }
            throw throwable;
        }
        return arrFechas;
    }

    public static ArrayList<String> selectDistinctDiaMesA(String mes, String a) throws SQLException {
        ArrayList<String> arrFechas = new ArrayList<>();
        PreparedStatement estatuto = VentanaMain.conex.getConnection().prepareStatement("SELECT DISTINCT (DAY(CAST(fechaGeneracion AS date))) as fecha FROM [ingresoAutomatico].[dbo].[ordenDeCompra] WHERE (MONTH(CAST(fechaGeneracion AS date))) = '" + mes + "' AND (YEAR(CAST(fechaGeneracion AS date))) = '" + a + "' GROUP BY (DAY(CAST(fechaGeneracion AS date))) order BY fecha asc");
        try {
            ResultSet res = estatuto.executeQuery();
            try {
                while (res.next()) {
                    arrFechas.add(res.getString("fecha"));
                }
                res.close();
                estatuto.close();
                if (res != null) {
                    res.close();
                }
            } catch (Throwable throwable) {
                if (res != null)
          try {
                    res.close();
                } catch (Throwable throwable1) {
                    throwable.addSuppressed(throwable1);
                }
                throw throwable;
            }
            if (estatuto != null) {
                estatuto.close();
            }
        } catch (Throwable throwable) {
            if (estatuto != null)
        try {
                estatuto.close();
            } catch (Throwable throwable1) {
                throwable.addSuppressed(throwable1);
            }
            throw throwable;
        }
        return arrFechas;
    }

    public static ArrayList<OrdenDeCompra> selectOrdenDeCompra(String fecha) throws SQLException {
        ArrayList<OrdenDeCompra> arrOrdenDeCompra = new ArrayList<>();
        PreparedStatement estatuto = VentanaMain.conex.getConnection().prepareStatement("SELECT * FROM dbo.ordenDeCompra WHERE fechaGeneracion LIKE '%" + fecha + "%'");
        try {
            ResultSet res = estatuto.executeQuery();
            try {
                while (res.next()) {
                    OrdenDeCompra ordenDeCompra = new OrdenDeCompra();
                    ordenDeCompra.setNumeroOC(res.getString("numeroOC"));
                    ordenDeCompra.setProveedor(res.getString("proveedor"));
                    ordenDeCompra.setFechaGeneracion(res.getString("fechaGeneracion"));
                    ordenDeCompra.setObservaciones(res.getString("observaciones"));
                    ordenDeCompra.setIdSucursalCliente(res.getString("idSucursalCliente"));
                    ordenDeCompra.setDescripcionFormaPago(res.getString("descripcionFormaPago"));
                    ordenDeCompra.setPrecioTotal(res.getString("precioFinal"));
                    ordenDeCompra.setDireccionDestinoDespacho(res.getString("direccionDestinoDespacho"));
                    ordenDeCompra.setGeneradoPor(res.getString("generadoPor"));
                    ordenDeCompra.setEstado(res.getString("estado"));
                    arrOrdenDeCompra.add(ordenDeCompra);
                }
                res.close();
                estatuto.close();
                if (res != null) {
                    res.close();
                }
            } catch (Throwable throwable) {
                if (res != null)
          try {
                    res.close();
                } catch (Throwable throwable1) {
                    throwable.addSuppressed(throwable1);
                }
                throw throwable;
            }
            if (estatuto != null) {
                estatuto.close();
            }
        } catch (Throwable throwable) {
            if (estatuto != null)
        try {
                estatuto.close();
            } catch (Throwable throwable1) {
                throwable.addSuppressed(throwable1);
            }
            throw throwable;
        }
        return arrOrdenDeCompra;
    }

    public static boolean insertOrdenDeCompra(OrdenDeCompra ordenDeCompra) {
        try {
            Statement estatuto = VentanaMain.conex.getConnection().createStatement();
            try {
                estatuto.executeUpdate("INSERT INTO dbo.ordenDeCompra (numeroOC, proveedor, fechaGeneracion, observaciones, idSucursalCliente, descripcionFormaPago, precioFinal, direccionDestinoDespacho, generadoPor, estado) VALUES ('" + ordenDeCompra
                        .getNumeroOC() + "', '" + ordenDeCompra
                                .getProveedor() + "', '" + ordenDeCompra
                                .getFechaGeneracion() + "', '" + ordenDeCompra
                                .getObservaciones() + "', '" + ordenDeCompra
                                .getIdSucursalCliente() + "', '" + ordenDeCompra
                                .getDescripcionFormaPago() + "', '" + ordenDeCompra
                                .getPrecioTotal() + "', '" + ordenDeCompra
                                .getDireccionDestinoDespacho() + "', '" + ordenDeCompra
                                .getGeneradoPor() + "', '" + ordenDeCompra
                                .getEstado() + "')");
                estatuto.close();
                boolean bool = true;
                if (estatuto != null) {
                    estatuto.close();
                }
                return bool;
            } catch (Throwable throwable) {
                if (estatuto != null)
          try {
                    estatuto.close();
                } catch (Throwable throwable1) {
                    throwable.addSuppressed(throwable1);
                }
                throw throwable;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean deleteProductoOC(String numeroOC) throws SQLException {
        try {
            Statement estatuto = VentanaMain.conex.getConnection().createStatement();
            try {
                estatuto.execute("DELETE from dbo.productoOrdenDeCompra WHERE numeroOC = '" + numeroOC + "'");
                estatuto.close();
                boolean bool = true;
                if (estatuto != null) {
                    estatuto.close();
                }
                return bool;
            } catch (Throwable throwable) {
                if (estatuto != null)
          try {
                    estatuto.close();
                } catch (Throwable throwable1) {
                    throwable.addSuppressed(throwable1);
                }
                throw throwable;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean deleteOrdenDeCompra(String numeroOC) throws SQLException {
        try {
            Statement estatuto = VentanaMain.conex.getConnection().createStatement();
            try {
                estatuto.execute("DELETE from dbo.ordenDeCompra WHERE numeroOC = '" + numeroOC + "'");
                estatuto.close();
                boolean bool = true;
                if (estatuto != null) {
                    estatuto.close();
                }
                return bool;
            } catch (Throwable throwable) {
                if (estatuto != null)
          try {
                    estatuto.close();
                } catch (Throwable throwable1) {
                    throwable.addSuppressed(throwable1);
                }
                throw throwable;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
