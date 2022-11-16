package com.gmall.vo;

import com.gmall.common.ListByPageQo;
import com.gmall.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author:peiliang
 * @Description:
 * @Date: 2022/11/10 15:38
 * @Modified By:
 * @Version: 1.0
 */
@Data
public class RequestUser extends  ListByPageQo {

    private Integer id;

    private String name;

    private String phone;

    private LocalDateTime cTime;

    private LocalDateTime uTime;
}
