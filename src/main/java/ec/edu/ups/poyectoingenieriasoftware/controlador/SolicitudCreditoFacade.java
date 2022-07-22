/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poyectoingenieriasoftware.controlador;

import ec.edu.ups.poyectoingenieriasoftware.modelo.Solicitud;
import ec.edu.ups.poyectoingenieriasoftware.modelo.SolicitudCredito;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author ASUS_GAMING
 */
@Stateless
public class SolicitudCreditoFacade extends AbstractFacade<SolicitudCredito> {

    @PersistenceContext(name = "SistemaIN")
    private EntityManager em;

    public SolicitudCreditoFacade() {
        super(SolicitudCredito.class);
    }

    public SolicitudCredito porId(int id) {
        return em.createQuery("select p from SolicitudCredito p  where p.id=:id", SolicitudCredito.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
