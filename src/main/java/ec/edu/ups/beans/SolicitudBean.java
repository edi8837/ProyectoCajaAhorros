/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.poyectoingenieriasoftware.controlador.ColaboradorFacade;
import ec.edu.ups.poyectoingenieriasoftware.controlador.CreditoFacade;
import ec.edu.ups.poyectoingenieriasoftware.controlador.CuentaFacade;
import ec.edu.ups.poyectoingenieriasoftware.controlador.RegistroFacade;
import ec.edu.ups.poyectoingenieriasoftware.controlador.SocioFacade;
import ec.edu.ups.poyectoingenieriasoftware.controlador.SolicitudCreditoFacade;
import ec.edu.ups.poyectoingenieriasoftware.controlador.SolicitudFacade;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Ahorro;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Colaborador;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Credito;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Cuenta;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Registro;
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
    private CreditoFacade creditoFacade1;
    @EJB
    private RegistroFacade registroFacade;
    @EJB
    private SocioFacade socioFacade;
    private List<Solicitud> listSo = new ArrayList<>();
    private List<SolicitudCredito> list = new ArrayList<>();// lista de Clientes , se usa el List por el findAll()
    private List<Cuenta> listC = new ArrayList<>();// lista de Clientes , se usa el List por el findAll()
    private List<Socio> listS = new ArrayList<>();
    private List<Colaborador> listc = new ArrayList<>();
    private List<Credito> listarCreditos = new ArrayList<>();
    private List<Registro> registros = new ArrayList<>();
    private List<Registro> registros1 = new ArrayList<>();
    private SolicitudCredito credito;
    private Credito credito1;
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
        this.solicitud = new Solicitud();
        this.listarCreditos = creditoFacade1.findAll();
        this.registros = registroFacade.findAll();
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

    public CreditoFacade getCreditoFacade1() {
        return creditoFacade1;
    }

    public void setCreditoFacade1(CreditoFacade creditoFacade1) {
        this.creditoFacade1 = creditoFacade1;
    }

    public RegistroFacade getRegistroFacade() {
        return registroFacade;
    }

    public void setRegistroFacade(RegistroFacade registroFacade) {
        this.registroFacade = registroFacade;
    }

    public List<Credito> getListarCreditos() {
        return listarCreditos;
    }

    public void setListarCreditos(List<Credito> listarCreditos) {
        this.listarCreditos = listarCreditos;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    public List<Registro> getRegistros1() {
        return registros1;
    }

    public void setRegistros1(List<Registro> registros1) {
        this.registros1 = registros1;
    }

    public Credito getCredito1() {
        return credito1;
    }

    public void setCredito1(Credito credito1) {
        this.credito1 = credito1;
    }

    public String solicitudBusqueda() {
        mensaje = "";
        System.out.println(numero);
        System.out.println("Hola");
        for (int i = 0; i < list.size(); i++) {

            SolicitudCredito a = list.get(i);

            if (numero == a.getId()) {
                credito = a;

                cantidad = credito.getCantidad();
                System.out.println("entra");
                cedula = credito.getCuenta().getSocio().getNombre();

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

                colaborador = c;

                System.out.println(colaborador);

                //System.out.println(credito);
            }
        }

        return null;
    }

    public String add(int idc, int id) {
        System.out.println(estado);
        //Solicitud solicitud1 = new Solicitud();
        System.out.println(colaborador);
        solicitud.setColaborador(colaborador);
        solicitud.setEstadoAportacion(estado);
        solicitud.setSolicitudCredito(credito);
        solicitudFacade.guardar(solicitud);
        crerCrecito();
        //System.out.println(credito);
        //System.out.println(solicitud1);
        //solicitudFacade.create(solicitud);

//        if (cuenta.getSocio().getCedula().equals(socio.getCedula())) {
//        }
        return "El numero de la cuenta no le pertenece al cliente";
    }

    public void crerCrecito() {
        listarCreditos = creditoFacade1.findAll();
        System.out.println("entra1");
        System.out.println(solicitud);
        SolicitudCredito solicitudCredito = creditoFacade.porId(credito.getId());
        if (solicitudCredito.getEstado() == 'A') {
            System.out.println("el pedido ya esta en estado Aceptado");

        } else if ('A' != credito.getEstado()) {
            credito.setEstado('A');
            creditoFacade.edit(credito);
            Credito credito1 = new Credito();
            credito1.setId(listarCreditos.size() + 1);
            credito1.setCantidad(credito.getCantidad());
            credito1.setCuenta(credito.getCuenta());
            credito1.setFecha(new Date());
            credito1.setEstadoCredito('A');
            credito1.setNum(credito.getMeses());
            credito1.setSolicitudCredito(credito);

            creditoFacade1.guardar(credito1);
            CrearTablaDeA(credito1.getNum(), credito1.getCantidad(), credito1.getId());

        }
        listarCreditos = creditoFacade1.findAll();

    }

    public void CrearTablaDeA(int mesesPlazo, double credito2, int idc) {
        System.out.println(idc);
        registros1.clear();
        int mesesPLazo = mesesPlazo;
        double monto = credito2;
        double saldo1 = monto;
        double in = 0.7;

        double coutaCpaital;
        double nteres;
        double amort;
        double saldo;
        System.out.println("llega");
        credito1 = creditoFacade1.porId(idc);
        System.out.println(credito1);
        for (int i = 0; i < mesesPLazo; i++) {
            coutaCpaital = monto / mesesPLazo;

            nteres = (saldo1 * in) / 100;
            amort = coutaCpaital + nteres;
            saldo = saldo1 - coutaCpaital;
            saldo1 = saldo;

            Registro registro = new Registro();
            registro.setCotaCapital(coutaCpaital);
            registro.setEstado("NOCANCELADO");
            registro.setInteres(nteres);
            registro.setAmortizacion(amort);
            registro.setSaldo(saldo);

            registro.setCredito(credito1);
            registroFacade.guardar(registro);

            System.out.println((i + 1) + "coutaCpaital" + coutaCpaital + " nteres" + nteres + " amort" + amort + "saldo " + saldo);

        }

        registros = registroFacade.findAll();

    }

    public String verTabla(int id) {
        credito1 = creditoFacade1.porId(id);
        registros1.clear();

        System.out.println("entra");
        List<Registro> registros2 =registroFacade.findAll();

        for (int i = 0; i < registros2.size(); i++) {
            Registro a = registros2.get(i);

            if (a.getCredito().getId() == id) {
                registros1.add(a);

            }
        }
        System.out.println(registros1);
        return "listRegistro.xhtml?faces-redirect=true";
    }

}
