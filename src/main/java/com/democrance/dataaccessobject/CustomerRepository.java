package com.democrance.dataaccessobject;

import com.democrance.domainobject.CustomerDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Database Access Object for Customer table.
 */
@Repository
public interface CustomerRepository extends CrudRepository<CustomerDo, Long> {
}
