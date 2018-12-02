package com.itacademy.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author i.sukach
 */
@Entity
//@Table(name = "invisible_enemies")
@ToString(callSuper = true, doNotUseGetters = true)
//@PrimaryKeyJoinColumn(name = "enemy_id")
@DiscriminatorValue("invisible")
public class InvisibleEnemy extends Enemy {

    @Column(name = "invisibility_duration")
    @Getter
    @Setter
    private Integer invisibilityDuration;
}
