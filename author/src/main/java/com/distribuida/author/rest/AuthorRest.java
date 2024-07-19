package com.distribuida.author.rest;

import com.distribuida.author.db.Author;
import com.distribuida.author.repository.AuthorsRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/authors")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional
public class AuthorRest {

    @Inject
    AuthorsRepository authorsRepository;

    @GET
    public List<Author> buscarTodos(){
        System.out.println("Buscar todos");
        return authorsRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response buscarId(@PathParam("id") Integer id){
        System.out.println("Buscar por id");
        var author = authorsRepository.findByIdOptional(id);
        if(author.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(author.get()).build();
    }

    @POST
    public Response ingresar(Author author){
        author.setId(null);
        authorsRepository.persist(author);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response actualizar(Author author, @PathParam("id") Integer id){
        Author aut=authorsRepository.findById(id);
        aut.setFirstName(author.getFirstName());
        aut.setLastName(author.getLastName());
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Integer id){
        authorsRepository.deleteById(id);
        return Response.ok().build();
    }
}
