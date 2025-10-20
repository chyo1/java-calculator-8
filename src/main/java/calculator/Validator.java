package calculator;

public class Validator {
    // 입력이 형식에 맞게 들어왔는지 확인
    public void validateInputFormat(String s) {
        validateInputEmpty(s);
    }

    // 입력이 없을 때 (빈 문자열, null)
    public void validateInputEmpty(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("문자열이 입력되지 않았습니다");
        }
    }

    // 구분자가 형식에 맞게 입력됐는지 검증
    // 기본 구분자가 형식에 맞게 입력됐는지
    // 커스텀 구분자가 1개 이상 들어왔는지
    // 커스텀 구분자가 형식에 맞게 입력됐는지
    // 커스텀 구분자가 문자열 앞 부분에 위치해 있는지
    // 지정되지 않은 문자열이 입력됐는지
}
