package org.free13.rubik.mem;

import java.util.*;

/**
 * Generate by Tongyiqianwen
 */
public class WordGraph {
    private Map<String, Node> wordMap;
    private String[][] graph;

    public WordGraph(int size) {
        this.wordMap = new HashMap<>();
        this.graph = new String[size][size];
    }

    // 定义节点类，用于存储单词及其在数组中的位置
    static class Node {
        String word;
        int position;

        Node(String word, int position) {
            this.word = word;
            this.position = position;
        }
    }

    // 1. 存储单词到空闲位置或返回已存在单词的下标
    public int putWord(String word) {
        if (wordMap.containsKey(word)) {
            return wordMap.get(word).position;
        } else {
            // 这里假设我们能找到一个空闲的位置，真实场景中可能需要更复杂的逻辑来管理空闲位置
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    if (graph[i][j] == null) {
                        graph[i][j] = word;
                        wordMap.put(word, new Node(word, i * graph.length + j));
                        return i * graph.length + j;
                    }
                }
            }
            throw new IllegalStateException("No space left in the graph.");
        }
    }

    // 2. 存储一组单词并按顺序记录连接关系
    public void putWords(List<String> words) {
        int prevPos = -1;
        for (String word : words) {
            int curPos = putWord(word);
            if (prevPos != -1) {
                // 假设位置是线性连续的，真实场景可能需要更复杂的方式来记录连接关系
                graph[prevPos / graph.length][prevPos % graph.length] = String.valueOf(curPos);
            }
            prevPos = curPos;
        }
    }

    // 3. 根据字符串返回包含的单词数组
    public List<String> getWordsFromString(String input) {
        List<String> result = new ArrayList<>();
        String[] words = input.split("\\s+");
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                result.add(word);
            }
        }
        return result;
    }
}