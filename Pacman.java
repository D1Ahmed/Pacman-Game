
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashSet;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

class pacman extends JPanel {

class Block{
    int x;
    int y;
    int width;
    int hieght;

    Image image;
    int startX;
    int startY;


        public Block(Image image, int x, int y, int width,int hieght) {
           this.image=image;
           this.x=x;
           this.y=y;
           this.width=width; 
           this.hieght=hieght;
           this.startX=x;
           this.startY=y;
        }

    
    }

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

    private String[] tileMap = {
        "XXXXXXXXXXXXXXXXXXX",
        "X        X        X",
        "X XX XXX X XXX XX X",
        "X                 X",
        "X XX X XXXXX X XX X",
        "X    X       X    X",
        "XXXX XXXX XXXX XXXX",
        "OOOX X       X XOOO",
        "XXXX X XXrXX X XXXX",
        "O       bpo       O",
        "XXXX X XXXXX X XXXX",
        "OOOX X       X XOOO",
        "XXXX X XXXXX X XXXX",
        "X        X        X",
        "X XX XXX X XXX XX X",
        "X  X     P     X  X",
        "XX X X XXXXX X X XX",
        "X    X   X   X    X",
        "X XXXXXX X XXXXXX X",
        "X                 X",
        "XXXXXXXXXXXXXXXXXXX" 
    };


    HashSet<Block> walls;
    HashSet<Block> foods;
    HashSet<Block> ghosts;
    Block pacman;
    
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

        loadMap();
        
    }

    public void loadMap()
    {
        walls= new HashSet<Block>();
        foods= new HashSet<Block>();
        ghosts= new HashSet<Block>();

        //row slider yani u go top to bottom
        for(int r =0; r< rowCount;r++)
        {      //column slider yani u go left to right
            for(int c=0;c<columnCount;c++)
            {
                
                String row =tileMap[r];//will give u puri string at row0(L to R) i.e. XXXXXXX

                char tileMapchar= row.charAt(c);//wil give u row ki string(upr wala variable) ka char, i.e. X for index 0
                int x =c* tileSize;
                int y =r* tileSize;

                if(tileMapchar=='X')
                {
                    Block wall = new Block(wallImage, x, y, tileSize, tileSize);
                    walls.add(wall);
                }
                else if(tileMapchar=='b')
                {
                    Block ghost=new Block(blueGhostImage,x,y,tileSize,tileSize);
                    ghosts.add(ghost);
                }
                else if(tileMapchar=='o')
                {
                    Block ghost=new Block(orangeGhostImage,x,y,tileSize,tileSize);
                    ghosts.add(ghost);
                }
                else if(tileMapchar=='r')
                {
                    Block ghost=new Block(redGhostImage,x,y,tileSize,tileSize);
                    ghosts.add(ghost);
                }
                else if(tileMapchar=='p')
                {
                    Block ghost=new Block(pinkGhostImage,x,y,tileSize,tileSize);
                    ghosts.add(ghost);
                }
                else if(tileMapchar=='P')
                {
                    pacman=new Block(pacmanRight, x, y, tileSize, tileSize);
                }
                else if(tileMapchar==' ')
                {
                    Block food=new Block(null,x+14,y+14,4,4);
                    foods.add(food);
                }

            }
        }
    }
    public void paintComponent(Graphics g)
    {
        //calling the function from Jpannel extended class
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g)
    {
        g.drawImage(pacman.image,pacman.x,pacman.y,pacman.width,pacman.hieght,null);

        for(Block ghost: ghosts){
            g.drawImage(ghost.image, ghost.x,ghost.y,ghost.width,ghost.hieght,null);
        }
        for(Block wall:walls)
        {
            g.drawImage(wall.image,wall.x,wall.y,wall.width,wall.hieght,null);
        }
        for(Block food : foods)
        {
            g.fillRect(food.x,food.y,food.width,food.hieght);
        }
    }
}