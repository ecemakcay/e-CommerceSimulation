package util;

import java.util.Random;

public class Code {

    int  code;

    public  String codeMaker() {
        int[] values = {0,1,2,3,4,5,6,7,8,9};
        Random rnd = new Random();

        for (int i = 0; i < 6; i++){
           code = rnd.nextInt(values.length);
        }
        return String.valueOf(code);
    }







}
