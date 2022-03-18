package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballGame {

    private final int NUMBER_RANGE_START = 1;
    private final int NUMBER_RANGE_END = 9;
    private final int DIGIT_NUMBER = 3;

    public BaseballGame() {

    }

    public List<Integer> makeRandomNumber() {
        int answer = Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
        List<Integer> answerList = new ArrayList<>();
        Set<Integer> answerSet = new HashSet<>();

        while (answerSet.size() < DIGIT_NUMBER) {
            if (answerSet.contains(answer)) {
                answer = Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
            } else {
                answerSet.add(answer);
                answerList.add(answer);
            }
        }
        return answerList;
    }

    public boolean correct(int[] grade) {
        return grade[0] == 3;
    }

    public int[] gradeAnswer(List<Integer> answerList, List<Integer> playerAnswer) {
        int strike = 0;
        int ball = 0;
        Set<Integer> ballCandidates = new HashSet<>();
        ballCandidates.addAll(answerList);

        for (int i = 0; i < DIGIT_NUMBER; ++i) {
            if (answerList.get(i) == playerAnswer.get(i)) {
                ++strike;
                ballCandidates.remove(answerList.get(i));
                continue;
            }
            if (ballCandidates.remove(playerAnswer.get(i))) {
                ++ball;
            }
        }

        Output playerOutput = new Output();
        playerOutput.printScore(strike, ball);

        System.out.println("===Cheat Code===");
        System.out.println(answerList.toString());

        return new int[]{strike, ball};
    }
}
