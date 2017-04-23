package be.continuum.slice.model;

import lombok.Builder;
import lombok.Singular;

import java.util.List;
import java.util.UUID;

/**
 * OrderDto
 *
 * @author bartgerard
 * @version v0.0.1
 */
@Builder
public class OrderDto {

    private UUID id;

    @Singular
    private List<ProductDto> products;

}
