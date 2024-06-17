package org.jsp.customeraddressapp.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.customeraddressapp.dao.AddressDao;
import org.jsp.customeraddressapp.dto.Address;
import org.jsp.customeraddressapp.dto.Customer;

public class AddressController {

	public static void main(String[] args) {
		AddressDao dao=new AddressDao();
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Save Address");
		System.out.println("2.Update Address");
		System.out.println("3.Find Address By Id");
		System.out.println("4.Find Address By Customer Id");
		System.out.println("5.Find Address By Customer Phone and password");
		System.out.println("6.Find Address By Type");
		switch(sc.nextInt()) {
		case 1:{
			System.out.println("Enter the Customer Id to add Address");
			int customer_id=sc.nextInt();
			System.out.println("Enter name, building_name, house_no,type,city,state,country,pincode");
			Address a=new Address();
			a.setName(sc.next());
			a.setBuilding_name(sc.next());
			a.setHouse_no(sc.nextInt());
			a.setType(sc.next());
			a.setCity(sc.next());
			a.setState(sc.next());
			a.setCountry(sc.next());
			a.setPincode(sc.nextInt());
			a=dao.SaveAdress(a,customer_id);
			System.out.println("Address data saved with Id: "+a.getId());
		}
		break;
		
		case 2:{
			System.out.println("Enter name, building_name, house_no,type,city,state,country,pincode");
			Address a=new Address();
			if(a!=null) {
				a.setName(sc.next());
				a.setBuilding_name(sc.next());
				a.setHouse_no(sc.nextInt());
				a.setType(sc.next());
				a.setCity(sc.next());
				a.setState(sc.next());
				a.setCountry(sc.next());
				a.setPincode(sc.nextInt());
				a=dao.UpdateAddress(a);
				System.out.println("Address Data Updated Successfully");
			}
				else {
					System.err.println("Cannont Updated the Address data");
				}
			break;
			}
		case 3:
		{
			System.out.println("Enter the Id");
			int id=sc.nextInt();
			Address a=new Address();
			a=dao.FindById(id);
			if(a!=null) {
				System.out.println(a);
			}
			else {
				System.err.println("Cannot find Address Id is Invalid");
			}
			break;
		}
		
		case 4:{
			System.out.println("Enter the Customer id to display Address details");
			int customer_id=sc.nextInt();
			List<Address> a=dao.FindByCustomerId(customer_id);
			if(a!=null) {
				System.out.println(a);
			}
			else {
				System.err.println("Cannont find address as invalid customer id");
			}
			break;
		}
		
		case 5:
		{
			System.out.println("Enter the Customer Phone no and password");
			long phone=sc.nextLong();
			String password=sc.next();
			List<Address> a=dao.FindByCustomerPhAndPw(phone, password);
			if(a!=null) {
				System.out.println(a);
			}
			else {
				System.err.println("Cannont find address as invalid phone number or password");
			}
			break;
		}
		
		case 6:{
			System.out.println("Enter the address type");
			String type=sc.next();
			List<Address> a=dao.FindByType(type);
			if(a!=null) {
				System.out.println(a);
			}
			else {
				System.err.println("Cannont find the type of Address");
			}
		}
		}
		}
	}

