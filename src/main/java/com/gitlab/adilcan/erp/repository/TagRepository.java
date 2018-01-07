package com.gitlab.adilcan.erp.repository;

import com.gitlab.adilcan.erp.domain.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
}
