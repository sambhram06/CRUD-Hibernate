package org.jsp.customeraddressapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.customeraddressapp.dto.Address;
import org.jsp.customeraddressapp.dto.Customer;

public class AddressDao {

	EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
	EntityManager manager=factory.createEntityManager();
	
	public Address SaveAdress(Address address,int customer_id) {
		Customer c=manager.find(Customer.class,customer_id );
		EntityTransaction transaction=manager.getTransaction();
		c.getAddress().add(address);
		address.setCustomer(c);
		transaction.begin();
		manager.persist(address);
		transaction.commit();
		return address;
	}
	
	public Address UpdateAddress(Address address) {
		EntityTransaction transaction=manager.getTransaction();
		Address a=manager.find(Address.class, address.getId());
		if(a!=null) {
			a.setName(address.getName());
			a.setBuilding_name(address.getBuilding_name());
			a.setHouse_no(address.getHouse_no());
			a.setType(address.getType());
			a.setCity(address.getCity());
			a.setState(address.getState());
			a.setCountry(address.getCountry());
			a.setPincode(address.getPincode());
			transaction.begin();
			transaction.commit();
		}
		return a;
	}
	
	public Address FindById(int id) {
		return manager.find(Address.class, id);
	}
	
	public List<Address> FindByCustomerId(int customer_id){
		Query q=manager.createQuery("select c.address from Customer c where c.id=?1");
		q.setParameter(1, customer_id);
		return q.getResultList();
	}
	
	public List<Address> FindByCustomerPhAndPw(long phone,String password){
		Query q=manager.createQuery("select c.address from Customer c where c.phone=?1 and c.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		return q.getResultList();
	}
	
	public List<Address> FindByType(String type){
		Query q=manager.createQuery("select a from Address a where c.type=?1");
		q.setParameter(1, type);
		return q.getResultList();
	}
	
}
