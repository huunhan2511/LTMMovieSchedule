/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Custom;


import Models.Cineplex;
import Models.Citi;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboBoxUI;
public class SweetComboBox extends JComboBox<Object>{
    public SweetComboBox (String backgroundColor, String foregroundColor , int left, int top, int width, int height,List<Object> value)
    {
            this.setModel(new javax.swing.DefaultComboBoxModel<Object>(value.toArray(new Object[0])));
            this.setRenderer(new MyComboBoxRenderer());
            this.setFont(new java.awt.Font("SansSerif", 0, 14));
            this.setForeground(Color.decode(foregroundColor));
            UIManager.put("ComboBox.background",new javax.swing.plaf.ColorUIResource(Color.decode(backgroundColor)));
            
            this.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
            this.setDoubleBuffered(true);
            this.setEditor(null);
            this.setFocusable(false);
            this.setLightWeightPopupEnabled(false);
            this.setBounds(left, top, width, height);
            this.setBorder(BorderFactory.createLineBorder(Color.decode("#FFFFFF"),1));
            this.setUI(new BasicComboBoxUI(){
            protected JButton createArrowButton()
            {
                JButton arrow = new JButton();
                arrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/expand-arrow.png")));
                arrow.setOpaque(true);
                arrow.setFont(new java.awt.Font("SansSerif", 0, 14));
                arrow.setText(null);
                arrow.setBorder(null);
                arrow.setBackground(Color.decode("#353746"));
                arrow.setContentAreaFilled(false);
                arrow.setBorder(null);
                return arrow;
            }
            });
    }
    
}
class MyComboBoxRenderer extends DefaultListCellRenderer{
        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean hasFocus)
        {
            super.getListCellRendererComponent(list, value, index, isSelected, hasFocus);
            if (value != null) {
              if(value instanceof Citi){
                Citi myObj = (Citi) value;
                setText(myObj.getName());
              }
              if(value instanceof Cineplex){
                Cineplex myObj = (Cineplex) value;
                setText(myObj.getName());
              }
            }
//            
            return this;
        }

    }
