package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import processing.core.PApplet;
import vista.Main;


public class Comunicación extends Thread{
	
	private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private String line;
    private Logica logica;
    private Tortuga tortuga; 
    private PApplet p;
    private OnMessageListener observer;
    
    public void setObserver(OnMessageListener observer){
        this.observer = observer;
    }

	public Comunicación(Logica logica) {
    	this.logica=logica;
    }
    
    //Hilo de recepcion
	@Override
    public void run() {
    	try {
    		
			ServerSocket server = new ServerSocket(5000);
			System.out.println("Esperando...");
			this.socket = server.accept();
			System.out.println("Aceptado");
			
			
			//Reader
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			this.reader=new BufferedReader(isr);
			
			
				
			
			
			//Wtriter
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			this.writer=new BufferedWriter(osw);
			
			
			
			while(true) {
				recibirMensajes();
				
					
					 
			}
			
			
			 

		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    //Esperar conexion
    public void esperarConexion(){
    	this.start();
    }

    //Mandar un mensaje
    public void mandarMesanje(String mensaje){
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

    //Recibir mensajes
    public void recibirMensajes() throws IOException{
    	
    	line = reader.readLine();
    	System.out.println(line);
    		
    	if(observer!=null)observer.onMessage(line);
    	
    
	//String[] info = line.split(";");
    	//String nombre= info[0];
    	//String contrasena = info[1];
    	//String contrasenaDos= info[2];
   
	
	
    	
    }
    
    //public void moverT(PApplet p) {
    	// while(true) {
    		//	switch(line) {
    			//case "RIGHT":
    				//tortuga.X+=5;
    				//break;
    			//}
    			 //}
	//}

    //Cerrar conexion
    public void cerrarConexion(){
    	try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public interface OnMessageListener{
        void onMessage(String mensaje);
    }


   
	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public PApplet getP() {
		return p;
	}

	public void setP(PApplet p) {
		this.p = p;
	}
	
	
	
	
	
	
	
}
