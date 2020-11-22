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
import persistencia.JPARotaDAO;
import persistencia.Rota;

/**
 *
 * @author Victor
 */

@Path("Rota")
public class RotaService {
    private final JsonBuilderFactory factory;
    
    public RotaService(){
        factory= Json.createBuilderFactory(null);
    }
    
    @POST
    @Path("create")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public void create (@FormParam("nomerota") String nomerota, @FormParam("ponto") String ponto){
        JPARotaDAO dao= new JPARotaDAO();
        Rota Rota= new Rota();
        Rota.setNomerota(nomerota);
        Rota.setPonto(ponto);
        dao.salva(Rota);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void createJson(String rota){
        JPARotaDAO dao= new JPARotaDAO();
        JsonReaderFactory f= Json.createReaderFactory(null);
        JsonReader jsonReader= f.createReader(new StringReader(rota));
        JsonObject json= jsonReader.readObject();
        Rota r= new Rota();
        r.setNomerota(json.getString("nomerota"));
        r.setPonto(json.getString("ponto"));
        dao.salva(r);
    }
    
    @PUT
    @Path("edit/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Rota entity){
        JPARotaDAO dao= new JPARotaDAO();
        dao.salva(entity);
    }
    
    @DELETE
    @Path("delete/{id}")
    public void remove(@PathParam("id") Long id){
        JPARotaDAO dao= new JPARotaDAO();
        dao.deleta(id);
    }
    
    @GET
    @Path("rota/{id}")
    @Produces({MediaType.APPLICATION_XML})
    public JsonObject findJson(@PathParam ("id") Long id){
        JPARotaDAO dao= new JPARotaDAO();
        Rota rota= dao.recupera(id);
        if (rota==null){
            throw new RuntimeException("Não foi possível encontrar o Rota.");
        } else{
            JsonObjectBuilder builder= factory.createObjectBuilder();
            JsonObject obj = builder.add("nomerota", rota.getNomerota())
                .add("ponto", rota.getPonto())
                .build();
            return obj;
        }
    }
    
    @GET
    @Path("rota/{id}")
    @Produces({MediaType.TEXT_PLAIN})
    public String findPlain(@PathParam("id") Long id){
        JPARotaDAO dao= new JPARotaDAO();
        return dao.recupera(id).toString();
    }
    
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Rota> findAll(){
        JPARotaDAO dao= new JPARotaDAO();
        return dao.buscaTudo();
    }
}
