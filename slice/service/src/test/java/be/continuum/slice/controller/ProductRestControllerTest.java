package be.continuum.slice.controller;

import be.continuum.slice.model.ConsumableProduct;
import be.continuum.slice.service.ProductService;
import be.continuum.slice.value.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * ProductRestController
 *
 * @author bartgerard
 * @version v0.0.1
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ProductRestController.class)
public class ProductRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Before
    public void setUp() {
        final Category candy = Category.of("candy");

        when(productService.findAll()).thenReturn(Arrays.asList(
                ConsumableProduct.builder()
                                 .name("mars")
                                 .category(candy)
                                 .build(),
                ConsumableProduct.builder()
                                 .name("bounty")
                                 .category(candy)
                                 .build()
        ));
    }

    @Test
    public void retrieveAllProducts() throws Exception {
        mockMvc.perform(get("/products"))
               .andExpect(status().isOk())
               .andDo(MockMvcResultHandlers.print()) // prints header, response and request
               .andExpect(jsonPath("$", hasSize(2)))
               .andExpect(jsonPath("$[0].name", is("mars")))
               .andExpect(jsonPath("$[0].category.name", is("candy")))
               .andExpect(jsonPath("$[1].name", is("bounty")))
               .andExpect(jsonPath("$[1].category.name", is("candy")));
    }

}
