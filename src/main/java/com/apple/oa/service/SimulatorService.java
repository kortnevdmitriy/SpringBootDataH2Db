package com.apple.oa.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.apple.oa.data.MostPopularProductResponse;
import com.apple.oa.data.MostValuableCustomerResponse;
import com.apple.oa.entity.Customer;
import com.apple.oa.entity.Order;
import com.apple.oa.entity.OrderLine;
import com.apple.oa.entity.Product;
import com.apple.oa.repository.CustomerRepository;
import com.apple.oa.repository.OrderRepository;
import com.apple.oa.repository.ProductRepository;

@Component
public class SimulatorService {

	private static final Logger log = LoggerFactory.getLogger(SimulatorService.class);

	private @Autowired CustomerRepository customerRepository;
	private @Autowired OrderRepository orderRepository;
	private @Autowired ProductRepository productRepository;
	private @Value("${oa.noOfOrders}") Integer noOfOrdersConfigured;

	@Transactional(readOnly = false)
	public void simulate() {
		List<Customer> customers = new ArrayList<>();
		for (int i = 1; i < 11; i++) {
			customers.add(customerRepository.save(new Customer("Test" + i)));
		}

		List<Product> products = new ArrayList<>();
		for (int i = 1; i < 11; i++) {
			products.add(productRepository.save(new Product("Product" + i, (1000.00 * i))));
		}

		for (int noOfOrders = 0; noOfOrders < noOfOrdersConfigured; noOfOrders++) {
			Order order = new Order();
			order.setCustomer(customers.get(0 + (int) (Math.random() * 9)));
			order.setOrderLines(new HashSet<OrderLine>());

			// Generating Random number for number of order lines per order
			int noOfOrderLines = 1 + (int) (Math.random() * 6);
			
			// productsSet is used to generate unique products per order
			Set<Product> productsSet = new HashSet<Product>();
			for (int uniqueProducts = 0; uniqueProducts < noOfOrderLines;) {
				if (productsSet.add(products.get(0 + (int) (Math.random() * 9)))) {
					uniqueProducts++;
				}
			}
			List<Product> productsList = new ArrayList<Product>();
			productsList.addAll(productsSet);
			for (int j = 0; j < noOfOrderLines; j++) {
				order.addOrderLine(new OrderLine(productsList.get(j), (1 + (int) (Math.random() * 5))));
			}
			orderRepository.save(order);
		}

		log.info("Orders : ");
		log.info("-------------------------------");
		for (Order order : orderRepository.findAll()) {
			log.info(order.toString());
		}
		log.info("");

		log.info("Three Most Popular Product in descending order :");
		log.info("-------------------------------");
		Pageable pageable = new PageRequest(0, 3);
		List<MostPopularProductResponse> mostPopularProducts = orderRepository.findThreeMostPopularProducts(pageable);

		for (MostPopularProductResponse mostPopularProduct : mostPopularProducts) {
			log.info(mostPopularProduct.toString());
		}
		log.info("");

		log.info("Most Valuable Customer : ");
		log.info("-------------------------------");
		pageable = new PageRequest(0, 1);
		List<MostValuableCustomerResponse> mostValuableCustomers = orderRepository.findMostValuableCustomer(pageable);

		for (MostValuableCustomerResponse mostValuableCustomer : mostValuableCustomers) {
			log.info(mostValuableCustomer.toString());
		}

		log.info("");

		log.info("Customers : ");
		log.info("-------------------------------");
		for (Customer customer : customerRepository.findAll()) {
			log.info(customer.toString());
		}
		log.info("");
	}
}
