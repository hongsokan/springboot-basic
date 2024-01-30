package com.example.basic.sample.mapper;

import com.example.basic.sample.model.Sample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SampleMapper {
    List<Sample> getSampleList();
    Sample getSample(int sampleId);
    void insertSample(Sample sample);
    void updateSample(Sample sample);
    void deleteSample(int sampleId);
}
