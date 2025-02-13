package Day5;

import lombok.Getter;
import lombok.Setter;

import javax.print.DocFlavor;
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

        if(naughtyPatterns.matcher(text).find()) {

            this.isNiceString = false;
            return;

        }

        this.vowelNumber = this.text.chars().filter(c -> "aeiou".indexOf(c) != -1).count();
        if(vowelNumber < 3){

            this.isNiceString = false;
            return;

        }

        boolean hasALetterThatRepeats = false;
        for (int i = 0; i < this.text.length() - 2 ; i++){

            if(this.text.charAt(i) == this.text.charAt(i+2) && this.text.charAt(i) != this.text.charAt(i+1)){

                hasALetterThatRepeats = true;
                break;
            }

        }

        this.isNiceString = hasALetterThatRepeats;

    }

}
