package com.gp.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: gaopeng
 * @Date: 2018-07-26
 */
@Data
public class ResultVo<T> implements Serializable {
    private String result;
    private String description;
    private T data;

    public ResultVo() {
        super();
    }

    public ResultVo(T data) {
        super();
        result = "SUCCESS";
        description="成功";
        this.data = data;
    }
}
