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
import persistencia.JPAOnibusDAO;
import persistencia.Onibus;

/**
 *
 * @author Victor
 */

@Path("onibus")
public class OnibusService {
    private final JsonBuilderFactory factory;
    
    public OnibusService(){
        factory= Json.createBuilderFactory(null);
    }
    
    @POST
    @Path("create")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public void create (@FormParam("marca") String marca, @FormParam("placa") String placa, @FormParam("modelo") String modelo){
        JPAOnibusDAO dao= new JPAOnibusDAO();
        Onibus onibus= new Onibus();
        onibus.setMarca(marca);
        onibus.setPlaca(placa);
        onibus.setModelo(modelo);
        dao.salva(onibus);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void createJson(String onibus){
        JPAOnibusDAO dao= new JPAOnibusDAO();
        JsonReaderFactory f= Json.createReaderFactory(null);
        JsonReader jsonReader= f.createReader(new StringReader(onibus));
        JsonObject json= jsonReader.readObject();
        Onibus o= new Onibus();
        o.setMarca(json.getString("marca"));
        o.setPlaca(json.getString("placa"));
        o.setModelo(json.getString("modelo"));
        dao.salva(o);
    }
    
    @PUT
    @Path("edit/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Onibus entity){
        JPAOnibusDAO dao= new JPAOnibusDAO();
        dao.salva(entity);
    }
    
    @DELETE
    @Path("delete/{id}")
    public void remove(@PathParam("id") Long id){
        JPAOnibusDAO dao= new JPAOnibusDAO();
        dao.deleta(id);
    }
    
    @GET
    @Path("onibus/{id}")
    @Produces({MediaType.APPLICATION_XML})
    public JsonObject findJson(@PathParam ("id") Long id){
        JPAOnibusDAO dao= new JPAOnibusDAO();
        Onibus onibus= dao.recupera(id);
        if (onibus==null){
            throw new RuntimeException("Não foi possível encontrar o Onibus.");
        } else{
            JsonObjectBuilder builder= factory.createObjectBuilder();
            JsonObject obj = builder.add("marca", onibus.getMarca())
                .add("placa", onibus.getPlaca())
                .add("modelo", onibus.getModelo())
                .build();
            return obj;
        }
    }
    
    @GET
    @Path("onibus/{id}")
    @Produces({MediaType.TEXT_PLAIN})
    public String findPlain(@PathParam("id") Long id){
        JPAOnibusDAO dao= new JPAOnibusDAO();
        return dao.recupera(id).toString();
    }
    
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Onibus> findAll(){
        JPAOnibusDAO dao= new JPAOnibusDAO();
        return dao.buscaTudo();
    }
}
