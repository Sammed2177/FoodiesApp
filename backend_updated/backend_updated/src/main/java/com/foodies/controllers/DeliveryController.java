/*
 * package com.foodies.controllers;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestMapping;
 * 
 * import com.deliciousbites.server.model.ResponseModel; import
 * com.deliciousbites.server.model.TotalModel; import
 * com.deliciousbites.server.service.*;
 * 
 * @CrossOrigin
 * 
 * @Controller
 * 
 * @RequestMapping("/delivery") public class DeliveryController {
 * 
 * @Autowired private UserService userService;
 * 
 * @Autowired private OrderService orderService;
 * 
 * // delivery dashboard // done and tested
 * 
 * @GetMapping("") public
 * ResponseEntity<com.deliciousbites.server.model.TotalModel>
 * totalCustomerInfo() { int customers = userService.findTotalCustomers(); int
 * deliveryBoy = userService.findTotalDeliveryBoy(); int orders =
 * userService.findTotalOrders(); int revenu = userService.findTotalRevenu();
 * TotalModel t = new TotalModel(); t.setTotalCustomers(customers);
 * t.setTotalDeliveryBoy(deliveryBoy); t.setTotalOrders(orders);
 * t.setTotalRevenu(revenu); return new ResponseEntity<>(t, HttpStatus.OK); }
 * 
 * // all orders for delivery // done and tested
 * 
 * @GetMapping("/orders") public ResponseEntity<?> getAllOrders() { return new
 * ResponseEntity<>(new ResponseModel<>("success", orderService.getAllOrders()),
 * HttpStatus.OK); } }
 */