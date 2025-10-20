package calculator;

import camp.nextstep.edu.missionutils.Console;

public class IOController {
    // 입력 받기
    public String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    // 출력하기
    public void print(int result) {
        System.out.println("결과 : " + result);
    }
}
