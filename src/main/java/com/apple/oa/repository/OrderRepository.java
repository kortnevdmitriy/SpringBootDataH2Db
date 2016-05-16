package com.apple.oa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.apple.oa.data.MostPopularProductResponse;
import com.apple.oa.data.MostValuableCustomerResponse;
import com.apple.oa.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

	@Query("select new com.apple.oa.data.MostPopularProductResponse(ol.product.name as name, count(ol.product.id) as value) from Order o "
			+ "left join o.orderLines ol group by ol.product.id order by value desc")
	List<MostPopularProductResponse> findThreeMostPopularProducts(Pageable pageable);

	@Query("select new com.apple.oa.data.MostValuableCustomerResponse(o.customer.name, sum(ol.product.price * ol.quantity) as value) from "
			+ "Order o left join o.orderLines ol group by o.customer.name order by value desc")
	List<MostValuableCustomerResponse> findMostValuableCustomer(Pageable pageable);

}
