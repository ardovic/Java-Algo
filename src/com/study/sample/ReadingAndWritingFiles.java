package com.study.sample;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.util.*;

public class ReadingAndWritingFiles {

    public static void main(String[] args) {
        readFileWithBufferedReader();
        readFileWithBufferedReader2();
        readConsoleWithBufferedReader();
        readFileWithScanner();
        readFileWithScanner2();
        readConsoleWithScanner();
    }

    public static void readFileWithBufferedReader() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("input.txt"));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File input.txt not found!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void readFileWithBufferedReader2() {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readConsoleWithBufferedReader() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String currentLine;
        while (true) {
            try {
                if ((currentLine = reader.readLine()) == null) {
                    break;
                }
                System.out.println(currentLine);
                if (currentLine.equals("exit")) {
                    reader.close();
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void readFileWithScanner() {
        File file = new File("input.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File input.txt not found!");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public static void readFileWithScanner2() {
        File file = new File("input.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File input.txt not found!");
        }
    }

    public static void readConsoleWithScanner() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            System.out.println(nextLine);
            if (nextLine.equals("exit")) {
                scanner.close();
                break;
            }
        }
    }
}
