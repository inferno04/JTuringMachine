package turingmachine;

/**
 * Created by inferno04 on 4/25/2014.
 */
public class Transition {

    private int currentState;
    private char read;

    private int futureState;
    private char write;
    private Action action;

    /**
     * Construct a Transition (delta).
     * @param currentState
     * @param read
     * @param futureState
     * @param write
     * @param action
     */
    public Transition(int currentState, char read, int futureState, char write, Action action) {
        this.currentState = currentState;
        this.read = read;
        this.futureState = futureState;
        this.write = write;
        this.action = action;
    }

    /**
     * Return whether this Transition is applicable to the current state of a Turing machine.
     * @param state
     * @param read
     * @return
     */
    public boolean applies(int state, char read) {
        return (state == currentState && read == this.read);
    }

    /**
     * Return the state the machine is being transitioned to.
     * @return
     */
    public int getFutureState() {
        return futureState;
    }

    /**
     * Return the value to be written to the tape.
     * @return
     */
    public char getWrite() {
        return write;
    }

    /**
     * Return the Action the read/write head is to perform upon writing to the tape.
     * @return
     */
    public Action getHeadAction() {
        return action;
    }
}
