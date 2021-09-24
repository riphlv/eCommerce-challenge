package services.product.impl;

import database.product.ProductDatabase;
import database.product.impl.ProductDatabaseImpl;
import models.Product;
import services.product.ProductService;

import java.util.*;

public class ProductServiceImpl implements ProductService {
    ProductDatabase productDatabase = new ProductDatabaseImpl();

    @Override
    public void addProduct(final Product product) {
        if (Objects.nonNull(product)) {
            getProductDatabase().addProduct(product);
        }
    }

    @Override
    public Product getProduct(final String code) {
        if (code != null && !code.isBlank()) {
            return getProductDatabase().getProduct(code).orElseThrow();
        } else {
            throw new IllegalArgumentException("Invalid product code");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        var productList = getProductDatabase().getAllProducts();
        if (Objects.nonNull(productList)) {
            return productList;
        } else {
            return Collections.emptyList();
        }
    }

    public ProductDatabase getProductDatabase() {
        return productDatabase;
    }

    public void setProductDatabase(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }
}
