package turingmachine;

/**
 * Created by inferno04 on 4/25/2014.
 */
public class TuringMachine {

    private int state;
    private Transition[] delta;
    private char blank;
    private int start;
    private int[] finals;

    /**
     * Construct a TuringMachine with the given blank, start state, final states, and delta function(s).
     * @param blank
     * @param startState
     * @param finalStates
     * @param delta
     */
    public TuringMachine(char blank, int startState, int[] finalStates, Transition... delta) {
        this.blank = blank;
        this.start = startState;
        this.finals = finalStates;
        this.delta = delta;
    }

    /**
     * Run an individual String in this machine.
     * @param tape
     * @param maxSteps
     * @return
     */
    public HaltState run(String tape, int maxSteps) {
        return run(new Tape(tape, blank), maxSteps);
    }

    /**
     * Run a specified Tape in this machine.
     * @param tape
     * @param maxSteps
     * @return
     */
    public HaltState run(Tape tape, int maxSteps) {
        int steps = 0;
        while (!isInFinalState()) {
            if (steps < maxSteps) {
                if (step(tape)) {
                    steps++;
                } else {
                    // Could not perform a transition.
                    return HaltState.UNDEFINED_STATE;
                }
            } else {
                // Our timeout has been reached.
                return HaltState.TIMEOUT;
            }
        }
        // We've reached a final state within timeout.
        return HaltState.FINAL_STATE;
    }

    /**
     * Return whether a step is successfully taken with the current delta function, and if so, preform it.
     *
     * @param tape
     * @return
     */
    public boolean step(Tape tape) {
        for (Transition t : delta) {
            if (t.applies(state, tape.read())) {
                state = t.getFutureState();
                tape.write(t.getWrite());
                tape.doAction(t.getHeadAction());
                return true;
            }
        }
        return false;
    }

    /**
     * Return whether the machine has reached a final state.
     * @return
     */
    private boolean isInFinalState() {
        for (int finalState : finals) {
            if (state == finalState) {
                return true;
            }
        }
        return false;
    }

}
