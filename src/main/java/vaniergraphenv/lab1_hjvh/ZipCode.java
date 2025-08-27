/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaniergraphenv.lab1_hjvh;


/**
 *
 * @author 6324151
 */
public class ZipCode {
    public int Zip;
    static private String barCode;
    
    public ZipCode(int zipCode) {
        if (zipCode < 0 || zipCode > 99999) {
            System.out.println("Error: Zip Code invalid format.");
        }
        
        this.Zip = zipCode;
    }
    
    public ZipCode(String barCode) {
        this.barCode = barCode;
        this.Zip = parseBarCode();
    }
    
    public String GetBarCode() {
        String zipString = String.valueOf(Zip); 
        String barCode = "1";
        
        if (Zip < 0) {
            System.out.println("Error: Invalid Zip Code.");
        }
        
        if (zipString.length() < 5) {
            for (int i = zipString.length(); i < 5; i++) {
                barCode += "11000";
            }
        }
        
        for (int i = 0; i < zipString.length(); i++) {
            switch(String.valueOf(Zip).charAt(i)) {

                case '0' -> barCode += "11000";
                case '1' -> barCode += "00011";
                case '2' -> barCode += "00101";
                case '3' -> barCode += "00110";
                case '4' -> barCode += "01001";
                case '5' -> barCode += "01010";
                case '6' -> barCode += "01100";
                case '7' -> barCode += "10001";
                case '8' -> barCode += "10010";
                case '9' -> barCode += "10100";
            }
        }
        
        barCode += "1";
        
        return barCode;
    }
    
    private static int parseBarCode() {
        if (barCode.length() != 27 || barCode.charAt(0) != '1' || barCode.charAt(26) != '1') {
            System.out.println("Error: Invalid barcode format.");
            return 0;
        }
        
        String zipFromBar = "";
        
        for (int i = 1; i < 26; i += 5) {
            String segment = barCode.substring(i, i + 5);
            switch(segment) {
                case "11000" -> zipFromBar += "0";
                case "00011" -> zipFromBar += "1";
                case "00101" -> zipFromBar += "2";
                case "00110" -> zipFromBar += "3";
                case "01001" -> zipFromBar += "4";
                case "01010" -> zipFromBar += "5";
                case "01100" -> zipFromBar += "6";
                case "10001" -> zipFromBar += "7";
                case "10010" -> zipFromBar += "8";
                case "10100" -> zipFromBar += "9";
            }
        }
        
        return Integer.parseInt(zipFromBar);
    }
}
 