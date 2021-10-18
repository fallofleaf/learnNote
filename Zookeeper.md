# Zookeeper

## 1. Zookeeper入门

### 概述

> Zookeeper是一个开源的分布式的，为分布式框架提供协调服务的Apache项目

> Zookeeper从设计模式角度来解释：是一个基于观察者模式设计的分布式服务管理框架，它负责存储和管理大家都关系的数据，然后接受观察者的注册，一旦这些数据的状态发生编号，Zookeeper就负责通知已经在Zookeeper上注册的那些观察者做出相应的反应

1. 服务端启动时去注册信息(创建都是临时节点)
2. 获取到当前在线服务器列表，并且注册监听
3. 服务器节点下线
4. 服务器节点上下线事件通知

Zookeeper=文件系统+通知机制

### 特点

1. Zookeeper：一个领导者(Leader)，多个跟随着组成的集群Follower

   主写从读

2. 集群中只要有半数以上的节点存货，Zookeeper就能正常服务，Zookeeper适合奇数台服务器

3. 全局数据一致：每个Server保存一份相同的数据副本，Client无论连接到哪个Server，数据都是一致的

4. 更新请求顺序执行，先进先出

5. 数据更新原子性，要么成功要么失败

6. 实时性，一定时间范围内，Client能读到最新数据

### 数据结构

Zookeeper数据模型的结构和Unix文件系统很类似，整体上可以看作是一棵树，每个节点称作一个Znode，每一个Znode默认能够存储1MB的数据，每个Znode都可以通过其路径唯一标识

### 应用场景

统一命名服务、统一配置管理、统一集群管理、服务器节点动态上下线、软负载均衡等

- 统一命名服务

  在分布式环境下，经常需要对应用/服务进行统一命名，便于识别

  比如一个域名对应多个Ip，Nginx

- 统一配置管理

  一般要求一个集群中，所有节点的配置信息是一致的，比如Kafka

  对配置文件修改后，希望能快速同步到各个节点上

  配置管理可以交给Zookeeper实现

  可以将配置信息写入Zookeeper上的一个Znode，各个客户端服务器监听这个Znode

- 统一集群管理

  可以根据节点实时状态做出调整

  可以将节点信息吸入到Zookeeper上的一个Znode

  监听这个Znode可以获取它的实时状态变化

- 服务器动态上下线

- 软负载均衡

  在Zookeeper中记录每台服务器的访问数，让访问数最少的服务器去处理最新的客户端请求

### 下载地址

[Zookeeper官网](http://zookeeper.apache.org/)

[下载](http://zookeeper.apache.org/releases.html)

## 2.  Zookeeper安装



[linux虚拟机ssh](https://blog.csdn.net/qq413886183/article/details/108324798)

```bash
# 下载Zookeeper
wget https://archive.apache.org/dist/zookeeper/zookeeper-3.5.7/apache-zookeeper-3.5.7-bin.tar.gz
# 搜索相关包
sudo apt-cache search jdk
# 安装JDK
sudo apt-get install openjdk-11-jdk

root@zxkbr:~/download# cd /opt
root@zxkbr:/opt# mkdir module
root@zxkbr:/opt# cd /root/download
# 解压并复制
root@zxkbr:~/download# tar -zxvf apache-zookeeper-3.5.7-bin.tar.gz -C /opt/module/
root@zxkbr:~/download# cd /opt/module/
root@zxkbr:/opt/module# ls
apache-zookeeper-3.5.7-bin
# 改名
root@zxkbr:/opt/module# mv apache-zookeeper-3.5.7-bin/ zookeeper-3.5.7
root@zxkbr:/opt/module# ls
zookeeper-3.5.7
systemctl stop firewall
```

