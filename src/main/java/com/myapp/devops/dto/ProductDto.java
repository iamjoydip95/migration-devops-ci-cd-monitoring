package com.myapp.devops.dto;



import com.myapp.devops.model.Product;

public class ProductDto {

    private Integer id;
    private  String productName;
    
    private  double price;
    private Double rating;
    
    public ProductDto(Product product) {
        this.setId(product.getId());
        this.setProductName(product.getProductName());
       
        this.setPrice(product.getPrice());
        this.setRating(product.getRating());
        
    }

    public ProductDto(String productName,  double price,  Double rating) {
        this.productName = productName;
       
        this.price = price;
       this.rating = rating;
    }

    public ProductDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

   

    public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

    

    }
