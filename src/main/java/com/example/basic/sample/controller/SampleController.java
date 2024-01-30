package com.example.basic.sample.controller;

import com.example.basic.sample.model.Sample;
import com.example.basic.sample.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sample")
public class SampleController {

    final SampleService sampleService;

    @GetMapping("")
    public List<Sample> getSampleList() {
        return sampleService.getSampleList();
    }

    @GetMapping("/{sampleId}")
    public Sample getSample(@PathVariable("sampleId") int sampleId) {
        return sampleService.getSample(sampleId);
    }

    @PostMapping("")
    public void insertSample(@RequestBody Sample sample) {
        sampleService.insertSample(sample);
    }

    @PutMapping("")
    public void updateSample(@RequestBody Sample sample) {
        sampleService.updateSample(sample);
    }

    @DeleteMapping("/{sampleId}")
    public void deleteSample(@PathVariable("sampleId") int sampleId) {
        sampleService.deleteSample(sampleId);
    }

}
