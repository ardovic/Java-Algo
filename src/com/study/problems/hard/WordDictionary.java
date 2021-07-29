package com.study.problems.hard;

import java.util.HashMap;
import java.util.Map;

class WordDictionary {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return false
        System.out.println(wordDictionary.search("bad")); // return true
        System.out.println(wordDictionary.search(".ad")); // return true
        System.out.println(wordDictionary.search("b..")); // return true
    }

    public Node node; // TrieNode

    public WordDictionary() {
        node = new Node();
    }

    public static class Node {
        HashMap<Character, Node> map;
        boolean word = false;

        public Node() {
            map = new HashMap<>();
        }
    }

    public void addWord(String word) {

        Node n = node;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!n.map.containsKey(c)) {
                Node newNode = new Node();
                n.map.put(c, newNode);
                n = newNode;
            } else {
                n = n.map.get(c);
            }

            if (i == word.length() - 1) {
                n.word = true;
            }
        }
    }

    public boolean search(String word) {
        return searchInTrie(word, node);
    }

    public boolean searchInTrie(String word, Node n) {
        char c = word.charAt(0);

        if (c == '.') {
            for (Map.Entry<Character, Node> entry : n.map.entrySet()) {
                Node nextNode = entry.getValue();
                if (word.length() == 1) {
                    if (nextNode.word) {
                        return true;
                    }
                } else {
                    if (searchInTrie(word.substring(1), nextNode)) {
                        return true;
                    }
                }
            }
            return false;
        } else if (!n.map.containsKey(c)) {
            return false;
        } else {
            Node nextNode = n.map.get(c);
            if (word.length() == 1) {
                return nextNode.word;
            } else {
                return searchInTrie(word.substring(1), nextNode);
            }
        }
    }
}
