import java.util.*;

public class BracketPredictor{

    public static int randInt(int min, int max) {

        Random rand = new Random();
        int x = rand.nextInt(max-min) + min;
        
        return x;
    }
    //seed: 1, 2 ,3 or for WC = 4
    //injury metric 0-5 (0 being the ahl team is playing, 5 being perfectly healthy) 
    //playoff experience 0-10 (0 no experience, 10 they are looking for a threepeat)
    //Star power/depth 0-10 (0 nobody knows who anybody is on the team, 10 it is stacked beyond being reasonable)
    
    public static boolean guessWinner(int seedHigh, int seedLow, int injuryMetricHigh, int injurymetricLow, int pexpHigh, int pexpLow, int starPowerHigh, int starPowerLow){
        int higherSeed = randInt(0, 100) + ((seedLow - seedHigh) * 4) + injuryMetricHigh + pexpHigh + starPowerHigh;
        int lowerSeed = randInt(0, 100) + injurymetricLow + pexpLow + starPowerLow;
        boolean highWinner;
        System.out.println("Game Score: " + higherSeed + ":" + lowerSeed);
        if (higherSeed >= lowerSeed){
            highWinner = true;

        }else{
            highWinner = false;

        }
        
        return highWinner;
        
    }
    
    public static int games(){
        int x = randInt(4, 7);
        return x;
    }
    

    

    public static void main(String[] args) {
       
        Scanner reader = new Scanner(System.in);
        System.out.println("Seed: 1, 2 ,3 or for WC = 4");
        System.out.println("Injury metric 0-5 (0 being the AHL team is playing, 5 being perfectly healthy)");
        System.out.println("Playoff experience 0-10 (0 no experience, 10 if they are looking for a threepeat)");
        System.out.println("Star power/depth 0-10 (0 nobody knows who anybody is on the team, 10 it is stacked beyond being reasonable)");        
        System.out.println();
        
        System.out.println("Enter high seed: ");
        int h = reader.nextInt();
        
        System.out.println("Enter high seed injury metric: ");
        int ih = reader.nextInt();    
        
        System.out.println("Enter high seed playoff experience: ");
        int ph = reader.nextInt();
        
        System.out.println("Enter high seed star power/depth: ");
        int sph = reader.nextInt();   
        
        System.out.println("Enter low seed: ");
        int l = reader.nextInt();
        
        System.out.println("Enter low seed injury metric: ");
        int il = reader.nextInt();
        
        System.out.println("Enter low seed playoff experience: ");
        int pl = reader.nextInt();            
        
        System.out.println("Enter low seed star power/depth: ");
        int spl = reader.nextInt();    

   
        BracketPredictor bp = new BracketPredictor();
        
        int hcount=0;
        for(int i=0; i<7; i++){
            if(bp.guessWinner(h, l, ih, il, ph, pl, sph, spl)){
                hcount++;
            }else{
                hcount--;
            }
        }
        if(hcount>=0){
            System.out.println("Higher seed wins with " + hcount);
            
            if(hcount == 0){
                System.out.println("This victory is achieved in " + 7 + " games");
            }else if(hcount > 4){
                System.out.println("This victory is achieved in " + 4 + " games");
            }else{
                System.out.println("This victory is achieved in " + (8 - hcount) + " games");
            }
        }else{               
            System.out.println("Lower seed wins with " + hcount);
            if(hcount < -4){
                System.out.println("This victory is achieved in " + 4 + " games");
            }else{
                System.out.println("This victory is achieved in " + (hcount + 8) + " games");
            }
        }
        
        reader.close();     
    }        
       
}





