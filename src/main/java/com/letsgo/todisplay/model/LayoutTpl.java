package com.letsgo.todisplay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class LayoutTpl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int width;
    private int height;
	
 
    public LayoutTpl(String name, int width, int height) {
        super();
        this.name = name;
        this.width = width;
        this.height = height;
    }

}
