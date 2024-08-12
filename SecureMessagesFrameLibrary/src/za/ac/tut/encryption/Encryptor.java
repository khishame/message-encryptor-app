/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.encryption;

public class Encryptor {

    public static String encrypt(String message) {
        StringBuilder en = new StringBuilder();  
        for (int i = 0; i < message.length(); i++) {
            char a = message.charAt(i); 

            switch (a) {
                case 'a': a = 'd'; break;
                case 'b': a = 'e'; break;
                case 'c': a = 'f'; break;
                case 'd': a = 'g'; break;
                case 'e': a = 'h'; break;
                case 'f': a = 'i'; break;
                case 'g': a = 'j'; break;
                case 'h': a = 'k'; break;
                case 'i': a = 'l'; break;
                case 'j': a = 'm'; break;
                case 'k': a = 'n'; break;
                case 'l': a = 'o'; break;
                case 'm': a = 'p'; break;
                case 'n': a = 'q'; break;
                case 'o': a = 'r'; break;
                case 'p': a = 's'; break;
                case 'q': a = 't'; break;
                case 'r': a = 'u'; break;
                case 's': a = 'v'; break;
                case 't': a = 'w'; break;
                case 'u': a = 'x'; break;
                case 'v': a = 'y'; break;
                case 'w': a = 'z'; break;
                case 'x': a = 'a'; break;
                case 'y': a = 'b'; break;
                case 'z': a = 'c'; break;
                default:
                    
                    break;
            }

            en.append(a);  
        }
        return en.toString();  
    }
}

