/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

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
    public String getHtml() throws IOException {
        String file = "IndividualData.json";
        try (JsonReader jsonReader = Json.createReader(getClass().getResource(file).openStream())) {
            JsonObject individualData = jsonReader.readObject();
            return individualData.toString();
        } catch (IOException ioEx) {
            System.out.println("Could not read file");
        }
        return "";
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
//    @PUT
//    @Path("{individualid}")
//    @Consumes("text/html")
//    public void updateIndividualDetails(String content)
//    {
//    }
}
