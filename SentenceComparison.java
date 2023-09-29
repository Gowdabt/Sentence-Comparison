import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Harshith Gowda B T
 * @Date 9/29/2023
 */
public class SentenceComparison {
    public static void main(String[] args) {
        String filePath = "sentences.txt";
        List<String> sentences = readSentences(filePath);

        if (sentences.size() > 1) {
            groupSentencesWithDiff(sentences);
        } else {
            System.out.println("No Data in file");
        }
    }

    public static List<String> readSentences(String filePath) {
        List<String> sentences = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sentences.add(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return sentences;
    }

    public static void groupSentencesWithDiff(List<String> sentences) {
        Map<String, List<String>> sentenceGroups = new HashMap<>();
        for (String sentence : sentences) {
            String[] words = sentence.split("\\s+");
            if (words.length < 3) {
                continue;
            }
            for (int i = 2; i < words.length; i++) {
                StringBuilder keyBuilder = new StringBuilder();

                for (int j = 2; j < words.length; j++) {
                    if (i == j) {
                        keyBuilder.append("* ");
                    } else {
                        keyBuilder.append(words[j]).append(" ");
                    }
                }
                String key = keyBuilder.toString().trim();

                sentenceGroups.computeIfAbsent(key, k -> new ArrayList<>()).add(sentence);

            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            sentenceGroups.forEach((k,v)->{
                if (v.size() > 1) {
                    List<String> words=new ArrayList<>();
                    String[] arr =k.split("\\*");
                    for (String sentence : v) {
                        String temp=sentence;
                        temp=temp.replace(arr[0],"");
                        if(arr.length>1){
                            temp=temp.replace(arr[1],"").trim();
                        }else{
                            temp=temp.trim();
                        }
                        try {
                            writer.write(sentence);
							writer.newLine();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        //System.out.println(sentence);
                        words.add(temp.split(" ")[2]);
                    }
                    //System.out.println("The changing word was:"+ words);
                    try {
                        writer.write("The changing word was:"+ words);
						writer.newLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (Exception e) {
            System.err.println("Error writing to output file: " + e.getMessage());
        }



    }
}
