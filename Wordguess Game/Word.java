import static java.lang.System.exit;

public class Word
{
    private static String word;
    public Word()
    {
        word = "";
        word = Wordbank_Manager.getWord();
        if (word.isEmpty())
        {
            System.out.println("An error has occurred");
            exit(1);
        }
    }

    public int getLength()
    {
        return word.length();
    }

    public int actualSize()
    {
        int size = 0;
        for (int i = 0; i < this.getLength(); i++)
        {
            if (this.char_At(i) != ' ' && this.char_At(i) != '\t')
            {
                size++;
            }
        }
        return size;
    }

    public char char_At(int i)
    {
        return word.charAt(i);
    }

    public int update_Letters_Left(StringBuilder guessletters, StringBuilder letters_left, char letter)
    {
        int guessword_length = this.getLength();
        int assignments = 0;
        boolean notGuessed = false;

        for (int i = 0; i < guessletters.length(); i++)
        {
            if (guessletters.charAt(i) == letter)
            {
                notGuessed = true;
            }
        }

        if (!notGuessed)
        {
            return 0;
        }

        for (int i = 0; i < guessword_length; i++)
        {
            if (this.char_At(i) == letter)
            {
                letters_left.setCharAt(i, letter);
                assignments++;
            }
        }

        return assignments;
    }

    public static boolean update_Guessletters(StringBuilder guessletters, char letter)
    {
        boolean notGuessed = false;
        for (int i = 0; i < guessletters.length(); i++)
        {
            if (guessletters.charAt(i) == letter)
            {
                guessletters.setCharAt(i, ' ');
                notGuessed = true;
            }
        }
        return notGuessed;
    }

    public int checkLetter(char letter)
    {
        if (!('a' <= letter && letter <= 'z') && !('A' <= letter && letter <= 'Z'))
        {
            return 3;
        }

        int length = this.getLength();
        boolean found = false;
        for (int i = 0; i < length; i++)
        {
            if (this.char_At(i) == letter)
            {
                found = true;
            }
        }

        if (found)
        {
            return 1;
        }
        return 2;
    }

    public void reset_Parameters(StringBuilder letters_left, StringBuilder guessletters, int length)
    {
        for (char ch = 'a'; ch <= 'z'; ch++)
        {
            guessletters.append(ch);
        }

        for (char ch = 'A'; ch <= 'Z'; ch++)
        {
            guessletters.append(ch);
        }

        for (int i = 0; i < length; i++)
        {
            if (this.char_At(i) != ' ' && this.char_At(i) != '\t')
            {
                letters_left.append('_');
            }
            else
            {
                letters_left.append(' ');
            }
        }
    }
}
