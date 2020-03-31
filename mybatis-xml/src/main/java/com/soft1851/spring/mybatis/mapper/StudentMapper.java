package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
public interface StudentMapper {
    /**
     *批量插入
     *
     * @return int
     */
    int batchInsert(@Param("students")List<Student>students);

    /**
     * 新增student，并返回自增主键
     *
     * @param student
     */
    void insert(Student student);

    /**
     * 根据studentId删除Student
     *
     * @param studentId
     */
    void delete(int studentId);

    /**
     * 批量删除
     *
     * @return int
     */
    int batchDelete(@Param("idList") List<Integer> idList);

    /**
     * 根据id查询Student
     * @param studentId
     * @return
     */
    Student getStudentById(int studentId);

    /**
     * 更新Student
     *
     * @param student
     */
    void update(Student student);

    /**
     * 表单（带两个指定条件）查询
     *
     * @return
     */
    List<Student> selectLimit();

    /**
     * 表单指定条件查询
     * @param student
     * @return
     */
    List<Student> selectLimitByDynamicSql(Student student);
}
