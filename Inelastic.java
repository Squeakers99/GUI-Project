import java.awt.Color;

 //Extends Elastic because only thing different is the calculations done
public class Inelastic extends Elastic{
    // Methods
    @Override
    public void calculations(){
        //Sets all the variables
        dblM1 = Double.parseDouble(theM1Field.getText());
        dblM2 = Double.parseDouble(theM2Field.getText());
        dblV1Initial = Double.parseDouble(theV1InitialField.getText());
        dblV2Initial = Double.parseDouble(theV2InitialField.getText());

        //Calculations
        dblP1Initial = dblM1 * dblV1Initial;
        dblP2Initial = dblM2 * dblV2Initial;
        dblV1Final = (dblM1 * dblV1Initial + dblM2 * dblV2Initial) / (dblM1 + dblM2);
        dblV2Final = (dblM1 * dblV1Initial + dblM2 * dblV2Initial) / (dblM1 + dblM2);
        dblP1Final = dblM1 * dblV1Final;
        dblP2Final = dblM2 * dblV2Final;

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

    // Constructor
    public Inelastic(){
        super();
    }
}
