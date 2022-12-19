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
public class Dinghuo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="Asia/Shanghai")
    private Date deliveryTime;
    private String goodsName;
    private Integer quantity;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="Asia/Shanghai")
    private Date deadline;
    private String buyer;
    private String unit;
    private String state;


}
