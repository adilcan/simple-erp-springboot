package com.gitlab.adilcan.erp.repository;

import com.gitlab.adilcan.erp.domain.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceRepository extends CrudRepository<Service, Long>{


}
