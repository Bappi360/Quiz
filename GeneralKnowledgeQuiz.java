import java.util.*;
import java.io.*;

class Question {
    String questionText;
    String[] options;
    int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean askQuestion(Scanner sc) {
        System.out.println("\n" + questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Your answer: ");
        int ans = sc.nextInt();
        return ans == correctAnswer;
    }
}

public class GeneralKnowledgeQuiz {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        Question[] questions = {
            new Question(
                "What is the capital of Bangladesh?",
                new String[]{"Dhaka", "Khulna", "Chittagong", "Rajshahi"},
                1
            ),
            new Question(
                "Who discovered gravity?",
                new String[]{"Albert Einstein", "Newton", "Galileo", "Kepler"},
                2
            ),
            new Question(
                "Which planet is known as the Red Planet?",
                new String[]{"Earth", "Jupiter", "Mars", "Venus"},
                3
            ),
            new Question(
                "What is the national flower of Bangladesh?",
                new String[]{"Water Lily", "Rose", "Tulip", "Sunflower"},
                1
            ),
            new Question(
                "Which gas do plants absorb?",
                new String[]{"Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen"},
                3
            )
        };

        int score = 0;

        System.out.println("\n===== High School General Knowledge Quiz =====");

        for (Question q : questions) {
            if (q.askQuestion(sc)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
            }
        }

        System.out.println("\n=============================");
        System.out.println("Student: " + name);
        System.out.println("Your Score: " + score + "/" + questions.length);
        System.out.println("=============================");

        // Save results to file
        try {
            FileWriter fw = new FileWriter("results.txt", true);
            fw.write("Name: " + name + " | Score: " + score + "/" + questions.length + "\n");
            fw.close();
            System.out.println("Your result has been saved to results.txt");
        } catch (Exception e) {
            System.out.println("Error saving result.");
        }

        sc.close();
    }
}
