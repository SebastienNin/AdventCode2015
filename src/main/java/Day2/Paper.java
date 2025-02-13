package Day2;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Paper {

    @Setter
    @Getter
    private Integer width;
    @Setter
    @Getter
    private Integer height;
    @Setter
    @Getter
    private Integer length;
    @Setter
    @Getter
    private Integer answer;
    private ArrayList<Integer> areas = new ArrayList<>();
    @Getter
    @Setter
    public Integer ExtraPaper;
    @Getter
    @Setter
    public Integer Ribbon;

    public Paper(Integer width, Integer height, Integer length) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.areas.add(calculateArea(this.width, this.height));
        this.areas.add(calculateArea(this.width, this.length));
        this.areas.add(calculateArea(this.height, this.length));
        this.ExtraPaper = Collections.min(this.areas);
        calculateAnswer();
        this.Ribbon = getRibbon();
    }

    public Integer calculateArea(Integer edge1, Integer edge2) {
        return edge1 * edge2;
    }

    public void calculateAnswer() {

        Integer answer = 0;

        for (Integer area : this.areas) {
            answer = answer + area * 2;
        }

        this.answer = answer + this.ExtraPaper;
    }

    public int getSmallestPerimeter() {

        ArrayList<Integer> papers = new ArrayList<>();
        papers.add(this.width);
        papers.add(this.height);
        papers.add(this.length);

        Collections.sort(papers);

        return papers.get(0) + papers.get(0) + papers.get(1) + papers.get(1);
    }

    public int getRibbon() {

        return this.width * this.height * this.length + getSmallestPerimeter();
    }
}
