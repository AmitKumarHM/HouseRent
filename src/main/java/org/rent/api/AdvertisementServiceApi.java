package org.rent.api;

import java.util.List;

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

import org.rent.model.Advertisement;
import org.rent.service.AdvertisementService;
import org.rent.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("/adver")
@Component
public class AdvertisementServiceApi {
	@Autowired
    private Services<Advertisement>	services;
	
	@Autowired
    private AdvertisementService advertisementService;
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Advertisement getUser(@HeaderParam("Authorization") String authorization,@PathParam("id") int id) {
		return services.getSingleById(id, Advertisement.class);		
	}
	
	@GET
	@Path("/{user-id}/all")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Advertisement> getUserlist(@HeaderParam("Authorization") String authorization,@PathParam("user-id") int userId) {
		return advertisementService.getByUserId(userId);
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Advertisement update(@HeaderParam("Authorization") String authorization ,Advertisement advertisement) {
		return services.update(advertisement);
     }
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Advertisement register(@HeaderParam("Authorization") String authorization ,Advertisement advertisement) {
		return services.save(advertisement);
     }
	
	@DELETE
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public boolean remove(@HeaderParam("Authorization") String authorization ,@PathParam("id") int id) {
		return services.remove(id,Advertisement.class);
     }
}
