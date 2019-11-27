package com.hzlgit.project.person;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 人员 DAO 接口类
 *
 * Created by fanb.
 */
@Repository
public interface PersonDao {

    /**
     * 根据人员名称，查询人员信息
     * xml 方式
     * @param name 人员姓名
     */
    Person findByName(@Param("name") String name);

    @Select("SELECT * FROM person where name = #{name}")
    // 直接注解方式，返回 Map 结果集
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone")
    })
    Person findByName2(@Param("name") String name);

    /**
     * 返回所有信息
     * xml 方式
     *
     */
    List<Person> findAll();
}
