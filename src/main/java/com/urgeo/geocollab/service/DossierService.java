
package com.urgeo.geocollab.service;

import com.urgeo.geocollab.exception.RecordNotFoundException;
import com.urgeo.geocollab.model.Dossier;
import com.urgeo.geocollab.repository.DossierRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DossierService {
    
    @Autowired
    DossierRepository dossierRep;
    
    public Dossier getDossierById(Long id) throws RecordNotFoundException{
        Optional<Dossier> dossier = dossierRep.findById(id);
        
        if(dossier.isPresent()){
            return dossier.get();
        }else{
            throw new RecordNotFoundException("No dossier record exist for given id", id);
        }
    }

    public Dossier create(Dossier dossier){
        return dossierRep.save(dossier);
    }

    public Dossier update(Dossier dossier) throws RecordNotFoundException{
            Optional<Dossier> _dossier = dossierRep.findById(dossier.getId());
            
            if(_dossier.isPresent()){
                Dossier newDossier = _dossier.get();
                newDossier.setCreatedBy(dossier.getCreatedBy());
                //... to be continued

                return dossierRep.save(newDossier);
            }

            return null;
    }

    public void deleteDossier(Long id) throws RecordNotFoundException{
        Optional<Dossier> dossier = dossierRep.findById(id);
        
        if(dossier.isPresent()){
            dossierRep.deleteById(id);
        }else{
            throw new RecordNotFoundException("No dossier record exist for given id", id);
        }
    }

    public int saveAll(List<Dossier> dossiers) throws Exception{
        List<Dossier> s = dossierRep.saveAll(dossiers);
        return s.size();
    }

    public List<Dossier> getAllDossiers()
    {
        List<Dossier> dossiers = dossierRep.findAll();
          
        if(dossiers.size() > 0) {
            return dossiers;
        } else {
            return new ArrayList<Dossier>();
        }
    }
}
