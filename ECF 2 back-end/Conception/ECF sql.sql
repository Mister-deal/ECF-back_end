CREATE DATABASE IF NOT EXISTS ECF;
USE ECF;

CREATE TABLE etablissement(
   id_e INT PRIMARY KEY auto_increment,
   nom_e VARCHAR(50)
);

CREATE TABLE Departement(
   id_d INT PRIMARY KEY auto_increment,
   nom_d VARCHAR(50),
   id_e INT NOT NULL,
   FOREIGN KEY(id_e) REFERENCES etablissement(id_e)
);

CREATE TABLE Matiere(
   id_m INT PRIMARY KEY auto_increment,
   intitule VARCHAR(150),
   dureeMin INT,
   coeff INT,
   description VARCHAR(200)
);

CREATE TABLE Enseignant(
   matricule_e INT PRIMARY KEY auto_increment,
   nom_e VARCHAR(50),
   age INT,
   prenom_e VARCHAR(50),
   grade VARCHAR(50),
   isResponsable boolean,
   isProfPrincipal boolean,
   id_d INT NOT NULL,
   FOREIGN KEY(id_d) REFERENCES Departement(id_d)
);

CREATE TABLE Classe(
   id_c INT PRIMARY KEY auto_increment,
   nomClasse VARCHAR(50),
   niveau VARCHAR(50),
   matricule_e INT NOT NULL,
   FOREIGN KEY(matricule_e) REFERENCES Enseignant(matricule_e)
);

CREATE TABLE Etudiant(
   id_e INT PRIMARY KEY auto_increment,
   nom_e VARCHAR(50),
   prenom_e VARCHAR(50),
   dateNaissance DATE,
   email_e VARCHAR(50),
   id_c INT NOT NULL,
   FOREIGN KEY(id_c) REFERENCES Classe(id_c)
);

CREATE TABLE note(
   id_n INT PRIMARY KEY auto_increment,
   note INT,
   commentaire VARCHAR(249),
   id_m INT NOT NULL,
   id_e INT NOT NULL,
   FOREIGN KEY(id_m) REFERENCES Matiere(id_m),
   FOREIGN KEY(id_e) REFERENCES Etudiant(id_e)
);

CREATE TABLE emploi_du_temps(
   id_e INT PRIMARY KEY auto_increment,
   dateJour DATETIME,
   id_c INT NOT NULL,
   matricule_e INT NOT NULL,
   id_m INT NOT NULL,
   FOREIGN KEY(id_c) REFERENCES Classe(id_c),
   FOREIGN KEY(matricule_e) REFERENCES Enseignant(matricule_e),
   FOREIGN KEY(id_m) REFERENCES Matiere(id_m)
);

CREATE TABLE enseignant_matière(
   id_m INT,
   matricule_e INT,
   PRIMARY KEY(id_m, matricule_e),
   FOREIGN KEY(id_m) REFERENCES Matiere(id_m),
   FOREIGN KEY(matricule_e) REFERENCES Enseignant(matricule_e)
);
