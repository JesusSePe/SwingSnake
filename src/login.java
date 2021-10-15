import javax.swing.*;

public class login {
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
                    System.out.println("Start game");
                } else {
                    JOptionPane optionPane = new JOptionPane("Please, insert a user name.", JOptionPane.ERROR_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Failure");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                    exit = false;
                }
            } else if (result == JOptionPane.NO_OPTION){
                System.out.println("Ranking window");
                exit = true;
            } else if (result == JOptionPane.CANCEL_OPTION){
                System.exit(0);
                exit = true;
            }
        }

    }
}