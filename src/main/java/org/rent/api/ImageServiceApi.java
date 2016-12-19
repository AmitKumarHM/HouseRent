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

import org.rent.model.Image;
import org.rent.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("/image")
@Component
public class ImageServiceApi {
	@Autowired
    private Services<Image> services;
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Image getUser(@HeaderParam("Authorization") String authorization,@PathParam("id") int id) {
		return services.getSingleById(id, Image.class);		
	}
	
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Image update(@HeaderParam("Authorization") String authorization ,Image image) {
		return services.update(image);
     }
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Image register(@HeaderParam("Authorization") String authorization ,Image image) {
		return services.save(image);
     }
	
	@DELETE
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public Boolean remove(@HeaderParam("Authorization") String authorization ,@PathParam("id") int id) {
		return services.remove(id,Image.class);
     }
}
