import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class MemoryGameAWT extends Frame implements ActionListener {
    JButton[] cards = new JButton[16];
    List<String> images = new ArrayList<String>() {{
        add("bear"); add("bear"); add("fox"); add("fox");
        add("penguin"); add("penguin"); add("cat"); add("cat");
        add("dog"); add("dog"); add("owl"); add("owl");
        add("panda"); add("panda"); add("koala"); add("koala");
    }};

    int moves = 0;
    Label moveLabel;
    int firstIndex = -1;
    boolean[] matched = new boolean[16];
    String[] shuffledImages = new String[16];

    public MemoryGameAWT() {
        setTitle("Memory Game");
        setSize(400, 500);
        setLayout(null);
        setBackground(new Color(30, 60, 80));

        Panel topPanel = new Panel();
        topPanel.setLayout(null);
        topPanel.setBounds(50, 50, 300, 50);
        topPanel.setBackground(new Color(120, 80, 40));
        add(topPanel);

        moveLabel = new Label("0", Label.CENTER);
        moveLabel.setBounds(0, 0, 100, 50);
        moveLabel.setBackground(new Color(150, 100, 60));
        moveLabel.setForeground(Color.white);
        moveLabel.setFont(new Font("Arial", Font.BOLD, 24));
        topPanel.add(moveLabel);

        Label moveText = new Label("MOVES", Label.CENTER);
        moveText.setBounds(120, 0, 180, 50);
        moveText.setBackground(new Color(120, 80, 40));
        moveText.setForeground(Color.white);
        moveText.setFont(new Font("Arial", Font.BOLD, 24));
        topPanel.add(moveText);

        shuffleImages();

        int index = 0;
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                JButton btn = new JButton();
                btn.setBounds(50 + x * 75, 120 + y * 75, 70, 70);
                btn.setBackground(new Color(130, 170, 200));
                btn.setFont(new Font("Arial", Font.BOLD, 20));
                btn.setActionCommand(String.valueOf(index));
                btn.addActionListener(this);
                cards[index] = btn;
                add(btn);
                index++;
            }
        }

        setVisible(true);
    }

    public void shuffleImages() {
        Collections.shuffle(images);
        for (int i = 0; i < 16; i++) {
            shuffledImages[i] = images.get(i);
        }
    }

    public void actionPerformed(ActionEvent e) {
        int index = Integer.parseInt(e.getActionCommand());
        if (matched[index] || index == firstIndex) return;

        ImageIcon icon = new ImageIcon("C:/flip/" + shuffledImages[index] + ".jpg");
        Image image = icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        cards[index].setIcon(icon);

        if (firstIndex == -1) {
            firstIndex = index;
        } else {
            moves++;
            moveLabel.setText(String.valueOf(moves));

            if (shuffledImages[index].equals(shuffledImages[firstIndex])) {
                matched[index] = true;
                matched[firstIndex] = true;
                firstIndex = -1;
                if (checkWin()) showWinScreen();
            } else {
                Timer t = new Timer(500, new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        cards[index].setIcon(null);
                        cards[firstIndex].setIcon(null);
                        firstIndex = -1;
                    }
                });
                t.setRepeats(false);
                t.start();
            }
        }
    }

    public boolean checkWin() {
        for (int i = 0; i < 16; i++) {
            if (!matched[i]) return false;
        }
        return true;
    }

    public void showWinScreen() {
        Dialog winDialog = new Dialog(this, "You Win!", true);
        winDialog.setSize(350, 400);
        winDialog.setLayout(null);
        winDialog.setBackground(new Color(30, 60, 80));

        Label winTitle = new Label("YOU WIN!", Label.CENTER);
        winTitle.setBounds(50, 50, 250, 50);
        winTitle.setBackground(new Color(160, 110, 60));
        winTitle.setForeground(Color.white);
        winTitle.setFont(new Font("Arial", Font.BOLD, 30));
        winDialog.add(winTitle);

        Label star = new Label("*", Label.CENTER);
        star.setBounds(125, 110, 100, 100);
        star.setFont(new Font("Arial", Font.BOLD, 60));
        star.setForeground(new Color(255, 215, 0));
        winDialog.add(star);

        Label congrats = new Label("Congratulations!", Label.CENTER);
        congrats.setBounds(50, 220, 250, 30);
        congrats.setFont(new Font("Arial", Font.BOLD, 20));
        congrats.setForeground(Color.white);
        winDialog.add(congrats);

        Label moveText = new Label("Moves", Label.CENTER);
        moveText.setBounds(50, 250, 250, 30);
        moveText.setFont(new Font("Arial", Font.BOLD, 18));
        moveText.setForeground(Color.white);
        winDialog.add(moveText);

        Label moveValue = new Label(String.valueOf(moves), Label.CENTER);
        moveValue.setBounds(50, 280, 250, 30);
        moveValue.setFont(new Font("Arial", Font.BOLD, 22));
        moveValue.setForeground(Color.white);
        winDialog.add(moveValue);

        Button ok = new Button("OK");
        ok.setBounds(120, 330, 100, 40);
        ok.setFont(new Font("Arial", Font.BOLD, 20));
        ok.setBackground(new Color(200, 140, 60));
        ok.setForeground(Color.white);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                winDialog.setVisible(false);
                System.exit(0);
            }
        });
        winDialog.add(ok);

        winDialog.setLocationRelativeTo(this);
        winDialog.setVisible(true);
    }

    public static void main(String[] args) {
        new MemoryGameAWT();
    }
}
