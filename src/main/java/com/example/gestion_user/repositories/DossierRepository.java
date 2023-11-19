package com.example.gestion_user.repositories;

import com.example.gestion_user.entities.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DossierRepository extends JpaRepository<Dossier, Integer > {
}
