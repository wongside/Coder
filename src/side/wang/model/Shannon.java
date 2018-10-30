/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package side.wang.model;
import java.util.List;
/**
 *
 * @author Side
 */
public class Shannon {
    /**Shannon算法 
     *  
     * 1.符号按概率递减的方式排列 
     * 2.计算每一个符号的码长l 
     * 3.计算累加概率 
     * 4.将累加概率用二进制表示 
     * 5.取小数点后l位为信源符号的二进制码字 
     *  
     */  
    double cumu = 0;//累加概率  
    Data data;//符号集  
    double prob;//概率  
    int codelength;//码长  
//  List list = new ArrayList();  
      
    /*累加概率的二进制转换*/  
    public static String getBinary(double cumu,int length){  
          
        String  codeword = "";  
        for(int i = 0; i < length; i++){  
            cumu *= 2;//小数转化二进制乘以2  
            if(cumu >= 1){  
                cumu -= 1;  
                codeword += 1;//大于1取1  
            }else{  
                codeword += 0;//小于1取0  
            }  
        }  
        return codeword;  
    }  
    /*实现香农编码*/  
    public List isShannon(List list){  
        for(int i = 0;i < list.size();i++){  
            data = (Data)list.get(i);//得到每一个符号  
            prob = data.getProb();//取出符号概率  
            codelength =(int)Math.ceil(Math.log(1/prob)/Math.log((double)2));//计算码长  
            data.setCodeLength(codelength);//添加码长  
            data.setCodeword(getBinary(cumu, codelength));//添加码字  
            list.set(i, data);//改变符号列表信息  
            cumu += prob;//累加概率  
        }  
        return list;  
    }  
}
