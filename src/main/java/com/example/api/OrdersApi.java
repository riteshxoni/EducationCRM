package com.example.api;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Orders;
import com.example.service.OrderService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
@RequestMapping("/api")
public class OrdersApi 
{
	@Autowired
	OrderService service;
	
	@PostMapping("/createOrder")
	public ResponseEntity<String> storeOrderDetail(@RequestBody Orders orders) throws RazorpayException
	{
		RazorpayClient razorpay = new RazorpayClient("rzp_test_RWbjjonrGYv3mw", "GMKTaPuZ7BnPwTnLzLM9CovW");

		JSONObject orderRequest = new JSONObject();
		orderRequest.put("amount",orders.getCoursePrice()); // Amount is in currency subunits. 
		orderRequest.put("currency","INR");
		orderRequest.put("receipt", "Reciept Id"+System.currentTimeMillis());

		Order order = razorpay.orders.create(orderRequest);
		
		orders.setOrderId(order.get("id"));
		
		service.createUserOrder(orders);
		return ResponseEntity.ok("Order details stored successfully.");
	}
}
