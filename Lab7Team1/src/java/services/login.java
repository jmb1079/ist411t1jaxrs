/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author James Bristow <jmb1079@psu.edu>
 */
@Path("login")
public class login
{
    @Context
    private UriInfo context;
    
    @GET
    @Produces("text/html")
    public String getHtml()
    {
        return "<html lang=\"en\"><body><h1>Login complete</body></h1></html>";
    }
    
    @DELETE
    @Path("id")
    public void deleteHtml()
    {
        
    }
    
    @PUT
    @Consumes("text/html")
    public void putHtml()
    {
        
    }
    
    @POST
    @Consumes("text/html")
    @Produces("text/html")
    public String postHtml()
    {
        return "";
    }
}
