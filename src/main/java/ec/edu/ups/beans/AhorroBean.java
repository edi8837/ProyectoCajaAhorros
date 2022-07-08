/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.poyectoingenieriasoftware.controlador.AhorroFacade;
import ec.edu.ups.poyectoingenieriasoftware.controlador.CuentaFacade;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Ahorro;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Cuenta;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Persona;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASUS_GAMING
 */
@Named
@SessionScoped
public class AhorroBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @EJB
    private CuentaFacade cuentaFacade;
    @EJB
    private AhorroFacade ahorroFacade;
    private List<Ahorro> list = new ArrayList<>();
    private List<Cuenta> listaCuenta = new ArrayList<>();
    private int id;
    private double valor;
    private char tipoAhorro;
    private Date fecha;
    private Ahorro ahorro;
    private Cuenta cuenta;
    private Persona persona;
    private int numero;
    private String mensaje;
    private String cedula;
    private String nombre;
    private String apellido;
    private int numeroCuenta;

    @PostConstruct//Esto es una notacion de EJB que nos dice que
    public void init() {//este metodo init se va a ejecutar despues 
        list = ahorroFacade.findAll();//de que se ha creado o visualizado el JSF o el bean
        listaCuenta = cuentaFacade.findAll();
    }

    public String delete(Ahorro a) {
        ahorroFacade.remove(a);
        list = ahorroFacade.findAll();
        return null;
    }

    public void Limpiar() {
        this.valor = 0.00;
        this.fecha = null;
        this.cuenta = null;
        this.persona = null;
    }

    public String edit(Ahorro a) {
        ahorroFacade.edit(a);
        list = ahorroFacade.findAll();
        return null;
    }

    public CuentaFacade getCuentaFacade() {
        return cuentaFacade;
    }

    public void setCuentaFacade(CuentaFacade cuentaFacade) {
        this.cuentaFacade = cuentaFacade;
    }

    public AhorroFacade getAhorroFacade() {
        return ahorroFacade;
    }

    public void setAhorroFacade(AhorroFacade ahorroFacade) {
        this.ahorroFacade = ahorroFacade;
    }

    public List<Ahorro> getList() {
        return list;
    }

    public void setList(List<Ahorro> list) {
        this.list = list;
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

    public Ahorro getAhorro() {
        return ahorro;
    }

    public void setAhorro(Ahorro ahorro) {
        this.ahorro = ahorro;
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

    public List<Cuenta> getListaCuenta() {
        return listaCuenta;
    }

    public void setListaCuenta(List<Cuenta> listaCuenta) {
        this.listaCuenta = listaCuenta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
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
    
    public String cuentaBusqueda() {
        mensaje = "";
        System.out.println(numero);
        for (Cuenta cuenta : listaCuenta) {
            System.out.println("Entro");
            if (numero == cuenta.getNumero()) {
                System.out.println("Cuenta Encontrada");
                mensaje = "Cuenta Encontrada";
                numeroCuenta = cuenta.getNumero();
                this.cuenta = cuenta;
            }
        }
        return null;
    }

    public String add() {
        ahorro = new Ahorro();
        ahorro.setValor(valor);
        ahorro.setTipoAhorro('D');
        ahorro.setFecha(new Date());
        ahorro.setCuenta(cuenta);
        persona = new Persona();
        persona.setCedula(cedula);
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        ahorro.setPersona(persona);
        System.out.println(ahorro);
        System.out.println("¿¿¿¿¿¿¿¿¿¿¿¿");
//        ahorroFacade.create(ahorro);
        //list = ahorroFacade.findAll();
        Limpiar();
        return "Ahorro.xhtml?faces-redirect=true";
    }
}
