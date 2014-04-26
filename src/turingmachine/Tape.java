package turingmachine;

/**
 * Created by inferno04 on 4/25/2014.
 */
public class Tape {

    private final char blank;
    private String tape;
    private int index;

    /**
     * Construct a Tape with a given starting string and the given blank character.
     *
     * @param input
     * @param blank
     */
    public Tape(String input, char blank) {
        this(input, blank, 0);
    }

    /**
     * Construct a Tape with a given starting string, blank character, and starting at the specified position.
     *
     * @param input
     * @param blank
     * @param start
     */
    public Tape(String input, char blank, int start) {
        tape = new String(input);
        this.blank = blank;
        index = start;
    }

    /**
     * Read the value on the tape at the current position.
     *
     * @return
     */
    public char read() {
        if (index >= tape.length()) {
            tape = tape + blank;
        }
        return tape.charAt(index);
    }

    /**
     * Write a value to the tape at the current position.
     *
     * @param value
     */
    public void write(char value) {
        char[] array = tape.toCharArray();
        array[index] = value;
        tape = new String(array);
    }

    /**
     * Move the read/write head to the left.
     */
    public void left() {
        if (index == 0) {
            tape = blank + tape;
            index = 0;
        } else {
            index--;
        }
    }

    /**
     * Move the read/write head to the right.
     */
    public void right() {
        if (index >= tape.length()) {
            tape = tape + blank;
        }
        index++;
    }

    /**
     * Perform a given read/write head Action.
     *
     * @param action
     */
    public void doAction(Action action) {
        switch (action) {
            case RIGHT:
                right();
                break;
            case LEFT:
                left();
                break;
            case HOLD:
            default:
        }
    }

    /**
     * Return the contents of the Tape. (As if it were removed and replaced in the same position.
     *
     * @return
     */
    public String getTapeContents() {
        return tape;
    }

}
