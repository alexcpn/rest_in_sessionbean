package com.nokia.oss;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;


@Stateless
@Path("sessionbean")
public class MroControllerRest extends Application {

	@EJB
	MroController mroController;
	
    /**
     * Default constructor. 
     */
    public MroControllerRest() {
      
    }
    
    
    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test( ){
    	
    	return "Hello from Mro SessionBean Jar ";
    }

    @GET
    @Path("/getciofordn")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCIOforDn(@QueryParam("dn") String dn ){
    	System.out.println("Dn received=" +dn);
    	int cio =mroController.getCIOForDN(dn);
    	return new Integer(cio).toString() + " Received DN " +dn;
    }

}
