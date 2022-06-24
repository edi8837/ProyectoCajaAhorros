/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poyectoingenieriasoftware.modelo;

import jakarta.persistence.CascadeType;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author edwin
 */
//@NamedQuery(name = "getByLevel",
  //      query = "SELECT c FROM Colaborador c WHERE c.id >= :level")
@Entity
@Table(name = "Colaborador")

public class Colaborador extends Persona implements Serializable {

    private String rol;
    private String usuario;
    private String contracenia;

    public Colaborador() {
    }

    public Colaborador(String rol, String usuario, String contracenia, int id, String cedula, String nombre, String apellido, String correo, String direccion, Date fechaN, String telefono) {
        super(id, cedula, nombre, apellido, correo, direccion, fechaN, telefono);
        this.rol = rol;
        this.usuario = usuario;
        this.contracenia = contracenia;
    }

   

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContracenia() {
        return contracenia;
    }

    public void setContracenia(String contracenia) {
        this.contracenia = contracenia;
    }

    @Override
    public String toString() {
        return "Colaborador{" + "rol=" + rol + ", usuario=" + usuario + ", contracenia=" + contracenia + '}';
    }

   

   

   
  

}
