package com.itacademy.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author i.sukach
 */
@Entity
@Table(name = "enemies")
@ToString(callSuper = true, exclude = "weapons", doNotUseGetters = true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "enemy_type")
public abstract class Enemy extends BaseEntity {

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @OneToMany(mappedBy = "enemy", fetch = FetchType.LAZY)
    private Set<Weapon> weapons = new HashSet<>();

    @Version
    @Getter
    @Setter
    private LocalDateTime version;
}
