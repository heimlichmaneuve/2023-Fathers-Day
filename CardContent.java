import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class CardContent extends JPanel {
    public JLabel topText;
    public JLabel bottomText;
    public JLabel dadLabel;
    public ImageIcon verticalBorder1;
    public JLabel verticalBorder1Label;
    public ImageIcon verticalBorder2;
    public JLabel verticalBorder2Label;
    public ImageIcon cloud;
    public JLabel cloudLabel;
    public Clip champions;

    public CardContent() {
        setBackground(new Color(135, 206, 250));
        setLayout(null);

        Font textFont = new Font("Times New Roman", Font.BOLD, 75);
        topText = new JLabel("HAPPY FATHER'S DAY ...");
        topText.setBounds(400, 100, 1440, 500);
        topText.setFont(textFont);
        topText.setForeground(Color.WHITE);
        topText.setHorizontalAlignment(SwingConstants.CENTER);
        bottomText = new JLabel("THANK YOU FOR BEING A GREAT DAD!");
        bottomText.setBounds(300, 660, 1640, 500);
        bottomText.setFont(textFont);
        bottomText.setForeground(Color.WHITE);
        bottomText.setHorizontalAlignment(SwingConstants.CENTER);

        add(topText);
        add(bottomText);

        
        try {
            File audioFile = new File("/Users/brian/Documents/Java/Project5 - 2023FathersDayCard/2023FathersDayCard/FDC Icon Images/Champions.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            champions = AudioSystem.getClip();
            champions.open(audioStream);
            champions.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        
        

        cloud = new ImageIcon("/Users/brian/Documents/Java/Project5 - 2023FathersDayCard/2023FathersDayCard/FDC Icon Images/Cloud.png");
        Image scaledCloud = cloud.getImage().getScaledInstance(1792, 300, Image.SCALE_SMOOTH);
        cloud = new ImageIcon(scaledCloud);
        cloudLabel = new JLabel(cloud);
        cloudLabel.setBounds(224, 30, 1792, 300);

        verticalBorder1 = new ImageIcon("/Users/brian/Documents/Java/Project5 - 2023FathersDayCard/2023FathersDayCard/FDC Icon Images/VerticalBorder1.png");
        Image scaledVerticalBorder1 = verticalBorder1.getImage().getScaledInstance(2240, 200, Image.SCALE_SMOOTH);
        verticalBorder1 = new ImageIcon(scaledVerticalBorder1);
        verticalBorder1Label = new JLabel(verticalBorder1);
        verticalBorder1Label.setBounds(0, 0, 2240, 200);

        verticalBorder2 = new ImageIcon("/Users/brian/Documents/Java/Project5 - 2023FathersDayCard/2023FathersDayCard/FDC Icon Images/VerticalBorder2.png");
        Image scaledVerticalBorder2 = verticalBorder2.getImage().getScaledInstance(2240, 200, Image.SCALE_SMOOTH);
        verticalBorder2 = new ImageIcon(scaledVerticalBorder2);
        verticalBorder2Label = new JLabel(verticalBorder2);
        verticalBorder2Label.setBounds(0, 1060, 2240, 200);

        add(cloudLabel);
        add(verticalBorder1Label);
        add(verticalBorder2Label);

        FDC.mainFrame.setLocationRelativeTo(null);
        FDC.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Timer wholeThingTimer = new Timer(300, new DadGeneration());
        wholeThingTimer.start();
    }   

    public class DadGeneration implements ActionListener {
        public DadGeneration() {
            generateDad();
        }

        public void actionPerformed(ActionEvent e) {
            Timer individualDadTimer = new Timer(300, new DadMovement());
            individualDadTimer.start();
            
        }
        
        class DadMovement implements ActionListener {
            boolean direction = true;

            public void actionPerformed(ActionEvent e) {     
                if (direction == true) {
                    if (dadLabel.getX() > 0) {
                        dadLabel.setBounds(dadLabel.getX() - 68, 530, 200, 200);
                        repaint();
                        setVisible(true);
                    }
                    else {
                        direction = false;
                    }
                }
                else if (direction == false) {
                    if (dadLabel.getX() < 2040) {
                        dadLabel.setBounds(dadLabel.getX() + 68, 530, 200, 200);
                        repaint();
                        setVisible(true);
                    }
                    else {
                        direction = true;
                    }
                }
                
            }
        }
    }

public void generateDad() {
        ImageIcon dad = new ImageIcon("/Users/brian/Documents/Java/Project5 - 2023FathersDayCard/2023FathersDayCard/FDC Icon Images/Dad.png");
        Image scaledDad = dad.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        dad = new ImageIcon(scaledDad);
        dadLabel = new JLabel(dad);
        dadLabel.setBounds(2040, 530, 200, 200);
        add(dadLabel);
    }
}
