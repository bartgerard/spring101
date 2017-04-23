package be.continuum.slice.model;

import be.continuum.slice.value.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import static lombok.AccessLevel.PRIVATE;

/**
 * Product
 *
 * @author bartgerard
 * @version v0.0.1
 */
@Entity
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@Getter
@Builder
@EqualsAndHashCode(of = "name")
public class Product {

    @Id
    private String name;

    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "category"))
    private Category category;

}
