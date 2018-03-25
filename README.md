> 开源是一种态度，分享是一种精神！

```
从发表springcloud到现在已经有一个星期的时间，很多朋友反映服务跑不起来，这里给大家详细的介绍一下配置中心的加解密，一个星期的时间，paascloud加了500+的星星，上了github本周加星榜，感谢大家的支持，同时也使笔者有了坚持下去的力量，这里谢谢的大家的支持
```
![这里写图片描述](http://img.paascloud.net/paascloud/doc/github_20180325225716.png)

## 配置JDK的JCE

### 下载

```
http://download.oracle.com/otn-pub/java/jce/8/jce_policy-8.zip
```
jdk最好使用jdk8后期的版本，建议使用144以后的版本

### 配置

```
我们需要将这里的两个jar包拷贝到我们的jdk安装目录下，我的是%JAVA_HOME%\jre\lib\security，覆盖该目录下原有的文件，切记是jdk的jre目录
```

jdk中自带的keytool工具生成密钥文件

```
keytool -genkeypair -alias paascloud-key-store -keyalg RSA -keypass paascloud-keypass -keystore server.jks -storepass paascloud-storepass
```

![这里写图片描述](http://img.paascloud.net/paascloud/doc/jce_20180325140421.png)

最后会生成一个文件server.jks 使用这个文件替换paascloud-master中配置中心的server.jks的文件
![这里写图片描述](http://img.paascloud.net/paascloud/doc/jec_20180325140532.png)

然后配置文件修改

```yml
encrypt:
 key-store:
   location: classpath:/server.jks
   password: paascloud-storepass
   alias: paascloud-key-store
   secret: paascloud-keypass
```
到此 我们配置环节就做好了，下面给大家介绍一下具体使用
## 使用

这里说明一下，根据笔者经验如果配置中心使用了加密，类似这样
	
```yml
spring:
  cloud:
    config:
      uri: http://admin:admin@paascloud-discovery:8080/
      label: master
      profile: ${spring.profiles.active:dev}
      ignoredInterfaces:
        - docker0
        - veth.*
        - VM.*
```
那么在使用jce做加密的时候往往会有未知的异常，所以这里为了给大家演示使用这里新起一个paascloud-example项目，找到模块paascloud-example-encrypt

### 启动项目

```
paascloud-encrypt-eureka
paascloud-encrypt-discovery
```
	
### 加解密操作
加密

```
 λ curl -X POST http://localhost:8080/encrypt -d 7010
```
加密结果
```
AQAznUNC91gEsaaejlN8kYfBbB66l/gbONnDP2IJz9yt+5wxc8cJDkIVsvtdyVVAen2+3t5iVe4IhhQB2PWr5vARdHi1CkeufFIwKVXESXzONwpbO4kh1+WhDuD/dfHKYZWKlrucUTbT1tNyxKBHaoopIDPkKKfyqLWMnhap9YKygMyp40pEEWMmG86Fb05gn8E5mq0cSpW9vVuybHTlh701k4/Zq8soRwqX8kXc5+oH05DIoTReKTByuK82MnMF9+a+MGf/qKZgChAgWTHQVuz2yMhWySvbWEKkNjNJ3r3LdWJG844Ka0dYKSTMEGdOw4ls+p0TLw5mdMPuJDd/uuduBE+mdf7BF+EAGfyCjzF3heEqVrXUnU8kVTUnFUf4QvM=
```
解密

```
λ curl localhost:8080/decrypt -d AQAoax6LyiCDqHuPuWTp95iDvPbBq5lJx2SGd1cxgMeJ2QvSpUNX2XKzd9gRzG7q40/fcN9K6wmTWzlQKLhHsuTn eYOTD79pEHIeKyp5GHIhvQXopO97Hu/E4cfkS8uH6oug6w5MmLZvOW1uRe2EBTroyk2k1HtrTOv9z0FPDxXhEe+5QcyAR/ArKwsZ4axPDXjv4pFEg6R9h/H4xG0hQJ9MPhDDzn1+Swmnerjnjfel6oSQ9vDC6WG9HwT527hIG74IWXIKd/JPqCE5XvcTilf9P3prcanDT2peKdatdlYGruXBva7pZmUUuov4TiKs4Yrqzl7JAO/4GtQhm16kuAbTBbevkv4HwVlPLeMgXy/EoSC9VHTDn635qiBObg3Cgis=
```
解密结果
```
7010
```

![这里写图片描述](http://img.paascloud.net/paascloud/doc/jce_20180325153913.png)

yml使用

```
rabbitmq:
    host:  paascloud-mq-rabbit
    port: 5672
    username: '{cipher}你的密文'
    password: '{cipher}你的密文'
```

## 后记

```
开源是一种态度，分享是一种精神！
```

## 我的开源项目
[github](https://github.com/paascloud/paascloud-master)： https://github.com/paascloud/paascloud-master

[码云](https://gitee.com/paascloud/paascloud-master)：https://gitee.com/paascloud/paascloud-master