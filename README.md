# SpringBootCrudFinal
A simple crud using Springboot 
 
 
Aplicación utilizando Spring Boot, MySQL


## Requirements

1. Java - 1.8.x
2. Maven - 3.x.x
3. Mysql - 5.x.x

## SETUP

**1. Clone

```bash
git clone https://github.com/yelken/springboot-crud.git
```

**2. BD MySQL**
```bash
create database test_app
```

**3. Modify the user and sign according to your installation**

+ open `src/main/resources/application.properties`

+ modify `spring.datasource.username` e `spring.datasource.password` de acordo com sua instalação

**4. Build**

```bash
mvn package
```

The application will run at <http://localhost:8080>.
