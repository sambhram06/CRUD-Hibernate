package org.jsp.customeraddressapp.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.customeraddressapp.dao.CustomerDao;
import org.jsp.customeraddressapp.dto.Customer;

public class CustomerController {

	public static void main(String[] args) {
		CustomerDao dao=new CustomerDao();
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Save Customer");
		System.out.println("2.Update Customer");
		System.out.println("3.Find Customer By Id");
		System.out.println("4.Verify Customer By Phone no and password");
		System.out.println("5.Verify Customer By Email and Password");
		switch(sc.nextInt()) {
		case 1:{
			System.out.println("Enter Customer name,phone,email,age,gender and password");
			Customer c=new Customer();
			c.setName(sc.next());
			c.setPhone(sc.nextLong());
			c.setEmail(sc.next());
			c.setAge(sc.nextInt());
			c.setGender(sc.next());
			c.setPassword(sc.next());
			c=dao.SaveCustomer(c);
					System.out.println("Customer data Saved with Id: "+c.getId());
		}
		break;

		
		case 2:{
			System.out.println("Enter name,phone,email,age,gender and password");
			Customer c=new Customer();
			c.setId(sc.nextInt());
			c.setName(sc.next());
			c.setPhone(sc.nextLong());
			c.setEmail(sc.next());
			c.setAge(sc.nextInt());
			c.setGender(sc.next());
			c.setPassword(sc.next());
			c=dao.UpdateCustomer(c);
			if(c!=null) {
				System.out.println("Customer Data Updated Successfully");
			}
			else {
				System.err.println("Cannot Update Customer Id Is Invalid");
			}
			break;
		}
		
		case 3:{
			System.out.println("Enter the customer id");
			int id=sc.nextInt();
			Customer c=new Customer();
			c=dao.FindById(id);
			if(c!=null) {
				System.out.println(c);
			}
			else {
				System.err.println("Cannot find customer Id is Invalid");
			}
			break;
		}
		
		case 4:{
			System.out.println("Enter the phone no and password to verify");
			long phone=sc.nextLong();
			String password=sc.next();
			List<Customer> c=dao.Verify(phone, password);
			if(c!=null) {
				System.out.println("Data Verified Successfully");
			}
			else {
				System.err.println("Inavlid phone no or password");
			}
			break;
		}
		
		case 5:{
			System.out.println("Enter the email and password to verify");
			String email=sc.next();
			String password=sc.next();
			List<Customer> c=dao.Verify(email, password);
			if(c!=null) {
				System.out.println("Data Verified Successfully");
			}
			else {
				System.err.println("Inavlid email or password");
			}
			break;
		}

	}
}
}
