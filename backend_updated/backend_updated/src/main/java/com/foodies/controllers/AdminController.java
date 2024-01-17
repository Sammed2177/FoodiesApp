package com.foodies.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodies.entity.User;
import com.foodies.model.ResponseDto;
import com.foodies.model.TotalMenuInfo;
import com.foodies.model.TotalModel;
import com.foodies.model.UserDto;
import com.foodies.serviceImpl.UserServiceImpl;

@CrossOrigin
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/userList")
	public ResponseEntity<?> findAllUsers() {
		List<User> userlist = userService.getAllUser("customer");
		List<UserDto> result = new ArrayList<UserDto>();
		for (User user : userlist)
			result.add(UserDto.fromEntity(user));
		return ResponseDto.success(result);

	}

	@GetMapping("/deliveryBoyList")
	public ResponseEntity<?> findAllDeliveryBoy() {
		List<User> userlist = userService.getAllDeliveryBoy("deliveryBoy");
		List<UserDto> result = new ArrayList<UserDto>();
		for (User user : userlist)
			result.add(UserDto.fromEntity(user));
		return ResponseDto.success(result);

	}
	
	
	@GetMapping("/totalCustomerInfo")
	public ResponseEntity<TotalModel> totalCustomerInfo() {
		
		int customers = userService.findTotalCustomers();
		int deliveryBoy = userService.findTotalDeliveryBoy();
		int orders = userService.findTotalOrders();
		int revenu = userService.findTotalRevenu();
		
		TotalModel t = new TotalModel();
		t.setTotalCustomers(customers);
		t.setTotalDeliveryBoy(deliveryBoy);
		t.setTotalOrders(orders);
		t.setTotalRevenu(revenu);
		return new ResponseEntity<>(t, HttpStatus.OK);
	}
	
	@GetMapping("/totalMenuInfo")
	public ResponseEntity<TotalMenuInfo> totalMenuInfo() {
		
		int menuCategory = userService.findTotalMenuCategory();
		int menu = userService.findTotalMenus();
	
		TotalMenuInfo t = new TotalMenuInfo();
		t.setTotalCategory(menuCategory);
		t.setTotalMenuItems(menu);
		return new ResponseEntity<>(t, HttpStatus.OK);
	}
	
	
}
