package com.generic.service.service;

import com.generic.service.GenericEntity;
import com.generic.service.exception.UserException;
import com.generic.service.repo.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;

public class GenericService<T extends GenericEntity<T>> {

    private final GenericRepository<T> genericRepository;

    public GenericService(GenericRepository<T> genericRepository) {
        this.genericRepository = genericRepository;
    }

    public Page<T> getPage(Pageable pageable){
        return genericRepository.findAll(pageable);
    }

    public T get(Long id){
        return genericRepository.findById(id).orElseThrow(
                () -> new UserException("User not found "+id)
        );
    }

    @Transactional
    public T update(T updated){
        T dbDomain = get(updated.getId());
        dbDomain.update(updated);

        return genericRepository.save(dbDomain);
    }

    @Transactional
    public T create(T newDomain){
        T dbDomain = newDomain.createNewInstance();
        return genericRepository.save(dbDomain);
    }

    @Transactional
    public void delete(Long id){
        //check if object with this id exists
        get(id);
        genericRepository.deleteById(id);
    }
}
