package day5;

import lombok.Getter;
import lombok.Setter;

import java.util.regex.Pattern;

public class ExerciceString {

    @Getter
    @Setter
    private String text;
    @Getter
    @Setter
    private boolean isNiceString;
    @Getter
    @Setter
    private long vowelNumber = 0;
    @Getter
    @Setter
    private Pattern naughtyPatterns = Pattern.compile("ab|cd|pq|xy");

    public ExerciceString(String text) {
        this.text = text;
        this.isNice();
    }

    public void isNice() {
        boolean hasAPairThatRepeats = false;
        for (int i = 0; i < this.text.length() - 1; i++) {
            String pair = this.text.substring(i, i + 2);
            if (this.text.indexOf(pair, i + 2) != -1) {
                hasAPairThatRepeats = true;
                break;
            }
        }

        boolean hasALetterThatRepeats = false;
        for (int i = 0; i < this.text.length() - 2; i++) {
            if (this.text.charAt(i) == this.text.charAt(i + 2)) {
                hasALetterThatRepeats = true;
                break;
            }
        }

        this.isNiceString = hasALetterThatRepeats && hasAPairThatRepeats;

    }
}
