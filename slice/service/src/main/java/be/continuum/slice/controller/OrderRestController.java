package be.continuum.slice.controller;

import be.continuum.slice.model.Order;
import be.continuum.slice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * OrderRestController
 *
 * @author bartgerard
 * @version v0.0.1
 */
@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    @GetMapping("{id}")
    public Order byId(@PathVariable final UUID id) {
        return orderService.findOne(id);
    }

    @GetMapping
    public List<Order> all() {
        return orderService.findAll();
    }

}
