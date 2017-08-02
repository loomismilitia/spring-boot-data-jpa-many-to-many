package com.example.spring_boot_data_jpa_many_to_many.domain;

import lombok.Getter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@Table(name = "product")
class Product extends AbstractPersistable<Integer> {

    @Column(unique = true)
    private String sku;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product")
    private List<ProductTag> productTags = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_specification",
            joinColumns = {@JoinColumn(name = "productId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "specificationId", referencedColumnName = "id")})
    private List<Specification> specifications = new ArrayList<>();

    private Product() {
        //thank you jpa :) \m/
    }

    Product(String sku, List<ProductTag> productTags, List<Specification> specifications) {
        this.sku = sku;
        this.productTags = productTags;
        this.specifications = specifications;
    }
}
