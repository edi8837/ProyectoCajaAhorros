/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poyectoingenieriasoftware.controlador;

import ec.edu.ups.poyectoingenieriasoftware.modelo.Ahorro;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Cuenta;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author ASUS_GAMING
 */
@Stateless
public class AhorroFacade extends AbstractFacade<Ahorro> {

    @PersistenceContext(name = "SistemaIN")
    private EntityManager em;

    public AhorroFacade() {
        super(Ahorro.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public void guardar(Ahorro ahorro) {
        em.merge(ahorro);
    }
    public Ahorro getSocioById(int id){
        String jpql = "SELECT c FROM Cuenta c WHERE c.id =" + id;
        Ahorro ahorro = (Ahorro) em.createQuery(jpql).getSingleResult();
        return ahorro;
    }
}
