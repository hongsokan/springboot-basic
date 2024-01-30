package com.example.basic.sample.controller;

import com.example.basic.common.model.SuccessResponse;
import com.example.basic.sample.model.Sample;
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
@RequestMapping("/api/sample")
@Tag(name = "샘플", description = "기본 샘플 API")
public class SampleController {

    final SampleService sampleService;

    @GetMapping("")
    @Operation(summary = "샘플 전체조회", description = "모든 샘플을 전체 조회한다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "샘플 조회 성공", content = @Content(schema = @Schema(implementation = Sample.class)))
    })
    public SuccessResponse getSampleList() {
        List<Sample> result = sampleService.getSampleList();
        return new SuccessResponse(result);
    }

    @GetMapping("/{sampleId}")
    @Parameters({
            @Parameter(name = "sampleId", description = "샘플아이디", in = ParameterIn.PATH)
    })
    @Operation(summary = "샘플조회", description = "특정 샘플을 조회한다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "샘플 조회 성공", content = @Content(schema = @Schema(implementation = Sample.class)))
    })
    public Sample getSample(@PathVariable("sampleId") int sampleId) {
        return sampleService.getSample(sampleId);
    }

    @PostMapping("")
    @Operation(summary = "샘플등록", description = "샘플을 등록한다.")
    public void insertSample(@RequestBody Sample sample) {
        sampleService.insertSample(sample);
    }

    @PutMapping("")
    @Operation(summary = "샘플수정", description = "샘플을 수정한다.")
    public void updateSample(@RequestBody Sample sample) {
        sampleService.updateSample(sample);
    }

    @DeleteMapping("/{sampleId}")
    @Parameters({
            @Parameter(name = "sampleId", description = "샘플아이디", in = ParameterIn.PATH)
    })
    @Operation(summary = "샘플삭제", description = "특정 샘플을 삭제한다.")
    public void deleteSample(@PathVariable("sampleId") int sampleId) {
        sampleService.deleteSample(sampleId);
    }

}
