
package com.xdev.jasperreportexample_v12.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.rapidclipse.framework.server.jpa.dal.JpaDataAccessObject;
import com.xdev.jasperreportexample_v12.domain.Category_;
import com.xdev.jasperreportexample_v12.domain.Product;
import com.xdev.jasperreportexample_v12.domain.Product_;
import com.xdev.jasperreportexample_v12.domain.queryObjects.ProductCategorySum;


/**
 * Home object for domain model class Product.
 *
 * @see Product
 */
public class ProductDAO extends JpaDataAccessObject.Default<Product, Integer>
{
	public final static ProductDAO INSTANCE = new ProductDAO();
	
	public ProductDAO()
	{
		super(Product.class);
	}
	
	public List<Product> getProductsOrderedByCategory()
	{
		final EntityManager entityManager = this.em();

		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		final CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);

		final Root<Product> root = criteriaQuery.from(Product.class);

		criteriaQuery.orderBy(criteriaBuilder.asc(root.get(Product_.category).get(Category_.categoryid)));

		final TypedQuery<Product> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	public List<ProductCategorySum> getProductsForChart()
	{
		final EntityManager entityManager = this.em();

		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		final CriteriaQuery<ProductCategorySum> criteriaQuery = criteriaBuilder.createQuery(ProductCategorySum.class);

		final Root<Product> root = criteriaQuery.from(Product.class);

		criteriaQuery.multiselect(criteriaBuilder.sum(root.get(Product_.unitprice)), root.get(Product_.category));

		criteriaQuery.groupBy(root.get(Product_.category));

		final TypedQuery<ProductCategorySum> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
}
