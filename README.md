# Payment-Integration-App

💳 Payment-Integration-App (Spring Boot + Razorpay)
A full-stack payment gateway integration project built using Spring Boot, Razorpay, MySQL, and Bootstrap, demonstrating real-world payment flow implementation with order management, database persistence, and email notifications.


🚀 Key Features
🔐 Razorpay Payment Gateway Integration
📦 Order creation & payment status tracking
🗄️ MySQL database persistence using Spring Data JPA
📧 Automated email confirmation after successful payment
🌐 Thymeleaf + Bootstrap based responsive UI
🔁 Secure payment callback handling
✅ Success page redirection after payment completion

🛠️ Tech Stack
Backend: Java 21, Spring Boot 3, Spring MVC, Spring Data JPA
Frontend: HTML5, Bootstrap 5, JavaScript
Payment Gateway: Razorpay Checkout
Database: MySQL
Email Service: JavaMailSender (SMTP)
Server: Embedded Tomcat

🔄 Payment Flow
User enters details (Name, Email, Course, Amount)
Order is created on Razorpay from backend
Razorpay Checkout opens securely
Payment is completed by the user
Razorpay callback updates order status in DB
Confirmation email is sent
User is redirected to Payment Success page

📂 Project Highlights
Proper Controller–Service–Repository layered architecture
Uses context-path based routing
Handles real payment callbacks
Implements production-style exception handling
Follows clean code & best practices

📸 Screenshots
<img width="1053" height="567" alt="PaymentPage" src="https://github.com/user-attachments/assets/04a53b3c-a2dc-4925-9fea-99d0c1865096" />


📌 Use Cases
Online course payments
E-commerce checkout prototype
Payment gateway learning project
Interview & portfolio project

👨‍💻 Author

Aniket Gupta
Java Backend Developer | Spring Boot | Microservices

⭐ Why this project?
This project demonstrates real payment integration, not just dummy APIs.
It reflects how payments are handled in production-grade Spring Boot applications.
