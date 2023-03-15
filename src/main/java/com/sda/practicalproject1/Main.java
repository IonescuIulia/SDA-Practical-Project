package com.sda.practicalproject1;

import com.sda.practicalproject1.utils.SessionManager;

public class Main {
    public static void main(String[] args) {
        SessionManager.getSessionFactory();


        SessionManager.shutdown();
    }
}