# Prise de RDV type doodle </br>
Auteurs : Linda YAO, Mahamadou SYLLA</br>
## Pr�sentation</br>
Cette application permet de cr�er un Doodle, c'est-�-dire donner la posibilit� � un utilisateur de cr�er un syst�me de sondage pour pouvoir planifier une 
r�union au sein d'un organisme. Ainsi, l'application dispose deux genres d'utilisateur, les cr�ateurs et les participants au sondage. Un utilisateur est identifi� par 
son mail unique, son nom et son pr�nom. Quand les utilisateur participent � un sondage, � travers leur r�ponse on saura distinguer les pr�sents et les absents. Un sondage 
contient une liste de reponses donn�es par les participants qui est un ensemble de plage d'horaire, une liste de choix de date parmi laquelle les participants font leur choix, apr�s la participation de tous les
utilisateurs au sondage, le cr�ateur choisira une date qui sera retenue pour la r�union. Une r�union est identifi� par un resum�, un intitul�, une liste de
de pr�sents et d'absents et un sondage qui a �t� fait pour planifier la r�union. 
## Fonctionnalit�s support�es 
- Cr�er un utilisateur, un sondage et une r�union 
- Ajouter un r�le � un utilisateur, une pr�ference alimentaire d'un utilisateur
- Avoir la liste de pr�sences et d'absences d'une r�union, de r�ponses � un sondage ou d'un utilisateur, des alergies et les sondages particip�s par un utilisateur
- Avoir la liste des r�unions, utilisateurs et sondages
- Valider une date d'une r�union
## Fonctionnalit�s � d�velopper	
- Envoyer le mail au participant, la fonction est impl�ment�e mais non v�rifi�e 
- Integration d'un PAD
## Lancement de l'application
Pour ex�cuter l'application il faut : </br>
1- un serveur smtp : fake SMPT, on peut avoir le zar ici : http://nilhcem.com/FakeSMTP/download.html </br>
1- faire un back up du fichier sql de la base de donn�es : jpa.sql</br>
2- Lancer le conteneur web tomcat : mvn tomcat7:run ou importer et lancer � l'aide d'un IDE(projet maven) </br>
### Information complementaire  
- Le fichier postman se trouve � la racine pour simplifier la v�rification des REST : SIR requests REST.postman_collection.json
- Le dossier Documentation contient quelques illustrations (en image) pour mieux comprendre l'architecture de l'application
## Technologies
Java, Jersey, MyQSL, Tomcat, Hibernate, JPA



