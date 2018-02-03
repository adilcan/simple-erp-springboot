package com.gitlab.adilcan.erp.commercial;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyRepository extends CrudRepository<ThirdParty, Long> {
}

