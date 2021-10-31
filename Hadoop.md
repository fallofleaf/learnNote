# Hadoop

## 课程基础

javase + maven +idea +linux基本命令

## 1. 概述

### 大数据的概念

​	大数据是指无法在一定时间范围内用常规软件工具进行捕获、管理和处理的数据集合，是需要新处理模式才能具有更强的决策力、洞察发现和流程优化能力的海量、高增长率和多样化的信息资产

​	大数据主要解决海量数据的采集、存储和分析计算问题

​	按顺序给出数据存储单位 bit、Byte、KB、MB、GB、**TB**、**PB**、**EB**、ZB、YB、BB、NB、DB

​	1Byte = 8bit 1K = 1024Byte 1MB=1024K 1G =1024M

### 大数据的特点(4V)

#### Volume 大量

​	截至目前，人类所生产的所有印刷材料的数据量是200PB，而历史上全人类总共说过的话数据量大约是5EB，当前，典型个人计算机硬盘的容量为TB量级，而一些大企业的数据量已经解决EB量级

#### Velocity 高速

​	这是大数据区分于传统数据挖掘最显著特征，根据IDC的数字宇宙的报告，预计到2025年，全球数据使用量将达到163ZB，在海量的数据面前，处理数据的效率非常重要。

#### Variety 多样

​	数据的类型分为结构化数据和非结构化数据，相对于以数据库/文本为主的结构化数据，非结构化数据越来越多，包括网络日志、音频、视频、图片、地理位置信息等，这些多类型的数据对数据的处理能力提出了更高的要求

#### Value 低价值密度

​	价值密度的高低与数据总量的大小成反比，从海量的数据中对有效数据进行提取

### 大数据的应用场景

1. 短视频，视频推荐

2. 电商广告推荐，推荐用户喜欢的商品

3. 零售，分析用户消费习惯 ，判断用户购买商品的关联性

4. 物流仓储
5. 保险，海量数据挖掘，风险预测
6. 金融，多维度体现用户特征，防范欺诈
7. 房产，精准投资和营销
8. 人工智能 5G 物联网 虚拟与现实

### 大数据的发展前景

1. 十九大 推动互联网 互联网 人工智能 实体经济深度融合
2. 2020 34万亿 新基建
3. 下一个风口 2020 5G设备 每秒钟10G的数据
4. 人才紧缺，竞争压力小

### 大数据部门间业务流程分析

产品人员提需求

数据部门搭建数据平台、分析数据指标

数据可视化

### 大数据部门内组织结构

```mermaid
flowchart TB
id(大数据部门组织结构) 
id --> 平台组 --> id2(Hadoop Flume Kafka \n HBase Spark等框架平台搭建) --> 集群性能监控 --> 集群性能调优 
id --> 数据仓库组 --> ETL工程师数据清洗 --> id3(数据分析\n数据仓库建模)
id --> 实时组 --> id4(实时指标分\n析性能调优)
id --> 数据挖掘组 --> 算法工程师 --> 推荐系统工程师 --> 用户画像工程师
id --> 报表开发组 --> JavaEE工程师 --> 前端工程师
```

## 2. Hadoop入门

```mermaid
flowchart LR
id(Hadoop入门) --> id11(概念)
	id11 --> Hadoop是什么
	id11 --> Hadoop发展历史
	id11 --> Hadoop三大发行版本
	id11 --> Hadoop的优势
	id11 --> Hadoop的组成
	id11 --> 大数据技术生态体系
	id11 --> 推荐系统案例
id --> id12(环境准备)
	id12 --> 模板虚拟机准备
	id12 --> 克隆
	id12 --> id121(安装JDK Hadoop)
id --> id13(Hadoop生产集群搭建)
	id13 --> 本地模式
	id13 --> 完全分布式集群重点
id --> 常见错误的解决方案
```

### 1. 概念

#### Hadoop是什么

1. Hadoop是一个由Apache基金会所开发的**分布式系统基础架构**

2. 主要解决海量数据的存储和海量数据的分析计算问题

3. 广义上来说Hadoop通常指一个更广泛的概念Hadoop生态圈

![img](Hadoop.assets/6422782-fbfd2b834ed3707d.png)

![img](Hadoop.assets/855959-20170903081527062-674324908.png)

Hive干掉Pig

#### Hadoop发展历史

1. Hadoop创始人Doug Cutting，为了实现与Google类似的全文搜索功能，在Lucene框架基础上进行优化升级，查询引擎和索引引擎

2. 2001年底Lucene称为Apache基金会的一个子项目

3. 对于海量数据的场景，Lucene框架面对与Google同样的困难，存储海量数据困难，检索海量数据速度慢

4. 学习和模仿Google解决这些问题的防范：微型版Nutch

5. Google在大数据方面的三篇论文
   - **GFS --> HDFS**
   - **Map-Reduce --> MR**
   - **BigTable --> HBase**
6. 2003-2004年，Google公开了部分GFS和MapReduce思想的细节，以此为基础Foug Cutting等人用了2年业余时间实现了DFS和MapReduce机制，使Nutch性能飙升
7. 2005年Hadoop作为Lucene的子项目Nutch的一部分正式引入Apache基金会
8. 2006年3月份，Map-Reduce和Nutch Distributed File System(NDFS)分别被纳入到Hadoop项目中，Hadoop正式诞生，标志着大数据时代到来

#### Hadoop三大发行版本

Apache、Cloudera、Hortonworks

Apache版本最原始最基础版本，入门 2006

Cloudera内部集成了很多大数据框架，对应产品CDH

Hortonworks文档较好，对应产品HDP 2011

Hortonworks现在已经被Cloudera公司收购，推出新的品牌CDP

##### Apache Hadoop

http://hadoop.apache.org/

https://hadoop.apache.org/releases.html

##### Cloudera Hadoop

https://cn.cloudera.com/products/open-source/apache-hadoop.html

2009年Hadoop创始人Doug Cutting加盟Cloudera公司

CDH为Cloudera的Hadoop发行版，完全开源，节点收费

##### Hortonworks Hadoop

HDP包括了Ambarl，开源安装和管理系统

#### Hadoop优势(4高)

1. 高可靠性
   - Hadoop底层维护多个数据副本，所以即使Hadoop某个计算元素或存储出现故障，也不会导致数据的丢失
2. 高扩展性
   - 在集群间分配任务数据，可方便的扩展数以千计的节点，动态扩容
3. 高效性
   - 在MapReduce的思想下，Hadoop是并行进行的，以加快任务的处理速度
4. 高容错性
   - 能够自动将失败的任务重新分配

#### Hadoop组成(重点)

```mermaid
flowchart TB
subgraph Hadoop2.x组成
	MapReduce计算
	Yarn资源调度
	id1(HDFS数据存储)
	id(Common辅助工具)
end
subgraph Hadoop1.x组成
	MapReduce\n计算+资源调度
	HDFS数据存储
	Common辅助工具
end

```

在Hadoop1.x时代，Hadoop中的MapReduce同时处理业务逻辑运算和资源的调度，耦合性较大

**在Hadoop2.0时代，增加了Yarn。Yarn只负责资源的调度，MapReduce只负责运算**。

Hadoop3.x在组成上没有变化

##### HDFS架构概述

Hadoop Distributed File System 简称HDFS，是一个分布式文件系统

NameNode nn

- 存储文件的元数据，如文件名、文件目录结构、文件属性(生成时间、副本数、文件权限)，以及每个文件的块列表和块所在的DataNode等

DataNode dn

- 在本地文件系统存储文件块数据，以及块数据的校验和

Secondary NameNode 2nn

- 每隔一段时间对NameNode元数据备份

```mermaid
flowchart TB
id(NameNode\n数据存在哪)
	id --> DataNode\n具体的数据
	id --> DataNode2
	id --> DataNode3
2NN\n备份元数据
```



##### YARN架构概述

Yet Another Rsource Negotiator简称YARN，另一种资源协调者，是Hadoop的资源管理器

1. ResourceManager(RM):整个集群资源(内存、CUP等)的管理者
2. NodeManager(NM):单个节点服务器资源的管理者
3. ApplicationMaster(AM):单个任务运行的管理者
4. Container:容器，相当于一台独立的服务器，里面封装了任务运行的资源，如内存、CPU、磁盘、网络等

```mermaid
flowchart LR
client1 -.-> id(Resource Manager\n12G内存6CPU)
client2 -.-> id
id --> NodeManager1\n4G内存2CPU
id --> NodeManager2\n4G内存2CPU
id --> NodeManager3\n4G内存2CPU
```

客户端可以有多个

集群上可以运行多个AM，每个容器最少一个CPU，容器可以跨节点

每个NodeManager上可以有多个Container

##### MapReduce架构概述

MapReduce将计算过程分为两个阶段，Map和Reduce

1. Map阶段并行处理输入数据
2. Reduce阶段对Map结果进行汇总

```mermaid
flowchart LR
id(待分析数据)
id --Map-->Hadoop1 --Reduce--> id2(汇总服务器)
id --Map-->Hadoop2 --Reduce--> id2(汇总服务器)
id --Map-->Hadoop3 --Reduce--> id2(汇总服务器)
id --Map-->Hadoop4 --Reduce--> id2(汇总服务器)
```

##### HDFS、YARN、MapReduce三者关系

![image-20211021155543595](Hadoop.assets/image-20211021155543595.png)

#### 大数据技术生态体系

![image-20211021155910782](Hadoop.assets/image-20211021155910782.png)

1. Sqoop: Sqoop是一款开源的工具，主要用于Hadoop、Hive与传统的数据库MySQL间进行数据的传输，可以将一个关系型数据库(如MySQL、Roacle等)中的数据导入到Hadoop的HDFS中，也可以将HDFS的数据导入到关系型数据库中
2. Flume: Flume是一个高可用的、高可靠的分布式的海量日志采集、聚合和传输的系统，Flume支持在日志系统中定制各类数据发送方，用于收集数据
3. Kafka: Kafka是一种高吞吐量的分布式发布订阅消息系统
4. Spark: Spark是当前最流行的开源大数据内存计算框架，可以基于Hadoop上存储的大数据进行计算
5. FlinkL: Flink是当前最流行的开源大数据内存计算框架，用于实时计算的场景较多
6. Oozie: Oozie是一个管理Hadoop作业(job)的工作流程调度管理系统
7. Hbase: Hbase是一个分布式的、面向列的开源数据库。Hbase不同于一般的关系数据库，它是一个适合于非结构化数据存储的数据库
8. Hive: Hive是基于Hadoop的一个数据仓库工具，可以将结构化数据文件映射为一张数据库表，并提供简单的SQL查询功能，可以将SQL语句转换为MapReduce任务进行运行，其优点是学习成本低，可以通过类SQL语句快速实现简单的MapReduce统计，不必开发专门的MapReduce应用，是否适合数据仓库的统计分析
9. Zookeeper: 它是一个针对大型分布式系统的可靠协调系统，提供的功能包括:配置维护、名字复位、分布式同步、组服务等

