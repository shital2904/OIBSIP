import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExamApplication extends JFrame {

    private static final String LOGIN = "LOGIN";
    private static final String REGISTER = "REGISTER";
    private static final String PROFILE = "PROFILE";
    private static final String SUBJECT = "SUBJECT";
    private static final String EXAM = "EXAM";
    private static final String RESULT = "RESULT";

    private static final int EXAM_DURATION_SECONDS = 30 * 60;

    private final CardLayout cardLayout = new CardLayout();
    private final JPanel mainPanel = new JPanel(cardLayout);
    private final UserStore userStore = new UserStore();
    private final Map<String, List<Question>> questionBank = QuestionBank.getAllQuestions();

    private final JTextField usernameField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();

    private final JTextField registerNameField = new JTextField();
    private final JTextField registerUsernameField = new JTextField();
    private final JPasswordField registerPasswordField = new JPasswordField();
    private final JPasswordField confirmPasswordField = new JPasswordField();

    private final JTextField displayNameField = new JTextField();
    private final JPasswordField newPasswordField = new JPasswordField();

    private final JLabel examSubjectLabel = new JLabel();
    private final JLabel questionNumberLabel = new JLabel();
    private final JLabel timerLabel = new JLabel();
    private final JLabel questionLabel = new JLabel();
    private final JLabel answeredLabel = new JLabel();

    private final JProgressBar questionProgress = new JProgressBar();

    private final JRadioButton[] optionButtons = new JRadioButton[4];
    private final ButtonGroup optionGroup = new ButtonGroup();

    private JTextArea resultTextArea;

    private User currentUser;
    private String selectedSubject;

    private List<Question> questions = new ArrayList<>();
    private int[] selectedAnswers = new int[0];

    private int currentQuestion;
    private int remainingSeconds;
    private int timeTakenSeconds;

    private Timer examTimer;
    private boolean examInProgress;

    public ExamApplication() {
        setTitle("Online Examination System");
        setSize(720, 460);
        setMinimumSize(new Dimension(680, 430));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        mainPanel.add(createLoginPanel(), LOGIN);
        mainPanel.add(createRegistrationPanel(), REGISTER);
        mainPanel.add(createProfilePanel(), PROFILE);
        mainPanel.add(createSubjectPanel(), SUBJECT);
        mainPanel.add(createExamPanel(), EXAM);
        mainPanel.add(createResultPanel(), RESULT);

        add(mainPanel);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                handleWindowClosing();
            }
        });

        showCard(LOGIN);
    }

    private JPanel createLoginPanel() {
        JPanel outer = new JPanel(new GridBagLayout());
        JPanel panel = createCardPanel(390, 260);

        JLabel title = createTitle("Online Examination System", 22);

        setSmallField(usernameField, 220);
        setSmallField(passwordField, 220);

        JButton loginButton = createButton("Login", 100, 31);
        JButton registerButton = createButton("Create Account", 140, 31);

        loginButton.addActionListener(e -> login());
        registerButton.addActionListener(e -> showCard(REGISTER));

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        buttons.add(loginButton);
        buttons.add(registerButton);

        panel.add(title);
        panel.add(space(13));
        panel.add(labeledField("Username", usernameField));
        panel.add(space(6));
        panel.add(labeledField("Password", passwordField));
        panel.add(space(12));
        panel.add(buttons);

        outer.add(panel);
        return outer;
    }

    private JPanel createRegistrationPanel() {
        JPanel outer = new JPanel(new GridBagLayout());
        JPanel panel = createCardPanel(420, 320);

        JLabel title = createTitle("Create Account", 22);

        setSmallField(registerNameField, 220);
        setSmallField(registerUsernameField, 220);
        setSmallField(registerPasswordField, 220);
        setSmallField(confirmPasswordField, 220);

        JButton registerButton = createButton("Register", 105, 31);
        JButton backButton = createButton("Back", 85, 31);

        registerButton.addActionListener(e -> registerUser());
        backButton.addActionListener(e -> showCard(LOGIN));

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        buttons.add(registerButton);
        buttons.add(backButton);

        panel.add(title);
        panel.add(space(8));
        panel.add(labeledField("Display Name", registerNameField));
        panel.add(space(5));
        panel.add(labeledField("Username", registerUsernameField));
        panel.add(space(5));
        panel.add(labeledField("Password", registerPasswordField));
        panel.add(space(5));
        panel.add(labeledField("Confirm", confirmPasswordField));
        panel.add(space(10));
        panel.add(buttons);

        outer.add(panel);
        return outer;
    }

    private JPanel createProfilePanel() {
        JPanel outer = new JPanel(new GridBagLayout());
        JPanel panel = createCardPanel(420, 260);

        JLabel title = createTitle("Update Profile", 22);

        JLabel message = new JLabel("Update your details before starting the exam.", SwingConstants.CENTER);
        message.setFont(new Font("SansSerif", Font.PLAIN, 12));
        message.setAlignmentX(Component.CENTER_ALIGNMENT);

        setSmallField(displayNameField, 220);
        setSmallField(newPasswordField, 220);

        JButton continueButton = createButton("Save & Continue", 140, 31);
        JButton logoutButton = createButton("Logout", 85, 31);

        continueButton.addActionListener(e -> updateProfileAndContinue());
        logoutButton.addActionListener(e -> logout());

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        buttons.add(continueButton);
        buttons.add(logoutButton);

        panel.add(title);
        panel.add(space(5));
        panel.add(message);
        panel.add(space(12));
        panel.add(labeledField("Display Name", displayNameField));
        panel.add(space(6));
        panel.add(labeledField("New Password", newPasswordField));
        panel.add(space(11));
        panel.add(buttons);

        outer.add(panel);
        return outer;
    }

    private JPanel createSubjectPanel() {
        JPanel outer = new JPanel(new GridBagLayout());
        JPanel panel = createCardPanel(470, 345);

        JLabel title = createTitle("Select Examination Subject", 21);
        title.setMaximumSize(new Dimension(410, 30));

        JLabel message = new JLabel("Choose one subject to start the examination.", SwingConstants.CENTER);
        message.setFont(new Font("SansSerif", Font.PLAIN, 12));
        message.setAlignmentX(Component.CENTER_ALIGNMENT);
        message.setMaximumSize(new Dimension(410, 25));

        JPanel subjectsPanel = new JPanel(new GridLayout(5, 1, 0, 2));
        ButtonGroup subjectGroup = new ButtonGroup();

        for (String subject : questionBank.keySet()) {
            JRadioButton button = new JRadioButton(subject);
            button.setFont(new Font("SansSerif", Font.PLAIN, 14));
            button.setFocusPainted(false);
            button.setBorder(
                    BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                            BorderFactory.createEmptyBorder(3, 8, 3, 8)
                    )
            );
            button.setOpaque(true);
            button.setBackground(Color.WHITE);

            button.addActionListener(e -> selectedSubject = subject);

            subjectGroup.add(button);
            subjectsPanel.add(button);
        }

        JButton backButton = createButton("Back", 85, 31);
        JButton startButton = createButton("Start Exam", 115, 31);

        backButton.addActionListener(e -> showCard(PROFILE));
        startButton.addActionListener(e -> startSelectedExam());

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        buttons.add(backButton);
        buttons.add(startButton);

        panel.add(title);
        panel.add(space(3));
        panel.add(message);
        panel.add(space(8));
        panel.add(subjectsPanel);
        panel.add(space(8));
        panel.add(buttons);

        outer.add(panel);
        return outer;
    }

    private JPanel createExamPanel() {
        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(12, 18, 12, 18));

        JPanel top = new JPanel(new BorderLayout(8, 0));

        examSubjectLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        questionNumberLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));

        JPanel info = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        info.add(examSubjectLabel);
        info.add(questionNumberLabel);

        timerLabel.setFont(new Font("Monospaced", Font.BOLD, 16));
        timerLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        top.add(info, BorderLayout.WEST);
        top.add(timerLabel, BorderLayout.EAST);

        JPanel progressPanel = new JPanel(new BorderLayout(6, 0));

        questionProgress.setStringPainted(true);
        questionProgress.setPreferredSize(new Dimension(0, 20));

        answeredLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));

        progressPanel.add(questionProgress, BorderLayout.CENTER);
        progressPanel.add(answeredLabel, BorderLayout.EAST);

        JPanel header = new JPanel(new BorderLayout(0, 5));
        header.add(top, BorderLayout.NORTH);
        header.add(progressPanel, BorderLayout.SOUTH);

        JPanel questionCard = new JPanel(new BorderLayout(6, 6));
        questionCard.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                        BorderFactory.createEmptyBorder(11, 13, 9, 13)
                )
        );

        questionLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        questionLabel.setVerticalAlignment(SwingConstants.TOP);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 0, 1));

        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i] = new JRadioButton();
            optionButtons[i].setFont(new Font("SansSerif", Font.PLAIN, 13));
            optionButtons[i].setFocusPainted(false);
            optionButtons[i].setMargin(new Insets(2, 4, 2, 4));
            optionGroup.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }

        questionCard.add(questionLabel, BorderLayout.NORTH);
        questionCard.add(optionsPanel, BorderLayout.CENTER);

        JButton previousButton = createButton("Previous", 90, 31);
        JButton nextButton = createButton("Next", 80, 31);
        JButton submitButton = createButton("Submit Exam", 115, 31);

        previousButton.addActionListener(e -> goToPreviousQuestion());
        nextButton.addActionListener(e -> goToNextQuestion());
        submitButton.addActionListener(e -> confirmManualSubmit());

        JPanel navigation = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        navigation.add(previousButton);
        navigation.add(nextButton);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(navigation, BorderLayout.WEST);
        bottom.add(submitButton, BorderLayout.EAST);

        panel.add(header, BorderLayout.NORTH);
        panel.add(questionCard, BorderLayout.CENTER);
        panel.add(bottom, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createResultPanel() {
        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(18, 28, 18, 28));

        JLabel title = createTitle("Examination Result", 23);

        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        resultTextArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        resultTextArea.setMargin(new Insets(10, 12, 10, 12));

        JButton logoutButton = createButton("Logout", 105, 31);
        logoutButton.addActionListener(e -> logout());

        JPanel bottom = new JPanel();
        bottom.add(logoutButton);

        panel.add(title, BorderLayout.NORTH);
        panel.add(new JScrollPane(resultTextArea), BorderLayout.CENTER);
        panel.add(bottom, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createCardPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(new javax.swing.BoxLayout(panel, javax.swing.BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(width, height));
        panel.setMaximumSize(new Dimension(width, height));

        panel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                        BorderFactory.createEmptyBorder(20, 26, 20, 26)
                )
        );

        return panel;
    }

    private JLabel createTitle(String text, int size) {
        JLabel title = new JLabel(text, SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, size));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        return title;
    }

    private JButton createButton(String text, int width, int height) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(width, height));
        button.setMinimumSize(new Dimension(width, height));
        button.setMaximumSize(new Dimension(width, height));
        button.setFont(new Font("SansSerif", Font.BOLD, 12));
        button.setFocusPainted(false);
        return button;
    }

    private void setSmallField(JTextField field, int width) {
        field.setPreferredSize(new Dimension(width, 28));
        field.setMinimumSize(new Dimension(width, 28));
        field.setMaximumSize(new Dimension(width, 28));
        field.setFont(new Font("SansSerif", Font.PLAIN, 13));
    }

    private JPanel labeledField(String label, JComponent field) {
        JPanel panel = new JPanel(new BorderLayout(8, 0));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelComponent = new JLabel(label);
        labelComponent.setPreferredSize(new Dimension(88, 28));

        panel.add(labelComponent, BorderLayout.WEST);
        panel.add(field, BorderLayout.CENTER);

        return panel;
    }

    private Component space(int height) {
        return javax.swing.Box.createVerticalStrut(height);
    }

    private void login() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            showMessage("Please enter your username and password.", "Login", JOptionPane.WARNING_MESSAGE);
            return;
        }

        User user = userStore.authenticate(username, password);

        if (user == null) {
            showMessage("Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            return;
        }

        currentUser = user;

        loadProfileDetails();
        showCard(PROFILE);
    }

    private void registerUser() {
        String name = registerNameField.getText().trim();
        String username = registerUsernameField.getText().trim();
        String password = new String(registerPasswordField.getPassword());
        String confirm = new String(confirmPasswordField.getPassword());

        if (name.isEmpty() || username.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
            showMessage("Please fill in all fields.", "Registration", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (username.contains(" ")) {
            showMessage("Username cannot contain spaces.", "Registration", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (password.length() < 4) {
            showMessage("Password must contain at least 4 characters.", "Registration", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!password.equals(confirm)) {
            showMessage("Passwords do not match.", "Registration", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (userStore.usernameExists(username)) {
            showMessage("Username already exists. Choose another username.", "Registration", JOptionPane.WARNING_MESSAGE);
            return;
        }

        userStore.addUser(new User(username, password, name));

        registerNameField.setText("");
        registerUsernameField.setText("");
        registerPasswordField.setText("");
        confirmPasswordField.setText("");

        usernameField.setText(username);
        passwordField.setText("");

        showMessage("Account created successfully. You can now log in.", "Registration Successful", JOptionPane.INFORMATION_MESSAGE);

        showCard(LOGIN);
    }

    private void loadProfileDetails() {
        displayNameField.setText(currentUser.getDisplayName());
        newPasswordField.setText("");
    }

    private void updateProfileAndContinue() {
        String displayName = displayNameField.getText().trim();
        String newPassword = new String(newPasswordField.getPassword());

        if (displayName.isEmpty()) {
            showMessage("Display name cannot be empty.", "Profile Update", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (newPassword.isEmpty()) {
            showMessage("Please enter a new password.", "Profile Update", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (newPassword.length() < 4) {
            showMessage("Password must contain at least 4 characters.", "Profile Update", JOptionPane.WARNING_MESSAGE);
            return;
        }

        currentUser.setDisplayName(displayName);
        currentUser.setPassword(newPassword);

        selectedSubject = null;
        showCard(SUBJECT);
    }

    private void startSelectedExam() {
        if (selectedSubject == null) {
            showMessage("Please select a subject first.", "Select Subject", JOptionPane.WARNING_MESSAGE);
            return;
        }

        questions = new ArrayList<>(questionBank.get(selectedSubject));
        selectedAnswers = new int[questions.size()];
        resetAnswers();

        currentQuestion = 0;
        remainingSeconds = EXAM_DURATION_SECONDS;
        timeTakenSeconds = 0;
        examInProgress = true;

        examSubjectLabel.setText("Subject: " + selectedSubject);

        loadQuestion();
        startTimer();
        showCard(EXAM);
    }

    private void startTimer() {
        if (examTimer != null) {
            examTimer.stop();
        }

        examTimer = new Timer(1000, e -> {
            remainingSeconds--;
            timeTakenSeconds++;

            updateTimerLabel();

            if (remainingSeconds <= 0) {
                examTimer.stop();
                examInProgress = false;
                submitExam(true);
            }
        });

        updateTimerLabel();
        examTimer.start();
    }

    private void updateTimerLabel() {
        int minutes = remainingSeconds / 60;
        int seconds = remainingSeconds % 60;

        timerLabel.setText(String.format("Time Left: %02d:%02d", minutes, seconds));

        if (remainingSeconds <= 60) {
            timerLabel.setForeground(Color.RED);
        } else {
            timerLabel.setForeground(Color.DARK_GRAY);
        }
    }

    private void loadQuestion() {
        Question question = questions.get(currentQuestion);

        questionNumberLabel.setText("Question " + (currentQuestion + 1) + " of " + questions.size());

        questionLabel.setText("<html><div style='width:600px;'>" + question.getText() + "</div></html>");

        optionGroup.clearSelection();

        String[] options = question.getOptions();

        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i].setText((char) ('A' + i) + ".  " + options[i]);
        }

        int savedAnswer = selectedAnswers[currentQuestion];

        if (savedAnswer >= 0) {
            optionButtons[savedAnswer].setSelected(true);
        }

        updateQuestionProgress();
    }

    private void updateQuestionProgress() {
        int answered = 0;

        for (int answer : selectedAnswers) {
            if (answer >= 0) {
                answered++;
            }
        }

        questionProgress.setMaximum(questions.size());
        questionProgress.setValue(currentQuestion + 1);
        questionProgress.setString("Question " + (currentQuestion + 1) + " / " + questions.size());

        answeredLabel.setText("Answered: " + answered + " / " + questions.size());
    }

    private void saveCurrentAnswer() {
        for (int i = 0; i < optionButtons.length; i++) {
            if (optionButtons[i].isSelected()) {
                selectedAnswers[currentQuestion] = i;
                updateQuestionProgress();
                return;
            }
        }

        selectedAnswers[currentQuestion] = -1;
        updateQuestionProgress();
    }

    private void goToNextQuestion() {
        saveCurrentAnswer();

        if (currentQuestion < questions.size() - 1) {
            currentQuestion++;
            loadQuestion();
        }
    }

    private void goToPreviousQuestion() {
        saveCurrentAnswer();

        if (currentQuestion > 0) {
            currentQuestion--;
            loadQuestion();
        }
    }

    private void confirmManualSubmit() {
        saveCurrentAnswer();

        int unanswered = 0;

        for (int answer : selectedAnswers) {
            if (answer == -1) {
                unanswered++;
            }
        }

        String message;

        if (unanswered == 0) {
            message = "Are you sure you want to submit the exam?";
        } else {
            message = "You have " + unanswered + " unanswered question(s).\nAre you sure you want to submit?";
        }

        int choice = JOptionPane.showConfirmDialog(
                this,
                message,
                "Confirm Submission",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (choice == JOptionPane.YES_OPTION) {
            submitExam(false);
        }
    }

    private void submitExam(boolean automatic) {
        if (!automatic) {
            saveCurrentAnswer();
        }

        if (examTimer != null) {
            examTimer.stop();
        }

        examInProgress = false;

        int score = 0;
        int correct = 0;
        int incorrect = 0;
        int unanswered = 0;

        StringBuilder breakdown = new StringBuilder();

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            int selected = selectedAnswers[i];

            if (selected == question.getCorrectAnswer()) {
                score++;
                correct++;
                breakdown.append(String.format("Question %2d : Correct%n", i + 1));
            } else if (selected == -1) {
                unanswered++;
                breakdown.append(String.format("Question %2d : Unanswered%n", i + 1));
            } else {
                incorrect++;
                breakdown.append(String.format("Question %2d : Incorrect%n", i + 1));
            }
        }

        String submissionType = automatic ? "Auto-submitted because time expired." : "Submitted manually.";

        String result = "Student : " + currentUser.getDisplayName() + "\n"
                + "Username: " + currentUser.getUsername() + "\n"
                + "Subject : " + selectedSubject + "\n\n"
                + "Score      : " + score + " / " + questions.size() + "\n"
                + "Correct    : " + correct + "\n"
                + "Incorrect  : " + incorrect + "\n"
                + "Unanswered : " + unanswered + "\n"
                + "Time Taken : " + formatTime(timeTakenSeconds) + "\n"
                + submissionType + "\n\n"
                + "Answer Breakdown\n"
                + "-------------------------\n"
                + breakdown;

        resultTextArea.setText(result);
        showCard(RESULT);
    }

    private String formatTime(int totalSeconds) {
        return String.format("%02d minutes %02d seconds", totalSeconds / 60, totalSeconds % 60);
    }

    private void handleWindowClosing() {
        if (!examInProgress) {
            dispose();
            return;
        }

        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to quit the exam?\nYour current progress will be lost.",
                "Quit Exam",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (choice == JOptionPane.YES_OPTION) {
            if (examTimer != null) {
                examTimer.stop();
            }
            dispose();
        }
    }

    private void logout() {
        if (examTimer != null) {
            examTimer.stop();
        }

        examInProgress = false;
        currentQuestion = 0;
        remainingSeconds = EXAM_DURATION_SECONDS;
        timeTakenSeconds = 0;
        selectedSubject = null;

        questions.clear();
        selectedAnswers = new int[0];

        usernameField.setText("");
        passwordField.setText("");
        displayNameField.setText("");
        newPasswordField.setText("");

        showCard(LOGIN);
    }

    private void resetAnswers() {
        for (int i = 0; i < selectedAnswers.length; i++) {
            selectedAnswers[i] = -1;
        }
    }

    private void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

    private void showCard(String cardName) {
        cardLayout.show(mainPanel, cardName);
    }
}