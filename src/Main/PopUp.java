package Main;

import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.awt.event.*;
import javax.swing.*;

public class PopUp extends JPopupMenu{
    JMenuItem it;
    public PopUp(String s){
        it = new JMenuItem("Copy");
        add(it);
        it.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection selection = new StringSelection(s);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection, selection);
            }
        });
    }
}
