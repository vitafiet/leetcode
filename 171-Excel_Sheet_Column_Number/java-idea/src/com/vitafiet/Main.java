package com.vitafiet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class Main {

    public static void main(String[] args)
            throws java.io.FileNotFoundException, java.io.IOException
    {
        Solution s = new Solution();
        Solution2 s2 = new Solution2();

        long startTime = 0;
        long endTime = 0;

        String propertiesFileName = "testData";


//        Properties props = new Properties();
//        props.put("Input1", "A");
//        props.put("Input2", "AB");
//        props.put("Input3", "ZY");
//        FileOutputStream out = new FileOutputStream(propertiesFileName);
//        props.store(out, "---No Comment---");
//        out.close();

        Properties propRead = new Properties();
        FileInputStream in = new FileInputStream(propertiesFileName);
        propRead.load(in);

        for(Object key : propRead.keySet()) {
            String input = key.toString();
            String val = (propRead.get(key)).toString();
            System.out.println(input + " : " + val);

            startTime = System.nanoTime();
            System.out.print("Output:" + s.titleToNumber(val));
            endTime = System.nanoTime();
            System.out.println(" Time:" + (endTime-startTime)/1000 + "ns");

            startTime = System.nanoTime();
            System.out.print("Output2:" + s2.titleToNumber(val));
            endTime = System.nanoTime();
            System.out.println(" Time:" + (endTime-startTime)/1000 + "ns");
        }

        in.close();
    }

    public static String arrayToStr(int[] arr){
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s = s + arr[i];
            if (i < arr.length -1) s = s + ",";
        }
        return s;
    }

    public static int[] strToArray(String s){
        String[] sList = s.split(",");
        int[] arr = new int[sList.length];

        int i=0;
        for(String str : sList)
            arr[i++] = Integer.parseInt(str);

        return arr;
    }
}
