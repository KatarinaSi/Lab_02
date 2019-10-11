package service;

import entity.Charac;
import entity.Paragraph;
import entity.Sentence;
import entity.Word;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ConverterServiceTest {
    private ConverterService converterService;
    private String TEXT = "But comparing objects is a little different. " +
            "For example, how would you compare two Employees? how would you compare two Students?\n"
            + "\n" + "You need to explicitly define how the objects of user defined classes should be compared. ";

    @Before
    public void setUp() throws Exception {
        converterService = new ConverterService();
    }

    @Test
    public void shouldReturnTwoParagraphs(){
        List<Paragraph> paragraphs = converterService.fromTextToParagraphs(TEXT);
        int expected = 2;
        assertEquals(expected, paragraphs.size());
    }

    @Test
    public void shouldReturnFourSentences(){
        List<Sentence> sentences =converterService.fromParagraphsToSentences(
                                    converterService.fromTextToParagraphs(TEXT));
        int expected = 4;
        assertEquals(expected, sentences.size());
    }

    @Test
    public void shouldReturnWrightSizeListWords(){
        List<Word> words = converterService.fromSentencesToWords(
                                converterService.fromParagraphsToSentences(
                                        converterService.fromTextToParagraphs(TEXT)));
        int expected = 36;
        assertEquals(expected, words.size());
    }

    @Test
    public void shouldReturnWrightSizeListWordsWithDigit(){
        List<Word> words = converterService.fromSentencesToWords(
                                converterService.fromParagraphsToSentences(
                                        converterService.fromTextToParagraphs("Worlds with hashcode number 0 1.")));
        int expected = 6;
        assertEquals(expected, words.size());
    }

    @Test
    public void shouldReturnOneParagraph(){
        List<Paragraph> paragraphs = converterService.fromTextToParagraphs("Worlds with hashcode number 0 1");
        int expected = 1;
        assertEquals(expected, paragraphs.size());
    }

    @Test
    public void shouldReturnSizeZeroFromCharacList(){
        List<Charac> characs = converterService.fromSentencesToCharac(
                                  converterService.fromParagraphsToSentences(
                                    converterService.fromTextToParagraphs("Worlds with hashcode number 0 1")));
        int expected = 0;
        assertEquals(expected, characs.size());
    }

    @Test
    public void shouldReturnSizeFromCharacList(){
        List<Charac> characs = converterService.fromSentencesToCharac(
                                  converterService.fromParagraphsToSentences(
                                    converterService.fromTextToParagraphs(TEXT)));
        int expected = 5;
        assertEquals(expected, characs.size());
    }
}