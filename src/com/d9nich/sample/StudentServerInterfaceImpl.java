package com.d9nich.sample;

import java.rmi.RemoteException;
import java.util.HashMap;

public class StudentServerInterfaceImpl implements StudentServerInterface {
    // Stores scores in a map indexed by name
    private final HashMap<String, Double> scores =
            new HashMap<>();

    public StudentServerInterfaceImpl() throws RemoteException {
        initializeStudent();
    }

    /**
     * Initialize student information
     */
    protected void initializeStudent() {
        scores.put("John", 90.5);
        scores.put("Michael", 100d);
        scores.put("Michelle", 98.5);
    }

    /**
     * Implement the findScore method from the
     * Student interface
     */
    public double findScore(String name) throws RemoteException {
        Double d = scores.get(name);
        if (d == null) {
            System.out.println("Student " + name + " is not found ");
            return -1;
        } else {
            System.out.println("Student " + name + "'s score is "
                    + d);
            return d;
        }
    }
}
