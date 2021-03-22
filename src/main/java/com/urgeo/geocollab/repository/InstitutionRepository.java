
package com.urgeo.geocollab.repository;

import com.urgeo.geocollab.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long>{
    
}
