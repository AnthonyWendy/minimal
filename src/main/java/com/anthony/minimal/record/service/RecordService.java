package com.anthony.minimal.record.service;

import com.anthony.minimal.category.domain.Category;
import com.anthony.minimal.category.domain.repository.CategoryRepository;
import com.anthony.minimal.record.domain.Record;
import com.anthony.minimal.record.domain.repository.RecordRepository;
import com.anthony.minimal.web.service.DefaultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RecordService extends DefaultService<Record, RecordRepository> {

    @Override
    protected void beforeUpdate(Record record) {
        LocalDateTime registrationDate = repository.getRegistrationDate(record.getId());
        record.setRegistrationDate(registrationDate);
    }
}
