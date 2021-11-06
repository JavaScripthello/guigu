package com.atguigu.eduservice.entity.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Scanner;

@Api(value = "讲师查询条件")
@Data
public class TeacherVO {
    @ApiModelProperty(value = "讲师姓名")
    private String name;
    @ApiModelProperty(value = "讲师资历")
    private String career;
    private Integer level;
    private String startTime;
    private String endTime;
}
