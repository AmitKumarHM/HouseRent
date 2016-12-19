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

import org.rent.model.Message;
import org.rent.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("/message")
@Component
public class MessageServiceApi {
	@Autowired
    private Services<Message> services;
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Message getUser(@HeaderParam("Authorization") String authorization,@PathParam("id") int id) {
		return services.getSingleById(id, Message.class);		
	}
	
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Message update(@HeaderParam("Authorization") String authorization ,Message message) {
		return services.update(message);
     }
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Message register(@HeaderParam("Authorization") String authorization ,Message message) {
		return services.save(message);
     }
	
	@DELETE
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public Boolean remove(@HeaderParam("Authorization") String authorization ,@PathParam("id") int id) {
		return services.remove(id,Message.class);
     }
}
