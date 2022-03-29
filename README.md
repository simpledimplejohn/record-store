# Record Store server

Record store server provides the back end server and database connection for a Record Store.  This is a demo project that explores nested many to many relationships across a database and how to turn those into api endpoints.  This uses the PostgreSQL open database Record-Store as its template with Customers purchasing Albums, that have Tracks, with Artists, and Generas--these were turned into models.

# Front End Repository

The front-end for this application has been written in Angular and can be found at this link:
_[FRONT END](https://github.com/simpledimplejohn/record-store-front-end)_

## Tech Stack

This web app was developed using : 
  * Java, Junit , Mockito, Log4J , Maven .
  * PostgreSQL, Spring Data, Spring MVC, Spring Boot.
  * Angular 2+, TypeScript, JavaScript, Bootstrap , HTML , CSS.
  * AWS EC2, AWS RDS,  AWS CodePipeline, AWS S3, Docker.
  * REST,  Sonarcloud, Agile-Scrum. 



## User stories

As a user I can : 

- Register 
- Login
- Search for Albums
- Select albums and view tracks
- Add Albums
- Add any number of tracks to an album


## API Documentation

| Route                                                               | Method | Status Code | Description                                                         |
| ------------------------------------------------------------------- | ------ | ----------- | ------------------------------------------------------------------- |
| /customers                                                          | GET    | 200         | Returns a list of all customers                                     |
| /customers/:id                                                      | GET    | 200         | Returns a the user with the id                                      |
| /customers/add                                                      | POST   | 201         | Creates a new user                                                  |
| /customers/find/{username}                                          | POST   | 200         | find a user by username                                             |
| /customers/:id                                                      | DELETE | 200         | Delete the user for the given ID                                    |
| /customers/{id}/addCart                                             | PUT    | 201         | add cart to user                                                    |
| /customers/{id}/addAlbumToCart/{id}                                 | PUT    | 201         | Add an album to a users cart                                        |            
| /customers/{userId}/memory/{memoryId}                               | GET    | 200         | get memory with given ID for a user  with given user id             |         
| /customers/{userId}/memory/{memoryId}                               | Delete | 204         | delete memory with given ID for a user  with given user id          | 
| /album/find/{albumName}                                             | GET    |   200       |  finds album by album name                                          |
| /album/findAlbumTrack/{id}                                          | GET    |   200       |  finds a track on the album by id                                   |
| /album/{id}                                                         | GET    |   200       |  finds an album by id                                               |
| /album/add                                                          | POST   |   201       |  adds an album                                                      |
| /album/{id}/addtrack                                                | PUT    |   201       |  adds a track to an album by album id                               |
| /album/{id}/addtracks                                               | PUT    |   201       |  adds a track list to an existing album                             |
| /track/find{title}                                                  | GET    |   200       |  gets a track by track name                                         |    
| /cart/                                                              | GET    |   200       |  Returns a list of all carts                                        |   
| /cart/{id}                                                          | GET    |   200       |  Returns a cart by its id                                           |
| /cart/add                                                           | POST   |   200       |  Adds a cart                                                        |



## Setup/Installation

* _Download repo from github_
* _In the root folder run the command line command `mvn clean install`_
* _Run the mavin file_
* _Access on localhost://5000_

## Known Bugs and Future Changes

* _Fix Cores Errors, add cores filter_
* _Add validation to models_
* _Add DTO's for increased security_
* _Fix SonarCloud github actions_

## License

_[MIT](https://opensource.org/licenses/MIT)_

_Copyright (c) 2022 John Blalock_

## Github Pages Link

[Portfolio](https://simpledimplejohn.github.io/Career-Quiz/)

## Contact Information

_simpledimplejohn@gmail.com_