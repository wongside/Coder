package side.wang.control;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Side
 */
public class Listener implements CoderActionListener, ItemListener{
    File file;
    JTextField filename;
    JButton open;
    JComboBox codeMethod;
    JButton coder;
    Label table [][];
    
    
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
            filename.setText(tmp.substring(tmp.lastIndexOf('\\')+1));
        }else if(command.equals("coder")){
            
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
    
}
