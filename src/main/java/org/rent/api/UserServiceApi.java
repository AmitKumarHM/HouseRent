package org.rent.api;

import java.io.InputStream;
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

import org.rent.base.BaseController;
import org.rent.model.AccessToken;
import org.rent.model.User;
import org.rent.service.Services;
import org.rent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
 
@Path("/user")
@Component
public class UserServiceApi extends BaseController{

	@Autowired
    private UserService	userService;
	
	@Autowired
    private Services<User> services;
	
	@GET
	@Path("/{id}")
	@Produces({"application/json"})
	public User getUser(@PathParam("id") Integer id) {
		return userService.getUser(id);		
	}
	
	@GET
	@Path("/all")
	@Produces({"application/json"})
	public List<User> getUserlist() {
		return userService.getUserList();
	}
	
	@POST
	@Path("/login")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public AccessToken login(User user) {
		User persistedUser=userService.getByEmailAndPwd(user);
		if(persistedUser!=null){
			AccessToken accessToken=createAccsessToken(persistedUser);
			Integer id =accessTokenService.save(accessToken);
			if(id!=null)
				return accessToken;
		}
		return null;
	}
	
	@POST
	@Path("/forget")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Boolean forget(User user) {
		return userService.getByEmail(user)!=null?true:false;
	}
	
	
	@POST
	@Path("/reset")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Boolean reset(@HeaderParam("Authorization") String authorization, @HeaderParam("userId") Integer userId ,User user) {
		AccessToken accessToken=new AccessToken();
		accessToken.setAccessToken(getAccsessToken(authorization));
		accessToken.setUser(new User(userId));
		accessToken=validateAccessToken(accessToken);
		if(accessToken!=null){
			return services.update(user)!=null?true:false;
		}
		return false;
	}
	
	
	
	@POST
	@Path("/upload")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public User upload(@FormDataParam("image") InputStream fileInputString,@FormDataParam("image") FormDataContentDisposition fileDetail,@HeaderParam("Authorization") String authorization, @HeaderParam("userId") Integer userId) {
		AccessToken accessToken=new AccessToken();
		accessToken.setAccessToken(getAccsessToken(authorization));
		accessToken.setUser(new User(userId));
		accessToken=validateAccessToken(accessToken);
		if(accessToken!=null){
			 writeToFile(fileInputString,fileDetail.getFileName(),accessToken.getUser());
			 services.update(accessToken.getUser());
		}
		return accessToken.getUser();
     }
	
	
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Boolean update(@HeaderParam("Authorization") String authorization, @HeaderParam("userId") Integer userId ,User user) {
		AccessToken accessToken=new AccessToken();
		accessToken.setAccessToken(getAccsessToken(authorization));
		accessToken.setUser(new User(userId));
		accessToken=validateAccessToken(accessToken);
		if(accessToken!=null){
			return services.update(user)!=null?true:false;
		}
		return false;
     }
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public AccessToken register(User user) {
		 User persistedUser=services.save(user);
		 if(persistedUser!=null){
				AccessToken accessToken=createAccsessToken(persistedUser);
				Integer id =accessTokenService.save(accessToken);
				if(id!=null)
					return accessToken;
			}
		return null;
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public Boolean remove(@HeaderParam("Authorization") String authorization , @HeaderParam("userId") Integer userId ,@PathParam("id") int id) {
		return services.remove(id,User.class);
     }
	
}
