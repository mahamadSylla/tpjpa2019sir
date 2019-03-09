# Architecture du projet
Pour respecter certaines régles de bonne pratique de la programmation, nous avons adopté une architecture avec trois couches : 
- une couche DAO pour toutes interactions avec la base de données
- une couche SERVICE pour les services offerts par l'application
- une couche JPA pour contenir nos classes métier
Chaque couche, à part la couche JPA, comporte deux packages, un pour les interfaces et l'autre pour les implementations de ces interfaces.  </br> Ainsi nous avons les packages suivants :
- daoImpl
- daoInterfaces
- Services
- ServicesImpl
Chaque service contient une annotation du genre @Path("/nomServices") qui tombe directement sur un GET des objets du dit service en format JSON

## Quelques grands points de la modélisation et du mapping
- La classe Utilisateur est reliée à la classe :
	- Sondage par un OneToMany qui permet de retrouver les sondages crées par un utilisateur
	- Alergies par un @OneToMany qui permet de retrouver les alergies d'un utilisateur
	- Rôle par un OneToMany, un utilisateur peut avoir plusieurs (participant, créateur)
	- Réunion par un @ManyToMany avec @JoinTable(name="les_presences") qui pemet de retrouver les reunoins assistées par un utilisateur, 
	l'annotation @JsonManagedReference(value = "utilisateur_present") pour éviter à jersey de faire une boucle infinie entre utilisateur et réunion
	@ManyToMany </br>
	@JoinTable(name = "les_absences", joinColumns = @JoinColumn (name="utilisateur_id"), inverseJoinColumns = @JoinColumn (name="reunion_id")) </br>
	@JsonManagedReference(value = "utilisateur_absent") : pemet de retrouver les reunoins manquées par un utilisateur. </br>
_ Vu qu'on peut avoir une réunion sans une passe, nous avons décidé de faire une clé composite qui permet de sauvegarder les préferences alimentaires
 d'un participant à une réunion si le début de la dite réunion est compris entre 12h et 14h.
- La classe *sondage*, elle n'est pas reliée directement à celle de l'utilisateur si ce n'est par le biais du créateur. Elle est reliée aux participants par la
classe ReponseSondage qui contient l'id du participant et celui du sondage avec une liste de chois de date qui illustre ses choix. 
- La classe MailSender permet d'envoyer des mails aux participants
- La classe Role pour distatcher les rôles entre les utilisateur


