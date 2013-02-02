Lambda-calcul
=============

Principe g&eacute;n&eacute;ral
------------------------------
Le &lambda;-calcul est un syst&egrave;me permettant de formaliser le
concept de fonction et d'application.  
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
et retournant le terme "u" : f(x) = u.  
__Concept important :__ Les abstractions en &lambda;-calcul
n'acceptent qu'un seul argument.


### D&eacute;finition d'une application

Une application est d&eacute;finie de la fa&ccedil;on suivante :
> (u v)

ou "u" et "v" sont des termes.

Dans cette expression le terme "u" est appliqu&eacute; &agrave; la
valeur "v".  
Exemple pour u = (&lambda;x .x) et v = 2 : ((&lambda;x . x) 2) = 2


### Parenth&eacute;sage

En &lambda;-calcul, on &eacute;vite autant que possible
d'&eacute;crire les parenth&egrave;ses.

Une application a une priorit&eacute; sup&eacute;rieure &agrave; une
abstraction :
> (&lambda;x . u v) &hArr; (&lambda;x . (u v))

L'abstraction de droite a une priorit&eacute; sup&eacute;rieure
&agrave; l'abstraction de gauche : 
> (&lambda;x . &lambda;y . x) &hArr; (&lambda;x . (&lambda;y . x))

### Variables li&eacute;es

La liaison d'une variable s'effectue lors de la d&eacute;claration
d'une abstraction. La variable li&eacute;e est celle qui se trouve
&agrave; c&ocirc;t&eacute; du signe &lambda;. Dans le terme (&lambda;x
. u) la variable "x" est li&eacute;e et cette liaison s'&eacute;tend
sur le terme "u".

#### Renommage d'une variable li&eacute;e

Une variable li&eacute;e peut &ecirc;tre renomm&eacute;e, sans changer
le sens de l'abstraction qui la contient, &agrave; condition
que le nouveau nom n'apparaisse pas d&eacute;j&agrave; dans la port&eacute;e 
de cette abstraction.


### Variables libres

Une variable libre est une variable non li&eacute;e. Dans le terme
(&lambda;y . x y) la variable "x" est libre alors que la variable "y"
est li&eacute;e. Une variable est libre dans un terme lorsque ce terme
contient au moins une occurence libre de cette variable.

#### Substitution d'une variable libre
