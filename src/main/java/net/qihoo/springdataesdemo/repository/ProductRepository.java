package net.qihoo.springdataesdemo.repository;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import net.qihoo.springdataesdemo.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
    List<Product> findByNameContaining(String name);
    List<Product> findByCategory(String category);
    List<Product> findByPriceBetween(Double startPrice, Double endPrice);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}, {\"match\": {\"description\": \"?0\"}}]}}")
    List<Product> searchByNameAndDescription(String keyword);
} 