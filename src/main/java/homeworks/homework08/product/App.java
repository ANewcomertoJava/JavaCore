package homeworks.homework08.product;

import homeworks.homework08.person.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) {


        try {
            FileReader fileReader = new FileReader("src/main/java/homeworks/homework08/input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }


            fileReader.close();
        } catch (IOException ioException){
            ioException.printStackTrace();
        }


    }
}

