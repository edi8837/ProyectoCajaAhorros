/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poyectoingenieriasoftware.modelo;

import jakarta.persistence.CascadeType;
import java.io.Serializable;
import jakarta.persistence.Entity;
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
 * @author edwin
 */

@Entity
@Table(name = "Socio")

public class Socio extends Persona implements Serializable {

    private String lugarTrabajo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socio")
    private List<Cuenta> cuentas;

    public Socio() {
    }

    public Socio(String lugarTrabajo, int id, String cedula, String nombre, String apellido, String correo, String direccion, Date fechaN, String telefono) {
        super(id, cedula, nombre, apellido, correo, direccion, fechaN, telefono);
        this.lugarTrabajo = lugarTrabajo;
    }


    

   

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    @Override
    public String toString() {
        return "Socio{" + "lugarTrabajo=" + lugarTrabajo + '}';
    }

}
