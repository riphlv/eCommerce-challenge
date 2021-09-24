package facades.cart.impl;

import models.Cart;
import models.CartItem;
import models.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.cart.CartService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class CartFacadeImplTest {
    @Mock
    CartService cartService;
    @InjectMocks
    CartFacadeImpl cartFacadeImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        Cart cart = mock(Cart.class);
        CartItem cartItem = mock(CartItem.class);
        Product product = mock(Product.class);

        when(cart.getCartItems()).thenReturn(List.of(cartItem));
        when(cartItem.getProduct()).thenReturn(product);

        var result = cartFacadeImpl.getAllProducts(cart);
        Assert.assertEquals(List.of(product), result);
    }

    @Test
    public void testGetAllProductsNullCart() {
        CartItem cartItem = mock(CartItem.class);
        Product product = mock(Product.class);

        when(cartItem.getProduct()).thenReturn(product);

        var result = cartFacadeImpl.getAllProducts(null);
        Assert.assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testAddProduct() {
        Cart cart = mock(Cart.class);
        Product product = mock(Product.class);
        BigDecimal quantity = mock(BigDecimal.class);

        when(quantity.signum()).thenReturn(1);

        cartFacadeImpl.addProduct(cart, product, quantity);
        verify(cartService, times(1)).addItemToCart(any(), any());
    }

    @Test
    public void testAddProductQuantityLessThan1() {
        Cart cart = mock(Cart.class);
        Product product = mock(Product.class);
        BigDecimal quantity = mock(BigDecimal.class);

        when(quantity.signum()).thenReturn(0);

        cartFacadeImpl.addProduct(cart, product, quantity);
        verify(cartService, times(0)).addItemToCart(any(), any());
    }

    @Test
    public void testAddProductNullCart() {
        Product product = mock(Product.class);
        BigDecimal quantity = mock(BigDecimal.class);

        when(quantity.signum()).thenReturn(1);

        cartFacadeImpl.addProduct(null, product, quantity);
        verify(cartService, times(0)).addItemToCart(any(), any());
    }

    @Test
    public void testAddProduct2() {
        Cart cart = mock(Cart.class);
        Product product = mock(Product.class);
        BigDecimal quantity = mock(BigDecimal.class);

        when(quantity.signum()).thenReturn(1);

        cartFacadeImpl.addProduct(cart, product);
        verify(cartService, times(1)).addItemToCart(any(), any());
    }
}