package com.myapp.devops.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.devops.model.Order;
import com.myapp.devops.repository.OrderItemsRepository;
import com.myapp.devops.repository.OrderRepository;



@Service
@Transactional
public class OrderService {

    @Autowired
    private CartService cartService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemsRepository orderItemsRepository;

   

   

    // create total price
        public void placeOrder() {
        // first let get cart items for the user
       

       

        // create the order and save it
        Order newOrder = new Order();
        newOrder.setCreatedDate(new Date());
       
       
        
        orderRepository.save(newOrder);

//        for (CartItemDto cartItemDto : cartItemDtoList) {
//            // create orderItem and save each one
//            OrderItem orderItem = new OrderItem();
//            orderItem.setCreatedDate(new Date());
//            orderItem.setPrice(cartItemDto.getProduct().getPrice());
//            orderItem.setProduct(cartItemDto.getProduct());
//            orderItem.setQuantity(cartItemDto.getQuantity());
//            orderItem.setOrder(newOrder);
//            // add to order item list
//            orderItemsRepository.save(orderItem);
//        }
        //
      //  cartService.deleteUserCartItems(user);
    }

   


   
}


