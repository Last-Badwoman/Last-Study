package com.last.yj.Exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 异常类
 * @author yangjun
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LastException extends RuntimeException {

    @ApiModelProperty(value = "状态码")
    private Integer code;
    private String msg;

}
