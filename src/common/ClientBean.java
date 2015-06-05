package common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.net.InetAddress;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ClientBean {
	
	private String toExtractor;

	public String getToExtractor() {
		return toExtractor;
	}

	public void setToExtractor(String toExtractor) {
		this.toExtractor = toExtractor;
	}
	
	
	public void sendToExtractor(String toExtractor){
		try{
		Socket socket =new Socket("172.16.80.180",5002);
		socket.setSoTimeout(60000);
		PrintWriter printWriter =new PrintWriter(socket.getOutputStream(),true);
		printWriter.println(toExtractor);
		printWriter.flush();
		BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String result = bufferedReader.readLine();
		System.out.println("Server say : " + result);

		printWriter.close();
		bufferedReader.close();
		socket.close();
		}
		catch(Exception e){
		}
		}
	
	/*
	public void sendToExtractor(File file){
		try{
			Socket socket = new Socket("172.16.80.180",5000);
			
			 
			
			
			socket.setSoTimeout(60000);
			PrintWriter printWriter =new PrintWriter(socket.getOutputStream(),true);
			printWriter.println("hello! connected!");
			printWriter.flush();
			
			
			
			DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
			DataOutputStream dos =new DataOutputStream(socket.getOutputStream());
			
			int bufferSize = 10240;
            byte[] buf = new byte[bufferSize];
            int num =0;
            while((num=dis.read(buf))!=-1){
                dos.write(buf, 0, num);
            }
            dos.flush();
			
			
			
			
			//BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //String result = bufferedReader.readLine();
            //System.out.println("Server say : " + result);
  
            
            printWriter.close();
    		//bufferedReader.close();
    		socket.close();
            //bufferedReader.close();
            //dis.close();
            //socket.close();
			
		}
		catch(Exception e){
			
		}
	}*/

}
