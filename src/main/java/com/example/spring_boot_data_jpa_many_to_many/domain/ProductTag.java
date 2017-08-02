package com.example.spring_boot_data_jpa_many_to_many.domain;

import lombok.Getter;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "product_tag"
 *
 * @author simon
 */
@Getter
@Entity
@Table(name = "product_tag")
class ProductTag {

    @EmbeddedId
    private ProductTagKey compositeKey;

    @MapsId("productId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "productId", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    @MapsId("tagId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "tagId", referencedColumnName = "id", insertable = false, updatable = false)
    private Tag tag;

    ProductTag() {
        //jpa only
    }

    ProductTag(Product product, Tag tag) {
        this.compositeKey = new ProductTagKey(product.getId(), tag.getId());
        this.product = product;
        this.tag = tag;
    }

}