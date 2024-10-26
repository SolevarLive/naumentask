package ru.urfu;

/**
 * Класс для запуска приложения
 */
public class Application {

    public static void main(String[] args) {
        MassageHandler massageHandler = new MassageHandler();
        String telegramBotName = System.getenv("telegram_botName");
        String telegramToken = System.getenv("telegram_token");
        new TelegramBot(telegramBotName, telegramToken, massageHandler)
                .start();

        String discordToken = System.getenv("discord_token");
        new DiscordBot(discordToken, massageHandler)
                .start();

        // сколько угодно чат платформ и все должны работать одинаково
    }

}
