package side.wang.view;

import java.awt.*;
import javax.swing.*;
import side.wang.control.Listener;


public class Window extends JFrame {   
    Listener listener;
    JTextField filename;
    JButton open;
    JComboBox method;
    JButton coder;
    JScrollPane scrollPane;
    String[] columnNames = {"字符", "概率", "编码", "码长"};// 定义表格列名数组
    JTextField d1, d2, d3, d4;
    
    public Window() {
        init();       
    }
    
    private void init() {
        listener = new  Listener();
        //输入框
        filename = new JTextField(10);
        filename.setText("testData.txt");
        filename.setActionCommand("filename");       
        
        open = new JButton("选择文件");
        open.setActionCommand("open");
        
        String [] methodName = {"选择编码方式", "香农编码", "费诺编码", "哈夫曼编码"};      
        method = new JComboBox();
        for(String s : methodName){
             method.addItem(s);
        }
                
        coder = new JButton("编码"); 
        coder.setActionCommand("coder");       
        
        JPanel panel = new JPanel();
        panel.add(filename);
        panel.add(open);
        panel.add(method);
        panel.add(coder);
        
        JPanel spanel = new JPanel();
        spanel.add(new JLabel("平均码长:"));
        d1 = new JTextField(4);
        d2 = new JTextField(4);
        d3 = new JTextField(4);
        d4 = new JTextField(5);
        spanel.add(d1);
        spanel.add(new JLabel("信源熵:"));
        spanel.add(d2);
        spanel.add(new JLabel("信息率:"));
        spanel.add(d3);
        spanel.add(new JLabel("编码效率:"));
        spanel.add(d4);
               
        String[][] tableValues = new String [100][4];
        JTable table = new JTable(tableValues,columnNames);
        scrollPane = new JScrollPane(table);
        
        
             
        add(panel,BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(spanel, BorderLayout.SOUTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void setListener(Listener listener){
        this.listener = listener;
        listener.setWindow(this);
        listener.setFilenameFiled(filename);
        listener.setOpenButton(open);
        listener.setCodeMethod(method);
        listener.setCoderButton(coder);
//        listener.setLabelArray(table);
        filename.addActionListener(listener);
        open.addActionListener(listener);
        coder.addActionListener(listener);
    }
    public void showData(String[][] tableValues, String [] parm){
        this.remove(scrollPane);
        JTable table = new JTable(tableValues,columnNames);       
        scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
        d1.setText(parm[0]);
        d2.setText(parm[1]);
        d3.setText(parm[2]);
        d4.setText(parm[3]);
    }
}