#### 推荐系统架构图

![image-20211021163857532](Hadoop.assets/image-20211021163857532.png)

### 2. Hadoop运行环境搭建(重点)

#### Hadoop模板搭建

内存4G，硬盘50g，IP，主机名称

后续的Hadoop服务器可以以此为模板进行复制

##### 安装步骤

1. 安装VMWare

2. 安装Centos
   - 配置IP、主机名称
   - 注意虚拟机的内核数不要超过宿主机的内核数
   - IP地址配置 
     - Vmware添加配置192.168.10.0，然后在网络连接方式那里选择NAT网络模式
     - windows以太网，更改适配器选项
       - vmnet1是为host-only方式服务的，vmnet8是为NAT方式服务的。
       - 修改vmnet8 属性 Internet协议版本4，依次为
         - 192.168.10.1
         - 255.255.255.0
         - 192.168.10.2
         - 192.168.10.2
         - 8.8.8.8
     - Centos
       - vim /etc/sysconfig/network-scripts/ifcfg-ens33 最后的设备名根据具体识别的名字选取
       - BOOTPROTO改为statici
       - 添加 
         - IPADDR=192.168.10.100
         - GATEWAY=192.168.10.2
         - DNS1=192.168.10.2
       - vim /etc/hostname
         - 改为 hadoop100
       - vim /etc/hosts
         - 添加ip映射 192.168.10.100 hadoop100
         - 一直到192.168.10.108 hadoop108
     - reboot重启  通过ping命令检测配置是否成功
   
3. 配置ssh访问

   - XSHELL或MobaXterm

4. 配置映射

   - 使Xshell或MobaXterm可以直接通过主机名连接

   - Windows电脑C:\Windows\System32\drivers\etc\hosts添加host映射

   - ```
     192.168.10.100 hadoop100
     192.168.10.101 hadoop101
     192.168.10.102 hadoop102
     192.168.10.103 hadoop103
     192.168.10.104 hadoop104
     192.168.10.105 hadoop105
     192.168.10.106 hadoop106
     192.168.10.107 hadoop107
     192.168.10.108 hadoop108
     ```

   - xshell还需要配置xftp进行文件的上传

5. centos安装epel-release

   - Extra Packages for Enterprise Linux是为红帽系的操作系统提供额外的软件包，适用于RHEL、Centos和Scientific Linux，相当于是一个软件仓库，大多数rmp包在官方的repository中是找不到的
   - yum install -y epel-release
   - 如果linux安装的是最小系统版，还需要安装如下工具，如果是桌面标准版则不需要
     - net-tool工具包集合，包含ifconfig等命令
     - yum install -y net-tools
     - yum install -y vim
   - 关闭防火墙，关闭防火墙开机自启
     - systemctl stop firewalld
     - systemctl disable firewalld.service
     - 在企业开发时，通常单个服务器的防火墙是关闭的，公司整体会对外设置非常安全的防火墙

6. 添加zxk用户，如果已经有了就只需要添加权限

   - useradd zxk
   - passwd zxk
   - vim /etc/sudoers
   - 在%wheel 下面添加
     - zxk ALL=(ALL) NOPASSWD:ALL

7. 创建和删除文件就可以加上sudo

   - ```bash
     [zxk@hadoop100 ~]$ cd /opt/
     [zxk@hadoop100 opt]$ ls
     rh
     [zxk@hadoop100 opt]$ rm -rf rh/
     rm: 无法删除"rh/": 权限不够
     [zxk@hadoop100 opt]$ sudo rm -rf rh/
     [zxk@hadoop100 opt]$ mkdir module
     mkdir: 无法创建目录"module": 权限不够
     [zxk@hadoop100 opt]$ sudo mkdir module
     [zxk@hadoop100 opt]$ sudo mkdir software
     [zxk@hadoop100 opt]$ sudo chown zxk
     chown: "zxk" 后缺少操作数
     Try 'chown --help' for more information.
     #修改权限
     [zxk@hadoop100 opt]$ sudo chown zxk:zxk module
     [zxk@hadoop100 opt]$ sudo chown zxk:zxk module/ software/
     [zxk@hadoop100 opt]$
     
     ```

8. 卸载自带的JDK

   - 虚拟机最小化安装不需要执行这一步
   - su root
   - rpm -qa | grep -i java | xargs -n1 rpm -e --nodeps
     - rpm -qa 查询安装的所有rpm包
     - grep -i 忽略大小写
     - xargs -n1 每次只传递一个参数
     - rpm -e --nodeps 强制卸载软件
   - reboot

#### 克隆虚拟机

Hadoop100 Hadoop102 Hadoop103 Hadoop104 搭建真正的分布式集群

修改IP

- vim /etc/sysconfig/network-scripts/ifcfg-ens33
- IPADDR=192.168.10.102   
- IPADDR=192.168.10.103
- IPADDR=192.168.10.104

主机名 

vim /etc/hostname

- 改为 hadoop102 hadoop103 hadoop104

Hadoop101留作伪分布式，单台服务器的操作使用，这里暂时不克隆，克隆时先关机

注意创建的是完整克隆

对应XSHELL和MobaXterm

@QAZ741

#### 在hadoop安装JDK

1. 卸载现有JDK

2. 用Xshell或MobaXterm将JDK导入到opt目录下的software文件夹下

   - 在Hadoop102安装好JDK后，之后拷贝到Hadoop103和Hadoop104

3. OpenJDK下载地址

   - http://jdk.java.net/java-se-ri/8-MR3
   - https://download.java.net/openjdk/jdk8u41/ri/openjdk-8u41-b04-linux-x64-14_jan_2020.tar.gz

4. Hadoop3下载地址

   - https://hadoop.apache.org/releases.html
   - https://www.apache.org/dyn/closer.cgi/hadoop/common/hadoop-3.3.1/hadoop-3.3.1.tar.gz

5. 将JDK和Hadoop上传到Hadoop102 的/opt/software/下

6. 安装JDK

   ```bash
   [zxk@hadoop102 software]$ tar -zxvf openjdk-8u41-b04-linux-x64-14_jan_2020.tar.gz -C /opt/module/
   [zxk@hadoop102 software]$ cd ..
   [zxk@hadoop102 opt]$ cd module/
   [zxk@hadoop102 module]$ cd java-se-8u41-ri/
   [zxk@hadoop102 java-se-8u41-ri]$ ll
   # 查看里面环境变量的配置可以看到启动时会依次加载/etc/profile.d文件夹下的.sh文件
   # 所以可以直接在此目录下新建对应的sh脚本加载环境变量
   [zxk@hadoop102 java-se-8u41-ri]$ sudo cat /etc/profile
   [zxk@hadoop102 java-se-8u41-ri]$ cd /etc/profile.d/
   [zxk@hadoop102 java-se-8u41-ri]$ ll
   #新建环境配置文件
   [zxk@hadoop102 java-se-8u41-ri]$ sudo vim my_env.sh 
   #内容为 export是全局变量，需要全局生效
   #JAVA_HOME
   export JAVA_HOME=/opt/module/java-se-8u41-ri
   export PATH=$PATH:$JAVA_HOME/bin
   # 重新加载文件
   [zxk@hadoop102 java-se-8u41-ri]$ source /etc/profile
   #输入java查看是否配置成功
   [zxk@hadoop102 profile.d]$ java -version
   openjdk version "1.8.0_41"
   OpenJDK Runtime Environment (build 1.8.0_41-b04)
   OpenJDK 64-Bit Server VM (build 25.40-b25, mixed mode)
   ```

#### 在Hadoop102安装Hadoop

```bash
[zxk@hadoop102 profile.d]$ cd /opt/software/
[zxk@hadoop102 software]$ ll
总用量 761208
-rw-rw-r--. 1 zxk zxk 605187279 10月 22 22:23 hadoop-3.3.1.tar.gz
-rw-rw-r--. 1 zxk zxk 174287938 10月 22 22:23 openjdk-8u41-b04-linux-x64-14_jan_2020.tar.gz
[zxk@hadoop102 software]$ tar -zxvf hadoop-3.3.1.tar.gz -C /opt/module/
[zxk@hadoop102 hadoop-3.3.1]$ pwd
/opt/module/hadoop-3.3.1
[zxk@hadoop102 hadoop-3.3.1]$ sudo vim /etc/profile.d/my_env.sh
# 内容为
#JAVA_HOME
export JAVA_HOME=/opt/module/java-se-8u41-ri
export PATH=$PATH:$JAVA_HOME/bin

#HADOOP_HOME
export HADOOP_HOME=/opt/module/hadoop-3.3.1

export PATH=$PATH:$HADOOP_HOME/bin
export PATH=$PATH:$HADOOP_HOME/sbin
# 刷新文件夹
[zxk@hadoop102 hadoop-3.3.1]$ source /etc/profile
[zxk@hadoop102 hadoop-3.3.1]$ hadoop
```

Hadoop文件夹结构

```bash
drwxr-xr-x. 2 zxk zxk   203 6月  15 13:52 bin
drwxr-xr-x. 3 zxk zxk    20 6月  15 13:15 etc
drwxr-xr-x. 2 zxk zxk   106 6月  15 13:52 include
drwxr-xr-x. 3 zxk zxk    20 6月  15 13:52 lib
drwxr-xr-x. 4 zxk zxk   288 6月  15 13:52 libexec
-rw-rw-r--. 1 zxk zxk 23450 6月  15 13:02 LICENSE-binary
drwxr-xr-x. 2 zxk zxk  4096 6月  15 13:52 licenses-binary
-rw-rw-r--. 1 zxk zxk 15217 6月  15 13:02 LICENSE.txt
-rw-rw-r--. 1 zxk zxk 29473 6月  15 13:02 NOTICE-binary
-rw-rw-r--. 1 zxk zxk  1541 5月  22 00:11 NOTICE.txt
-rw-rw-r--. 1 zxk zxk   175 5月  22 00:11 README.txt
drwxr-xr-x. 3 zxk zxk  4096 6月  15 13:15 sbin
drwxr-xr-x. 4 zxk zxk    31 6月  15 14:18 share
```

- bin和hdfs mapred yarn
- etc 存放相关配置文件hdfs-site.xml  core-site.xml  mapred-site.xml  yarn-site.xml  works
- lib 本地链接库
- sbin start-dfs.sh   start-yarn.sh  
- share 学习资料

### 3. Hadoop运行模式

1. Hadoop官网 http://hadoop.apache.org/
2. Hadoop运行模式包括本地模式、伪分布式模式以及完全分布式模式
   - 本地模式 单机运行 只是用来演示官方案例，生产环境不用
   - 伪分布式模式 也是单机运行，但是具备Hadoop集群的所有功能，一台机器模拟一个分布式的环境，个别公司用来进行测试，生产环境不用
   - 完全分布模式 多台服务器组成分布式环境，生产环境使用
