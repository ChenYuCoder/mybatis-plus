package com.shop.user;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author chenyu
 * @date 2020/6/5
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

  /**
   * 注解方式（sql参数固定，sql长度较短）（推荐）
   *
   * @param id
   * @return
   */
  @Select("select * from user where id =#{id}")
  User getUserById(Integer id);

  /**
   * 注解方式+wrapper（sql参数动态）（推荐）
   *
   * @param wrapper 查询条件
   * @return
   */
  @Select("select * from user ${ew.customSqlSegment} limit 1")
  User getUserOfWrapper(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

  /**
   * xml方式（多表联查或复杂sql）（推荐）
   *
   * @param id id
   * @return
   */
  UserGroup getUserGroupByUserId(long id);

  /**
   * xml方式（多表联查或复杂sql，多表内不能有重复列名）：（不推荐）
   *
   * @param wrapper 查询条件
   * @return
   */
  UserGroup getUserGroupOfWrapper(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

  /**
   * <p>
   * 查询 : 根据state状态查询用户列表，分页显示
   * </p>
   *
   * @param page  分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
   * @param groupId 用户组ID
   * @return 分页对象
   */
  IPage<User> selectUserPage(Page<User> page, Long groupId);

}
