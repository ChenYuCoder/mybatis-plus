package com.shop.common;

import com.sun.istack.internal.NotNull;

/**
 * @author chenyu
 * @date 2020/6/5
 */
public class PageParams {
  /**
   * 当前页数
   */
  @NotNull
  private Integer page;
  /**
   * 本页展示数
   */
  @NotNull
  private Integer count;
  /**
   * 排序字段
   */
  @NotNull
  private String sortKey;
  /**
   * 排序类型
   */
  @NotNull
  private String sortType;

}
