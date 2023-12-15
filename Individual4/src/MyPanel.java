import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;
public class MyPanel extends JPanel{
    JLabel l1, l2, l3, l4;
    TextArea area;
    JTextField f1, f2, f3, f4;
    ArrayList<Car> m;
    JButton add, print, delete;
    MyPanel() {
        m = new ArrayList<>();
        l1 = new JLabel("Введите производителя");
        add(l1);
        f1 = new JTextField();
        f1.setColumns(10);
        add(f1);

        l2 = new JLabel("Введите марку");
        add(l2);
        f2 = new JTextField();
        f2.setColumns(10);
        add(f2);

        l3 = new JLabel("Введите гос. номер");
        add(l3);
        f3 = new JTextField();
        f3.setColumns(10);
        add(f3);

        add = new JButton("Добавить автомобиль ");
        MyListener m = new MyListener();
        add.addActionListener(m);
        add(add);

        l4 = new JLabel("Введите марку машины, чтобы ее удалить");
        add(l4);
        f4 = new JTextField(10);
        add(f4);

        delete = new JButton("Удалить");
        MyListenerDel d = new MyListenerDel();
        delete.addActionListener(d);
        add(delete);

        print = new JButton("Вывести список ");
        MyListenerPrinter p = new MyListenerPrinter();
        print.addActionListener(p);
        add(print);
        area = new TextArea("В вашем списке:\n");
        add(area);
    }
    class MyListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String manufacture = f1.getText();
            String marka = f2.getText();
            String number = f3.getText();
            Car c = new Car(manufacture,marka,number);
            m.add(c);
        }
    }
    class MyListenerDel implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int p = -1;
            for (int i = 0; i < m.size(); i++) {
                if(f4.getText().equalsIgnoreCase(m.get(i).getMarka()))
                    p = i;
            }
            if (p > -1){
                m.remove(p);
                System.out.println("Удалили автомобиль марки " + f4.getText());
            }
            else System.out.println("Такого автомобиля нет!");
        }
    }
    class MyListenerPrinter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            area.setText(null);
            for (Car c : m) {
                area.append(c.toString());
            }
        }
    }
}
