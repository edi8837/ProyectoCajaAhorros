/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poyectoingenieriasoftware.modelo;

import jakarta.persistence.CascadeType;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Edisson
 */
//@NamedQuery(name = "getByLevel",
    //    query = "SELECT c FROM Cuenta c WHERE .id >= :level")
@Entity
@Table(name = "Cuenta")

public class Cuenta implements Serializable {
 private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   private int numero;
   private Date fechaApertura;
   private String tipoDeCuenta;
   private boolean Estado;
   private double monto;
   @ManyToOne
   @JoinColumn
   private Socio socio;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")
   private List<Ahorro> ahoroo;
   

    public Cuenta() {
    }

    public Cuenta(int id, int numero, Date fechaApertura, String tipoDeCuenta, boolean Estado,double monto, Socio socio) {
        this.id = id;
        this.numero = numero;
        this.fechaApertura = fechaApertura;
        this.monto = monto;
        this.tipoDeCuenta = tipoDeCuenta;
        this.Estado = Estado;
        this.socio = socio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public void setTipoDeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "id=" + id + ", numero=" + numero + ", fechaApertura=" + fechaApertura + ", tipoDeCuenta=" + tipoDeCuenta + ", Estado=" + Estado + ", monto=" + monto + ", socio=" + socio + ", ahoroo=" + ahoroo + '}';
    }
   


    
}
