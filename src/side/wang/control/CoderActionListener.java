package side.wang.control;

import java.awt.Label;

import java.awt.event.ActionListener;
import javax.swing.*;
import side.wang.view.Window;

/**
 *
 * @author Side
 */
public interface CoderActionListener extends ActionListener{
    public void setWindow(Window win);
    public void setFilenameFiled(JTextField filename);
    public void setOpenButton(JButton open);
    public void setCodeMethod(JComboBox codeMethod);
    public void setCoderButton(JButton coder);
    public void setLabelArray(Label[][] label);
}
