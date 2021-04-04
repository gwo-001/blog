package com.gwo.myblog.mapper;

import com.gwo.myblog.model.dos.UserDo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @author Gwo(1552571230@qq.com)
 */

@Mapper
@Repository
public interface UserDataMapper {
    Integer insertUserDataToDB(UserDo userDo);

}
