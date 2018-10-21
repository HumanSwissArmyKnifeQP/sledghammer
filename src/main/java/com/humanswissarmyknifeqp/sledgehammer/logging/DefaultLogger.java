package com.humanswissarmyknifeqp.sledgehammer.logging;

public class DefaultLogger {
    
    public static void logMessage(String message){
        System.out.println(message);
    }
    
    public static void logFormattedMessage(String messageTemplate, Object... values){
        String formattedMessage = String.format(messageTemplate, values);
        System.out.println(formattedMessage);
    }
}
