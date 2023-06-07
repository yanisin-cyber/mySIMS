package com.yanisin.sims.model.mapper;

import com.yanisin.sims.model.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    int insertUser(User user);

    int updateUser(User user);

    int deleteUserById(@Param("user_id") String user_id);


    User selectUserById(@Param("user_id") String user_id);

    List<User> selectAllUser();

    boolean checkLogin(@Param("user_id") String user_id,
                       @Param("user_password") String user_password);

    boolean isSuperManager(@Param("user_id") String user_id);
}
