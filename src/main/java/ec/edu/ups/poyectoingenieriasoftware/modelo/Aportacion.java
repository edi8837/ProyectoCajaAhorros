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
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ASUS_GAMING
 */
@Entity
@Table(name = "Aportacion")
public class Aportacion extends Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double valor;
    private char tipoAhorro;
    private Date fecha;
    @ManyToOne
    @JoinColumn(nullable = true)
    private Cuenta cuenta;
    @ManyToOne
    @JoinColumn(nullable = true)
    private Persona persona;

    public Aportacion() {
    }

    public Aportacion(int id, double valor, char tipoAhorro, Date fecha, Cuenta cuenta) {
        this.id = id;
        this.valor = valor;
        this.tipoAhorro = tipoAhorro;
        this.fecha = fecha;
        this.cuenta = cuenta;
    }

    public Aportacion(int id, double valor, char tipoAhorro, Date fecha, Cuenta cuenta, Persona persona) {
        this.id = id;
        this.valor = valor;
        this.tipoAhorro = tipoAhorro;
        this.fecha = fecha;
        this.cuenta = cuenta;
        this.persona = persona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public char getTipoAhorro() {
        return tipoAhorro;
    }

    public void setTipoAhorro(char tipoAhorro) {
        this.tipoAhorro = tipoAhorro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Ahorro{" + "id=" + id + ", valor=" + valor + ", tipoAhorro=" + tipoAhorro + ", fecha=" + fecha + ", cuenta=" + cuenta + ", persona=" + persona + '}';
    }

}
