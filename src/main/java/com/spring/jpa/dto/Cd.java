package com.spring.jpa.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_cd")
public class Cd extends Item{

    @Column(name = "genre")
    private String genre;

    @Column(name = "duration")
    private Integer duration;
}
