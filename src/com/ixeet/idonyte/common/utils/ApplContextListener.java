/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ixeet.idonyte.common.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author dell
 */
@WebListener()
public class ApplContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context initialized...........iDonyte");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context destroyed...........iDonyte");
    }
    
    
}
