package facades.product;

import models.Product;

import java.util.List;

public interface ProductFacade {
    List<Product> getAllProducts();

    void addProduct(Product product);

    Product getProduct(String code);
}
