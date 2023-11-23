package org.jsp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.dto.Product;
import org.jsp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ProductDao {
	@Autowired
	EntityManager manager ;

	public Product addproduct(Product pro, int id) {
		System.out.println("enter the user id to add product");
		User u = manager.find(User.class, id);
		if (u != null) {
			ArrayList<Product> p = new ArrayList<Product>();
			p.add(pro);
			u.setPro(p);
			pro.setUsers(u);
			manager.persist(pro);
			EntityTransaction t = manager.getTransaction();

			t.begin();
			t.commit();
			return pro;
		}
		return null;

	}

	public List findproduct(int id) {
		User u = manager.find(User.class, id);
		if (u != null) {
			String qry = "select u.pro from User u where u.id=?1";
			Query q = manager.createQuery(qry);
			q.setParameter(1, id);
			return q.getResultList();

		}
		return null;

	}

	public List findproduct(String category) {
		String qry = "select p from Product p where p.category=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, category);

		return q.getResultList();

	}

}
