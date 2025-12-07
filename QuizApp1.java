import java.util.*;
import java.io.*;

class Question {
    private String question;
    private String[] options;
    private int answer;

    public Question(String q, String[] o, int a) {
        this.question = q;
        this.options = o;
        this.answer = a;
    }

    public String getQuestion() { return question; }
    public String[] getOptions() { return options; }
    public int getAnswer() { return answer; }
}

abstract class Subject {
    List<Question> questions = new ArrayList<>();
    public List<Question> getQuestions() { return questions; }
}

class Maths extends Subject {
    public Maths() {
        questions.add(new Question("What is the time complexity of binary search?",
                new String[]{"O(n)", "O(log n)", "O(n log n)", "O(1)"}, 2));
        questions.add(new Question("Which data structure uses FIFO?",
                new String[]{"Stack", "Queue", "Tree", "Graph"}, 2));
        questions.add(new Question("Which number system is base 16?",
                new String[]{"Binary", "Octal", "Hexadecimal", "Decimal"}, 3));
    }
}

class English extends Subject {
    public English() {
        questions.add(new Question("Correct plural of 'analysis'?",
                new String[]{"analysises", "analysiseses", "analyses", "analyzes"}, 3));
        questions.add(new Question("Choose correct sentence.",
                new String[]{"He don't like tea.", "He doesn't likes tea.",
                        "He doesn't like tea.", "He not like tea."}, 3));
        questions.add(new Question("Meaning of 'concise'?",
                new String[]{"Short and clear", "Confusing", "Very long", "Hidden"}, 1));
    }
}

class Science extends Subject {
    public Science() {
        questions.add(new Question("Which law states F = ma?",
                new String[]{"Newton's 1st Law", "Newton's 2nd Law",
                        "Newton's 3rd Law", "Law of Gravitation"}, 2));
        questions.add(new Question("Speed of light?",
                new String[]{"3×10^8 m/s", "3×10^6 m/s", "3×10^5 m/s", "3×10^7 m/s"}, 1));
        questions.add(new Question("Atomic number of Carbon?",
                new String[]{"4", "5", "6", "7"}, 3));
    }
}

class ResultSaver {
    public static void saveResult(String subject, int score, int total) {
        try (FileWriter fw = new FileWriter("results.txt", true)) {
            fw.write("Subject: " + subject + " Score: " + score + "/" + total + "\n");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
}

public class QuizApp1 {

    static int readInt(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Enter numbers only:");
                sc.next();
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Select Subject:");
        System.out.println("1. Maths");
        System.out.println("2. English");
        System.out.println("3. Science");

        int choice = readInt(sc);

        Subject subject;

        if (choice == 1) subject = new Maths();
        else if (choice == 2) subject = new English();
        else if (choice == 3) subject = new Science();
        else {
            System.out.println("Invalid option!");
            return;
        }

        List<Question> qList = subject.getQuestions();
        Collections.shuffle(qList);

        int score = 0;

        for (Question q : qList) {
            System.out.println("\n" + q.getQuestion());
            String[] ops = q.getOptions();

            for (int i = 0; i < ops.length; i++) {
                System.out.println((i + 1) + ". " + ops[i]);
            }

            int ans = readInt(sc);
            if (ans == q.getAnswer()) score++;
        }

        System.out.println("\nFinal Score: " + score + "/" + qList.size());

        ResultSaver.saveResult(subject.getClass().getSimpleName(), score, qList.size());

        sc.close();
    }
}