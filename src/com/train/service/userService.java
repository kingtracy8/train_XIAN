package com.train.service;

import com.train.dao.userDao;
import com.train.model.userModel;

public class userService {

	userDao dao = new userDao();

	public int save(userModel model) throws Exception {
		return dao.save(model);
	}

	public userModel selectByName(String userName) throws Exception {
		return dao.selectByName(userName);
	}

	public userModel selectByNameAndPass(userModel model) throws Exception {
		return dao.selectByNameAndPass(model);
	}

}
