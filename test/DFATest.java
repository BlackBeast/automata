import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;


/**
 * Created by ashwin on 10/11/16.
 */
public class DFATest {
    @Test
    public void testInputContainsEvenNumberOf0() throws Exception{
        DFA<Integer> dfa = new DFA<Integer>();
        dfa.addToAlphabet(0);
        dfa.addToAlphabet(1);

        State evenNumber = new State();
        evenNumber.setFinalState(true);
        dfa.addToStates(evenNumber);

        State oddNumber = new State();
        oddNumber.setFinalState(true);
        dfa.addToStates(oddNumber);

        Transition<Integer> t1 =
                new Transition<Integer>(evenNumber, 0, oddNumber);
        dfa.addTransition(t1);

        Transition<Integer> t2 =
                new Transition<Integer>(oddNumber, 0, evenNumber);
        dfa.addTransition(t2);

        Transition<Integer> t3 =
                new Transition<Integer>(evenNumber, 1, evenNumber);
        dfa.addTransition(t3);

        Transition<Integer> t4 =
                new Transition<Integer>(oddNumber, 1, oddNumber);
        dfa.addTransition(t4);

        LinkedList<Integer> binaryList =
                new LinkedList<Integer>();
        binaryList.add(1);
        binaryList.add(0);
        binaryList.add(1);
        binaryList.add(1);
        binaryList.add(0);

        Assert.assertEquals(evenNumber,dfa.calculateFinalState(evenNumber, binaryList));

        binaryList.add(0);
        Assert.assertEquals(oddNumber,dfa.calculateFinalState(evenNumber, binaryList));
    }

//    @Test
//    public void AllStringsOtherThanTheStrings_11_And_111() throws Exception{
//        DFA<Integer> dfa = new DFA<Integer>();
//        dfa.addToAlphabet(0);
//        dfa.addToAlphabet(1);
//
//        State q0 = new State();
//        q0.setFinalState(false);
//        dfa.addToStates(q0);
//
//        State q1 = new State();
//        q1.setFinalState(true);
//        dfa.addToStates(q1);
//
//        State q2 = new State();
//        q2.setFinalState(false);
//        dfa.addToStates(q2);
//
//        State q3 = new State();
//        q3.setFinalState(false);
//        dfa.addToStates(q3);
//
//        State q4 = new State();
//        q4.setFinalState(true);
//        dfa.addToStates(q4);
//
//        Transition<Integer> t1 =
//                new Transition<Integer>(q0, 0, q1);
//        dfa.addTransition(t1);
//
//        Transition<Integer> t2 =
//                new Transition<Integer>(q0, 1, q1);
//        dfa.addTransition(t2);
//
//        Transition<Integer> t3 =
//                new Transition<Integer>(q1, 1, q2);
//        dfa.addTransition(t3);
//
//        Transition<Integer> t4 =
//                new Transition<Integer>(q1, 0, q4);
//        dfa.addTransition(t4);
//
//        Transition<Integer> t5 =
//                new Transition<Integer>(q2, 1, q3);
//        dfa.addTransition(t5);
//
//        Transition<Integer> t6 =
//                new Transition<Integer>(q2, 0, q4);
//        dfa.addTransition(t6);
//
//        Transition<Integer> t7 =
//                new Transition<Integer>(q3, 0, q4);
//        dfa.addTransition(t7);
//
//        Transition<Integer> t8 =
//                new Transition<Integer>(q3, 1, q4);
//        dfa.addTransition(t8);
//
//        Transition<Integer> t9 =
//                new Transition<Integer>(q4, 1, q4);
//        dfa.addTransition(t9);
//
//        Transition<Integer> t10 =
//                new Transition<Integer>(q4, 0, q4);
//        dfa.addTransition(t10);
//
//        LinkedList<Integer> binaryList =
//                new LinkedList<Integer>();
//        binaryList.add(1);
////        binaryList.add(0);
//        binaryList.add(1);
//        binaryList.add(1);
////        binaryList.add(0);
//
//        Assert.assertEquals(q4,dfa.calculateFinalState(q4, binaryList));
//
////        binaryList.add(0);
////        Assert.assertEquals(oddNumber,dfa.calculateFinalState(evenNumber, binaryList));
//    }

    @Test
    public void AllStringsWhoseDecimalRepresentationIsAPowerOfTwo() throws Exception{
        DFA<Integer> dfa = new DFA<Integer>();
        dfa.addToAlphabet(0);
        dfa.addToAlphabet(1);

        State q0 = new State();
        q0.setFinalState(false);
        dfa.addToStates(q0);

        State q1 = new State();
        q1.setFinalState(true);
        dfa.addToStates(q1);

        State q2 = new State();
        q2.setFinalState(false);
        dfa.addToStates(q2);

        Transition<Integer> t1 =
                new Transition<Integer>(q0, 0, q2);
        dfa.addTransition(t1);

        Transition<Integer> t2 =
                new Transition<Integer>(q0, 1, q1);
        dfa.addTransition(t2);

        Transition<Integer> t3 =
                new Transition<Integer>(q1, 0, q1);
        dfa.addTransition(t3);

        Transition<Integer> t4 =
                new Transition<Integer>(q1, 1, q2);
        dfa.addTransition(t4);

        Transition<Integer> t5 =
                new Transition<Integer>(q2, 0, q2);
        dfa.addTransition(t5);

        Transition<Integer> t6 =
                new Transition<Integer>(q2, 1, q2);
        dfa.addTransition(t6);

        LinkedList<Integer> binaryList =
                new LinkedList<Integer>();
        binaryList.add(1);
//        binaryList.add(0);
//        binaryList.add(1);
//        binaryList.add(1);
//        binaryList.add(0);

        Assert.assertEquals(q1,dfa.calculateFinalState(q1, binaryList));

//        binaryList.add(0);
//        Assert.assertEquals(oddNumber,dfa.calculateFinalState(evenNumber, binaryList));
    }

}