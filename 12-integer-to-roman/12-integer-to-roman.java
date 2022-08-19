class Solution {
   public static String intToRoman(int num) {
        String romanNumber = "";
        while (true) {
            if (num <= 5) {
                if (num == 5) {
                    romanNumber = romanNumber + "V";
                    break;
                } else if (num == 4) {
                    romanNumber = romanNumber + "IV";
                    break;
                } else if (num == 3) {
                    romanNumber = romanNumber + "III";
                    break;
                } else if (num == 2) {
                    romanNumber = romanNumber + "II";
                    break;
                } else if (num == 1) {
                    romanNumber = romanNumber + "I";
                    break;
                }
                else{
                    break;
                }
            } else if (num <= 10) {
                if (num == 10) {
                    romanNumber = romanNumber + "X";
                    break;
                } else if (num == 9) {
                    romanNumber = romanNumber + "IX";
                    break;
                } else {
                    num = num - 5;
                    romanNumber = romanNumber + "V";
                }
            }else if(num <= 50){
                if (num == 50) {
                    romanNumber = romanNumber + "L";
                    break;
                } else if (num == 40) {
                    romanNumber = romanNumber + "XL";
                    break;
                }else if(num > 40){
                    num = num - 40;
                    romanNumber = romanNumber + "XL";
                }
                else{
                    num = num - 10;
                    romanNumber = romanNumber + "X";
                }
            }
            else if(num <= 100){
                if (num == 100) {
                    romanNumber = romanNumber + "C";
                    break;
                } else if (num == 90) {
                    romanNumber = romanNumber + "XC";
                    break;
                }else if(num > 90){
                    num = num - 90;
                    romanNumber = romanNumber + "XC";
                }else{
                    num = num - 50;
                    romanNumber = romanNumber + "L";
                }
            }else if(num <= 500){
                if (num == 500) {
                    romanNumber = romanNumber + "D";
                    break;
                } else if (num == 400) {
                    romanNumber = romanNumber + "CD";
                    break;
                }else if(num > 400){
                    num = num - 400;
                    romanNumber = romanNumber + "CD";
                }else{
                    num = num - 100;
                    romanNumber = romanNumber + "C";
                }
            }else{
                if(num == 1000){
                    romanNumber = romanNumber + "M";
                    break;
                }else if (num == 900) {
                    romanNumber = romanNumber + "CM";
                    break;
                }else if(num > 900 && num < 1000){
                    num = num - 900;
                    romanNumber = romanNumber + "CM";
                } else if(num < 1000){
                    num = num - 500;
                    romanNumber = romanNumber + "D";
                }else{
                    num = num - 1000;
                    romanNumber = romanNumber + "M";
                }
            }
        }
        return romanNumber;
   }
}