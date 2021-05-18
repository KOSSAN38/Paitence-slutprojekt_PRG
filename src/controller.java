import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class controller {
    private view view;
    private counter counter;
    private boolean running;
    private databas databas;

    public controller(){
        view= new view();
        counter = new counter();
        running = true;
        databas = new databas();
        view.ExitButton(new exit());
        view.topscore(new score());
        update();
    }
    public void update(){
        while (running){
            view.setTime(counter.time());
        }
    }
    private class exit implements ActionListener{
        public void actionPerformed(ActionEvent e){
            running = false;
            try {
                databas.dbStore(JOptionPane.showInputDialog(null, "Whats ur nam?"), Integer.parseInt(view.getTime()));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            view.dispose();
        }
    }

    private class score implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                view.scoreboard(databas.dbShow());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
