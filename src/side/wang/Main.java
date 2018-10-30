package side.wang;

import side.wang.control.Listener;
import side.wang.view.Window;

/**
 *
 * @author Side
 */
public class Main {
    public static void main(String[] args) {
        Window win=new Window();
        Listener listener = new Listener();
        win.setListener(listener);
        win.setTitle("信源编码模拟"); 
        win.setBounds(100,100,480,300);
    }  
}
