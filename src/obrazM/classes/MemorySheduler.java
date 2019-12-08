package obrazM.classes;

import java.util.ArrayList;

public class MemorySheduler {
    private static ArrayList<MemoryBlock> memoryBlocks = new ArrayList<>();

    private static int findFreeBlock(int size) {
        memoryBlocks.sort(MemoryBlock.byEnd);

        ArrayList<MemoryBlock> tempMemoryBlocks = new ArrayList<>();
        for (int i = 0; i < memoryBlocks.size() - 1; i++){
            if (memoryBlocks.get(i + 1).start - memoryBlocks.get(i).end > size) {
                MemoryBlock tempMemoryBlock = new MemoryBlock(memoryBlocks.get(i).end, memoryBlocks.get(i + 1).start);
                tempMemoryBlocks.add(tempMemoryBlock);
            }
        }
        if (Configuration.memoryVolume-memoryBlocks.get(memoryBlocks.size()-1).end > size){
            MemoryBlock tempMemoryBlock = new MemoryBlock(memoryBlocks.get(memoryBlocks.size()-1).end, Configuration.memoryVolume);
            tempMemoryBlocks.add(tempMemoryBlock);
        }

        if (tempMemoryBlocks.size() > 0){
        for (int i=0; i < tempMemoryBlocks.size(); i++) {
            System.out.println("Fit memory block for the process: "+tempMemoryBlocks.get(0) + "\n");
            break;
        }}
        else
            System.out.println("No memory blocks");
        return 0;
    }

    public static boolean fillMemoryBlock(int size){
        findFreeBlock(size);
        return false;
    }

    public static void releaseMemoryBlock(MemoryBlock memoryBlock){
        memoryBlocks.remove(memoryBlock);
    }

    public static void add(MemoryBlock memoryBlock) { memoryBlocks.add(memoryBlock); }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < memoryBlocks.size(); i++) {
            result+=memoryBlocks.get(i) + " ";
        }
        return result + "]";
    }
}
