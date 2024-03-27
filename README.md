# springboot boilderplate
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
CREATE TABLE `sample`
(
    `sample_id` int(11)      NOT NULL AUTO_INCREMENT,
    `title`     varchar(100) NOT NULL,
    `contents`  text         NOT NULL,
    `reg_date`  datetime     NOT NULL,
    PRIMARY KEY (`sample_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='샘플';

-- 샘플 INSERT QUERY
INSERT INTO sample (title, contents, reg_date)
VALUES ('테스트', '테스트 컨텐츠', now());
```

- DatabaseConfig.java : 
DataSource bean 등록 및 SqlSessionFactory 빈 등록
- MybatisConfig.java :
Mapper 스캐너 빈 등록


### 2. Swagger UI
```yaml
springdoc:
  default-consumes-media-type: application/json
  default-produces-media-type: application/json
  api-docs:
    groups:
      enabled: true
  swagger-ui:
    operations-sorter: alpha # alpha(알파벳 오름차순), method(HTTP메소드순)
    tags-sorter: alpha # 태그 정렬 기준
    path: /swagger-ui.html # html 문서 접속 경로
    disable-swagger-default-url: true
    doc-expansion: none # tag, operation 펼치는 방식
  paths-to-match:
    - /**
```
- OpenApiConfig.java
```java
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {

        Info info = new Info()
                .version("v1.0.0")
                .title("API 타이틀")
                .description("API Description");

        return new OpenAPI()
                .info(info);
    }
}
```

### 3. 로그 설정 추가
- gradle
```
implementation 'ch.qos.logback:logback-classic:1.4.6'
implementation 'org.slf4j:slf4j-log4j12:2.0.10'
```
- logback.xml
```xml
<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>
                %d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n
            </pattern>
        </encoder>
    </appender>
    <logger name="com.example.basic" level="DEBUG"/>
    <root level="INFO">
        <appender-ref ref="STDOUT"/>
    </root>
</configuration>
```

### 4. AdminLTE 템플릿 추가
- Thymeleaf Layout Dialect 세팅 (https://ultraq.github.io/thymeleaf-layout-dialect/)
- AdminLTE 템플릿 세팅 (https://adminlte.io/)