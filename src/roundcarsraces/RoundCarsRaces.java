/*
 * 
 */
package roundcarsraces;

import java.util.Random;

/**
 *
 * @author Rokas
 */
public class RoundCarsRaces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Car[] cars = {
            new Car("01", 120),
            new Car("02", 150),
            new Car("03", 130),
            new Car("04", 100),
            new Car("05", 160),
            new Car("06", 140),
            new SportCar("s11", 240),
            new SportCar("s12", 260),
            new SportCar("s13", 280),
            new SportCar("s14", 300)
        };
        
        int maxInDeltaSpeed = 50; // km/h, max Delta Increased Speed
        int maxReDeltaSpeed = 50; // km/h, max Delta Reduced Speed
        
        int[] interDistRating = new int[cars.length]; // tarpiniai reitingai, kurios masinos atstumas didesnis kirtus tarpinius intervalus, tos pozicija aukstesne, o indeksas (i+1) nurodo vieta
        int[] finalRating = new int[cars.length]; // jei finisuojama ta pacia iteracija, traktuojame, kad uzima ta pacia pozicija 
 
        int[] interDists = new int[cars.length]; // tarpines distacijos, pasiekus pasikeicia
        
        int finalPlace = 0; // pasiekus finisa, nurodo kelintas finisuoja
        int t = 0; // time
        
        int intervalsNumber = 10;
        int checkInterval = 100; // km   
        int raceTrackLength = intervalsNumber * checkInterval; // km
        
        char signFinishPosition = '#';
        char signInterPosition = ':';
        
        for (int ind = 0; ind < cars.length; ind++) {
            interDists[ind] += checkInterval;
        }
        
        
        System.out.printf("%50s","Cars Distances & Positions\n");
        System.out.print("Cars\t");
        for (int ind = 0; ind < cars.length; ind++) {
            System.out.print(":[" + cars[ind].getName() + "]:" + "\t");
        }
        System.out.print("\nmaxSp\t");
        for (int ind = 0; ind < cars.length; ind++) {
            System.out.print("" + cars[ind].maxSpeed + "\t");
        }
        System.out.println("\ntime");
        
        
        
        boolean orNotAllFinished = true;

        while (orNotAllFinished) {
            
            int checkedCars = 0; // through the same cycle
            int finishedSameTime = 0;
            
            t++;
            
            
            for (int carIndex = 0; carIndex < cars.length; carIndex++) {
                
                if (cars[carIndex].getDistance() < raceTrackLength) {
                    
                    if (cars[carIndex] instanceof SportCar) {
                        if (Math.random() < 0.5) {
                            ((SportCar) cars[carIndex]).changeSpoiler();
                        }
                    }
                    
                    double probability = Math.random();
                    
                    if (probability < 0.3) {
                        cars[carIndex].reduceSpeed((int) (Math.random() * maxInDeltaSpeed) + 1); // v - [1;maxDeltaSpeed] km/h        
                    } else if (probability < 0.8) {
                        cars[carIndex].increaseSpeed((int) (Math.random() * maxReDeltaSpeed) + 1); // v - [1;maxDeltaSpeed] km/h
                    }
                    
                    cars[carIndex].movement();
                    
                    
                    if (cars[carIndex].getDistance() >= interDists[carIndex] && cars[carIndex].getDistance() < raceTrackLength) {              
                        checkedCars++; 
                        interDists[carIndex] += checkInterval;
                    }
                    
                    // if car is finished
                    if (cars[carIndex].getDistance() >= raceTrackLength) {
                        checkedCars++;
                        finalPlace++;
                        finalRating[carIndex] = finalPlace - finishedSameTime;
                        finishedSameTime++;
                        
                        if (finalPlace == cars.length) {
                            orNotAllFinished = false;
                        }
                        
                    }
                    
                }
                interDistRating[carIndex] = cars[carIndex].getDistance(); // sioje vietoje idedame, kad vel teisingai sudeliotu atstumus pagal masinu indeksus, nes zemiau yra isrikiuojama 
            }
            
            // inter results
            if (checkedCars > 0) {
                
                for (int i = 0; i < cars.length; i++) {
                    for (int j = i; j < cars.length; j++) {
                        if (interDistRating[i] < interDistRating[j]) {
                            int max = interDistRating[j];
                            interDistRating[j] = interDistRating[i];
                            interDistRating[i] = max;
                        }
                    }
                    
                }
                
                System.out.print(t + " >\t");
                
                for (int ind = 0; ind < cars.length; ind++) {
                    
                    if (cars[ind].getDistance() >= raceTrackLength) {
                        System.out.print(raceTrackLength);
                        System.out.print("" + signFinishPosition + finalRating[ind]);
                    }
                    else {
                        System.out.print(cars[ind].getDistance());
                        for (int i = 0; i < cars.length; i++) {
                           if (cars[ind].getDistance() == interDistRating[i]) {
                                System.out.print("" + signInterPosition + (i + 1));  
                                break;
                           }
                        }
                        System.out.print("");
                    }
                    
                    System.out.print("\t");
                }
                
                System.out.println(""); 
                
            }
     
        } // while end
        
        System.out.println("");
        
        System.out.println("Race Track Length (Finish): " + raceTrackLength);
        System.out.println("Check interval length: " + checkInterval);
        System.out.println(signInterPosition + "1" + " - inter position");
        System.out.println(signFinishPosition + "1" + " - final position");
        
        // final results
        System.out.println("\nPosition \t cars");    

        for (int place = 1; place <= cars.length; place++) {
            boolean emptyPosition = true;
            System.out.print("\t" + signFinishPosition + place);
            for (int ind = 0; ind < cars.length; ind++) {
                if (finalRating[ind] == place) {
                    System.out.print("\t:[" + cars[ind].getName() + "]:");
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
