package com.example.MusicApplication.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.razorpay.RazorpayClient;

@Controller
public class PaymentController {
	@PostMapping("/createOrder")
	public String createOrder() {
		
		try {

 RazorpayClient razorpay = new RazorpayClient("rzp_test_1BhLXVQ2hF6cOM", "TzRGjYfjx5QOm7owIik9p2fL");

		JSONObject orderRequest = new JSONObject();

		orderRequest.put("amount",50000);

		orderRequest.put("currency", "INR");

		orderRequest.put("receipt", "receipt#1"); 
		JSONObject notes = new JSONObject();
		notes.put("notes_key_1", "Tea, Earl Grey, Hot");

		orderRequest.put("notes", notes);
		}

		catch(Exception e) {
		System.out.println("exception while crteating order");

		}

		return "order";

		}
	}

