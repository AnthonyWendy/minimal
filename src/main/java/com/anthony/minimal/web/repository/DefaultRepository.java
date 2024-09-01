package com.anthony.minimal.web.repository;

import com.anthony.minimal.web.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface DefaultRepository<T extends Entity> extends JpaRepository<T, Long> {

    Page<T> search(String search, Long idCompany, Pageable pageable);

    T findOne(Long id);

    Optional<T> findById(Long id);

    T save(T entity, String username, String path);

    void delete(T entity, String username, String path);

}
