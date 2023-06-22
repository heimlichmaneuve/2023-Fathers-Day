import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class FDC extends JFrame implements ActionListener {
    public static JFrame mainFrame;
    public static JPanel mainPanel;
    public ImageIcon envelope;
    public JLabel envelopeLabel;
    public JButton open;

    public FDC() {
        mainFrame = new JFrame("Father's Day Card");
        setPreferredSize(new Dimension(2240, 1260));
        pack();

        envelope = new ImageIcon("/Users/brian/Documents/Java/Project5 - 2023FathersDayCard/2023FathersDayCard/FDC Icon Images/FDEnvelope.png");
        Image scaledEnvelope = envelope.getImage().getScaledInstance(2240, 1260, Image.SCALE_SMOOTH);
        envelope = new ImageIcon(scaledEnvelope);
        envelopeLabel = new JLabel(envelope);
        envelopeLabel.setBounds(0, 0, 2240, 1260);

        open = new JButton("OPEN");
        Font envelopeFont = new Font("Dialog", Font.BOLD, 40);
        open.setFont(envelopeFont);
        open.setBackground(Color.BLUE);
        open.setOpaque(true);
        open.addActionListener(this);
        open.setBounds(1008, 567, 224, 126);

        mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.CYAN);
        add(envelopeLabel);
        add(open);
        getContentPane().add(mainPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == open) {
            getContentPane().removeAll();
            CardContent FathersDay2023 = new CardContent();
            getContentPane().add(FathersDay2023);
            setVisible(true);
        }
    }

    public static void main(String[] args) throws Exception {
        FDC FathersDay2023 = new FDC();
    }   
}
