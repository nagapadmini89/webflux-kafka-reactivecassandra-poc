package com.mypoc.webfluxkafkareactivecassandrapoc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

@Table("user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    private static final long serialVersionUID = 1L;

    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @Column("id")
    private String id;

    @PrimaryKeyColumn(name = "name", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    @Column("name")
    private String name;

    @Column("created_time")
    private Date createdTime  = new Date();

    @Column("email")
    private String email;

    @Column("age")
    private int age;

}
