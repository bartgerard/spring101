package be.continuum.slice.controller;

import be.continuum.slice.model.Product;
import be.continuum.slice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ProductRestController
 *
 * @author bartgerard
 * @version v0.0.1
 */
@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("{name}")
    public Product byName(@PathVariable final String name) {
        return productService.findOne(name);
    }

    @GetMapping
    public List<Product> all() {
        return productService.findAll();
    }

}
