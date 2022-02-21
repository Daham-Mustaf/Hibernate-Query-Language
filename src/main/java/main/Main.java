package main;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import main.entity.Employee;


import main.utils.HibernateUtil;

public class Main {
	public static void main(String[] args) throws ParseException {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		
			session.beginTransaction();
			Employee employee1 = new Employee();
			employee1.setEmployeeName("Daham Mustafa");
			employee1.setDesignation("IT Manager");
			employee1.setDoj(new Date());
			employee1.setEmail("daham.m2007@yahoo.com");
			employee1.setBonus(new BigDecimal(2000));
			employee1.setSalary(90000.00);
	
			Employee employee2 = new Employee();
			employee2.setEmployeeName("Ali Hadi");
			employee2.setDesignation("IT Developer");
			employee2.setDoj(new Date());
			employee2.setEmail("ali.b2017@gmail.com");
			employee2.setBonus(new BigDecimal(1000));
			employee2.setSalary(40000.00);
			
			session.save(employee1);
			session.save(employee2);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
