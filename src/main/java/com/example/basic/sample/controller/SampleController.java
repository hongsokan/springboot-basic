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
    public Sample getSample(int sampleId) {
        return sampleService.getSample(sampleId);
    }

    @PostMapping("")
    public void insertSample(Sample sample) {
        sampleService.insertSample(sample);
    }

    @PutMapping("")
    public void updateSample(Sample sample) {
        sampleService.updateSample(sample);
    }

    @DeleteMapping("/{sampleId}")
    public void deleteSample(int sampleId) {
        sampleService.deleteSample(sampleId);
    }

}
