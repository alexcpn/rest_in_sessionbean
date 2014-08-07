package com.nokia.oss;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Stateless
@Path("/servlet")
public class RestFacade {
	
	@EJB
	MroController mroController;
	

    @GET
    @Path("service1")
    @Produces(MediaType.TEXT_PLAIN)
    public String service1(String test) {
    	return "Hello Form Mro War Packaged Session Bean";
    }
    
    @GET
    @Path("/getciofordn")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCIOforDn(@QueryParam("dn") String dn ){
    	int cio =mroController.getCIOForDN(dn);
    	return new Integer(cio).toString() +" " + dn;
    }
}