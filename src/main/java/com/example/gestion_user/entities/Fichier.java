package com.example.gestion_user.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Fichier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFichier")

    private Integer idFichier ;

    private String nameFile;

    private String path;

    @JsonIgnore
    @OneToOne()
    private Dossier dossier ;

    public Fichier(String nameFile) {
        this.nameFile = nameFile;
    }

}
