package com.atguigu.eduservice.controller;


import com.atguigu.commontuils.ResultUtils;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherVO;
import com.atguigu.eduservice.service.impl.EduTeacherServiceImpl;
import com.atguigu.servicebase.handler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-10-06
 */
@Api(value = "讲师管理")
@RestController
@CrossOrigin
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherServiceImpl eduTeacherService;

    @ApiOperation(value = "获取所有讲师信息")
    @GetMapping("/findAll")
    public ResultUtils findAll() {
        List<EduTeacher> list = eduTeacherService.list(null);
        //int i =1/0;
        return ResultUtils.ok().data("list", list);
    }

    @ApiOperation(value = "获取讲师信息")
    @GetMapping("/getEduTeacherById/{id}")
    public ResultUtils getEduTeacherById(@ApiParam(value = "讲师ID") @PathVariable String id) {
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return ResultUtils.ok().data("edu", eduTeacher);
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "分页查询")
    @GetMapping("/pageListTeacher/{current}/{limit}")
    public ResultUtils pageListTeacher(@PathVariable long current, @PathVariable long limit) {
        Page<EduTeacher> teacherPage = new Page<>(current, limit);
        try{
            int i =1/0;
        }catch (Exception e){
          throw   new  GuliException(201,"自定义异常");
        }
        IPage<EduTeacher> teacherIPage = eduTeacherService.page(teacherPage, null);
        System.out.println(teacherIPage.getTotal());
        System.out.println(teacherIPage.getRecords());
        return ResultUtils.ok().data("totals", teacherPage.getTotal()).data("records", teacherPage.getRecords());
    }

    @PostMapping("/pageListByQuery/{current}/{limit}")
    public ResultUtils pageListByQuery(@PathVariable long current, @PathVariable long limit, @RequestBody(required = false) TeacherVO teacherVO) {
        Page<EduTeacher> teacherPage = new Page<>(current, limit);
        QueryWrapper queryWrapper = new QueryWrapper();
        if (!StringUtils.isEmpty(teacherVO.getName())) {
            queryWrapper.like("name", teacherVO.getName());
        }
        if (!StringUtils.isEmpty(teacherVO.getLevel())) {
            queryWrapper.eq("level", teacherVO.getLevel());
        }
        if (!StringUtils.isEmpty(teacherVO.getCareer())) {
            queryWrapper.eq("career", teacherVO.getCareer());
        }
        if (!StringUtils.isEmpty(teacherVO.getStartTime())) {
            queryWrapper.ge("gmt_create", teacherVO.getStartTime());
        }
        if (!StringUtils.isEmpty(teacherVO.getEndTime())) {
            queryWrapper.le("gmt_create", teacherVO.getEndTime());
        }
        eduTeacherService.page(teacherPage, queryWrapper);
        return ResultUtils.ok().data("totals", teacherPage.getTotal()).data("records", teacherPage.getRecords());
    }

    /**
     * 添加讲师
     */
    @PostMapping("/addTeacher")
    public ResultUtils addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        if (save){
          return   ResultUtils.ok();
        }else {
            return  ResultUtils.error();
        }
    }

    /**
     * 修改讲师信息
     */
    @PostMapping("/update")
    public ResultUtils update(@RequestBody EduTeacher eduTeacher){
        EduTeacher eduTeacher1 = eduTeacherService.getById(eduTeacher.getId());
        if (eduTeacher1 == null){
          return  ResultUtils.error();
        }
        boolean update = eduTeacherService.update(eduTeacher, null);
        if (update){
            return ResultUtils.ok();
        }else {
            return ResultUtils.error();
        }
    }

    /**
     * 删除讲师信息
     */
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResultUtils deleteById(@PathVariable long id){
        boolean remove = eduTeacherService.removeById(id);
        if (remove){
            return ResultUtils.ok();
        }else{
            return ResultUtils.error();
        }
    }

}

