package com.democrance.dataaccessobject;

import com.democrance.domainobject.PolicyDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Database Access Object for policy table.
 */
@Repository
public interface PolicyRepository extends CrudRepository<PolicyDo, Long> {

}