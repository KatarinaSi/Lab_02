package service;

import entity.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConverterService {
    private Text text;
    private String PARAGRAPH_REGEX = "\\s*.+\\s*";
    private String SENTENCE_REGEX = "(.+?)[.?!]";
    private String WORD_REGEX = "\\w+";
    private String CHARAC_REGEX = "[^\\w\\s]";

    public List<Paragraph> fromTextToParagraphs(String text){
        this.text = new Text(text);
        List<Paragraph> list = new ArrayList<>();
        Matcher matcher = Pattern.compile(PARAGRAPH_REGEX).matcher(text);
        while (matcher.find()){
            list.add(new Paragraph(matcher.group()));
        }
        return list;
    }

    public List<Sentence> fromParagraphsToSentences(List<Paragraph> paragraphs) {
        List<Sentence> sentences = new ArrayList<>();
        paragraphs
                .forEach(i -> {
                    Matcher matcher = Pattern.compile(SENTENCE_REGEX).matcher(i.getParagraph());
                    while (matcher.find()){
                        sentences.add(new Sentence(matcher.group()));
                    }
                });
        return sentences;
    }

    public List<Word> fromSentencesToWords(List<Sentence> sentences){
        List<Word> words = new ArrayList<>();
        sentences.forEach(i ->{
                    Matcher matcher =Pattern.compile(WORD_REGEX).matcher(i.getSentence());
                    while (matcher.find()){
                        words.add(new Word(matcher.group()));
                    }
                });
        return words;
    }

    public List<Charac> fromSentencesToCharac(List<Sentence> sentences){
        List<Charac> chars = new ArrayList<>();
        sentences.forEach(i ->{
                    Matcher matcher = Pattern.compile(CHARAC_REGEX).matcher(i.getSentence());
                    while (matcher.find()){
                        chars.add(new Charac(matcher.group()));
                    }
                });
        return chars;
    }

    public void alphabeticPrint(List<Word> words, List<Charac> characs){
        Collections.sort(characs);
        characs.stream().forEach(System.out::print);
        Collections.sort(words);
        words.stream().forEach(System.out::print);
        System.out.println(words.size());
    }
}
