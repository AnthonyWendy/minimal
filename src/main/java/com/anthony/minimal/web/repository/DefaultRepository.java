package com.anthony.minimal.web.repository;

import com.anthony.minimal.web.entity.DefaultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface DefaultRepository<T extends DefaultEntity> extends JpaRepository<T, Long> {

    Page<T> search(String search, Pageable pageable);

    Optional<T> findById(Long id);

    void delete(T entity);


}
