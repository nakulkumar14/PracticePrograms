package com.wingify;

import java.util.Scanner;

/**
 * Write a program that flattens a nested JSON object. The method should take an object and return a new flattened object.
 * <p>
 * Input: var inputObj = {
 * 'name': 'jane',
 * 'last_name': 'doe',
 * 'profession': 'engineer',
 * 'characteristics': {
 * 'intelligent': true,
 * 'punctual': false,
 * 'experience': {
 * '2012': 'college passout',
 * '2014': 'mba passout',
 * '2016': 'employed'
 * }
 * }
 * };
 * <p>
 * flatten(inputObj);
 * <p>
 * Output:
 * {
 * 'name': 'jane',
 * 'last_name': 'doe',
 * 'profession': 'engineer',
 * 'characteristics.intelligent': true,
 * 'characteristics.punctual': false,
 * 'characteristics.experience.2012': 'college passout',
 * 'characteristics.experience.2014': 'mba passout',
 * 'characteristics.experience.2016': 'employed'
 * }
 * <p>
 * Note: The method should NOT modify the original object. It should return a new object.
 */
public class FlattenJson {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String json;// = in.next();
        json = "{\n" +
                "        'name': 'jane',\n" +
                "        'last_name': 'doe',\n" +
                "        'profession': 'engineer',\n" +
                "        'characteristics': {\n" +
                "                'intelligent': true,\n" +
                "                'punctual': false,\n" +
                "                'experience': {\n" +
                "                        '2012': 'college passout',\n" +
                "                        '2014': 'mba passout',\n" +
                "                        '2016': 'employed'\n" +
                "                }\n" +
                "        }\n" +
                "};";
        String flatten = flatten(json);
        System.out.println(flatten);
    }

    private static String flatten(String json) {
//        String[] split = json.split("\\{");
//        for (int i = 0; i < split.length; i++) {
//            System.out.println(i+"::" + split[i]);
//        }
        String res = "{";
        for (int i = 0; i < json.length(); i++) {

            while (i < json.length() && json.charAt(i) != '\'') {
                i++;
            }
            System.out.println(i);

            if (i >= json.length())
                break;

            String key = "";
            while (i < json.length() && json.charAt(i) != ':') {
                key += json.charAt(i);
                i++;
            }

            System.out.println("i: " + i + ", key: " + key);
            res += key;

            int j = i + 1;

            if (j >= json.length()) {
                return "";
            }

            String value = "";

            while (j < json.length()) {
                if (json.charAt(j) == ',' || json.charAt(j) == '{')
                    break;
                j++;
            }

            if (j >= json.length())
                value = json.substring(i + 1);
            else
                value = json.substring(i + 1, j);

            System.out.println("i: " + i + ", value: " + value);

            i = j;

        }
        return "";
    }
}
