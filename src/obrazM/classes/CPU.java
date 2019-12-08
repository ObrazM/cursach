package obrazM.classes;

import java.util.Arrays;

public class CPU {
    Core [] cores;

    public CPU(final int coresNumber) {

        this.cores = new Core [coresNumber];
        for (int i =0; i<coresNumber;i++) {
            this.cores[i] = new Core();
        }
    }

    public Core[] getCores() {
        return cores;
    }

    public void setCores(Core[] cores) {
        this.cores = cores;
    }

    @Override
    public String toString() {
        String result = " ";
        for (Core core:cores) {
            result += core.getState() + ",";
        }
        return result + "\n";
    }
}
