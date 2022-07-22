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

/**
 *
 * @author ASUS_GAMING
 */
@Entity
@Table(name = "Solicitud")
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private char estadoAportacion;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = true)
    private Colaborador colaborador;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = true)
    private SolicitudCredito solicitudCredito;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getEstadoAportacion() {
        return estadoAportacion;
    }

    public void setEstadoAportacion(char estadoAportacion) {
        this.estadoAportacion = estadoAportacion;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public SolicitudCredito getSolicitudCredito() {
        return solicitudCredito;
    }

    public void setSolicitudCredito(SolicitudCredito solicitudCredito) {
        this.solicitudCredito = solicitudCredito;
    }
    
    
    @Override
    public String toString() {
        return "Solicitud{" + "id=" + id + ", estadoAportacion=" + estadoAportacion + ", colaborador=" + colaborador + '}';
    }

    

}