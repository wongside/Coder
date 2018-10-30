package side.wang.model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.*;
import java.util.Map.Entry;

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
    
    public static List getData(File file){
        Map map = new HashMap<>();
        int sum = 0;
        char [] buffer = new char[100];
        try {
            Reader in = new FileReader(file);
            int n;
            while((n = in.read(buffer)) != -1){
                for(int i = 0; i < n; i++){
                    if(!Character.isWhitespace(buffer[i])){
                        sum++;
                        Integer tmp = (Integer)map.get(buffer[i]);
                        if(tmp != null){
                            tmp++;
                            map.put(buffer[i], tmp);
                        }else{
                            map.put(buffer[i], 1);
                        }
                    }
                }
            } 
        } catch (IOException ex) {
            System.out.println("文件异常:\n" + ex.toString());
        }
        List list = new ArrayList();
        Iterator<Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
                Entry<Character, Integer> entry = iterator.next();
                Character key = entry.getKey();
                Integer value = entry.getValue();
                double prob = value * 1.0 / sum;
                Data data = new Data(key, prob);
                list.add(data);
        }
        Collections.sort(list, (Object o1, Object o2) -> {
            Data d1 = (Data)o1;
            Data d2 = (Data)o2;
            int t = d2.getProb().compareTo(d1.getProb());
            return t;
        });
        
//        System.out.println(sum);
//        double tmp = 0.0 ;
//        for(int i = 0; i < list.size(); i++){
//            System.out.println(((Data)list.get(i)).toString());
//            tmp += ((Data)list.get(i)).getProb();
//        }
//        System.out.println(tmp);
        
        return list;
    }   
}
