
package com.urgeo.geocollab.repository;

import com.urgeo.geocollab.model.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierRepository extends JpaRepository<Dossier, Long>{

}
