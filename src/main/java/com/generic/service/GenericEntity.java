package com.generic.service;

public interface GenericEntity<T> {

    void update(T source);

    Long getId();

    T createNewInstance();
}