3. 模式存储区别
   - 本地模式 数据存储在linux本地
   - 伪分布式 数据存储在HDFS
   - 完全分布式 数据存储在HDFS 多台服务器工作

#### 本地运行模式(WordCount)

```bash
[zxk@hadoop102 ~]$ cd /opt/module/hadoop-3.3.1/
[zxk@hadoop102 hadoop-3.3.1]$ mkdir wcinput
[zxk@hadoop102 hadoop-3.3.1]$ cd wcinput/
[zxk@hadoop102 wcinput]$ vim word.txt
# 输入
bird
light dark
human boy girl
darker name
# :wq退出
[zxk@hadoop102 wcinput]$ cd ..
[zxk@hadoop102 hadoop-3.3.1]$ hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-3.3.1.jar wordcount wcinput/ wcoutput
[zxk@hadoop102 hadoop-3.3.1]$ cat wcoutput/part-r-00000
bird    1
boy     1
dark    1
darker  1
girl    1
human   1
light   1
name    1
```

#### 完全分布式环境搭建(重点)

##### 过程分析

1. 准备3台客户机(关闭防火墙，静态IP、主机名称配置)
2. 安装JDK
3. 配置环境变量
4. 安装Hadoop
5. 配置环境变量
6. 配置集群
7. 单点启动
8. 配置ssh
9. 启动集群并测试

##### 编写集群分发脚本xsync

1. scp(secure copy)安全拷贝

   - scp定义

     - scp可以实现服务器与服务器之间的数据拷贝

   - 基本语法

     - | scp  | -r   | `$pdir/$fname`        | `$user@$host:$pdir/$fname`      |
       | ---- | ---- | --------------------- | ------------------------------- |
       | 命令 | 递归 | 要拷贝的文件路径/名称 | 目的地用户@主机:目的地路径/名称 |

   - 具体实现

     - 在hadoop102、hadoop103、hadoop104都已经创建好/opt/module、/opt/software两个目录，并且已经将目录的用户和用户组修改为zxk:zxk

     - sudo chown zxk:zxk -R /opt/module

     - 在hadoop102上，将hadoop102中/opt/module/里面的jdk和hadoop目录拷贝到hadoop103和104上

     - ```bash
       # hadoop102拷贝到hadoop103
       [zxk@hadoop102 module]$ pwd
       /opt/module
       [zxk@hadoop102 module]$ scp -r java-se-8u41-ri/ zxk@hadoop103:/opt/module/
       # hadoop103从hadoop102拉取数据
       [zxk@hadoop103 ~]$ cd /opt/module/
       [zxk@hadoop103 module]$ ls
       java-se-8u41-ri
       [zxk@hadoop103 module]$ scp -r zxk@hadoop102:/opt/module/hadoop-3.3.1 ./
       #在hadoop103上把hadoop102上的文件拷贝到hadoop104上
        scp -r zxk@hadoop102:/opt/module/* zxk@hadoop104:/opt/module/
       
       ```

2. rsync远程同步工具

   - rsync主要用于备份和镜像，具有速度快、避免复制相同内容和支持符号链接的优点

   - rsync和scp区别：用rsync做文件的复制要比scp的速度块，rsync只对差异文件做更新。scp是把所有文件都复制过去

   - 基本语法

   - | rsync | -av      | `$pdir/$fname`        | `$user@$host:$pdir/$fname`      |
     | ----- | -------- | --------------------- | ------------------------------- |
     | 命令  | 选项参数 | 要拷贝的文件路径/名称 | 目的地用户@主机:目的地路径/名称 |

   - 选项参数说明

     - -a 归档拷贝
     - -v 显示复制过程

   - 案例实操

   - ```bash
     # 删除hadoop103中的wcinput/ wcoutput/
     [zxk@hadoop103 hadoop-3.3.1]$ pwd
     /opt/module/hadoop-3.3.1
     [zxk@hadoop103 hadoop-3.3.1]$ rm -rf wcinput/ wcoutput/
     # hadoop102同步到hadoop103
     [zxk@hadoop102 module]$ pwd
     /opt/module
     [zxk@hadoop102 module]$ rsync -av hadoop-3.3.1/ zxk@hadoop103:/opt/module/hadoop-3.3.1/
     ```

3. xsync集群分发脚本

   - 需求：循环复制所有文件到节点相同的目录下

   - rsync命令原始拷贝

   - `rsync -av /opt/module zxk@hadoop103:/opt`

   - 期望脚本

   - `xsync 要同步的文件名称`

   - 期望脚本在任何路径都能使用(脚本放在了声明了全局环境变量的路径)

   - ```bash
     [zxk@hadoop102 module]$ echo $PATH
     /usr/local/bin:/usr/bin:/usr/local/sbin:/usr/sbin:/opt/module/java-se-8u41-ri/bin:/opt/module/hadoop-3.3.1/bin:/opt/module/hadoop-3.3.1/sbin:/home/zxk/.local/bin:/home/zxk/bin
     ```

   - 脚本实现

   - 在/home/zxk/bin目录下创建xsync文件

   - ```bash
     cd /home/zxk
     mkdir bin
     cd bin
     vim xsync
     ```

   - 文件内容

   - ```shell
     #!/bin/bash
     
     #1.判断参数个数
     if [ $# -lt 1 ]
     then
             echo Not Enought Arguement!
             exit;
     fi
     
     #2.遍历集群所有机器
     for host in  hadoop102 hadoop103 hadoop104
     do
             echo ===================== $host =================
             # 3. 遍历所有目录,挨个发送
     
             for file in $@
             do
                     #4.判断文件是否存在
                     if [ -e $file ]
                             then
                                     #5.获取父目录
                                     pdir=$(cd -P $(dirname $file); pwd)
                                     #6.获取当前文件的名称
                                     fname=$(basename $file)
                                     ssh $host "mkdir -p $pdir"
                                     rsync -av $pdir/$fname $host:$pdir
                             else
                                     echo $file does not exists!
                     fi
             done
     done
     ```

   - 改变文件权限

   - `[zxk@hadoop102 bin]$ chmod 777 xsync`

   - 分发环境变量

   - `[zxk@hadoop102 ~]$ sudo ./bin/xsync /etc/profile.d/my_env.sh`

   - 输入`source /etc/profile`更新命令

##### ssh免密登录

ssh-key-gen生成密钥对

公钥-私钥

私钥自己保存，公钥发送给对方

执行ssh访问后，会生成ssh文件/home/zxk/.ssh

配置hadoop102免密ssh登录hadoop103，hadoop104

```bash
# 配置hadoop102免密ssh登录hadoop103，hadoop104
[zxk@hadoop102 .ssh]$ pwd
/home/zxk/.ssh
[zxk@hadoop102 .ssh]$ ssh-keygen -t rsa
# 三次回车
[zxk@hadoop102 .ssh]$ ll
总用量 12
-rw-------. 1 zxk zxk 1679 10月 23 16:44 id_rsa
-rw-r--r--. 1 zxk zxk  395 10月 23 16:44 id_rsa.pub
-rw-r--r--. 1 zxk zxk  558 10月 23 16:21 known_hosts
[zxk@hadoop102 .ssh]$ ssh-copy-id hadoop103
[zxk@hadoop102 .ssh]$ ssh hadoop103
Last login: Sat Oct 23 15:32:45 2021 from 192.168.10.1
[zxk@hadoop103 ~]$ exit
登出
Connection to hadoop103 closed.
[zxk@hadoop102 .ssh]$ ssh-copy-id hadoop104
[zxk@hadoop102 .ssh]$ ssh-copy-id hadoop102
[zxk@hadoop102 .ssh]$ ll
总用量 16
-rw-------. 1 zxk zxk  395 10月 23 16:46 authorized_keys
-rw-------. 1 zxk zxk 1679 10月 23 16:44 id_rsa
-rw-r--r--. 1 zxk zxk  395 10月 23 16:44 id_rsa.pub
-rw-r--r--. 1 zxk zxk  558 10月 23 16:21 known_hosts
[zxk@hadoop102 .ssh]$
# 自己用ssh访问自己也需要配置公钥和密钥，authorized_keys里面记录了允许登录的主机
```

配置102 103 104 都可以互相免密登录

```bash
重复上面步骤
```

注意zxk可以无密登录，root还需要配置

配置102 root对103 104 无密登录

```bash
[root@hadoop102 .ssh]# ssh-keygen -t rsa
[root@hadoop102 .ssh]# ssh-copy-id hadoop103
[root@hadoop102 .ssh]# ssh-copy-id hadoop104

```

#### 集群配置

##### 1. 集群部署规划

- NameNode和SecondaryNameNode不要安装在同一台服务器
- ResourceManager也很消耗内存，不要和NameNode、SecondaryNameNode配置在同一台服务器

|      | hadoop102              | hadoop103                        | hadoop104                       |
| ---- | ---------------------- | -------------------------------- | ------------------------------- |
| HDFS | **NameNode**、DataNode | DataNode                         | **SecondaryNameNode**、DataNode |
| YARN | NodeMnanager           | **ResourceManager**、NodeManager | NodeManager                     |

##### 2. 配置文件说明

Hadoop配置文件分为两类：默认配置文件和自定义配置文件，只有用户想修改某一默认配置值时，才需要修改自定义配置文件，更改相应属性值

1. 默认配置文件

   | 要获取的默认文件     | 文件放在Hadoop的jar包中的位置             |
   | -------------------- | ----------------------------------------- |
   | [core-default.xml]   | hadoop-common-3.3.1/core-default.xml      |
   | [hdfs-default.xml]   | hadoop-hdfs-3.3.1/hdfs-default.xml        |
   | [yarn-default.xml]   | hadoop-yarn-3.3.1/yarn-default.xml        |
   | [mapred-default.xml] | hadoop-mapreduce-3.3.1/mapred-default.xml |

