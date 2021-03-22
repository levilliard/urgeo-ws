
package com.urgeo.geocollab.controller;

import com.urgeo.geocollab.exception.RecordNotFoundException;
import com.urgeo.geocollab.model.Institution;
import com.urgeo.geocollab.service.InstitutionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/institutions")
public class InstitutionCtrl {
    
    @Autowired
    InstitutionService institutionService;
    
    @GetMapping("/all")
    public ResponseEntity<List<Institution>> getAllInstitutions(){
        List<Institution> institutions = institutionService.getAllInstitutions();
        return new ResponseEntity<List<Institution>>(institutions, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Institution> getInstitutionById(@PathVariable("id") Long id)
    throws RecordNotFoundException{
        Institution institution = institutionService.getInstitutionById(id);
        return new ResponseEntity<Institution>(institution, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Institution> postInstitution(@RequestBody Institution institution){
        institution = institutionService.create(institution);
        return new ResponseEntity<Institution>(institution, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/saveall")
    public ResponseEntity<Integer> saveAll(@RequestBody List<Institution> institutions) throws Exception {
        int size = -1;
        size = institutionService.saveAll(institutions);
        return new ResponseEntity<Integer>(size, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Institution> putSource(@RequestBody Institution institution){
        institution = institutionService.update(institution);
        return new ResponseEntity<Institution>(institution, new HttpHeaders(), HttpStatus.OK);
    }
}
