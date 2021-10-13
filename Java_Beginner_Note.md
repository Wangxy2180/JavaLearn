# 贪吃蛇部分

对于一个新的java项目，为了养成规范，一般会新建一些包

右键src，新建package(com.learn.snake; static)

java执行jar包,class

```
java -jar xxx.jar
执行class文件必须在主目录下，要不然会报错无法加载主类
java xxx
```





打包方式：

project structure -> Artifacts -> add -> JAR -> from module and dependences ->选择main方法 -> apply

然后在idea任务栏build-> build artifact。然后再out文件夹中就出现了



# 网络编程部分

 计算机端口有65536个,0到1023的端口我们称为注册端口;从1024到49151称为公认端口;49152到65535为动态和私有端口

```
查看所有端口 netstat -ano
netstat -ano | findstr "5900"
tasklist | findstr "QQ" 查看指定端口的进程
```

TCP先运行server，再运行client，demo01是传文字，demo02是传文件

UDP中01是一方发送一方接收的窗口







# Tomcat

/bin/startup启动

webapps就是你的网站内容，你可以在这新建文件夹存放资源，如现在上一层目录的那个tomcat所示，并且你修改完文件后，一刷新他就更新了

localhost:8080/testPage/testPage.txt

