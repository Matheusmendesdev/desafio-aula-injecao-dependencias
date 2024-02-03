package com.devsuperior.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.aula.entities.Order;

@Service
public class OrderService {
	
	@Autowired
	private ShippingService shippingService;
	
	public double total(Order order) {
		double totalWithShipping = shippingService.shipment(order) + order.getBasic();
		double discount = (order.getBasic() * order.getDiscount()) / 100;
		return totalWithShipping - discount;
	}

}
