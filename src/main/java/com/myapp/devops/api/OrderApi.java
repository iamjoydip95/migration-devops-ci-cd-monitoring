package com.myapp.devops.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.devops.service.OrderService;

@RestController
@RequestMapping("/api/v1/order")
public class OrderApi {
    @Autowired
    private OrderService orderService;

   

    // stripe create session API
   
    // place order after checkout
    @PostMapping("/add")
    public ResponseEntity<String> placeOrder( @RequestParam("sessionId") String sessionId)
             {
        // validate token
       
        //orderService.placeOrder(user);
        return new ResponseEntity<>( "Order has been placed", HttpStatus.CREATED);
    }

//    // get all orders
//    @GetMapping("/")
//    public ResponseEntity<List<Order>> getAllOrders(@RequestParam("token") String token) throws AuthenticationFailException {
//        // validate token
//        authenticationService.authenticate(token);
//        // retrieve user
//        User user = authenticationService.getUser(token);
//        // get orders
//        List<Order> orderDtoList = orderService.listOrders(user);
//
//        return new ResponseEntity<>(orderDtoList, HttpStatus.OK);
//    }
//
//
//    // get orderitems for an order
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getOrderById(@PathVariable("id") Integer id, @RequestParam("token") String token)
//            throws AuthenticationFailException {
//        // validate token
//        authenticationService.authenticate(token);
//        try {
//            Order order = orderService.getOrder(id);
//            return new ResponseEntity<>(order,HttpStatus.OK);
//        }
//        catch (OrderNotFoundException e) {
//            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
//        }
//
//    }

}
