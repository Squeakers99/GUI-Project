/*
 * Soheil Rajabali and Jayred Robles
 * Momentum and Collisions Simulator
 * V1.0
 */

package Collisions;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * <h1>Elastic Panel</h1>
 * This class creates a fully animated JPanel to simulate an elastic collision between two masses. <br>
 * It contains sliders, text fields, check boxes, dividers, and buttons to control the simulation. <br>
 * It also contains a timer to animate the simulation.<br>
 * 
 * @author Soheil Rajabali, Jayred Robles
 * @version 1.0
 * @since 2024-05-09
*/

public class Elastic extends JPanel implements ActionListener, ChangeListener {
    //------------------PROPERTIES------------------

    // Font Definitions
    public Font fntDialog20 = new Font("Dialog", 1, 20);
    public Font fntDialog15 = new Font("Dialog", 1, 15);
    public Font fntDialog13 = new Font("Dialog", 1, 13);
    public Font fntDialog10 = new Font("Dialog", 1, 10);

    // Creates the Divider
    public JSeparator theMainDivider = new JSeparator(SwingConstants.VERTICAL);
    public JSeparator theMassAndVelocitiesDivider = new JSeparator(SwingConstants.HORIZONTAL);
    public JSeparator theVelocitiesDivider = new JSeparator(SwingConstants.HORIZONTAL);

    // Labels
    public JLabel theM1Label = new JLabel("Mass 1: ", JLabel.CENTER);
    public JLabel theM2Label = new JLabel("Mass 2: ", JLabel.CENTER);
    public JLabel theV1InitialLabel = new JLabel("Mass 1 Initial V: ", JLabel.CENTER);
    public JLabel theV2InitialLabel = new JLabel("Mass 2 Initial V: ", JLabel.CENTER);
    public JLabel theCheckboxInstructions = new JLabel("Check the box to enable Mass 2 V -->", JLabel.CENTER);
    public JLabel theV1FinalLabel = new JLabel("M1 Final V: 0", JLabel.CENTER);
    public JLabel theV2FinalLabel = new JLabel("M2 Final V: 0", JLabel.CENTER);
    public JLabel theP1FinalLabel = new JLabel("M1 Final P: 0", JLabel.CENTER);
    public JLabel theP2FinalLabel = new JLabel("M2 Final P: 0", JLabel.CENTER);
    public JLabel theP1InitialLabel = new JLabel("M1 Init P: 0", JLabel.CENTER);
    public JLabel theP2InitialLabel = new JLabel("M2 Init P: 0", JLabel.CENTER);

    // Input Fields
    public JTextField theM1Field = new JTextField("50");
    public JTextField theM2Field = new JTextField("50");
    public JTextField theV1InitialField = new JTextField("0");
    public JTextField theV2InitialField = new JTextField("0");

    // Sliders
    public JSlider theM1Slider = new JSlider(0, 100, 50);
    public JSlider theM2Slider = new JSlider(0, 100, 50);
    public JSlider theV1InitialSlider = new JSlider(0, 10, 0);
    public JSlider theV2InitialSlider = new JSlider(-10, 10, 0);

    //Checkbox
    public JRadioButton theCheckbox = new JRadioButton();

    //Buttons
    public JButton theRunButton = new JButton("Run Simulation");
    public JButton theResetButton = new JButton("Reset Simulation");

    //Timer
    public Timer theTimer = new Timer(1000/48, this);

    // Variables - Calculations
    public boolean blnM2V = false;
    public boolean blnCollided = false;
    public double dblM1 = 1.0;
    public double dblM2 = 1.0;
    public double dblV1Initial = 0.0;
    public double dblV2Initial = 0.0;
    public double dblV1Final;
    public double dblV2Final;
    public double dblP1Initial;
    public double dblP2Initial;
    public double dblP1Final;
    public double dblP2Final;

    //Variables - Animation
    public int intM1X = 300;
    public int intM1Size = 50;
    public int intM2X = 450;
    public int intM2Size = 50;

    //------------------METHODS------------------

