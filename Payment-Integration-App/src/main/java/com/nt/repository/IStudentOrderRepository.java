package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.StudentOrder;

public interface IStudentOrderRepository extends JpaRepository<StudentOrder, Integer> {

	public StudentOrder findByRazorpayOrderId(String orderId);
}
