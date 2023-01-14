package com.myapp.devops.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.devops.dto.AddToCartDto;
import com.myapp.devops.dto.CartDto;
import com.myapp.devops.model.Product;
import com.myapp.devops.service.CartService;
import com.myapp.devops.service.ProductService;


@RestController
@RequestMapping("/api/v1/carts")
public class CartApi {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

   

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody AddToCartDto addToCartDto
                                                 )  {
        
        Product product = productService.getProductById(addToCartDto.getProductId()).get();
        System.out.println("product to add"+  product.getProductName());
        cartService.addToCart(addToCartDto, product);
        return new ResponseEntity<>( "Added to cart", HttpStatus.CREATED);

    }
    
    
}