2. 自定义配置文件

   core-site.xml、hdfs-site.xml、yarn-site.xml、mapred-site.xml四个配置文件存放在hadoop-3.3.1/etc/hadoop文件夹下

   - 核心配置文件core-site.xml

   - ```xml
     <?xml version="1.0" encoding="UTF-8"?>
     <?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
     <!--
       Licensed under the Apache License, Version 2.0 (the "License");
       you may not use this file except in compliance with the License.
       You may obtain a copy of the License at
     
         http://www.apache.org/licenses/LICENSE-2.0
     
       Unless required by applicable law or agreed to in writing, software
       distributed under the License is distributed on an "AS IS" BASIS,
       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
       See the License for the specific language governing permissions and
       limitations under the License. See accompanying LICENSE file.
     -->
     
     <!-- Put site-specific property overrides in this file. -->
     
     <configuration>
       <!-- 指定NameNode的地址 -->
       <property>
             <name>fs.defaultFS</name>
             <value>hdfs://hadoop102:8020</value>
       </property>
       <!-- 指定hadoop数据的存储目录 -->
       <property>
             <name>hadoop.tmp.dir</name>
             <value>/opt/module/hadoop-3.3.1/data</value>
       </property>
       <!-- 配置HDFS网页登录使用的静态用户为zxk -->
       <property>
             <name>hadoop.http.staticuser.user</name>
             <value>zxk</value>
       </property>
     </configuration>
     ```

   - HDFS配置文件 hdfs-site.xml

   - ```xml
     <?xml version="1.0" encoding="UTF-8"?>
     <?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
     <!--
       Licensed under the Apache License, Version 2.0 (the "License");
       you may not use this file except in compliance with the License.
       You may obtain a copy of the License at
     
         http://www.apache.org/licenses/LICENSE-2.0
     
       Unless required by applicable law or agreed to in writing, software
       distributed under the License is distributed on an "AS IS" BASIS,
       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
       See the License for the specific language governing permissions and
       limitations under the License. See accompanying LICENSE file.
     -->
     
     <!-- Put site-specific property overrides in this file. -->
     
     <configuration>
     
       <!-- nn web端访问地址 -->
       <property>
             <name>dfs.namenode.http-address</name>
             <value>hadoop102:9870</value>
       </property>
       <!-- 2nn web端访问地址 -->
       <property>
             <name>dfs.namenode.secondary.http-address</name>
             <value>hadoop104:9868</value>
       </property>
     
     </configuration>
     ```

   - YARN配置文件 yarn-site.xml

   - ```xml
     <?xml version="1.0"?>
     <!--
       Licensed under the Apache License, Version 2.0 (the "License");
       you may not use this file except in compliance with the License.
       You may obtain a copy of the License at
     
         http://www.apache.org/licenses/LICENSE-2.0
     
       Unless required by applicable law or agreed to in writing, software
       distributed under the License is distributed on an "AS IS" BASIS,
       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
       See the License for the specific language governing permissions and
       limitations under the License. See accompanying LICENSE file.
     -->
     <configuration>
     
     <!-- Site specific YARN configuration properties -->
       <!-- 指定MR走shuffle -->
       <property>
             <name>yarn.nodemanager.aux-services</name>
             <value>mapreduce_shuffle</value>
       </property>
       <!-- 指定ResourceManager的地址 -->
       <property>
             <name>yarn.resourcemanager.hostname</name>
             <value>hadoop103</value>
       </property>
       <!-- 环境变量的继承 -->
       <property>
             <name>yarn.nodemanager.env-whitelist</name>
             <value>JAVA_HOME,COMMON_HOME,HADOOP_HDFS_HOME,HADOOP_CONF_DIR,CLASSPATH_PREPEND_DISTCACHE,HADOOP_YARN_HOME,HADOOP_MAPRED_HOME</value>
       </property>
     
     </configuration>
     ```

   - MapReduce配置文件 mapred-site.xml

   - ```xml
     <?xml version="1.0"?>
     <?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
     <!--
       Licensed under the Apache License, Version 2.0 (the "License");
       you may not use this file except in compliance with the License.
       You may obtain a copy of the License at
     
         http://www.apache.org/licenses/LICENSE-2.0
     
       Unless required by applicable law or agreed to in writing, software
       distributed under the License is distributed on an "AS IS" BASIS,
       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
       See the License for the specific language governing permissions and
       limitations under the License. See accompanying LICENSE file.
     -->
     
     <!-- Put site-specific property overrides in this file. -->
     
     <configuration>
     
       <!-- 指定MapReduce程序运行在Yarn上 -->
       <property>
             <name>mapreduce.framework.name</name>
             <value>yarn</value>
       </property>
     
     </configuration>
     ```

   - 在集群上分发配置好的文件

   - `[zxk@hadoop102 etc]$ xsync hadoop/`

##### 3. 启动集群

1. 配置works

   - ```bash
     [zxk@hadoop102 hadoop]$ vim workers
     # 输入以下内容，注意内容结尾不允许有空格，文件中不允许有空行
     hadoop102
     hadoop103
     hadoop104
     # 同步配置
     [zxk@hadoop102 hadoop]$ xsync workers
     ```

2. 启动集群

   - 如果集群是第一次启动，需要在hadoop102节点格式化NameNode(注意：格式化NameNode，会产生新的集群id，导致NameNode和DataNode的集群id不一致，集群找不到以往数据，如果集群在运行过程中报错，需要重新格式化NameNode的话，一定要先停止namenode和datanode进程，并且要删除所有机器的data和logs目录，然后再进行格式化)

     - ```bash
       # 初始化命令
       [zxk@hadoop102 hadoop]$ hdfs namenode -format
       [zxk@hadoop102 current]$ pwd
       /opt/module/hadoop-3.3.1/data/dfs/name/current
       [zxk@hadoop102 current]$ cat VERSION
       #Sat Oct 23 17:59:52 CST 2021
       namespaceID=1932685138
       clusterID=CID-871c270e-a527-4231-85b5-b7e5c89f8765
       cTime=1634983192570
       storageType=NAME_NODE
       blockpoolID=BP-1678355428-192.168.10.102-1634983192570
       layoutVersion=-66
       # 启动HDFS
       [zxk@hadoop102 hadoop-3.3.1]$ sbin/start-dfs.sh
       #102
       [zxk@hadoop102 hadoop-3.3.1]$ jps
       5744 Jps
       5482 DataNode
       5358 NameNode
       # 103
       [zxk@hadoop103 hadoop]$ jps
       4806 Jps
       4729 DataNode
       #104
       [zxk@hadoop104 .ssh]$ jps
       4613 SecondaryNameNode
       4698 Jps
       4539 DataNode
       ```

     - 访问http://hadoop102:9870/explorer.html#/

     - 在配置了ResourceManager的节点hadoop103启动Yarn

     - ```bash
       [zxk@hadoop103 hadoop-3.3.1]$ pwd
       /opt/module/hadoop-3.3.1
       [zxk@hadoop103 hadoop-3.3.1]$ sbin/start-yarn.sh
       Starting resourcemanager
       Starting nodemanagers
       #103
       [zxk@hadoop103 hadoop-3.3.1]$ jps
       4945 ResourceManager
       5057 NodeManager
       5400 Jps
       4729 DataNode
       # 102
       [zxk@hadoop102 hadoop-3.3.1]$ jps
       5844 NodeManager
       5482 DataNode
       5949 Jps
       5358 NameNode
       # 104
       [zxk@hadoop104 .ssh]$ jps
       4912 Jps
       4613 SecondaryNameNode
       4793 NodeManager
       4539 DataNode
       
       ```

     - web端查看HDFS的NameNode http://hadoop102:9870/explorer.html#/

     - web端查看Yarn的ResourceManager  http://hadoop103:8088/cluster

3. 集群基本测试

   ```bash
   # 上传文件到集群
   # 1. 上传小文件
   [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -mkdir /wcinput
   # HDFS的NameNode显示变化，多了wcinput
   [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -put wcinput/word.txt /wcinput
   # 回到HDFS页面可以看到wcinput里面多了word.txt文件
   # 2. 上传大文件
   [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -put /opt/software/openjdk-8u41-b04-linux-x64-14_jan_2020.tar.gz /
   
   # 查看文件存储位置
   [zxk@hadoop102 subdir0]$ pwd
   /opt/module/hadoop-3.3.1/data/dfs/data/current/BP-1678355428-192.168.10.102-1634983192570/current/finalized/subdir0/subdir0
   [zxk@hadoop102 subdir0]$ ll
   总用量 171548
   -rw-rw-r--. 1 zxk zxk        43 10月 23 18:16 blk_1073741825
   -rw-rw-r--. 1 zxk zxk        11 10月 23 18:16 blk_1073741825_1001.meta
   -rw-rw-r--. 1 zxk zxk 134217728 10月 23 18:22 blk_1073741826
   -rw-rw-r--. 1 zxk zxk   1048583 10月 23 18:22 blk_1073741826_1002.meta
   -rw-rw-r--. 1 zxk zxk  40070210 10月 23 18:22 blk_1073741827
   -rw-rw-r--. 1 zxk zxk    313059 10月 23 18:22 blk_1073741827_1003.meta
   [zxk@hadoop102 subdir0]$ cat blk_1073741825
   bird
   light dark
   human boy girl
   darker name
   # 
   [zxk@hadoop102 subdir0]$ cat blk_1073741826 >> tmp.tar.gz
   [zxk@hadoop102 subdir0]$ cat blk_1073741827 >> tmp.tar.gz
   [zxk@hadoop102 subdir0]$ tar -zxvf tmp.tar.gz
   解压出来的文件就是JDK
   # hadoop102 hadoop103 hadoop104一样
   # hadoop会选择任意三台服务器备份一个数据文件
   # 测试工作运行
   [zxk@hadoop102 hadoop-3.3.1]$ hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-3.3.1.jar wordcount /wcinput /wcoutput
   # 发现yarn创建了相关任务，注意这里的路径必须都是hdfs的路径，不能是本地路径
   ```

4. 如果运行任务后报错

   - Error: Could not find or load main class org.apache.hadoop.mapreduce.v2.app.MRAppMaster

   - ```bash
     [zxk@hadoop102 hadoop-3.3.1]$ vim  /opt/module/hadoop-3.3.1/etc/hadoop/mapred-site.xml
     # 内容为
     # 注意这里calsspath的值为执行hadoop classpath后显示的值
     <configuration>
         <property>
             <name>mapreduce.framework.name</name>
             <value>yarn</value>
         </property>
         <property>
             <name>mapreduce.application.classpath</name>
             <value>/opt/module/hadoop-3.3.1/etc/hadoop:/opt/module/hadoop-3.3.1/share/hadoop/common/lib/*:/opt/module/hadoop-3.3.1/share/hadoop/common/*:/opt/module/hadoop-3.3.1/share/hadoop/hdfs:/opt/module/hadoop-3.3.1/share/hadoop/hdfs/lib/*:/opt/module/hadoop-3.3.1/share/hadoop/hdfs/*:/opt/module/hadoop-3.3.1/share/hadoop/mapreduce/*:/opt/module/hadoop-3.3.1/share/hadoop/yarn:/opt/module/hadoop-3.3.1/share/hadoop/yarn/lib/*:/opt/module/hadoop-3.3.1/share/hadoop/yarn/*</value>
         </property>
         <property>
           <name>yarn.app.mapreduce.am.env</name>
           <value>HADOOP_MAPRED_HOME=${HADOOP_HOME}</value>
         </property>
         <property>
           <name>mapreduce.map.env</name>
           <value>HADOOP_MAPRED_HOME=${HADOOP_HOME}</value>
         </property>
         <property>
           <name>mapreduce.reduce.env</name>
           <value>HADOOP_MAPRED_HOME=${HADOOP_HOME}</value>
         </property>
     </configuration>
     
     [zxk@hadoop102 hadoop-3.3.1]$ xsync  /opt/module/hadoop-3.3.1/etc/hadoop/mapred-site.xml
     #在hadoop103上重启yarn
     [zxk@hadoop103 hadoop-3.3.1]$ sbin/stop-yarn.sh
     Stopping resourcemanager
     [zxk@hadoop103 hadoop-3.3.1]$ sbin/start-yarn.sh
     
     ```

