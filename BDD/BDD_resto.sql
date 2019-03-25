CREATE DATABASE BaseTapas;

USE BaseTapas;

create table Client (
	idClient int(11) NOT NULL auto_increment,
	pseudo varchar(64), 
	couleur varchar(64),
	idGroupe int(11), 
	primary key (idClient)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table Groupe (
	idGroupe int(11) NOT NULL auto_increment, 
	numeroTable int(11),
	idCommande int(11),
	primary key (idGroupe)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table Commande (
	idCommande int(11) NOT NULL auto_increment,
	dateCommande date, 
	primary key (idCommande)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table Categorie (
	idCategorie int(11) NOT NULL auto_increment,
	libelle varchar(64),
	primary key (idCategorie)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table Tapas (
	idTapas int(11) NOT NULL auto_increment,
	nom varchar(64),
	couleur VARCHAR(64),
	idCommande int(11),
	idCategorie int(11),
	primary key (idTapas)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

alter table Client
add constraint Client_idGroupe
foreign key (idGroupe)
references Groupe (idGroupe);

alter table Groupe
add constraint Groupe_idCommande
foreign key (idCommande)
references Commande (idCommande);

alter table Tapas
add constraint Tapas_idCommande
foreign key (idCommande)
references Commande (idCommande);

alter table Tapas
add constraint Tapas_idCategorie
foreign key (idCategorie)
references Categorie (idCategorie);

INSERT INTO Commande (dateCommande) VALUES
("2018-07-26");

INSERT INTO Groupe (numeroTable, idCommande) VALUES
(1,1);

INSERT INTO Client (pseudo, couleur, idGroupe) VALUES
("Eglantine","jaune",1),
("Geraud","vert",1),
("Gedeon","bleu",1),
("Norbert","rouge",1);

INSERT INTO Categorie (libelle) VALUES
("Poulettito"),
("Legumes de mer"),
("Boeufounnet"),
("Dragonnet"),
("Viande Humaine"),
("Vegan");

INSERT INTO Tapas (nom, couleur, idCommande, idCategorie) VALUES
("Eau de Source","",1,2),
("Aile avec Plumes","",1,1),
("Ongles sous marins","",1,2),
("Flammes très chaudes","",1,4),
("Cornes de vachon","",1,3),
("Griffes qui griffent","",1,4),
("Doigt de iep","",1,5),
("Champignon non toxique","",1,6);