import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class NumberGuessingGame extends JFrame {

    private int targetNumber;
    private int maxAttempts;
    private int attemptsLeft;
    private int maxRange; // Track maximum range for validation
    private int totalScore = 0;
    private int currentRound = 1;

    private Random random = new Random();
    private JTextField txtGuess;
    private JButton btnSubmit;
    private JButton btnPlayAgain;
    private JComboBox<String> cbDifficulty;
    private JLabel lblStatus;
    private JLabel lblAttempts;
    private JLabel lblScore;
    private JLabel lblRound;
    private JPanel mainPanel;

    public NumberGuessingGame() {
        setTitle("Task 2 - Number Guessing Game");
        setSize(420, 440);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponent();
        startNewRound();
    }
    private void initComponent() {
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel lblTitle = new JLabel("Number Guessing Game", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(lblTitle, gbc);
        JLabel lblDiff = new JLabel("Difficulty Level:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(lblDiff, gbc);

        String[] levels = {"Easy (1-50, 10 Attempts)", "Medium (1-100, 7 Attempts)", "Hard (1-200, 5 Attempts)"};
        cbDifficulty = new JComboBox<>(levels);
        cbDifficulty.setSelectedIndex(1);
        cbDifficulty.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cbDifficulty.addActionListener(e -> startNewRound());
        gbc.gridx = 1;
        gbc.gridy = 1;

        mainPanel.add(cbDifficulty, gbc);
        lblRound = new JLabel("Round: 1");
        lblRound.setFont(new Font("Arial", Font.BOLD, 13));
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(lblRound, gbc);
        lblScore = new JLabel("Total Score: 0");
        lblScore.setFont(new Font("Arial", Font.BOLD, 13));
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(lblScore, gbc);

        lblStatus = new JLabel("Enter a guess to begin!", SwingConstants.CENTER);
        lblStatus.setFont(new Font("Arial", Font.PLAIN, 14));
        lblStatus.setPreferredSize(new Dimension(350, 25));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        mainPanel.add(lblStatus, gbc);

        txtGuess = new JTextField();
        txtGuess.setHorizontalAlignment(JTextField.CENTER);
        txtGuess.setFont(new Font("Arial", Font.PLAIN, 16));

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        mainPanel.add(txtGuess, gbc);

        btnSubmit = new JButton("Submit Guess");
        btnSubmit.setFont(new Font("Arial", Font.BOLD, 14));
        btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSubmit.addActionListener(e -> checkUserGuess());
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        mainPanel.add(btnSubmit, gbc);
        lblAttempts = new JLabel("Attempts Left: 7", SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        mainPanel.add(lblAttempts, gbc);
        btnPlayAgain = new JButton("Play Again");
        btnPlayAgain.setFont(new Font("Arial", Font.BOLD, 14));
        btnPlayAgain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnPlayAgain.setEnabled(false);

        btnPlayAgain.addActionListener(e -> {
            currentRound++;
            lblRound.setText("Round: " + currentRound);
            startNewRound();
        });
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        mainPanel.add(btnPlayAgain, gbc);

        txtGuess.addActionListener(e -> checkUserGuess());

        add(mainPanel);
    }
    private void startNewRound() {
        int index = cbDifficulty.getSelectedIndex();
        if (index == 0) {
            maxRange = 50;
            maxAttempts = 10;
        } else if (index == 1) {
            maxRange = 100;
            maxAttempts = 7;
        } else if (index == 2) {
            maxRange = 200;
            maxAttempts = 5;
        }

        targetNumber = random.nextInt(maxRange) + 1;
        attemptsLeft = maxAttempts;

        lblStatus.setText("Guess a number between 1 and " + maxRange);
        lblStatus.setForeground(Color.BLACK);
        lblAttempts.setText("Attempts Left: " + attemptsLeft);

        txtGuess.setText("");
        txtGuess.setEnabled(true);
        btnSubmit.setEnabled(true);
        btnPlayAgain.setEnabled(false);

        getRootPane().setDefaultButton(btnSubmit);

        mainPanel.revalidate();
        mainPanel.repaint();
        SwingUtilities.invokeLater(() -> txtGuess.requestFocusInWindow());
    }

    private void checkUserGuess() {
        if (!btnSubmit.isEnabled()) {
            return;
        }
        String input = txtGuess.getText().trim();
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Warning", JOptionPane.WARNING_MESSAGE);
            SwingUtilities.invokeLater(() -> txtGuess.requestFocusInWindow());
            return;
        }
        try {
            int guess = Integer.parseInt(input);
            if (guess < 1 || guess > maxRange) {
                JOptionPane.showMessageDialog(this,
                        "Out of bounds! Please enter a number between 1 and " + maxRange + ".",
                        "Invalid Guess",
                        JOptionPane.WARNING_MESSAGE);
                txtGuess.setText("");
                SwingUtilities.invokeLater(() -> txtGuess.requestFocusInWindow());
                return;
            }

            attemptsLeft--;
            int attemptsUsed = maxAttempts - attemptsLeft;
            if (guess == targetNumber) {
                int scoreEarned = (attemptsLeft + 1) * 10;
                totalScore += scoreEarned;
                lblScore.setText("Total Score: " + totalScore);
                lblStatus.setText("Correct! Round " + currentRound + " — guessed in " + attemptsUsed + " attempts.");
                lblStatus.setForeground(new Color(0, 128, 0));
                lblAttempts.setText("Attempts Left: " + attemptsLeft);
                finishRound();
            } else if (attemptsLeft == 0) {
                lblStatus.setText("You Lost! The correct number was " + targetNumber);
                lblStatus.setForeground(Color.RED);
                lblAttempts.setText("Attempts Left: 0");
                finishRound();
            } else if (guess < targetNumber) {
                lblStatus.setText("Too Low!");
                lblStatus.setForeground(Color.BLUE);
                lblAttempts.setText("Attempts Left: " + attemptsLeft);
            } else {
                lblStatus.setText("Too High!");
                lblStatus.setForeground(Color.BLUE);
                lblAttempts.setText("Attempts Left: " + attemptsLeft);
            }
            txtGuess.setText("");
            if (attemptsLeft > 0 && guess != targetNumber) {
                SwingUtilities.invokeLater(() -> txtGuess.requestFocusInWindow());
            }
            mainPanel.revalidate();
            mainPanel.repaint();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid entry! Please enter numbers only.", "Error", JOptionPane.ERROR_MESSAGE);
            txtGuess.setText("");
            SwingUtilities.invokeLater(() -> txtGuess.requestFocusInWindow());
        }
    }
    private void finishRound() {
        txtGuess.setEnabled(false);
        btnSubmit.setEnabled(false);
        btnPlayAgain.setEnabled(true);
        getRootPane().setDefaultButton(btnPlayAgain);
        SwingUtilities.invokeLater(() -> btnPlayAgain.requestFocusInWindow());
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new NumberGuessingGame().setVisible(true);
        });
    }
}