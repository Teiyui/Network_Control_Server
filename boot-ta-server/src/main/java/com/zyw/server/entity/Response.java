package com.zyw.server.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author: ywzheng
 * @Description: TODO
 * @date: 2022/1/25 2:27 PM
 */
@Data
@Component
public class Response {
    private String msg;
    private Integer code;
    private Object result;
}
