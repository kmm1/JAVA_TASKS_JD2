package com.itacademy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author i.sukach
 */
@Entity
@Table(name = "weapons")
public class Weapon extends BaseEntity {

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "enemy_id")
    private Enemy enemy;
}
