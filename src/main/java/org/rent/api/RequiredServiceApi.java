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

import org.rent.model.Required;
import org.rent.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("/required")
@Component
public class RequiredServiceApi {
	@Autowired
    private Services<Required> services;
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Required getUser(@HeaderParam("Authorization") String authorization,@PathParam("id") int id) {
		return services.getSingleById(id, Required.class);		
	}
	
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Required update(@HeaderParam("Authorization") String authorization ,Required required) {
		return services.update(required);
     }
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Required register(@HeaderParam("Authorization") String authorization ,Required required) {
		return services.save(required);
     }
	
	@DELETE
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public Boolean remove(@HeaderParam("Authorization") String authorization ,@PathParam("id") int id) {
		return services.remove(id,Required.class);
     }
}
