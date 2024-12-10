package net.qihoo.springdataesdemo.service;

import lombok.RequiredArgsConstructor;
import net.qihoo.springdataesdemo.entity.Product;
import net.qihoo.springdataesdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findByName(String name) {
        return productRepository.findByNameContaining(name);
    }

    public SearchHits<Product> searchProducts(String keyword) {
        Criteria criteria = new Criteria("name").contains(keyword)
                .or(new Criteria("description").contains(keyword));
        CriteriaQuery query = new CriteriaQuery(criteria);
        return elasticsearchOperations.search(query, Product.class);
    }
} 