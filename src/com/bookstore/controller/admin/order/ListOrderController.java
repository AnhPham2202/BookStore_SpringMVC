package com.bookstore.controller.admin.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.entity.BookOrder;
import com.bookstore.entity.OrderDetail;
import com.bookstore.service.OrderService;

@Controller
@RequestMapping("/admin/")
public class ListOrderController {
	private String subfolder = "admin/order-pages/";
	@Autowired
	OrderService orderService;
	
	
	@GetMapping("list-order")
	public String showPage(HttpServletRequest request) {
		List<BookOrder> listOrder = orderService.listOrder();
		System.out.println(listOrder);
		for (BookOrder order : listOrder) {
			
			List<OrderDetail> orderDetails = orderService.getOrderDetailByOrderId(order.getOrderId());
			for (OrderDetail detail : orderDetails) {
				request.setAttribute(String.valueOf("id" + order.getOrderId()) , detail.getQuantity());
			}

		}
		request.setAttribute("listOrders", listOrder);
		return subfolder + "list-order";
	}
}
