/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.poyectoingenieriasoftware.controlador.ColaboradorFacade;
import ec.edu.ups.poyectoingenieriasoftware.controlador.SocioFacade;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Colaborador;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Socio;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author edwin
 */
@Named
@SessionScoped
public class ColaboradorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ColaboradorFacade colaboradorFacade;//mando mi fachada
    private List<Colaborador> list = new ArrayList<>();// lista de Clientes , se usa el List por el findAll()
    private int id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String telefono;
    private Date fechaN;
    private String rol;
    private String usuario;
    private String contracenia;

    @PostConstruct//Esto es una notacion de EJB que nos dice que
    public void init() {//este metodo init se va a ejecutar despues 
        list = colaboradorFacade.findAll();//de que se ha creado o visualizado el JSF o el bean
    }                                  // esto se lo hace ya que puede que no se haya renderizado toda la vista y ya quiera llamar a buscar la info//lo cual puede arrojar un error  

    public String add() {
        colaboradorFacade.create(new Colaborador(rol, usuario, contracenia, id, cedula, nombre, apellido, correo, direccion, fechaN, telefono));
        list = colaboradorFacade.findAll();
        this.limpiar();
        return null;
    }

    public String delete(Colaborador c) {
        colaboradorFacade.remove(c);
        list = colaboradorFacade.findAll();
        return null;
    }

    public String edit(Colaborador c) {
        colaboradorFacade.edit(c);
        return null;
    }

    public String save(Colaborador c) {
        colaboradorFacade.edit(c);
        list = colaboradorFacade.findAll(); //actualizo la lista
        c.setEditable(false); //desabilita la caja
        return null;
    }

    public Colaborador[] getList() { //este metodo tambien se lo modifica
        return list.toArray(new Colaborador[0]);// Lo que necesita el JSF dentro del table es un
        //arreglo no una lista por lo que convierto de lista a arreglo
    }                                         //un arreglo de clientes 

    public void setList(List<Colaborador> list) {
        this.list = list;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public ColaboradorFacade getColaboradorFacade() {
        return colaboradorFacade;
    }

    public void setColaboradorFacade(ColaboradorFacade colaboradorFacade) {
        this.colaboradorFacade = colaboradorFacade;
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

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getFechaN() {
        return fechaN;
    }

    public void setFechaN(Date fechaN) {
        this.fechaN = fechaN;
    }
    

    public void limpiar() {
        this.apellido = "";
        this.nombre = "";
        this.correo = "";
        this.direccion = "";
        this.fechaN = null;
        this.telefono = "";
        this.cedula = "";
        this.rol = "";
        this.usuario="";
        this.contracenia="";
    }
}
