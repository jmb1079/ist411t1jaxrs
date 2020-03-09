/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import services.Business;

/**
 *
 * @author Frederick A. Aaron
 */
@Stateless
@Path("services.business")
public class BusinessFacadeREST extends AbstractFacade<Business>
{
    @PersistenceContext(unitName = "Lab7Team1PU")
    private EntityManager em;

    public BusinessFacadeREST()
    {
        super(Business.class);
    }

    @POST
    @Override
    @Consumes(
    {
        "application/xml", "application/json"
    })
    public void create(Business entity)
    {
                System.out.println("In the POST");

        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(
    {
        "application/xml", "application/json"
    })
    public void edit(@PathParam("id") Integer id, Business entity)
    {
        System.out.println("In the PUT");
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id)
    {
        System.out.println("deleting");
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces(
    {
        "application/xml", "application/json"
    })
    public Business find(@PathParam("id") Integer id)
    {
        System.out.println("In the Get");
        return super.find(id);
    }

    @GET
    @Override
    @Produces(
    {
        "application/xml", "application/json"
    })
    public List<Business> findAll()
    {
                System.out.println("In the Get");

        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(
    {
        "application/xml", "application/json"
    })
    public List<Business> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to)
    {
                System.out.println("In the Get");

        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST()
    {
                System.out.println("In the Get");

        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }
    
}
