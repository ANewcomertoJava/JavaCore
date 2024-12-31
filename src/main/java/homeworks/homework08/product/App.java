package homeworks.homework08.product;

import homeworks.homework08.person.Person;

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {

        // для считывания из файла
        try {
            String string;
            FileReader fileReader = new FileReader("src/main/java/homeworks/homework08/product/input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("src/main/java/homeworks/homework08/product/output.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            while (bufferedReader.ready()) {
                string = bufferedReader.readLine();
                bufferedWriter.write(string + "\r\n");

            }

            bufferedReader.close();
            fileReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();


        } catch (IOException ioException){
            ioException.printStackTrace();
        }




    }
}

