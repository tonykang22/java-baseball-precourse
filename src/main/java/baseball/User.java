package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private int[] userAnswer;
    private int[] computerAnswer;
    private final int CORRECT = 777;
    private final int INCORRECT = 444;
    private final String RESTART_GAME = "1";
    private final String TERMINATE_GAME = "2";
    private int strike;
    private int ball;

    /**
     * "Scope" 를 생각해보는 것도 좋을거 같다.
     *
     * computerAnswer _ 정답을 맞출 때까지
     *
     * userAnswer / strike / ball _ 이번 답 입력까지
     *
     */
    public User() {
        Computer computer = new Computer();
        computerAnswer = computer.getAnswer();
        userAnswer = new int[3];
        inputNum();
    }

    public void inputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        for (int i = 0; i < 3; i++) {
            userAnswer[i] = input.charAt(i) - '0';
        }
//        System.out.println("[[ Cheat Version ]]");
        System.out.println("Computer Answer :: " + computerAnswer[0]+""+computerAnswer[1]+""+computerAnswer[2]);
        digitBingo();
    }

    private void digitBingo() {
        strike = 0;
        ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                checkDigit(i, j);
            }
        }
        gameStatus();
    }

    private void gameStatus() {
        if (printScore() == CORRECT) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restartInput = Console.readLine();

            if (restartInput == RESTART_GAME) {

            } else if (restartInput == TERMINATE_GAME) {
                return;
            }
        } else {
            inputNum();
        }
    }

    private void checkDigit(int i, int j) { // 00 01 02 11 12 22
        if (computerAnswer[i] == userAnswer[j]) {
            if (i == j) {
                ++strike;
            } else {
                ++ball;
            }
        }
    }

    private int printScore() {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return INCORRECT;
        } else if (strike == 3) {
            System.out.println(strike +"스트라이크");
            return CORRECT;
        } else if (ball == 0) {
            System.out.println(strike +"스트라이크");
            return INCORRECT;
        } else if (strike == 0) {
            System.out.println(ball + "볼 ");
            return INCORRECT;
        } else {
            System.out.println(ball + "볼 " + strike +"스트라이크");
            return INCORRECT;
        }
    }
}