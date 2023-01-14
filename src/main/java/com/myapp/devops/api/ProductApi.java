package com.myapp.devops.api;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.devops.dto.ProductDto;
import com.myapp.devops.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductApi {
    @Autowired ProductService productService;
    
    @Autowired
    private ModelMapper mapper;
   

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> body = productService.listProducts();
        return new ResponseEntity<List<ProductDto>>(body, HttpStatus.OK);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Integer id) {
    	
    ProductDto dto=	mapper.map(productService.getProductById(id).get(),ProductDto.class);
       
        return new ResponseEntity<>(dto,HttpStatus.OK);
        		
    } 		
    @PostMapping()
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        productDto =productService.addProduct(productDto);
        return new ResponseEntity<>(productDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Integer productID, @RequestBody ProductDto productDto) {
       
        
       productDto= productService.updateProduct(productID, productDto);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }
}
