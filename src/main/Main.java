package main;

import facades.cart.CartFacade;
import facades.cart.impl.CartFacadeImpl;
import facades.product.ProductFacade;
import facades.product.impl.ProductFacadeImpl;
import models.Cart;
import models.Product;

import java.math.BigDecimal;

public class Main {
    private static CartFacade cartFacade = new CartFacadeImpl();
    private static ProductFacade productFacade = new ProductFacadeImpl();

    public static void main(String[] args) {
        generateTestData();

        System.out.println("Products in cart: ");
        Cart cart = new Cart();
        cartFacade.addProduct(cart, productFacade.getProduct("2"), new BigDecimal("2"));
        cartFacade.addProduct(cart, productFacade.getProduct("3"));
        System.out.println(cartFacade.getAllProducts(cart));

        System.out.println("All products: ");
        System.out.println(productFacade.getAllProducts());

    }

    static void generateTestData() {
        Product product = new Product("1", "Water bottle", new BigDecimal("20"));
        Product product2 = new Product("2", "T-shirt", new BigDecimal("15"));
        Product product3 = new Product("3", "Sport boots", new BigDecimal("55"));
        productFacade.addProduct(product);
        productFacade.addProduct(product2);
        productFacade.addProduct(product3);
    }
}
