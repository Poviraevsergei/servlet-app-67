package com.tms.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class FirstListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Application listener: UP");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Application listener: DOWN");
    }
}
