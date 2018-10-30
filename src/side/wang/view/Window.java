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
    Label table [][];
    
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
        
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(6, 10));
        table = new Label[6][10];  
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 10; j++) {
                table[i][j] = new Label();
                if(j % 2 == 0){
                    table[i][j].setBackground(Color.gray);
                }
                grid.add(table[i][j]); 
            }
        }
             
        add(panel,BorderLayout.NORTH);
//        add(grid, BorderLayout.CENTER); 
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
        listener.setLabelArray(table);
        filename.addActionListener(listener);
        open.addActionListener(listener);
        coder.addActionListener(listener);
    }
    public void showData(String[] columnNames, String[][] tableValues){
        JTable table = new JTable(tableValues,columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
    }
}
