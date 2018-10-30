/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package side.wang.model;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Side
 */
public class Huffman {
    /**Huffman算法 
     *  
     * 1.信源符号按概率递减的方式排列 
     * 2.用0、1分别表示最小的两个符号，将这两个符号合并成一个新的符号，从而得到一个新信源 
     * 3.将新信源重排列，再取最后两位最小的分别用0、1表示，并合并，得到一个缩减信源 
     * 4.重复步骤3，直到只有两符号为止，将这两个符号分别用0、1表示 
     * 5.从最后一级缩减信源开始向前返回，反向列出所编码元，得到各信源符号的码字 
     * @param l
     */  
    /*霍夫曼的实现*/  
    public void isHuffman(List l){  
        List list = new ArrayList();//新建一个表  
        list.addAll(l);//复制  
        for(int i = list.size()-1; i >=0 ; i--){  
            double d = ((Data)list.get(i)).getProb();//得到概率  
            TreeNode root = new TreeNode(d);//将概率作为根结点  
            list.remove(i);//移除最后一项  
            list.add(i, root);//将结点添加到最后一项  
        }  
        createTree(list);//创建树  
        TreeNode root = (TreeNode)list.get(0);//得到最终树的根结点  
        list.clear();//清空列表  
        printTree(root,list);//根据树的叶子得到码字、码长  
        for(int i = 0; i < list.size(); i ++){  
            Data data = new Data();  
            data.setSymbol(((Data)l.get(i)).getSymbol());//取出符号  
            data.setProb(((Data)l.get(i)).getProb());//取出概率  
            data.setCodeLength(((Data)list.get(i)).getCodeLength());//取出码长  
            data.setCodeword(((Data)list.get(i)).getCodeword());//取出码字  
            l.set(i, data);//将新得的Data对象加到列表  
            System.out.println(data.toString());
        }  
        
    }  
    //创建树  
    public static void createTree(List list){  
        double d1 = ((TreeNode)list.get(list.size()-1)).data;//取出倒数第一个  
        double d2 = ((TreeNode)list.get(list.size()-2)).data;//取出倒数第二个  
        double cumu = d1 + d2;//最小两个相加  
        TreeNode root = new TreeNode(cumu);//将和作为树根结点  
        root.left = (TreeNode)list.get(list.size()-1);//将倒数第一个作为左孩子  
        root.right = (TreeNode)list.get(list.size()-2);//将倒数第二个作为右孩子  
        list.remove(list.size()-1);//移除最后二个  
        list.remove(list.size()-1);  
        sortList(list, root);//将根结点加到列表,并排序  
        if(list.size() > 1){  
            createTree(list);//只要list大于1时就递归创建树  
        }else{  
              
        }  
    }  
    //将树转为码字  

    public static void printTree(TreeNode root,List list){  
        Data data = new Data();  
        if(root.left != null){  
            root.left.codeword = root.codeword + "0";//左孩子加0  
            printTree(root.left,list);//遍历左孩子  
        }  
        if(root.right != null){  
            root.right.codeword = root.codeword  + "1";//右孩子加1  
            printTree(root.right,list);//遍历右孩子  
        }  
        //如果是树的叶子,刚将其作为对应的码字  
        if(root.left == null && root.right == null){  
            data.setProb(root.data);//概率  
            data.setCodeLength(root.codeword.length());//码长  
            data.setCodeword(root.codeword);//码字  
//            sortList(list, new TreeNode(data));//将Data对象加入列表  
            list.add(data);
        }  
    }  
    /*将根结点顺序插入list*/  
    public static void sortList(List list,TreeNode root){  
        int i = 0;  
        if(list.isEmpty()){  
            list.add(root);//list为空,直接插入  
        }else{  
            while(i < list.size()){  
                if(((TreeNode)list.get(i)).data <= root.data){  
                    list.add(i,root);//将根结点按顺序插入  
                    break;  
                }else{  
                    i++;  
                }  
            }  
            if(i == list.size()){  
                list.add(i,root);//走到最后为最小,直接插入  
            }  
        }  
    }  
}  
/*创建一棵树*/  
class TreeNode {  
  
    public double data;//结点数据  
    public String codeword = "";//码字  
    public TreeNode left;//左孩子  
    public TreeNode right;//右孩子  
      
    public TreeNode(double data){  
        this.data = data;  
    }  
}
