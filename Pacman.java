
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

class pacman extends JPanel {
    int rowCount=21;
    int columnCount=19;
    int tileSize=32;
    int boardWidth = columnCount*tileSize;
    int boardHieght = rowCount*tileSize;

    private Image wallImage;
    private Image blueGhostImage;
    private Image orangeGhostImage;
    private Image pinkGhostImage;
    private Image redGhostImage;

    private Image pacmanUP;
    private Image pacmanDown;
    private Image pacmanRight;
    private Image pacmanLeftImage;


    
    pacman()
    {
        setPreferredSize(new Dimension(boardWidth,boardHieght));
        setBackground(Color.BLACK);

        wallImage = new ImageIcon(getClass().getResource("./wall.png")).getImage();
        blueGhostImage = new ImageIcon(getClass().getResource("./blueGhost.png")).getImage();
        orangeGhostImage = new ImageIcon(getClass().getResource("./orangeGhost.png")).getImage();
        redGhostImage = new ImageIcon(getClass().getResource("./redGhost.png")).getImage();
        pinkGhostImage = new ImageIcon(getClass().getResource("./pinkGhost.png")).getImage();
        
        pacmanUP = new ImageIcon(getClass().getResource("./pacmanUp.png")).getImage();
        pacmanDown = new ImageIcon(getClass().getResource("./pacmanDown.png")).getImage();
        pacmanRight = new ImageIcon(getClass().getResource("./pacmanRight.png")).getImage();
        pacmanLeftImage = new ImageIcon(getClass().getResource("./pacmanLeft.png")).getImage();
    }
}