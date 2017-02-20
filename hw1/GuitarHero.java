/**
 * Created by ranko on 2/20/17.
 */
public class GuitarHero {
    private static final double CONCERT_A = 440.0;
    private static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);

    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        /* create two guitar strings, for concert A and C */
        synthesizer.GuitarString[] arr = new synthesizer.GuitarString[37];
        for(int i = 0; i < 37; i++){
             double concert = CONCERT_A * Math.pow(2, (i - 24) / 12);
            arr[i] = new synthesizer.GuitarString(concert);
        }

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {

                char key = StdDraw.nextKeyTyped();
                if (keyboard.indexOf(key) > -1) {
                    arr[keyboard.indexOf(key)].pluck();
                }
            }

        /* compute the superposition of samples */
            double sample = 0;
            for (int i = 0; i < 37; i++){
                sample += arr[i].sample();
            }

        /* play the sample on standard audio */
            StdAudio.play(sample);

        /* advance the simulation of each guitar string by one step */
            for(int i = 0; i < 37; i++){
                arr[i].tic();
            }
        }
    }
}
