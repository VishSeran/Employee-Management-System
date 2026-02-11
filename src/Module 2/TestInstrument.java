
public class TestInstrument {

    public static void main(String[] args) {

        Instrument[] instruments = new Instrument[3];

        instruments[0] = new Guitar("Fender Stratocaster", 2020, 6, "electric");
        instruments[1] = new Piano("Steinway", 2015, true);
        instruments[2] = new Guitar("Martin", 2018, 12, "acoustic");

        // Demonstrate polymorphism by calling play() for each instrument
        System.out.println("===== PLAYING INSTRUMENTS =====");
        for (Instrument instrument : instruments) {
            System.out.println(instrument.play());
            System.out.println(instrument.getInstrumentDetails());
        }

        // Demonstrate interface type checking and method calling
        System.out.println("\n===== MAINTAINING INSTRUMENTS =====");
        for (Instrument instrument : instruments) {
            System.out.println("The instrument we working with: " + instrument.getName());

            if (instrument instanceof Tunable) {
                Tunable tunableInstrument = (Tunable) instrument;
                System.out.println(tunableInstrument.tune());
                System.out.println(tunableInstrument.adjustPitch(true));
            }

            //instanceof = “Can you behave like this interface?”
            //casting = “Okay — now behave like it"
            if (instrument instanceof Maintainable) {
                Maintainable maintainableInstrument = (Maintainable) instrument;
                System.out.println(maintainableInstrument.clean());
                System.out.println(maintainableInstrument.inspect());

            }

            System.out.println("-----");
        }
    }
}
