
package com.urgeo.geocollab.controller;

import com.urgeo.geocollab.model.Dossier;
import com.urgeo.geocollab.service.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dossiers")
public class DossierCtrl {

    @Autowired
    DossierService dossierService;

    @GetMapping("/{id}")
    public ResponseEntity<Dossier> getDossier(@PathVariable("id") Long id){
        Dossier src = dossierService.getDossierById(id);
        return new ResponseEntity<Dossier>(src, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Dossier>> getAllDossiers(){
        List<Dossier> dossiers = dossierService.getAllDossiers();
        return new ResponseEntity<List<Dossier>>(dossiers, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Dossier> postDossier(@RequestBody Dossier dossier){
        Dossier src = dossierService.create(dossier);
        return new ResponseEntity<Dossier>(src, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/saveall")
    public ResponseEntity<Integer> saveAll(@RequestBody List<Dossier> dossiers) throws Exception {
        int size = -1;
        size = dossierService.saveAll(dossiers);
        return new ResponseEntity<Integer>(size, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Dossier> putDossier(@RequestBody Dossier dossier){
        Dossier src = dossierService.update(dossier);
        return new ResponseEntity<Dossier>(src, new HttpHeaders(), HttpStatus.OK);
    }
}
