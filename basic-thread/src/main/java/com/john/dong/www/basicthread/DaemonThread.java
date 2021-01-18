package com.john.dong.www.basicthread;

import lombok.extern.slf4j.Slf4j;

/**
 * 守护线程,主线程结束，自动结束.
 */
@Slf4j
public class DaemonThread {

  /**
   * 测试方法.
   *
   * @param args
   *
   */
  public static void main(String[] args) {

    Thread t1 = new Thread(() -> {
      while (true) {
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          log.warn("子线程发生异常", e);
          Thread.currentThread().interrupt();
        }
        log.info("子线程正在运行");
      }
    });
    t1.setDaemon(true);
    t1.start();
    for (int i = 1; i < 10; i++) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        log.warn("主线程发生异常", e);
        Thread.currentThread().interrupt();
      }
    }
    log.info("主线程结束");
  }
}
