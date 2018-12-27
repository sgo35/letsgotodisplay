package com.letsgo.todisplay.model;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
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
@Embeddable
@Entity
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
    
//    public DataLayout(LayoutTpl layoutTpl, int pos_x, int pos_y) {
//        super();
//        this.layoutTpl = layoutTpl;
//        this.pos_x = pos_x;
//        this.pos_y = pos_y;
//    }
	

}
