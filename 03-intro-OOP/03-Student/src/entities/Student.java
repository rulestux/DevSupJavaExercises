package entities;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class Student {

    public String name;
    public double fstQuarter;
    public double secQuarter;
    public double trdQuarter;

    public double finGrade() {
       return fstQuarter + secQuarter + trdQuarter;
    }
    public double missingPoints() {
        if (finGrade() < 60.0) {
            return 60.0 - finGrade();
        }
        else {
            return 0.0;
        }

    }

}
