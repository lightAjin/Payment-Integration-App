package com.nt.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.nt.entity.StudentOrder;
import com.nt.repository.IStudentOrderRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Service
public class StudentOrderServiceImpl implements IStudentOrderService {
	
	@Autowired
	private IStudentOrderRepository studentRepo;
	
    @Autowired
    private JavaMailSender mailSender;

	// For Communication with razorPay
	@Value("${razorpay.key.id}")
	private String razorPayKey;

	@Value("${razorpay.secret.key}")
	private String razorPaySecret;

	// Predefined RazorPayClient class that comes from razorPay dependency
	private RazorpayClient client;



	@Override
	public StudentOrder createOrder(StudentOrder studOrder) throws Exception {

		JSONObject orderReq = new JSONObject();
		orderReq.put("amount", studOrder.getAmount() * 100); // amount in paisa
		orderReq.put("currency", "INR");
		orderReq.put("receipt", studOrder.getEmail());
		this.client = new RazorpayClient(razorPayKey, razorPaySecret);

		// create order in razorpay
		Order razorPayOrder = client.orders.create(orderReq);
		System.out.println(razorPayOrder);

		studOrder.setRazorpayOrderId(razorPayOrder.get("id"));
		studOrder.setOrderStatus(razorPayOrder.get("status"));
		studentRepo.save(studOrder);
		return studOrder;
	}
    
	//Callback method to update the order
	@Override
	public StudentOrder updateOrder(Map<String,String> responsePayLoad) {
		String razorPayOrderId= responsePayLoad.get("razorpay_order_id");
		StudentOrder order=studentRepo.findByRazorpayOrderId(razorPayOrderId);
		order.setOrderStatus("PAYMENT_COMPLETED");
		StudentOrder updateOrder=studentRepo.save(order);
		return updateOrder;
	}

	@Override
	public void sendPaymentSuccessEmail(String toEmail, String customerName, String orderId, Double amount) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Payment Successful - Course Enrollment");

        message.setText(
            "Dear " + customerName + ",\n\n" +
            "Your payment was successful.\n\n" +
            "Order ID: " + orderId + "\n" +
            "Amount Paid: ₹" + amount + "\n\n" +
            "Thank you for enrolling.\n\n" +
            "Regards,\nAniket Enterprises"
        );

        mailSender.send(message);
		
	}
}
