package ua.igorbendera.string;

import java.util.Scanner;

/**
 * The {@code Main} main class for work with string objects
 * @author Igor Bendera
 * @since JDK 1.5
 * @version 1.1 12-th March 2019
 */

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        isPalindrome(scanner);
        replaceVowelLetters(scanner);
        amountWords(scanner);
        amountSentences(scanner);
        wordTheMostOftenUsedInSentence(scanner);
        wordTheMostOftenUsedInText(scanner);

    }

    /**
     * Check is word palindrome
     * @param scanner
     */
    public static void isPalindrome(Scanner scanner) {
        System.out.println("Enter word with length = 5! We'll check is word palindrome");
        String palindrome = scanner.nextLine();

        if(palindrome.length() == 5) {
            /*Word is palindrome only when half of word is equals to half of word which was reversed*/
            if(palindrome.substring(0, palindrome.length() / 2).equalsIgnoreCase(
                    new StringBuilder(palindrome).reverse().toString().substring(0, palindrome.length() / 2))) {
                System.out.println("The word is palindrome");
            } else {
                System.out.println("The word is not palindrome");
            }
        } else {
            System.out.println("Error! Word has to have 5 letters");
        }
    }

    /**
     * Method which replace all vowel letters to '-'
     * @param scanner
     */
    public static void replaceVowelLetters(Scanner scanner) {
        System.out.println("Enter some English text");
        StringBuffer someText = new StringBuffer();
        someText.append(scanner.nextLine());

        for(int i = 0; i < someText.length(); i++) {
            switch (someText.toString().toLowerCase().charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'y':
                    someText.replace(i, i + 1, "-");
                    break;
                default: break;
            }
        }
        System.out.println(someText);
    }

    /**
     * Amount words in sentence
     * @param scanner
     */
    public static void amountWords(Scanner scanner) {
        System.out.println("Введіть речення для підрахунку кількості слів");
        StringBuffer originalSentence = deleteSentenceAfterDot(scanner);
        String copySentence = originalSentence.toString().replaceAll("\\pP", "");

        int count = 0;
        String[] str = copySentence.split(" ");

        for(int i = 0; i < str.length; i++) {
            /*Count word which only have rather than 2 letters */
            if(str[i].length() >= 3) {
                count++;
            } else {
                continue;
            }
        }

        System.out.println("Речення - " + originalSentence + " складається з +- " + count + " слів");
    }

    /**
     * Amount sentence in all text
     * @param scanner
     */
    public static void amountSentences(Scanner scanner) {
        System.out.println("Введіть текст для підрахунку кількості речень");
        String text = scanner.nextLine();

        String[] str = text.split("\\.");
        System.out.println("Текст - " + text + " \nскладається з " + str.length + " речень");
    }

    public static void wordTheMostOftenUsedInSentence(Scanner scanner) {
        System.out.println("Введіть речення для знаходження слова, яке найчастіше використовується");
        StringBuffer originalSentence = deleteSentenceAfterDot(scanner);
        String copySentence = originalSentence.toString().replaceAll("\\pP", "");

        String[] str = copySentence.split(" ");
        System.out.print("Найчастіше в реченні\n" + originalSentence + " вжито слово: ");
        equalsWords(str);
    }

    public static void wordTheMostOftenUsedInText(Scanner scanner) {
        System.out.println("Введіть текст для знаходження слова, яке найчастіше використовується");
        StringBuffer originalSentence = new StringBuffer();
        originalSentence.append(scanner.nextLine());
        String copySentence = originalSentence.toString().replaceAll("\\pP", "");

        String[] str = copySentence.split(" ");
        System.out.print("Найчастіше в тексті\n" + originalSentence + " вжито слово: ");
        equalsWords(str);
    }

    /**
     * This method is comparing words and counting which word used the most often
     * @param str
     */
    private static void equalsWords(String[] str) {
        String theMostPopularWord = "";
        int saveWordCount = 0;
        int wordCountTemp = 1;

        if (str.length > 1) {
            String word = str[0];
            for (int i = 1; i < str.length; i++) {
                for (int j = str.length - 1; j >= i; j--) {
                    if (str[j].length() >= 3 & word.equalsIgnoreCase(str[j])) {
                        wordCountTemp++;
                    } else {
                        continue;
                    }
                }
                if(wordCountTemp > saveWordCount) {
                    saveWordCount = wordCountTemp;
                    theMostPopularWord = word;
                }
                word = str[i];
                wordCountTemp = 1;
            }
        } else if (str.length == 1 && !(theMostPopularWord.equals(""))){
            theMostPopularWord = str[0];
        } else {
            System.out.println("Жодного слова не було введено!!");
            return;
        }

        System.out.println(theMostPopularWord + "\n" + saveWordCount + " р.");
    }

    private static StringBuffer deleteSentenceAfterDot(Scanner scanner) {
        StringBuffer sentence = new StringBuffer();
        sentence.append(scanner.nextLine());

        if(sentence.indexOf(".") != -1) {
            sentence.delete(sentence.indexOf("."), sentence.length());
        }

        return sentence;
    }
}
