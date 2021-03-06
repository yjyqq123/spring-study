package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class StudentMapperTest {
    @Resource
    private StudentMapper studentMapper;

    @Test
    public void insert() {
        Student student = Student.builder()
                .clazzId(1)
                .studentName("测试学生")
                .hometown("江苏南京")
                .birthday(LocalDate.of(2000,10,10))
                .build();
        studentMapper.insert(student);
        System.out.println(student.getStudentId());
    }

    @Test
    public void delete() {
        studentMapper.delete(2010);
    }


    @Test
    public void getStudentById() {
        Student student= studentMapper.getStudentById(1002);
        System.out.println(student);

    }

    @Test
    public void update() {
        Student student= studentMapper.getStudentById(2011);
        System.out.println(student);
        student.setStudentName("测试姓名");
        student.setHometown("江苏某地");
        student.setBirthday(LocalDate.of(1991,11,12));
        studentMapper.update(student);
        System.out.println(studentMapper.getStudentById(2011));
    }

    @Test
    public void batchInsert() {
        List<Student> students = new ArrayList<>();
        for (int i = 0 ;i<10 ;i++){
            Student student = Student.builder()
                    .studentId(4000+i)
                    .studentName("测试"+i)
                    .clazzId(1)
                    .hometown("测试城市")
                    .birthday(LocalDate.of(1999,01,01))
                    .build();
            students.add(student);
        }
        System.out.println(studentMapper.batchInsert(students));
    }

    @Test
    public void batchDelete() {
        List<Integer> idList = new ArrayList<>();
        for (int i = 0 ;i<5;i++){
            idList.add(4000+i);
        }
        studentMapper.batchDelete(idList);

    }

    @Test
    public void selectLimit() {
        System.out.println(studentMapper.selectLimit());
    }

    @Test
    public void selectLimitByDynamicSql() {
        Student student = Student.builder()
                .clazzId(1)
                .hometown("江苏")
//                .studentName("郁杰原")
//                .studentId(1001)
                .build();
        System.out.println(studentMapper.selectLimitByDynamicSql(student));

    }
}
