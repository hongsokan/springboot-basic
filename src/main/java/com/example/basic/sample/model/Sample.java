package com.example.basic.sample.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Sample {
    int sampleId;
    String title;
    String contents;
    LocalDateTime regDate;
}
