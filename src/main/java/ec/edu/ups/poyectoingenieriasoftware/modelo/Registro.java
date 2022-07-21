/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poyectoingenieriasoftware.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ASUS_GAMING
 */
@Entity
@Table(name = "Registro")
public class Registro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double cotaCapital;
    private double interes;
    private double amortizacion;
    private Date fecha;
    private double saldo;
    private String estado;

    @OneToOne
    @JoinColumn(nullable = true)
    private Credito credito;

    public Registro() {
    }

    public Registro(int id, double cotaCapital, double interes, double amortizacion, Date fecha, double saldo, String estado, Credito credito) {
        this.id = id;
        this.cotaCapital = cotaCapital;
        this.interes = interes;
        this.amortizacion = amortizacion;
        this.fecha = fecha;
        this.saldo = saldo;
        this.estado = estado;
        this.credito = credito;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCotaCapital() {
        return cotaCapital;
    }

    public void setCotaCapital(double cotaCapital) {
        this.cotaCapital = cotaCapital;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getAmortizacion() {
        return amortizacion;
    }

    public void setAmortizacion(double amortizacion) {
        this.amortizacion = amortizacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Credito getCredito() {
        return credito;
    }

    public void setCredito(Credito credito) {
        this.credito = credito;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Registro{" + "id=" + id + ", cotaCapital=" + cotaCapital + ", interes=" + interes + ", amortizacion=" + amortizacion + ", fecha=" + fecha + ", saldo=" + saldo + ", estado=" + estado + ", credito=" + credito + '}';
    }

   
    
    

}
