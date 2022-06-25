/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poyectoingenieriasoftware.controlador;

import ec.edu.ups.poyectoingenieriasoftware.modelo.Cuenta;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Socio;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
/**
 *
 * @author edwin
 */
@Stateless
public class CuentaFacade extends AbstractFacade<Cuenta> {
    @PersistenceContext(name = "SistemaIN")
    private EntityManager em;

    public CuentaFacade() {
        super(Cuenta.class);
    }
    
    public List<Integer> getSocioIds() {
        String jpql1 = "SELECT s.id FROM Cuenta s";
        List<Integer> res = em.createQuery(jpql1).getResultList();
        return res;
    }
    
    
    public Cuenta getSocioById(int id){
        String jpql = "SELECT c FROM Cuenta c WHERE c.id =" + id;
        Cuenta cuenta = (Cuenta) em.createQuery(jpql).getSingleResult();
        return cuenta;
    }
      public Cuenta buscarClientePorCedula(String cedula) {
        //return em.find(Producto.class, id);
        return em.createQuery("select c from Cuenta c  where c.cedula=:cedula", Cuenta.class)
                .setParameter("cedula", cedula)
                .getSingleResult();
    }
    
    
     public List<Cuenta>  getClientesByLevel(int level){
            Query query = em.createNamedQuery("getByLevel");
            query.setParameter("level", level);
            List<Cuenta> cli = query.getResultList();
            return cli;
        }
     
     
     public List<Cuenta> consuntaDos(String nombre, int id){
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Cuenta> cq= cb.createQuery(Cuenta.class);
        Root root = cq.from(Cuenta.class);
        cq.select(root);
        Predicate p1=cb.like(root.get("nombre").as(String.class),"Miguel");
        Predicate p2=cb.greaterThanOrEqualTo(root.get("id").as(Integer.class), id);
        Predicate predicado = cb.and(p1,p2);
        cq.where(predicado);
        
        Query consulta = em.createQuery(cq);
        return consulta.getResultList();
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    
}
