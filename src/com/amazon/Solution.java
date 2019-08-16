package com.amazon;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static int getMinimumCostToConstruct(int numTotalAvailableCities,
                                         int numTotalAvailableRoads,
                                         List<List<Integer>> roadsAvailable,
                                         int numNewRoadsConstruct,
                                         List<List<Integer>> costNewRoadsConstruct) {
        // WRITE YOUR CODE HERE
        int mat[][] = new int[numTotalAvailableCities + 1][numTotalAvailableCities + 1];
        for (int i = 0; i <= numTotalAvailableCities; i++) {
            mat[0][i] = 0;
            mat[i][0] = 0;
        }

        for (int i = 0; i < roadsAvailable.size(); i++) {
            List<Integer> road = roadsAvailable.get(i);
            mat[road.get(0)][road.get(1)] = 1;
        }

        int price = 0;
        for (int i = 1; i <= numTotalAvailableCities; i++) {
            for (int j = 1; j <= numTotalAvailableCities; j++) {
                if (mat[i][j] == 0) {
                    // can be handled via map
                    boolean reachable = checkJReachableFromAnyCity(mat, j);
                    if (!reachable) {
                        for (int k = 0; k < costNewRoadsConstruct.size(); k++) {
                            List<Integer> cost = costNewRoadsConstruct.get(i);
                            if ((cost.get(0) == i && cost.get(1) == j) || (cost.get(0) == j && cost.get(1) == i)) {
                                price += cost.get(2);
                                //mark it as visited
                                mat[i][j] = 1;

                            }
                        }

                    } else {
                        List<Integer> cities = citiesReachableFroomJ(mat, j);
                        price += minCostToReachJOrCitiesFromI(mat, cities, i, j, costNewRoadsConstruct);
                    }

                }
            }
        }

        return price;
    }

    private static int minCostToReachJOrCitiesFromI(int mat[][], List<Integer> cities, int i, int j, List<List<Integer>> costNewRoadsConstruct) {
        int index = -1;
        int cost = 0;
        for (int k = 0; k < costNewRoadsConstruct.size(); k++) {
            List<Integer> costList = costNewRoadsConstruct.get(i);
            if ((costList.get(0) == i && costList.get(1) == j) || (costList.get(0) == j && costList.get(1) == i)) {
                cost = costList.get(2);
                index = j;
                break;
            }
        }

        for (int city : cities) {
            for (int k = 0; k < costNewRoadsConstruct.size(); k++) {
                List<Integer> costList = costNewRoadsConstruct.get(i);
                if ((costList.get(0) == i && costList.get(1) == city) || (costList.get(0) == city && costList.get(1) == i)) {
                    if (costList.get(2) < cost) {
                        cost = costList.get(2);
                        index = city;
                    }
                }
            }
        }
        if (index != -1) {
            mat[i][index] = 1;
        }
        return cost;
    }

    private static List<Integer> citiesReachableFroomJ(int[][] mat, int j) {
        List<Integer> cities = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][j] == 1) {
                cities.add(i);
            }
        }
        return cities;
    }

    private static boolean checkJReachableFromAnyCity(int[][] mat, int j) {
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][j] == 1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> roadsAvailable = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        roadsAvailable.add(l);

        List<Integer> l2 = new ArrayList<>();
        l2.add(2);
        l2.add(3);
        roadsAvailable.add(l2);
        List<Integer> l3 = new ArrayList<>();
        l3.add(4);
        l3.add(5);
        roadsAvailable.add(l3);
        List<Integer> l4 = new ArrayList<>();
        l4.add(3);
        l4.add(5);
        roadsAvailable.add(l4);

        List<List<Integer>> costNewRoadsConstruct = new ArrayList<>();

        List<Integer> c1 = new ArrayList<>();
        c1.add(1);
        c1.add(6);
        c1.add(410);
        costNewRoadsConstruct.add(c1);

        List<Integer> c2 = new ArrayList<>();
        c2.add(2);
        c2.add(4);
        c2.add(800);
        costNewRoadsConstruct.add(c1);

        System.out.println(getMinimumCostToConstruct(6, 4, roadsAvailable, 2, costNewRoadsConstruct));
    }
}