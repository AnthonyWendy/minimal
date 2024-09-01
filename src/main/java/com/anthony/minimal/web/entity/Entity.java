package com.anthony.minimal.web.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public interface Entity extends Serializable {

    Long getId();

}
