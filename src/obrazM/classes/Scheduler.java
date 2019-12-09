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
        clockGenerator = new ClockGenerator();
        clockGenerator.run();
    }

    public void init(){
       MemorySheduler.add(new MemoryBlock(Utils.getRandomInteger(1,500), Utils.getRandomInteger(501,1500)));
        MemorySheduler.add(new MemoryBlock(Utils.getRandomInteger(0,300), Utils.getRandomInteger(400,900)));
        MemorySheduler.add(new MemoryBlock(Utils.getRandomInteger(100,500), Utils.getRandomInteger(1000,1500)));
        MemorySheduler.fillMemoryBlock(Utils.getRandomInteger(50, 500));

        processQueue.add(Utils.getRandomInteger(1, 5));
        rejectsQueue.add(Utils.getRandomInteger(1,10));
        System.out.println("Process Queue: "+processQueue);
        System.out.println("Rejects Queue: "+rejectsQueue);
    }

    @Override
    public String toString() {
        return "Scheduler" +"\n"+
                "processQueue:" + processQueue + "\n"+ "rejectsQueue:" + rejectsQueue+ "\n"+
                "cpu=" + cpu +
                "memorySheduler=" + memorySheduler;
    }
}
