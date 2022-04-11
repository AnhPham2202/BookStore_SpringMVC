package com.bookstore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.OrderDAO;
import com.bookstore.dao.OrderDetailDAO;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.OrderDetail;

@Service
public class OrderService {

	@Autowired
	OrderDAO orderDao;
	
	@Autowired
	OrderDetailDAO orderDetailDAO;
	
	public List<BookOrder> listOrder() {
		return orderDao.listAllWithNamedQuery("getAllBookOrders");
	}
	
	public List<OrderDetail> getOrderDetailByOrderId(int id) {
		Map<String, Object> paramsList = new HashMap<String, Object>();
		paramsList.put("orderId", id);
		return orderDetailDAO.queryWithManyParamsListResult("getOrderDetailByOrderId", paramsList);
	}
	
	public void removeOrder(int id) {
		orderDao.delete(BookOrder.class, id);
	}
	
	public BookOrder getOrderById(int id) {
		return orderDao.find(BookOrder.class, id);
	}
	
	public void updateOrder(HttpServletRequest request, int id) {
		BookOrder order = getOrderById(id);
		String  recipientName = request.getParameter("recipientName");
		String  recipientPhone = request.getParameter("recipientPhone");
		String  address = request.getParameter("address");
		String  paymentMethod = request.getParameter("payment-method");
		float  total = Float.parseFloat(request.getParameter("total")) ;
		String  status = request.getParameter("status");
		
		order.setRecipientName(recipientName);
		order.setRecipientPhone(recipientPhone);
		order.setShippingAddress(address);
		order.setPaymentMethod(paymentMethod);
		order.setTotal(total);
		order.setStatus(status);
		
		orderDao.update(order);
	}
	
}
