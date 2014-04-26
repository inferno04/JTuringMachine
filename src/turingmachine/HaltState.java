package turingmachine;

/**
 * Created by inferno04 on 4/25/2014.
 */
public enum HaltState {

    /**
     * The Turing machine has reached a final state during its computation.
     */
    FINAL_STATE,

    /**
     * A delta function describing what to do at the current state has not been supplied, and the machine will not halt normally.
     */
    UNDEFINED_STATE,

    /**
     * The specified timeout has been reached before normal halting could occur.
     */
    TIMEOUT;

}
