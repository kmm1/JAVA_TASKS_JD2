package com.itacademy.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Enemy.class)
public abstract class Enemy_ extends com.itacademy.entity.BaseEntity_ {

	public static volatile SingularAttribute<Enemy, String> name;
	public static volatile SetAttribute<Enemy, Weapon> weapons;
	public static volatile SingularAttribute<Enemy, LocalDateTime> version;

}

