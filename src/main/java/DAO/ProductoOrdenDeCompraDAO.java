package DAO;

import Clases.ProductoOrdenDeCompra;
import Ventanas.VentanaMain;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductoOrdenDeCompraDAO {

    public static ArrayList<ProductoOrdenDeCompra> selectproductoOrdenDeCompraWhere(String numeroOC, String proveedor) throws SQLException {
        ArrayList<ProductoOrdenDeCompra> arrProductoOrdenDeCompra = new ArrayList<>();
        PreparedStatement estatuto = VentanaMain.conex.getConnection().prepareStatement("SELECT * FROM (SELECT codigoItemProveedor,codigoItemComprador,descripcionItem,cantidadItem,unidadMedidaItem,precioUnitarioBrutoItem,precioFinalItem,observacionesItem,a.numeroOC,cantidadEntregada, b.proveedor from dbo.productoOrdenDeCompra AS a INNER JOIN dbo.ordenDeCompra AS b on a.numeroOC = b.numeroOC) as c LEFT JOIN dbo.pareoCodigo AS d on c.codigoItemProveedor = d.codigoOriginal where c.proveedor = '" + proveedor + "' and c.numeroOC = '" + numeroOC + "'");
        try {
            ResultSet res = estatuto.executeQuery();
            try {
                while (res.next()) {
                    ProductoOrdenDeCompra productoOrdenDeCompra = new ProductoOrdenDeCompra();
                    productoOrdenDeCompra.setCodigoItemProveedor(res.getString("codigoItemProveedor"));
                    productoOrdenDeCompra.setCodigoItemComprador(res.getString("codigoItemComprador"));
                    productoOrdenDeCompra.setDescripcionItem(res.getString("descripcionItem"));
                    productoOrdenDeCompra.setCantidadItem(res.getString("cantidadItem"));
                    productoOrdenDeCompra.setUnidadMedidaItem(res.getString("unidadMedidaItem"));
                    productoOrdenDeCompra.setPrecioUnitarioBrutoItem(res.getString("precioUnitarioBrutoItem"));
                    productoOrdenDeCompra.setPrecioFinalItem(res.getString("precioFinalItem"));
                    productoOrdenDeCompra.setObservacionesItem(res.getString("observacionesItem"));
                    productoOrdenDeCompra.setNumeroOC(res.getString("numeroOC"));
                    productoOrdenDeCompra.setCodigoOriginal(res.getString("codigoOriginal"));
                    productoOrdenDeCompra.setCodigo1(res.getString("codigo1"));
                    productoOrdenDeCompra.setCodigo2(res.getString("codigo2"));
                    productoOrdenDeCompra.setRtu1(res.getString("rtu1"));
                    productoOrdenDeCompra.setRtuFactor1(res.getString("rtuFactor1"));
                    productoOrdenDeCompra.setRtu2(res.getString("rtu2"));
                    productoOrdenDeCompra.setRtuFactor2(res.getString("rtuFactor2"));
                    arrProductoOrdenDeCompra.add(productoOrdenDeCompra);
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
        if (arrProductoOrdenDeCompra.isEmpty()) {
            estatuto = VentanaMain.conex.getConnection().prepareStatement("SELECT * FROM dbo.productoOrdenDeCompra WHERE numeroOC = '" + numeroOC + "'");
            try {
                ResultSet res = estatuto.executeQuery();
                try {
                    while (res.next()) {
                        ProductoOrdenDeCompra productoOrdenDeCompra = new ProductoOrdenDeCompra();
                        productoOrdenDeCompra.setCodigoItemProveedor(res.getString("codigoItemProveedor"));
                        productoOrdenDeCompra.setCodigoItemComprador(res.getString("codigoItemComprador"));
                        productoOrdenDeCompra.setDescripcionItem(res.getString("descripcionItem"));
                        productoOrdenDeCompra.setCantidadItem(res.getString("cantidadItem"));
                        productoOrdenDeCompra.setUnidadMedidaItem(res.getString("unidadMedidaItem"));
                        productoOrdenDeCompra.setPrecioUnitarioBrutoItem(res.getString("precioUnitarioBrutoItem"));
                        productoOrdenDeCompra.setPrecioFinalItem(res.getString("precioFinalItem"));
                        productoOrdenDeCompra.setObservacionesItem(res.getString("observacionesItem"));
                        productoOrdenDeCompra.setNumeroOC(res.getString("numeroOC"));
                        arrProductoOrdenDeCompra.add(productoOrdenDeCompra);
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
        }
        return arrProductoOrdenDeCompra;
    }

    public static void insertProductoOrdenDeCompra(ProductoOrdenDeCompra productoOrdenDeCompra) {
        try {
            Statement estatuto = VentanaMain.conex.getConnection().createStatement();
            try {
                estatuto.executeUpdate("INSERT INTO dbo.productoOrdenDeCompra (codigoItemProveedor, codigoItemComprador, descripcionItem, cantidadItem, unidadMedidaItem, precioUnitarioBrutoItem, precioFinalItem, observacionesItem, numeroOC) VALUES ('" + productoOrdenDeCompra
                        .getCodigoItemProveedor() + "', '" + productoOrdenDeCompra
                                .getCodigoItemComprador() + "', '" + productoOrdenDeCompra
                                .getDescripcionItem().replace("'", "") + "', '" + productoOrdenDeCompra
                        .getCantidadItem() + "', '" + productoOrdenDeCompra
                                .getUnidadMedidaItem() + "', '" + productoOrdenDeCompra
                                .getPrecioUnitarioBrutoItem() + "', '" + productoOrdenDeCompra
                                .getPrecioFinalItem() + "', '" + productoOrdenDeCompra
                                .getObservacionesItem() + "', '" + productoOrdenDeCompra
                                .getNumeroOC() + "')");
                estatuto.close();
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
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
