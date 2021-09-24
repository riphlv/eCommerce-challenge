package services.product.impl;

import database.product.ProductDatabase;
import models.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class ProductServiceImplTest {
    @Mock
    ProductDatabase productDatabase;
    @InjectMocks
    ProductServiceImpl productServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProduct() {
        Product product = mock(Product.class);
        productServiceImpl.addProduct(product);
        verify(productDatabase, times(1)).addProduct(product);
    }

    @Test
    public void testAddProductNull() {
        productServiceImpl.addProduct(null);
        verify(productDatabase, times(0)).addProduct(any());
    }

    @Test
    public void testGetProduct() {
        String productCode = "111";
        Product product = mock(Product.class);

        when(productDatabase.getProduct(productCode)).thenReturn(Optional.of(product));

        var result = productServiceImpl.getProduct(productCode);
        Assert.assertEquals(product, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetProductNullCode() {
        productServiceImpl.getProduct(null);
    }

    @Test
    public void testGetAllProducts() {
        Product product = mock(Product.class);

        when(productDatabase.getAllProducts()).thenReturn(List.of(product));

        var result = productServiceImpl.getAllProducts();
        Assert.assertEquals(List.of(product), result);
    }

    @Test
    public void testGetAllProductsNull() {

        when(productDatabase.getAllProducts()).thenReturn(null);

        var result = productServiceImpl.getAllProducts();
        Assert.assertEquals(Collections.emptyList(), result);
    }

}