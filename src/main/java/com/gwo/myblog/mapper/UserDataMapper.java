package com.gwo.myblog.mapper;

import com.gwo.myblog.model.dos.UserDo;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author Gwo(1552571230@qq.com)
 */

@Mapper

public interface UserDataMapper {
    Integer insertUserDataToDB(UserDo userDo);

}
