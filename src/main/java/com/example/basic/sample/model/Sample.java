package com.example.basic.sample.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Sample {
    int sampleId;
    String title;
    String contents;
    LocalDateTime regDate;
}
