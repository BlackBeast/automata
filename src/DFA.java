import java.util.HashSet;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ashwin on 10/11/16.
 */
public class DFA<T> {
    private Set<T> alphabet = new HashSet<T>();
    private Set<State> States = new HashSet<State>();
    private Set<Transition<T>> transitionFunction = new HashSet<Transition<T>>();

    public void addToAlphabet(T symbol) {
        alphabet.add(symbol);
    }

    public void addToStates(State State){
        States.add(State);
    }

    public void addTransition(Transition<T> transition) throws IllegalArgumentException{
        if(transitionFunction.stream()
                .noneMatch(t -> t.getInputState().equals(transition.getInputState()) &&
                        t.getSymbol().equals(transition.getSymbol()))){
            transitionFunction.add(transition);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public State calculateFinalState(State State, Queue<T> symbol) throws IllegalStateException, IllegalArgumentException {
        if(symbol.isEmpty() && State.isFinalState()){
            return State;
        }
        if(!alphabet.contains(symbol.peek())){
            throw new IllegalArgumentException("Plz provide a valid alphabet");
        }
        Optional<State> nextState = getNextState(State, symbol.poll());
        if(nextState.isPresent()){
            return calculateFinalState(nextState.get(), symbol);
        }
        throw new IllegalStateException("I think the transition is provided for a state with doesn't exist");
    }

    private Optional<State> getNextState(State State, T alphabet){
        return
                transitionFunction.stream()
                        .filter(t -> t.getInputState().equals(State) &&
                                t.getSymbol().equals(alphabet))
                        .map(t -> t.getOutputState()).findFirst();
    }
}
