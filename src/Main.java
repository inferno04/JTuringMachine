import turingmachine.Action;
import turingmachine.HaltState;
import turingmachine.Tape;
import turingmachine.Transition;
import turingmachine.TuringMachine;

/**
 * Created by inferno04 on 4/25/2014.
 */
public class Main {

    /**
     * Testing TuringMachine and related classes.
     * @param args
     */
    public static void main(String... args) {

        // Define blank to be a space. (It makes output readable)
        final char blank = ' ';

        // Define delta 1
        final Transition[] d1 = new Transition[6];
        d1[0] = new Transition(0, 'a', 0, 'b', Action.RIGHT);
        d1[1] = new Transition(0, 'b', 0, 'b', Action.RIGHT);
        d1[2] = new Transition(0, blank, 1, blank, Action.LEFT);
        d1[3] = new Transition(1, 'a', 1, 'a', Action.LEFT);
        d1[4] = new Transition(1, 'b', 1, 'b', Action.LEFT);
        d1[5] = new Transition(1, blank, 2, blank, Action.RIGHT);

        // Define our first Turing machine.
        // This machine replaces all a's in a given Tape with b's.
        final TuringMachine m = new TuringMachine(blank, 0, new int[]{1}, d1);
        final Tape t = new Tape("aaa", blank);
        final HaltState r1 = m.run(t, 100);
        System.out.println(r1);
        System.out.println(t.getTapeContents());

        // Define delta 2
        final Transition[] d2 = new Transition[7];
        d2[0] = new Transition(0, 'a', 1, 'a', Action.RIGHT);
        d2[1] = new Transition(1, 'a', 1, 'a', Action.RIGHT);
        d2[2] = new Transition(1, 'b', 1, 'b', Action.RIGHT);
        d2[3] = new Transition(1, blank, 2, blank, Action.LEFT);
        d2[4] = new Transition(2, 'a', 2, 'a', Action.LEFT);
        d2[5] = new Transition(2, 'b', 2, 'b', Action.LEFT);
        d2[6] = new Transition(2, blank, 3, blank, Action.RIGHT);

        // Define our second Turing machine.
        // This machine accepts strings matching the grammar a(a+b)*
        final TuringMachine m2 = new TuringMachine(blank, 0, new int[]{3}, d2);
        final Tape t2 = new Tape("aabaaabab", blank);
        final HaltState r2 = m2.run(t2, 100);
        System.out.println(r2);
        System.out.println(t2.getTapeContents());

    }

}
