package com.train.dao;

import java.sql.ResultSet;

import com.train.model.userModel;

public class userDao {

	DBHelper helper = new DBHelper();

	public int save(userModel model) throws Exception {

		String sql = "INSERT INTO `user`(userName,userPassWord) VALUES(?,?)";

		Object [] values = {model.getUserName(),model.getPassWord()};

		int flag = 0;
		try {
			flag =  helper.execueUpdate(sql, values);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			helper.close();
		}

		return flag;

	}
	
	
	public userModel selectByName(String userName) throws Exception {
		userModel model = new userModel();
		String sql = "SELECT * FROM user WHERE userName = ?";
		Object [] values = {userName};
		try {
			ResultSet rs = helper.executeQuery(sql, values);
			if(rs.next()){
				model.setUserName(rs.getString("userName"));
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			helper.close();
		}
		return model;
	}


	public userModel selectByNameAndPass(userModel model) throws Exception {
		
		userModel md = new userModel();
		String sql = "SELECT * FROM user WHERE userName = ? AND userPassWord = ?";
		Object [] values = {model.getUserName(),model.getPassWord()};
		
		try {
			ResultSet rs = helper.executeQuery(sql, values);
			if(rs.next()){
				md.setUserName(rs.getString("userName"));
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			helper.close();
		}
		
		return md;
	}
	

}
