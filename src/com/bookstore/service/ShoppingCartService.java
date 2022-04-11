package com.bookstore.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.dao.OrderDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;
import com.bookstore.entity.OrderDetail;
import com.bookstore.entity.OrderDetailId;
import com.bookstore.entity.ShoppingCart;

@Service
@Transactional
public class ShoppingCartService {
	
	@Autowired
	OrderDAO dao;
	
	public void createOrder(HttpServletRequest request) {
		String  recipientName = request.getParameter("recipientName");
		String  recipientPhone = request.getParameter("recipientPhone");
		String  address = request.getParameter("address");
		String  zipcode = request.getParameter("zipcode");
		String  city = request.getParameter("city");
		String  country = request.getParameter("country");
		String  paymentMethod = request.getParameter("payment-method");
		
		Set<OrderDetail> orderDetails = new HashSet<>();
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		BookOrder order = new BookOrder();
		Map<Book, Integer> listOrder = cart.getItems();
		
		
		order.setCustomer(customer);
		order.setOrderDate(new Date());
		order.setPaymentMethod(paymentMethod);
		order.setRecipientName(recipientName);
		order.setRecipientPhone(recipientPhone);
		order.setShippingAddress(address + ", " + city +", " + country);
		order.setStatus("processing");
		order.setTotal(cart.getTotalMoney());
		
		order.setOrderDetails(orderDetails);
		for (Entry<Book, Integer> entry : listOrder.entrySet()) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setBook(entry.getKey());
			orderDetail.setBookOrder(order);
			orderDetail.setQuantity(entry.getValue());
			orderDetail.setSubtotal(entry.getValue() *  entry.getKey().getPrice());
			orderDetail.setId(new OrderDetailId(order.getOrderId(), entry.getKey().getBookId()));
			orderDetails.add(orderDetail);
		}
		
		order.setOrderDetails(orderDetails);
		cart.clear();
		dao.create(order);
		
	}
}
