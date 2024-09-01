package com.anthony.minimal.category.domain.repository;

import com.anthony.minimal.category.domain.Category;
import com.anthony.minimal.web.repository.DefaultRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends DefaultRepository<Category> {

    @Override
    @Query("SELECT c FROM Category c WHERE c.name ILIKE %:search%")
    Page<Category> search(@Param("search") String search, Pageable pageable);

}
