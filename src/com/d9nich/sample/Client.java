package com.d9nich.sample;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        //создание реестра расшареных объетов
        final Registry registry;
        try {
            registry = LocateRegistry.getRegistry("", 2099);
            //получаем объект (на самом деле это proxy-объект)
            StudentServerInterface service = (StudentServerInterface) registry.lookup("StudentServerInterfaceImpl");

            //Вызываем удаленный метод
            double result = service.findScore("John");
            System.out.println(result);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }


    }
}
