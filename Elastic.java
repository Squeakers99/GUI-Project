import javax.swing.*;
import java.awt.Dimension;

/*
 ? Relative Velocity Calculations to put the system in the frame of M2
 if(dblV2Initial >= dblV1Initial) {
    TODO: Pop up window saying collision will not happen
 }else{
    dblV1Initial = dblV1Initial - dblV2Initial
 }

 ? Elastic Collision Formulas assuming V2 is 0 
 * dblV1Final = ( (dblM1 - dblM2) * dblV1Initial) / (dblM1 + dblM2)
 * dblV2Final = ( 2 * dblM1 * dblV1Initial) / (dblM1+dblM2)
 * 
 
 ? Relative Colision Velocity Calculations to put Velocities back into their original frame
 * dblV1Final = dblV1Final + dblV2Initial
 * dblV2Final = dblV2Final + dblV2Initial
 
 ? Momentum Calculations
 * dblP1Initial = dblM1 * dblV1Initial
 * dblP2Initial = dblM2 * dblV2Initial
 * dblP1Final = dblM1 * dblV1Final
 * dblP2Final = dblM2 * dblV2Final
*/

public class Elastic {
    JPanel theElasticPanel = new JPanel();

    public Elastic() {
        theElasticPanel.setPreferredSize(new Dimension(960, 540));
    }
}