package com.ipn.mx.miniinventario.core.features.mail;

public interface EmailService {
    void enviarCorreoElectronico(String to, String subject, String text);
}
