package org.example;

import presentation.BookConsoleView;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        BookConsoleView nuestraApp = new BookConsoleView();
          nuestraApp.printMenu();
    }
}


