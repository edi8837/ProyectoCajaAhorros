/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;


import ec.edu.ups.poyectoingenieriasoftware.controlador.ColaboradorFacade;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Colaborador;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ViewScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;
import java.io.Serializable;

/**
 *
 * @author Jonny
 */
@Named
@RequestScoped
public class IndexController implements Serializable {

    @EJB
    private ColaboradorFacade uFacade;
    private Colaborador usuario;

    @PostConstruct
    public void init() {
        usuario = new Colaborador();

    }

    public Colaborador getUsuario() {
        return usuario;
    }

    public void setUsuario(Colaborador usuario) {
        this.usuario = usuario;
    }

 

    public String iniciarSesion() {
        System.out.println("VERIFICANDO INICIARSESION");
        String redireccion = null;
        Colaborador u;

        try {

            u = this.uFacade.iniciarSesion(usuario);
            if (u != null) {
                if ("Administrador".equals(u.getRol())) {
                     System.out.println("ADMIN 1");
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", u);
                    redireccion = "AdminInicio.xhtml?faces-redirect=true";
                } else if ("Empleado".equals(u.getRol())) {
                       System.out.println("EMPLEADO 1");
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", u);
                    redireccion = "InicioEmpleado.xhtml?faces-redirect=true";
                }

            } else {
                System.out.println("NO EXISTE 1");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario  y contraseña son incorrectos"));
                System.out.println("NO EXISTE 2");

                redireccion = "";
              
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario  no existe"));
        }
        return redireccion;
    }

}
