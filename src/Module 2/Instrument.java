// Step 1: Create an abstract class Instrument
abstract class Instrument {

    private String name;
    protected int year;

    public Instrument(String name, int year){

        this.name = name;
        this.year = year;
    }

    public abstract String play();

    public String getInstrumentDetails(){
        return ("name" + this.name + "\nyear: " + this.year);
    }

}

// Step 2: Create an interface Tunable
interface Tunable{
    String tune();
    String adjustPitch(boolean up);
}

interface Maintainable{
    String clean();
    String inspect();
}

class StringedInstrument extends Instrument {

    private int numberOfStrings;
    
    public StringedInstrument(String name, int year, int numberOfStrings) {
        super(name, year);
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public String play(){
        return "Playing " + numberOfStrings + " strings instrument";
    }

    @Override
    public String getInstrumentDetails(){
        return super.getInstrumentDetails() + "No of strings: " + numberOfStrings;
    }

    public int getNumberOfStrings (){
        return numberOfStrings;
    }
}

class Guitar extends StringedInstrument implements Tunable, Maintainable {

    private String guitarType; //classical, electric, accoustic

    public Guitar (String name, int year, int numberOFStrings, String guitarType){
        super(name, year, numberOFStrings);
        this.guitarType = guitarType;
    }

    public String play(){
        return ("guitar playing");
    }

    public String tune(){
        return "tuning start";
    }

    public String adjustPitch(boolean up){
        if(up){
            return "pitched upwared adjusted";
        } else {
            return "already adjusted";
        } 

        
    }

    public String clean(){
        return "Guitar is cleaned";
    }

    public String inspect(){
        return "Inspect is started now";
    }

}

class Piano extends Instrument implements Tunable, Maintainable{

    private boolean isGrand;

    public Piano (String name, int year, boolean isGrand){
        super(name, year);
        this.isGrand = isGrand;
    }

    public String play(){
        return "Playing a piano";
    }

    public String tune(){
        return "tuning start";
    }

    public String adjustPitch(boolean up){
        if(up){
            return "pitched upwared adjusted";
        } else {
            return "already adjusted";
        } 

        
    }

    public String clean(){
        return "Piano is cleaned";
    }

    public String inspect(){
        return "Inspect is started now";
    }


}
