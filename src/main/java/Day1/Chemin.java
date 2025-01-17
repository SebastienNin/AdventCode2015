package Day1;

import lombok.Getter;
import lombok.Setter;

public class Chemin {

    @Getter
    @Setter
    private String chemins;
    private int etage = 0;
    @Getter
    @Setter
    private int PremierBasement = 0;

    public int etageFinal() {

        for (int i = 0; i < this.chemins.length(); i++) {
            if (this.chemins.charAt(i) == '(') {
                etage++;
            } else {
                etage--;
                if (etage < 0 && PremierBasement == 0) {
                    this.setPremierBasement(i+1);
                }
            }
        }

        return this.etage;
    }

}
