package org.jsp.customeraddressapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.customeraddressapp.dto.Customer;

public class CustomerDao {

	EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
	EntityManager manager=factory.createEntityManager();
	
	public Customer SaveCustomer(Customer customer) {
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(customer);
		transaction.commit();
		return customer;
	}
	
	public Customer UpdateCustomer(Customer customer) {
		EntityTransaction transaction=manager.getTransaction();
		Customer c=manager.find(Customer.class, customer.getId());
		if(c!=null) {
			c.setName(customer.getName());
			c.setPhone(customer.getPhone());
			c.setEmail(customer.getEmail());
			c.setAge(customer.getAge());
			c.setGender(customer.getGender());
			c.setPassword(customer.getPassword());
			transaction.begin();
			transaction.commit();
		}
		return c;
	}
	
	public Customer FindById(int id) {
		return manager.find(Customer.class, id);
	}
	
	public List<Customer> Verify(long phone,String password){
		Query q=manager.createQuery("select c from Customer c where c.phone=?1 and c.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
	    return q.getResultList();
	}
	
	public List<Customer> Verify(String email,String password){
		Query q=manager.createQuery("select c from Customer c where c.email=?1 and c.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
	    return q.getResultList();
	}

}
