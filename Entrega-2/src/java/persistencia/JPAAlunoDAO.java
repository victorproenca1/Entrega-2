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
public class JPAAlunoDAO {
    private EntityManager em;
    
    public JPAAlunoDAO(){
    }
    
    public void salva(Aluno aluno){
        em= JPAUtil.getEM();
        EntityTransaction et= em.getTransaction();
        et.begin();
        em.persist(aluno);
        et.commit();
        em.close();
    }
    
    public Aluno recupera (Long id){
        em= JPAUtil.getEM();
        EntityTransaction et= em.getTransaction();
        et.begin();
        Aluno aluno= em.find(Aluno.class, id);
        et.commit();
        em.close();
        return aluno;
    }
    
    public void deleta (Long id){
        em= JPAUtil.getEM();
        EntityTransaction et= em.getTransaction();
        et.begin();
        Aluno aluno= em.find(Aluno.class, id);
        em.remove(aluno);
        et.commit();
        em.close();
    }
    
    public List<Aluno> buscaAluno (String nomealuno){
        String jpqlQuery= "SELECT aluno FROM Aluno where aluno.nomealuno= :sn";
        em = JPAUtil.getEM();
        Query query= em.createQuery(jpqlQuery);
        query.setParameter("sn", nomealuno);
        List<Aluno> aluno= query.getResultList();
        em.close();
        return aluno;
    }
    
    public List<Aluno> buscaTudo(){
        String jpqlQuery= "SELECT aluno FROM Aluno aluno";
        em= JPAUtil.getEM();
        Query query= em.createQuery(jpqlQuery);
        List<Aluno> aluno= query.getResultList();
        em.close();
        return aluno;
    }
}