    //Override to paint the components
    /**
     * Overrided method that handles the animation
     * @param g Contains the graphics object that is going to be drawn on the panel
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(240, 400, 720, 5);
        g.setColor(Color.white);
        g.fillOval(intM1X, 400-intM1Size, intM1Size, intM1Size);
        g.fillOval(intM2X, 400-intM2Size, intM2Size, intM2Size);
    }

    //Mandatory override to read component states
    /**
     * Overrided method that triggers when a Field, Checkbox, or Button has been triggered
     * @param evt Contains the event that was triggered
     */
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
                theM1Slider.setValue(50);
                theM1Field.setText("50");
            }
            this.calculations();
            this.simulationSetup();
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
                theM2Slider.setValue(50);
                theM2Field.setText("50");
            }
            this.calculations();
            this.simulationSetup();
        }else if(evt.getSource() == theV1InitialField){
            try {
                theV1InitialSlider.setValue(Integer.parseInt(theV1InitialField.getText()));
                theV1InitialField.setText(Integer.toString(theV1InitialSlider.getValue()));
                dblV1Initial = Double.parseDouble(theV1InitialField.getText());
            } catch (NumberFormatException e) {
                theV1InitialSlider.setValue(0);
                theV1InitialField.setText("0");
            }
            this.calculations();
        }else if(evt.getSource() == theV2InitialField){
            try {
                theV2InitialSlider.setValue(Integer.parseInt(theV2InitialField.getText()));
                theV2InitialField.setText(Integer.toString(theV2InitialSlider.getValue()));
                dblV2Initial = Double.parseDouble(theV2InitialField.getText());
            } catch (NumberFormatException e) {
                theV2InitialSlider.setValue(0);
                theV2InitialField.setText("0");
            }
            this.calculations();
        }else if(evt.getSource() == theCheckbox){
            blnM2V = !blnM2V;
            if(blnM2V){
                theV2InitialField.setEnabled(true);
                theV2InitialSlider.setEnabled(true);
            }else{
                theV2InitialField.setEnabled(false);
                theV2InitialSlider.setEnabled(false);
                theV2InitialField.setText("0");
                theV2InitialSlider.setValue(0);
            }
        }else if(evt.getSource() == theRunButton){
            if(dblV1Initial <= dblV2Initial){
                JOptionPane.showMessageDialog(null, "Collision Invalid. \nInitial velocity of mass 2 cannot be greater than or equal to the initial velocity of mass 1", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                theM1Field.setEnabled(false);
                theM2Field.setEnabled(false);
                theV1InitialField.setEnabled(false);
                theV2InitialField.setEnabled(false);
                theM1Slider.setEnabled(false);
                theM2Slider.setEnabled(false);
                theV1InitialSlider.setEnabled(false);
                theV2InitialSlider.setEnabled(false);
                theCheckbox.setEnabled(false);
                theRunButton.setEnabled(false);
                theTimer.start();
            }
        }else if(evt.getSource() == theResetButton){
            intM1X = 300;
            intM2X = 450;
            simulationSetup();
            blnCollided = false;
            theM1Field.setEnabled(true);
            theM2Field.setEnabled(true);
            theV1InitialField.setEnabled(true);
            theV2InitialField.setEnabled(true);
            theM1Slider.setEnabled(true);
            theM2Slider.setEnabled(true);
            theV1InitialSlider.setEnabled(true);
            theV2InitialSlider.setEnabled(true);
            theCheckbox.setEnabled(true);
            theRunButton.setEnabled(true);
            theResetButton.setEnabled(true);
            theTimer.stop();
        }else if(evt.getSource() == theTimer){
            simulationRun();
        }
    }

    //Mandatory override to read slider state
    /**
     * Overrided method that triggers when a Slider has been triggered
     * @param evt Contains the event that was triggered
     */
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
        simulationSetup();
    }

    //Method to perform calculations and display them
    /**
     * Method to perform all calculations that are going to be displayed
    */
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

        //Resetting V1 and V2 after Relative Velocity Calculations
        dblV1Initial = Double.valueOf(theV1InitialSlider.getValue());
        dblV2Initial = Double.valueOf(theV2InitialSlider.getValue());

        //Calculating Momentums
        dblP1Final = dblM1 * dblV1Final;
        dblP2Final = dblM2 * dblV2Final;
        dblP1Initial = dblV1Initial * dblM1;
        dblP2Initial = dblV2Initial * dblM2;

        //Draws the labels
        drawLabels();
    }

    //Method to draw the labels
    /**
     * Method to draw all calculation labels on the panel
    */
    public void drawLabels(){
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
        add(theV1FinalLabel);

        theV2FinalLabel.setBounds(5, 460, 110, 30);
        theV2FinalLabel.setFont(fntDialog13);
        theV2FinalLabel.setForeground(Color.white);
        add(theV2FinalLabel);

        theP1FinalLabel.setBounds(120, 430, 110, 30);
        theP1FinalLabel.setFont(fntDialog13);
        theP1FinalLabel.setForeground(Color.white);
        add(theP1FinalLabel);

        theP2FinalLabel.setBounds(120, 460, 110, 30);
        theP2FinalLabel.setFont(fntDialog13);
        theP2FinalLabel.setForeground(Color.white);
        add(theP2FinalLabel);

        theP1InitialLabel.setBounds(5, 490, 100, 30);
        theP1InitialLabel.setFont(fntDialog13);
        theP1InitialLabel.setForeground(Color.white);
        add(theP1InitialLabel);

        theP2InitialLabel.setBounds(120, 490, 100, 30);
        theP2InitialLabel.setFont(fntDialog13);
        theP2InitialLabel.setForeground(Color.white);
        add(theP2InitialLabel);
    }

    //Method to setup the simulation
    /**
     * Sets up the simulation by setting the mass sizes to the variables
    */
    public void simulationSetup(){
        intM1Size = (int)dblM1;
        intM2Size = (int)dblM2;
        repaint();
    }

    //Method to run the simulation
    /**
     * Runs the simulation
    */
    public void simulationRun(){
        if(blnCollided == false){
            intM1X += (int)dblV1Initial;
            intM2X += (int)dblV2Initial;
        }else{
            if(dblV1Final < 1.0 && dblV1Final > 0.0){
                intM1X += 1;
            }else if(dblV1Final > -1.0 && dblV1Final < 0.0){
                intM1X -= 1;
            }else{
                intM1X += (int)dblV1Final;
            }

            if(dblV2Final < 1.0 && dblV2Final > 0.0){
                intM2X += 1;
            }else if (dblV2Final > -1.0 && dblV2Final < 0.0){
                intM2X -= 1;
            }else{
                intM2X += (int)dblV2Final;
            }
        }
        if(intM1X+intM1Size >= intM2X){
            blnCollided = true;
        }

        //Puts M1 out of the screen if it gets on the configuration side of the panel
        if(intM1X <= 240){
            intM1X = 0 - intM1Size;
        }
        
        repaint();
    }

    //------------------CONSTRUCTOR------------------
    /**
     * Constructor that sets up and formats the whole panel with sliders, text boxes, check boxes, dividers, and buttons; as well as the simulation
    */
    public Elastic() {
        // Panel Properties
        setPreferredSize(new Dimension(960, 540));
        setLayout(null);
        setBackground(Color.black);

        // Main Divider Properties
        theMainDivider.setBounds(240, 0, 10, 540);
        theMainDivider.setForeground(Color.white);
        add(theMainDivider);

        // Label for Mass 1
        theM1Label.setBounds(70, 10, 80, 20);
        theM1Label.setFont(fntDialog20);
        theM1Label.setForeground(Color.white);
        add(theM1Field);

        // Text Field for Mass 1
        theM1Field.setBounds(150, 10, 50, 20);
        theM1Field.setOpaque(false);
        theM1Field.setBorder(null);
        theM1Field.setFont(fntDialog20);
        theM1Field.setForeground(Color.white);
        add(theM1Label);

        // Slider for Mass 1
        theM1Slider.setBounds(20, 40, 200, 50);
        theM1Slider.setForeground(Color.white);
        theM1Slider.setPaintTicks(true);
        theM1Slider.setPaintLabels(true);
        theM1Slider.setOpaque(false);
        theM1Slider.setMajorTickSpacing(10);
        theM1Slider.setMinorTickSpacing(5);
        theM1Slider.setSnapToTicks(true);
        add(theM1Slider);

        // Label for Mass 2
        theM2Label.setBounds(70, 105, 80, 20);
        theM2Label.setFont(fntDialog20);
        theM2Label.setForeground(Color.white);
        add(theM2Label);

        // Text Field for Mass 2
        theM2Field.setBounds(150, 105, 50, 20);
        theM2Field.setOpaque(false);
        theM2Field.setBorder(null);
        theM2Field.setFont(fntDialog20);
        theM2Field.setForeground(Color.white);
        add(theM2Field);

        // Slider for Mass 2
        theM2Slider.setBounds(20, 135, 200, 50);
        theM2Slider.setForeground(Color.white);
        theM2Slider.setPaintTicks(true);
        theM2Slider.setPaintLabels(true);
        theM2Slider.setOpaque(false);
        theM2Slider.setMajorTickSpacing(10);
        theM2Slider.setMinorTickSpacing(5);
        theM2Slider.setSnapToTicks(true);
        add(theM2Slider);

        // Divider between Mass and Velocities
        theMassAndVelocitiesDivider.setBounds(0, 200, 240, 5);
        theMassAndVelocitiesDivider.setForeground(Color.white);
        add(theMassAndVelocitiesDivider);

        // Label for Checkbox Instructions
        theCheckboxInstructions.setBounds(1, 200, 220, 50);
        theCheckboxInstructions.setFont(fntDialog10);
        theCheckboxInstructions.setForeground(Color.white);
        add(theCheckboxInstructions);

        // Checkbox
        theCheckbox.setBounds(215, 215, 20, 20);
        theCheckbox.setOpaque(false);
        add(theCheckbox);

        // Mass 1 Initial V Label
        theV1InitialLabel.setBounds(1, 240, 220, 30);
        theV1InitialLabel.setFont(fntDialog15);
        theV1InitialLabel.setForeground(Color.white);
        add(theV1InitialLabel);

        // Mass 1 Initial V Field
        theV1InitialField.setBounds(170, 240, 50, 30);
        theV1InitialField.setOpaque(false);
        theV1InitialField.setBorder(null);
        theV1InitialField.setFont(fntDialog15);
        theV1InitialField.setForeground(Color.white);
        add(theV1InitialField);

        // Mass 1 Initial V Slider
        theV1InitialSlider.setBounds(20, 270, 200, 50);
        theV1InitialSlider.setForeground(Color.white);
        theV1InitialSlider.setPaintTicks(true);
        theV1InitialSlider.setPaintLabels(true);
        theV1InitialSlider.setOpaque(false);
        theV1InitialSlider.setMajorTickSpacing(2);
        theV1InitialSlider.setMinorTickSpacing(1);
        theV1InitialSlider.setSnapToTicks(true);
        add(theV1InitialSlider);

        // Mass 2 Initial V Label
        theV2InitialLabel.setBounds(1, 325, 220, 30);
        theV2InitialLabel.setFont(fntDialog15);
        theV2InitialLabel.setForeground(Color.white);
        add(theV2InitialLabel);

        // Mass 2 Initial V Field
        theV2InitialField.setBounds(170, 325, 50, 30);
        theV2InitialField.setOpaque(false);
        theV2InitialField.setBorder(null);
        theV2InitialField.setFont(fntDialog15);
        theV2InitialField.setForeground(Color.white);
        theV2InitialField.setEnabled(false);
        add(theV2InitialField);

        // Mass 2 Initial V Slider
        theV2InitialSlider.setBounds(20, 355, 200, 50);
        theV2InitialSlider.setForeground(Color.white);
        theV2InitialSlider.setPaintTicks(true);
        theV2InitialSlider.setPaintLabels(true);
        theV2InitialSlider.setOpaque(false);
        theV2InitialSlider.setMajorTickSpacing(2);
        theV2InitialSlider.setMinorTickSpacing(1);
        theV2InitialSlider.setEnabled(false);
        theV2InitialSlider.setSnapToTicks(true);
        add(theV2InitialSlider);

        // Divider between V inputs and calculations
        theVelocitiesDivider.setBounds(0, 420, 240, 5);
        theVelocitiesDivider.setForeground(Color.white);
        add(theVelocitiesDivider);

        // Run Button for Simulation
        theRunButton.setBounds(260, 20, 200, 30);
        theRunButton.setFont(fntDialog15);
        theRunButton.setForeground(Color.white);
        theRunButton.setBackground(Color.black);
        theRunButton.setBorder(BorderFactory.createLineBorder(Color.white));
        add(theRunButton);

        // Reset Button for Simulation
        theResetButton.setBounds(740, 20, 200, 30);
        theResetButton.setFont(fntDialog15);
        theResetButton.setForeground(Color.white);
        theResetButton.setBackground(Color.black);
        theResetButton.setBorder(BorderFactory.createLineBorder(Color.white));
        add(theResetButton);

        // Runs Calculations
        this.calculations();

        //Sets up the Simulation
        simulationSetup();

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
        theRunButton.addActionListener(this);
        theResetButton.addActionListener(this);
        theTimer.addActionListener(this);
    }
}
