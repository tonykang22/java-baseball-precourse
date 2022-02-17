package baseball;

public class Output {

    private static final String REQUEST_USER_NUMBER = "숫자를 입력해주세요 : ";
    private static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_FOR_MORE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String SCORE_NOTHING = "낫싱 ";
    public static final String SCORE_BALL = "볼 ";
    public static final String SCORE_STRIKE = "스트라이크 ";

    public static void requestUserNumber() {
        System.out.print(REQUEST_USER_NUMBER);
    }

    public static void requestRestart() {
        System.out.println(GAME_OVER);
        System.out.println(ASK_FOR_MORE_GAME);
    }

}