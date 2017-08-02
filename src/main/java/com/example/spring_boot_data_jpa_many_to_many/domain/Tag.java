package com.example.spring_boot_data_jpa_many_to_many.domain;

import lombok.Getter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Persistent class for entity stored in table "tag"
 *
 * @author simon
 */
@Getter
@Entity
@Table(name = "tag")
class Tag extends AbstractPersistable<Integer> {

    @Column(nullable = false, unique = true)
    private String name;

    private Tag() {
        //jpa only
    }

    Tag(String name) {
        this.name = name;
    }
}
