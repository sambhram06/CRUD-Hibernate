package org.jsp.hibernatetemplatedemo.controller;

import java.util.Scanner;

import org.jsp.hibernatetemplatedemo.dao.MerchantDao;
import org.jsp.hibernatetemplatedemo.dto.Merchant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class MerchantController {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		MerchantDao merchantDao=context.getBean(MerchantDao.class);
		System.out.println("1.Save Merchant");
		System.out.println("2.Update Merchant");
		System.out.println("3.Find By Id");
		System.out.println("4.Delete By Id");
		Scanner sc=new Scanner(System.in);
		switch(sc.nextInt()) {
		case 1:{
			System.out.println("Enter the name,phone,gstnumber,email and password");
			Merchant merchant=new Merchant();
			merchant.setName(sc.next());
			merchant.setPhone(sc.nextLong());
			merchant.setGstnumber(sc.next());
			merchant.setEmail(sc.next());
			merchant.setPassword(sc.next());
			merchant=merchantDao.saveMerchant(merchant);
			System.out.println("merchant saved with id: "+merchant.getId());
			break;
			}
		case 2:{
			System.out.println("Enter the Id,name,phone,gstnumber,email and password");
			Merchant merchant=new Merchant();
			merchant.setId(sc.nextInt());
			merchant.setName(sc.next());
			merchant.setPhone(sc.nextLong());
			merchant.setGstnumber(sc.next());
			merchant.setEmail(sc.next());
			merchant.setPassword(sc.next());
			merchant=merchantDao.updateMerchant(merchant);
			System.out.println("Merchant updated successfully with id:"+merchant.getId());
			break;
		}
		case 3:{
			System.out.println(("Enter Merchant Id to display details"));
			Merchant merchant=merchantDao.findById(sc.nextInt());
			if(merchant!=null) {
				System.out.println(merchant);
			}
			else {
				System.err.println("Invalid Merchant Id");
				break;
			}
		}
		case 4:{
			System.out.println("Enter Merchnat Id to Delete Merchant");
			boolean deleted=merchantDao.delete(sc.nextInt());
			if(deleted) {
				System.out.println("Merchant with entered Id is deleted");
			}
			else {
				System.err.println("Cannot delete merchant has Id Invalid");
				break;
			}
		}
		case 5:{
			for(Merchant m:merchantDao.FindAll()) {
				System.out.println(m);
				System.out.println("--------------");
			}
			break;
		}
		default:{
			System.err.println("Invalid choice");
		}
		}
		sc.close();
		((ClassPathXmlApplicationContext)context).close();
	}
}
