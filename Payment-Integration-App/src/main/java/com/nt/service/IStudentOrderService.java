package com.nt.service;

import java.util.Map;

import com.nt.entity.StudentOrder;

public interface IStudentOrderService {
	
	public StudentOrder createOrder(StudentOrder order) throws Exception;
	public StudentOrder updateOrder(Map<String,String> responsePayLoad);
	public void sendPaymentSuccessEmail(String toEmail,String customerName,String orderId,Double amount);
}
