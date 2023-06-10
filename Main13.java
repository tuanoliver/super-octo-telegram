import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Word {
    private String name;
    private String definition;
    private String type;

    public Word(String name, String definition, String type) {
        this.name = name;
        this.definition = definition;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getDefinition() {
        return definition;
    }

    public String getType() {
        return type;
    }

    public boolean isMisc() {
        return type.equals("misc");
    }

    public boolean isPn() {
        return type.equals("pn");
    }
}

class Dictionary {
    private List<Word> words;

    public Dictionary(String fileName) {
        words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            String currentName = "none";
            String currentDefinition = "none";
            String currentType = "none";

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                currentName = line;
                currentDefinition = br.readLine();
                currentType = br.readLine();

                Word newWord = new Word(currentName, currentDefinition, currentType);
                words.add(newWord);
            }
        } catch (IOException e) {
            System.out.println("Unable to open file");
        }
    }

    public void queryNewWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the word: ");
        String queryWord = scanner.nextLine();
        
        for (Word word : words) {
            if (word.getName().contains(queryWord)) {
                System.out.println(word.getName());
                System.out.println(word.getDefinition());
                System.out.println(word.getType());
                System.out.println();
            }
        }
    }

    public String getLastThree(String input) {
        return input.substring(Math.max(0, input.length() - 3));
    }

    public void rhyme() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the word: ");
        String queryWord = scanner.nextLine();
        
        String queryEnd = getLastThree(queryWord);
        for (Word word : words) {
            if (getLastThree(word.getName()).equals(queryEnd)) {
                System.out.println(word.getName());
            }
        }
    }

    public int getLetterScore(char letter) {
        // Map to match letters and scores
        Map<Character, Integer> letterScore = new HashMap<>();
        letterScore.put('a', 1);
        letterScore.put('e', 1);
        letterScore.put('i', 1);
        letterScore.put('l', 1);
        letterScore.put('o', 1);
        letterScore.put('r', 1);
        letterScore.put('s', 1);
        letterScore.put('t', 1);
        letterScore.put('u', 1);
        letterScore.put('n', 1);
        letterScore.put('d', 2);
        letterScore.put('g', 2);
        letterScore.put('b', 3);
        letterScore.put('c', 3);
        letterScore.put('m', 3);
        letterScore.put('p', 3);
        letterScore.put('f', 4);
        letterScore.put('h', 4);
        letterScore.put('v', 4);
        letterScore.put('w', 4);
        letterScore.put('y', 4);
        letterScore.put('k', 5);
        letterScore.put('j', 8);
        letterScore.put('x', 8);
        letterScore.put('q', 10);
        letterScore.put('z', 10);

        char lowercaseLetter = Character.toLowerCase(letter);
        return letterScore.getOrDefault(lowercaseLetter, 0);
    }

    public int calculateScore(String string) {
        int score = 0;
        for (char c : string.toCharArray()) {
            if (c != '-') {
                score += getLetterScore(c);
            }
        }
        return score;
    }

    public void scrabbleScore() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a word: ");
            String word = scanner.nextLine();

            if (word.isEmpty()) {
                break;
            }

            int score = calculateScore(word);
            System.out.println("The score for '" + word + "' is " + score);

            for (Word dictionaryWord : words) {
                if (word.equals(dictionaryWord.getName())) {
                    System.out.println(dictionaryWord.getDefinition());
                }
            }
        }
    }

    public boolean areAnagrams(String str1, String str2) {
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }

    public void anagram() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the word: ");
        String queryWord = scanner.nextLine();

        for (Word word : words) {
            if (areAnagrams(queryWord, word.getName())) {
                System.out.println(word.getName());
            }
        }
    }

    public void hash10() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter scrambled letters: ");
        String tester = scanner.nextLine();
        char[] testerArray = tester.toCharArray();
        Arrays.sort(testerArray);
        tester = new String(testerArray);

        do {
            for (Word word : words) {
                char[] wordArray = word.getName().toCharArray();
                Arrays.sort(wordArray);
                String sortedWord = new String(wordArray);
                if (sortedWord.equals(tester)) {
                    System.out.println("Found word: " + word.getName());
                    System.out.println(word.getDefinition());
                }
            }
        } while (nextPermutation(testerArray));

        scanner.close();
    }

    private boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        int j = arr.length - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }

        swap(arr, i, j);
        reverse(arr, i + 1);
        return true;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int start) {
        int i = start;
        int j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public void run() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        
        while (!exit) {
            System.out.println("\n---- W E L C O M E  T O   D I C T I O N A R Y ----");
            System.out.println("1. Search for a word");
            System.out.println("2. Find rhyming words");
            System.out.println("3. Calculate Scrabble score");
            System.out.println("4. Find anagrams");
            System.out.println("5. Unscramble letters");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    queryNewWord();
                    break;
                case 2:
                    rhyme();
                    break;
                case 3:
                    scrabbleScore();
                    break;
                case 4:
                    anagram();
                    break;
                case 5:
                    hash10();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class Main13 {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary("C:\\Users\\61404\\Desktop\\c++ assign folder\\dictionary.txt");
        dictionary.run();
    }
}

