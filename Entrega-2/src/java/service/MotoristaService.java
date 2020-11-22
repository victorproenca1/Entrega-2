/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.StringReader;
import java.util.List;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonReaderFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import persistencia.JPAMotoristaDAO;
import persistencia.Motorista;

/**
 *
 * @author Victor
 */

@Path("motorista")
public class MotoristaService {
    private final JsonBuilderFactory factory;
    
    public MotoristaService(){
        factory= Json.createBuilderFactory(null);
    }
    
    @POST
    @Path("create")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public void create (@FormParam("nomemotorista") String nomemotorista, @FormParam("emailmotorista") String emailmotorista, @FormParam("senhamotorista") String senhamotorista, @FormParam("avaliacoespositivas") Integer avaliacoespositivas, @FormParam("avaliacoesnegativas") Integer avaliacoesnegativas){
        JPAMotoristaDAO dao= new JPAMotoristaDAO();
        Motorista motorista= new Motorista();
        motorista.setNomemotorista(nomemotorista);
        motorista.setEmailmotorista(emailmotorista);
        motorista.setSenhamotorista(senhamotorista);
        motorista.setAvaliacoespositivas(avaliacoespositivas);
        motorista.setAvaliacoesnegativas(avaliacoesnegativas);
        dao.salva(motorista);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void createJson(String motorista){
        JPAMotoristaDAO dao= new JPAMotoristaDAO();
        JsonReaderFactory f= Json.createReaderFactory(null);
        JsonReader jsonReader= f.createReader(new StringReader(motorista));
        JsonObject json= jsonReader.readObject();
        Motorista m= new Motorista();
        m.setNomemotorista(json.getString("nomemotorista"));
        m.setEmailmotorista(json.getString("emailmotorista"));
        m.setSenhamotorista(json.getString("senhamotorista"));
        m.setAvaliacoespositivas(json.getInt("avaliacoespositivas"));
        m.setAvaliacoesnegativas(json.getInt("avaliacoesnegativas"));
        dao.salva(m);
    }
    
    @PUT
    @Path("edit/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Motorista entity){
        JPAMotoristaDAO dao= new JPAMotoristaDAO();
        dao.salva(entity);
    }
    
    @DELETE
    @Path("delete/{id}")
    public void remove(@PathParam("id") Long id){
        JPAMotoristaDAO dao= new JPAMotoristaDAO();
        dao.deleta(id);
    }
    
    @GET
    @Path("motorista/{id}")
    @Produces({MediaType.APPLICATION_XML})
    public JsonObject findJson(@PathParam ("id") Long id){
        JPAMotoristaDAO dao= new JPAMotoristaDAO();
        Motorista motorista= dao.recupera(id);
        if (motorista==null){
            throw new RuntimeException("Não foi possível encontrar o motorista.");
        } else{
            JsonObjectBuilder builder= factory.createObjectBuilder();
            JsonObject obj = builder.add("nomemotorista", motorista.getNomemotorista())
                .add("emailmotorista", motorista.getEmailmotorista())
                .add("senhamotorista", motorista.getSenhamotorista())
                .add("avaliacoespositivas", motorista.getAvaliacoespositivas())
                .add("avaliacoesnegativas", motorista.getAvaliacoesnegativas())
                .build();
            return obj;
        }
    }
    
    @GET
    @Path("motorista/{id}")
    @Produces({MediaType.TEXT_PLAIN})
    public String findPlain(@PathParam("id") Long id){
        JPAMotoristaDAO dao= new JPAMotoristaDAO();
        return dao.recupera(id).toString();
    }
    
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Motorista> findAll(){
        JPAMotoristaDAO dao= new JPAMotoristaDAO();
        return dao.buscaTudo();
    }
}