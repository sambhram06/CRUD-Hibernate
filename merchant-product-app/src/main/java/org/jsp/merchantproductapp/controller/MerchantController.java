package org.jsp.merchantproductapp.controller;

import java.util.Scanner;

import org.jsp.merchantproductapp.dao.MerchantDao;
import org.jsp.merchantproductapp.dto.Merchant;

public class MerchantController {

	public static void main(String[] args) {
		MerchantDao dao=new MerchantDao();
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Save Merchanr");
		System.out.println("2.Update Merchant");
		System.out.println("3.Find By Id");
		System.out.println("4.Verify By Phone and Password");
		System.out.println("5.Verify By email and Password");
		switch(sc.nextInt()) {
		case 1:{
			System.out.println("Enter name,phone,email,gst_number and password");
			Merchant m=new Merchant();
			m.setName(sc.next());
			m.setPhone(sc.nextLong());
			m.setEmail(sc.next());
			m.setGst_number(sc.next());
			m.setPassword(sc.next());
			m=dao.SaveMerchant(m);
			System.out.println("Merchant saved with id: "+m.getId());
			break;
		}
		case 2:{
			System.out.println("Enter the Id,name,phone,email,gst_number and password");
			Merchant m=new Merchant();
			m.setId(sc.nextInt());
			m.setName(sc.next());
			m.setPhone(sc.nextLong());
			m.setEmail(sc.next());
			m.setGst_number(sc.next());
			m.setPassword(sc.next());
			m=dao.UpdateMerchant(m);
			if(m!=null) {
				System.out.println("Merchant Updated Successfully");
			}
			else {
				System.out.println("Cannot update Merchant as Id is Invalid");
				break;
			}
		}
		case 3:
		{
			System.out.println("Enter the Merchant Id to display details");
			Merchant merchant=dao.findById(sc.nextInt());
			if(merchant!=null) {
				System.out.println(merchant);
			}
			else {
				System.out.println("Invalud Merchant Id");
				break;
			}
		}
		case 4:
		{
			System.out.println("Enter the phone no and password to verify Merchant details");
			long phone=sc.nextLong();
			String password=sc.next();
			Merchant merchant=dao.verify(phone, password);
			if(merchant!=null) {
				System.out.println(merchant);
			}
			else {
				System.out.println("Invalid phone no or password");
				break;
			}
		}
		case 5:
		{
			System.out.println("Enter the email and password to verify Merchant details");
			String email=sc.next();
			String password=sc.next();
			Merchant merchant=dao.verify(email, password);
			if(merchant!=null) {
				System.out.println(merchant);
			}
			else {
				System.out.println("Invalid email or password");
				break;
			}
		}
		}
	}
}
