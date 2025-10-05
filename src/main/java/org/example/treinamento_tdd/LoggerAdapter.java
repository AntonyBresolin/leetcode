package org.example.treinamento_tdd;

public class LoggerAdapter implements Logger {
    @Override
    public void log(String mensagem) {
        System.out.println(mensagem);
    }
}
