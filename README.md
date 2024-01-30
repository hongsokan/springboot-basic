# springboot basic
- 프로젝트 기본 설정 모음

## 기본 설정
### 1. DataSource
- application.yml
```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/basic?serverTimezone=UTC&characterEncoding=UTF-8
    username:
    password:
    driver-class-name: com.mysql.cj.jdbc.Driver
```
```sql
CREATE TABLE `SAMPLE`
(
    `SAMPLE_ID` int(11)      NOT NULL AUTO_INCREMENT,
    `TITLE`     varchar(100) NOT NULL,
    `CONTENTS`  text         NOT NULL,
    `REG_DATE`  datetime     NOT NULL,
    PRIMARY KEY (`SAMPLE_ID`)
) ENGINE = InnoDB
#   AUTO_INCREMENT = 23
  DEFAULT CHARSET = utf8 COMMENT ='샘플';

-- 샘플 INSERT QUERY
INSERT INTO SAMPLE (TITLE, CONTENTS, REG_DATE)
VALUES ('테스트', '테스트 컨텐츠', NOW());
```

- DatabaseConfig.java : 
DataSource bean 등록 및 SqlSessionFactory 빈 등록
- MybatisConfig.java :
Mapper 스캐너 빈 등록
