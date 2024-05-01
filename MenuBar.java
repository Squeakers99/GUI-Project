import javax.swing.*;

public class MenuBar{
    JMenuBar theMenuBar = new JMenuBar();
    JMenu theSimulationsMenu = new JMenu("Simulations");    
    JMenuItem theElasticSimulation = new JMenuItem("Elastic Simulation");
    JMenuItem theInelasticSimulation = new JMenuItem("Inelastic Simulation");
    JMenu theQuiz = new JMenu("Quiz");
    JMenu theLeaderboard = new JMenu("Leaderboard");

    public MenuBar() {
        theSimulationsMenu.add(theElasticSimulation);
        theSimulationsMenu.add(theInelasticSimulation);
        theMenuBar.add(theSimulationsMenu);
        theMenuBar.add(theQuiz);
        theMenuBar.add(theLeaderboard);
    }
}
