# Projet j2ee
Ce projet a pour but d'implémenter un jeu de dé, "le Cul de Chouette", basé sur la série Kaamelott.

# Principe général
Le Cul de Chouette se joue avec 3 dés à 6 faces et un maximum de 6 joueurs. Le joueur gagnant est celui qui atteint ou dépasse le premier le score de 343. Chaque joueur joue à tour de rôle et marque des points en fonction des combinaisons de son lancer de 3 dés. Certaines combinaisons impliquent une interaction entre les joueurs qui déterminera les points gagnés ou perdus.

Un joueur lance une partie en invitant un ou plusieurs autres joueurs et en précisant l'ordre de jeu de chacun. C'est le joueur qui a lancé la partie qui commence à jouer.

# Combinaisons
Les dés se lancent en 2 fois : d'abord 2 dés puis le troisième. Le jet des 2 premiers dés est appelé la chouette et le troisième dé est appelé le cul.

Les combinaisons sans interaction :

La velute : la somme des dés de la chouette donne la valeur du cul. Exemple : (1,3) avec 4. Les points marqués par le joueur sont le carré de la velute. Dans l'exemple précédent, la velute est de 4, donc 16 points sont marqués.
La chouette : les deux dés de la chouette sont identiques. Exemple : (5,5). Les points marqués sont le carré de cette valeur identique, soit 25 pour l'exemple.
Le cul de chouette : les trois dés sont identiques. 50 points sont marqués pour un cul de chouette de 1, 60 pour un de 2, 70 pour un de 3, 80 pour un de 4, 90 pour un de 5 et 100 pour un de 6.
Les combinaisons avec interaction :

La suite : toute combinaison de 3 dés donnant 3 valeurs consécutives (1,2,3), (3,4,5) ... En cas de suite, chaque joueur doit crier "Grelotte ça picote !". Le dernier joueur à le faire perd 10 points.
La chouette velute : il s'agit d'une chouette qui avec le cul donne une velute, ce qui est le cas pour les 3 combinaisons (1,1) avec 2, (2,2) avec 4 et (3,3) avec 6. Dans ce cas, chaque joueur doit crier "Pas mou le caillou !". Le premier à crier gagne les points de la velute.

# Gestion des comptes joueur
Chaque joueur peut se créer un compte en précisant ses informations personnelles : pseudo, mot de passe, age, sexe et ville. A l'exception du pseudo, les autres champs peuvent être modifiés.

# Interface de jeu
Chaque joueur se connecte avec son pseudo et mot de passe. La page affiche la liste des joueurs actuellement connectés avec un rafraichissement régulier.

Un joueur lance une partie en sélectionnant un ou plusieurs joueurs dans la liste. S'il y en a plusieurs, il doit être possible de préciser l'ordre des joueurs. Pour raccourcir les parties, il pourra aussi changer la valeur de 343 de fin de partie.

Chaque joueur sélectionné reçoit une invitation et l'accepte ou la refuse. Une fois que tout le monde a répondu, le jeu démarre.

Quand c'est à son tour de jouer, un joueur lance les dés en deux fois et marque des points comme précisé dans les règles.

Quand ce n'est pas le tour d'un joueur, celui-ci voit sur sa page ce qu'il se passe chez celui qui joue.

Les combinaisons avec interaction sont gérées par des boutons permettant d'envoyer le bon message.

A chaque tour, tout le monde est informé de qui a marqué combien de points et les scores de chaque joueur sont visibles.

# Statistiques
Un ensemble d'informations devront être disponibles :

La liste des joueurs enregistrés.
Des informations sur sur chaque joueur : en plus des informations personnelles, on précisera le nombre de parties jouées, le nombre de victoires, le nombre moyen de victoires, le score moyen, la moyenne des suites gagnées et des chouettes velues perdues.
Le résultat de chaque partie pourra être consulté : liste des joueurs avec leurs points, le nombre de suites gagnées et de chouettes velues perdues.
