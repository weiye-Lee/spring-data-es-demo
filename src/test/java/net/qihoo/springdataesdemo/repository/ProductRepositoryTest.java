package net.qihoo.springdataesdemo.repository;

import org.junit.jupiter.api.Test;
import net.qihoo.springdataesdemo.entity.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void testSearchByNameAndDescription() {
        Product product = new Product();
        product.setName("手机");
        product.setDescription("手机是用来打电话的");
        productRepository.save(product);
        List<Product> products = productRepository.searchByNameAndDescription("手机");
        System.out.println(products);
    }
}
