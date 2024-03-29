/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.poyectoingenieriasoftware.controlador.CuentaFacade;
import ec.edu.ups.poyectoingenieriasoftware.controlador.SocioFacade;
import ec.edu.ups.poyectoingenieriasoftware.controlador.SolicitudCreditoFacade;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Cuenta;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Socio;
import ec.edu.ups.poyectoingenieriasoftware.modelo.SolicitudCredito;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
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
public class SolicitudCreditoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    @EJB
    private SolicitudCreditoFacade creditoFacade;
    @EJB
    private CuentaFacade cuentaFacade;
    @EJB
    private SocioFacade socioFacade;
    private List<SolicitudCredito> list = new ArrayList<>();// lista de Clientes , se usa el List por el findAll()
    private List<Cuenta> listC = new ArrayList<>();// lista de Clientes , se usa el List por el findAll()
    private List<Socio> listS = new ArrayList<>();
    private SolicitudCredito credito;
    private double cantidad;
    private Date fechaE;
    private String motivo;
    private String lugarT;
    private int numero;
    private String cedula;
    private String tipoDeCuenta;
    private double ingresM;
    private Socio socio;
    private Cuenta cuenta;
    private int meses;
    private String mensaje;
    private String numeroCedula;

    @PostConstruct//Esto es una notacion de EJB que nos dice que
    public void init() {//este metodo init se va a ejecutar despues 
        this.list = creditoFacade.findAll();//de que se ha creado o visualizado el JSF o el bean
        this.listC = cuentaFacade.findAll();
        this.listS = socioFacade.findAll();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SolicitudCreditoFacade getCreditoFacade() {
        return creditoFacade;
    }

    public void setCreditoFacade(SolicitudCreditoFacade creditoFacade) {
        this.creditoFacade = creditoFacade;
    }

    public CuentaFacade getCuentaFacade() {
        return cuentaFacade;
    }

    public void setCuentaFacade(CuentaFacade cuentaFacade) {
        this.cuentaFacade = cuentaFacade;
    }

    public SocioFacade getSocioFacade() {
        return socioFacade;
    }

    public void setSocioFacade(SocioFacade socioFacade) {
        this.socioFacade = socioFacade;
    }

    public List<SolicitudCredito> getList() {
        return list;
    }

    public void setList(List<SolicitudCredito> list) {
        this.list = list;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaE() {
        return fechaE;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }
    
    public void setFechaE(Date fechaE) {
        this.fechaE = fechaE;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getLugarT() {
        return lugarT;
    }

    public void setLugarT(String lugarT) {
        this.lugarT = lugarT;
    }

    public double getIngresM() {
        return ingresM;
    }

    public void setIngresM(double ingresM) {
        this.ingresM = ingresM;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public List<Cuenta> getListC() {
        return listC;
    }

    public void setListC(List<Cuenta> listC) {
        this.listC = listC;
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

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public List<Socio> getListS() {
        return listS;
    }

    public void setListS(List<Socio> listS) {
        this.listS = listS;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public void setTipoDeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public SolicitudCredito getCredito() {
        return credito;
    }

    public void setCredito(SolicitudCredito credito) {
        this.credito = credito;
    }

    public String clienteBusqueda() {
        mensaje = "";
        System.out.println(cedula);
        for (Socio socio : listS) {
            if (socio.getCedula().equalsIgnoreCase(cedula)) {
                System.out.println("Se encontro");
                mensaje = "Cedula Encontrada";
                numeroCedula = socio.getCedula();
                this.socio = socio;
            }
        }
        return null;
    }

    public String cuentaBusqueda() {
        mensaje = "";
        System.out.println(numero);
        for (Cuenta cuenta : listC) {
            System.out.println("Entro");
            if (numero == cuenta.getNumero()) {
                mensaje = "Cuenta Encontrada";
                tipoDeCuenta = cuenta.getTipoDeCuenta();
                System.out.println(tipoDeCuenta);
                this.cuenta = cuenta;
            }
        }
        return null;
    }

    public String add() {
        credito = new SolicitudCredito();
        credito.setCantidad(cantidad);
        credito.setCuenta(cuenta);
        credito.setFechaEmicion(new Date());
        credito.setIngresoMensual(ingresM);
        credito.setLugarTrabajo(lugarT);
        credito.setMotivo(motivo);
        credito.setSocio(socio);
        credito.setMeses(meses);
        if (socio != null && cuenta != null) {
            if (socio.getCedula().equals(cuenta.getSocio().getCedula())) {
                credito.setEstado('E');
                creditoFacade.create(credito);
                list = creditoFacade.findAll();
                limpiar();
                return "SolicitudCredito.xhtml?faces-redirect=true";
            }
            return "El numero de la cuenta no le pertenece al cliente";
        }
//        if (cuenta.getSocio().getCedula().equals(socio.getCedula())) {
//        }
        return "El numero de la cuenta no le pertenece al cliente";
    }

    public void limpiar() {
        this.cantidad = 0.00;
        this.cedula = "";
        this.ingresM = 0.00;
        this.lugarT = "";
        this.motivo = "";
        this.numero = 0;
        this.meses = 0;
    }
}
