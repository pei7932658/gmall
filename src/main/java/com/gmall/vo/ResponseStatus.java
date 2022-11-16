package com.gmall.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yihongzhi
 * @version 1.0
 * @date 2019-12-06 13:56
 */
@AllArgsConstructor
@Getter
public enum ResponseStatus {

    OK(200, "成功"),
    RATE_LIMIT(201, "超过服务速率限制"),
    FAILED(500, "失败");

    private final Integer code;
    private final String message;

}
