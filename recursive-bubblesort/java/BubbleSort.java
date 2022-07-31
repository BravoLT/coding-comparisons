import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class BubbleSort {

    public static void main(final String[] args){
        // parse the arguments
        final String filename = parseArgs(args);

        // extract file content from the filename
        final String[] input = readFile(filename);

        // sort the file content with a recursive bubble sort algorithm
        bubbleSort(input, input.length);

        // tally the sorted file content to replace duplicates with number of occurrences
        final Map<String, Integer> result = tallyWords(input);

        // print the sorted and tallied result
        System.out.println(result);
    }

    private static void bubbleSort(final String[] data, final int length){
        if(length == 1){
            return;
        }

        int count = 0;
        for(int i = 0; i < length - 1; i++){
            final String curVal = data[i];
            final String nxtVal = data[i + 1];

            if(Comparator.comparing(String::toString).compare(curVal, nxtVal) > 0){
                data[i] = nxtVal;
                data[i + 1] = curVal;
                count = count + 1;
            }
        }
        if(count == 0){
            return;
        }
        bubbleSort(data, length - 1);
    }

    private static String parseArgs(final String[] args){
        if(args.length != 1){
            throw new IllegalArgumentException("expected 'args.length' to be 1");
        }
        return args[0];
    }

    private static String[] readFile(final String filename){
        try {
            return Files.readAllLines(Paths.get(filename)).toArray(new String[0]);

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static Map<String, Integer> tallyWords(final String[] data){
        final Map<String, Integer> dataMap = new LinkedHashMap<>();
        for(String s : data){
            int curVal = dataMap.getOrDefault(s, 0);
            dataMap.put(s, curVal + 1);
        }
        return dataMap;
    }
}
