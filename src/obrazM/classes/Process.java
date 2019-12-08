package obrazM.classes;

public class Process {
    int id;
    String name;
    int priority;
    int time;
    int memory;
    int timeIn;
    int burstTime;
    State state;

    public Process(int id) {
        this.id = id;
        this.memory = Utils.getRandomInteger(Configuration.leftBorder,Configuration.memoryVolume/2);
        this.priority = Utils.getRandomInteger(Configuration.maxpriority);
        this.timeIn = ClockGenerator.getTime();
        this.time = Utils.getRandomInteger(Configuration.leftBorder,Configuration.rightBorder);
        this.burstTime = 0;
        this.name = "P"+this.id;
        this.state = State.Ready;
    }

    @Override
    public String toString() {
        return id + ", name='" + name + '\'' + ", priority=" + priority + ", time=" + time + ", memory=" + memory +
                ", timeIn=" + timeIn + ", burstTime=" + burstTime + ", state=" + state + '}';
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getTime() {
        return time;
    }

    public int getMemory() {
        return memory;
    }

    public int getTimeIn() {
        return timeIn;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public State getState() {
        return state;
    }

    public int getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
