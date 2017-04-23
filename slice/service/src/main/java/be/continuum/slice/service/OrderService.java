package be.continuum.slice.service;

import be.continuum.slice.model.Order;

import java.util.List;
import java.util.UUID;

/**
 * OrderService
 *
 * @author bartgerard
 * @version v0.0.1
 */
public interface OrderService {

    Order findOne(UUID id);

    List<Order> findAll();

}
