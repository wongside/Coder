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
            filename.setText(tmp.substring(tmp.lastIndexOf('\\')+1));
            win.validate();
        }else if(command.equals("coder")){   
            List list = Coder.getData(file);
            
            String[][] tableValues = new String [list.size()][4];
            switch (codeMethod.getSelectedIndex()) {
                case 1:
                    list = new Shannon().isShannon(list);
                    break;
                case 2:
                    list = new Fano().isFano(list);
                    break;
                case 3:
                    new Huffman().isHuffman(list);
                    break;
                default:
                    break;
            }
            double k = 0.0;
            double hx = 0.0;
            for(int i = 0; i < list.size(); i++){
                Data data = (Data)list.get(i);
                int j = 0;
                tableValues[i][j++] = "    " + data.getSymbol() + "";
//                String tmp;
//                if(data.getProb() < 10e-4){
//                    tmp = (data.getProb() * 10e4) + "" ;
//                }else{
//                    tmp = data.getProb() + "" ;
//                }
                tableValues[i][j++] = "  " +  data.getProb();
                tableValues[i][j++] = "  " + data.getCodeword();
                tableValues[i][j++] = "    " + data.getCodeLength()+"";
                k += data.getProb() * data.getCodeLength();
                hx += data.getProb() * Math.log(data.getProb());
            }
            hx = -hx;
            String parm [] = new String [4];
            parm[0] = String.valueOf(k).substring(0,4);
            parm[1] = String.valueOf(hx).substring(0,4);
            parm[2] = String.valueOf(k).substring(0,4);
            parm[3] = String.valueOf(hx / k * 100).substring(0,4) + "%";
            win.showData(tableValues, parm);
            win.validate();
            
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
