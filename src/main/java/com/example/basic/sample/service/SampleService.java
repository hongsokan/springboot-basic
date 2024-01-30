package com.example.basic.sample.service;

import com.example.basic.sample.mapper.SampleMapper;
import com.example.basic.sample.model.Sample;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SampleService {

    private SampleMapper sampleMapper;

    public SampleService(SampleMapper sampleMapper) {
        this.sampleMapper = sampleMapper;
    }

    @Transactional(readOnly = true)
    public List<Sample> getSampleList() {
        return sampleMapper.getSampleList();
    }

    @Transactional(readOnly = true)
    public Sample getSample(int sampleId) {
        return sampleMapper.getSample(sampleId);
    }


    public void insertSample(Sample sample) {
        sampleMapper.insertSample(sample);
    }


    public void updateSample(Sample sample) {
        sampleMapper.updateSample(sample);
    }

    public void deleteSample(int sampleId) {
        sampleMapper.deleteSample(sampleId);
    }

    @Transactional
    public void transactional(Sample sample) {
        insertSample(sample);
        sample.setTitle("This is transaction sample.");
        updateSample(sample);
    }
}
