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
    private SocioFacade socioFacade;
    @EJB
    private CuentaFacade cuentaFacade;
//mando mi fachada
    private List<Cuenta> list = new ArrayList<>();
 private List<Cuenta> listCSocios = new ArrayList<>();// lista de Clientes , se usa el List por el findAll()
    private int id;
    private String cedula;
    private int numero;
    private Date fechaApertura;
    private String tipoDeCuenta;
    private Cuenta cuenta;
    private Socio socio;
    private boolean Estado;
    private double monto;

    @PostConstruct//Esto es una notacion de EJB que nos dice que
    public void init() {//este metodo init se va a ejecutar despues 
        this.list = cuentaFacade.findAll();//de que se ha creado o visualizado el JSF o el bean
    }                                  // esto se lo hace ya que puede que no se haya renderizado toda la vista y ya quiera llamar a buscar la info//lo cual puede arrojar un error  

    public String add() {

        cuenta = new Cuenta();
        cuenta.setNumero(numero);
        cuenta.setFechaApertura(fechaApertura);
        cuenta.setEstado(Estado);
        cuenta.setTipoDeCuenta(tipoDeCuenta);
        cuenta.setSocio(socio);
        cuenta.setMonto(monto);
        cuentaFacade.create(cuenta);
        list = cuentaFacade.findAll();
        limpiar();
        return "Cuenta.xhtml?faces-redirect=true";
    }

    public String delete(Cuenta c) {
        cuentaFacade.remove(c);
        list = cuentaFacade.findAll();
        return null;
    }
     public void limpiar(){
         numero=0;
         fechaApertura=null;
         tipoDeCuenta="";
         socio=null;
         monto =0.00;
     }
     
    public String edit(Cuenta c) {
        cuentaFacade.edit(c);
        this.list = cuentaFacade.findAll();
        return null;
    }

    public String save(Socio c) {
        socioFacade.edit(c);
        list = cuentaFacade.findAll(); //actualizo la lista
        c.setEditable(false); //desabilita la caja
        return null;
    }

    public SocioFacade getSocioFacade() {
        return socioFacade;
    }

    public void setSocioFacade(SocioFacade socioFacade) {
        this.socioFacade = socioFacade;
    }

    public CuentaFacade getCuentaFacade() {
        return cuentaFacade;
    }

    public void setCuentaFacade(CuentaFacade cuentaFacade) {
        this.cuentaFacade = cuentaFacade;
    }

    public List<Cuenta> getList() {
        return list;
    }

    public void setList(List<Cuenta> list) {
        this.list = list;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public void setTipoDeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public List<Cuenta> getListCSocios() {
        return listCSocios;
    }

    public void setListCSocios(List<Cuenta> listCSocios) {
        this.listCSocios = listCSocios;
    }
    
    
    public void buscarSocio() {
        
        System.out.println(cedula);

        socio = socioFacade.buscarClientePorCedula(cedula);

        try {
            if (socio != null) {
                numero = (int) (1000000 + Math.random() * 90000);
                fechaApertura = new Date();
                Estado = true;
            } else {
                System.out.println("NO EXISTE 1");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "EL Socio no Existee"));
                System.out.println("NO EXISTE 2");
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Socio  no existe"));
        }

    }
    public void buscarPorSocio(){
        listCSocios.clear();
        System.out.println("entra");
        List<Cuenta> cuentas1= cuentaFacade.findAll();
        Socio socio1 = socioFacade.buscarClientePorCedula(cedula);
         for (int i = 0; i < cuentas1.size(); i++) {
                Cuenta c = cuentas1.get(i);
                if (c.getSocio().getId()== socio1.getId()) {
                    listCSocios.add(c);
                 
             }
         }
         System.out.println(listCSocios);
 
    }
}
