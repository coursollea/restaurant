create table Client (
ID int(11) auto_increment,
pseudo varchar (55), 
couleur varchar (55),
idGroupe int, 
primary key (ID)
);

create table Choix_Client (
ID int(11) auto_increment, 
idClient int, 
primary key (ID)
);

create table Groupe (
ID int(11) auto_increment, 
numeroTable int, 
primary key (ID)
);

create table Commande (
ID int(11) auto_increment,
dateCommande date, 
idGroupe int, 
primary key (ID)
);

create table Categorie (
ID int(11) auto_increment,
libelle varchar(55), 
primary key (ID)
);

create table Appartenir (
ID int(11) auto_increment,
idCategorie int,
idTapas int,
primary key (ID)
);

create table Tapas (
ID int(11) auto_increment,
nom varchar(55),  
primary key (ID)
);

create table Contient (
ID int(11) auto_increment,
quantite int, 
idTapas int,
idChoix_Client int,
primary key (ID)
);

alter table Client
add constraint Client_idGroupe
foreign key (idGroupe)
references Groupe(ID);

alter table Choix_Client
add constraint Choix_Client_idClient
foreign key (idClient)
references Client (ID);

alter table Commande
add constraint Commande_idGroupe
foreign key (idGroupe)
references Groupe (ID);

alter table Appartenir
add constraint Appartenir_idCategorie
foreign key (idCategorie)
references Categorie (ID);

alter table Appartenir
add constraint Appartenir_idTapas
foreign key (idTapas)
references Tapas (ID); 

alter table Contient
add constraint Contient_idTapas
foreign key (idTapas)
references Tapas (ID); 

alter table Contient
add constraint Contient_idChoix_Client
foreign key (idChoix_Client)
references Choix_Client (ID); 
 

