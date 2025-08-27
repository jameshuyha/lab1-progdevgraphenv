// Git Repo Link: https://github.com/jameshuyha/lab1-progdevgraphenv.git

package vaniergraphenv.lab1_hjvh;


/**
 *
 * @author 6324151
 */
public class ZipCode {
    public int Zip;
    static private String barCode;
    
    public ZipCode(int zipCode) {
        if (zipCode > 99999) {
            System.out.println("Error: " + zipCode + " is more than 5 digits.");
        }
        
        this.Zip = zipCode;
    }
    
    public ZipCode(String barCode) {
        this.barCode = barCode;
        
        if (barCode.length() != 27) {
            System.out.println("Error: bar code must be in multiples of 5-binary digits.");
            Zip = 0;
            return;
        }
        
        if (barCode.charAt(0) != '1' || barCode.charAt(26) != '1') {
            System.out.println("Error: bar code missing a 1 at start or end.");
            Zip = 0;
            return;
        }
        
        boolean valid = true;
        
        for (int i = 0; i < barCode.length(); i++) {
            if (barCode.charAt(i) != '0' && barCode.charAt(i) != '1'){
                System.out.println("bar code character: " + barCode.charAt(i) + " must be '0' or '1'.");
                valid = false;
            }
        }
        
        if (!valid) {
            Zip = 0;
            return;
        }
        
        int zeroCount = 0;
        int oneCount = 0;
        
        for (int i = 1; i < 26; i += 5) {
            String segment = barCode.substring(i, i + 5);
            for (int j = 0; i < 5; i++) {
                if (segment.charAt(j) == '0') {
                    zeroCount++;
                }
                
                if(segment.charAt(j) == '1') {
                    oneCount++;
                }
            }
            
            if (zeroCount != 3 && oneCount != 2) {
                System.out.println(segment + " has invalid sequence in the bar code.");
                valid = false;
            }
        }
        
        if (!valid) {
            Zip = 0;
            return;
        }
        
        this.Zip = parseBarCode();
    }
    
    public String GetBarCode() {
        String zipString = String.valueOf(Zip); 
        String barCode = "1";
        String zipFive = "";
        
        if (Zip < 0) {
            System.out.println("Error: Invalid Zip Code.");
        }
        
        if (zipString.length() < 5) {
            for (int i = zipString.length(); i < 5; i++) {
                barCode += "11000";
            }
        }
        
        if (zipString.length() > 5) {
            zipFive += zipString.substring(1);
        } else {
            zipFive += zipString;
        }
        
        for (int i = 0; i < zipFive.length(); i++) {
            switch(zipFive.charAt(i)) {

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
 