package database.product.impl;

import database.product.ProductDatabase;
import models.Product;

import java.util.*;

//Simulates basic database with add / remove / get functionality
public class ProductDatabaseImpl implements ProductDatabase {
    List<Product> productDatabase = new ArrayList<>();

    @Override
    public void addProduct(final Product product) {
        if (getProductDatabase().stream().noneMatch(product1 -> product1.getCode().equalsIgnoreCase(product.getCode()))) {
            getProductDatabase().add(product);
        }
    }

    @Override
    public void removeProduct(final Product product) {
        if (Objects.nonNull(product)) {
            getProductDatabase().remove(product);
        }
    }

    @Override
    public Optional<Product> getProduct(final String code) {
        if (Objects.nonNull(code) && !code.isBlank()) {
            return getProductDatabase().stream().filter(product -> product.getCode().equalsIgnoreCase(code)).findFirst();
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return Objects.nonNull(getProductDatabase()) ? getProductDatabase() : Collections.emptyList();
    }

    public List<Product> getProductDatabase() {
        return productDatabase;
    }

    public void setProductDatabase(List<Product> productDatabase) {
        this.productDatabase = productDatabase;
    }
}
