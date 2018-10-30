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
public class Fano {
    /**Fano算法 
     *  
     * 1.信源符号按概率递减的方式排列 
     * 2.将排列好的符号分成两组，使每组的概率之和接近相等并对赋于0和1 
     * 3.将每一大组再分组，同2 
     * 4.依次下去，直到只剩一个信源符号 
     * 5.信源符号所对应的码字即为费诺码 
     */  
    Data data;//符号集  
    double prob;//概率  
    int codelength;//码长  
    /*费诺码的实现*/  
    public List isFano(List list){  
        double[] arr = new double[list.size()];  
        for(int i = 0;i < list.size();i++){  
            data = (Data)list.get(i);//得到每一个符号  
            prob = data.getProb();//取出符号概率  
            arr[i] = prob;//将概率存放在一个数组中  
        }  
        String[] codeword = getGroup(arr,0,arr.length-1);//符号编码  
        for(int i = 0; i < codeword.length; i++){  
            data = (Data)list.get(i);//得到每一个符号  
            data.setCodeword(codeword[i]);//加上码字  
            data.setCodeLength(codeword[i].length());//加上码长  
            list.set(i, data);//加上符号  
        }  
          
          
        return list;//返回改变的列表  
    }  
    /*用分组法求出符号的编码*/  
    public static  String[] getGroup(double[] a,int i,int j){  
  
        String[] p = new String[a.length]; //返回的字符编码  
        for(int t = 0; t < a.length; t++){  
            p[t] = "";//初始化  
        }  
        int flag = 0;//分组间隔点  
        if(i < j){  
            //采用递归法,将数组分为两半  
            double sum = 10;//比较中间量  
            for(int k = i; k <= j; k++){  
                //取累和间距最小量  
                if(Math.abs(sumGroup(a,i,k)-sumGroup(a, k+1, j)) < sum){  
                    //以flag为中间点,分别累加左边和右边,然后比较  
                    sum=Math.abs(sumGroup(a,i,k)-sumGroup(a, k+1, j));  
                    flag = k;//取出中间点  
                }  
            }  
            String[] p1 = getGroup(a, i, flag);//递归第一组(左边)  
            String[] p2 = getGroup(a, flag+1, j);//递归第二组(右边)  
            for(int m = i; m <= flag; m++){  
                p[m] = "0" + p1[m];//第一组赋值0  
            }  
                for(int m = flag+1; m <= j; m++){  
                    p[m] = "1" + p2[m];//第二组赋值1  
                }  
        }  
          
        return p;//得到分组后的码字  
    }  
    /*求数组第i位到第j位的和*/  
    public static double sumGroup(double[] a, int i, int j ){  
        double total = 0;  
        for(int k = i; k <= j; k++){  
            total = total + a[k];  
        }  
        return total;  
    }  
}
