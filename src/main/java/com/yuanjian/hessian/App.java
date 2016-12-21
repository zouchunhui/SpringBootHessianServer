package com.yuanjian.hessian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.DispatcherServlet;


/**
 * yujian.yang
 */
@SpringBootApplication
@PropertySources({@PropertySource("classpath:environments/application.properties")})
@ImportResource("classpath*:/spring/spring-root-context.xml")
@ComponentScan(basePackages = {"com.yuanjian.hessian"})
@EnableScheduling//定时任务
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class,args);
    }
    
    @Bean
    public ServletRegistrationBean hessianServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean();
        bean.setName("hessianServlet");
        bean.setEnabled(true);
        
        DispatcherServlet servlet = new DispatcherServlet();
        
        /**
         * DispatcherServlet.initHandlerMappings中
         * Map<String, HandlerMapping> matchingBeans = BeanFactoryUtils.beansOfTypeIncludingAncestors(context, HandlerMapping.class, true, false);
         * 上面拿到的BeanNameUrlHandlerMapping没有hessianExport的url，
         * 将detectAllHandlerMappings设为false，通过this.handlerMappings = getDefaultStrategies(context, HandlerMapping.class);
         * 这样拿到的BeanNameUrlHandlerMapping是包含hessianExport的url。
         * 初步判断是spring boot中context的继承关系导致的
         * TODO 这是临时解决问题的方案，需要深入了解一下为什么BeanFactoryUtils.beansOfTypeIncludingAncestors拿不到hessianExport的url mapping
         */
        servlet.setDetectAllHandlerMappings(false);
        bean.setServlet(servlet);
        bean.addInitParameter("contextConfigLocation", "classpath*:/spring/spring-hessian-service.xml");
        bean.setLoadOnStartup(1);
        
        bean.addUrlMappings("/api/hessian/*");
        
        return bean;
    }
}
