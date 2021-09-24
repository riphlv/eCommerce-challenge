package facades.cart;

import models.Cart;
import models.Product;

import java.math.BigDecimal;
import java.util.List;

public interface CartFacade {
    List<Product> getAllProducts(Cart cart);

    void addProduct(Cart cart, Product product);

    void addProduct(Cart cart, Product product, BigDecimal quantity);
}
