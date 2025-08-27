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
    private int zipInt;
    
    public ZipCode(String zipCode) {
        if (zipCode.length() > 5) {
            System.out.println("Error: Zip Code has more than five digits.");
        }
        
        this.zipInt = zipInt;
    }
    
    public ZipCode() {
        
    }
    
    public String getBarCode() {
        String zipString = String.valueOf(zipInt); 
        String barCode = "1";
        
        if (zipString.length() < 5) {
            for (int i = zipString.length(); i == 5; i++) {
                barCode += "11000";
            }
        }
        
        for (int i = 4; i >= 0; i--) {
            switch(String.valueOf(zipInt).charAt(i)) {
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
    
    private static int parseBarCode(String barCode) {
        if (barCode.length() != 27) {
           System.out.println("Error: Bar Code is not conventional 27 digits.");
           return 0;
        }
        
        String barCodeReduced = barCode.substring(1, barCode.length());
        
        for (int i = 5; i > 0; i--) {
            String barDigit = 
            switch(barCodeReduced.charAt(i)) {
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
    }
}
 