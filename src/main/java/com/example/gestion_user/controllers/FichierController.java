package com.example.gestion_user.controllers;

import com.example.gestion_user.entities.Fichier;
import com.example.gestion_user.servicesImpl.FichierServicesImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/Fichier")
public class FichierController {

    @Autowired
    FichierServicesImpl fichierServicesIpml ;

    @PostMapping("/add-fichier")
    public Fichier addFichier(@RequestBody Fichier f){
        Fichier fichier = fichierServicesIpml.addFichier(f);
        return fichier ;
    }



}
