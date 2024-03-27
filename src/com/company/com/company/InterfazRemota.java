package com.company;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazRemota extends Remote {

    public String getMensaje(String message) throws RemoteException;
    public String getMensaje() throws RemoteException;

    public String getDate(String keyword) throws RemoteException;

}