##### 4. 集群崩溃处理

比如3个节点

删除所有data和log文件夹，重新format并启动集群

##### 5. 配置历史服务器

yarn里面history选项

为了查看程序的历史运行情况，需要配置一下历史服务器，具体配置步骤如下

1. 配置mapred-site.xml

   ```
   [zxk@hadoop102 hadoop]$ pwd
   /opt/module/hadoop-3.3.1/etc/hadoop
   [zxk@hadoop102 hadoop]$ vim mapred-site.xml
   # 添加的内容为
       <!-- 历史服务器地址 -->
       <property>
         <name>mapreduce.jobhistory.address</name>
         <value>hadoop102:10020</value>
       </property>
       <!-- 历史服务器web端地址 -->
       <property>
         <name>mapreduce.jobhistory.webapp.address</name>
         <value>hadoop102:19888</value>
       </property>
       # 分发
   [zxk@hadoop102 hadoop]$ xsync mapred-site.xml
   # 重启yarn  hadoop103
   [zxk@hadoop103 hadoop-3.3.1]$ sbin/stop-yarn.sh
   [zxk@hadoop103 hadoop-3.3.1]$ sbin/start-yarn.sh
   # 启动历史服务器 hadoop102
   [zxk@hadoop102 hadoop-3.3.1]$ bin/mapred --daemon start historyserver
   [zxk@hadoop102 hadoop-3.3.1]$ jps
   9713 Jps
   9689 JobHistoryServer
   5482 DataNode
   5358 NameNode
   9247 NodeManager
   # 再次运行就可以查看history了
   ```

##### 6. 配置日志的聚集功能

日志聚集概念：应用运行完成以后，将程序的运行日志信息上传到HDFS系统上

```mermaid
flowchart TB
用户查看HDFS日志
subgraph 所有服务器日志聚集到HDFS
id(Log)
end
hadoop102Log --> id
hadoop103Log --> id
hadoop104Log --> id
```

日志聚集功能的好处：可以方便的查看到程序运行详情，方便开发调试

开启日志聚集功能，需要重新启动NodeManager、ResourceManager和HistoryServer

具体步骤如下

1. 配置yarn-site.xml 添加配置

   ```bash
   [zxk@hadoop102 hadoop]$ pwd
   /opt/module/hadoop-3.3.1/etc/hadoop
   [zxk@hadoop102 hadoop]$ vim yarn-site.xml
   ```

   ```xml
     <!-- 开启日志聚集功能 -->
     <property>
           <name>yarn.log-aggregation-enable</name>
           <value>true</value>
     </property>
     <!-- 设置日志聚集服务器地址 -->
     <property>
           <name>yarn.log.server.url</name>
           <value>http://hadoop102:19888/jobhistory/logs</value>
     </property>
     <!-- 设置日志保留时间为7天 -->
     <property>
           <name>yarn.log-aggregation.retain-seconds</name>
           <value>604800</value>
     </property>
   ```

2. 分发配置

   ```bash
   [zxk@hadoop102 hadoop]$ xsync yarn-site.xml
   ```

3. 关闭NodeManager、ResourceManager和HistoryServer,然后重启

   ```bash
   [zxk@hadoop102 hadoop]$ mapred --daemon stop historyserver
   
   [zxk@hadoop103 hadoop-3.3.1]$ sbin/stop-yarn.sh
   [zxk@hadoop103 hadoop-3.3.1]$ sbin/start-yarn.sh
   
   [zxk@hadoop102 hadoop]$ mapred --daemon start historyserver
   
   ```

4. 再次运行任务，在history的logs下可以看到相关日志

##### 7. 集群启动/停止方式总结

1. 各个模块分开启动/停止

   - 整体启动/停止HDFS

     `start-dfs.sh/stop-dfs.sh`

   - 整体启动/停止YARN

     `start-yarn.sh/stop-yarn.sh`

2. 各个服务组件逐一启动/停止

   - 分别启动/停止HDFS组件

     `hdfs --daemon start/stop namenode/datanode/secondarynamenode`

   - 启动/停止yarn

     `yarn --daemon start/stop resourcemanager/nodemanager`

##### 8. 编写Hadoop集群常用脚本

1. Hadoop集群启停脚本(包含HDFS、Yarn、Historyserver) myhadoop.sh

   ```shell
   #!/bin/bash
   
   if [ $# -lt 1 ]
   then
       echo "No Args Input..."
   fi
   
   case $1 in
   "start")
           echo "=================启动hadoop集群=================="
           echo "------------启动hdfs-----------------"
           ssh hadoop102 "/opt/module/hadoop-3.3.1/sbin/start-dfs.sh"
           echo "------------启动yarn-----------------"
           ssh hadoop103 "/opt/module/hadoop-3.3.1/sbin/start-yarn.sh"
           echo "------------启动historyserver----------------"
           ssh hadoop102 "/opt/module/hadoop-3.3.1/bin/mapred --daemon start historyserver"
   ;;
   "stop")
           echo "===================关闭Hadoop集群=================="
           echo "---------------关闭historyserver------------------"
           ssh hadoop102 "/opt/module/hadoop-3.3.1/bin/mapred --daemon stop historyserver"
           echo "---------------关闭yarn-----------------------"
           ssh hadoop103 "/opt/module/hadoop-3.3.1/sbin/stop-yarn.sh"
           echo "---------------关闭hdfs----------------------"
           ssh hadoop102 "/opt/module/hadoop-3.3.1/sbin/stop-dfs.sh"
   ;;
   *)
           echo "Input Args Error... Please input start or stop"
   ;;
   esac
   ```

   保存后退出，然后赋予脚本执行权限

   `[zxk@hadoop102 bin]$ chmod +x myhadoop.sh`

2. 查看三台服务器Java进程脚本 jpsall

   ```bash
   [zxk@hadoop102 bin]$ pwd
   /home/zxk/bin
   [zxk@hadoop102 bin]$ vim jpsall
   ```

   ```shell
   #!/bin/bash
   
   for host in hadoop102 hadoop103 hadoop104
   do
           echo "==================$host==============="
           ssh $host jps
   done
   ```

   赋予运行权限

   `[zxk@hadoop102 bin]$ chmod 777 jpsall`

   分发

   `[zxk@hadoop102 ~]$ xsync /home/zxk/bin/`

##### 9. 常用端口号说明

| 端口名称                   | Hadoop2.x | Hadoop3.x      |
| -------------------------- | --------- | -------------- |
| NameNode内部通信端口       | 8020/9000 | 8020/9000/9820 |
| NameNode HTTP UI           | 50070     | 9870           |
| MapReduce 查看执行任务端口 | 8088      | 8088           |
| 历史服务器通信端口         | 19888     | 19888          |

常用配置文件

3.x core-site.xml hdfs-site.xml yarn-site.xml mapred-site.xml workers

2.x core-site.xml hdfs-site.xml yarn-site.xml mapred-site.xml slaves

##### 10.集群时间同步(一般不用)

如果服务器在公网环境(能连接外网)，可以不采用集群时间同步，因为服务器会定期和公网时间进行校准

如果服务器在内网环境，必须要配置集群时间同步，否则时间久了，会产生时间偏差，导致集群执行任务时间不同步

需求

把一个集群中的机器作为时间服务器，所有的机器与这台集群时间进行定时的同步，生成环境根据任务对事件的准确程度要求周期同步，测试环境为了尽快看到效果，采用1分钟同步一次

###### 时间服务器配置(必须root用户)

1. 查看所有节点ntpd服务状态和开机自启动状态

   ```bash
   sudo systemctl status ntpd
   sudo systemctl start ntpd
   sudo systemctl is-enabled ntpd
   ```

2. 修改hadoop102的ntp.conf配置文件

   ```bash
   sudo vim /etc/ntp.conf
   ```

   修改1(授权192.168.10.0-192.168.10.255网段上所有的机器都可以从这台机器上查询和同步时间)

   ```bash
   #restrict 192.168.10.0 mask 255.255.255.0 nomodify notrap
   ```

   修改为

   ```bash
   restrict 192.168.10.0 mask 255.255.255.0 nomodify notrap
   ```

   修改2(集群在局域网中，不使用其他互联网上的时间)

   ```bash
   server 0.centos.pool.ntp.org iburst
   server 1.centos.pool.ntp.org iburst
   server 2.centos.pool.ntp.org iburst
   server 3.centos.pool.ntp.org iburst
   ```

   为

   ```bash
   #server 0.centos.pool.ntp.org iburst
   #server 1.centos.pool.ntp.org iburst
   #server 2.centos.pool.ntp.org iburst
   #server 3.centos.pool.ntp.org iburst
   ```

   添加3(当该节点丢失网络连接，怡冉可以采用本地时间作为时间服务器为集群中的其他节点提供时间同步)

   ```bash
   server 127.127.1.0
   fudge 127.127.1.0 stratum 10
   ```

   修改hadoop102的/etc/sysconfig/ntpd文件

   `sudo vim /etc/sysconfig/ntpd`

   增加内容如下(让硬件时间与系统时间一起同步)

   `SYNC_HWCLOCK=yes`

   重新启动ntpd服务

   `sudo systemctl start ntpd`

   设置ntpd服务开启启动

   `sudo systemctl enable ntpd`

3. 其他机器配置，必须root用户

   1 关闭所有节点上的ntp服务和自启动

   ```bash
   sudo systemctl stop ntpd
   sudo systemctl disable ntpd
   sudo systemctl stop ntpd
   sudo systemctl disable ntpd
   ```

   2 在其他机器配置一分钟与时间服务器同步一次

   ```bash
   sudo crontab -e
   ```

   编写定时任务如下

   ```bash
   */1 * * * * /usr/sbin/ntpdate hadoop102
   ```

   3 修改任意机器时间

   ```bash
   sudo date -s "2021-9-11 11:11:11"
   ```

   4 1分钟后查看机器是否与时间服务器同步

   ```bash
   sudo date
   ```



### 4. 常见错误及解决方案

1. 防火墙没关闭、或者没有启动yarn

2. 主机名称配置错误

3. IP地址配置错误

4. ssh没有配置好

