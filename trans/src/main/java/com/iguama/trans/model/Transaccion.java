package com.iguama.trans.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity(name="TRANSACCIONES")
public class Transaccion implements Serializable {

    /** Primary key. */
    protected static final String PK = "idOrden";

    @Id
    @Column(name="ID_ORDEN", unique=true, nullable=false, precision=5)
    private Long idOrden;
    @Column(name="FECHA_CREACION", nullable=false)
    private Timestamp fechaCreacion;
    @Column(name="ID_CLIENTE", nullable=false, precision=12)
    private Long idCliente;
    @Column(name="NOMBRE_PRODUCTO", nullable=false, length=50)
    private String nombreProducto;
    @Column(name="MONTO_TOTAL", nullable=false, precision=16, scale=2)
    private BigDecimal montoTotal;
    @Column(name="MILLAS_GASTADAS", nullable=false, precision=16, scale=2)
    private BigDecimal millasGastadas;
    @Column(name="TIPO_CAMBIO", nullable=false, precision=7, scale=4)
    private Float tipoCambio;

    /** Default constructor. */
    public Transaccion() {
        super();
    }

    /**
     * Access method for idOrden.
     *
     * @return the current value of idOrden
     */
    public Long getIdOrden() {
        return idOrden;
    }

    /**
     * Setter method for idOrden.
     *
     * @param aIdOrden the new value for idOrden
     */
    public void setIdOrden(Long aIdOrden) {
        idOrden = aIdOrden;
    }

    /**
     * Access method for fechaCreacion.
     *
     * @return the current value of fechaCreacion
     */
    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Setter method for fechaCreacion.
     *
     * @param aFechaCreacion the new value for fechaCreacion
     */
    public void setFechaCreacion(Timestamp aFechaCreacion) {
        fechaCreacion = aFechaCreacion;
    }

    /**
     * Access method for idCliente.
     *
     * @return the current value of idCliente
     */
    public Long getIdCliente() {
        return idCliente;
    }

    /**
     * Setter method for idCliente.
     *
     * @param aIdCliente the new value for idCliente
     */
    public void setIdCliente(Long aIdCliente) {
        idCliente = aIdCliente;
    }

    /**
     * Access method for nombreProducto.
     *
     * @return the current value of nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * Setter method for nombreProducto.
     *
     * @param aNombreProducto the new value for nombreProducto
     */
    public void setNombreProducto(String aNombreProducto) {
        nombreProducto = aNombreProducto;
    }

    /**
     * Access method for montoTotal.
     *
     * @return the current value of montoTotal
     */
    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    /**
     * Setter method for montoTotal.
     *
     * @param aMontoTotal the new value for montoTotal
     */
    public void setMontoTotal(BigDecimal aMontoTotal) {
        montoTotal = aMontoTotal;
    }

    /**
     * Access method for millasGastadas.
     *
     * @return the current value of millasGastadas
     */
    public BigDecimal getMillasGastadas() {
        return millasGastadas;
    }
    
    /**
     * Setter method for millasGastadas.
     *
     * @param aMillasGastadas the new value for millasGastadas
     */
    public void setMillasGastadas(BigDecimal aMillasGastadas) {
        millasGastadas = aMillasGastadas;
    }

    /**
     * Access method for tipoCambio.
     *
     * @return the current value of tipoCambio
     */
    public Float getTipoCambio() {
        return tipoCambio;
    }

    /**
     * Setter method for tipoCambio.
     *
     * @param aTipoCambio the new value for tipoCambio
     */
    public void setTipoCambio(Float aTipoCambio) {
        tipoCambio = aTipoCambio;
    }

    /**
     * Compares the key for this instance with another Transaccion.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Transaccion and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Transaccion)) {
            return false;
        }
        Transaccion that = (Transaccion) other;
        Object myIdOrden = this.getIdOrden();
        Object yourIdOrden = that.getIdOrden();
        if (myIdOrden==null ? yourIdOrden!=null : !myIdOrden.equals(yourIdOrden)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Transaccion.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Transaccion)) return false;
        return this.equalKeys(other) && ((Transaccion)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        if (getIdOrden() == null) {
            i = 0;
        } else {
            i = getIdOrden().hashCode();
        }
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Transaccion |");
        sb.append(" idOrden=").append(getIdOrden());
        sb.append(" idOrden=").append(getIdOrden());
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    public String toStringFull() {
    	
    	DecimalFormat df = new DecimalFormat("#,###.00");
    	
        StringBuffer sb = new StringBuffer("");
        sb.append(getIdOrden()).append("|");
        sb.append(getFechaCreacion()).append("|");
        sb.append(getIdCliente()).append("|");
        sb.append(getNombreProducto()).append("|$");
        sb.append(df.format(getMontoTotal())).append("|Millas ");
        sb.append(df.format(getMillasGastadas())).append("|");
        sb.append(getTipoCambio());
        return sb.toString();
    }


    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("idOrden", getIdOrden());
        return ret;
    }

}
