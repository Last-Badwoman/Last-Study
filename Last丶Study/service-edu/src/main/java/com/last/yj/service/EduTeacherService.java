package com.last.yj.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.last.yj.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.last.yj.entity.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author yangjun
 * @since 2020-10-17
 */
public interface EduTeacherService extends IService<EduTeacher> {

    /**
     * 讲师条件查询分页
     * @param teacherPage
     * @param teacher
     */
    void pageQuery(Page<EduTeacher> teacherPage, TeacherQuery teacher);

    /**
     * 讲师条件查询分页
     * @param teacher
     */
    void insert(EduTeacher teacher);
}
