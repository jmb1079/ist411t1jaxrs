/* 
Project: Lab 7
Purpose Details: Client-Server capitalization application
Course: IST 411
Author: James Bristow, Alba Beqo, Frederick Aaron, Logan Pratt, Ryan Urbanski
Date Developed: 3/18/2020
Last Date Changed:3/22/2020
Revision: 6
*/
package Services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author James Bristow <jmb1079@psu.edu>
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application
{

    @Override
    public Set<Class<?>> getClasses()
    {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources)
    {
        resources.add(Services.IndividualFacadeREST.class);
    }
    
}
