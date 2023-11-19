package com.example.gestion_user.services;

import com.example.gestion_user.entities.Dossier;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

public interface DossierService {

    Dossier addDossier (Dossier dossier) ;

    List<Dossier> retrieveAllDossiers() ;

    Dossier updateDossier (Dossier dossier) ;

    void removeDossier (Integer idDossier) ;

    Dossier retrieveDossier (Integer idDossier);

    void addDossierAndAffectToAffaire (Dossier dossier , Integer idAffaire ) ;

    public Dossier addDossierWithFileAndAssignToAffaire(Dossier dossier, Integer idAffaire,
                                                          MultipartFile multipartFile);

}
