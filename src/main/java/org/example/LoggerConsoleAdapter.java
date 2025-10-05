package org.example;

public class LoggerConsoleAdapter implements LoggerPort{
    @Override
    public void log(String mensagem) {
        System.out.println(mensagem);
    }
}
