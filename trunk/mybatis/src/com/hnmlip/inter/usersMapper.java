package com.hnmlip.inter;

import com.hnmlip.model.users;
import com.hnmlip.model.usersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface usersMapper {
    int countByExample(usersExample example);

    int deleteByExample(usersExample example);

    int deleteByPrimaryKey(Long id);

    int insert(users record);

    int insertSelective(users record);

    List<users> selectByExample(usersExample example);

    users selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") users record, @Param("example") usersExample example);

    int updateByExample(@Param("record") users record, @Param("example") usersExample example);

    int updateByPrimaryKeySelective(users record);

    int updateByPrimaryKey(users record);
}