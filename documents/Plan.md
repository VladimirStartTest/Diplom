## План автоматизации тестирования сценария покупки тура

### Исходные данные:

### Активная карта (Валидные данные):
- Активная карта - 4444 4444 4444 4441
- Месяц - текущий месяц
- Год - текущий год
- Владелец - набор символов на латинице
- CVC/CVV - три цифры (кроме 000) 
 (Данные карты подходят для всех сценариев)

### Заблокированя карта:
- Заблокированя карта - 4444 4444 4444 4442
- Месяц - текущий месяц
- Год - текущий год
- Владелец - набор символов на латинице
- CVC/CVV - три цифры (кроме 000)

### Перечень автоматизируемых сценариев:

#### Покупка по карте:

1. Успешная покупка тура по карте:
- на странице сервиса нажать кнопку "Купить".
- ввести валидные данные одобренной карты.
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Запрос успешно принят. Появилось всплывающие окно "Операция одобрена Банком." В базе данных есть запись "APPROVED".


2. Попытка покупки тура по заблокированной карте:
- на странице сервиса нажать кнопку "Купить".
- ввести данные заблокированной карты.
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Запрос успешно принят. Появилось всплывающие окно "Операция одобрена Банком." В базе данных есть запись "DECLINED".


3. Попытка покупки тура с невалидными данными (Ввод номера карты из 8 символов):
- на странице сервиса нажать кнопку "Купить".
- ввести номер карты из 8 цифр (0000 0000 0000 0000);
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


4. Попытка покупки тура с невалидными данными (Ввод не полного номера карты):
- на странице сервиса нажать кнопку "Купить".
- ввести в поле "Номер карты" 4444 4444 4444 444;
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


5. Попытка покупки тура с невалидными данными в поле "Месяц":
- на странице сервиса нажать кнопку "Купить".
- ввести в поле "Месяц" число 13;
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


6. Попытка покупки тура с невалидными данными в поле "Год":
- на странице сервиса нажать кнопку "Купить".
- ввести в поле "Год" прошедший год;
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


7. Попытка покупки тура с невалидными данными в поле "Владелец"(кириллица):
- на странице сервиса нажать кнопку "Купить".
- заполнить поле "Владелец" кириллицей;
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


8. Попытка покупки тура с невалидными данными в поле "Владелец"(цифры):
- на странице сервиса нажать кнопку "Купить".
- заполнить поле "Владелец" цифрами;
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


9. Попытка покупки тура с невалидными данными в поле "Владелец"(Спецсимволы):
- на странице сервиса нажать кнопку "Купить".
- заполнить поле "Владелец" спецсимволами;
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


10. Попытка покупки тура с невалидными данными в поле "СVC/CVV":
- на странице сервиса нажать кнопку "Купить".
- в поле "СVC/CVV" ввести 2 цифры;
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


11. Попытка покупки тура с пустой формой:
- на странице сервиса нажать кнопку "Купить".
- оставить форму незаполненной и нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение: "Неверный формат".


12. Попытка покупки тура с пустым полем "Владелец":
- на странице сервиса нажать кнопку "Купить".
- оставить поле "Владелец" пустым
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение: "Неверный формат".


13. Попытка покупки тура с пустым полем "Номер карты":
- на странице сервиса нажать кнопку "Купить".
- оставить поле "Номер карты" пустым
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение: "Неверный формат".


14. Попытка покупки тура с пустым полем "Месяц":
- на странице сервиса нажать кнопку "Купить".
- оставить поле "Месяц" пустым
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение: "Неверный формат".


15. Попытка покупки тура с пустым полем "Год":
- на странице сервиса нажать кнопку "Купить".
- оставить поле "Год" пустым
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение: "Неверный формат".


16. Попытка покупки тура с пустым полем "СVC/CVV":
- на странице сервиса нажать кнопку "Купить".
- оставить поле "СVC/CVV" пустым
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение: "Неверный формат".


17. Попытка покупки тура с невалидными данными в поле "СVC/CVV":
- на странице сервиса нажать кнопку "Купить".
- в поле "СVC/CVV" ввести 000;
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


18.  Попытка покупки тура с невалидными значениями в поле "Год":
- на странице сервиса нажать кнопку "Купить".
- Поле "Год" пустым заполнить нулями (00);
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение: "Неверный формат".


19. Попытка покупки тура с невалидными данными в поле "Месяц":
- на странице сервиса нажать кнопку "Купить".
- ввести в поле "Месяц" 00;
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


#### Покупка в кредит:

1. Успешная покупка тура в кредит:
- на странице сервиса нажать кнопку "Купить в кредит".
- ввести валидные данные одобренной карты.
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Запрос успешно принят. Появилось всплывающие окно "Операция одобрена Банком." В базе данных есть запись "APPROVED".


2. Попытка покупки тура в кредит по заблокированной карте:
- на странице сервиса нажать кнопку "Купить в кредит".
- ввести данные заблокированной карты.
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Запрос успешно принят. Появилось всплывающие окно "Операция одобрена Банком." В базе данных есть запись "DECLINED".


