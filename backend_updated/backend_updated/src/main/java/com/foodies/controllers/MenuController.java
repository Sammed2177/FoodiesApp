package com.foodies.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.foodies.daos.MenuDao;
import com.foodies.entity.Menu;
import com.foodies.model.AddMenuDto;
import com.foodies.model.AddMenuInDto;
import com.foodies.model.MenuDto;
import com.foodies.model.ResponseDto;
import com.foodies.serviceImpl.MenuServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuServiceImpl menuService;
	
	@Autowired
	private MenuDao repo;

	@PostMapping("/add/{menuTypeid}")
	public ResponseEntity<?> addMenu(AddMenuInDto menuInDto, @PathVariable int menuTypeid) 
	{
		Menu menu = AddMenuInDto.toEntity(menuInDto);
		menu = menuService.addMenu(menu, menuInDto.getImageName(), menuTypeid);
		return new ResponseEntity<>(new ResponseDto<Menu>("Success", menu), HttpStatus.CREATED);
	}

	// successfully working
	@GetMapping("/all")
	public ResponseEntity<?> findAllMenu() {
		List<Menu> list = menuService.findAll();
		System.out.println(list);
		// Stream<ArtistDTO> result = list.stream().map(artist ->
		// ArtistDTO.fromEntity(artist));
		List<AddMenuDto> result = new ArrayList<AddMenuDto>();
		for (Menu menu : list)
			result.add(AddMenuDto.fromEntity(menu));
		System.out.println(result);
		return ResponseDto.success(result);
	}

	@GetMapping("/all/{menuTypeid}")
	public ResponseEntity<?> findAllMenuByType(@PathVariable int menuTypeid) {
		System.out.println(menuTypeid + "  menuTypeid");
		List<Menu> list = menuService.findAllByType(menuTypeid);
		// Stream<ArtistDTO> result = list.stream().map(artist ->
		// ArtistDTO.fromEntity(artist));
		// List<AddMenuDto> result = new ArrayList<AddMenuDto>();
		// for (Menu menu : list)
		// result.add( AddMenuDto.fromEntity(menu) );
		return ResponseDto.success(list);
	}

	// done
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteMenu(@PathVariable int id) {
		String message = menuService.deleteMenu(id);
		return new ResponseEntity<>(new ResponseDto<>("success", message), HttpStatus.CREATED);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editMenu(@RequestBody MenuDto menuDto, @PathVariable int id) {
		System.out.println(menuDto);
		System.out.println(id);
		Menu menu = menuService.editMenu(menuDto, id);
		// System.out.println("----------"+ menu+ "---------------");
		// String message = "success";
		return new ResponseEntity<>(new ResponseDto<>("Success", menu), HttpStatus.OK);
	}

	// @GetMapping("/findmenu")
	// public ResponseEntity<?>findAllMenu(){
	// System.out.println("All menu");
	// return new ResponseEntity<>(menuService.getAllMenu(),HttpStatus.OK);
	// }

}
