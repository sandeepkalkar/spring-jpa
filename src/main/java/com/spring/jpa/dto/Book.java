package com.spring.jpa.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "t_book")
public class Book extends  Item{

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "pages")
    private  Integer pages;

    @Column(name = "publish_dt")
    private Date publishDate;
}
