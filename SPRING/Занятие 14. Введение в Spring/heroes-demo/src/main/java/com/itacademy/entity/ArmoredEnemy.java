package com.itacademy.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author i.sukach
 */
@Entity
//@Table(name = "armored_enemies")
@ToString(callSuper = true, doNotUseGetters = true)
//@PrimaryKeyJoinColumn(name = "enemy_id")
@DiscriminatorValue("armored")
public class ArmoredEnemy extends Enemy {

    @Column(name = "armor_type")
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private ArmorType armorType;

    @Column(name = "armor_durability")
    @Getter
    @Setter
    private Integer armorDurability;
}
