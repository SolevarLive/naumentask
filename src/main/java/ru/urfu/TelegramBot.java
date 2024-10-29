package ru.urfu;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * Телеграм бот
 */
public class TelegramBot extends TelegramLongPollingBot {

    private final String telegramBotName;
    private final MessageHandler messageHandler;

    /**
     * Конструктор для создания экземпляра бота.
     *
     * @param telegramBotName имя бота
     * @param token для доступа к API Telegram
     * @param messageHandler обработчик сообщений
     */
    public TelegramBot(String telegramBotName, String token, MessageHandler messageHandler) {
        super(token);
        this.telegramBotName = telegramBotName;
        this.messageHandler = messageHandler;
    }

    /**
     * Запускт бота и обработка входящих сообщений.
     */
    public void start() {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(this);
            System.out.println("Telegram бот запущен");
        } catch (TelegramApiException e) {
            throw new RuntimeException("Не удалось запустить телеграм бота", e);
        }
    }

    /**
     * Обрабатывает входящие обновления от Telegram
     *
     * @param update содержит сообщение от пользователя
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message updateMessage = update.getMessage();
            Long chatId = updateMessage.getChatId();
            String messageFromUser = updateMessage.getText();
            String responseMessage = messageHandler.createResponse(messageFromUser);

            sendMessage(chatId.toString(), responseMessage);
        }
    }

    /**
     * Отправить сообщение
     * @param chatId идентификатор чата
     * @param message текст сообщения
     */
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.err.println("Не удалось отправить сообщение. " + e.getMessage());
        }
    }

    /**
     * Возвращает имя бота
     */
    @Override
    public String getBotUsername() {
        return telegramBotName;
    }
}
