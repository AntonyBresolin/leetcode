package org.example;

public class cump {
    public static void main(String[] args) {
        String s = "abcd";

        String response = getStringBuilder(s);
        System.out.println(response);
    }

    private static String getStringBuilder(String s) {
        StringBuilder response = new StringBuilder();
        int counter = 1;

        int size = s.length();

        for (int i =0; i < size; i++) {
            if(i+1 !=size && s.charAt(i) == s.charAt(i+1)){
                counter++;
                continue;
            }
            response.append(s.charAt(i));
            response.append(counter != 1 ? counter :"");
            counter =1;
        }
        return response.toString();
    }
}
