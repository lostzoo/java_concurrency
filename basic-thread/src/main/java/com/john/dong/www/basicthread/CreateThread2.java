package com.john.dong.www.basicthread;

import lombok.extern.slf4j.Slf4j;

/**
 * 实现runnable接口，创建线程.
 */
@Slf4j
public class CreateThread2 implements Runnable {


  @Override
  public void run() {
    log.info(
        "子线程，名称：" + Thread.currentThread().getName() + ",Id:" + Thread.currentThread().getId());
  }

  /**
   * 运行测试类.
   *
   * @param args
   *
   */
  public static void main(String[] args) {

    log.info("主线程，名称" + Thread.currentThread().getName() + ",Id:" + Thread.currentThread().getId());

    Thread t2 = new Thread(new CreateThread2());

    t2.start();
  }

}
