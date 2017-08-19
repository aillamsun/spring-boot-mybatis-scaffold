package com.scaffold.model;

import com.scaffold.core.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by sungang on 2017/8/19.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user")
public class User extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     *
     */
    @Column(name = "user_name")
    private String userName;


    private String password;

    private String remark;

}
