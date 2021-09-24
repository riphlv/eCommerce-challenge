package database.product;

import models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDatabase {
    void addProduct(Product product);

    void removeProduct(Product product);

    Optional<Product> getProduct(String code);

    List<Product> getAllProducts();
}
