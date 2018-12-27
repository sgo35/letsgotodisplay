package com.letsgo.todisplay.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.letsgo.todisplay.model.DataLayout;

//@PreAuthorize("hasRole('ROLE_USER')")
@CrossOrigin
@RepositoryRestResource
public interface DataLayoutRepository extends CrudRepository<DataLayout, Long>{

}
