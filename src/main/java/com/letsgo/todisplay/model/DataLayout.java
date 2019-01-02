package com.letsgo.todisplay.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor(staticName="of")
//@ToString(of= {"pos_x", "pos_y"})
@Embeddable
@Entity
public class DataLayout implements Serializable{
	
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
