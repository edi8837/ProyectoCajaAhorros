/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poyectoingenieriasoftware.controlador;

import ec.edu.ups.poyectoingenieriasoftware.modelo.Colaborador;
import ec.edu.ups.poyectoingenieriasoftware.modelo.Menu;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author ASUS_GAMING
 */
@Stateless
public class MenuFacade extends AbstractFacade<Menu>{
    @PersistenceContext(name = "SistemaIN")
    private EntityManager em;

    public MenuFacade() {
        super(Menu.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Colaborador iniciarUsuario(Colaborador usuario) {
        Colaborador u = null;
        try {
            String consulta = "SELECT c FROM Colaborador c WHERE c.usuario = ?1 AND c.contrasenia = ?2"; // de esta forma mando parametros
            Query query = em.createQuery(consulta);
            query.setParameter(1, usuario.getUsuario()); // asigno los parametros al objeto
            query.setParameter(2, usuario.getContracenia());
            
            List<Colaborador> lista = query.getResultList(); //definimos una lista de tipo usuario ya que es el objeto que se esta mapeando
            System.out.println(usuario.getUsuario());
            System.out.println(usuario.getContracenia());
            if (!lista.isEmpty()) { //pregunto si la lista es diferente de  vacia
                System.out.println(lista.get(0) + " Hola mundo" );
                return usuario = lista.get(0); //retorno el primer elemento de la lista
            }
        }catch (Exception e) {
           System.out.println("Ya valio maso " + e); // caso contrario ya valio y retorna un null
        }
        return u;
    }
}
