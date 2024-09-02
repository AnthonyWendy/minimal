package com.anthony.minimal.record.domain.repository;

import com.anthony.minimal.category.domain.Category;
import com.anthony.minimal.record.domain.Record;
import com.anthony.minimal.web.repository.DefaultRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface RecordRepository extends DefaultRepository<Record> {

    @Override
    @Query("SELECT r FROM Record r WHERE r.description ILIKE %:search%")
    Page<Record> search(@Param("search") String search, Pageable pageable);

    @Query("Select r.registrationDate FROM Record r WHERE r.id = :id")
    LocalDateTime getRegistrationDate(@Param("id") Long id);

}
