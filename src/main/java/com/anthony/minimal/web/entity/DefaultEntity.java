package com.anthony.minimal.web.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public interface DefaultEntity extends Serializable {

    Long getId();

}