/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.poyectoingenieriasoftware.controlador.CuentaFacade;
import ec.edu.ups.poyectoingenieriasoftware.controlador.SocioFacade;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Cuenta;
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
public class CuentaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private CuentaFacade cuentaFacade;//mando mi fachada
    private List<Cuenta> list = new ArrayList<>();// lista de Clientes , se usa el List por el findAll()
    private int id;
    private int numero;
    private Date fechaApertura;
    private String tipoDeCuenta;
    private boolean Estado;
    private Socio Socio;

    @PostConstruct//Esto es una notacion de EJB que nos dice que
    public void init() {//este metodo init se va a ejecutar despues 
        list = cuentaFacade.findAll();//de que se ha creado o visualizado el JSF o el bean
    }                                  // esto se lo hace ya que puede que no se haya renderizado toda la vista y ya quiera llamar a buscar la info//lo cual puede arrojar un error  

    public void generarDatos(){
     numero=(int)Math.random()*1000;
    fechaApertura=new Date();
    
    }
    public String add() {


    cuentaFacade.create (
            
    new Cuenta(id, numero, fechaApertura, tipoDeCuenta, Estado, Socio));
        list  = cuentaFacade.findAll();

    //this.limpiar();

return null;
    }

    public String delete(Cuenta c) {
        cuentaFacade.remove(c);
        list = cuentaFacade.findAll();
        return null;
    }

    public String edit(Cuenta c) {
        cuentaFacade.edit(c);
        return null;
    }

    public String save(Cuenta c) {
        cuentaFacade.edit(c);
        list = cuentaFacade.findAll(); //actualizo la lista
        //c.setEditable(false); //desabilita la caja
        return null;
    }

    public Cuenta[] getList() { //este metodo tambien se lo modifica
        return list.toArray(new Cuenta[0]);// Lo que necesita el JSF dentro del table es un
        //arreglo no una lista por lo que convierto de lista a arreglo
    }                                         //un arreglo de clientes 

}
