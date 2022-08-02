# Évaluation foncière d'un Terrain


Ce logiciel vous permettra de calculer la valeur foncière d'un terrain ayant au moins un lot.


## Description

Ce programme prend en argument un fichier d'entrée JSON avec [cette syntaxe spécifique](https://drive.google.com/file/d/1oR08MncoI7gVTLPlDQAI6oTPiaHfA27Q/view?usp=sharing) . Ce fichier JSON devra contenir les informations nécessaires sur chacun des lots  que contient le terrain, afin de pouvoir calculer leurs valeurs  respectives et d'en déduire la valeur foncière du Terrain. Un fichier de sortie JSON contenant toutes les informations de calcul sera généré à la fin de l'éxécution du programme.

## Pour commencer

### Dépendances

* Java
* Librairie JSON-lib

### Installation

* Exportez le projet depuis la branche Master du dépôt git
* Ouvrez avec l'IDE de votre choix, et faites "Build project" pour générer le .jar du projet.

### Exécution du  programme

* Exécuter la commande suivante  pour rouler le programmme
 java -jar Projet.jar entree.json sortie.json

* Vous devrez spécifier le chemin complet dans lequel se trouve votre .jar et votre fichier d'entrée JSON
```
```

## Aide

Pour toute aide supplémentaire reliée à l'utilisation de ce logiciel, veuillez contacter 
l'un des auteurs mentionnés ci-dessus
```
```

## Auteurs



* **Achou Henri Joël** _alias_ https://github.com/Akaffou-Achou-Henri-Joel
* **Aurélien Tcheuffa Kemayou** _alias_ https://github.com/kemayou
* **Elza Meguieng Tiemghen** _alias_ https://github.com/meguieng
* **Jordan Mone** _alias_ https://github.com/mtljason322

## Version

* Sprint 3.0
    * Section Observation ajoutée : contient des détails sur les anomalies que peuvent présenter le fichier d'entrée
    * Arrondissement au dixième près
    * Rapport statistique en format txt généré à la fin de chaque exécution du programme
* Sprint 2.0
    * Gestion de plusieurs exceptions, reglant ici certains bugs mineurs
    * Refactoring effectué pour respecter les conventions et Normes de programmation
* Sprint 1.0
    * Sortie initiale

## License

Ce logiciel est autorisé sous la licence [INF2050 E22]  - Pour plus de détails, consultez sa licence [LICENCE.MD](https://github.com/INF2015-H16/INF2050-E22-EQUIPE2/blob/master/LICENSE.MD)
