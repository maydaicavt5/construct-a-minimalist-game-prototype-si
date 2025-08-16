import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Fuq4_Construct_a_Min extends JPanel {

    // Game State Variables
    private int playerX = 0;
    private int playerY = 0;
    private int targetX = 0;
    private int targetY = 0;
    private boolean gameOver = false;

    // Game Logic Variables
    private Random random = new Random();

    public Fuq4_Construct_a_Min() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!gameOver) {
                    int keyCode = e.getKeyCode();
                    if (keyCode == KeyEvent.VK_UP) {
                        movePlayer(0, -10);
                    } else if (keyCode == KeyEvent.VK_DOWN) {
                        movePlayer(0, 10);
                    } else if (keyCode == KeyEvent.VK_LEFT) {
                        movePlayer(-10, 0);
                    } else if (keyCode == KeyEvent.VK_RIGHT) {
                        movePlayer(10, 0);
                    }
                }
            }
        });
    }

    private void movePlayer(int dx, int dy) {
        playerX += dx;
        playerY += dy;
        checkCollision();
        repaint();
    }

    private void checkCollision() {
        if (playerX == targetX && playerY == targetY) {
            gameOver = true;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(playerX, playerY, 10, 10);
        g.setColor(Color.RED);
        g.fillRect(targetX, targetY, 10, 10);
        if (gameOver) {
            g.setColor(Color.WHITE);
            g.drawString("Game Over!", 170, 200);
        }
    }

    public void startGame() {
        targetX = random.nextInt(380) + 10;
        targetY = random.nextInt(380) + 10;
        gameOver = false;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fuq4_Construct_a_Min");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Fuq4_Construct_a_Min game = new Fuq4_Construct_a_Min();
        frame.add(game);
        frame.pack();
        frame.setVisible(true);
        game.startGame();
    }
}