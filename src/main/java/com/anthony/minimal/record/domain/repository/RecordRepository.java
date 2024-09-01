package com.anthony.minimal.record.domain.repository;

import com.anthony.minimal.category.domain.Category;
import com.anthony.minimal.record.domain.Record;
import com.anthony.minimal.web.repository.DefaultRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends DefaultRepository<Record> {

    @Override
    @Query("SELECT c FROM Record c WHERE c.description ILIKE %:search%")
    Page<Record> search(@Param("search") String search, Pageable pageable);

}
