package com.spring.jpa.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
public class Item {

    @Id
    @GeneratedValue
    private Integer itemId;

    private String title;

    private String description;

    private BigDecimal cost;

}
