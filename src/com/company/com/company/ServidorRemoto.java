package com.company;


//import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ServidorRemoto implements InterfazRemota {
	
	private String mensaje;
	private String date;

    public ServidorRemoto() {

    }
	@Override
	public String getMensaje() throws RemoteException {
		// TODO Auto-generated method stub
		return "Ana saludo :) de servidor" + this.mensaje;
	}
	@Override
	public String getMensaje(String message) throws RemoteException {
		// TODO Auto-generated method stub
		return message;
	}


    public String getDate(String keyword) throws RemoteException {
        //lógica para devolver la fecha
        //formato Mar 15 2024 s se recibe la
        // palabra clave "date"
        if (keyword.equals("date")) {
            LocalDate fechaActual = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy");
            return fechaActual.format(formatter);
        } else {
            return "Palabra clave incorrecta";
        }
    }


    public static void main (String[] arr) throws RemoteException{
    	ServidorRemoto sr = new ServidorRemoto();
    	sr.mensaje = "que onda";
    	sr.date = "date";
    	
    	
    	
    	InterfazRemota esqueleto = (InterfazRemota) UnicastRemoteObject.exportObject(sr, 0);
    	Registry registro = LocateRegistry.createRegistry(1099);
    	registro.rebind("ObjetoMensaje", esqueleto);
    	System.out.println("Servidor encendido");
    	/**
        try {
            InterfazRemota servidor = new ServidorRemoto();
            Registry registro = LocateRegistry.getRegistry(8777);

            registro.bind("servidorHolaMundo", servidor);
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
        **/
    }





}
