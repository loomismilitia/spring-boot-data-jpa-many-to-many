package com.example.spring_boot_data_jpa_many_to_many.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Composite primary key for entity "ProductTag" ( stored in table "product_tag" )
 *
 * @author simon loomis suiçmez
 */
@Getter
@Embeddable
@EqualsAndHashCode
class ProductTagKey implements Serializable {

    @Column(nullable = false)
    private Integer productId;

    @Column(nullable = false)
    private Integer tagId;

    ProductTagKey() {
        //jpa only
    }

    ProductTagKey(Integer productId, Integer tagId) {
        this.productId = productId;
        this.tagId = tagId;
    }

}
