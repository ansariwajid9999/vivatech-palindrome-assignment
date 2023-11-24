package com.example.Assign;

// PalindromeController.java

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PalindromeController {

    private int wrongInputCount = 0;

    @PostMapping("/submit")
    public String submit(@RequestBody Request request) {
        String t = request.getStr();
        if (wrongInputCount >= 2) {
            return "No more input allowed.";
        }

        if (isPalindrome(t)) {
            wrongInputCount = 0;
            Map<Character, Integer> frequencyMap = generateFrequencyMap(t);
            HashMap<Character,Integer> map1 = new HashMap<>();
            for(char ch : t.toCharArray()){
                map1.put(ch,map1.getOrDefault(ch,0)+1);
            }

            for(Map.Entry<Character, Integer> entry :map1.entrySet()){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
            return "Palindrome! Now we can write into xlsx.";
        } else {
            wrongInputCount++;
            return "Not a palindrome. Attempts left: " + (2 - wrongInputCount);
        }
    }

    private boolean isPalindrome(String str) {
        char[] arr = str.toCharArray();
        int i = 0;
        int j = arr.length - 1;

        while(i < j){
            if(arr[i] != arr[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private Map<Character, Integer> generateFrequencyMap(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }

}

