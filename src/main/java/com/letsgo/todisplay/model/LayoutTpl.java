package com.letsgo.todisplay.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor(staticName="of")
@EqualsAndHashCode(of= {"name"})
@ToString(of= {"name", "width", "height"})
@Entity
public class LayoutTpl implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
    private int width;
    private int height;
	
//    public LayoutTpl(String name, int width, int height) {
//        super();
//        this.name = name;
//        this.width = width;
//        this.height = height;
//    }

}