3. Попытка покупки тура в кредит с невалидными данными (Ввод номера карты из 8 символов):
- на странице сервиса нажать кнопку "Купить в кредит".
- ввести номер карты из 8 нулей (0000 0000 0000 0000);
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


4. Попытка покупки тура в кредит с невалидными данными (Ввод неполного номера в поле номер карты):
- на странице сервиса нажать кнопку "Купить в кредит".
- ввести в поле "Номер карты" неполный номер (4444 4444 4444 444);
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


5. Попытка покупки тура в кредит с невалидными данными в поле "Месяц":
- на странице сервиса нажать кнопку "Купить в кредит".
- ввести в поле "Месяц" число 13;
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


6. Попытка покупки тура в кредит с невалидными данными в поле "Год":
- на странице сервиса нажать кнопку "Купить в кредит".
- ввести в поле "Год" прошедший год;
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


7. Попытка покупки тура в кредит с невалидными данными в поле "Владелец"(кириллица):
- на странице сервиса нажать кнопку "Купить в кредит".
- заполнить поле "Владелец" кириллицей;
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


8. Попытка покупки тура в кредит с невалидными данными в поле "Владелец"(цифры):
- на странице сервиса нажать кнопку "Купить в кредит".
- заполнить поле "Владелец" цифрами;
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


9. Попытка покупки тура в кредит с невалидными данными в поле "Владелец"(Спецсимволы):
- на странице сервиса нажать кнопку "Купить в кредит".
- заполнить поле "Владелец" спецсимволами;
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


10. Попытка покупки тура в кредит с невалидными данными в поле "СVC/CVV":
- на странице сервиса нажать кнопку "Купить в кредит".
- в поле "СVC/CVV" ввести 2 цифры;
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


11. Попытка покупки тура в кредит с незаполненной формой:
- на странице сервиса нажать кнопку "Купить в кредит".
- оставить форму незаполненной и нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение: "Неверный формат".


12. Попытка покупки тура в кредит с пустым полем "Владелец":
- на странице сервиса нажать кнопку "Купить в кредит".
- оставить поле "Владелец" пустым
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение: "Неверный формат".


13. Попытка покупки тура в кредит с пустым полем "Номер карты":
- на странице сервиса нажать кнопку "Купить в кредит".
- оставить поле "Номер карты" пустым
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение: "Неверный формат".


14. Попытка покупки тура в кредит с пустым полем "Месяц":
- на странице сервиса нажать кнопку "Купить в кредит".
- оставить поле "Месяц" пустым
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение: "Неверный формат".


15. Попытка покупки тура в кредит с пустым полем "Год":
- на странице сервиса нажать кнопку "Купить в кредит".
- оставить поле "Год" пустым
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение: "Неверный формат".


16. Попытка покупки тура в кредит с пустым полем "СVC/CVV":
- на странице сервиса нажать кнопку "Купить в кредит".
- оставить поле "СVC/CVV" пустым
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение: "Неверный формат".


17.  Попытка покупки тура в кредит с невалидными данными в поле "Месяц":
- на странице сервиса нажать кнопку "Купить в кредит".
- заполнить поле "Месяц" нулями (00);
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


18.  Попытка покупки тура в кредит с невалидными данными в поле "Год":
- на странице сервиса нажать кнопку "Купить в кредит".
- заполнить поле "Год" нулями (00);
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


19. Попытка покупки тура в кредит с невалидными данными в поле "СVC/CVV":
- на странице сервиса нажать кнопку "Купить в кредит".
- в поле "СVC/CVV" ввести 000;
- остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить"

*Ожидаемый результат*: Покупка не совершается. Данные не отправлены. Пользователь видит сообщение: "Неверный формат данных".


### Перечень используемых инструментов с обоснованием выбора:

- **IntelliJ IDEA** - содержит инструменты для проведения автоматических тестов и формирования аналитики, которая показывает, какой объем кода протестирован, встроен декомпилятор.
- **Gradle** - система автоматический сборки, которую используют для упрощения работы с Java.
- **JUnit5** - инфраструктура модульного тестирования для Java, оснащенная множеством функций, включая вложенные тесты, параметризованные тесты, новые API расширения или поддержку Java.
- **Selenide** - для автоматизированного тестирования веб-приложений на основе Selenium WebDriver, простая конфигурация.
- **MySQL, PostgresQL** - используется для доступа к базам данным.
- **Github** - хранение документации и автотестов.
- **Allure** - для создания отчетов.

### Перечень и описание возможных рисков при автоматизаци:

- нехватка времени на выполнение
- недостаточная мощность сервера (может не выдержать дополнительных нагрузок);
- без допуска к базе данных и API сайта невозможно проверить, какие данные уходят на сервер;
- отсутствие квалифицированных специалистов по автотестированию.

### Интервальная оценка с учетом риска в часах:

С учетом рисков, для написания автотестов может потребоваться около 100 часов.

### План сдачи работ:

- ожидается, что автотесты буду готовы через 2-3 недели.
- ожидается, что результатом прогона автотестов будет их успешное прохождение.
