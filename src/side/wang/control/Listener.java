package side.wang.control;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;
import side.wang.model.Coder;
import side.wang.model.Data;
import side.wang.model.Fano;
import side.wang.model.Huffman;
import side.wang.model.Shannon;
import side.wang.view.Window;

/**
 *
 * @author Side
 */
public class Listener implements CoderActionListener, ItemListener{
    Window win;
    File file;
    JTextField filename;
    JButton open;
    JComboBox codeMethod;
    JButton coder;
    Label table [][];
    
    public Listener(){
        String tmp = "C:\\Users\\Side\\Desktop\\testData.txt";
        this.file = new File(tmp);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {         
        String command = e.getActionCommand();
        if(command.equals("open")){
            File desktopDir = FileSystemView.getFileSystemView() .getHomeDirectory();
            JFileChooser fileChooser=new JFileChooser(desktopDir);
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.showDialog(new JLabel(), "选择需要编码的文件");
            file = fileChooser.getSelectedFile();
            String tmp = file.getAbsolutePath();
//            System.out.println(tmp);
            filename.setText(tmp.substring(tmp.lastIndexOf('\\')+1));
            win.validate();
        }else if(command.equals("coder")){   
            System.out.println("sss");
            String[] columnNames = {"A","B"};// 定义表格列名数组
            String[][] tableValues = {{"A1","B1"},{"A2","B2"},{"A3","B3"},{"A4","B4"},{"A5","B5"}};
            win.showData(columnNames, tableValues);
            win.validate();
//            List list = Coder.getData(file);
//            new Huffman().isHuffman(list);
//            for(int i = 0; i < list.size(); i++){
//                System.out.println(((Data)list.get(i)).toString());                  
//            }
            
        }
    }

    @Override
    public void setFilenameFiled(JTextField filename) {
        this.filename = filename;
    }

    @Override
    public void setOpenButton(JButton open) {
        this.open = open;
    }

    @Override
    public void setCodeMethod(JComboBox codeMethod) {
        this.codeMethod = codeMethod;
    }

    @Override
    public void setCoderButton(JButton coder) {
        this.coder = coder;
    }

    @Override
    public void setLabelArray(Label[][] label) {
        this.table = label;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
    }

    @Override
    public void setWindow(Window win) {
        this.win = win;
    }
    
}
