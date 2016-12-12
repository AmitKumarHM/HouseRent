package org.rent.service;

import java.util.List;

import org.rent.model.User;

public interface UserService {

List<User> getUserList(); 
User getUser(int id);
}
