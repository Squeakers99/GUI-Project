import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Elastic implements ActionListener, ChangeListener {
    // JPanel Definition
    JPanel thePanel = new JPanel();
    
    // Font Definitions
    Font fntDialog20 = new Font("Dialog", 1, 20);
    Font fntDialog15 = new Font("Dialog", 1, 15);
    Font fntDialog13 = new Font("Dialog", 1, 13);
    Font fntDialog10 = new Font("Dialog", 1, 10);

    // Creates the Divider
    JSeparator theMainDivider = new JSeparator(SwingConstants.VERTICAL);
    JSeparator theMassAndVelocitiesDivider = new JSeparator(SwingConstants.HORIZONTAL);
    JSeparator theVelocitiesDivider = new JSeparator(SwingConstants.HORIZONTAL);

    // Labels
    JLabel theM1Label = new JLabel("Mass 1: ", JLabel.CENTER);
    JLabel theM2Label = new JLabel("Mass 2: ", JLabel.CENTER);
    JLabel theV1InitialLabel = new JLabel("Mass 1 Initial V: ", JLabel.CENTER);
    JLabel theV2InitialLabel = new JLabel("Mass 2 Initial V: ", JLabel.CENTER);
    JLabel theCheckboxInstructions = new JLabel("Check the box to enable Mass 2 V -->", JLabel.CENTER);
    JLabel theV1FinalLabel = new JLabel("M1 Final V: 0", JLabel.CENTER);
    JLabel theV2FinalLabel = new JLabel("M2 Final V: 0", JLabel.CENTER);
    JLabel theP1FinalLabel = new JLabel("M1 Final P: 0", JLabel.CENTER);
    JLabel theP2FinalLabel = new JLabel("M2 Final P: 0", JLabel.CENTER);
    JLabel theP1InitialLabel = new JLabel("M1 Init P: 0", JLabel.CENTER);
    JLabel theP2InitialLabel = new JLabel("M2 Init P: 0", JLabel.CENTER);

    // Input Fields
    JTextField theM1Field = new JTextField("1");
    JTextField theM2Field = new JTextField("1");
    JTextField theV1InitialField = new JTextField("0");
    JTextField theV2InitialField = new JTextField("0");

    // Sliders
    JSlider theM1Slider = new JSlider(0, 100, 1);
    JSlider theM2Slider = new JSlider(0, 100, 1);
    JSlider theV1InitialSlider = new JSlider(-100, 100, 0);
    JSlider theV2InitialSlider = new JSlider(-100, 100, 0);

    //Checkbox
    JRadioButton theCheckbox = new JRadioButton();

    // Variables
    boolean blnMass2V = false;
    double dblM1 = 1.0;
    double dblM2 = 1.0;
    double dblV1Initial = 0.0;
    double dblV2Initial = 0.0;
    double dblV1Final;
    double dblV2Final;
    double dblP1Initial;
    double dblP2Initial;
    double dblP1Final;
    double dblP2Final;

    // Methods
    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == theM1Field){
            try {
                if (Integer.parseInt(theM1Field.getText()) < 1) {
                    theM1Slider.setValue(1);
                    theM1Field.setText("1");
                } else {
                    theM1Slider.setValue(Integer.parseInt(theM1Field.getText()));
                    theM1Field.setText(Integer.toString(theM1Slider.getValue()));
                }
            } catch (NumberFormatException e) {
                theM1Slider.setValue(1);
                theM1Field.setText("1");
            }
        } else if (evt.getSource() == theM2Field) {
            try {
                if (Integer.parseInt(theM2Field.getText()) < 1) {
                    theM2Slider.setValue(1);
                    theM2Field.setText("1");
                } else {
                    theM2Slider.setValue(Integer.parseInt(theM2Field.getText()));
                    theM2Field.setText(Integer.toString(theM2Slider.getValue()));
                }
            } catch (NumberFormatException e) {
                theM2Slider.setValue(1);
                theM2Field.setText("1");
            }
        }else if(evt.getSource() == theV1InitialField){
            try {
                theV1InitialSlider.setValue(Integer.parseInt(theV1InitialField.getText()));
                theV1InitialField.setText(Integer.toString(theV1InitialSlider.getValue()));
                dblV1Initial = Double.parseDouble(theV1InitialField.getText());
            } catch (NumberFormatException e) {
                theV1InitialSlider.setValue(0);
                theV1InitialField.setText("0");
            }
        }else if(evt.getSource() == theV2InitialField){
            try {
                theV2InitialSlider.setValue(Integer.parseInt(theV2InitialField.getText()));
                theV2InitialField.setText(Integer.toString(theV2InitialSlider.getValue()));
                dblV2Initial = Double.parseDouble(theV2InitialField.getText());
            } catch (NumberFormatException e) {
                theV2InitialSlider.setValue(0);
                theV2InitialField.setText("0");
            }
        }else if(evt.getSource() == theCheckbox){
            blnMass2V = !blnMass2V;
            if(blnMass2V){
                theV2InitialField.setEnabled(true);
                theV2InitialSlider.setEnabled(true);
            }else{
                theV2InitialField.setEnabled(false);
                theV2InitialSlider.setEnabled(false);
                theV2InitialField.setText("0");
                theV2InitialSlider.setValue(0);
            }
        }
        this.calculations();
    }

    @Override
    public void stateChanged(ChangeEvent evt) {
        if (evt.getSource() == theM1Slider) {
            if (theM1Slider.getValue() < 1) {
                theM1Slider.setValue(1);
                theM1Field.setText("1");
            } else {
                theM1Field.setText(Integer.toString(theM1Slider.getValue()));
            }
        } else if (evt.getSource() == theM2Slider) {
            if (theM2Slider.getValue() < 1) {
                theM2Slider.setValue(1);
                theM2Field.setText("1");
            } else {
                theM2Field.setText(Integer.toString(theM2Slider.getValue()));
            }
        } else if(evt.getSource() == theV1InitialSlider){
            theV1InitialField.setText(Integer.toString(theV1InitialSlider.getValue()));
        } else if(evt.getSource() == theV2InitialSlider){
            theV2InitialField.setText(Integer.toString(theV2InitialSlider.getValue()));
        }
        this.calculations();
    }

    //Method to perform calculations and display them
    public void calculations(){
        //Sets all the variables
        dblM1 = Double.parseDouble(theM1Field.getText());
        dblM2 = Double.parseDouble(theM2Field.getText());
        dblV1Initial = Double.parseDouble(theV1InitialField.getText());
        dblV2Initial = Double.parseDouble(theV2InitialField.getText());

        // Calculations
        dblV1Initial = dblV1Initial - dblV2Initial;
        dblV1Final = ((dblM1-dblM2)*dblV1Initial)/(dblM1+dblM2);
        dblV2Final = (2.0*dblM1*dblV1Initial)/(dblM1+dblM2);

        //Relative Velocity back into ground frame
        if(dblV2Initial != 0.0){
            dblV1Final = dblV1Final + dblV2Initial;
            dblV2Final = dblV2Final + dblV2Initial;
        }

        //Calculating Momentums
        dblP1Final = dblM1 * dblV1Final;
        dblP2Final = dblM2 * dblV2Final;
        dblP1Initial = dblV1Initial * dblM1;
        dblP2Initial = dblV2Initial * dblM2;

        //Rounds all to 1 Decimal Place
        dblV1Final = Math.round(dblV1Final * 10.0) / 10.0;
        dblV2Final = Math.round(dblV2Final * 10.0) / 10.0;
        dblP1Final = Math.round(dblP1Final * 10.0) / 10.0;
        dblP2Final = Math.round(dblP2Final * 10.0) / 10.0;
        dblP1Initial = Math.round(dblP1Initial * 10.0) / 10.0;
        dblP2Initial = Math.round(dblP2Initial * 10.0) / 10.0;

        // Set Label Text
        theV1FinalLabel.setText("M1 V Final: " + dblV1Final);
        theV2FinalLabel.setText("M2 V Final: " + dblV2Final);
        theP1FinalLabel.setText("M1 P Final: " + dblP1Final);
        theP2FinalLabel.setText("M2 P Final: " + dblP2Final);
        theP1InitialLabel.setText("M1 P Init: " + dblP1Initial);
        theP2InitialLabel.setText("M2 P Init: " + dblP2Initial);

        //Display Calculations on panel
        theV1FinalLabel.setBounds(5, 430, 110, 30);
        theV1FinalLabel.setFont(fntDialog13);
        theV1FinalLabel.setForeground(Color.white);
        thePanel.add(theV1FinalLabel);

        theV2FinalLabel.setBounds(5, 460, 110, 30);
        theV2FinalLabel.setFont(fntDialog13);
        theV2FinalLabel.setForeground(Color.white);
        thePanel.add(theV2FinalLabel);

        theP1FinalLabel.setBounds(120, 430, 110, 30);
        theP1FinalLabel.setFont(fntDialog13);
        theP1FinalLabel.setForeground(Color.white);
        thePanel.add(theP1FinalLabel);

        theP2FinalLabel.setBounds(120, 460, 110, 30);
        theP2FinalLabel.setFont(fntDialog13);
        theP2FinalLabel.setForeground(Color.white);
        thePanel.add(theP2FinalLabel);

        theP1InitialLabel.setBounds(5, 490, 100, 30);
        theP1InitialLabel.setFont(fntDialog13);
        theP1InitialLabel.setForeground(Color.white);
        thePanel.add(theP1InitialLabel);

        theP2InitialLabel.setBounds(120, 490, 100, 30);
        theP2InitialLabel.setFont(fntDialog13);
        theP2InitialLabel.setForeground(Color.white);
        thePanel.add(theP2InitialLabel);
    }

    public Elastic() {
        // Panel Properties
        thePanel.setPreferredSize(new Dimension(960, 540));
        thePanel.setLayout(null);
        thePanel.setBackground(Color.black);

        // Main Divider Properties
        theMainDivider.setBounds(240, 0, 10, 540);
        theMainDivider.setForeground(Color.white);
        thePanel.add(theMainDivider);

        // Label for Mass 1
        theM1Label.setBounds(70, 10, 80, 20);
        theM1Label.setFont(fntDialog20);
        theM1Label.setForeground(Color.white);
        thePanel.add(theM1Field);

        // Text Field for Mass 1
        theM1Field.setBounds(150, 10, 50, 20);
        theM1Field.setOpaque(false);
        theM1Field.setBorder(null);
        theM1Field.setFont(fntDialog20);
        theM1Field.setForeground(Color.white);
        thePanel.add(theM1Label);

        // Slider for Mass 1
        theM1Slider.setBounds(20, 40, 200, 50);
        theM1Slider.setForeground(Color.white);
        theM1Slider.setPaintTicks(true);
        theM1Slider.setPaintLabels(true);
        theM1Slider.setOpaque(false);
        theM1Slider.setMajorTickSpacing(10);
        theM1Slider.setMinorTickSpacing(5);
        thePanel.add(theM1Slider);

        // Label for Mass 2
        theM2Label.setBounds(70, 105, 80, 20);
        theM2Label.setFont(fntDialog20);
        theM2Label.setForeground(Color.white);
        thePanel.add(theM2Label);

        // Text Field for Mass 2
        theM2Field.setBounds(150, 105, 50, 20);
        theM2Field.setOpaque(false);
        theM2Field.setBorder(null);
        theM2Field.setFont(fntDialog20);
        theM2Field.setForeground(Color.white);
        thePanel.add(theM2Field);

        // Slider for Mass 2
        theM2Slider.setBounds(20, 135, 200, 50);
        theM2Slider.setForeground(Color.white);
        theM2Slider.setPaintTicks(true);
        theM2Slider.setPaintLabels(true);
        theM2Slider.setOpaque(false);
        theM2Slider.setMajorTickSpacing(10);
        theM2Slider.setMinorTickSpacing(5);
        thePanel.add(theM2Slider);

        // Divider between Mass and Velocities
        theMassAndVelocitiesDivider.setBounds(0, 200, 240, 5);
        theMassAndVelocitiesDivider.setForeground(Color.white);
        thePanel.add(theMassAndVelocitiesDivider);

        // Label for Checkbox Instructions
        theCheckboxInstructions.setBounds(1, 200, 220, 50);
        theCheckboxInstructions.setFont(fntDialog10);
        theCheckboxInstructions.setForeground(Color.white);
        thePanel.add(theCheckboxInstructions);

        // Checkbox
        theCheckbox.setBounds(215, 215, 20, 20);
        theCheckbox.setOpaque(false);
        thePanel.add(theCheckbox);

        // Mass 1 Initial V Label
        theV1InitialLabel.setBounds(1, 240, 220, 30);
        theV1InitialLabel.setFont(fntDialog15);
        theV1InitialLabel.setForeground(Color.white);
        thePanel.add(theV1InitialLabel);

        // Mass 1 Initial V Field
        theV1InitialField.setBounds(170, 240, 50, 30);
        theV1InitialField.setOpaque(false);
        theV1InitialField.setBorder(null);
        theV1InitialField.setFont(fntDialog15);
        theV1InitialField.setForeground(Color.white);
        thePanel.add(theV1InitialField);

        // Mass 1 Initial V Slider
        theV1InitialSlider.setBounds(20, 270, 200, 50);
        theV1InitialSlider.setForeground(Color.white);
        theV1InitialSlider.setPaintTicks(true);
        theV1InitialSlider.setPaintLabels(true);
        theV1InitialSlider.setOpaque(false);
        theV1InitialSlider.setMajorTickSpacing(50);
        theV1InitialSlider.setMinorTickSpacing(10);
        thePanel.add(theV1InitialSlider);

        // Mass 2 Initial V Label
        theV2InitialLabel.setBounds(1, 325, 220, 30);
        theV2InitialLabel.setFont(fntDialog15);
        theV2InitialLabel.setForeground(Color.white);
        thePanel.add(theV2InitialLabel);

        // Mass 2 Initial V Field
        theV2InitialField.setBounds(170, 325, 50, 30);
        theV2InitialField.setOpaque(false);
        theV2InitialField.setBorder(null);
        theV2InitialField.setFont(fntDialog15);
        theV2InitialField.setForeground(Color.white);
        theV2InitialField.setEnabled(false);
        thePanel.add(theV2InitialField);

        // Mass 2 Initial V Slider
        theV2InitialSlider.setBounds(20, 355, 200, 50);
        theV2InitialSlider.setForeground(Color.white);
        theV2InitialSlider.setPaintTicks(true);
        theV2InitialSlider.setPaintLabels(true);
        theV2InitialSlider.setOpaque(false);
        theV2InitialSlider.setMajorTickSpacing(50);
        theV2InitialSlider.setMinorTickSpacing(10);
        theV2InitialSlider.setEnabled(false);
        thePanel.add(theV2InitialSlider);

        // Divider between V inputs and calculations
        theVelocitiesDivider.setBounds(0, 420, 240, 5);
        theVelocitiesDivider.setForeground(Color.white);
        thePanel.add(theVelocitiesDivider);

        // Runs Calculations to display the calculations
        this.calculations();

        // All Listeners
        theM1Field.addActionListener(this);
        theM1Slider.addChangeListener(this);
        theM2Field.addActionListener(this);
        theM2Slider.addChangeListener(this);
        theCheckbox.addActionListener(this);
        theV1InitialField.addActionListener(this);
        theV1InitialSlider.addChangeListener(this);
        theV2InitialField.addActionListener(this);
        theV2InitialSlider.addChangeListener(this);
    }
}
