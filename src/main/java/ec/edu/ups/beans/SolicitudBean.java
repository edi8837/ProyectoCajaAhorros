/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.poyectoingenieriasoftware.controlador.ColaboradorFacade;
import ec.edu.ups.poyectoingenieriasoftware.controlador.CuentaFacade;
import ec.edu.ups.poyectoingenieriasoftware.controlador.SocioFacade;
import ec.edu.ups.poyectoingenieriasoftware.controlador.SolicitudCreditoFacade;
import ec.edu.ups.poyectoingenieriasoftware.controlador.SolicitudFacade;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Ahorro;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Colaborador;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Cuenta;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Socio;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Solicitud;
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
public class SolicitudBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    @EJB
    private SolicitudCreditoFacade creditoFacade;
    @EJB
    private SolicitudFacade solicitudFacade;
    @EJB
    private ColaboradorFacade colaboradorFacade;
    @EJB
    private CuentaFacade cuentaFacade;
    @EJB
    private SocioFacade socioFacade;
    private List<Solicitud> listSo = new ArrayList<>();
    private List<SolicitudCredito> list = new ArrayList<>();// lista de Clientes , se usa el List por el findAll()
    private List<Cuenta> listC = new ArrayList<>();// lista de Clientes , se usa el List por el findAll()
    private List<Socio> listS = new ArrayList<>();
    private List<Colaborador> listc = new ArrayList<>();
    private SolicitudCredito credito;
    private Solicitud solicitud;
    private double cantidad;
    private Date fechaE;
    private String motivo;
    private String lugarT;
    private int numero;
    private String cedula;
    private char estado;
    private double ingresM;
    private Socio socio;
    private Cuenta cuenta;
    private int meses;
    private Colaborador colaborador;
    private String mensaje;
    private String numeroCedula;

    @PostConstruct//Esto es una notacion de EJB que nos dice que
    public void init() {//este metodo init se va a ejecutar despues 
        this.listSo = solicitudFacade.findAll();
        this.list = creditoFacade.findAll();//de que se ha creado o visualizado el JSF o el bean
        this.listC = cuentaFacade.findAll();
        this.listS = socioFacade.findAll();
        this.listc = colaboradorFacade.findAll();
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

    public List<Cuenta> getListC() {
        return listC;
    }

    public void setListC(List<Cuenta> listC) {
        this.listC = listC;
    }

    public List<Socio> getListS() {
        return listS;
    }

    public void setListS(List<Socio> listS) {
        this.listS = listS;
    }

    public SolicitudCredito getCredito() {
        return credito;
    }

    public void setCredito(SolicitudCredito credito) {
        this.credito = credito;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public SolicitudFacade getSolicitudFacade() {
        return solicitudFacade;
    }

    public void setSolicitudFacade(SolicitudFacade solicitudFacade) {
        this.solicitudFacade = solicitudFacade;
    }

    public List<Solicitud> getListSo() {
        return listSo;
    }

    public void setListSo(List<Solicitud> listSo) {
        this.listSo = listSo;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
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

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public ColaboradorFacade getColaboradorFacade() {
        return colaboradorFacade;
    }

    public void setColaboradorFacade(ColaboradorFacade colaboradorFacade) {
        this.colaboradorFacade = colaboradorFacade;
    }

    public List<Colaborador> getListc() {
        return listc;
    }

    public void setListc(List<Colaborador> listc) {
        this.listc = listc;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }
    

    public String solicitudBusqueda() {
        mensaje = "";
        System.out.println(numero);
        System.out.println("Hola");
        for (int i = 0; i < list.size(); i++) {
         
            SolicitudCredito a = list.get(i);

             if (numero == a.getId()) {
                credito = a;
              
                cantidad=credito.getCantidad();
                  System.out.println("entra");
                cedula=credito.getCuenta().getSocio().getNombre();
                
                //System.out.println(credito);
            }
        }
           
        
        
            
        return null;
    }
    public String buscarColaborador() {
        mensaje = "";
        System.out.println(cedula);
        System.out.println("Hola");
        for (int i = 0; i < listc.size(); i++) {
         
            Colaborador c = listc.get(i);

             if (cedula.equals(c.getCedula())) {
           
              
                colaborador=c;
                 
                 System.out.println(colaborador);
                
                //System.out.println(credito);
            }
        }
           
        
        
            
        return null;
    }
    public String add(int idc ,int id ) {
        System.out.println(estado);
        Solicitud solicitud1 = new Solicitud();
        System.out.println(colaborador);
        solicitud1.setColaborador(colaborador);
        solicitud1.setEstadoAportacion(estado);
        solicitud1.setSolicitudCredito(credito);
        this.credito.setEstado(estado);
        solicitudFacade.guardar(solicitud1);
        //System.out.println(credito);
        //System.out.println(solicitud1);
        //solicitudFacade.create(solicitud);
        
//        if (cuenta.getSocio().getCedula().equals(socio.getCedula())) {
//        }
        return "El numero de la cuenta no le pertenece al cliente";
    }

}
