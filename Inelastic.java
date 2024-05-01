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
        
        //Method to draw the labels
        drawLabels();
    }

    // Constructor
    public Inelastic(){
        super();
    }
}
