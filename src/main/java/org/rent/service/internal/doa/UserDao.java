package org.rent.service.internal.doa;

import java.util.List;

import org.rent.model.User;

public interface UserDao {

List<User> findUserList(); 
User findUser(int id);
}
