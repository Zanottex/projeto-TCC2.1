package com.cronoporta.projeto.Service;

import com.cronoporta.projeto.Model.M_Porta;
import com.fazecast.jSerialComm.SerialPort;
import org.springframework.stereotype.Service;

@Service
public class S_Arduino {

    public static void mandarArduino() {

        SerialPort[] ports = SerialPort.getCommPorts();
        SerialPort serialPort;
        if (ports.length > 0) {
            serialPort = ports[0]; // Seleciona a primeira porta serial disponível (altere conforme necessário)

            if (serialPort.openPort()) {
                System.out.println("Porta serial aberta!");

                serialPort.setBaudRate(9600); // Define a taxa de transmissão (baud rate)

                M_Porta m_porta = new M_Porta();
                boolean ativoAtual = m_porta.isAtivo();

                    String message = ativoAtual ? "true" : "false";
                    serialPort.writeBytes(message.getBytes(), message.getBytes().length);
                    System.out.println("Enviado para Arduino: " + message);
                    try {
                        Thread.sleep(2000);
//                        statusPorta = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();

//                        statusPorta = false;
                    }

                    serialPort.closePort(); // Fecha a porta serial
                } else {
                System.err.println("Não foi possível abrir a porta serial.");
            }
        } else {
            System.err.println("Nenhuma porta serial encontrada.");
        }
//        return statusPorta;
    }

    public static boolean receberArduino (){

        boolean statusBotao = true;
        SerialPort[] ports = SerialPort.getCommPorts();
        if (ports.length > 0) {
            SerialPort serialPort = ports[1]; // Seleciona a primeira porta serial disponível (altere conforme necessário)
            if (serialPort.openPort()) {
                System.out.println("Porta serial aberta!");

                serialPort.setBaudRate(9600); // Define a taxa de transmissão (baud rate)

                while (true) {
                    if (serialPort.bytesAvailable() > 0) {
                        byte[] newData = new byte[serialPort.bytesAvailable()];
                        int numRead = serialPort.readBytes(newData, newData.length);
                        String receivedData = new String(newData, 0, numRead);

                        // Converte a string recebida para um valor booleano
                        boolean receivedBoolean = Boolean.parseBoolean(receivedData);

                        // Exibe o valor booleano recebido do Arduino
                        System.out.println("Valor booleano recebido do Arduino: " + receivedBoolean);

                        // Exibe um alerta no console com base no valor booleano
                        if (receivedBoolean) {
                            System.out.println("ALERTA: Valor recebido é verdadeiro!");
                        }
                    }

                    try {
                        Thread.sleep(100);
                        statusBotao = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        statusBotao = false;
                    }
                }
            } else {
                System.err.println("Não foi possível abrir a porta serial.");
            }
        } else {
            System.err.println("Nenhuma porta serial encontrada.");
        }
        return statusBotao;
}}
