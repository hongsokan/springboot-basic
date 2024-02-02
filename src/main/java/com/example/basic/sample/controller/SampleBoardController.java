package com.example.basic.sample.controller;

import com.example.basic.common.model.SuccessResponse;
import com.example.basic.sample.model.Sample;
import com.example.basic.sample.model.SampleBoard;
import com.example.basic.sample.service.SampleBoardService;
import com.example.basic.sample.service.SampleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sample/board")
@Tag(name = "샘플 게시판", description = "기본 샘플 게시판 API")
public class SampleBoardController {

    final SampleBoardService sampleService;

    @GetMapping("")
    @Operation(summary = "샘플 게시판 전체조회", description = "모든 샘플 게시판을 전체 조회한다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "샘플 게시판 조회 성공", content = @Content(schema = @Schema(implementation = SampleBoard.class)))
    })
    public SuccessResponse getSampleList() {
        List<SampleBoard> result = sampleService.getSampleList();
        return new SuccessResponse(result);
    }

    @GetMapping("/{boardId}")
    @Parameters({
            @Parameter(name = "boardId", description = "샘플게시판 아이디", in = ParameterIn.PATH)
    })
    @Operation(summary = "샘플게시판 조회", description = "특정 샘플게시판을 조회한다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "샘플게시판 조회 성공", content = @Content(schema = @Schema(implementation = SampleBoard.class)))
    })
    public SampleBoard getSample(@PathVariable("boardId") int boardId) {
        return sampleService.getSample(boardId);
    }

    @PostMapping("")
    @Operation(summary = "샘플게시판 등록", description = "샘플게시판을 등록한다.")
    public void insertBoard(@RequestBody SampleBoard sample) {
        sampleService.insertSample(sample);
    }

    @PutMapping("")
    @Operation(summary = "샘플게시판 수정", description = "샘플게시판을 수정한다.")
    public void updateSample(@RequestBody SampleBoard sample) {
        sampleService.updateSample(sample);
    }

    @DeleteMapping("/{boardId}")
    @Parameters({
            @Parameter(name = "boardId", description = "샘플게시판 아이디", in = ParameterIn.PATH)
    })
    @Operation(summary = "샘플게시판 삭제", description = "특정 샘플게시판을 삭제한다.")
    public void deleteSample(@PathVariable("boardId") int boardId) {
        sampleService.deleteSample(boardId);
    }

}
