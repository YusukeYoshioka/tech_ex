/**
 */
package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import datamodel.Product;
import datamodel.User;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilDB {
	static SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory != null)
		{
			return sessionFactory;
		}
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	// Create all user list
	public static List<User> listUser()
	{
		List<User> resultList = new ArrayList<User>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;  // each process needs transaction and commit the changes in DB.

		try
		{
			tx = session.beginTransaction();
			List<?> users = session.createQuery("FROM User").list();
			for (Iterator<?> iterator = users.iterator(); iterator.hasNext();)
			{
				User user = (User) iterator.next();
				resultList.add(user);
			}
		tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}

	public static List<User> listUser(String keyword)
	{
		List<User> resultList = new ArrayList<User>();
		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try
		{
			tx = session.beginTransaction();
			System.out.println((User)session.get(User.class, 1)); // use "get" to fetch data
    	  // Query q = session.createQuery("FROM Employee");
			List<?> employees = session.createQuery("FROM User").list();
			for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();)
			{
				User employee = (User) iterator.next();
				if (employee.getName().startsWith(keyword))
				{
					resultList.add(employee);
				}
			}
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}
	
	public static List<Product> listProduct()
	{
		List<Product> resultList = new ArrayList<Product>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;  // each process needs transaction and commit the changes in DB.

		try
		{
			tx = session.beginTransaction();
			List<?> products = session.createQuery("FROM Product").list();
			for (Iterator<?> iterator = products.iterator(); iterator.hasNext();)
			{
				Product product = (Product) iterator.next();
				resultList.add(product);
			}
		tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}
	
	public static List<Product> listProduct(String keyword)
	{
		List<Product> resultList = new ArrayList<Product>();
		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try
		{
			tx = session.beginTransaction();
			System.out.println((Product)session.get(Product.class, 1)); // use "get" to fetch data
    	  // Query q = session.createQuery("FROM Employee");
			List<?> products = session.createQuery("FROM Product").list();
			for (Iterator<?> iterator = products.iterator(); iterator.hasNext();)
			{
				Product product = (Product) iterator.next();
				if (product.getProductName().startsWith(keyword))
				{
					resultList.add(product);
				}
			}
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}
	
	public static List<Product> searchProductID(String keyword)
	{
		List<Product> resultList = new ArrayList<Product>();
		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try
		{
			tx = session.beginTransaction();
			System.out.println((Product)session.get(Product.class, 1)); // use "get" to fetch data
    	  // Query q = session.createQuery("FROM Employee");
			List<?> products = session.createQuery("FROM Product").list();
			for (Iterator<?> iterator = products.iterator(); iterator.hasNext();)
			{
				Product product = (Product) iterator.next();
				if (product.getId() == Integer.valueOf(keyword))
				{
					resultList.add(product);
				}
			}
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}
	
	public static void editProductInfo(String keyword, String newName, String newManu, String newInve)
	{
		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try
		{
			tx = session.beginTransaction();
			System.out.println((Product)session.get(Product.class, 1)); // use "get" to fetch data
    	  // Query q = session.createQuery("FROM Employee");
			
			Product editProduct = (Product)session.get(Product.class, Integer.valueOf(keyword));
			editProduct.setProductName(newName);
			editProduct.setManufacturer(newManu);
			editProduct.setInventroy(Integer.valueOf(newInve));
			
			session.update(editProduct);
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void createUser(String userName, String age, String gender, String email, String address)
	{
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.save(new User(userName, Integer.valueOf(age), gender, email, address));
		tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void createProduct(String productName, String manufacturer, String inventory)
	{
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.save(new Product(productName, manufacturer, Integer.valueOf(inventory)));
		tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
