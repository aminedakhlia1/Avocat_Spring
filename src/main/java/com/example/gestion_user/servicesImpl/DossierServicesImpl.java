package com.example.gestion_user.servicesImpl;

import com.example.gestion_user.entities.Affaire;
import com.example.gestion_user.entities.Dossier;
import com.example.gestion_user.entities.Fichier;
import com.example.gestion_user.repositories.AffaireRepository;
import com.example.gestion_user.repositories.DossierRepository;
import com.example.gestion_user.repositories.FichierRepository;
import com.example.gestion_user.services.DossierService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
@AllArgsConstructor
@Service
public class DossierServicesImpl implements DossierService {

    @Autowired
    DossierRepository dossierRepository;
    @Autowired
    AffaireRepository affaireRepository;
    @Autowired
    FichierRepository fichierRepository;

    @Override
    public Dossier addDossier(Dossier dossier) {
        return dossierRepository.save(dossier) ;
    }

    @Override
    public List<Dossier> retrieveAllDossiers() {
        return dossierRepository.findAll() ;
    }

    @Override
    public Dossier updateDossier(Dossier dossier) {
        return dossierRepository.save(dossier);
    }

    @Override
    public void removeDossier(Integer idDossier) {
        dossierRepository.deleteById(idDossier);

    }

    @Override
    public Dossier retrieveDossier(Integer idDossier) {
        return dossierRepository.findById(idDossier).get();
    }

    @Override
    public void addDossierAndAffectToAffaire(Dossier dossier, Integer idAffaire) {
        Affaire affaire = affaireRepository.findById(idAffaire).orElse(null);
        dossier.setAffaire(affaire);
        dossierRepository.save(dossier);

    }


    @Override
    public Dossier addDossierWithFileAndAssignToAffaire(Dossier dossier, Integer idAffaire,
                                                                MultipartFile multipartFile){
        Affaire affaire = affaireRepository.findById(idAffaire).orElse(null);
        dossier.setAffaire(affaire);

        Dossier savedDossier = dossierRepository.save(dossier);

        //Save file
        Fichier fichier = new Fichier();
        fichier.setNameFile(multipartFile.getOriginalFilename());
        fichier.setPath("/uploadsFiles/" + fichier.getNameFile());
        fichier.setDossier(savedDossier);
        Fichier savedFile = fichierRepository.save(fichier);

        //Affecter dossier à file
        savedDossier.setFichier(savedFile);
        dossierRepository.save(savedDossier);
        return savedDossier;
    }
}
