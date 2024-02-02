package com.example.basic.sample.mapper;

import com.example.basic.sample.model.SampleBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SampleBoardMapper {
    List<SampleBoard> getSampleList();

    SampleBoard getSample(int boardId);

    void insertSample(SampleBoard sample);

    void updateSample(SampleBoard sample);

    void deleteSample(int boardId);
}
