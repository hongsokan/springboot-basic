package com.example.basic.sample.service;

import com.example.basic.sample.mapper.SampleBoardMapper;
import com.example.basic.sample.mapper.SampleMapper;
import com.example.basic.sample.model.SampleBoard;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SampleBoardService {

    private SampleBoardMapper sampleMapper;

    public SampleBoardService(SampleBoardMapper sampleMapper) {
        this.sampleMapper = sampleMapper;
    }

    @Transactional(readOnly = true)
    public List<SampleBoard> getSampleList() {
        return sampleMapper.getSampleList();
    }

    @Transactional(readOnly = true)
    public SampleBoard getSample(int boardId) {
        return sampleMapper.getSample(boardId);
    }


    public void insertSample(SampleBoard sample) {
        System.out.println(sample.toString());
        sampleMapper.insertSample(sample);
    }


    public void updateSample(SampleBoard sample) {
        sampleMapper.updateSample(sample);
    }

    public void deleteSample(int boardId) {
        sampleMapper.deleteSample(boardId);
    }

    @Transactional
    public void transactional(SampleBoard sample) {
        insertSample(sample);
        sample.setTitle("This is transaction sample.");
        updateSample(sample);
    }
}
