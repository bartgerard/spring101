package be.continuum.slice.service;

import be.continuum.slice.model.Product;
import be.continuum.slice.respository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductServiceImpl
 *
 * @author bartgerard
 * @version v0.0.1
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product findOne(String name) {
        return productRepository.findOne(name);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

}
