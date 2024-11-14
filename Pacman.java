
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

class pacman extends JPanel {
    int rowCount=21;
    int columnCount=19;
    int tileSize=32;
    int boardWidth = columnCount*tileSize;
    int boardHieght = rowCount*tileSize;
    
    pacman()
    {
        setPreferredSize(new Dimension(boardWidth,boardHieght));
        setBackground(Color.BLACK);
    }
}