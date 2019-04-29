CREATE DATABASE BaseTapas;

USE BaseTapas;

create table Groupe (
	idGroupe int(11) NOT NULL auto_increment, 
	numeroTable int(11),
	primary key (idGroupe)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table Client (
	idClient int(11) NOT NULL auto_increment,
	idClientGroupe int(11) NOT NULL,
	pseudo varchar(64), 
	couleur varchar(64),
	idGroupe int(11),
	primary key (idClient)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table Choix_Client (
	idChoix int(11) NOT NULL auto_increment,
	idTapas int(11),
	idClient int(11),
	idCommande int(11),
	primary key(idChoix)
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
	idCategorie int(11),
	primary key (idTapas)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

alter table Client
add constraint Client_idGroupe
foreign key (idGroupe)
references Groupe (idGroupe);

alter table Tapas
add constraint Tapas_idCategorie
foreign key (idCategorie)
references Categorie (idCategorie);

alter table Choix_Client
add constraint Choix_Client_idTapas
foreign key (idTapas)
references Tapas (idTapas);

alter table Choix_Client
add constraint Choix_Client_idCommande
foreign key (idCommande)
references Commande (idCommande);

alter table Choix_Client
add constraint Choix_Client_idClient
foreign key (idClient)
references Client (idClient);


INSERT INTO Commande (dateCommande) VALUES
("2018-07-26"),
("2018-07-26"),
("2018-07-26"),
("2018-07-26"),
("2018-07-26"),
("2018-07-26"),
("2018-07-26"),
("2018-07-26"),
("2018-07-26"),
("2018-07-26"),
("2018-07-26"),
("2018-07-26");

INSERT INTO Categorie (libelle) VALUES
("Poulettito"),
("Legumes de mer"),
("Boeufounnet"),
("Dragonnet"),
("Viande Humaine"),
("Vegan");

INSERT INTO Tapas (nom, couleur, idCategorie) VALUES
("Eau de Source","",2),
("Aile avec Plumes","",1),
("Ongles sous marins","",2),
("Flammes très chaudes","",4),
("Cornes de vachon","",3),
("Griffes qui griffent","",4),
("Doigt de iep","",5),
("Champignon non toxique","",6);