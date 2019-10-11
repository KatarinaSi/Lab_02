package service;

import com.sun.corba.se.impl.ior.WireObjectKeyTemplate;
import entity.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConverterService {
    private Text text;
    private Paragraph paragraph;
    private Sentence sentence;
    private Word word;
    private Charac charac;

    public List<Paragraph> fromTextToParagraphs(String text){
        this.text = new Text(text);
        List<Paragraph> list = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\s*.+\\s*").matcher(text);//".+\\R"
        while (matcher.find()){
            list.add(new Paragraph(matcher.group()));
        }
        return list;
    }

    public List<Sentence> fromParagraphsToSentences(List<Paragraph> paragraphs) {
        List<Sentence> sentences = new ArrayList<>();
        paragraphs.stream()
                .forEach(i -> {
                    Matcher matcher = Pattern.compile("(.+?)[.?!]").matcher(i.getParagraph()); //^\s+[A-Za-z,;'"\s]+[.?!]$   "[^.!?]*[.!?]"
                    while (matcher.find()){
                        sentences.add(new Sentence(matcher.group()));
                    }
                });
        return sentences;
    }

    public List<Word> fromSentencesToWords(List<Sentence> sentences){
        List<Word> words = new ArrayList<>();
        sentences.stream()
                .forEach(i ->{
                    Matcher matcher =Pattern.compile("\\w+").matcher(i.getSentence());
                    while (matcher.find()){
                        words.add(new Word(matcher.group()));
                    }
                });
        return words;
    }

    public List<Charac> fromSentencesToCharac(List<Sentence> sentences){
        List<Charac> chars = new ArrayList<>();
        sentences.stream()
                .forEach(i ->{
                    Matcher matcher = Pattern.compile("[^\\w\\s]").matcher(i.getSentence());
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
