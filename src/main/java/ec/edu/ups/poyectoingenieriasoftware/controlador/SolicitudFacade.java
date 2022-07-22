/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poyectoingenieriasoftware.controlador;

import ec.edu.ups.poyectoingenieriasoftware.modelo.Aportacion;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Solicitud;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author ASUS_GAMING
 */
@Stateless
public class SolicitudFacade extends AbstractFacade<Solicitud>{

    @PersistenceContext(name = "SistemaIN")
    private EntityManager em;

    public SolicitudFacade() {
        super(Solicitud.class);
    }
    public void guardar(Solicitud solicitud) {
        em.merge(solicitud);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
