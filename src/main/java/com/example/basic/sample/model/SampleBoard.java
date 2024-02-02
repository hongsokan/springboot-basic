package com.example.basic.sample.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema(description = "샘플 Board VO")
@Getter
@Setter
public class SampleBoard {

    @Schema(description = "게시판아이디", type = "int")
    private int boardId;

    @Schema(description = "게시판유형", type = "SampleBoardType")
    private SampleBoardType boardType;

    @Schema(description = "타이틀", type = "String")
    private String title;

    @Schema(description = "콘텐츠", type = "String")
    private String contents;

    @Schema(description = "등록일시", type = "LocalDateTime")
    private LocalDateTime regDate;
}
