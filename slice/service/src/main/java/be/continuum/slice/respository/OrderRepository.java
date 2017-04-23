package be.continuum.slice.respository;

import be.continuum.slice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * OrderRepository
 *
 * @author bartgerard
 * @version v0.0.1
 */
public interface OrderRepository extends JpaRepository<Order, UUID> {
}
