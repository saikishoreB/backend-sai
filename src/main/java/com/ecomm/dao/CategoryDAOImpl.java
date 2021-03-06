package com.ecomm.dao;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ecomm.model.Category;
@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	SessionFactory sessionFactory;

	public List<Category> findAllCategories() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public Category findCategoryById(int CategoryId) {
		return (Category)sessionFactory.getCurrentSession().createQuery("from Category where CategoryId="+CategoryId).uniqueResult();
	}

	public Category findCategoryByName(String CategoryName) {
		return (Category)sessionFactory.getCurrentSession().createQuery("from Category where CategoryName='"+CategoryName+"'").uniqueResult();
	}

	public boolean addCategory(Category category) {
		sessionFactory.getCurrentSession().save(category);
		return true;
	}

	public boolean updateCategory(Category category) {
		sessionFactory.getCurrentSession().update(category);
		return true;
	}

	public boolean deleteCategory(int categoryId) {
		sessionFactory.getCurrentSession().delete(findCategoryById(categoryId));	
		return true;
	}

	public boolean add(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Category> ListCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	public Category getCategory(int categoryid) {
		// TODO Auto-generated method stub
		return null;
	}


}
