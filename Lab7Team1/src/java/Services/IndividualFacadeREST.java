/* 
Project: Lab 7
Purpose Details: Client-Server capitalization application
Course: IST 411
Author: James Bristow, Alba Beqo, Frederick Aaron, Logan Pratt, Ryan Urbanski
Date Developed: 3/20/2020
Last Date Changed:3/22/2020
Revision: 6
*/
package Services;

import Services.AbstractFacade;
import Services.Individual;
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

/**
 *
 * @author James Bristow <jmb1079@psu.edu>
 */
@Stateless
@Path("services.individual")
public class IndividualFacadeREST extends AbstractFacade<Individual>
{
    @PersistenceContext(unitName = "Lab7Team1PU")
    private EntityManager em;

    public IndividualFacadeREST()
    {
        super(Individual.class);
    }

    @POST
    @Override
    @Consumes(
    {
        "application/xml", "application/json"
    })
    public void create(Individual entity)
    {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(
    {
        "application/xml", "application/json"
    })
    public void edit(@PathParam("id") Integer id, Individual entity)
    {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id)
    {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces(
    {
        "application/xml", "application/json"
    })
    public Individual find(@PathParam("id") Integer id)
    {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(
    {
        "application/xml", "application/json"
    })
    public List<Individual> findAll()
    {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(
    {
        "application/xml", "application/json"
    })
    public List<Individual> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to)
    {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST()
    {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }
    
}
