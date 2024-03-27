package com.company;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteAna {
	private ClienteAna() {super();}

    public static void main(String[] args) throws RemoteException, NotBoundException {
    	
    	Registry registry = LocateRegistry.getRegistry(1099);
    	InterfazRemota stub = (InterfazRemota) registry.lookup("ObjetoMensaje");
    	
    	//Integer finalizar = 1;
    	
    	//do {
    		//finalizar 1 o 0 
    		//tomar el valor de date
    		//tomar el valor de tu mensaje 
    		//if(finalizar ==1)
    		//String texto = "enduro";
    		//String textoDate ="enduro";
    		
    		
    		//poner esos valores en println 
    		//System.out.println(""+ stub.getMensaje());
    		//System.out.println(""+ stub.getMensaje(texto));
    		//System.out.println(""+ stub.getDate(textoDate));
    	System.out.println("Mensaje: " + stub.getMensaje() + " Fecha:" + stub.getDate("date") + " resultado:"+ stub.getMensaje("ana desde cliente"));

    	//}while(0)
/**
        InterfazRemota servidor;
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 8777);
            servidor = (InterfazRemota) registro.lookup("servidorHolaMundo");
            System.out.println(servidor);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
        **/
    }
}


// se debe agregar un ciclo para invocar los dos metodos y definir a main
//con eso se simulara un servidor echo con fecha usando rmi