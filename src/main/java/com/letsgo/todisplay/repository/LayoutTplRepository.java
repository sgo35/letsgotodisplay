package com.letsgo.todisplay.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.letsgo.todisplay.model.LayoutTpl;

	@PreAuthorize("hasRole('ROLE_USER')")
	@RepositoryRestResource
	public interface LayoutTplRepository extends CrudRepository<LayoutTpl, Long>{

	}
