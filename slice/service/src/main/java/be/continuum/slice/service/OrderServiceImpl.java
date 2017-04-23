package be.continuum.slice.service;

import be.continuum.slice.model.Order;
import be.continuum.slice.respository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * OrderServiceImpl
 *
 * @author bartgerard
 * @version v0.0.1
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order findOne(final UUID id) {
        return orderRepository.findOne(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

}
