package com.anthony.minimal.record.controller;

import com.anthony.minimal.category.domain.Category;
import com.anthony.minimal.category.service.CategoryService;
import com.anthony.minimal.record.domain.Record;
import com.anthony.minimal.record.service.RecordService;
import com.anthony.minimal.web.controller.DefaultController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("record")
public class RecordController extends DefaultController<Record, RecordService> {

}
