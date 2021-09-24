package facades.product.impl;

import facades.product.ProductFacade;
import models.Product;
import services.product.ProductService;
import services.product.impl.ProductServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ProductFacadeImpl implements ProductFacade {
    ProductService productService = new ProductServiceImpl();

    @Override
    public List<Product> getAllProducts() {
        var allProducts = getProductService().getAllProducts();
        return Objects.nonNull(allProducts) ? allProducts : Collections.emptyList();
    }

    @Override
    public void addProduct(final Product product) {
        if (Objects.nonNull(product) && validateProduct(product)) {
            getProductService().addProduct(product);
        }
    }

    @Override
    public Product getProduct(final String code) {
        if (Objects.nonNull(code) && !code.isBlank()) {
            return getProductService().getProduct(code);
        } else {
            throw new IllegalArgumentException("Invalid product code");
        }
    }

    private boolean validateProduct(Product product) {
        if (Objects.nonNull(product.getCode()) && !product.getCode().isBlank() &&
                Objects.nonNull(product.getName()) && !product.getName().isBlank() &&
                Objects.nonNull(product.getPrice()) && product.getPrice().signum() > 0) {
            return true;
        }
        return false;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
