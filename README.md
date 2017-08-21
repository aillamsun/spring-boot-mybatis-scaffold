# spring-boot-mybatis-scaffold
spring-boot-mybatis-scaffold

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



##scaffold-restapi

api服务端脚手架
拦截/api/**请求,通过header验证请求的合法性,(类似JWT)<br>

### 测试 spring security With Jwtt

直接启动运行 RestApiAppMain 类

访问:[http://localhost:3345](http://localhost:3345)

### 效果提


欢迎各位大神来吐槽.
