package com.shop;

import com.shop.user.UserMapper;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vichen
 */
@SpringBootApplication
@RestController
public class Application {

  final UserMapper userMapper;

  public Application(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  public static void main(String[] args) {
    try {
      System.setProperty("local-ip", getIpAddress().getHostAddress());
    } catch (SocketException e) {
      e.printStackTrace();
    }
    SpringApplication.run(Application.class, args);
  }

  @GetMapping("/status")
  public String welcome() {
    return "ok";
  }

  @GetMapping("/test")
  public String test() {
    return userMapper.selectById(1).getName();
  }

  public static InetAddress getIpAddress() throws SocketException {
    Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
    while (interfaces.hasMoreElements()) {
      NetworkInterface current = interfaces.nextElement();
      if (!current.isUp() || current.isLoopback() || current.isVirtual()) {
        continue;
      }
      Enumeration<InetAddress> addresses = current.getInetAddresses();
      while (addresses.hasMoreElements()) {
        InetAddress addr = addresses.nextElement();
        if (addr.isLoopbackAddress()) {
          continue;
        }
        //去掉还回和虚拟地址
        if (addr.isSiteLocalAddress()) {
          return addr;
        }
      }
    }
    throw new SocketException("Can't get our ip address, interfaces are: " + interfaces);
  }
}
