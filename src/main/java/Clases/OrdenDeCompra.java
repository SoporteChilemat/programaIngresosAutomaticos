package Clases;

public class OrdenDeCompra {

    String numeroOC;

    String proveedor;

    String fechaGeneracion;

    String observaciones;

    String idSucursalCliente;

    String descripcionFormaPago;

    String precioTotal;

    String direccionDestinoDespacho;

    String generadoPor;

    String estado;

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumeroOC() {
        return this.numeroOC;
    }

    public void setNumeroOC(String numeroOC) {
        this.numeroOC = numeroOC;
    }

    public String getProveedor() {
        return this.proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getFechaGeneracion() {
        return this.fechaGeneracion;
    }

    public void setFechaGeneracion(String fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getObservaciones() {
        return this.observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getIdSucursalCliente() {
        return this.idSucursalCliente;
    }

    public void setIdSucursalCliente(String idSucursalCliente) {
        this.idSucursalCliente = idSucursalCliente;
    }

    public String getDescripcionFormaPago() {
        return this.descripcionFormaPago;
    }

    public void setDescripcionFormaPago(String descripcionFormaPago) {
        this.descripcionFormaPago = descripcionFormaPago;
    }

    public String getPrecioTotal() {
        return this.precioTotal;
    }

    public void setPrecioTotal(String precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getDireccionDestinoDespacho() {
        return this.direccionDestinoDespacho;
    }

    public void setDireccionDestinoDespacho(String direccionDestinoDespacho) {
        this.direccionDestinoDespacho = direccionDestinoDespacho;
    }

    public String getGeneradoPor() {
        return this.generadoPor;
    }

    public void setGeneradoPor(String generadoPor) {
        this.generadoPor = generadoPor;
    }
}
