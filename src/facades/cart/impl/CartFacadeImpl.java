package facades.cart.impl;

import facades.cart.CartFacade;
import models.Cart;
import models.CartItem;
import models.Product;
import services.cart.CartService;
import services.cart.impl.CartServiceImpl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CartFacadeImpl implements CartFacade {
    CartService cartService = new CartServiceImpl();

    @Override
    public List<Product> getAllProducts(final Cart cart) {
        if (Objects.isNull(cart)) {
            return Collections.emptyList();
        }
        return cart.getCartItems().stream().map(CartItem::getProduct).collect(Collectors.toList());
    }

    @Override
    public void addProduct(final Cart cart, final Product product) {
        addProduct(cart, product, BigDecimal.ONE);
    }

    @Override
    public void addProduct(final Cart cart, final Product product, final BigDecimal quantity) {
        if (Objects.nonNull(cart) && Objects.nonNull(product) &&
                Objects.nonNull(quantity) && quantity.signum() == 1) {
            final CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            getCartService().addItemToCart(cart, cartItem);
        }
    }

    public CartService getCartService() {
        return cartService;
    }

    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

}
