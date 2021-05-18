import javax.swing.*;
import java.awt.event.ActionListener;

public class view extends JFrame{
    private JTextField time;
    private JPanel panel1;
    private JButton exitButton;
    private JButton score;
    private JList list;
    private DefaultListModel listModel;

    view(){
        this.add(panel1);
        listModel = new DefaultListModel();
        list.setModel(listModel);
        list.setVisible(false);
        time.setEditable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.setVisible(true);
    }
    void ExitButton(ActionListener actionListener){
        this.exitButton.addActionListener(actionListener);
    }
    public void setTime(long i){
        time.setText(String.valueOf(i));
    }

    public String getTime(){
        return time.getText();
    }

    public void scoreboard(user[] user){
        if (!list.isVisible()){
            list.setVisible(true);
            time.setVisible(false);
            exitButton.setVisible(false);
            score.setText("Back to gaming?");
            for (int i = 0; i < 10; i++){
                listModel.addElement(user[i].getName() + " " + user[i].getScore());
            }
        } else{
            list.setVisible(false);
            time.setVisible(true);
            exitButton.setVisible(true);
            score.setText("scorebord");
        }
    }
    void topscore(ActionListener actionListener){
        this.score.addActionListener(actionListener);
    }
}

