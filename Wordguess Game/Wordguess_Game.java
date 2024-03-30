import java.util.Scanner;

public class Wordguess_Game
{

    public static void main(String[] args)
    {
        int guesses, guessword_length, guessed_letters, guessword_size;
        char letter, response;
        boolean play;
        Word guessword;
        StringBuilder letters_left;
        StringBuilder guessletters;
        Scanner scanner;



        guesses = 0;
        guessed_letters = 0;
        play = true;
        guessword = new Word();
        guessword_length = guessword.getLength();
        guessword_size = guessword.actualSize();
        letters_left = new StringBuilder();
        guessletters = new StringBuilder();
        scanner = new Scanner(System.in);
        guessword.reset_Parameters(letters_left, guessletters, guessword_length);



        System.out.println("Welcome to Wordguess Game");
        while (play)
        {
            System.out.println("Guess the next word:" + '\n');

            while (guessed_letters < guessword_size)
            {
                System.out.println(letters_left);
                System.out.println("Letter you could use:" + '\n' + guessletters);

                letter = scanner.next().charAt(0);

                if (guessword.checkLetter(letter) == 1)
                {
                    guessed_letters += guessword.update_Letters_Left(guessletters, letters_left, letter);
                    Word.update_Guessletters(guessletters, letter);
                    guesses++;
                }
                else if (guessword.checkLetter(letter) == 2)
                {
                    boolean notGuessed = Word.update_Guessletters(guessletters, letter);
                    if (notGuessed)
                    {
                        guesses++;
                    }
                }
                else
                {
                    System.out.println("Invalid Letter");
                }
            }

            System.out.println("Congratulations! it took you " + guesses + " guesses to guess " + letters_left);

            while (true)
            {
                System.out.println("Do you want to continue playing? [Y/N]");
                response = scanner.next().charAt(0);
                if (response == 'Y' || response == 'y')
                {
                    break;
                }
                else if (response == 'N' || response == 'n')
                {
                    play = false;
                    break;
                }
                else
                {
                    System.out.println("Invalid Response");
                }
            }

            guesses = 0;
            guessed_letters = 0;
            guessword = new Word();
            guessword_length = guessword.getLength();
            guessword_size = guessword.actualSize();
            letters_left = new StringBuilder();
            guessletters = new StringBuilder();
            guessword.reset_Parameters(letters_left, guessletters, guessword_length);

        }

    }


}
