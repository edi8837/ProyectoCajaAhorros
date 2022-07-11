/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poyectoingenieriasoftware.controlador;

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
public class SocioFacade extends AbstractFacade<Socio> {
    @PersistenceContext(name = "SistemaIN")
    private EntityManager em;

    public SocioFacade() {
        super(Socio.class);
    }
    
    public List<Integer> getSocioIds() {
        String jpql1 = "SELECT s.id FROM Socio s";
        List<Integer> res = em.createQuery(jpql1).getResultList();
        return res;
    }
    
    
    public Socio getSocioById(int id){
        String jpql = "SELECT c FROM Socio c WHERE c.id =" + id;
        Socio socio = (Socio) em.createQuery(jpql).getSingleResult();
        return socio;
    }
      public Socio buscarClientePorCedula(String cedula) {
        //return em.find(Producto.class, id);
        return em.createQuery("select c from Socio c  where c.cedula=:cedula", Socio.class)
                .setParameter("cedula", cedula)
                .getSingleResult();
    }
    
    
     public List<Socio>  getClientesByLevel(int level){
            Query query = em.createNamedQuery("getByLevel");
            query.setParameter("level", level);
            List<Socio> cli = query.getResultList();
            return cli;
        }
     
     
     public List<Socio> consuntaDos(String nombre, int id){
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Socio> cq= cb.createQuery(Socio.class);
        Root root = cq.from(Socio.class);
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
