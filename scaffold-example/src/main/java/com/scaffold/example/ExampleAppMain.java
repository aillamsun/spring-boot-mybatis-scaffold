package com.scaffold.example;

import com.didispace.swagger.EnableSwagger2Doc;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.Locale;

/**
 * Created by sungang on 2017/8/19.
 */
@SpringBootApplication
@PropertySources({
        //默认配置
        @PropertySource("classpath:secure.properties"),
        //tomcat目录下
        @PropertySource(value = "file:${CATALINA_BASE}/conf/secure.properties", ignoreResourceNotFound = true),

        //${user.dir} 运行在项目同目录下
        @PropertySource(value = "file:${user.dir}/conf/secure.properties", ignoreResourceNotFound = true)
})
@Slf4j
//@EnableAspectJAutoProxy
@EnableSwagger2Doc
@MapperScan("com.scaffold.mapper")
@ComponentScan("com.scaffold")
//开启 缓存
@EnableCaching
public class ExampleAppMain extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ExampleAppMain.class);
    }

    /**
     * spring boot 服务主入口
     *
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ExampleAppMain.class, args);
        if (context instanceof EmbeddedWebApplicationContext) {
            int port = ((EmbeddedWebApplicationContext) context).getEmbeddedServletContainer().getPort();
            String contextPath = context.getApplicationName();
            String url = String.format(Locale.SIMPLIFIED_CHINESE, "http://localhost:%d%s", port, contextPath);

            //提示项目用到的相关配置文件
            log.info(" =========== ${user.dir}={} ===========  ", System.getProperty("user.dir"));
            log.info(" =========== ${java.io.tmpdir}={} ===========  ", System.getProperty("java.io.tmpdir"));

            String dashes = "------------------------------------------------------------------------";
            log.info("Access URLs:\n{}\n\tLocal: \t\t{}\n{}", dashes, url, dashes);
        }
    }
}
