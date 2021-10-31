import javax.swing.*;

public class login {
    static Player player;
    public login(){
        boolean exit = false;
        while (!exit){
            Object[] loginOptions = { "Play Game", "Ranking", "Quit" };

            JPanel panel = new JPanel();
            panel.add(new JLabel("Welcome to SwingSnake. Please, enter your username."));
            JTextField textField = new JTextField(10);
            panel.add(textField);

            int result = JOptionPane.showOptionDialog(null, panel, "Welcome",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, loginOptions, null);
            if (result == JOptionPane.YES_OPTION){
                if (Integer.parseInt(String.valueOf(textField.getText().length()) )> 0 ){
                    exit = true;
                    player = new Player(textField.getText(), 0);
                    new FramePrincipal();
                } else {
                    JOptionPane optionPane = new JOptionPane("Please, insert a user name.", JOptionPane.ERROR_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Failure");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                    exit = false;
                }
            } else if (result == JOptionPane.NO_OPTION){
                exit = true;
                new ranking();
            } else if (result == JOptionPane.CANCEL_OPTION){
                System.exit(0);
                exit = true;
            }
        }
    }

    public static Player getPlayer() {
        return player;
    }
}