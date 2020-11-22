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
public class JPAOnibusDAO {
    private EntityManager em;
    
    public JPAOnibusDAO(){
    }
    
    public void salva(Onibus onibus){
        em= JPAUtil.getEM();
        EntityTransaction et= em.getTransaction();
        et.begin();
        em.persist(onibus);
        et.commit();
        em.close();
    }
    
    public Onibus recupera (Long id){
        em= JPAUtil.getEM();
        EntityTransaction et= em.getTransaction();
        et.begin();
        Onibus onibus= em.find(Onibus.class, id);
        et.commit();
        em.close();
        return onibus;
    }
    
    public void deleta (Long id){
        em= JPAUtil.getEM();
        EntityTransaction et= em.getTransaction();
        et.begin();
        Onibus onibus= em.find(Onibus.class, id);
        em.remove(onibus);
        et.commit();
        em.close();
    }
    
    public List<Onibus> buscaOnibus (String placa){
        String jpqlQuery= "SELECT onibus FROM Onibus where onibus.placa= :sn";
        em= JPAUtil.getEM();
        Query query= em.createQuery(jpqlQuery);
        query.setParameter("sn", placa);
        List<Onibus> onibus= query.getResultList();
        em.close();
        return onibus;
    }
    
    public List<Onibus> buscaTudo(){
        String jpqlQuery= "SELECT onibus FROM Onibus onibus";
        em= JPAUtil.getEM();
        Query query= em.createQuery(jpqlQuery);
        List<Onibus> onibus= query.getResultList();
        em.close();
        return onibus;
    }
}

