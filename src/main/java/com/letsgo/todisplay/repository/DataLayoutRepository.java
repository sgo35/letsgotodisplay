package com.letsgo.todisplay.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.letsgo.todisplay.model.DataLayout;

@PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource
public interface DataLayoutRepository extends CrudRepository<DataLayout, Long>{

}
