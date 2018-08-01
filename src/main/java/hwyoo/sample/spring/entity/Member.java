package hwyoo.sample.spring.entity;

import hwyoo.sample.spring.enumerate.RoleType;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hanwon.yoo on 2018. 7. 25..
 */
@Data
@Entity
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

}
