
package com.urgeo.geocollab.service;

import com.urgeo.geocollab.exception.RecordNotFoundException;
import com.urgeo.geocollab.model.Institution;
import com.urgeo.geocollab.repository.InstitutionRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class InstitutionService {
    
    @Autowired
    InstitutionRepository institutionRep;
    
    public Institution getInstitutionById(Long id) throws RecordNotFoundException{
        Optional<Institution> institution = institutionRep.findById(id);
        
        if(institution.isPresent()){
            return institution.get();
        }else{
            throw new RecordNotFoundException("No institution record exist for given id", id);
        }
    }

    public Institution create(Institution institution) throws RecordNotFoundException{
        return institutionRep.save(institution);
    }

    public Institution update(Institution institution) throws RecordNotFoundException{
            Optional<Institution> _institution = institutionRep.findById(institution.getId());
            
            if(_institution.isPresent()){
                Institution newInstitution = _institution.get();
                // to be continued
                
                newInstitution = institutionRep.save(newInstitution);
                return newInstitution;
            }

            return null;
    }

    public int saveAll(List<Institution> institutions) throws Exception{
        int size = -1;
        List<Institution> ls = institutionRep.saveAll(institutions);
        return ls.size();
    }
    
    public void deleteInstitution(Long id) throws RecordNotFoundException{
        Optional<Institution> institution = institutionRep.findById(id);
        
        if(institution.isPresent()){
            institutionRep.deleteById(id);
        }else{
            throw new RecordNotFoundException("No institution record exist for given id", id);
        }
    }

    public List<Institution> orderAllByDatePub(final String criteria){
        return institutionRep.findAll(Sort.by(Sort.Direction.DESC, criteria));
    }

    public List<Institution> getAllInstitutions()
    {
        List<Institution> institutions = institutionRep.findAll();
          
        if(institutions.size() > 0) {
            return institutions;
        } else {
            return new ArrayList<Institution>();
        }
    }
}


