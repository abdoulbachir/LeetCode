package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoubleAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> ans = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String word = new String(chars);

            if (!ans.containsKey(word)) {
                ans.put(word, new ArrayList<>());
            }

            ans.get(word).add(strs[i]);
            System.out.println(ans);
        }

        return new ArrayList<>(ans.values());
    }

    public static void main(String[] args) {
        DoubleAnagram c = new DoubleAnagram();

        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(c.groupAnagrams(words));

    }
}