5. root用户和zxk两个用户启动集群不统一

6. 配置文件修改不细心

7. 不识别主机名称

8. 不要起hadoop和hadoop000等特殊名称

9. DataNode和NameNode进程同时只能有一个工作问题分析，因为两者集群id不同了

   解决防范是在格式化之前，先删除DataNode里面的信息，默认在/tmp，如果配置了该目录，就去配置的目录下删除数据

10. 执行命令不生效-和--没区分开

11. jps发现进程没有，重新启动集群提示进程开启

    在linux根目录下/tmp目录中存在启动的进程临时文件，将集群相关进程删除掉再重新启动集群

12. jps不生效

    全局变量hadoop.java没有生效，需要source /etc/profile文件

13. 8088端口连不上

    cat /etc/hosts注释掉

    #127.0.0.1 localhost localhost...

14. 网页删除提示没有权限，需要在core-site.xml里面配置默认用户

Block Size是指这个文件最大为这么大，并不是真的占用了这些空间

## 3.HDFS

```mermaid
flowchart LR
id(HDFS)
id --> id1(概述)
	id1 --> HDFS产生背景和定义
	id1 --> 优缺点
	id1 --> 组成
	id1 --> 文件快大小
id --> id2(HDFS的Shell相关操作) --> 开发的重点
id --> id3(HDFS的客户端API) --> 数据的上传和下载
id --> id4(HDFS的读写流程) --> 面试重点
id --> id5(NN和2NN) --> 了解
id --> id6(Datanode工作机制)
```



### 1. HDFS概述

#### HDFS产生背景及定义

##### 产生背景

​	随着数据量越来越大，在一个操作系统存不下所有的数据，那么就分配到更多的操作系统管理的磁盘中，但是不方便管理和维护，迫切需要一种系统来管理多台机器上的文件，这就是分布式文件管理系统。HDFS只是**分布式文件管理系统**中的一种

##### 定义

​	**HDFS(Hadoop Distributed File System)，它是一个文件系统**，用于存储文件，通过目录树来定位文件，其次，它是**分布式**的，由很多服务器联合起来实现其功能，集群中的服务器有各自的角色

​	**HDFS的使用场景：适合一次写入，多次读出的场景**。一个文件经过创建、写入和关闭之后就不需要改变

NTFS系统

#### HDFS优缺点

##### HDFS优点

1. 高容错性
   - 数据自动保存多个副本，通过增加副本的形式，提高容错性
   - 某一个副本丢失后，可以自动恢复，比如某台机器的数据丢失，他会从其他的副本把数据保存到其他服务器，确保有三个副本
2. 适合处理大数据
   - 数据规模 能够处理数据规模达到GB、TB、甚至PB级别的数据
   - 文件规模 能够处理百万规模以上的文件数量
3. 可以构建在廉价的机器上，通过多副本机制，提高可靠性

##### HDFS缺点

1. 不适合低延时数据访问，比如毫秒级别的存储数据是做不到的
2. 无法高效的对大量的小文件进行存储
   - 存储大量小文件的话，会占用NameNode大量的内存来存储文件目录和块信息，这样不可取，因为NameNode的内存有限
   - 小文件存储的寻址时间会超过读取时间，违反了HDFS的设计目标
3. 不支持并发写入、文件随机修改
   - 一个文件只能有一个写，不允许多个线程同时写
   - **仅支持数据append(追加)**，不支持文件的随机修改

#### HDFS组成架构

https://hadoop.apache.org/docs/

https://hadoop.apache.org/docs/r3.3.1/

![HDFS Architecture](Hadoop.assets/hdfsarchitecture.png)

1. NameNode(nn):就是Master，它是一个主管、管理者
   - 管理HDFS的名称空间
   - 配置副本策略
     - 数据有多少副本
   - 管理数据块(Block)映射信息
     - 比如一个文件分成多个块存储，不同的块可能会分布在不同的服务器上
   - 处理客户端读写请求
2. DataNode:就是Slave，NameNode下达命令，DataNode执行实际的操作
   - 存储实际的数据块
   - 执行数据块的读/写操作
3. Client:就是客户端
   - 文件切分。文件上传HDFS的时候，Client将文件切分成一个一个的块，然后进行上传
   - 与NameNode交互，获取文件的位置信息
   - 与DataNode交互，读取或写入数据
   - Client提供一些命令来管理HDFS，比如NameNode的格式化
   - Client可以通过一些命令来访问HDFS，比如对HDFS的增删改查操作
4. Secondary NameNode：并非NameNode的热备份，当NameNode挂掉的时候，它并不能马上替换NameNode并提供服务
   - 辅助NameNode，分担其工作量，比如定期合并Fsimage和Edits，并推送给NameNode
   - 在紧急情况下可以辅助恢复NameNode

#### HDFS文件块大小(重点)

​	HDFS中的文件在物理上是分块存储的(Block)，块的大小可以通过配置参数(dfs.blocksize)来规定，Hadoop2.x/3.x默认大小是128M，1.x版本中是64M

1. 集群中的block
2. 如果寻址时间约为10ms，即查找到目标block的时间为10ms
3. 寻址时间为传输时间的1%时，则为最佳状态，因此传输时间=10ms/0.01=1000ms=1s
4. 而目前磁盘传输速率普遍为100MB/s
5. block大小=1s*100MB/s=100MB

一般机械硬盘为128MB，固态硬盘为256MB

为什么块的大小不能设置太小，也不能设置太大？

1. HDFS块设置太小，会增加寻址时间，程序一直在找块的开始位置
2. 如果块设置的太大，从磁盘传输数据的时间会明显大于定位这个块开始位置所需的时间，导致程序在处理这块数据时，会非常慢

HDFS块大小的设置主要取决于磁盘传输速率

### 2. HDFS的Shell操作(重点)

#### 基本语法

hadoop fs 具体命令 OR hdfs dfs 具体命令

这两个命令是完全相同的

#### 命令大全

```bash
[zxk@hadoop102 ~]$ hadoop fs
Usage: hadoop fs [generic options]
        [-appendToFile <localsrc> ... <dst>]
        [-cat [-ignoreCrc] <src> ...]
        [-checksum [-v] <src> ...]
        [-chgrp [-R] GROUP PATH...]
        [-chmod [-R] <MODE[,MODE]... | OCTALMODE> PATH...]
        [-chown [-R] [OWNER][:[GROUP]] PATH...]
        [-concat <target path> <src path> <src path> ...]
        [-copyFromLocal [-f] [-p] [-l] [-d] [-t <thread count>] <localsrc> ... <dst>]
        [-copyToLocal [-f] [-p] [-ignoreCrc] [-crc] <src> ... <localdst>]
        [-count [-q] [-h] [-v] [-t [<storage type>]] [-u] [-x] [-e] [-s] <path> ...]
        [-cp [-f] [-p | -p[topax]] [-d] <src> ... <dst>]
        [-createSnapshot <snapshotDir> [<snapshotName>]]
        [-deleteSnapshot <snapshotDir> <snapshotName>]
        [-df [-h] [<path> ...]]
        [-du [-s] [-h] [-v] [-x] <path> ...]
        [-expunge [-immediate] [-fs <path>]]
        [-find <path> ... <expression> ...]
        [-get [-f] [-p] [-ignoreCrc] [-crc] <src> ... <localdst>]
        [-getfacl [-R] <path>]
        [-getfattr [-R] {-n name | -d} [-e en] <path>]
        [-getmerge [-nl] [-skip-empty-file] <src> <localdst>]
        [-head <file>]
        [-help [cmd ...]]
        [-ls [-C] [-d] [-h] [-q] [-R] [-t] [-S] [-r] [-u] [-e] [<path> ...]]
        [-mkdir [-p] <path> ...]
        [-moveFromLocal [-f] [-p] [-l] [-d] <localsrc> ... <dst>]
        [-moveToLocal <src> <localdst>]
        [-mv <src> ... <dst>]
        [-put [-f] [-p] [-l] [-d] [-t <thread count>] <localsrc> ... <dst>]
        [-renameSnapshot <snapshotDir> <oldName> <newName>]
        [-rm [-f] [-r|-R] [-skipTrash] [-safely] <src> ...]
        [-rmdir [--ignore-fail-on-non-empty] <dir> ...]
        [-setfacl [-R] [{-b|-k} {-m|-x <acl_spec>} <path>]|[--set <acl_spec> <path>]]
        [-setfattr {-n name [-v value] | -x name} <path>]
        [-setrep [-R] [-w] <rep> <path> ...]
        [-stat [format] <path> ...]
        [-tail [-f] [-s <sleep interval>] <file>]
        [-test -[defswrz] <path>]
        [-text [-ignoreCrc] <src> ...]
        [-touch [-a] [-m] [-t TIMESTAMP (yyyyMMdd:HHmmss) ] [-c] <path> ...]
        [-touchz <path> ...]
        [-truncate [-w] <length> <path> ...]
        [-usage [cmd ...]]

Generic options supported are:
-conf <configuration file>        specify an application configuration file
-D <property=value>               define a value for a given property
-fs <file:///|hdfs://namenode:port> specify default filesystem URL to use, overrides 'fs.defaultFS' property from configurations.
-jt <local|resourcemanager:port>  specify a ResourceManager
-files <file1,...>                specify a comma-separated list of files to be copied to the map reduce cluster
-libjars <jar1,...>               specify a comma-separated list of jar files to be included in the classpath
-archives <archive1,...>          specify a comma-separated list of archives to be unarchived on the compute machines

The general command line syntax is:
command [genericOptions] [commandOptions]
```

#### 常用命令操作

##### 准备

1. 启动hadoop集群

   ```bash
   #102
   start-dfs.sh
   #103
   start-yarn.sh
   也可以用之前配置好的启动脚本
   ```

2. -help 输出这个命令参数的用法

   ```bash
   [zxk@hadoop102 ~]$ hadoop fs -help rm
   -rm [-f] [-r|-R] [-skipTrash] [-safely] <src> ... :
     Delete all files that match the specified file pattern. Equivalent to the Unix
     command "rm <src>"
   
     -f          If the file does not exist, do not display a diagnostic message or
                 modify the exit status to reflect an error.
     -[rR]       Recursively deletes directories.
     -skipTrash  option bypasses trash, if enabled, and immediately deletes <src>.
     -safely     option requires safety confirmation, if enabled, requires
                 confirmation before deleting large directory with more than
                 <hadoop.shell.delete.limit.num.files> files. Delay is expected when
                 walking over large directory recursively to count the number of
                 files to be deleted before the confirmation.
   ```

3. 创建/sanguo文件夹

   ```bash
   [zxk@hadoop102 ~]$ hadoop fs -mkdir /sanguo
   ```

##### 上传

