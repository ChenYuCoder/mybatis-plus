package com.shop.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sun.istack.internal.NotNull;
import java.util.List;

/**
 * @author chenyu
 * @date 2020/6/5
 */
public class PageResult<T> extends DataResult<T> {

  /**
   * 当前页数
   */
  private long page;
  /**
   * 每页数量
   */
  private long count;
  /**
   * 总数量
   */
  private long total;
  /**
   * 总页数
   */
  private long totalPage;
  /**
   * 数据列表
   */
  private List<T> dataList;

  public PageResult(@NotNull IPage<T> page) {
    super();
    this.page = page.getCurrent();
    this.count = page.getSize();
    this.total = page.getTotal();
    this.totalPage = page.getPages();
    this.dataList = page.getRecords();
  }

  public PageResult() {
  }

  public long getPage() {
    return page;
  }

  public void setPage(long page) {
    this.page = page;
  }

  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }

  public long getTotalPage() {
    return totalPage;
  }

  public void setTotalPage(long totalPage) {
    this.totalPage = totalPage;
  }

  public List<T> getDataList() {
    return dataList;
  }

  public void setDataList(List<T> dataList) {
    this.dataList = dataList;
  }
}
