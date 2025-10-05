package org.example.motor_de_descontos.logger;

public class LoggerAdapter implements Logger {
    @Override
    public void log(String mensagem) {
        System.out.println(mensagem);
    }
}
