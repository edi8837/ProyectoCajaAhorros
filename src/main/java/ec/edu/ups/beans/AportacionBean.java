/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.poyectoingenieriasoftware.controlador.AhorroFacade;
import ec.edu.ups.poyectoingenieriasoftware.controlador.AportacionFacade;
import ec.edu.ups.poyectoingenieriasoftware.controlador.CuentaFacade;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Ahorro;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Aportacion;
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
public class AportacionBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    @EJB
    private CuentaFacade cuentaFacade;
    @EJB
    private AportacionFacade aportacionFacade;
    private List<Aportacion> list = new ArrayList<>();
    private List<Cuenta> listaCuenta = new ArrayList<>();
    private double valor;
    private char tipoAhorro;
    private Date fecha;
    private Aportacion aportacion;
    private Cuenta cuenta;
    private Persona persona;
    private int numero;
    private String mensaje;
    private String cedula;
    private String nombre;
    private String apellido;
    private int numeroCuenta;
    private String nombreCuenta;
    private int reducir;

    @PostConstruct//Esto es una notacion de EJB que nos dice que
    public void init() {//este metodo init se va a ejecutar despues 
        this.list = aportacionFacade.findAll();//de que se ha creado o visualizado el JSF o el bean
        this.listaCuenta = cuentaFacade.findAll();
    }

    public String delete(Aportacion a) {
        aportacionFacade.remove(a);
        list = aportacionFacade.findAll();
        return null;
    }

    public String edit(Aportacion a) {
        aportacionFacade.edit(a);
        list = aportacionFacade.findAll();
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CuentaFacade getCuentaFacade() {
        return cuentaFacade;
    }

    public void setCuentaFacade(CuentaFacade cuentaFacade) {
        this.cuentaFacade = cuentaFacade;
    }

    public AportacionFacade getAportacionFacade() {
        return aportacionFacade;
    }

    public void setAportacionFacade(AportacionFacade aportacionFacade) {
        this.aportacionFacade = aportacionFacade;
    }

    public List<Aportacion> getList() {
        return list;
    }

    public void setList(List<Aportacion> list) {
        this.list = list;
    }

    public List<Cuenta> getListaCuenta() {
        return listaCuenta;
    }

    public void setListaCuenta(List<Cuenta> listaCuenta) {
        this.listaCuenta = listaCuenta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getReducir() {
        return reducir;
    }

    public void setReducir(int reducir) {
        this.reducir = reducir;
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

    public Aportacion getAportacion() {
        return aportacion;
    }

    public void setAportacion(Aportacion aportacion) {
        this.aportacion = aportacion;
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

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
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
                nombreCuenta = cuenta.getSocio().getNombre();
                this.cuenta = cuenta;
            }
            System.out.println("No entro");
        }
        return null;
    }

    public String add() {
        System.out.println("Entro Aportacion");
        System.out.println(cedula);
        aportacion = new Aportacion();
        aportacion.setValor(valor);
        aportacion.setTipoAportacion('D');
        aportacion.setFecha(new Date());
        aportacion.setCuenta(cuenta);
        Persona persona1 = new Persona();
        persona1.setCedula(cedula);
        persona1.setNombre(nombre);
        persona1.setApellido(apellido);
        aportacion.setPersona(persona1);
        System.out.println(aportacion);
        System.out.println("¿¿¿¿¿¿¿¿¿¿¿¿");
        aportacionFacade.guardar(aportacion);
        list = aportacionFacade.findAll();
        aumentarMonto();
        Limpiar();
        return "Aportacion.xhtml?faces-redirect=true";
    }

    public String addR() {
        reducir = 5000;
        System.out.println(aportacion.getValor()+"Hola munodo------");
        if (aportacion.getValor() <= reducir) {
            aportacion = new Aportacion();
            aportacion.setValor(valor);
            aportacion.setTipoAportacion('R');
            aportacion.setFecha(new Date());
            aportacion.setCuenta(cuenta);
            aportacionFacade.guardar(aportacion);
            list = aportacionFacade.findAll();
            reducirMonto();
            Limpiar();
            return "Retiro.xhtml?faces-redirect=true";
        }
        return "No cumple con el monto necesario";
    }

    public void aumentarMonto() {
        double aumentar = 0.00;
        aumentar = cuenta.getMonto() + valor;
        cuenta.setMonto(aumentar);
        System.out.println(aumentar);
        cuentaFacade.edit(cuenta);
        this.listaCuenta = cuentaFacade.findAll();
    }

    public void reducirMonto() {
        double reducir = 0.00;
//        for (Cuenta cuenta : listaCuenta) {
        if (this.cuenta.getMonto() >= valor) {
            System.out.println(cuenta.getMonto() + "Hola");
            reducir = cuenta.getMonto() - valor;
            System.out.println(reducir);
            cuenta.setMonto(reducir);
            cuentaFacade.edit(cuenta);
            this.listaCuenta = cuentaFacade.findAll();

        } else {
            System.out.println("NO EXISTE 1");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No puede retirar"));
        }
//        }
    }

    public void Limpiar() {
        this.valor = 0.00;
        this.nombre = "";
        this.apellido = "";
        this.cedula = "";
    }

}
