package main;

import java.util.Random;

public class Main{
    public static void main(String[] args) {

        //Q-Learning parameters
        double alpha = 0.5; //learning rate
        double gamma = 0.8; //discount factor

        int numStates = 6;//number of states
        int numActions = 4;//up, down, left, right
        double[][] Q = new double[numStates][numActions];//Q-table
        double[][] R = new double[numStates][numActions];//Reward table

        //inicilize Q-table
        for (int i = 0; i < numStates; i++) {
            for (int j = 0; j < numActions; j++) {
                Q[i][j] = 0;
            }
        }
        //initialize Reward table
        R[0][0] = -1;//up
        R[0][1] = -10;//down
        R[0][2] = -10;//left
        R[0][3] = -1;//right
        R[1][0] = -1;//up
        R[1][1] = -1;//down
        R[1][2] = -10;//left
        R[1][3] = -1;//right
        R[2][0] = -10;//up
        R[2][1] = -1;//down
        R[2][2] = -10;//left
        R[2][3] = 10;//right
        R[3][0] = -1;//up
        R[3][1] = -10;//down
        R[3][2] = -1;//left
        R[3][3] = -10;//right
        R[4][0] = 10;//up
        R[4][1] = -1;//down
        R[4][2] = -1;//left
        R[4][3] = -10;//right
        R[5][0] = -10;//up
        R[5][1] = -1;//down
        R[5][2] = -1;//left
        R[5][3] = -10;//right


        //int []actionD = new int[]{0,0,0,3};
        //int []actionD = new int[]{2,2,0,3};

        //int state = 0;//initialize state
        int state = 0;//initialize state

        int steps = 0;//initialize steps
        int action; //initialize action
        int nextState;//initialize next state
        Random generator = new Random();

        while (steps < 100) {

            action = generator.nextInt(4); // Escolhe açao aleatoriamente
            //action = actionD[steps];
            nextState = getNextState(state, action); //Determina proximo estado
            if(getReward(R, state, action) == -10) nextState = state; //Se bateu na parede, permanace no mesmo estado

            double next_max = getMaxQ(Q, nextState);

            //update Q-table
            Q[state][action] = Q[state][action] + alpha * (R[state][action] + (gamma * next_max) - Q[state][action]);
            state = nextState;
            steps++;
        }


        //Printando tabela Q
        System.out.println("                UP        DOWN      LEFT     RIGHT");
        for (int i = 0; i < numStates; i++) {
            System.out.print("State " + (i+1) + " -->   ");
            for (int j = 0; j < numActions; j++) {
                System.out.printf("%.5f",Q[i][j]); System.out.print("  ");
            }
            System.out.println();
        }

    }


    //get max Q-value
    public static double getMaxQ(double[][] Q, int state){
        double maxQ = Q[state][0];
        for(int i = 1; i < 4; i++){
            if(Q[state][i] > maxQ){
                maxQ = Q[state][i];
            }
        }
        return maxQ;
    }


    //get next state
    public static int getNextState(int state, int action) {
        int nextState = 0;
        if (action == 0) {
            nextState = state + 1;
        } else if (action == 1) {
            nextState = state - 1;
        } else if (action == 2) {
            nextState = state - 3;
        } else if (action == 3) {
            nextState = state + 3;
        }
        return nextState;
    }

    //get reward
    public static double getReward(double[][] R, int state, int action){
        return R[state][action];
    }

}