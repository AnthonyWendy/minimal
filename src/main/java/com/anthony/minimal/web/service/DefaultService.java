package com.anthony.minimal.web.service;

import com.anthony.minimal.web.Tools.Adapters;
import com.anthony.minimal.web.Tools.Validators;
import com.anthony.minimal.web.entity.Entity;
import com.anthony.minimal.web.repository.DefaultRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class DefaultService<T extends Entity, R extends DefaultRepository<T>> {

    @Autowired
    @Getter
    @Setter
    protected R repository;

    public T save(T entity) {
        if (entity.getId() != null) {
            return update(entity);
        }

        beforeInsert(entity);
        setParentReference(entity);
//        checkEntityValidation();
        repository.save(entity);
        afterInsert(entity);

        return entity;
    }
    public T update(T entity) {
        beforeUpdate(entity);
        setParentReference(entity);
//        checkEntityValidation(entity);
        repository.save(entity);
        afterUpdate(entity);
        return entity;
    }

    @Transactional
    public void delete(T entity) {
        beforeDelete(entity);
        repository.delete(entity);
        afterDelete(entity);
    }

    @Transactional
    public void delete(Long id) {
        T entity = repository.findOne(id);
        if (entity == null) {
            throw new EntityNotFoundException("Entity not found with id: " + id);
        }
        beforeDelete(entity);
        repository.delete(entity);
        afterDelete(entity);
    }

    public T findOne(Long id) {
        return repository.findOne(id);
    }

    public Optional<T> findById(Long id) {
        if (Validators.isNullOrLessThanOne(id))
            return Optional.empty();

        return repository.findById(id);
    }

    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<T> search(String search, Long idCompany, Pageable pageable) {
        String adaptedSearch = Adapters.adaptForFullTextSearch(search);
        return repository.search(adaptedSearch, idCompany, pageable);
    }


//    private void checkEntityValidation(T entity) {
//        ErrorMessage entityValidate = entityValidate(entity);
//        generateException(entityValidate);
//    }

    protected void setParentReference(T entity) {
        // subclasses provide implementation
    }

    protected void afterInsert(T entity) {
        // subclasses provide implementation
    }

    protected void afterUpdate(T entity) {
        // subclasses provide implementation
    }

    protected void afterDelete(T entity) {
        // subclasses provide implementation
    }

    protected void beforeInsert(T entity) {
        // subclasses provide implementation
    }

    protected void beforeUpdate(T entity) {
        // subclasses provide implementation
    }

    protected void beforeDelete(T entity) {
        // subclasses provide implementation
    }

}