1. -moveFromLocal 从本地**剪切黏贴到**HDFS

   ```bash
   [zxk@hadoop102 hadoop-3.3.1]$ vim shuguo.txt
   # 输入shuguo
   [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -moveFromLocal ./shuguo.txt /sanguo
   ```

2. -copyFromLocal 从本地文件系统中拷贝文件到HDFS路径去

   ```bash
   [zxk@hadoop102 hadoop-3.3.1]$ vim weiguo.txt
   # 输入weiguo
   [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -copyFromLocal ./weiguo.txt /sanguo
   ```

3. -put 等同于copyFromLocal,生产环境更习惯用put

   ```bash
   [zxk@hadoop102 hadoop-3.3.1]$ vim wuguo.txt
   #输入wuguo
   [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -put ./wuguo.txt /sanguo
   ```

4. -appendToFile 追加一个文件到已经存在的文件末尾

   ```bash
   [zxk@hadoop102 hadoop-3.3.1]$ vim liubei.txt
   # 输入liubei
   [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -appendToFile ./liubei.txt /sanguo/shuguo.txt
   ```

##### 下载(可以修改名字)

1. -copyToLocal 从HDFS拷贝到本地

   ```bash
   [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -copyToLocal /sanguo/shuguo.txt ./
   ```

2. -get 等同于copyToLocal，生产环境更习惯用get

   ```bash
   [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -get /sanguo/shuguo.txt ./shuguo2.txt
   ```

##### HDFS直接操作

1. -ls 显示目录信息

   ```bash
   [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -ls /
   Found 4 items
   -rw-r--r--   3 zxk supergroup  174287938 2021-10-23 18:22 /openjdk-8u41-b04-linux-x64-14_jan_2020.tar.gz
   drwxr-xr-x   - zxk supergroup          0 2021-10-25 21:01 /sanguo
   drwx------   - zxk supergroup          0 2021-10-23 20:31 /tmp
   drwxr-xr-x   - zxk supergroup          0 2021-10-23 18:16 /wcinput
   ```

2. -cat 显示文件内容

   ```bash
   [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -cat /sanguo/wuguo.txt
   wuguo
   ```

3. -chgrp、-chmod、-chown Linux文件系统中用法一样，修改文件所属权限

   ```bash
   [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -chown zxk:zxk /sanguo/shuguo.txt
   ```

4. -mkdir 创建路径(文件夹)

   ```bash
   [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -mkdir /jinguo
   ```

5. -cp 从HDFS的一个路径拷贝到HDFS的另一个路径

   ```bash
   [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -cp /sanguo/shuguo.txt /jinguo
   ```

6. -mv 在HDFS目录中移动文件

   ```bash
   [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -mv /sanguo/weiguo.txt /jinguo
   [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -mv /sanguo/wuguo.txt /jinguo
   ```

7. -tail 显示一个文件的末尾1kb的数据

   ```bash
   [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -tail /jinguo/shuguo.txt
   shuguo
   liubei
   ```

8. -rm 删除文件或文件夹

   ```bash
   [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -rm /sanguo/shuguo.txt
   Deleted /sanguo/shuguo.txt
   ```

9. -rm -r 递归删除目录及目录里面的内容

   ```bash
   [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -rm -r /sanguo
   Deleted /sanguo
   ```

10. -du 统计文件夹的大小信息

    ```bash
    [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -du -s -h /jinguo
    27  81  /jinguo
    [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -du -h /jinguo
    14  42  /jinguo/shuguo.txt
    7   21  /jinguo/weiguo.txt
    6   18  /jinguo/wuguo.txt
    ```

    27表示文件大小，81表示27*3个副本，/jinguo表示查看的目录

11. -setrep 设置HDFS中文件的副本数量

    ```bash
    [zxk@hadoop102 hadoop-3.3.1]$ hadoop fs -setrep 10 /jinguo/shuguo.txt
    ```

    这里设置的副本数只是记录在NameNode的元数据中，是否真的会有这么多副本，还得看DataNode的数量，因为目前只有三台设备，最多也就三个副本，只有节点数增加到10台时，副本数才能达到10

### 3. HDFS的API操作

#### 客户端环境准备

可以在hadoop集群内部，使用相关命令操作Hadoop，也可在外部，比如windows上，使用客户端进行相关命令操作

1. windows版客户端对应版本下载

   https://github.com/fallofleaf/winutils

   注意下载后拷贝到非中文目录下

2. 配置HADOOP_HOME环境变量

   此电脑>属性>高级系统设置>高级>环境变量>用户变量里面添加

   HADOOP_HOME，值为bin目录所在的位置，如E:\assist tool\hadoop-3.3.1，然后在Path里面添加%HADOOP_HOME%\bin

3. 双击winutils.exe，不提示错误表示成功

4. IDEA新建Maven工程HdfsClientDemo

   - 导入相应依赖(注意版本一致)

     ```xml
         <dependencies>
             <dependency>
                 <groupId>org.apache.hadoop</groupId>
                 <artifactId>hadoop-client</artifactId>
                 <version>3.3.1</version>
             </dependency>
             <dependency>
                 <groupId>junit</groupId>
                 <artifactId>junit</artifactId>
                 <version>4.13.2</version>
             </dependency>
             <dependency>
                 <groupId>org.slf4j</groupId>
                 <artifactId>slf4j-log4j12</artifactId>
                 <version>1.7.32</version>
             </dependency>
         </dependencies>
     ```

   - 在src/main/resources目录下添加文件log4j.properties

     ```properties
     log4j.rootLogger=INFO,stdout
     log4j.appender.stdout=org.apache.log4j.ConsoleAppender
     log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
     log4j.appender.stdout.layout.ConversionPattern=%d %p [%c] - %m%n
     log4j.appender.logfile=org.apache.log4j.FileAppender
     log4j.appender.logfile.File=target/spring.log
     log4j.appender.logfile.layout=org.apache.log4j.PatternLayout
     log4j.appender.logfile.layout.ConversionPattern=%d %p [%c] - %m%n
     ```

   - 创建包

     com.flywinter.hdfs

   - 创建类HdfsClient

#### API调用

```java
package com.flywinter.hdfs;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/10/26 17:48
 * Description:
 */


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

/**
 * 常见流程
 * 1. 获取一个客户端对象
 * 2. 执行相关的操作命令
 * 3. 关闭资源
 * HDFS zookeeper
 */
public class HdfsClient {

    private FileSystem fs;

    @Before
    public void init() throws IOException, InterruptedException, URISyntaxException {
        //连接的集群nn地址
        URI uri = new URI("hdfs://hadoop102:8020");
        //创建一个配置文件
        Configuration configuration = new Configuration();
        configuration.set("dfs.replication", "2");
        //1.获取到客户端对象
        String user = "zxk";
        fs = FileSystem.get(uri, configuration, user);

    }

    @After
    public void close() throws IOException {
        //3.关闭资源
        fs.close();
    }

    //创建目录
    @Test
    public void testmkdir() throws IOException {
        //2.创建一个文件夹
        fs.mkdirs(new Path("/xiyou/huaguoshan1"));
        //3.关闭资源
        fs.close();
    }
    //上传
    //注意先在E盘下新建sunwukong.txt文件

    /**
     * 参数优先级 hdfs-default.xml => hdfs-site.xml => 在项目资源目录下的配置文件 => 代码里面的配置优先级
     * 在resources文件夹下添加hdfs-site.xml文件后，再次上传，查看副本数
     * resources文件夹下的优先级较高
     *
     * @throws IOException
     */
    @Test
    public void testPut() throws IOException {
//        boolean delSrc  是否删除原数据
//        boolean overwrite 是否覆盖
//        Path[] srcs 原数据路径
//        Path dst 目的地路径
        fs.copyFromLocalFile(false, true,
                new Path("E:\\sunwukong.txt"),
                new Path("hdfs://hadoop102:8020/xiyou/huaguoshan"));
    }

    //文件下载
    //crc文件，加密进行文件校验，判断文件是否完整
    @Test
    public void testGet() throws IOException {
//        boolean delSrc, 是否删除原文件
//        Path src, 原文件路径HDFS
//        Path dst, 目标地址路径windows
//        boolean useRawLocalFileSystem 是否开启本地校验，true不开启
        fs.copyToLocalFile(false,
                new Path("hdfs://hadoop102:8020/xiyou/huaguoshan"),
                new Path("E:"),
                false);
    }

    //文件删除
    @Test
    public void testRm() throws IOException {
        //要删除的路径  是否递归删除
        //删除文件
//        fs.delete(new Path("/openjdk-8u41-b04-linux-x64-14_jan_2020.tar.gz"),false);
        //删除空目录
        //删除非空目录
        fs.delete(new Path("/jinguo"), true);
    }

    //文件更名和移动
    @Test
    public void testmv() throws IOException {
        //原文件路径  目标文件路径
        //改名
//        fs.rename(new Path("/wcinput/word.txt"),new Path("/wcinput/ss.txt"));
        //移动并改名
//        fs.rename(new Path("/wcinput/ss.txt"),new Path("/ssm.txt"));
        //目录的更名
        fs.rename(new Path("/wcinput"), new Path("/input"));
    }

    //HDFS文件详情查看
    @Test
    public void fileDetail() throws IOException {
        //文件路径 是否递归查看
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);
        //遍历文件
        while (listFiles.hasNext()) {
            LocatedFileStatus next = listFiles.next();
            System.out.println("======" + next.getPath() + "======");
            System.out.println(next.getPermission());
            System.out.println(next.getOwner());
            System.out.println(next.getLen());
            System.out.println(next.getModificationTime());
            System.out.println(next.getReplication());
            System.out.println(next.getBlockSize());
            System.out.println(Arrays.toString(next.getBlockLocations()));
            System.out.println(next.getPath().getName());
        }
    }

    //HDFS文件和文件夹判断
    @Test
    public void testListStatus() throws IOException {
        FileStatus[] fileStatuses = fs.listStatus(new Path("/"));
        for (FileStatus status : fileStatuses) {
            if (status.isFile()) {
                System.out.println("文件："+status.getPath().getName());
            }else {
                System.out.println("目录："+status.getPath().getName());
            }
        }
    }
}
```

### 4. HDFS的读写流程(重点)

#### HDFS写数据流程

![image-20211026203853217](Hadoop.assets/image-20211026203853217.png)

1. 客户端通过DistributedFileSystem模块向NameNode请求上传文件，NameNode检查目标文件是否已经存在，父目录是否存在
2. NameNode返回是否可以上传
3. 客户端请求第一个Block上传到哪几个DataNode服务器上
4. NameNode返回3个DataNode节点，分别为dn1、dn2、dn3
5. 客户端通过FSDataOutputStream模块请求dn1上传数据，dn1收到请求会继续调用dn2，然后dn2调用dn3，将这个通信管道建立完成
6. dn1、dn2、dn3逐级应答客户端
7. 客户端开始往dn1上传第一个Blcok(先从磁盘读取数据放到一个本地缓存)，以Packet为单位，dn1收到一个Packet就会传给dn2mdn2传给dn3；dn1每传一个packet都会放入一个应答队列等待应答
8. 当一个Block传输完成之后，客户端再次请求NameNode上传第二个Block的服务器(重复执行3-7)

