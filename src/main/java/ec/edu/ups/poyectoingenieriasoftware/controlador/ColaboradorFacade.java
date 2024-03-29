/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poyectoingenieriasoftware.controlador;

import ec.edu.ups.poyectoingenieriasoftware.modelo.Colaborador;
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
public class ColaboradorFacade extends AbstractFacade<Colaborador> {
    @PersistenceContext(name = "SistemaIN")
    private EntityManager em;

    public ColaboradorFacade() {
        super(Colaborador.class);
    }
    
    public List<Integer> getSocioIds() {
        String jpql1 = "SELECT s.id FROM Colaborador s";
        List<Integer> res = em.createQuery(jpql1).getResultList();
        return res;
    }
    
    
    public Colaborador getSocioById(int id){
        String jpql = "SELECT c FROM Colaborador c WHERE c.id =" + id;
        Colaborador   colaborador= (Colaborador) em.createQuery(jpql).getSingleResult();
        return colaborador;
    }
    
    
     public List<Colaborador>  getClientesByLevel(int level){
            Query query = em.createNamedQuery("getByLevel");
            query.setParameter("level", level);
            List<Colaborador> cli = query.getResultList();
            return cli;
        }
     
     
     public List<Colaborador> consuntaDos(String nombre, int id){
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Colaborador> cq= cb.createQuery(Colaborador.class);
        Root root = cq.from(Colaborador.class);
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
    
    
    
    public Colaborador iniciarSesion(Colaborador u) {
        Colaborador usuario = null;
        String consulta;
        try {
            consulta = "SELECT u FROM Colaborador u WHERE u.usuario = ?1 and u.contracenia= ?2";
            Query query;
            query = em.createQuery(consulta);
            query.setParameter(1, u.getUsuario());
            query.setParameter(2, u.getContracenia());
            List<Colaborador> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return usuario;
    }
    
    
}
