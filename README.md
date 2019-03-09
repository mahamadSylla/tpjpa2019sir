# Prise de RDV type doodle </br>
Auteurs : Linda YAO, Mahamadou SYLLA</br>
## Présentation</br>
Cette application permet de créer un Doodle, c'est-à-dire donner la posibilité à un utilisateur de créer un système de sondage pour pouvoir planifier une 
réunion au sein d'un organisme. Ainsi, l'application dispose deux genres d'utilisateur, les créateurs et les participants au sondage. Un utilisateur est identifié par 
son mail unique, son nom et son prénom. Quand les utilisateur participent à un sondage, à travers leur réponse on saura distinguer les présents et les absents. Un sondage 
contient une liste de reponses données par les participants qui est un ensemble de plage d'horaire, une liste de choix de date parmi laquelle les participants font leur choix, après la participation de tous les
utilisateurs au sondage, le créateur choisira une date qui sera retenue pour la réunion. Une réunion est identifié par un resumé, un intitulé, une liste de
de présents et d'absents et un sondage qui a été fait pour planifier la réunion. 
## Fonctionnalités supportées 
- Créer un utilisateur, un sondage et une réunion 
- Ajouter un rôle à un utilisateur, une préference alimentaire d'un utilisateur
- Avoir la liste de présences et d'absences d'une réunion, de réponses à un sondage ou d'un utilisateur, des alergies et les sondages participés par un utilisateur
- Avoir la liste des réunions, utilisateurs et sondages
- Valider une date d'une réunion
## Fonctionnalités à développer	
- Envoyer le mail au participant, la fonction est implémentée mais non vérifiée 
- Integration d'un PAD
## Lancement de l'application
Pour exécuter l'application il faut : </br>
1- un serveur smtp : fake SMPT, on peut avoir le zar ici : http://nilhcem.com/FakeSMTP/download.html </br>
1- faire un back up du fichier sql de la base de données : jpa.sql</br>
2- Lancer le conteneur web tomcat : mvn tomcat7:run ou importer et lancer à l'aide d'un IDE(projet maven) </br>
### Information complementaire  
- Le fichier postman se trouve à la racine pour simplifier la vérification des REST : SIR requests REST.postman_collection.json
- Le dossier Documentation contient quelques illustrations (en image) pour mieux comprendre l'architecture de l'application
## Technologies
Java, Jersey, MyQSL, Tomcat, Hibernate, JPA



