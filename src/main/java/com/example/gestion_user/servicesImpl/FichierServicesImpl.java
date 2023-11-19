package com.example.gestion_user.servicesImpl;

import com.example.gestion_user.entities.Fichier;
import com.example.gestion_user.repositories.FichierRepository;
import com.example.gestion_user.services.FichierService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FichierServicesImpl implements FichierService {

    @Autowired
    FichierRepository fichierRepository ;

    @Override
    public Fichier addFichier(Fichier fichier) {
        return fichierRepository.save(fichier);
    }
}
