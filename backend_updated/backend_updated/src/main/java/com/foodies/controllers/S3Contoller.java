package com.foodies.controllers;

import com.foodies.entity.Menu;
import com.foodies.model.AddMenuInDto;
import com.foodies.model.ResponseDto;
import com.foodies.serviceImpl.MenuServiceImpl;
import com.foodies.serviceImpl.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S3Contoller {

	@Autowired
	private MenuServiceImpl menuService;
	
	@Autowired
	private S3Service s3Service;;
	
	
	
	@PostMapping("/add/{menuTypeid}")
	public ResponseEntity<?> addMenu(AddMenuInDto menuInDto, @PathVariable int menuTypeid) {
		System.out.println(menuTypeid);
		Menu menu = AddMenuInDto.toEntity(menuInDto);
		menu = menuService.addMenu(menu, menuInDto.getImageName(), menuTypeid);
		return new ResponseEntity<>(new ResponseDto<Menu>("Success", menu), HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("{filename}")
	public  String deleteFile(@PathVariable("filename") String filename){
	   return s3Service.deleteFile(filename);
	}
	
}
