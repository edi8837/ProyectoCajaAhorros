/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.poyectoingenieriasoftware.modelo.Colaborador;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author ASUS_GAMING
 */
@Named
@RequestScoped
public class Permisos implements Serializable{
        public void verificarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
                        //Casteo
            Colaborador co = (Colaborador) context.getExternalContext().getSessionMap().get("usuario"); // (get) con esto hago un seguimiento de la sesion iniciada

            if (co == null) {
                context.getExternalContext().redirect("InicioSesion.html"); //redirecciono al login 
            }
        } catch (Exception e) {
            System.out.println("No entro");
        }
    }
}
