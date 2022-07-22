/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poyectoingenieriasoftware.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Edisson
 */
@Entity
@Table(name = "Credito")
public class Credito implements Serializable {

    @Id
    private int id;
    private int num;
    private double cantidad;
    private char EstadoCredito;
    private Date fecha;

    @OneToOne
    @JoinColumn(nullable = true)
    private SolicitudCredito solicitudCredito;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Cuenta cuenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "credito")
    private List<Registro> registros;

    public Credito() {
    }

    public Credito(int id, int num, double cantidad, char EstadoCredito, Date fecha, SolicitudCredito solicitudCredito, Cuenta cuenta, List<Registro> registros) {
        this.id = id;
        this.num = num;
        this.cantidad = cantidad;
        this.EstadoCredito = EstadoCredito;
        this.fecha = fecha;
        this.solicitudCredito = solicitudCredito;
        this.cuenta = cuenta;
        this.registros = registros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public char getEstadoCredito() {
        return EstadoCredito;
    }

    public void setEstadoCredito(char EstadoCredito) {
        this.EstadoCredito = EstadoCredito;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    public SolicitudCredito getSolicitudCredito() {
        return solicitudCredito;
    }

    public void setSolicitudCredito(SolicitudCredito solicitudCredito) {
        this.solicitudCredito = solicitudCredito;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Credito{" + "id=" + id + ", num=" + num + ", cantidad=" + cantidad + ", EstadoCredito=" + EstadoCredito + ", fecha=" + fecha + ", solicitudCredito=" + solicitudCredito + ", cuenta=" + cuenta + '}';
    }

}
