package com.example.gestion_user.repositories;

import com.example.gestion_user.entities.Fichier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichierRepository extends JpaRepository<Fichier, Integer> {
}
