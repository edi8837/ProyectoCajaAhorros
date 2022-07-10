/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poyectoingenieriasoftware.controlador;

import ec.edu.ups.poyectoingenieriasoftware.modelo.Aportacion;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author ASUS_GAMING
 */
@Stateless
public class AportacionFacade extends AbstractFacade<Aportacion>{

    @PersistenceContext(name = "SistemaIN")
    private EntityManager em;

    public AportacionFacade() {
        super(Aportacion.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
     public void guardar(Aportacion aportacion) {
        em.merge(aportacion);
    }
}
