package com.shop.user;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author chenyu
 * @date 2020/6/5
 */
@Service
public class UserServiceImpl implements IUserService {

  final
  UserMapper userMapper;

  public UserServiceImpl(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  @Override
  public List<User> selectByAbstractWrapper() {
    //lambda
    Wrappers.<User>lambdaQuery().eq(User::getName, "Jack");
    System.out.println(JSON
      .toJSONString(userMapper.selectList(Wrappers.<User>lambdaQuery().eq(User::getName, "Jack"))));
    //传统
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper
      .eq("name", "Jack");

    return userMapper.selectList(queryWrapper);
  }

  @Override
  public List<User> selectByBaseMapper() {
    return userMapper.selectBatchIds(Arrays.asList(1, 2));
  }

  @Override
  public UserGroup selectByXml() {
    //xml+wrapper
    System.out.println(JSON.toJSONString(
      userMapper.getUserGroupOfWrapper(Wrappers.<User>lambdaQuery().eq(User::getId, 1))));
    //xml
    return userMapper.getUserGroupByUserId(1);
  }

  @Override
  public User selectByAnnotation() {
    //annotation+wrapper
    System.out.println(JSON
      .toJSONString(userMapper.getUserOfWrapper(Wrappers.<User>lambdaQuery().eq(User::getId, 1))));
    //annotation
    return userMapper.getUserById(1);
  }

  @Override
  public IPage<User> selectUserPage() {
    Page<User> page = new Page<>();
    page.setCurrent(2);
    page.setSize(2);
    page.setOrders(Collections.singletonList(new OrderItem().setColumn("name").setAsc(true)));
    return userMapper.selectUserPage(page, 1L);
  }


}
