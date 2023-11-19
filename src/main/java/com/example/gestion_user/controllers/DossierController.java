package com.example.gestion_user.controllers;

import com.example.gestion_user.entities.Dossier;
import com.example.gestion_user.services.DossierService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Dossier")
public class DossierController {

    @Autowired
    DossierService dossierService ;
    @GetMapping("/retrieve-all-dossiers")
    public List<Dossier> getDossier() {
        List<Dossier> listDossiers = dossierService.retrieveAllDossiers();
        return listDossiers;
    }

    @GetMapping("/retrieve-dossier/{dossier-id}")
    public Dossier retrieveDossier(@PathVariable("dossier-id") Integer dossierId){
        return dossierService.retrieveDossier(dossierId);
    }
    @PostMapping("/add-dossier")
    public Dossier addDossier(@RequestBody Dossier d){
        Dossier dossier = dossierService.addDossier(d);
        return dossier ;
    }

    @PutMapping("/update-dossier")
    public Dossier updateDossier(@RequestBody Dossier d){
        Dossier dossier = dossierService.updateDossier(d);
        return dossier ;
    }

    @DeleteMapping("/remove-dossier/{dossier-id}")
    public void removeDossier(@PathVariable("dossier-id")Integer dossierId) {
        dossierService.removeDossier(dossierId);
    }

    @PostMapping("/addDossierAndAffectToAffaire/{affaire-id}")
    public void addDossierAndAffectToAffaire (@RequestBody Dossier dossier ,@PathVariable("affaire-id") Integer idAffaire ){
        dossierService.addDossierAndAffectToAffaire(dossier, idAffaire);

    }

    @PostMapping(value = "/addDossierWithFileAndAssignToAffaire/{idAffaire}", consumes = {"multipart/form-data"})
    public ResponseEntity<Dossier> addDossierWithFileAndAssignToAffaire(@PathVariable("idAffaire") Integer idAffaire,
                                                                        @Valid @RequestParam("dossier") String dossierJson,
                                                                        @RequestParam("fichier") MultipartFile fichier ) {

        //Convertir JSON string un objet
        ObjectMapper objectMapper = new ObjectMapper();
        Dossier dossier = null;
        try {
            dossier = objectMapper.readValue(dossierJson, Dossier.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Dossier savedDossier = dossierService.addDossierWithFileAndAssignToAffaire(dossier, idAffaire, fichier);
        return new ResponseEntity<>(savedDossier, HttpStatus.CREATED);
    }
}
