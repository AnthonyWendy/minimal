package com.anthony.minimal.web.controller;

import com.anthony.minimal.web.entity.DefaultEntity;
import com.anthony.minimal.web.service.DefaultService;

import java.net.URI;
import java.util.Arrays;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

public class DefaultController<T extends DefaultEntity, S extends DefaultService<T, ?>> {

    @Autowired
    protected S service;

    @PostMapping("/")
    public ResponseEntity<T> doPost(@RequestBody T entity) {
        service.save(entity);
        return ResponseEntity.created(getEntityUri(entity)).body(entity);
    }

    @PutMapping("/")
    public ResponseEntity<T> doPut(@RequestBody T entity) {
        service.update(entity);
        return ResponseEntity.accepted().body(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> doGet(@PathVariable Long id) {
        T entity = service.findOne(id);
        return ResponseEntity.accepted().body(entity);
    }

    @GetMapping({"/", ""})
    public ResponseEntity<Page<T>> doGetAll(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return ResponseEntity.ok(service.search(search, pageable));
        }
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<T> doDelete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private URI getEntityUri(T entity) {
        return UriComponentsBuilder.fromPath("/").pathSegment(getPath()).pathSegment(entity.getId().toString()).build().toUri();
    }

    private String getPath() {
        return Arrays.stream(getClass().getAnnotation(RequestMapping.class).value()).findFirst().orElse("");
    }
}
