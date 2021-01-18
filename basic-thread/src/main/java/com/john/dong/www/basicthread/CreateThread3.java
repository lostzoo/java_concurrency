package com.john.dong.www.basicthread;

import lombok.extern.slf4j.Slf4j;

/**
 * 匿名类创建线程.
 */
@Slf4j
public class CreateThread3 {


  /**
   * 运行测试类.
   *
   * @param args
   *
   */
  public static void main(String[] args) {

    log.info("主线程，名称" + Thread.currentThread().getName() + ",Id:" + Thread.currentThread().getId());

    Thread t3 = new Thread(new Runnable() {
      @Override
      public void run() {
        log.info("匿名类创建子线程，名称：" + Thread.currentThread().getName() + ",Id:"
            + Thread.currentThread().getId());
      }
    });

    Thread t4 = new Thread(() -> log.info("lamda表达式创建子线程，名称：" + Thread.currentThread().getName()
        + ",Id:" + Thread.currentThread().getId()));

    t3.start();
    t4.start();
  }

}
