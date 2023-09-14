## About the project

Simple API for the creation of medical appointments. The frontend side is in [Citas_Medicas_Angular](https://github.com/JuananMtez/Citas_Medicas_Angular).

### Built With
![Java]

## Getting Started

### Prerequisites
* Java 1.8 or superior
* Oracle Database XE
* Eclipse IDE for Java Developers


### Installation
1. Clone the repo.
```sh
https://github.com/JuananMtez/Medical_Appointments_SpringBoot.git
```

2. Create database in Oracle Database XE.

3. Open the project with Eclipse IDE for Java Developers.

4. Install maven dependencies. 


## Usage

Run ``./demo/src/main/java/um/practicas/metaenlace/SpringBootJpaApplication.java`` with Eclipse.


## Aditional information

You can change the DBMS in ``./demo/src/main/resources/application.properties``.
```properties
spring.datasource.url=jdbc:INSERT DBMS CONNECTION
spring.datasource.username=system
spring.datasource.password=admin

spring.datasource.driver-class-name=INSERT DBMS DRIVER
spring.datasource.platform=INSERT DBMS

spring.jpa.show-sql=true

spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.generate-ddl=false
spring.datasource.initialization-mode=always

```




## Author

* **Juan Antonio Martínez López** - [Website](https://juananmtez.github.io/) - [LinkedIn](https://www.linkedin.com/in/juanantonio-martinez/)


## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

[Java]: https://img.shields.io/badge/java-20232A?style=for-the-badge&logo=openjdk
