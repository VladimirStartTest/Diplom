# Дипломная работа


1. [План автоматизации](https://github.com/VladimirStartTest/Diplom/blob/main/documents/Plan.md)
2. [Отчет о тестировании](https://github.com/VladimirStartTest/Diplom/blob/main/documents/Report.md)
3. [Отчет по итогам автоматизации](https://github.com/VladimirStartTest/Diplom/blob/main/documents/Result.md)

## Информация о проекте

Приложение — это веб-сервис, который предлагает купить тур по определённой цене двумя способами:

1. Обычная оплата по дебетовой карте.
2. Уникальная технология: выдача кредита по данным банковской карты.

Само приложение не обрабатывает данные по картам, а пересылает их банковским сервисам:

- сервису платежей, далее Payment Gate;
- кредитному сервису, далее Credit Gate.


### Запуск тестов:

#### Работа с базой данных MySQl:

 С помощью Git клонировать репозиторий командой git
  clone [Проект тестирования](https://github.com/VladimirStartTest/Diplom)
- Запустить Docker;
- Открыть проект в IntelliJ IDEA;
- В терминале IntelliJ IDEA запустить необходимые базы данных с помощью команды `docker-compose up -d` 
- В новой вкладке терминала запустить приложение с помощью команды  `java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar` 
- Для запуска автотестов в новом окне терминала ввести команду `./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"`
- Для создания отчета ввести команду  `./gradlew allureServe`
(Если отчет не отрывается автоматически необходимо использовать команду `./gradlew allureReport` и открыть отчёт вручную по адресу `.\build\reports\allure-report\allureReport\index.html`)

#### Работа с базой данных PostgreSQl:

С помощью Git клонировать репозиторий командой git
  clone [Проект тестирования](https://github.com/VladimirStartTest/Diplom)
- Запустить Docker;
- Открыть проект в IntelliJ IDEA;
- В терминале IntelliJ IDEA запустить необходимые базы данных с помощью команды `docker-compose up -d` 
- В новой вкладке терминала запустить приложение с помощью команды  `java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar`
- Для запуска автотестов в новом окне терминала ввести команду `./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"`
- Для создания отчета ввести команду  `./gradlew allureServe`
(Если отчет не отрывается автоматически необходимо использовать команду `./gradlew allureReport` и открыть отчёт вручную по адресу `.\build\reports\allure-report\allureReport\index.html`)