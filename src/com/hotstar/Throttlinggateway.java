package com.hotstar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Throttlinggateway {

    static int droppedRequests(List<Integer> requestTime) {
        int max = requestTime.stream().max(Integer::compare).get();
        int count[] = new int[max+1];

        for (int i = 0; i < requestTime.size(); i++) {
            count[requestTime.get(i)]++;
        }

        int dropped = 0;
        int index = 0;
        int numrequest = 0;
        for (int i = 0; i < count.length; i++) {
            numrequest+=count[i];
            if (count[i] > 3) {
                dropped++;
            }
            index++;
            if ( (index-i)%10<=10){
                if (numrequest > 20) {
                    dropped+=numrequest-20;
                    numrequest=numrequest-count[i];
                }
            }
            if ( (index-i)%60<=60){
                if (numrequest > 60) {
                    dropped+=numrequest-60;
                    numrequest=numrequest-count[i];
                }
            }

        }

        return dropped;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7);
        System.out.println(droppedRequests(list));
    }
}
