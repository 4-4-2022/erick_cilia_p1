# FBI Monster API
The FBI Monster API allows users to get data from monsters around the world. This include descriptions, sightings, and number of attacks. The user is also able to create monsters, set their properties such as name, description and abilities. On top of that, the user is able to delete monsters by name. The API allows creation for sightings, the number of witnesses and the location. As well as the number of attacks which include the name of the monster, the location of attack, and the number of victims. They all have functionalities for GET, PUT, POST, DELETE. 

## Technologies Used
- Java
- Spring Framework
- Spring Data JPA
- GIT SCM
- REST
- SOAP
- Spring Transactions (JTA)
- Logback

## Getting Started
- http://localhost:8081/monsters/ (for monster data)
- http://localhost:8081/sightings/ (for sighting data)
- http://localhost:8081/attacks/ (for attack data)

## Usage
- GET  /monsters/all - gets all monsters
- GET /monsters/{monsterName} - get by specific monster name
- POST /monsters/new/{monsterName} - create monster info by name
- DELETE /monsters/{monsterName} - delete monster by name
- GET /sightings/all - get all monster sightings
- POST /sightings/new/{monsterName} - create new sighting
- GET /sightings/{monsterName} - get sighting by monster name
