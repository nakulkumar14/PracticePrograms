package com.strings;

// https://www.geeksforgeeks.org/trie-insert-and-search/

class TrieNode {
    TrieNode child[] = new TrieNode[26];
    boolean end;
}

public class TrieDS {

    static TrieNode trieNode = new TrieNode();

    static void insert(String key) {
        TrieNode temp = trieNode;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (temp.child[index] == null) {
                temp.child[index] = new TrieNode();
            }
            temp = temp.child[index];
        }
        temp.end = true;
    }

    static boolean search(String key) {
        TrieNode temp = trieNode;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (temp.child[index] == null) {
                return false;
            }
            temp = temp.child[index];
        }

        System.out.println(key + " " + temp.end);
        return temp.end;
    }

    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        for (String key : keys) {
            insert(key);
        }

        search("the");
        search("these");
        search("their");
        search("thaw");
        search("bye");

    }
}
