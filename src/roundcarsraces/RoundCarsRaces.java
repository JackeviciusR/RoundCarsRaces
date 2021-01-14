/*
 * 
 */
package roundcarsraces;

/**
 *
 * @author Rokas
 */
public class RoundCarsRaces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] cars = new int[12];
        int[] carsDists = new int[cars.length];
        int[] rating = new int[cars.length];
 
        int[] checkDists = new int[cars.length];
        
        int carPlace = 0; //
        int t = 0; // time
        
        int intervalsNumber = 8;
        int checkInterval = 5; // km   
        int raceTrackLength = intervalsNumber * checkInterval; // km
        
        
        for (int ind = 0; ind < cars.length; ind++) {
            checkDists[ind] += checkInterval;
        }
        
        
        System.out.printf("%50s","Cars Distances\n");
        System.out.print("time\t");
        for (int ind = 0; ind < cars.length; ind++) {
            System.out.print(":[" + ind + "]:" + "\t");
        }
        System.out.println("");
        
        
        boolean orNotAllFinished = true;

        while (orNotAllFinished) {
            
            // int[] momentSpeeds = new int[cars.length];
            
            int checkedCars = 0; // through the same cycle
            int finishedSameTime = 0;
            
            t++;
            
            
            for (int carIndex = 0; carIndex < cars.length; carIndex++) {
                
                if (carsDists[carIndex] < raceTrackLength) {
                
                    carsDists[carIndex] += (int) (Math.random() * 11); // v - [0;10] km/h

                    if (carsDists[carIndex] >= checkDists[carIndex] && carsDists[carIndex] < raceTrackLength) {              
                        checkedCars++; 
                        checkDists[carIndex] += checkInterval;
                    }
                    
                    if (carsDists[carIndex] >= raceTrackLength) {
                        carsDists[carIndex] = raceTrackLength;
                        checkedCars++;
                        carPlace++;
                        rating[carIndex] = carPlace - finishedSameTime;
                        finishedSameTime++;
                        
                        if (carPlace == cars.length) {
                            orNotAllFinished = false;
                        }
                    }
                    
                }
              
            }
            
            if (checkedCars > 0) {
                
                System.out.print(t + " >\t");
                
                for (int ind = 0; ind < cars.length; ind++) {
                    System.out.print(carsDists[ind]);
                    
                    if (carsDists[ind] == raceTrackLength) {
                        System.out.print("#" + rating[ind]);
                    }
                    else {
                        System.out.print("");
                    }
                    System.out.print("\t");
                }
                System.out.println(""); 
            }
            
            
        }
        
//        System.out.println("time: " + t);
//        
//        int pl = 0;
//        for (int carPl : rating) {
//            pl++;
//            System.out.println(pl + " - :|" + carPl + "|:");
//        }

        
//        System.out.println("\nFinished cars:\t" + carPlace);
//        System.out.print("\nPosition:");
//        
//        for (int position : rating) {
//            System.out.print("\t #" + position);
//        }
        
//        System.out.print("\nCars:\t");
//        
//        for (int ind = 0; ind < cars.length; ind++) {
//            System.out.print("\t:[" + ind + "]:");
//        }
        
        System.out.println("");
        
        System.out.println("Race Track Length: " + raceTrackLength);
        System.out.println("Check interval: " + checkInterval);
        
        System.out.println("\nPosition \t cars");    

        for (int place = 1; place <= cars.length; place++) {
            boolean emptyPosition = true;
            System.out.print("\t#" + place);
            for (int ind = 0; ind < cars.length; ind++) {
                if (rating[ind] == place) {
                    System.out.print("\t:[" + ind + "]:");
                    emptyPosition = false;
                }
            }
            
            if (emptyPosition == true) {
                System.out.print("\t  -");
            }
            
            System.out.println("");
        }
        
        
    }

}
