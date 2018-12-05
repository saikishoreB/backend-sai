package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

public class CategoryDAOTestCase 
{
	
	static CategoryDAO categoryDAO;
	private static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void executeFirst()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.ecomm");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("WindowCurtain");
		category.setCategorydesc("Various Variety of Window Curtains");
		
		assertTrue("Problem in Adding the Category",categoryDAO.add(category));
	}
	
	
	@Test
	public void updateCategoryTest()
	{	
		Category category=categoryDAO.getCategory(2);
		category.setCategorydesc("ash Basin and Front Glasses");	
		assertTrue("Problem in Updating the Category",categoryDAO.update(category));
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(2);
		assertTrue("Problem in Updating the Category",categoryDAO.delete(category));
	}
	
	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories=categoryDAO.ListCategories();
		
		assertTrue("Problem in Listing the Categories",listCategories.size()>0);
		
		for(Category category:listCategories)
		{
			System.out.print("Category ID:"+category.getCategoryId());
			System.out.print("Category Name:"+category.getCategoryName());
			System.out.println("Category Desc:"+category.getCategorydesc());
		}
	}
	
}



