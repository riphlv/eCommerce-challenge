package services.cart.impl;

import models.Cart;
import models.CartItem;
import services.cart.CartService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class CartServiceImpl implements CartService {

    @Override
    public void addItemToCart(final Cart cart, final CartItem cartItem) {
        if (Objects.nonNull(cart) && Objects.nonNull(cartItem)) {
            final ArrayList<CartItem> itemList = new ArrayList<>(
                    Objects.nonNull(cart.getCartItems()) ? cart.getCartItems() : Collections.emptyList());
            itemList.add(cartItem);
            cart.setCartItems(itemList);
        }
    }
}
