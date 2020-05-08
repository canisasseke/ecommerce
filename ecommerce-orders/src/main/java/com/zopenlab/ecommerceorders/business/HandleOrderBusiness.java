package com.zopenlab.ecommerceorders.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zopenlab.ecommerceorders.beans.CustomerBean;
import com.zopenlab.ecommerceorders.beans.ProductBean;
import com.zopenlab.ecommerceorders.dao.IOrderDAO;
import com.zopenlab.ecommerceorders.dao.IProductItemDAO;
import com.zopenlab.ecommerceorders.models.Orders;
import com.zopenlab.ecommerceorders.models.ProductItem;
import com.zopenlab.ecommerceorders.web.exceptions.OrderNotFoundException;

@Service
public class HandleOrderBusiness implements IHandleOrderBusiness {

	@Autowired
	IOrderDAO orderDAO;
	@Autowired
	IProductItemDAO productItemDAO;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<Orders> getAllOrders() {
		return orderDAO.findAll();
	}
	
	@Override
	public Orders getOrderById(Long orderid) {
		Optional<Orders> optOrder= orderDAO.findById(orderid);
		if(!optOrder.isPresent()) throw new OrderNotFoundException("Order not found");
		return optOrder.get();
	}
	
	@Override
	public Orders getOrderWithDetailsById(Long orderid) {
		Optional<Orders> optOrder= orderDAO.findById(orderid);
		if(!optOrder.isPresent()) throw new OrderNotFoundException("Order not found");
		Orders order = optOrder.get();
		order.setCustomerBean(restTemplate.getForObject("http://ecommerce-customers/customers/"+order.getCustomerid(), CustomerBean.class));
		order.getProductItems().forEach(item -> {
			item.setProductBean(restTemplate.getForObject("http://ecommerce-products/products/"+item.getProductid(), ProductBean.class));
		});
		return order;
	}

	@Override
	public Orders createOrder(Orders order) {
		order.setIsCompleted(false);
		Orders order1 = orderDAO.save(order);
		order.getProductItems().forEach(item -> {
			item.setOrder(order1);
			productItemDAO.save(item);
		});	
		return getOrderById(order1.getId());
	}

	@Override
	public Orders updateOrder(Orders order, Long orderid) {
		Optional<Orders> optOrder= orderDAO.findById(orderid);
		if(!optOrder.isPresent()) throw new OrderNotFoundException("Order not found");
		optOrder.get().getProductItems().clear();
		orderDAO.save(order);
		order.getProductItems().forEach(item -> {
			item.setOrder(order);
			productItemDAO.save(item);
		});
		return getOrderById(order.getId());
	}

	@Override
	public void deleteOrder(Long orderid) {
		Optional<Orders> optOrder= orderDAO.findById(orderid);
		if(!optOrder.isPresent()) throw new OrderNotFoundException("Order not found");
		List<ProductItem> items = optOrder.get().getProductItems();
		if(!items.isEmpty()) {
			items.forEach(item -> {
				productItemDAO.deleteById(item.getId());
			});
		}
		orderDAO.deleteById(orderid);

	}

}
