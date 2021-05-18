package com.listaDesejos.listaDesejos;

import com.listaDesejos.listaDesejos.entity.Product;
import com.listaDesejos.listaDesejos.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class ProductControllerTest {

    @Autowired
    ProductService productService;

    @Test
    void registerProduct() {
        Product product = new Product();
        product.setName("Microondas");
        product.setDescription("Brastemp 31L");
        BigDecimal valor = new BigDecimal(800.00);
        product.setPrice(valor);

        Product productSave = productService.registerProduct(product);

        assertThat(productSave).isNotNull();
    }

}
