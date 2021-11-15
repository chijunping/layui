package com.example.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName emp
 */
@Data
public class Emp implements Serializable {
    /**
     * 
     */
    private Integer empId;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String sex;

    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private Double sal;

    /**
     * 
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private Integer deptId;

    private Dept dept;


    private static final long serialVersionUID = 1L;

}