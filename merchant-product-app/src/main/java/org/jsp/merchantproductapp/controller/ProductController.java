package org.jsp.merchantproductapp.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.merchantproductapp.dao.ProductDao;
import org.jsp.merchantproductapp.dto.Product;

public class ProductController {

	public static void main(String[] args) {
		ProductDao dao=new ProductDao();
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Save Product");
		System.out.println("2.Update Product");
		System.out.println("3.Find Products By Id");
		System.out.println("4.Find Products By Brand");
		System.out.println("5.Find Products By Category");
		System.out.println("6.Find Products By Name");
		System.out.println("7.Find Products By Merchant Id");
		System.out.println("8.Find All Products");
		switch(sc.nextInt()) {
		case 1:{
			System.out.println("Enter the Merchant id to add Product");
			int merchant_id=sc.nextInt();
			System.out.println("Enter name,brand,category,description,Cost and image_url");
			Product p=new Product();
			p.setName(sc.next());
			p.setBrand(sc.next());
			p.setCategory(sc.next());
			p.setDescription(sc.next());
			p.setCost(sc.nextDouble());
			p.setImage_url(sc.next());
			p=dao.SaveProduct(p,merchant_id);
			if(p!=null) 
			System.out.println("Product saved with Id: "+p.getId());
			else
				System.err.println("Cannot add Product as Merchant Id is Invalid");
		}
		break;
		case 2:{
			System.out.println("Enter the Id,name,brand,category,description,cost and image_url");
			Product p=new Product();
			p.setId(sc.nextInt());
			p.setName(sc.next());
			p.setBrand(sc.next());
			p.setCategory(sc.next());
			p.setDescription(sc.next());
			p.setCost(sc.nextDouble());
			p.setImage_url(sc.next());
			p=dao.UpdateProduct(p);
			if(p!=null) {
				System.out.println("Product Saved Successfully");
			}
			else {
				System.out.println("Cannot update Product as Id is Invalid");
			}
		}
		break;
		case 3:{
			System.out.println("Enter the id to find product");
			int id = sc.nextInt();
			Product product = dao.findById(id);
			if (product != null)
				System.err.println(product);
			else
				System.err.println("Invalid Product Id");
			break;
		}
		case 4:{
			System.out.println("Enter the brand to find product");
			String brand = sc.next();
			List<Product> product = dao.findByBrand(brand);
			if (product.isEmpty())
				System.err.println("No Product found with entered brand");
			else
				for(Product p:product) {
				System.out.println(p);
			System.out.println("=================");
				}
			break;
		}
		case 5:{
			System.out.println("Enter the category to find product");
			String category = sc.next();
			List<Product> product = dao.findByCategory(category);
			if (product.isEmpty())
				System.err.println("No Product found with entered category");
			else
				for(Product p:product) {
				System.out.println(p);
			System.out.println("=================");
				}
			break;
		}

		case 6:{
			System.out.println("Enter the name to find product");
			String name = sc.next();
			List<Product> product = dao.findByName(name);
			if (product.isEmpty())
				System.err.println("No Product found with entered name");
			else
				for(Product p:product) {
				System.out.println(p);
			System.out.println("=================");
				}
			break;
		}

		case 7:{
			System.out.println("Enter the merchant id to find product");
			int merchant_id = sc.nextInt();
			List<Product> product = dao.findByMerchantId(merchant_id);
			if (product.isEmpty())
				System.err.println("No Product found with entered merchant id");
			else
				for(Product p:product) {
				System.out.println(p);
			System.out.println("=================");
				}
			break;
		}
		
		case 8:{
			List<Product> product = dao.findAll();
			if (product.isEmpty())
				System.err.println("No Product found");
			else
				for(Product p:product) {
				System.out.println(p);
			System.out.println("=================");
				}
			break;
		}
		default: {
			sc.close();
			System.err.println("Invalid Choice");
		}
		}
	}
}
