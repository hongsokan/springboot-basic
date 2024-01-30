package com.example.basic.sample.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema(description = "샘플 Response VO")
@Getter
@Setter
public class Sample {

    @Schema(description = "샘플아이디", type = "Integer")
    private Integer sampleId;

    @Schema(description = "타이틀", type = "String")
    private String title;

    @Schema(description = "콘텐츠", type = "String")
    private String contents;

    @Schema(description = "등록일시", type = "LocalDateTime")
    private LocalDateTime regDate;
}
