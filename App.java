
import javax.swing.JFrame;


public class App{
    public static void main(String[] args) {
        int rowCount=21;
        int columnCount=19;
        int tileSize=32;
        int boardWidth = columnCount*tileSize;
        int boardHieght = rowCount*tileSize;

        JFrame GameWindow= new JFrame("Pac Man");
        GameWindow.setLocationRelativeTo(null);
        GameWindow.setResizable(false);
        GameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameWindow.setSize(boardWidth,boardHieght);

        pacman pacmanGame=new pacman();
        GameWindow.add(pacmanGame);
       GameWindow.pack();
       pacmanGame.requestFocus();
       GameWindow.setVisible(true);

    }
}