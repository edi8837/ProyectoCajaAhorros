/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;


import ec.edu.ups.poyectoingenieriasoftware.controlador.SocioFacade;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Socio;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
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
public class SocioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private SocioFacade socioFacade;//mando mi fachada
    private List<Socio> list = new ArrayList<>();// lista de Clientes , se usa el List por el findAll()
    private int id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String telefono;
     private String lugarDeTrabajo;
    private Date fechaN;
    private Socio socio;
    private String cedula1;

    @PostConstruct//Esto es una notacion de EJB que nos dice que
    public void init() {//este metodo init se va a ejecutar despues 
        list = socioFacade.findAll();//de que se ha creado o visualizado el JSF o el bean
    }                                  // esto se lo hace ya que puede que no se haya renderizado toda la vista y ya quiera llamar a buscar la info//lo cual puede arrojar un error  

    public String add() {
        socioFacade.create(new Socio(lugarDeTrabajo, id, cedula, nombre, apellido, correo, direccion, fechaN, telefono));
        list = socioFacade.findAll();
        this.limpiar();
        return null;
    }

    public String delete(Socio c) {
        socioFacade.remove(c);
        list = socioFacade.findAll();
        return null;
    }

    public String edit(Socio c) {
      socioFacade.edit(c);
        return null;
    }

    public String save(Socio c) {
        socioFacade.edit(c);
        list = socioFacade.findAll(); //actualizo la lista
        c.setEditable(false); //desabilita la caja
        return null;
    }

    public Socio[] getList() { //este metodo tambien se lo modifica
        return list.toArray(new Socio[0]);// Lo que necesita el JSF dentro del table es un
        //arreglo no una lista por lo que convierto de lista a arreglo
    }                                         //un arreglo de clientes 

    public void setList(List<Socio> list) {
        this.list = list;
    }

    public SocioFacade getSocioFacade() {
        return socioFacade;
    }

    public void setSocioFacade(SocioFacade socioFacade) {
        this.socioFacade = socioFacade;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getLugarDeTrabajo() {
        return lugarDeTrabajo;
    }

    public void setLugarDeTrabajo(String lugarDeTrabajo) {
        this.lugarDeTrabajo = lugarDeTrabajo;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula1() {
        return cedula1;
    }

    public void setCedula1(String cedula1) {
        this.cedula1 = cedula1;
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

    public SocioBean() {
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
    
    

    public void limpiar() {
        this.apellido = "";
        this.nombre = "";
        this.correo = "";
        this.direccion = "";
        this.fechaN = null;
        this.telefono = "";
        this.cedula="";
        this.lugarDeTrabajo="";
    }
    
    
    public  void buscarSocio(){
        
     
        System.out.println(cedula);
      
         socio = socioFacade.buscarClientePorCedula(cedula);
        
        try {
            if (socio != null) {
                System.out.println("Entra en buscar ");
               

            } else {
                System.out.println("NO EXISTE 1");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "EL Socio no Existee"));
                System.out.println("NO EXISTE 2");
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Socio  no existe"));
        }
        
        
    }
}
