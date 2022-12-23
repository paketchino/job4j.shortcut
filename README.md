## Стек технологий:

![java](https://img.shields.io/badge/Java--17-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Rest](https://img.shields.io/badge/Spring_Boot--2.7.0-F2F4F9?style=for-the-badge&logo=spring-boot)
![PostgresSQL](https://img.shields.io/badge/PostgreSQL--42.3.6-316192?style=for-the-badge&logo=postgresql&logoColor=white)

![Liquibase](https://img.shields.io/badge/Liquibase-4.17.2-red)
![Junit](https://img.shields.io/badge/JUNIT-4.13.1-orange)
![Mockito](https://img.shields.io/badge/MOCKITO-3.5.13-red)
![Log4j2](https://img.shields.io/badge/Log4j-2.18.0-green)
![Lombok](https://img.shields.io/badge/Lombok-1.18.24-white)

## Контакты
[![Telegram](https://img.shields.io/badge/TELEGRAM-26A5E4?style=for-the-badge&logo=telegram&logoColor=white)](https://t.me/romanka3)

### chansforman@gmail.com

## Перед запуском установите:

- Java 17
- Apache Maven 3.x
- Postgres 14


## Запуск приложения

1. Создать бд:
```sql
create database url_short;
```

2. Запуск приложения с maven. Перейдите в корень проекта через командную строку и выполните команды:
```
    mvn clean install
    mvn spring-boot:run
```
3. Запустить ссылку http://localhost:8080/index