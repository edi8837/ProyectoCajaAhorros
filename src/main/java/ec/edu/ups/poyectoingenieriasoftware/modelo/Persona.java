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
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 *
 * @author edwin
 */
@Entity
@Table(name = "Persona")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //esta anotacion me dice que voy a heredar esta clase con todos sus atributos y los hijos llevaran los mismos(una tabla por clase de entidad correcta)
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "cedula", nullable = false, unique = true, length = 10)
    private String cedula;
    private String nombre;
    private String apellido;
    @Column(name = "correo")
    private String correo;
    private String direccion;
    private Date fechaN;
    private String telefono;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Ahorro> ahorro;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Aportacion> aportaciom;
    @Transient
    private boolean editable;

    public Persona() {
    }

    public Persona(int id, String cedula, String nombre, String apellido, List<Ahorro> ahorro) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ahorro = ahorro;
    }

    
    
    public Persona(int id, String cedula, String nombre, String apellido, String correo, String direccion, Date fechaN, String telefono) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.fechaN = fechaN;
        this.telefono = telefono;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Date getFechaN() {
        return fechaN;
    }

    public void setFechaN(Date fechaN) {
        this.fechaN = fechaN;
    }

    public List<Ahorro> getAhorro() {
        return ahorro;
    }

    public void setAhorro(List<Ahorro> ahorro) {
        this.ahorro = ahorro;
    }

    public List<Aportacion> getAportaciom() {
        return aportaciom;
    }

    public void setAportaciom(List<Aportacion> aportaciom) {
        this.aportaciom = aportaciom;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", direccion=" + direccion + ", fechaN=" + fechaN + ", telefono=" + telefono + ", ahorro=" + ahorro + ", editable=" + editable + '}';
    } 
    

}
