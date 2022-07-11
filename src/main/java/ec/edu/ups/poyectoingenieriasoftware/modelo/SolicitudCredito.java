/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poyectoingenieriasoftware.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASUS_GAMING
 */
@Entity
@Table(name = "SolicitudCredito")
public class SolicitudCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double cantidad;
    private Date fechaEmicion;
    private String motivo;
    private String lugarTrabajo;
    private double ingresoMensual;
    private Socio socio;
    private Cuenta cuenta;
    @OneToMany(mappedBy = "solicitudCredito", cascade = CascadeType.ALL)
    private List<Solicitud> solicitud;

    public SolicitudCredito() {
    }

    public SolicitudCredito(int id, double cantidad, Date fechaEmicion, String motivo, String lugarTrabajo, double ingresoMensual, Socio socio, Cuenta cuenta, List<Solicitud> solicitud) {
        this.id = id;
        this.cantidad = cantidad;
        this.fechaEmicion = fechaEmicion;
        this.motivo = motivo;
        this.lugarTrabajo = lugarTrabajo;
        this.ingresoMensual = ingresoMensual;
        this.socio = socio;
        this.cuenta = cuenta;
        this.solicitud = solicitud;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaEmicion() {
        return fechaEmicion;
    }

    public void setFechaEmicion(Date fechaEmicion) {
        this.fechaEmicion = fechaEmicion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public double getIngresoMensual() {
        return ingresoMensual;
    }

    public void setIngresoMensual(double ingresoMensual) {
        this.ingresoMensual = ingresoMensual;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public List<Solicitud> getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(List<Solicitud> solicitud) {
        this.solicitud = solicitud;
    }

    @Override
    public String toString() {
        return "SolicitudCredito{" + "id=" + id + ", cantidad=" + cantidad + ", fechaEmicion=" + fechaEmicion + ", motivo=" + motivo + ", lugarTrabajo=" + lugarTrabajo + ", ingresoMensual=" + ingresoMensual + ", socio=" + socio + ", cuenta=" + cuenta + ", solicitud=" + solicitud + '}';
    }
    
    
}
