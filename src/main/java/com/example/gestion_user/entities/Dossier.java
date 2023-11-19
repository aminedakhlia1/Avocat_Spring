package com.example.gestion_user.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Dossier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDossier")
  private Integer idDossier ;
  private Date dateCreation ;
  private String nom ;
  private String description ;
 // attribut => type + refrence
    @JsonIgnore
  @ManyToOne(cascade = CascadeType.ALL)
    private Affaire affaire ;
    @JsonIgnore
  @OneToOne(mappedBy="dossier", cascade = CascadeType.ALL)
    private Fichier fichier ;


}
