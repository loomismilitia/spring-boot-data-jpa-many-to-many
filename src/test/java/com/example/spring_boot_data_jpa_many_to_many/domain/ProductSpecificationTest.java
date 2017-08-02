package com.example.spring_boot_data_jpa_many_to_many.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Data JPA tests for many to many relationship between entity {@link Product} and {@link Specification}.
 *
 * @author simon
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@EnableJpaAuditing
public class ProductSpecificationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void saveShouldPersistDataOfExistingSpecification() throws Exception {

        Specification savedSpecification = this.entityManager.persistFlushFind(Fixtures.createSpecification());

        Product product = Fixtures.createProduct();
        product.getSpecifications().add(savedSpecification);

        Product savedProduct = this.entityManager.persistFlushFind(product);
        assertThat(savedProduct.getSku()).isEqualTo("sku");
        assertThat(savedProduct.getSpecifications().get(0).getName()).isEqualTo("spec");
    }

    @Test
    public void saveShouldPersistDataAndCreateSpecification() throws Exception {

        Product product = Fixtures.createProduct();
        product.getSpecifications().add(Fixtures.createSpecification());

        Product savedProduct = this.entityManager.persistFlushFind(product);
        assertThat(savedProduct.getSku()).isEqualTo("sku");
        assertThat(savedProduct.getSpecifications().get(0).getName()).isEqualTo("spec");
    }

}