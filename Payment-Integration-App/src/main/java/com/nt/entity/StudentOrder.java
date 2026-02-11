package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor   // ✅ REQUIRED
@AllArgsConstructor  // optional but useful
@Table(name="student_orders")
public class StudentOrder {
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName="stud_seq",allocationSize=1,initialValue=1000)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer orderId;
	

	@Column(length=30)
	private String name;
	
	
	@Column(length=30)
	private String email;
	

	@Column(length=30)
	private String phno;
	
	@NonNull
	@Column(length=30)
	private String course;
	
	
	@Column(length=30)
	private Double amount;
	

	@Column(length=30)
	private String orderStatus;
	
	
	@Column(length=30)
	private String razorpayOrderId;

}
