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
 * Data JPA tests for entity {@link Product}.
 *
 * @author simon
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@EnableJpaAuditing
public class ProductTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void saveShouldPersistData() throws Exception {

        Product savedProduct = this.entityManager.persistFlushFind(Fixtures.createProduct());
        assertThat(savedProduct.getSku()).isEqualTo("sku");
    }

}