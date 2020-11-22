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
public class JPARotaDAO {
    private EntityManager em;
    
    public JPARotaDAO(){
    }
    
    public void salva(Rota rota){
        em= JPAUtil.getEM();
        EntityTransaction et= em.getTransaction();
        et.begin();
        em.persist(rota);
        et.commit();
        em.close();
    }
    
    public Rota recupera (Long id){
        em= JPAUtil.getEM();
        EntityTransaction et= em.getTransaction();
        et.begin();
        Rota rota= em.find(Rota.class, id);
        et.commit();
        em.close();
        return rota;
    }
    
    public void deleta (Long id){
        em= JPAUtil.getEM();
        EntityTransaction et= em.getTransaction();
        et.begin();
        Rota rota= em.find(Rota.class, id);
        em.remove(rota);
        et.commit();
        em.close();
    }
    
    public List<Rota> buscaRota (String nomerota){
        String jpqlQuery= "SELECT rota FROM Rota where rota.nomerota= :sn";
        em= JPAUtil.getEM();
        Query query= em.createQuery(jpqlQuery);
        query.setParameter("sn", nomerota);
        List<Rota> rota= query.getResultList();
        em.close();
        return rota;
    }
    
    public List<Rota> buscaTudo(){
        String jpqlQuery= "SELECT rota FROM Rota rota";
        em= JPAUtil.getEM();
        Query query= em.createQuery(jpqlQuery);
        List<Rota> rota= query.getResultList();
        em.close();
        return rota;
    }
}


