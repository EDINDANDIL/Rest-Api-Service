# REST API Service for Weather Sensor Data

## Краткое описание

Сервис представляет собой REST API для сбора и анализа метеорологических данных. Ключевые возможности:
- Регистрация сенсоров с валидацией данных
- Сохранение измерений температуры и осадков
- Аналитика (история измерений, статистика дождливых дней
- Имитация работы датчиков через тестового клиента

## Технические особенности

### Основной стек:
- **Сам сервис**: 
  - Java 17+, Spring Boot 3.x
  - Spring Web (REST controllers)
  - Spring Data JPA + Hibernate
  - СУБД: [указать вашу БД, напр. PostgreSQL]
- **Клиент**:
  - RestTemplate для HTTP-запросов
  - Java Faker для генерации тестовых данных
  - XChart для визуализации (опционально)

### Тестирование:
Проект включает многоуровневое тестирование:
1. **Модульные тесты** (JUnit 5 + Mockito):
   - Тестирование сервисов и валидаторов
   - Mocking репозиториев
2. **Интеграционные тесты**:
   - @DataJpaTest для репозиториев
   - @WebMvcTest для контроллеров
   - Тестирование сквозных сценариев
3. **Клиентское тестирование**:
   - Автоматическая отправка 1000+ запросов
   - Проверка корректности ответов
   - Валидация полученных данных

Пример теста контроллера:
```java
@WebMvcTest(SensorController.class)
class SensorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void registerSensor_ValidData_ReturnsOk() throws Exception {
        mockMvc.perform(post("/sensors/registration")
               .contentType(MediaType.APPLICATION_JSON)
               .content("{\"name\":\"Test Sensor\"}"))
               .andExpect(status().isOk());
    }
}
