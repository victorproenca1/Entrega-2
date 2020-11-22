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
import persistencia.Aluno;
import persistencia.JPAAlunoDAO;

/**
 *
 * @author Victor
 */

@Path("aluno")
public class AlunoService {
    private final JsonBuilderFactory factory;
    
    public AlunoService(){
        factory= Json.createBuilderFactory(null);
    }
    
    @POST
    @Path("create")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public void create (@FormParam("nomealuno") String nomealuno, @FormParam("emailaluno") String emailaluno, @FormParam("senhaaluno") String senhaaluno, @FormParam("curso") String curso){
        JPAAlunoDAO dao= new JPAAlunoDAO();
        Aluno aluno= new Aluno();
        aluno.setNomealuno(nomealuno);
        aluno.setEmailaluno(emailaluno);
        aluno.setSenhaaluno(senhaaluno);
        aluno.setCurso(curso);
        dao.salva(aluno);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void createJson(String aluno){
        JPAAlunoDAO dao= new JPAAlunoDAO();
        JsonReaderFactory f= Json.createReaderFactory(null);
        JsonReader jsonReader= f.createReader(new StringReader(aluno));
        JsonObject json= jsonReader.readObject();
        Aluno a= new Aluno();
        a.setNomealuno(json.getString("nomealuno"));
        a.setEmailaluno(json.getString("emailaluno"));
        a.setSenhaaluno(json.getString("senhaaluno"));
        a.setCurso(json.getString("curso"));
        dao.salva(a);
    }
    
    @PUT
    @Path("edit/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Aluno entity){
        JPAAlunoDAO dao= new JPAAlunoDAO();
        dao.salva(entity);
    }
    
    @DELETE
    @Path("delete/{id}")
    public void remove(@PathParam("id") Long id){
        JPAAlunoDAO dao= new JPAAlunoDAO();
        dao.deleta(id);
    }
    
    @GET
    @Path("aluno/{id}")
    @Produces({MediaType.APPLICATION_XML})
    public JsonObject findJson(@PathParam ("id") Long id){
        JPAAlunoDAO dao= new JPAAlunoDAO();
        Aluno aluno= dao.recupera(id);
        if (aluno==null){
            throw new RuntimeException("Não foi possível encontrar o aluno.");
        } else{
            JsonObjectBuilder builder= factory.createObjectBuilder();
            JsonObject obj = builder.add("nomealuno", aluno.getNomealuno())
                .add("emailaluno", aluno.getEmailaluno())
                .add("senhaaluno", aluno.getSenhaaluno())
                .add("curso", aluno.getCurso())
                .build();
            return obj;
        }
    }
    
    @GET
    @Path("aluno/{id}")
    @Produces({MediaType.TEXT_PLAIN})
    public String findPlain(@PathParam("id") Long id){
        JPAAlunoDAO dao= new JPAAlunoDAO();
        return dao.recupera(id).toString();
    }
    
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Aluno> findAll(){
        JPAAlunoDAO dao= new JPAAlunoDAO();
        return dao.buscaTudo();
    }
}
