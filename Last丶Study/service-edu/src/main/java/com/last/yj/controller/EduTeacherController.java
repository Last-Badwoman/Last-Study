package com.last.yj.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.last.yj.entity.EduTeacher;
import com.last.yj.entity.TeacherQuery;
import com.last.yj.service.EduTeacherService;
import com.last.yj.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author yangjun
 * @since 2020-10-17
 */
@CrossOrigin
@RestController
@RequestMapping("/yj/edu-teacher")
@Api(tags = "讲师接口")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    @ApiOperation(value = "查询所有", notes = "查询所有讲师信息")
    @GetMapping
    public ResponseResult list() {
        return ResponseResult.ok().data("items",teacherService.list(null));
    }


    @ApiOperation(value = "删除讲师信息",notes = "根据讲师id删除讲师信息")
    @DeleteMapping("{ids}")
    public ResponseResult removeTeacherById(@ApiParam(name = "ids",value = "讲师id") @PathVariable("ids") String[] ids) {
        try {
            if (CollectionUtils.isNotEmpty(Arrays.asList(ids))) {
                 teacherService.removeByIds(Arrays.asList(ids));
                return ResponseResult.ok();
            }
            return ResponseResult.error();
        }catch (Exception e) {
            return ResponseResult.error();
        }
    }


    @ApiOperation(value = "讲师信息分页数据",notes = "讲师信息搜索过滤分页数据")
    @GetMapping("{page}/{limit}")
    public ResponseResult pageList(
                        @ApiParam(name = "page",value = "当前页码",required = true) @PathVariable("page") Long page,
                        @ApiParam(name = "limit",value = "每页记录数",required = true) @PathVariable("limit") Long limit,
                        @ApiParam(name = "teacher",value = "搜索teacher数据",required = false) TeacherQuery teacher
    ) {
        Page<EduTeacher> teacherPage = new Page<>();
        teacherService.pageQuery(teacherPage,teacher);
        List<EduTeacher> records = teacherPage.getRecords();
        long total = teacherPage.getTotal();
        return ResponseResult.ok().data("total",total).data("rows",records);
    }

    @ApiOperation(value = "修改讲师信息",notes = "根据id修改讲师信息")
    @PutMapping("update")
    public ResponseResult update(@ApiParam(name = "teacher",value = "讲师信息类",required = true) EduTeacher teacher) {
        if (teacher != null) {
            teacherService.updateById(teacher);
            return ResponseResult.ok();
        }
        return ResponseResult.error();
    }

    @ApiOperation(value = "添加讲师",notes = "添加讲师信息")
    @PostMapping("insert")
    public ResponseResult insert(@ApiParam(name = "teacher",value = "讲师信息类",required = true) EduTeacher teacher) {
        if (teacher != null) {
            teacherService.insert(teacher);
            return ResponseResult.ok();
        }
        return ResponseResult.error();
    }
}

