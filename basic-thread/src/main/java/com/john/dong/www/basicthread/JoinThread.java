package com.john.dong.www.basicthread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JoinThread {
  /**
   * Join 方法示例.
   *
   */
  public static void main(String[] args) {

    Thread t1 = new Thread(() -> {

      for (int i = 0; i < 10; i++) {
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          log.warn("线程1异常", e);
          Thread.currentThread().interrupt();
        }
        log.info("线程1正在运行");
      }
      log.info("线程1运行结束,名称" + Thread.currentThread().getName() + ",Id:"
          + Thread.currentThread().getId());

    });

    Thread t2 = new Thread(() -> {
      try {
        t1.join();
      } catch (InterruptedException e) {
        log.warn("线程2异常", e);
        Thread.currentThread().interrupt();
      }
      for (int i = 0; i < 10; i++) {
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          log.warn("线程2异常", e);
          Thread.currentThread().interrupt();
        }
        log.info("线程2正在运行");
      }
      log.info("线程2运行结束，名称" + Thread.currentThread().getName() + ",Id:"
          + Thread.currentThread().getId());

    });


    Thread t3 = new Thread(() -> {
      try {
        t2.join();
      } catch (InterruptedException e) {
        log.warn("线程3异常", e);
        Thread.currentThread().interrupt();
      }
      for (int i = 0; i < 10; i++) {
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          log.warn("线程3异常", e);
          Thread.currentThread().interrupt();
        }
        log.info("线程3正在运行");
      }
      log.info("线程3运行结束,名称" + Thread.currentThread().getName() + ",Id:"
          + Thread.currentThread().getId());

    });


    t1.start();
    t2.start();
    t3.start();


  }
}
