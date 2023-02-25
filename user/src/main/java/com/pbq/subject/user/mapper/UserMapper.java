package com.pbq.subject.user.mapper;

import com.pbq.common.po.UserPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

   UserPo getUserByUserNameAndPassword(String userName, String password);
}
