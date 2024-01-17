package com.foodies.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodies.entity.MenuType;

@Repository
public interface Menu_TypeDao extends JpaRepository<MenuType, Integer> {
	// @Query(value="select id,menu_type from menu_types", nativeQuery=true)
	// public List<MenuType> getAllMenuType();
}
