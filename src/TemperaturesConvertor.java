import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * This application convert Celsius temperature
 * 0 through 100 to Fahrenheit
 * @Version 1.0
 * @Author Mahmut under
 *
 */

public class TemperaturesConvertor extends JFrame {

    private JLabel label1,label2; // info labels
    private JTextField fahTemp;   // fahrenheit temp;
    private JTextField calTemp;   // celsius temp
    private  JPanel fPanel;       // fahrenheit panel
    private  JPanel cPanel;       // celsius panel
    private JPanel sliderPanel;  // slider panel
    private JSlider tempSlider;  // temperature slider

    // build constructor

    public TemperaturesConvertor(){

        // set title for the frame
        setTitle("Convertor");
        // close the all app
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // building fPanel in the method, it is optional you can build here too
        buildFPanel();
        // building cPanel in the method, it is optional you can build here too
        builtCPanel();
        // building sliderPanel in the method, it is optional you can build here too
        buildSlider();

        // add panels to the frame
        add(fPanel);
        add(cPanel);
        add(sliderPanel);

        // set layout
        setLayout(new GridLayout(3,1));
        // give dimension
        setSize(400,200);


        // to center the app
        setLocation(600,300);

        // to keep always same size
        setResizable(false);







        // to display the frame
        setVisible(true);

    }

    private void buildSlider() {
        tempSlider= new JSlider(JSlider.HORIZONTAL,-20,100,0);
        sliderPanel= new JPanel();
        tempSlider.setMinorTickSpacing(5);
        tempSlider.setMajorTickSpacing(20);
        tempSlider.setPaintTicks(true);
        tempSlider.setPaintLabels(true);
        tempSlider.addChangeListener(new MyConvertClass());




        sliderPanel.add(tempSlider);
    }

    private void builtCPanel() {
        label1= new JLabel("Celsius: ");
        calTemp= new JTextField(20);
        calTemp.setEditable(false);
        calTemp.setHorizontalAlignment(JTextField.CENTER);
        calTemp.setFont(new Font(Font.MONOSPACED,0,20));

        cPanel= new JPanel();
        cPanel.add(label1);
        cPanel.add(calTemp);


    }

    private void buildFPanel() {
        label2= new JLabel("Fahrenheit: ");
        fahTemp= new JTextField(19);
        fahTemp.setEditable(false);
        fahTemp.setHorizontalAlignment(JTextField.CENTER);
        fahTemp.setFont(new Font(Font.MONOSPACED,0,20));
        fPanel= new JPanel();
        fPanel.add(label2);
        fPanel.add(fahTemp);
    }

    public static void main(String[] args) {
        new TemperaturesConvertor();
    }

    private class MyConvertClass implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            int cal=tempSlider.getValue();
            calTemp.setText(cal+"");

            // convert for fahrenheit

            double fah=cal*(9.0/5.0)+32.0;
            fahTemp.setText(String.format("%.2f",fah));

        }
    }
}
