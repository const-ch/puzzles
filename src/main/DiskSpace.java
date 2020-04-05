import java.util.Set;

public class DiskSpace {

    public static boolean isWritable(int blockSize,                 //        blockSize will be between 1 and 1,000,000, inclusive.
                                     int fileSize,                  //                fileSize will be between 1 and blockSize, inclusive.
                                     Set<Integer> occupiedSectors    //occupiedSectors will contain between 1 and 1,000,000 elements, inclusive.
                                                                     //                Each element of occupiedSectors will be between 1 and blockSize, inclusive.
                                                                     //        Elements of occupiedSectors will be distinct.
    ) {

        if((occupiedSectors == null) || (blockSize<1)||(blockSize>1000001)||(fileSize>blockSize)||occupiedSectors.size()>1000001)
            return false;


        if(occupiedSectors.isEmpty())
            if(fileSize<=blockSize)
                return true;

        Integer[] occupieds = occupiedSectors.stream().sorted().toArray(Integer[]::new);

        Integer firstFree = occupieds[0]-1;
        if(fileSize<=firstFree)
            return true;

        for(int i = 1;i<occupieds.length;i++){
            Integer freeSegment = occupieds[i]-occupieds[i-1]-1;
            if(fileSize<=freeSegment)
                return true;
        }

        Integer lastFree = blockSize-occupieds[occupieds.length-1];
        if(fileSize<=lastFree)
            return true;

        return false;
    }
}