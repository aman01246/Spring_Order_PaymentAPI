package com.orderpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
        title = "Order Payment",
        version = "1.0",
        description = "Order Payement Api",
        contact = @Contact(name ="Aman Kumar",email = "aman@gmail.com")))

@SpringBootApplication
public class OrderPaymentOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderPaymentOperationApplication.class, args);
	}

}
