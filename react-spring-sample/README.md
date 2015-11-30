## React-spring-sample

### Spec
 - spring security
 - spring reactor
 - mail configuration
 - locale message

### Installation

#### DB

```

$ mysql -uroot < react-spring-sample/src/main/resources/import.sql


$ vi react-spring-sample/src/main/webapp/WEB-INF/config.properties


자신의 개발 환경에 맞게 아래 부분을 수정합니다.

###########################################
## DataSource Configuration
###########################################

jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/uengine?useUnicode=true&characterEncoding=UTF8&zeroDateTimeBehavior=convertToNull
jdbc.username=root
jdbc.password=
jdbc.min.pool=3
jdbc.max.pool=30

```

#### Run

빌드 후 톰캣 실행.
