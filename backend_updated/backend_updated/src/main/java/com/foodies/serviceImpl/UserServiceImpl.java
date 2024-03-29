package com.foodies.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodies.daos.UserDao;

import com.foodies.entity.User;


@Transactional
@Service
public class UserServiceImpl {
	@Autowired
	private UserDao userdao;

	public User findByEmail(String email) {
		return userdao.findByEmail(email); 
	}

	 
	public User save(User u) {
		return userdao.save(u);
	}

	 
	public User authenticate(String email, String password) {
		User u=findByEmail(email);
				if(u!=null && u.getPassword().equals(password))
					return u;
		return null;
	}

	 
	public User update(User u) {
		return userdao.save(u);
	}

	 
	public String deleteById(int id) {
		if(userdao.existsById(id)) {
			userdao.deleteById(id);
			return "success";
		}
	return "failed";
	}

	 
	public List<User> findAll() {
		return userdao.findAll();
	}

	 
	public User finById(int uid) {
		return userdao.getById(uid);
	}

	 
	public Integer findTotalCustomers() {
	
		return userdao.findTotalCustomers();
	}
	
	public Integer findTotalOrders() {
		
		return userdao.findTotalOrders();
	}
	
	public Integer findTotalDeliveryBoy() {
		
		return userdao.findTotalDeliverBoy();
	}
	
	public Integer findTotalRevenu() {
		
		return userdao.findTotalRevenu();
	}
	
	public Integer findTotalMenuCategory() {
		
		return userdao.findTotalMenuCategory();
	}

	public Integer findTotalMenus() {
	
		return userdao.findTotalMenus();
	}

	 
	public User ceateNewUser(User user) {
		return userdao.save(user);
	}	
	
	public List<User> getAllUser(String role) {
		return userdao.findByRole(role);
	}

	 
	public List<User> getAllDeliveryBoy(String role) {
		
		return userdao.findByRole(role);
	}

	 
	public User findUser(int userId) {
		Optional<User> user = userdao.findById(userId);
		return user.orElse(null);
	}

	 
	public String updatePassword(String email, String password) {
		User user = userdao.findByEmail(email);
		 user.setPassword(password);
		return "password Changed Successfully!!!";

	}


//	 
//	public Optional findUserByEmail(String email) {
//		return userdao.findByEmail(email);
//	}
//
//	 
//	public Optional findUserByResetToken(String resetToken) {
//		return userdao.findByResetToken(resetToken);
//	}

}
