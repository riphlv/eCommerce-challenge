package services.product;

import models.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);

    Product getProduct(String code);

    List<Product> getAllProducts();
}
