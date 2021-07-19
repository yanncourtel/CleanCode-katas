## Iteration 00 
C'est ce qu'on donne au stagiaires: un projet maven, une classe de test avec un TODO.md qui contient les liste des 
taches à réaliser.

## Iteration 01 - Concepts : Nommage, Test minimal

### Mise a jour de la TODO list
Ajouter une nouvelle ligne *Print an integer*

### RED 
* Créer le premier test `car_should_initially_have_4_free_seats`. Mais ne pas donner le nom du test tout de suite aux stagiaires, leur faire trouver qu'on n'a qu'à créer un test reprenant le nom du TODO. L'idée aussi est de commencer par un test très simple.

### GREEN 
* cf. le code

### REFACTOR
* Faire refactorer jusqu'à ce que freeSeats() ait un nom parlant et métier.

## Iteration 02 - Concepts : DRY, Ubiquitous language

### RED
* Créer le test `car_should_have_3_free_seats_after_taking_1_passenger`

### GREEN
* Plusieurs solutions sont possibles: utiliser un simple compteur des passagers (approche "TDD intégriste"), ou partir directement sur une collection de passagers (approche "TDD pragmatique")

### REFACTOR
* La méthode ne doit pas s'appeler `addPassenger`, leur faire remarquer que ce n'est pas ce qu'on dirait oralement.
* `takePassenger(passenger)` n'est pas très joli, car on répète passenger (DRY)


## Iteration 03 - Concepts : Tester aussi les scénarios d'erreur et pas seulement le scénario nominal "happy path", Echouer avec un message parlant avant de faire passer à GREEN

### RED
* Créer le test `car_should_not_take_more_passengers_than_it_has_seats`
* La solution avec annotation d'exception expected n'est pas satisfaisante car on ne sait pas si l'exception est survenue lors du premier ou du second appel à take(passenger)
* Utiliser fail("message clair")
* Bien sommé l'exception genre "success" et mettre un commentaire dans le catch vide pour montrer que ce n'est pas une exception mise sous le tapis

### GREEN
* L'approche compteur est encore viable pour ce test

### REFACTOR


## Iteration 04 - Concepts : eq/hash, ne pas rester avec plein de tests rouges

### RED
* Créer le test `car_should_not_take_same_passengers_twice`
* Si des stagiaires comprennent "le meme passager" au sens de "la même instance", leur faire remarquer que ca ne fonctionne pas pour de passagers serialisés/persistés. Ceci dit il peuvent faire ça dans un premier temps.


### GREEN
* Implémenter eq/hash

### REFACTOR
* Implémenter eq/hash avec Objects pour la concision, ne pas avoir à se préoccuper des null, éviter les calculs de hash dans hashCode, ...
* Préférer un Set à une List car sémantiquement c'est plus logique (même si ici on n'utilise pas la déduplication du Set puisqu'on throw quand on take 2 fois le mm passager)
* Faire constater que ca fail quand on ne met pas hashCode