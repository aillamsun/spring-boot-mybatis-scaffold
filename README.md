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

### 效果图（功能暂未实现）

![Markdown](http://i2.bvimg.com/607995/665f5fe027815230.jpg)

-----

### Swagger-UI

访问:[http://localhost:3344/swagger-ui.html](http://localhost:3344/swagger-ui.html)

![Markdown](http://i2.bvimg.com/607995/241eb08cf9fd7f3e.jpg)



##scaffold-restapi

api服务端脚手架
拦截/api/**请求,通过header验证请求的合法性,(类似JWT)<br>

### 测试 spring security With Jwtt

直接启动运行 RestApiAppMain 类

访问:[http://localhost:3345](http://localhost:3345)

### 效果图

#### 未登录
![Markdown](http://i2.bvimg.com/607995/6c1ed865cb00195f.jpg)

-----
#### 登录成功

![Markdown](http://i2.bvimg.com/607995/b212c49d89276492.jpg)



欢迎各位大神来吐槽.
