package org.rent.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rent.model.Furnished;
import org.rent.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("/furnished")
@Component
public class FurnishedServiceApi {
	@Autowired
    private Services<Furnished> services;
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Furnished getUser(@HeaderParam("Authorization") String authorization,@PathParam("id") int id) {
		return services.getSingleById(id, Furnished.class);		
	}
	
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Furnished update(@HeaderParam("Authorization") String authorization ,Furnished furnished) {
		return services.update(furnished);
     }
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Furnished register(@HeaderParam("Authorization") String authorization ,Furnished furnished) {
		return services.save(furnished);
     }
	
	@DELETE
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public Boolean remove(@HeaderParam("Authorization") String authorization ,@PathParam("id") int id) {
		return services.remove(id,Furnished.class);
     }
}
