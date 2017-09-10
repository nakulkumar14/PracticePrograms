package com.airtel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by nakul on 10-Sep-17.
 */
public class ClosestMatching {

    private Map<Integer,String[]> address = new HashMap<>();
    private Map<Integer,String> actualAddress = new HashMap<>();

    void populateAddress(int lineno,String addressLine){
        String str=addressLine.replaceAll("[/,-]"," ");
        String words[] = str.toLowerCase().split("\\s+");
        address.put(lineno,words);
        actualAddress.put(lineno,addressLine);
    }

    String closestAddress(String newAddress){
        int bestScore = Integer.MIN_VALUE;
        int line = 0;
        List newAddList = new ArrayList<>(Arrays.asList(newAddress.toLowerCase().split("\\s+")));

        for (Map.Entry<Integer,String[]> entry : address.entrySet()){
            List addList = new ArrayList<>(Arrays.asList(entry.getValue()));
            addList.retainAll(newAddList);
            if (addList.size()>bestScore){
                bestScore = addList.size();
                line = entry.getKey();
            }
        }
        return bestScore!=0?actualAddress.get(line):"Nothing matched";
    }

    public static void main(String[] args) throws IOException {
        ClosestMatching closestMatching = new ClosestMatching();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int lineNo = 0;
        while (m!=0){
            System.out.println(lineNo+" line : ");
            String line = br.readLine();
            closestMatching.populateAddress(lineNo,line);
            m--;
            lineNo++;
        }

        System.out.println("Enter new address : ");
        String newAddress = br.readLine();
        System.out.println("Result : " + closestMatching.closestAddress(newAddress));
    }
}
