# 文件上传笔记

## CommandLineRunner接口

- 需要实现在项目启动后执行的功能，SpringBoot提供的一种简单的实现方案就是添加一个model并实现CommandLineRunner接口，实现功能的代码放在实现的run方法中。

- 如果有多个类实现CommandLineRunner接口，就需要在实体类上使用一个@Order注解（@Order(value=1..)）来表明顺序。

## @Autowired

- 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。

- @Autowired注入bean，相当于在配置文件中配置bean，并且使用setter注入。

- 使用构造器注入的方法，**可以明确成员变量的加载顺序**

  ```java
  //@Autowired
  private StorageService storageService;
  
  //推荐对构造函数进行注解
  @Autowired
  public FileUploadController(StorageService storageService) {
      this.storageService = storageService;
  }
  ```
  
## Get和Post

- 使用get场景：超链接、地址栏、method="get"
- 与post的区别：
  - get方式会在地址栏显示信息，而post不会；
  - 文件上传操作必须是post，原因get容纳的信息有限，推荐使用post方式。

## @PathVariable 

- 通过 @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中：URL 中的 {xxx} 占位符可以通过@PathVariable("xxx") 绑定到操作方法的入参中。

```java
//@PathVariable可以用来映射URL中的占位符到目标方法的参数中
@RequestMapping("/test/{id}")
public String test(@PathVariable("id") Integer ids)
{
    System.out.println("testPathVariable:"+ids);
    return SUCCESS;
}
```

