package com.micro.chen.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value="da_le_tou")
public class DaLeTou implements Serializable {

    private String firstBall;
    private String secondBall;
    private String thirdBall;
    private String fourthBall;
    private String fifthBall;
    private String blueFirstBall;
    private String blueSecondBall;

}
