package yyf256.top.blog.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import yyf256.top.blog.config.contants.SystemConfigKeyContants;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartListener implements ServletContextListener {

    @Value("${server.servlet.context-path}")
    private String projectName;


    private Logger logger = LogManager.getLogger(StartListener.class);


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute(SystemConfigKeyContants.PROJECT_NAME,projectName);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
