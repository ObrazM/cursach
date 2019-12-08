package obrazM.classes;

import java.util.ArrayList;

public class Queue {
    private ArrayList<Process> queque;
    private int lastId;

    public int getLastId() {
        return lastId;
    }

    public Queue() {
        queque = new ArrayList<>();
        this.lastId=1;
    }

    public void add(Process process){
        this.queque.add(process);
    }

    public boolean add(){
        Process process = new Process(this.lastId++);
        this.add(process);
        return false;
    }

    public void add(final int N){
        for (int i = 0; i < N; i++)
        { this.add();}
    }

    @Override
    public String toString() {
        String result = "";
        for (Process process:queque){
            result += process + "\n";
        }
        return result;
    }
}
