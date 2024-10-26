package ru.urfu;

/**
 * Класс для обработки сообщений
 */
public class MassageHandler {
    /**
     * Формирует ответ на сообщение пользователя
     * @param messageFromUser текст сообщения от пользователя
     */
    public String createResponse(String messageFromUser){
        return "Ваше сообщение " + messageFromUser;
    }
}
