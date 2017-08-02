package com.example.spring_boot_data_jpa_many_to_many.domain;

import java.util.ArrayList;

/**
 * Utilities for constructing test fixtures.
 *
 * @author simon
 */
final class Fixtures {

    static Product createProduct(){
        return new Product("sku", new ArrayList<>(), new ArrayList<>());
    }

    static Tag createTag(){
        return new Tag("tag");
    }

    static Specification createSpecification(){
        return new Specification("spec");
    }

}
