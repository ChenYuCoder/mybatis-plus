package com.shop.common;

/**
 * @author chenyu
 * @date 2020/6/5
 */
public class DataResult<T> {

  /**
   * 错误码
   */
  private int code;
  /**
   * 错误信息
   */
  private String message;
  /**
   * 数据实体
   */
  private T data;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
