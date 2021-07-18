一、
1、mvn clean ; 
2、mvn clean package -Dmaven.test.skip=true;
3、java -jar  *.jar

4、mybatis、redis、spring security、nginx、rabbitmq(kafka)

5、spring cloud 和dubbo ，spring cloud alibaba、spring boot admin
6、nacos、zookeeper、配置中心、devops、docker (k8s)
7、服务健康、业务日志、链路日志
8、十大排序算法+23种设计模式

二、网关、微服务(分布式)、管理后台
1、rpc 协议

三、工具
1、virtualbox、kvm
2、更改docker仓库源，参考：https://www.jianshu.com/p/dfd30e94b517
阿里云源:
``` json
{
"registry-mirrors": ["https://3laho3y3.mirror.aliyuncs.com"]
}
```

yum install -y vim net-tools telnet  lrzsz 

linux 查询某一个端口是否有进程在运行： netstat -tunpl | grep 9003
windows 查询某一个端口是否有进程在运行： netstat -ano | findstr 9003

linux操作系统重启命令是reboot，(关闭命令：shutdown -h 0)

docker 开始、重启、停止： systemctl start/restart/stop docker
防火墙 开始、重启、停止：systemctl start/restart/stop firewalld
防火墙禁用： systemctl disable firewalld
防火墙开启： systrmctl enable firewalld

docker run 和docker start

mysql 用户授权命令：
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY '123456';
flush privileges;


1、http、https 各自的流程







