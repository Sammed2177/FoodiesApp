package com.foodies.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.foodies.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	User findByEmailAndPassword(String email, String password);

	User findByEmail(String email);

	List<User> findByRole(String role);

	// Optional<User> findByEmail(String email);
	// Optional<User> findByResetToken(String resetToken);

	@Query(value = "select count(id) from users;", nativeQuery = true)
	Integer findTotalCustomers();
	
	@Query(value = "select count(id) from orders;", nativeQuery = true)
	Integer findTotalOrders();
	
	@Query(value = "select count(id) from users where role = 'DeliveryBoy';", nativeQuery = true)
	Integer findTotalDeliverBoy();
	
	@Query(value = "select sum(total_price) from orders;", nativeQuery = true)
	Integer findTotalRevenu();
	
	@Query(value = "select count(id) from menu_types;", nativeQuery = true)
	Integer findTotalMenuCategory();
	
	@Query(value = "select count(id) from menu;", nativeQuery = true)
	Integer findTotalMenus();
	
}
