/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.message;


import za.ac.tut.encryption.Encryptor;

public class Message {
    private String plainMessage;
    private String encryptedMessage;

    public Message(String plainMessage) {
        this.plainMessage = plainMessage;
        this.encryptedMessage = Encryptor.encrypt(plainMessage);
    }

    public String getPlainMessage() {
        return plainMessage;
    }

    public String getEncryptedMessage() {
        return encryptedMessage;
    }

    public void setPlainMessage(String plainMessage) {
        this.plainMessage = plainMessage;
        this.encryptedMessage = Encryptor.encrypt(plainMessage);
    }

    public void clearMessages() {
        this.plainMessage = "";
        this.encryptedMessage = "";
    }
}
