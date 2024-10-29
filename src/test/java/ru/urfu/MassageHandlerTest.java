package ru.urfu;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки функциональности класса MassageHandler.
 */
class MassageHandlerTest {

    /**
     * Проверяет, что метод createResponse возвращает правильный ответ
     * для стандартного входного сообщения.
     */
    @org.junit.jupiter.api.Test
    void createResponse_ReturnResponse() {
        MassageHandler messageHandler = new MassageHandler();
        String inputMessage = "Привет, бот!";
        String expectedResponse = "Ваше сообщение: Привет, бот!";

        String actualResponse = messageHandler.createResponse(inputMessage);

        assertEquals(expectedResponse, actualResponse);
    }

    /**
     * Проверяет, что метод createResponse возвращает корректный ответ
     * для пустого входного сообщения.
     */
    @org.junit.jupiter.api.Test
    void createResponse_ReturnsAnEmptyMessage() {
        MassageHandler messageHandler = new MassageHandler();
        String inputMessage = "";
        String expectedResponse = "Ваше сообщение: ";

        String actualResponse = messageHandler.createResponse(inputMessage);

        assertEquals(expectedResponse, actualResponse);
    }

    /**
     * Проверяет, что метод createResponse корректно обрабатывает
     * входные сообщения, состоящие только из пробелов.
     */
    @org.junit.jupiter.api.Test
    void createResponse_HandlesWhitespace() {
        MassageHandler messageHandler = new MassageHandler();
        String inputMessage = "   ";
        String expectedResponse = "Ваше сообщение:    ";

        String actualResponse = messageHandler.createResponse(inputMessage);

        assertEquals(expectedResponse, actualResponse);
    }
}
