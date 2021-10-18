# Velocity

## 1. 简介

>  Velocity 是一个基于 Java 的模板引擎。它允许任何人使用简单而强大的模板语言来引用 Java 代码中定义的对象。

当 Velocity 用于 Web 开发时，Web 设计人员可以与 Java 程序员并行工作，根据模型-视图-控制器 (MVC) 模型开发网站，这意味着网页设计人员可以专注于创建一个看起来不错的网站，程序员可以只专注于编写一流的代码。Velocity 将 Java 代码与网页分开，使网站在其生命周期内更易于维护，并为[Java 服务器页面](https://java.sun.com/products/jsp/)(JSP) 或[PHP](https://www.php.net/)提供了可行的替代方案。

Velocity 的功能远远超出了网络领域；例如，它可用于从模板生成 SQL、PostScript 和 XML。它既可以用作生成源代码和报告的独立实用程序，也可以用作其他系统的集成组件。例如，Velocity 为[各种 Web 框架](https://wiki.apache.org/velocity/PoweredByVelocity)提供模板服务，使它们具有视图引擎，可根据真正的 MVC 模型促进 Web 应用程序的开发。

## 2. 快速入门

java代码

```java
public static void main(String[] args) {
    // 初始化模板引擎
    VelocityEngine ve = new VelocityEngine();
    ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
    ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
    ve.init();
    // 获取模板文件
    Template t = ve.getTemplate("hellovelocity.vm");
    // 设置变量
    VelocityContext ctx = new VelocityContext();
    ctx.put("name", "Velocity");
    List list = new ArrayList();
    list.add("1");
    list.add("2");
    ctx.put("list", list);
    // 输出
    StringWriter sw = new StringWriter();
    t.merge(ctx,sw);
    System.out.println(sw.toString());
}
```

- 初始化VelocityEngine模板引擎，对其设置参数进行初始化
- 指定ClasspathResourceLoader来加载vm文件
- 存放对象，然后在vm文件中取出，进行模板输出

编写hellovelocity.vm文件，放在classpath目录下

```velocity
#set($greet = 'hello')
$gerrt $name
#foreach($i in $list)
$i
#end
```

输出如下

```cmd
hello Velocity
1
2
```

## 3. 基本语法

### 变量

#### 定义

使用$符号声明变量，可以声明变量也可以对变量进行赋值，变量是弱类型的，

也可以使用$取出在VelocityContext容器中存放的值

```velocity
#set($directoryRoot = "www" )
#set($templateName = "index.vm" )
#set($template = "$directoryRoot/$templateName" )
$template

输出为www/index.vm
```

#### 规范写法

```velocity
${name} 也可以写成$name
当引用属性的时候不能加{}
```

#### 变量赋值

```velocity
$name="hello"
赋值的左边必须是一个变量或者属性引用，右边可以是下面六种类型之一
变量引用、字面字符串、属性引用、方法引用、字面数字、数组列表

#set( $monkey = $bill ) ## variable reference
#set( $monkey.Friend = "monica" ) ## string
#set( $monkey.Blame = $whitehouse.Leak ) ## property reference
#set( $monkey.Plan = $spindoctor.weave($web) ) ## method reference
#set( $monkey.Number = 123 ) ##number
#set( $monkey.Say = ["Not", $my, "fault"] ) ## ArrayList

注意
- 如果上述例子中的右值为null，则左值不会被赋值，也就是说会保留以前的值
- velocity模板中未被定义的变量将被认为是一个字符串
eg
#set($foo="git")
$hub=$foo
输出结果为
$hub=git
- velocity模板中不会将refrence解释为对象的实例变量
eg $foo.Name将会被解析为Foo对象的getName方法，而不是foo对象的Name实例变量
$foo.getBar()等同于$foo.Bar
$data.getUser("join")等同于$data.User("join")
data.getRequest().getServerName()等同于
${data.Request.ServerName}
```

### 循环

```velocity
#foreach ($element in $list)
This is $element.
   $velocityCount
   #end

eg:
#set( $list = ["pine", "oak", "maple"])
#foreach ($element in $list)
$velocityCount
This is $element.
#end

输出的结果为：
1 This is pine.
2 This is oak.
3 This is maple.

每次循环$list中的一个值都会赋给$element变量
$list可以是一个Vector、HashTable或者Array，分配给$element的值是一个java对象，并且可以通过变量被引用
如果$element是一个java的Product类，那么这个产品的名字可以通过调用它的getName()方法得到

#foreach ( $key in $list.keySet())
Key: $key -> Value: $list.get($key) <br>
#end
```

velocity中大小写敏感

```velocity
#foreach($foo in [1..5])
$foo
#end
输出12345

#foreach($foo in [2..-2])
$foo
#end
输出
2 1 0 -1 -2

#set($arr=[0..1])
#foreach($i in $arr)
$i
#end
输出
0 1
```

### 条件

```velocity
#if(condition)
#elseif(condition)
#else
#end
```

### 嵌套语句

```velocity
#foreach ($element in $list)
 ## inner foreach 内循环
#foreach ($element in $list)
This is $element. $velocityCount <br>inner<br>
#end
 ## inner foreach 内循环结束
 ## outer foreach
This is $element.
$velocityCount <br>outer<br>
#end
```

### 注释

```velocity
## 这是单行注释

#*
这是多行注释
*#

#**
这是文档注释
@version 1.1
*#
```

### 关系和逻辑操作符

&&  || !

### 宏

宏可以理解为函数

```velocity
## 宏的定义
#macro(宏的名称 $参数1 $参数2 ...)
	语句体
#end

## 宏的调用
#宏的名称($参数1 $参数2 ...)

```

### #stop

停止执行模板引擎并返回，可以应用于debug

### #include与#parse

#include和#parse的作用都是引入本地文件，为了安全的原因，被引入的本地文件只能在TEMPLATE_ROOT目录下

### 转义字符`\`的使用

如果reference被定义，两个`\`意味着输出一个`\`，如果未被定义，则按原样输出

```velocity
#set($email = "foo" )
$email
\$emai
l\\$email
\\\$email
输出：
foo
$email
\foo
\$email

如果$email 未定义
$email
\$email
\\$email
\\\$email
输出：
$email
\$email
\\$email
\\$email

```

### 内置对象

Velocity内置了一些对象，在vm模板里可以直接第哦啊用























