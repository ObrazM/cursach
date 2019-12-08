package obrazM.classes;

public class ProcessQueue extends Queue {
    RejectsQueue rejectsQueue;

    public ProcessQueue() {
        this.rejectsQueue = new RejectsQueue();
    }

    @Override
    public void add(Process process) {
        super.add(process);
    }
}
