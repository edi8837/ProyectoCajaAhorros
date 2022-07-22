/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poyectoingenieriasoftware.controlador;

import ec.edu.ups.poyectoingenieriasoftware.modelo.Credito;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Registro;
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
public class RegistroFacade extends AbstractFacade<Registro> {

    @PersistenceContext(name = "SistemaIN")
    private EntityManager em;

    public RegistroFacade() {
        super(Registro.class);
    }
    public void guardar(Registro registro) {
        em.merge(registro);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
     public Registro porId(int id) {
        return em.createQuery("select p from Registro p  where p.id=:id", Registro.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
