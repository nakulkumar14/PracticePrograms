package com.lenskart;

import java.util.*;

/*
1. There are a set of reports executors stored in database which  is to be run. Some of these reports are dependent on other report to run before executing the current one. Write a program to figure out the sequence in which the reports should be run. There are no cyclic dependencies.

Sample Input:
1 -> 8,9,10
2 -> 5,6
8 -> 7,4

Input Explanation: 1 depends on 8,9 and 10; 2 depends on 5 and 6; 8 depends on 7 and 4;

Sample Output:(One possible, There can be many)
4,7,8,5,6,2,9,10,1

 */
public class TopologicalSort {

    static void topologicalSort(Map<Integer, List<Integer>> map) {

        Map<Integer, Boolean> visited = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        Set<Map.Entry<Integer, List<Integer>>> entries = map.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : entries) {
            if (!visited.containsKey(entry.getKey())) {
                traverseList(map, entry.getValue(), visited, stack);
//                visited.put(entry.getKey(), true);
                stack.push(entry.getKey());
            }
        }


        int a[] = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.empty()) {
            a[i] = stack.pop();
            i--;
        }
        System.out.println(Arrays.toString(a));

    }

    private static void traverseList(Map<Integer, List<Integer>> map, List<Integer> values, Map<Integer, Boolean> visited, Stack<Integer> stack) {
        if (values != null && !values.isEmpty()) {
            for (Integer value : values) {
                if (!visited.containsKey(value)) {
                    traverseList(map, map.get(value), visited, stack);
                    visited.put(value, true);
                    stack.push(value);
                }
            }
        }
    }

    public static void main(String[] args) {

        Map<Integer, List<Integer>> map = new HashMap<>();
//        map.put(1, new ArrayList<>(Arrays.asList(8,9,10)));
//        map.put(2, new ArrayList<>(Arrays.asList(5,6)));
//        map.put(8, new ArrayList<>(Arrays.asList(7,4)));
        map.put(40, new ArrayList<>(Arrays.asList(10, 20)));
        map.put(10, new ArrayList<>(Arrays.asList(30)));
        map.put(20, new ArrayList<>(Arrays.asList(70, 50)));
        map.put(30, new ArrayList<>(Arrays.asList(60)));
        map.put(60, new ArrayList<>(Arrays.asList(70)));
        topologicalSort(map);
    }
}
