package com.practice.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.springdemo.entity.Customer;
import com.practice.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject the dao into controller
	@Autowired 
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get the customers from the dao
		List<Customer> customers = customerService.getCustomers();
		
		//add customers to the model
		theModel.addAttribute("customers",customers);
		return "list-customers";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer customer = new Customer();
		theModel.addAttribute("customer",customer);
		return "customer-form";
	}
	
	@RequestMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		return "redirect:/customer-list";
	}
}
