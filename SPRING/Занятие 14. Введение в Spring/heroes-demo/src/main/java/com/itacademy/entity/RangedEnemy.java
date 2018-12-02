package com.itacademy.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author i.sukach
 */
@Entity
//@Table(name = "ranged_enemies")
@ToString(callSuper = true, doNotUseGetters = true)
//@PrimaryKeyJoinColumn(name = "enemy_id")
@DiscriminatorValue("ranged")
public class RangedEnemy extends Enemy {

    @Column(name = "weapon_type")
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private WeaponType weaponType;

    @Column(name = "range_of_fire")
    @Getter
    @Setter
    private Integer rangeOfFire;
}
