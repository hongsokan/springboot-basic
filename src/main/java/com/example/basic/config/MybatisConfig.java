package com.example.basic.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class MybatisConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        String basePackage = "com.example.basic.**.mapper";
        mapperScannerConfigurer.setBasePackage(basePackage);
        mapperScannerConfigurer.setAnnotationClass(Mapper.class);
        mapperScannerConfigurer.setSqlSessionTemplateBeanName("sqlSession");
        return mapperScannerConfigurer;
    }
}
