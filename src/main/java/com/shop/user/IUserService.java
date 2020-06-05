package com.shop.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * @author chenyu
 * @date 2020/6/5
 */
public interface IUserService {

  /**
   * 通过抽象Wrapper进行查询
   *
   * @return
   */
  List<User> selectByAbstractWrapper();

  /**
   * 通过基础mapper进行查询
   *
   * @return
   */
  List<User> selectByBaseMapper();

  /**
   * 通过xml进行查询
   *
   * @return
   */
  UserGroup selectByXml();

  /**
   * 通过注解进行查询
   *
   * @return
   */
  User selectByAnnotation();

  /**
   * 分页查询
   *
   * @return
   */
  IPage<User> selectUserPage();
}
