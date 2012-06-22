Lambda-calcul
=============

Principe g&eacute;n&eacute;ral
------------------------------
Le &lambda;-calcul est un syst&egrave;me permettant de formaliser le concept
de _fonction_ et d'_application_.  
Dans ce formalisme, tout est fonction, et toute fonction non
encore d&eacute;finie peut &ecirc;tre remplac&eacute;e par une variable.

Syntaxe
-------

### D&eacute;finition d'un lambda-terme

Un terme peut &ecirc;tre d&eacute;fini en tant que : 

* variable de la forme : x
* abstraction (ou fonction) de la forme : (&lambda;x . u)
* application de la forme : (u v)

Dans chacune de ces d&eacute;finitions "x" repr&eacute;sente une
variable, "u" et "v" repr&eacute;sentent des termes.


### D&eacute;finition d'une abstraction

Une abstraction est d&eacute;finie de la fa&ccedil;on suivante :
> (&lambda;x . u)

ou "x" est une variable et "u" un terme.

Cette abstraction d&eacute;finie une fonction prenant "x" en argument
et retournant le terme "u".  
__Concept important :__ Les abstractions en &lambda;-calcul n'acceptent qu'un seul argument.


### D&eacute;finition d'une application

Une application est d&eacute;finie de la fa&ccedil;on suivante :
> (u v)

ou "u" et "v" sont des termes.


### Parenth&eacute;sage

En &lambda;-calcul, on &eacute;vite autant que possible d'&eacute;crire les parenth&egrave;ses.

Une application a une priorit&eacute; sup&eacute;rieure &agrave; une abstraction :
> (&lambda;x . u v) <=> (&lambda;x . (u v))

L'abstraction de droite a une priorit&eacute; sup&eacute;rieure &agrave; l'abstraction de gauche : 
> (&lambda;x . &lambda;y . x) <=> (&lambda;x . (&lambda;y . x))
