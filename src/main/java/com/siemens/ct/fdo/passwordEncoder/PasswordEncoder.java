package com.siemens.ct.fdo.passwordEncoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.*;
import java.util.HashMap;

public class PasswordEncoder {

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static void main(String[] args) throws IOException {
        String filePath = "./passwd.txt";
        HashMap<String, String> map = new HashMap<>();
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                map.put(key, value);
            } else {
                System.out.println("ignoring line: " + line);
            }
        }


        new File("./out.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter("./out.txt"));
        for (String key : map.keySet()) {
            writer.write(key + " : " + passwordEncoder.encode(map.get(key)));
            writer.newLine();
        }
        writer.close();
        reader.close();
    }
}
