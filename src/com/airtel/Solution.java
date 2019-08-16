package com.airtel;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'findCapitalCity' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER robber_distance
     *  2. WEIGHTED_INTEGER_GRAPH city
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */

    public static int findCapitalCity(int robber_distance, int cityNodes, List<Integer> cityFrom, List<Integer> cityTo, List<Integer> cityWeight) {
        int dist[] = new int[cityNodes];
        int count = 0;
        int tempcity = 0;
        int tempdis= 0;
        for(int i = 0;i <=cityNodes;){
            tempcity = cityFrom.get(i);
            tempdis = cityWeight.get(i);

            if (tempdis <= robber_distance) {
                count = 1;
            }

            int j = i+1;
            while(j<cityNodes && tempcity == cityFrom.get(j)){

                tempdis = cityWeight.get(j);

                if (tempdis <= robber_distance) {
                    count++;
                }
                j++;
            }
            dist[tempcity] = count;
            count = 0;
            i = j;
        }

        int max = dist[0];
        int z = 0;
        for(int i = 0 ; i<cityNodes;i++){
            if(max < dist[i]){
                max = dist[i];
                z = i;
            }
        }

        return z;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int robber_distance = 0;//Integer.parseInt(bufferedReader.readLine().trim());

//        String[] cityNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int cityNodes = 0;//Integer.parseInt(cityNodesEdges[0]);
        int cityEdges = 0;//Integer.parseInt(cityNodesEdges[1]);

        List<Integer> cityFrom = new ArrayList<>();
        List<Integer> cityTo = new ArrayList<>();
        List<Integer> cityWeight = new ArrayList<>();

//        IntStream.range(0, cityEdges).forEach(i -> {
//            try {
//                String[] cityFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//                cityFrom.add(Integer.parseInt(cityFromToWeight[0]));
//                cityTo.add(Integer.parseInt(cityFromToWeight[1]));
//                cityWeight.add(Integer.parseInt(cityFromToWeight[2]));
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });


        robber_distance = 4;
        cityNodes = 5;
        cityEdges = 6;
        cityFrom.add(1);
        cityFrom.add(1);
        cityFrom.add(2);
        cityFrom.add(3);
        cityFrom.add(3);
        cityFrom.add(4);

        cityTo.add(2);
        cityTo.add(3);
        cityTo.add(3);
        cityTo.add(4);
        cityTo.add(5);
        cityTo.add(5);

        cityWeight.add(6);
        cityWeight.add(1);
        cityWeight.add(1);
        cityWeight.add(1);
        cityWeight.add(1);
        cityWeight.add(8);

        int result = Result.findCapitalCity(robber_distance, cityNodes, cityFrom, cityTo, cityWeight);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
