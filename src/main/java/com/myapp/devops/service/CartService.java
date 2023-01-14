package com.myapp.devops.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.devops.dto.AddToCartDto;
import com.myapp.devops.model.Cart;
import com.myapp.devops.model.Product;
import com.myapp.devops.repository.CartRepository;


@Service
@Transactional
public class CartService {

    @Autowired
    private  CartRepository cartRepository;

    public CartService(){}

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addToCart(AddToCartDto addToCartDto, Product product){
        Cart cart = new Cart(product, addToCartDto.getQuantity());
        cartRepository.save(cart);
    }


   


    public void updateCartItem(AddToCartDto cartDto, Product product){
        Cart cart = cartRepository.getOne(cartDto.getId());
        cart.setQuantity(cartDto.getQuantity());
        cart.setCreatedDate(new Date());
        cartRepository.save(cart);
    }

   

    public void deleteCartItems(int userId) {
        cartRepository.deleteAll();
    }


   
}


