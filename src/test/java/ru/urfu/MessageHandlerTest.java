package ru.urfu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки функциональности класса MessageHandler.
 */
class MessageHandlerTest {

    /**
     * Проверяет, что метод createResponse возвращает правильный ответ
     * для стандартного входного сообщения.
     */
    @Test
    void createResponse_ReturnResponse() {
        MessageHandler messageHandler = new MessageHandler();
        String inputMessage = "Привет, бот!";
        String expectedResponse = "Ваше сообщение: Привет, бот!";

        String actualResponse = messageHandler.createResponse(inputMessage);

        assertEquals(expectedResponse, actualResponse);
    }

    /**
     * Проверяет, что метод createResponse возвращает корректный ответ
     * для пустого входного сообщения.
     */
    @Test
    void createResponse_ReturnsAnEmptyMessage() {
        MessageHandler messageHandler = new MessageHandler();
        String inputMessage = "";
        String expectedResponse = "Ваше сообщение: ";

        String actualResponse = messageHandler.createResponse(inputMessage);

        assertEquals(expectedResponse, actualResponse);
    }

    /**
     * Проверяет, что метод createResponse корректно обрабатывает
     * входные сообщения, состоящие только из пробелов.
     */
    @Test
    void createResponse_HandlesWhitespace() {
        MessageHandler messageHandler = new MessageHandler();
        String inputMessage = "   ";
        String expectedResponse = "Ваше сообщение:    ";

        String actualResponse = messageHandler.createResponse(inputMessage);

        assertEquals(expectedResponse, actualResponse);
    }
}
