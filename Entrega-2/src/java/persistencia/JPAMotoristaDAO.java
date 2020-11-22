/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Victor
 */
public class JPAMotoristaDAO {
    private EntityManager em;
    
    public JPAMotoristaDAO(){
    }
    
    public void salva(Motorista motorista){
        em= JPAUtil.getEM();
        EntityTransaction et= em.getTransaction();
        et.begin();
        em.persist(motorista);
        et.commit();
        em.close();
    }
    
    public Motorista recupera (Long id){
        em= JPAUtil.getEM();
        EntityTransaction et= em.getTransaction();
        et.begin();
        Motorista motorista= em.find(Motorista.class, id);
        et.commit();
        em.close();
        return motorista;
    }
    
    public void deleta (Long id){
        em= JPAUtil.getEM();
        EntityTransaction et= em.getTransaction();
        et.begin();
        Motorista motorista= em.find(Motorista.class, id);
        em.remove(motorista);
        et.commit();
        em.close();
    }
    
    public List<Motorista> buscaMotorista (String nomemotorista){
        String jpqlQuery= "SELECT motorista FROM Motorista where motorista.nomemotorista= :sn";
        em = JPAUtil.getEM();
        Query query= em.createQuery(jpqlQuery);
        query.setParameter("sn", nomemotorista);
        List<Motorista> motorista= query.getResultList();
        em.close();
        return motorista;
    }
    
    public List<Motorista> buscaTudo(){
        String jpqlQuery= "SELECT motorista FROM Motorista motorista";
        em= JPAUtil.getEM();
        Query query= em.createQuery(jpqlQuery);
        List<Motorista> motorista= query.getResultList();
        em.close();
        return motorista;
    }
}