#### 网络拓扑-节点距离计算

在HDFS写数据的过程中，NameNode会选择距离上传数据近距离的NameNode接收数据

节点距离：两个节点到达最近的共同祖先的距离总和

Distance(d1/r1/n0,d1/r1/n0)=0(同一节点上的进程)

Distance(d1/r1/n1,d1/r1/n2)=2(同一机架上不同节点)

Distance(d1/r2/n1,d1/r3/n2)=4(同一数据中心上不同机架上的节点)

Distance(d1/r2/n1,d2/r4/n1)=6(不同数据中心的节点)

```mermaid
flowchart LR
subgraph 互联网
	subgraph 集群d1
		subgraph 机架r1
			r11(n0)
			r12(n1)
			r13(n2)
		end
		subgraph 机架r2
			r21(n0)
			r22(n1)
			r23(n2)
		end
		subgraph 机架r3
			r31(n0)
			r32(n1)
			r33(n2)
		end
	end
		subgraph 集群d2
			subgraph 机架r4
			r41(n0)
			r42(n1)
			r43(n2)
		end
			subgraph 机架r5
			r51(n0)
			r52(n1)
			r53(n2)
		end
			subgraph 机架r6
			r61(n0)
			r62(n1)
			r63(n2)
		end
	end
end
```

假设有数据中心d1机架r1中的节点n1，该节点可以标识为d1/r1/n1，利用这种标记，给出四种距离描述。

![img](Hadoop.assets/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmdzaGVuZ3dlaTIzMDYxMg==,size_16,color_FFFFFF,t_70.png)

5-9距离为1+1+1=3

#### 机架感知(副本存储节点选择)

##### 官方说明

​	For the common case, when the replication factor is three, HDFS’s placement policy is to put one replica on the local machine if the writer is on a datanode, otherwise on a random datanode in the same rack as that of the writer, another replica on a node in a different (remote) rack, and the last on a different node in the same remote rack. This policy cuts the inter-rack write traffic which generally improves write performance. The chance of rack failure is far less than that of node failure; this policy does not impact data reliability and availability guarantees. However, it does not reduce the aggregate network bandwidth used when reading data since a block is placed in only two unique racks rather than three. With this policy, the replicas of a block do not evenly distribute across the racks. Two replicas are on different nodes of one rack and the remaining replica is on a node of one of the other racks. This policy improves write performance without compromising data reliability or read performance.

##### 具体选择

第一个副本在Client所处的节点上，如果客户端在集群外，随机选一个

第二个副本在另一个机架的随机一个节点

第三个副本在第二个副本所在机架的随机节点

#### HDFS读数据流程

![image-20211026215716074](Hadoop.assets/image-20211026215716074.png)

1. 客户端通过Distributed FileSystem向NameNode请求下载文件，NameNode通过查询元数据，找到文件块所在的DataNode地址
2. 挑选一台DataNode(就近原则，然后随机)服务器，请求读取数据
3. DataNode开始传输数据给客户端(从磁盘里面读取数据输入流，以Packet为单位来做校验)
4. 客户端以Packet为单位接收，先在本地缓存，然后写入目标文件

### 5. NameNode和SecondaryNameNode

#### NN和2NN工作机制

NameNode中的元数据是存储在哪里的？

如果存储在NameNode节点的磁盘中，因为经常需要进行随机访问，还有相应客户请求，必然是效率过低。因此，元数据需要存放在内存中。但如果只存在内存中，一旦断电，元数据丢失，整个集群就无法工作了，**因此产生在磁盘中备份元数据的FsImage**

这样又会带来新的问题，当在内存中的元数据更新时，如果同时更新FsImage，就会导致效率过低，但如果不更新，就会发生一致性问题，一旦NameNode节点断电，就会产生数据丢失。因此，引入Edits文件(只进行追加操作，效率很高)。**每当元数据有更新或者添加元数据时，修改内存中的元数据并追加到Edits中**。这样，一旦NameNode节点断电，可以通过FsImage和Edits的合并，合成元数据。

![image-20211026223103542](Hadoop.assets/image-20211026223103542.png)

##### 1.第一阶段 NameNode启动

1. 第一次启动NameNode格式化后，创建Fsimage和Edits文件。如果不是第一次启动，直接加载编辑日子和镜像文件到内存
2. 客户端对元数据进行增删改的请求
3. NameNode记录操作日志，更新滚动日志
4. NameNode在内存中对数据进行增删改

##### 2.第二阶段 Secondary NameNode工作

1.  Secondary NameNode询问NameNode是否需要CheckPoint，直接带回NameNode是否检查结果
2. Secondary NameNode请求执行CheckPoint
3. NameNode滚动正在写的Edits日志
4. 将滚动前的编辑日志和镜像文件拷贝到Secondary NameNode
5. Secondary NameNode加载编辑日志和镜像文件到内存，并合并
6. 生成新的镜像文件fsimage.chkpoint
7. 拷贝fsimage.chkpoint到NameNode
8. NameNode将fsimage.chkpoint重新命名成fsimage

#### Fsimage和Edits解析

##### Fsimage和Edits概念

NameNode被格式化之后，将在/opt/module/hadoop-3.3.1/data/dfs/name/current目录中产生如下文件:

```bash
 fsimage_0000000000000000000
 fsimage_0000000000000000000.md5
 seen_txid
 VERSION
```

1. Fsimage文件：HDFS文件系统元数据的一个永久性的检查点，其中包含HDFS文件系统的所有目录和文件inode的序列化信息
2. Edits文件:存放HDFS文件系统所有更新操作的路径，文件系统客户端执行的所有写操作首先会被记录到Edits文件中
3. seen_txid文件保存的是一个数字，就是最后一个edits_的数字
4. 每次NameNode启动的时候都会将Fsimage文件读入内存，加载Edits里面的更新操作，保证内存中的元数据信息是最新的、同步的，可以看成NameNode启动的时候就将Fsimage和Edits文件进行了合并

##### oiv查看Fsimage文件

1. 查看oiv和oev命令

   ```
   oev      apply the offline edits viewer to an edits file
   oiv      apply the offline fsimage viewer to an fsimage
   ```
   
2. 基本语法

   `hdfs oiv -p 文件类型 -i 镜像文件 -o 转换后文件输出路径`

3. 案例实操

   ```bash
   [zxk@hadoop102 current]$ hdfs oiv -p XML -i fsimage_0000000000000000483 -o /opt/software/fsimage.xml
   ```

4. fsimage里面利用树形结构存储文件的层次，每个文件都有ID表示，但是并不存储文件具体的位置，每次集群启动，其他的节点都会主动向NameNode汇报

##### oev查看Edits文件

1. 基本语法 

   `hdfs oev -p 文件类型 -i 编辑日志 -o 转换后文件输出路径`

2. 案例实操

   ```bash
   [zxk@hadoop102 current]$ hdfs oev -p XML -i edits_inprogress_0000000000000000486 -o /opt/software/edit.xml
   ```

3. 里面用xml格式，记录追加操作

4. NameNode每次启动如何确认合并哪些？合并大于fsimage序号的

5. 2NN没有progress也就是最新的信息，如果NameNode挂掉，只使用2NN，那么就会丢失最新的操作信息

#### CheckPoint时间设置

1. 通常情况下，SecondaryNameNode每隔一小时执行一次

   ```xml
   <property>
       <name>dfs.namenode.checkpoint.period</name>
       <value>3600s</value>
   </property>
   ```

2. 一分钟检查一次操作次数，当操作次数达到一百万时，SecondaryNameNode执行一次

   ```xml
   <property>
       <name>dfs.namenode.checkpoint.txns</name>
       <value>1000000</value>
       <decsription>操作动作次数</decsription>
   </property>
   <property>
       <name>dfs.namenode.checkpoint.check.period</name>
       <value>60s</value>
       <decsription >一分钟检查一次操作次数</decsription> 
   </property>
   ```

### 6. DataNode

#### DataNode工作机制

![image-20211027215155014](Hadoop.assets/image-20211027215155014.png)

1. 一个数据库在DataNode上以文件形式存储在磁盘上，包括两个文件，一个是数据本身，一个是元数据包括数据块的长度，块数据的校验和，以及时间戳
2. DataNode启动后向NameNode注册，通过后，周期性(1小时)的向NameNode上报所有的块信息
3. 心跳是每3s一次，心跳返回结果带有NameNode给该DataNode的命令如复制块数据到另一台机器，或者删除某个数据块。如果超过10分钟没有收到某个DataNode的心跳，则认为该节点不可用。
4. 集群运行中可以安全加入和退出一些机器.

#### 数据完整性

如果电脑磁盘里存储的数据是控制高铁信号灯的红灯信号1和绿灯信号0，但是存储该数据的磁盘坏了，一直显示是绿灯，是否很危险？同理DataNode节点上的数据损坏了，却没有发现，是否也很危险，如何解决？

以下是DataNode节点保证数据完整性的方法

1. 当DataNode读取Block的时候，它会计算CheckSum
2. 如果计算后的CheckSum，与Block创建时值不一样，说明Block已经损坏
3. Client读取其他DataNode上的Block
4. 常见的校验算法crc(32)、md5(128)、sha1(160)
5. DataNode在其文件创建后周期验证CheckSum

![image-20211027223248894](Hadoop.assets/image-20211027223248894.png)

#### 掉线时限参数设置

1. DataNode进程死亡或者网络故障造成DataNode无法与NameNode通信
2. NameNode不会立即把该节点判定为死亡，要经过一段时间，这段时间暂称为超时时长
3. HDFS默认的超时时长为10分钟+30秒
4. 如果定义超时时间为TimeOut，则超时时长计算公式为`TimeOut=2*dfs.namenode.heartbeat.recheck-interval+10*dfs.heartbeat.interval`，而默认的dfs.namenode.heartbeat.recheck-interval大小为5分钟，dfs.heartbeat.interval默认为3s

需要注意的是hdfs-site.xml配置文件中的heartbeat.recheck.interval的单位为毫秒，dfs.heartbeat.interval的单位为秒

```mermaid
flowchart TB
NameNode <==> DataNode
```



```xml
<property>
    <name>dfs.namenode.heartbeat.recheck-interval</name>
    <value>300000</value>
</property>
<property>
    <name>dfs.heartbeat.interval</name>
    <value>3</value>
</property>
```

### 总结

1. HDFS块大小
   - 磁盘读写速度
2. HDFS shell操作 重点
3. HDFS读写流程 重点

## 4. MapReduce

