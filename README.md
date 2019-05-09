# cloud-yesk
1，配置注册中心，配置中心，路由为基础，freemarker模板引擎，发散式的代码结构

2019-04-24 16:14 update:增加查询表数据 <br>
2019-04-24 17:14 update:拆分模块日志<br>
2019-04-28 09:42 update:jackson版本<br>
2019-04-28 14.48 add:swagger2<br>
swagger用法<br>
常用注解： <br>
- @Api()用于类； <br>
表示标识这个类是swagger的资源 <br>
- @ApiOperation()用于方法； <br>
表示一个http请求的操作 <br>
- @ApiParam()用于方法，参数，字段说明； <br>
表示对参数的添加元数据（说明或是否必填等） <br>
- @ApiModel()用于类 <br>
表示对类进行说明，用于参数用实体类接收 <br>
- @ApiModelProperty()用于方法，字段 <br>
表示对model属性的说明或者数据操作更改 <br>
- @ApiIgnore()用于类，方法，方法参数 <br>
表示这个方法或者类被忽略 <br>
- @ApiImplicitParam() 用于方法 <br>
表示单独的请求参数 <br>
- @ApiImplicitParams() 用于方法，包含多个 @ApiImplicitParam<br>

2019-04-28 18.03 add:redis缓存机制 非持久化，持久化单独配置<br>

2019-04-28 13:38 add:redis级别锁，非集群，性能优于数据库锁
下期----增加
