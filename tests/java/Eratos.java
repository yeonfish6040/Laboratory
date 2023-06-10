import org.yeonfish.Util.Stopwatch;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class Eratos extends JFrame {
    static int size = 512;
    static int max = size*size;
    static JPanel container;
    static ArrayList<JLabel> numbersList = new ArrayList<JLabel>();
    static JLabel[] numbers = new JLabel[max];

    static Stopwatch stopwatch;

    Eratos() {
        container = new JPanel();
        container.setVisible(true);
        JScrollPane scrPane = new JScrollPane(container);

        container.setLayout(new GridLayout(size, size));
        container.setPreferredSize(new Dimension(size*55, size*12));
        container.setBackground(Color.darkGray);
        scrPane.setBounds(0, 0, 2400, 1200);
        scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrPane.getVerticalScrollBar().setUnitIncrement(16);
        scrPane.getHorizontalScrollBar().setUnitIncrement(16);
        scrPane.setVisible(true);
        getContentPane().add(scrPane);

        setTitle("Eratos");
        setSize(2450, 1250);
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Eratos | Preparing resources...");
        StringBuilder num = new StringBuilder();
        for (int i=0;i<max;i++) {
            num.delete(0, num.length());
            num.append("000000").append(i+1);
            JLabel number = new JLabel(num.substring(num.length()-7, num.length()).toString());
            number.setForeground(Color.white);
            number.setBackground(Color.lightGray);
            number.setOpaque(true);
            numbersList.add(number);
            container.add(number);
        }
        container.updateUI();
        numbers = numbersList.toArray(numbers);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        stopwatch = new Stopwatch();

        System.out.println("Preparing resources...");
        stopwatch.Flag();
        Eratos eratos = new Eratos();
        stopwatch.Flag();

        System.out.println("Calculating...");
        stopwatch.Flag();
        ArrayList<Integer> numList = new ArrayList<Integer>();
        for (int i=1;i<=max;i++) {
            numList.add(i);
        }
        numList.remove(0);
        numbers[0].setBackground(Color.GREEN);

        eratos.setTitle("Eratos | Calculating...");
        while (true) {
            if (numList.size() == 0)
                break;
            int i = numList.get(0);
            numbers[i-1].setBackground(Color.GREEN);
            for (int j = 1; i * j <= max; j++) {
                if (!(numList.indexOf(i * j) == -1))
                    numList.remove(numList.indexOf(i * j));
                if (!((i * j) == i))
                    numbers[(i * j)-1].setBackground(Color.RED);
            }
        }
        container.updateUI();
        eratos.setTitle("Eratos | Calculate complete "+String.valueOf(max)+"/"+String.valueOf(max)+" - 100%");

        stopwatch.Flag();
        System.out.println("Done!");

        System.out.println(stopwatch.getDuration(0, 1));
        System.out.println(stopwatch.getDuration(2, 3));
        System.out.println(stopwatch.getDuration(0, 3));
    }

}
