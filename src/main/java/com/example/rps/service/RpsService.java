package com.example.rps.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class RpsService {

    public String rpsBrain(String userChoice){

        if(userChoice == null || userChoice.isEmpty()){
            return "You insert a empty choice!";
        }

        String response = "";
        int randomNum = getRandomNumberWithRange(1,4);
        String cpuChoose = getRpsChooiseFromNumber(randomNum);

        if(cpuChoose.equalsIgnoreCase("Rock")){
            if(userChoice.equalsIgnoreCase("Rock")){
                response = "You choose Rock and CPU choose Rock ,You Draw!";
            }else if(userChoice.equalsIgnoreCase("Paper")){
                response = "You choose Paper and CPU choose Rock ,You Win!";
            }else if(userChoice.equalsIgnoreCase("Scissors")){
                response = "You choose Scissors and CPU choose Rock ,You Lose!";
            }else{
                response = "You insert a wrong choice!";
            }
        }else if (cpuChoose.equalsIgnoreCase("Paper")){
            if(userChoice.equalsIgnoreCase("Rock")){
                response = "You choose Rock and CPU choose Paper ,You Lose!";
            }else if(userChoice.equalsIgnoreCase("Paper")){
                response = "You choose Paper and CPU choose Paper ,You Draw!";
            }else if(userChoice.equalsIgnoreCase("Scissors")){
                response = "You choose Scissors and CPU choose Paper ,You Win!";
            }else{
                response = "You insert a wrong choice!";
            }
        }else if (cpuChoose.equalsIgnoreCase("Scissors")){
            if(userChoice.equalsIgnoreCase("Rock")){
                response = "You choose Rock and CPU choose Scissors ,You Win!";
            }else if(userChoice.equalsIgnoreCase("Paper")){
                response = "You choose Paper and CPU choose Scissors ,You Lose!";
            }else if(userChoice.equalsIgnoreCase("Scissors")){
                response = "You choose Scissors and CPU choose Scissors ,You Draw!";
            }else{
                response = "You insert a wrong choice!";
            }
        }

        return response;
    }

    private int getRandomNumberWithRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private String getRpsChooiseFromNumber(int num){
        HashMap<Integer, String> rpcItems = new HashMap<Integer, String>();
        rpcItems.put(1,"Rock");
        rpcItems.put(2,"Paper");
        rpcItems.put(3,"Scissors");

        return rpcItems.get(num);
    }

}
