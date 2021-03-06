package com.letsgo.todisplay.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.letsgo.todisplay.model.LayoutTpl;

//@PreAuthorize("hasRole('ROLE_USER')")
//@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE }, maxAge = 3600)
@CrossOrigin
@RepositoryRestResource
public interface LayoutTplRepository extends CrudRepository<LayoutTpl, Long> {

}
