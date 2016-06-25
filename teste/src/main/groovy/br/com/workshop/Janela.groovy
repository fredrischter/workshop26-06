package br.com.workshop

import javax.swing.JFrame
import javax.swing.JList
import javax.swing.JScrollPane
import javax.swing.ListSelectionModel
import java.awt.Dimension
import java.awt.GraphicsDevice
import java.awt.GraphicsEnvironment

/**
 * Created by dummy on 18/06/2016.
 */
class Janela extends JFrame {

    public Janela() {
        super("Workshop Java");
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

        JFrame frame = this;
        frame.setSize(500, 500)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        device.setFullScreenWindow(frame);
    }

    void exibir() {
        this.pack();
        this.setVisible(true);
    }

    JScrollPane listScroller;
    void setList(Object[] objects) {
        JList list = new JList(objects); //data has type Object[]
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);

        if (listScroller == null ) {
            JScrollPane listScroller = new JScrollPane(list);
            listScroller.setPreferredSize(new Dimension(250, 80));
            this.add(listScroller);
        } else {
            listScroller.add(list);
        }
    }
}
