import java.lang.String;
import java.util.*;

public class Main {
    public static void main(String[] args) {

//        String number = "MCMXCIV";
//        int value = romanToInt(number);
//        String[] theStrings = {"flower","flow","flight"};
//        String value = longestCommonPrefix(theStrings);
//        LinkedList<Integer> l1 = new LinkedList<>(List.of(9,9,9,9,9,9,9));
//        LinkedList<Integer> l2 = new LinkedList<>(List.of(9,9,9,9));
//        LinkedList<Integer> result = addTwoNumbers(l1, l2);
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
        int[] nums={1,3,8,11,15,16,19,22,65,72,81,98};

        System.out.println(Arrays.binarySearch(nums, 3));
        System.out.println(findInteger(nums, 98));
    }

    private static int romanToInt(String s) {

        int total = 0;
        Map<Character, Integer> lookup = new HashMap<>();
        lookup.put('I', 1);
        lookup.put('V', 5);
        lookup.put('X', 10);
        lookup.put('L', 50);
        lookup.put('C', 100);
        lookup.put('D', 500);
        lookup.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            int curr = lookup.get(s.charAt(i));
            System.out.println("Current Before: "+curr);
            if (i + 1 < s.length() && curr < lookup.get(s.charAt(i + 1))) {
                total -= curr;
                System.out.println("Current After1: "+curr+" Total: "+total);
            } else {
                total += curr;
                System.out.println("Current After 2: "+curr+" Total: "+total);
            }
        }
        return total;
    }

    public static String longestCommonPrefix(String[] strs) {

        int index=0;
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];

        for(int i=0; i<s1.length(); i++){
            if (s1.charAt(i) == s2.charAt(i)) {
                index++;
            }else {
                break;
            }
        }
        return s1.substring(0,index);
    }
    public static LinkedList<Integer>  addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer>  l2) {
        LinkedList<Integer> newArray = new LinkedList<>();
        int sum, v1, v2, firstDigit=0;

        for (int i = 0; i <= Math.max(l1.size(), l2.size()); i++) {
            v1 = i < l1.size() ? l1.get(i) : 0;
            v2 = i < l2.size() ? l2.get(i) : 0;

            sum = firstDigit + v1 + v2;
            firstDigit = sum/10;
            newArray.add(sum%10);
        }
        return newArray;
    }

    public static int countSubstrings(String s) {
        int count=0;
        StringBuilder theSubstring= new StringBuilder();
        while(count <= s.length()){
            for (int i = 0; i <s.length(); i++) {
                if (s.charAt(i) == s.charAt(s.length() - 1)){
                    theSubstring.append(s.charAt(i));
                }else {
                    theSubstring.delete(0, theSubstring.length());
                }
                i++;
            }
        }
        return count;
    }


    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(); // Length of the String
        int maxLength = 0; // Max Length
        int[] charIndex = new int[128]; // Characters Index
        Arrays.fill(charIndex, -1);
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (charIndex[s.charAt(right)] >= left) {
                left = charIndex[s.charAt(right)] + 1;
            }
            charIndex[s.charAt(right)] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;

    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer>[] freq = new ArrayList[nums.length+1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] result=new int[k];
        int index=0;

        for(int i = freq.length-1; i > 0 ; i--){
            for(int n : freq[i]){
                result[index++]=n;
                if (index == k)
                    return result;
            }
        }
        return result;
    }


    public static int findInteger(int[] nums, int k) {

        int start = 0;
        int end = nums.length-1;

        while (start <= end){
            int mid = start + (end - start)/2;

            if (nums[mid] == k){
                return mid;
            }

            if(k > nums[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }

        return -1;
    }


}
