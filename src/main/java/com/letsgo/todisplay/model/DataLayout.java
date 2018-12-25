package com.letsgo.todisplay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class DataLayout {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//    @ManyToOne
//    private User user_id;
    
    @ManyToOne
    private LayoutTpl layoutTpl;
    
    private int pos_x;
    private int pos_y;
	

}
