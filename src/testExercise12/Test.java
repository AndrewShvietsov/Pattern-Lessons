package testExercise12;

import java.io.IOException;
import java.util.*;

public class Test {
    @Test @Disabled
    public void nestedMaps() throws IOException {
        List<String> words = new ArrayList<>();
        reader.lines()
                .forEach(x -> {
                    String [] strings = x.split("\\s+|,");
                    words.addAll(Arrays.asList(strings));
                });
        Map<Character, Map<Integer, List<String>>> map = new HashMap<>();
        for (String string : words) {
            if (string.trim().length() == 0) {
                continue;
            }
            Character letter = new Character(string.charAt(0)).toString().toLowerCase().charAt(0);
            if (map.get(letter) == null) {
                map.put(letter, new HashMap<>());
                List<String> list = new ArrayList<>();
                list.add(string);
                map.get(letter).put(string.length(), list);
            } else {
                Map<Integer, List<String>> map1 = map.get(letter);
                if (map1.get(string.length()) == null) {
                    List<String> list2 = new ArrayList<>();
                    list2.add(string);
                    map1.put(string.length(), list2);
                } else {
                    String alternative1 = string.substring(0, 1).toLowerCase() + string.substring(1);
                    String alternative2 = string.substring(0, 1).toUpperCase() + string.substring(1);
                    if (!(map1.get(string.length()).contains(alternative1) || map1.get(string.length()).contains(alternative2))) {
                        map1.get(string.length()).add(string);
                    }
                }
            }
        }
        System.out.println(map);
}
