# ConsoleApp

Java-приложение для чтения и обработки данных из JSON-файла с информацией об источниках бесперебойного питания (ИБП).

## 📦 Зависимости

- Java 21
- Maven
- Gson 2.10.1

## 📁 Структура проекта

- `App.java` — точка входа в приложение
- `IBP.java` — модель данных UPS
- `data.json` — входной файл с телеметрией UPS
- `pom.xml` — конфигурация Maven
- `.gitignore` — исключения для Git

## 🚀 Сборка и запуск

```bash
# Сборка
mvn clean package

# Запуск
java -jar target/TestProject-1.0-SNAPSHOT.jar имя_функции data.json

Функции:
1 - avg (подсчитывает среднее значение по полю OutputVoltage)
2 - max (ищет максимальное значение по полю BatteryRuntimeRemaining)
3 - uniquevalues (ищет уникальные значения хостов)
```

## 📄 Пример данных (data.json)

```json
[
  {
    "ups_adv_output_load": 6,
    "ups_adv_battery_temperature": 23,
    "@timestamp": "2021-04-20T15:34:58.290Z",
    "host": "192.168.11.9",
    "ups_adv_battery_run_time_remaining": 528000,
    "ups_adv_output_voltage": 234
  }
]
```
