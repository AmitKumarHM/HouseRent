package org.rent.service.internal;

import java.util.List;

import org.rent.model.User;
import org.rent.service.UserService;
import org.rent.service.internal.doa.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
	private UserDao userDao;
	public List<User> getUserList() {
		return userDao.findUserList();
	}
	public User getUser(int id) {		
		return userDao.findUser(id);
	}
	@Override
	public User getByEmailAndPwd(User user) {
		return userDao.findByEmailAndPwd(user);
	}
	@Override
	public User getByEmail(User user) {
		return userDao.findByEmail(user);
	}

}
