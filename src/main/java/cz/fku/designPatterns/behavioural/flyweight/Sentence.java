package cz.fku.designPatterns.behavioural.flyweight;

import java.util.ArrayList;
import java.util.List;

class Sentence
{
    String plainText;
    private List<WordToken> tokens = new ArrayList<>();
    public Sentence(String plainText)
    {
        this.plainText = plainText;
    }

    public WordToken getWord(int index)
    {
        WordToken token = new WordToken(index);
        this.tokens.add(token);
        return token;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        String[] words = this.plainText.split(" ");
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            for(WordToken token: tokens) {
                word = (token.covers(i) && token.capitalize) ? word.toUpperCase() : word;
            }
            sb.append(word);
            if(i != words.length-1) {
                sb.append(" ");

            }
        }
        return sb.toString();
    }

    class WordToken
    {
        int index;
        WordToken(int index) {
            this.index = index;
        }
        public boolean covers(int index) {
            return this.index == index;
        }
        public boolean capitalize;
    }
}

class Demo {
    public static void main(String[] args) {
        Sentence sentence = new Sentence("hello world");
        sentence.getWord(1).capitalize = true;
        System.out.println(sentence);
    }
}
