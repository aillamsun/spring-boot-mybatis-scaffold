# spring-boot-mybatis-scaffold
spring-boot-mybatis-scaffold

通用技术选型：

    springboot脚手架，集成mybatis freemarker security为一体,使用mybatis 通用分页pagehelper. 通用Mapper.
    
    

集成:
> * spring-boot-starter-swagger
> * druid-spring-boot-starter



#开发工具
项目使用了lombok 用idea开发的小伙伴请安装lombok插件，不然会提示报错

#项目结构
   <modules>
        <module>scaffold-core</module>
        <module>scaffold-example</module>
        <module>scaffold-utils</module>
        <module>scaffold-mapper</module>
        <module>scaffold-model</module>
        <module>scaffold-restapi</module>
  </modules>



#运行方式


##scaffold-example
通用后台脚手架

访问:[http://localhost:3344](http://localhost:3344)

### 效果提

![Markdown](http://i1.bvimg.com/607995/67f078816fa10f83.jpg)

-----

### Swagger-UI

访问:[http://localhost:3344/swagger-ui.html](http://localhost:3344/swagger-ui.html)

![Markdown](http://i1.bvimg.com/607995/e3b97eb44e672909.jpg)



##scaffold-restapi

api服务端脚手架
拦截/api/**请求,通过header验证请求的合法性,(类似JWT)<br>

### 测试 spring security With Jwtt

直接启动运行 RestApiAppMain 类

访问:[http://localhost:3345](http://localhost:3345)

### 效果提

#### 未登录
![Markdown](http://i4.bvimg.com/607995/ffe926a0c0ac9adf.jpg)

-----
#### 登录成功

![Markdown](http://i4.bvimg.com/607995/3c99d23bdd0fdf6e.jpg)



欢迎各位大神来吐槽.
