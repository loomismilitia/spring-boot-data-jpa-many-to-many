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
 * Data JPA tests for entity {@link ProductTag}.
 *
 * @author simon
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@EnableJpaAuditing
public class ProductTagTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void saveShouldPersistDataOfExistingTag() throws Exception {

        Tag savedTag = this.entityManager.persistFlushFind(Fixtures.createTag());

        Product product = Fixtures.createProduct();
        product.getProductTags().add(new ProductTag(product, savedTag));

        Product savedProduct = this.entityManager.persistFlushFind(product);
        assertThat(savedProduct.getSku()).isEqualTo("sku");
        assertThat(savedProduct.getProductTags().get(0).getTag().getName()).isEqualTo("tag");
    }

    @Test
    public void saveShouldPersistDataAndCreateTag() throws Exception {

        // save product
        Product product = Fixtures.createProduct();
        product.getProductTags().add(new ProductTag(product, Fixtures.createTag()));

        Product savedProduct = this.entityManager.persistFlushFind(product);
        assertThat(savedProduct.getSku()).isEqualTo("sku");
        assertThat(savedProduct.getProductTags().get(0).getTag().getName()).isEqualTo("tag");
    }

}