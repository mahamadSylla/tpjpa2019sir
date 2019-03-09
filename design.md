# Architecture du projet
Pour respecter certaines r�gles de bonne pratique de la programmation, nous avons adopt� une architecture avec trois couches : 
- une couche DAO pour toutes interactions avec la base de donn�es
- une couche SERVICE pour les services offerts par l'application
- une couche JPA pour contenir nos classes m�tier
Chaque couche, � part la couche JPA, comporte deux packages, un pour les interfaces et l'autre pour les implementations de ces interfaces.  </br> Ainsi nous avons les packages suivants :
- daoImpl
- daoInterfaces
- Services
- ServicesImpl
Chaque service contient une annotation du genre @Path("/nomServices") qui tombe directement sur un GET des objets du dit service en format JSON

## Quelques grands points de la mod�lisation et du mapping
- La classe Utilisateur est reli�e � la classe :
	- Sondage par un OneToMany qui permet de retrouver les sondages cr�es par un utilisateur
	- Alergies par un @OneToMany qui permet de retrouver les alergies d'un utilisateur
	- R�le par un OneToMany, un utilisateur peut avoir plusieurs (participant, cr�ateur)
	- R�union par un @ManyToMany avec @JoinTable(name="les_presences") qui pemet de retrouver les reunoins assist�es par un utilisateur, 
	l'annotation @JsonManagedReference(value = "utilisateur_present") pour �viter � jersey de faire une boucle infinie entre utilisateur et r�union
	@ManyToMany </br>
	@JoinTable(name = "les_absences", joinColumns = @JoinColumn (name="utilisateur_id"), inverseJoinColumns = @JoinColumn (name="reunion_id")) </br>
	@JsonManagedReference(value = "utilisateur_absent") : pemet de retrouver les reunoins manqu�es par un utilisateur. </br>
_ Vu qu'on peut avoir une r�union sans une passe, nous avons d�cid� de faire une cl� composite qui permet de sauvegarder les pr�ferences alimentaires
 d'un participant � une r�union si le d�but de la dite r�union est compris entre 12h et 14h.
- La classe *sondage*, elle n'est pas reli�e directement � celle de l'utilisateur si ce n'est par le biais du cr�ateur. Elle est reli�e aux participants par la
classe ReponseSondage qui contient l'id du participant et celui du sondage avec une liste de chois de date qui illustre ses choix. 
- La classe MailSender permet d'envoyer des mails aux participants
- La classe Role pour distatcher les r�les entre les utilisateur


