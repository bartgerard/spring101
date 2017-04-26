package be.continuum.slice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

/**
 * Order
 *
 * @author bartgerard
 * @version v0.0.1
 */
@Entity
@Table(name = "orders") // order is a reserved keyword in SQL
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    @ManyToOne
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "fk_order_customer"))
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_order",
            joinColumns = @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "fk_product_order")),
            inverseJoinColumns = @JoinColumn(name = "product_name", foreignKey = @ForeignKey(name = "fk_order_product"))
    )
    @Singular
    private List<OrderQuantity> products;

    public enum Status {
        PENDING,
        CONFIRMED
    }

}
