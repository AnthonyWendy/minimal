package com.anthony.minimal.record.service;

import com.anthony.minimal.category.domain.Category;
import com.anthony.minimal.category.domain.repository.CategoryRepository;
import com.anthony.minimal.record.domain.Record;
import com.anthony.minimal.record.domain.repository.RecordRepository;
import com.anthony.minimal.web.service.DefaultService;
import org.springframework.stereotype.Service;

@Service
public class RecordService extends DefaultService<Record, RecordRepository> {
}
