package side.wang.model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

/**
 *
 * @author Side
 */
public class Coder {
    public static String [] shannon(File file){
        String result[] = {};
        return result;
    }
    public static String [] fano(File file){
        String result[] = {};
        return result;
    }
    public static String [] huffman(File file){
        String result[] = {};
        
        return result;
    }
    private static int [] statistics(File file){
        int result [] = new int[26];
        char [] buffer = new char[100];
        try {
            Reader in = new FileReader(file);
            int n;
            while((n = in.read(buffer)) != -1){
                for(int i = 0; i < n; i++){
                    if(Character.isLetter(buffer[i])){
                        result[buffer[i]-'a']++;
                    }
                }
            }            
        } catch (IOException ex) {
            System.out.println("文件异常:\n" + ex.toString());
        }
        Arrays.sort(result);
        int tmp;
        for(int i = 0; i < 13; i++){
            tmp = result[i];
            result[i] = result[25-i];
            result[25-i] = tmp;
        }      
        for(int i : result){
            System.out.println(i);
        }
        return result;
    }
}
