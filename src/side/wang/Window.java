package side.wang;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Window extends JFrame implements ActionListener {
    private Triangle triangle;              //数据对象
    private JTextField textA,textB,textC;   //数据对象的视图
    private JTextArea showArea;            //数据对象的视图
    private JButton controlButton;         //控制器对象
    private JComboBox choice;
    JButton open=null;
    Window() {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void init() {
        String [] method = {"选择编码方式", "香农编码", "费诺编码", "哈夫曼编码"};
        triangle=new Triangle();
        textA=new JTextField(6);   
        choice = new JComboBox();
        showArea=new JTextArea();    
        controlButton=new JButton("编码");
        open=new JButton("浏览");
        JPanel pNorth=new JPanel();
        pNorth.add(new JLabel("文件："));
        pNorth.add(textA);
        textA.setText("输入文件名");
        for(String s : method){
             choice.addItem(s);
        }  
        pNorth.add(choice);
        pNorth.add(open); 
        pNorth.add(controlButton); 
        
        controlButton.addActionListener(this);
        open.addActionListener(this);
        add(pNorth,BorderLayout.NORTH);
        add(new JScrollPane(showArea),BorderLayout.CENTER);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{  
            double a=Double.parseDouble(textA.getText().trim());   
            double b=Double.parseDouble(textB.getText().trim());      
            double c=Double.parseDouble(textC.getText().trim()); 
            triangle.setA(a) ;          //更新数据
            triangle.setB(b);
            triangle.setC(c);
            String area=triangle.getArea();     
            showArea.append("三角形"+a+","+b+","+c+"的面积:"); 
            showArea.append(area+"\n");  //更新视图
        } 
        catch(Exception ex) {
            showArea.append("\n"+ex+"\n");
        }
    }
}

