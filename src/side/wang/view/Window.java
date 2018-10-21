package side.wang.view;

import java.awt.*;
import javax.swing.*;


public class Window extends JFrame{   
    private JTextField textA;   //数据对象的视图
    private JButton controlButton;         //控制器对象
    private JButton open;
    private JComboBox choice; 
    private PanelGrid grid;
    
    public Window() {
        init();       
    }
    
    private void init() {
        String [] method = {"选择编码方式", "香农编码", "费诺编码", "哈夫曼编码"};      
        
        textA=new JTextField(8);   
        choice = new JComboBox();
        
        controlButton=new JButton("编码");
        open=new JButton("浏览");
        
        JPanel pNorth=new JPanel();
        pNorth.add(new JLabel("文件："));
        pNorth.add(textA);
        textA.setText("输入文件名");
        pNorth.add(open); 
        for(String s : method){
             choice.addItem(s);
        }  
        pNorth.add(choice);       
        pNorth.add(controlButton);  
        
        grid = new PanelGrid(6, 10); 
        
        
        add(pNorth,BorderLayout.NORTH);   
        add(grid, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class PanelGrid extends JPanel {
    PanelGrid(int a, int b) {
       init(a, b);
    }
    private void init(int a, int b){
        GridLayout grid=new GridLayout(a,b);  //网格布局
        setLayout(grid);
        
        Label label[][]=new Label[a][b];     
        for(int i=0;i<a;i++) {
            for(int j=0;j<b;j++) {
                label[i][j]=new Label();
                if(j % 2 == 0){
                    label[i][j].setBackground(Color.gray);
                }
                add(label[i][j]); 
            }
        }
    }
}
