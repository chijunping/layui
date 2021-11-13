package com.example.common.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Page implements Serializable {
    private Integer page;
    private Integer limit;
    public Long getStart(){
//        1后加L 转换成Long  否则会报类型错误  Start开始页面
        return (page-1L)*limit;
    }
}
