package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private String filePath = "/Users/michalwierba/Desktop/Testing IO/testingIO.txt";
    private List<String> extractedData = new ArrayList<>();
    private List<Result> results = new ArrayList<>();
    List<Result> deserializedResultList = null;


    public static void main(String[] args) {

        Main main = new Main();

        try {
            main.performApplicationAction();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public boolean changePossible(String string1, String string2){

        char[] firstStringAsArray = string1.toCharArray();
        char[] secondStringAsArray = string2.toCharArray();


        Arrays.sort(firstStringAsArray);

        Arrays.sort(secondStringAsArray);

        return Arrays.equals(firstStringAsArray,secondStringAsArray);

    }


    public void readDataFromFile() throws Exception{


        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)))) {


            for(String extractedString = bufferedReader.readLine(); extractedString != null; extractedString = bufferedReader.readLine()) {

                extractedData.add(extractedString);

            }

        }

    }



    public void performApplicationAction() throws Exception {

        readDataFromFile();

        for(int i = 0; i < extractedData.size()-1; i+=2){

            results.add(new Result(extractedData.get(i),
                                    extractedData.get(i + 1),
                                    changePossible(extractedData.get(i), extractedData.get(i + 1))));


        }

        writeResultsAsObjects();
        readObjectsFromAFile();


        System.out.println("Results from current application run: ");
        System.out.println(results);
        System.out.println("Deserialized results: ");
        System.out.println(deserializedResultList);
        System.out.println("Result count:");
        System.out.println(Result.RESULT_COUNT);

    }

    private void writeResultsAsObjects() throws Exception{


        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("result.bin")))){


            objectOutputStream.writeObject(results);
        }
    }


    private void readObjectsFromAFile() throws Exception {

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("result.bin")))) {

            deserializedResultList = (ArrayList<Result>)objectInputStream.readObject();
            System.out.println(deserializedResultList);

        }



    }


}
