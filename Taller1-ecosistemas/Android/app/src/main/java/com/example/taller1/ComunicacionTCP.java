package com.example.taller1;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ComunicacionTCP extends Thread{

    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    private AppCompatActivity app;




    public ComunicacionTCP(AppCompatActivity app){
        this.app = app;
    }

    //Hilo de recepción
    @Override
    public void run() {
        try {
            Log.e(">>>","Lanzando conexion");
            this.socket = new Socket("192.168.0.16",5000);
            Log.e(">>>","Exito");
            //Reader
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            this.reader = new BufferedReader(isr);

            //Writer
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            this.writer = new BufferedWriter(osw);

            while(true) {
                recibirMensaje();
            }



        } catch (IOException e) {
            e.printStackTrace();
            //Log.e(">>>",""+e.getLocalizedMessage());
        }
    }

    //Solicitar conexion
    public void solicitarConexion(){
        this.start();
    }


    public void mandarMensaje(String mensaje){
        new Thread(
                ()->{
                    try {
                        writer.write(mensaje+"\n");
                        writer.flush();

                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
        ).start();
    }



    public void recibirMensaje() throws IOException{
        String line = reader.readLine();
        System.out.println("<<<"+line);

    }

    public void cerrarConexion(){
        try {
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }




}
