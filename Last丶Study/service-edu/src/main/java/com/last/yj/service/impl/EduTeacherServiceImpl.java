package com.last.yj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.last.yj.entity.EduTeacher;
import com.last.yj.entity.TeacherQuery;
import com.last.yj.mapper.EduTeacherMapper;
import com.last.yj.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author yangjun
 * @since 2020-10-17
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public void pageQuery(Page<EduTeacher> teacherPage, TeacherQuery teacher) {
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("sort");

        if (teacher == null) {
            baseMapper.selectPage(teacherPage,wrapper);
            return;
        }

        String name = teacher.getName();
        Integer level = teacher.getLevel();
        String begin = teacher.getBegin();
        String end = teacher.getEnd();
        if (StringUtils.isNotBlank(name)) {
            wrapper.like("name",name);
        }

        if (level != null) {
            wrapper.eq("level",level);
        }

        if (StringUtils.isNotBlank(begin)) {
            wrapper.ge("gmt_create",begin);
        }

        if (StringUtils.isNotBlank(end)) {
            wrapper.le("gmt_create",end);
        }

        baseMapper.selectPage(teacherPage,wrapper);
    }

    @Override
    public void insert(EduTeacher teacher) {
        baseMapper.insert(teacher);
    }
}
