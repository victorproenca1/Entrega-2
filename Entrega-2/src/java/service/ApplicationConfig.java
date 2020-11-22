/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Victor
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.AlunoService.class);
        resources.add(service.MotoristaService.class);
        resources.add(service.OnibusService.class);
        resources.add(service.RastreamentoalunoFacadeREST.class);
        resources.add(service.RastreamentomotoristaFacadeREST.class);
        resources.add(service.RastreamentoonibusFacadeREST.class);
        resources.add(service.RastreamentorotaFacadeREST.class);
        resources.add(service.RotaService.class);
    }
    
}
