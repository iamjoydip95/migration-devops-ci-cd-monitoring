package com.myapp.devops.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.devops.dto.ProductDto;
import com.myapp.devops.model.Product;
import com.myapp.devops.repository.ProductRepository;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ModelMapper mapper;

    public List<ProductDto> listProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product : products) {
            ProductDto productDto = getDtoFromProduct(product);
            productDtos.add(productDto);
        }
        return productDtos;
    }

    public static ProductDto getDtoFromProduct(Product product) {
        ProductDto productDto = new ProductDto(product);
        return productDto;
    }

    public static Product getProductFromDto(ProductDto productDto) {
        Product product = new Product();
        
        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        
        return product;
    }

    public ProductDto addProduct(ProductDto productDto) {
        Product product = getProductFromDto(productDto);
        product= productRepository.save(product);
        return  mapper.map(product, ProductDto.class);
    }

    public ProductDto updateProduct(Integer productID, ProductDto productDto) {
        Product product = getProductFromDto(productDto);
        product.setId(productID);
        product = productRepository.save(product);
       return  mapper.map(product, ProductDto.class);
    }
    
   


    public Optional<Product> getProductById(Integer productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct;
    }


}
