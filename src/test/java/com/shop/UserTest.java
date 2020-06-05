package com.shop;

import com.alibaba.fastjson.JSON;
import com.shop.user.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chenyu
 * @date 2020/6/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

  @Autowired
  private IUserService userService;

  @Test
  public void testBaseMapper() {
    System.out.println(JSON.toJSONString(userService.selectByBaseMapper()));
  }

  @Test
  public void testAnnotation() {
    System.out.println(JSON.toJSONString(userService.selectByAnnotation()));
  }

  @Test
  public void testXml() {
    System.out.println(JSON.toJSONString(userService.selectByXml()));
  }

  @Test
  public void testAbstractWrapper() {
    System.out.println(JSON.toJSONString(userService.selectByAbstractWrapper()));
  }

  @Test
  public void testUserPage() {
    System.out.println(JSON.toJSONString(userService.selectUserPage()));
  }


}
