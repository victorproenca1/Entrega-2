/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Victor
 */
class JPAUtil {
    private static EntityManagerFactory emf;
    
    static EntityManager getEM() {
        if (emf == null){
            emf= Persistence.createEntityManagerFactory("Rastreamento");
        }
        return emf.createEntityManager();
    }
    public static void fechaEmf(){
        emf.close();
    }
}
