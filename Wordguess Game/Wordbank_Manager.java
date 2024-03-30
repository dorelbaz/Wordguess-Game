import java.io.*;
import java.util.Random;

import static java.lang.System.exit;

public class Wordbank_Manager
{
    private static int lines;
    private static String word;

    private static void setWord()
    {
        word = "";
        int line_counter = 0;
        Random randomizer = new Random();

        try {
            count_Lines();
            BufferedReader words = new BufferedReader(new FileReader("Wordbank.txt"));
            int randomLine = randomizer.nextInt(lines);
            while (line_counter <= randomLine)
            {
                word = words.readLine();
                line_counter++;
            }
            words.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            exit(1);
        }
    }

    private static void count_Lines()
    {
        try {
            BufferedReader words = new BufferedReader(new FileReader("Wordbank.txt"));
            lines = 0;
            while (words.readLine() != null)
            {
                lines++;
            }
            words.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            exit(1);
        }
    }

    public static String getWord()
    {
        setWord();
        return word;
    }

}
















