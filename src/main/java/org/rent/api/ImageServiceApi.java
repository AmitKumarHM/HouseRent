package org.rent.api;

import java.io.InputStream;

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

import org.rent.base.BaseController;
import org.rent.model.AccessToken;
import org.rent.model.Advertisement;
import org.rent.model.Image;
import org.rent.model.User;
import org.rent.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/image")
@Component
public class ImageServiceApi extends BaseController{
	@Autowired
    private Services<Image> services;
	
	@Autowired
    private Services<Advertisement>	advServices;
	
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
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.MULTIPART_FORM_DATA,MediaType.APPLICATION_JSON})
	public Image register(@PathParam("id") Integer id,@FormDataParam("image") InputStream fileInputString,@FormDataParam("image") FormDataContentDisposition fileDetail,@HeaderParam("Authorization") String authorization ,@HeaderParam("userId") Integer userId) {
		AccessToken accessToken=new AccessToken();
		accessToken.setAccessToken(getAccsessToken(authorization));
		accessToken.setUser(new User(userId));
		accessToken=validateAccessToken(accessToken);
		Image image=null;
		if(accessToken!=null){
			Advertisement adver= advServices.getSingleById(id, Advertisement.class);
			image=writeToFileAdvertisement(fileInputString,fileDetail.getFileName(),adver,accessToken.getUser());
			image.setAdvertisement(adver);
			image=services.save(image);
		}
		return image;
     }
	


	@DELETE
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public Boolean remove(@HeaderParam("Authorization") String authorization ,@PathParam("id") int id) {
		return services.remove(id,Image.class);
     }
}
