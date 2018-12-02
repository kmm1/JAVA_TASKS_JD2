package com.itacademy.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Weapon.class)
public abstract class Weapon_ extends com.itacademy.entity.BaseEntity_ {

	public static volatile SingularAttribute<Weapon, String> name;
	public static volatile SingularAttribute<Weapon, Enemy> enemy;

}

