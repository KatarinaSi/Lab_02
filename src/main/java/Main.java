import entity.Charac;
import entity.Paragraph;
import entity.Sentence;
import entity.Word;
import service.ConverterService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ConverterService converterService = new ConverterService();
        List<Paragraph> paragraphs = converterService.fromTextToParagraphs(" Overview\n"
                + "In this quick article, we’ll discuss different array copying methods in Java. Array copy may seem " +
                "like a trivial task, but it may cause unexpected results and program behaviors if not done carefully.\n"
                + "\n"
                + "2. The System Class\n"
                + "Let's start with the core Java library – System.arrayCopy(); this copies an array from a" +
                " source array to a destination array, starting the copy action from the source position to the target position till the specified length.");
        List<Sentence> sentences = converterService.fromParagraphsToSentences(paragraphs);
        List<Word> words = converterService.fromSentencesToWords(sentences);
        List<Charac> characs = converterService.fromSentencesToCharac(sentences);
        converterService.alphabeticPrint(words, characs);
    }
}
