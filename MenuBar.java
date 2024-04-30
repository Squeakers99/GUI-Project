import javax.swing.*;

public class MenuBar{
    JMenuBar theMenuBar = new JMenuBar();
    JMenu theSimulationsMenu = new JMenu("Simulations");    
    JMenuItem theElasticSimulation = new JMenuItem("Elastic Simulation");
    JMenuItem theInelasticSimulation = new JMenuItem("Inelastic Simulation");
    JMenu theQuiz = new JMenu("Quiz");
    JMenu theLeaderboard = new JMenu("Leaderboard");

    public MenuBar() {
        this.theSimulationsMenu.add(this.theElasticSimulation);
        this.theSimulationsMenu.add(this.theInelasticSimulation);
        this.theMenuBar.add(this.theSimulationsMenu);
        this.theMenuBar.add(this.theQuiz);
        this.theMenuBar.add(this.theLeaderboard);
    }
}
