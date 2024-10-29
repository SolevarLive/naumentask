package ru.urfu;

/**
 * Класс для обработки сообщений
 */
public class MassageHandler {
    /**
     * Обрабаывает и формирует ответ на сообщение пользователя
     * @param messageFromUser текст сообщения от пользователя
     */
    public String createResponse(String messageFromUser){
        return String.format("Ваше сообщение: %s", messageFromUser);
    }
}
