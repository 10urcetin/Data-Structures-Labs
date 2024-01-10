//Huffman Coding
//Compare Algorithm https://tr.wikipedia.org/wiki/Huffman_kodu
//Using hashmap

import java.util.HashMap;
//import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {


    }
    public static HashMap<Character,Integer> findFrequency(String str){

        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            if (frequencyMap.containsKey(c)){

                frequencyMap.put(c,frequencyMap.get(c)+1); //varsa 1 arttırıcak frekkansı

            }else {
                frequencyMap.put(c,1); //yoksa 1 olarak kaydedicek
            }

        }

        return frequencyMap;
    }
    class HuffmanNode implements Comparable<HuffmanNode>{
        private char character;
        private int frequency;
        private HuffmanNode left;
        private HuffmanNode right;

        public HuffmanNode(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }
        @Override
        public int compareTo(HuffmanNode otherNode) {
            return this.character-otherNode.character;
        }
        public char getCharacter() {
            return character;
        }

        public void setCharacter(char character) {
            this.character = character;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        public HuffmanNode getLeft() {
            return left;
        }

        public void setLeft(HuffmanNode left) {
            this.left = left;
        }

        public HuffmanNode getRight() {
            return right;
        }

        public void setRight(HuffmanNode right) {
            this.right = right;
        }
    }

}


