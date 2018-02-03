package com.gitlab.adilcan.erp.user;

import com.gitlab.adilcan.erp.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created on February, 2018
 *
 * @author adilcan
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByUsername(String username);

}
