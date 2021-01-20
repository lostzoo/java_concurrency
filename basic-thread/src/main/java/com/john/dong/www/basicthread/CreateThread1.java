package com.john.dong.www.basicthread;

import lombok.extern.slf4j.Slf4j;

/**
 * 继承Thread方式，创建线程.
 *
 */
@Slf4j
public class CreateThread1 extends Thread {
  @Override
  public void run() {
    log.info("子线程，名称：" + getName() + ",Id:" + getId());
  }

  /**
   * 运行测试类.
   *
   * @param args
   *
   */
  public static void main(String[] args) {

    log.info("主线程，名称" + Thread.currentThread().getName() + ",Id:" + Thread.currentThread().getId());

    CreateThread1 t1 = new CreateThread1();
    t1.start();
  }
}
