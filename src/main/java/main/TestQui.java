package main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import main.entity.Employee;
import main.utils.HibernateUtil;

public class TestQui {
	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		// getingAllEmployees(sf);
		getEmployeeById(sf);
	}

	private static void getEmployeeById(SessionFactory sf) {
		int empId = 2;
		try (Session session = sf.openSession()) {
			String HQL = "FROM Employee WHERE employeeId=:employee_id";
			Query<Employee> query = session.createQuery(HQL, Employee.class);
			query.setParameter(1, empId);

			Employee employee = query.uniqueResult();
			System.out.println(employee);
		}

	}

	private static void getingAllEmployees(SessionFactory sf) {

		try (Session session = sf.openSession()) {
			String HQL = "FROM Employee";
			Query<Employee> query = session.createQuery(HQL, Employee.class);
			List<Employee> list = query.list();
			list.forEach(System.out::println);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
