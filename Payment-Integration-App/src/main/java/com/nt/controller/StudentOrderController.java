package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nt.entity.StudentOrder;
import com.nt.service.StudentOrderServiceImpl;

@Controller
public class StudentOrderController {

	@Autowired
	private StudentOrderServiceImpl service;
	
	@GetMapping("/")
	public String home() {
		//return LVN
		return "index";
	}
	

	@PostMapping(value="/create-order",produces="application/json")
	@ResponseBody
	public ResponseEntity<StudentOrder> createOrder(@RequestBody StudentOrder studentOrder) throws Exception{
		StudentOrder createdOrder=service.createOrder(studentOrder);
		return new ResponseEntity<>(createdOrder,HttpStatus.CREATED);
	}

	//Callback method after successfull completion
	@PostMapping("/handle-payment-callback")
	public String handlePaymentCallback(@RequestParam Map<String,String> resPayload) {
		System.out.println(resPayload);
		StudentOrder updateOrder=service.updateOrder(resPayload);
		//For Sending mail as response
		service.sendPaymentSuccessEmail(
				updateOrder.getEmail(),
				updateOrder.getName(),
				updateOrder.getRazorpayOrderId(),
				updateOrder.getAmount()
	    );
		return "success";
	}	
}
