package lesson31.homework;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Solution <T> {



    public LinkedHashMap<T, Integer> countSymbols(String text) {
        if (text == null || text.isEmpty())
            return null;
        char[] chars = text.toCharArray();

        LinkedHashMap<T, Integer> res = new LinkedHashMap<>();


        for (Character letter : chars) {
            if (letter == ' ') {
                continue;
            }

            res = add(res, (T) letter);
        }

        return res;


    }


    public LinkedHashMap<T, Integer> words (String text){
        if (text == null || text.isEmpty())
            return null;

        String[] words = text.split(" ");
        LinkedHashMap<T, Integer> res = new LinkedHashMap<>();


        for (String word : words) {
            if (word.length() <= 2) {
                continue;
            }

            res = add(res ,(T) word);
        }
        return res;
    }

    private LinkedHashMap<T, Integer> add(LinkedHashMap<T, Integer> res, T t){
        //LinkedHashMap<T, Integer> res = new LinkedHashMap<>();
        if (!res.keySet().contains(t)){
            res.put(t, 1);
        }
        else {
            int count = res.get(t);
            res.put(t, ++count);
        }
        return res;
    }

    }
