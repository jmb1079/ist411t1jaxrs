/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author James Bristow <jmb1079@psu.edu>
 */
@Path("individual")
public class Individual {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public Individual() {
    }

    /**
     * Retrieves Individuals list by state
     *
     * @return an instance of java.lang.String
     */
//    @GET
//    @Path("{state}")
//    @Produces("text/html")
//    public String getIndividualsByState()
//    {
//        return "";
//    }
    @GET
    @Produces("text/html")
    public String getHtml() throws IOException 
    {
        return getAllIndividuals().toString();
    }

    private JsonObject getAllIndividuals() 
    {
        String file = "IndividualData.json";
        try (JsonReader jsonReader = Json.createReader(getClass().getResource(file).openStream())) {
            JsonObject individualData = jsonReader.readObject();
            return individualData;
        } catch (IOException ioEx) {
            System.out.println("Could not read file");
        }
        return null;
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void updateIndividualDetails(String content) 
    {
        try (InputStream stream = new ByteArrayInputStream(content.getBytes())) {
            Boolean passFormat = true;
            JsonReader reader = Json.createReader(stream);
            ArrayList<String> keys = new ArrayList<>(Arrays.asList("id", "fname", "lname", "state", "longitude", "latitude"));
            for (String key : reader.readObject().keySet()) 
            {
                if (!keys.contains(key)) 
                {
                    passFormat = false;
                }
            }
            if(!reader.readObject().keySet().contains("id"))
            {
                passFormat = false;
            }
            JsonObject allIndividuals = getAllIndividuals();
            //Here is where we need to filter and do update to all individuals for the individual changes;

        } catch (IOException ioEx) {

        }
    }
    
@DELETE
public Response deleteConfiguration(){
        return Response.status(Response.Status.OK).build();
    }
}
