package com.d9nich.sample;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegisterRMIServer {
    public static void main(String[] args) {
        try {
            StudentServerInterface obj =
                    new StudentServerInterfaceImpl();
            Registry registry = LocateRegistry.createRegistry(2099);
            registry.rebind("StudentServerInterfaceImpl", obj);
            System.out.println("Student server " + obj + " registered");
            Thread.sleep(Integer.MAX_VALUE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
