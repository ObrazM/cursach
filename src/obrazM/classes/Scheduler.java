package obrazM.classes;

public class Scheduler {
    ProcessQueue processQueue;
    RejectsQueue rejectsQueue;
    CPU cpu;
    MemorySheduler memorySheduler;
    ClockGenerator clockGenerator;

    public Scheduler(final int cpuCoresNumber, int memoryVolume) {
        this.processQueue = new ProcessQueue();
        this.rejectsQueue = new RejectsQueue();
        this.cpu = new CPU(cpuCoresNumber);
        this.memorySheduler = new MemorySheduler();
        Configuration.memoryVolume = memoryVolume;
        init();
        //clockGenerator = new ClockGenerator();
       // clockGenerator.run();
    }

    public void init(){
        MemorySheduler.add(new MemoryBlock(0, 100));
        MemorySheduler.add(new MemoryBlock(1000, 1100));
        MemorySheduler.add(new MemoryBlock(500, 800));
        MemorySheduler.fillMemoryBlock(100);

        processQueue.add(3);
        rejectsQueue.add(2);
    }

    @Override
    public String toString() {
        return "Scheduler" +"\n"+
                "processQueue:" + processQueue + "\n"+ "rejectsQueue:" + rejectsQueue+ "\n"+
                "cpu=" + cpu +
                "memorySheduler=" + memorySheduler;
    }
}
