package facades.product.impl;

import models.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.product.ProductService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class ProductFacadeImplTest {
    @Mock
    ProductService productService;
    @InjectMocks
    ProductFacadeImpl productFacadeImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        Product product = mock(Product.class);

        when(productService.getAllProducts()).thenReturn(List.of(product));

        var result = productFacadeImpl.getAllProducts();
        Assert.assertEquals(List.of(product), result);
    }

    @Test
    public void testGetAllProductsNull() {
        when(productService.getAllProducts()).thenReturn(null);

        var result = productFacadeImpl.getAllProducts();
        Assert.assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testAddProduct() {
        Product product = mock(Product.class);

        when(product.getCode()).thenReturn("123");
        when(product.getName()).thenReturn("name");
        when(product.getPrice()).thenReturn(BigDecimal.ONE);

        productFacadeImpl.addProduct(product);
        verify(productService, times(1)).addProduct(product);
    }

    @Test
    public void testAddProductFailVerify() {
        Product product = mock(Product.class);

        when(product.getCode()).thenReturn("123");
        when(product.getPrice()).thenReturn(BigDecimal.ONE);

        productFacadeImpl.addProduct(product);
        verify(productService, times(0)).addProduct(product);
    }

    @Test
    public void testAddProductNullProduct() {
        productFacadeImpl.addProduct(null);
        verify(productService, times(0)).addProduct(any());
    }

    @Test
    public void testGetProduct() {
        String productCode = "1111";
        Product product = mock(Product.class);

        when(productService.getProduct(productCode)).thenReturn(product);

        var result = productFacadeImpl.getProduct(productCode);
        Assert.assertEquals(product, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetProductNull() {
        productFacadeImpl.getProduct(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetProductBlank() {
        productFacadeImpl.getProduct("");
    }
}