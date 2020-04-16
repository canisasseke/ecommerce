package com.zopenlab.ecommerceorders.business;

import java.util.List;

import com.zopenlab.ecommerceorders.models.Orders;


public interface IHandleOrderBusiness {
	
	public List<Orders> getAllOrders();
	public Orders getOrderWithDetailsById(Long orderid);
	public Orders getOrderById(Long orderid);
	public Orders updateOrder(Orders order, Long orderid);
	public void deleteOrder(Long orderid);
	public Orders createOrder(Orders order);

}
