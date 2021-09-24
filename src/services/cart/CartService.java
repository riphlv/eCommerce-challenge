package services.cart;

import models.Cart;
import models.CartItem;

public interface CartService {
    void addItemToCart(Cart cart, CartItem cartItem);
}
