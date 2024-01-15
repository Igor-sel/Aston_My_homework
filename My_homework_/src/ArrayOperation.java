import java.io.*;
import java.util.*;

public class ArrayOperation { //  List<String[]> lines = new ArrayList<String[]>();    //
    public static List<String> fillTheArray(List<String> array) { // Здесь сделать ArrayList вместо обычного List"a  //
        array.add("beer");
        array.add("beer");
        array.add("lemonade");
        array.add("cola");
        array.add("Pepsi");
        array.add("Lemonade");
        array.add("water");
        array.add("lemonade");
        array.add("Pepsi");
        array.add("cola");
        array.add("juice");
        array.add("juice");
        return array;
    }

    public static void printUniqueWords(List<String> array) {
        Set<String> tempArray = new HashSet<>();
        for (String arr : array) {
            String a = arr.toLowerCase();
            tempArray.add(a);
        }
        for (String tempArr : tempArray) {
            int count = 0;
            for (String arr : array) {
                String a = arr.toLowerCase();
                if(tempArr.equals(a)) count++;
            }
            System.out.println("\"" + tempArr + "\"" + " repeated in the list = " + count);
        }
        System.out.println();
    }
}
