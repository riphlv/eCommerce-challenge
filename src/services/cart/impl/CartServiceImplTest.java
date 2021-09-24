package services.cart.impl;

import models.Cart;
import models.CartItem;
import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.List;

public class CartServiceImplTest {
    CartServiceImpl cartServiceImpl = new CartServiceImpl();

    @Test
    public void testAddItemToCart() {
        Cart cart = mock(Cart.class);
        CartItem cartItem = mock(CartItem.class);
        CartItem newCartItem = mock(CartItem.class);

        when(cart.getCartItems()).thenReturn(List.of(cartItem));

        cartServiceImpl.addItemToCart(cart, newCartItem);
        verify(cart, times(1)).setCartItems(List.of(cartItem, newCartItem));
    }

    @Test
    public void testAddItemToCartNullCart() {
        Cart cart = mock(Cart.class);
        CartItem cartItem = mock(CartItem.class);
        CartItem newCartItem = mock(CartItem.class);

        when(cart.getCartItems()).thenReturn(List.of(cartItem));

        cartServiceImpl.addItemToCart(null, newCartItem);
        verify(cart, times(0)).setCartItems(any());
    }

    @Test
    public void testAddItemToCartNullCartItem() {
        Cart cart = mock(Cart.class);
        CartItem cartItem = mock(CartItem.class);

        when(cart.getCartItems()).thenReturn(List.of(cartItem));

        cartServiceImpl.addItemToCart(cart, null);
        verify(cart, times(0)).setCartItems(any());
    }
}
