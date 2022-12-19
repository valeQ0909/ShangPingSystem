package com.shangping.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer quantity;
    private Integer price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="Asia/Shanghai")
    private Date qgp;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="Asia/Shanghai")
    private Date purchaseTime;
    private String buyer;
    private String supplier;
    private String describeInfo;
    private String unit;
}
