package calculator;

public class Validator {
    // 입력이 형식에 맞게 들어왔는지 확인
    public void validateInputFormat(String s, char[] basicSeparators) {
        validateInputEmpty(s, basicSeparators);
    }

    // 입력이 없을 때 (빈 문자열, null)
    public void validateInputEmpty(String s, char[] basicSeparators) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("문자열이 입력되지 않았습니다");
        }
    }

    // 구분자가 형식에 맞게 입력됐는지 검증
    public void validateSeparator(String s, char[] basicSeparators) {
        validateBasicSeparator(s, basicSeparators);
    }

    // 기본 구분자가 형식에 맞게 입력됐는지 검증
    public void validateBasicSeparator(String s, char[] basicSeparators) {
        String separators = makeSeparatorIntoSplitForm(basicSeparators);
        String[] splitInput = s.split(separators);
        for (String split : splitInput) {
            if (split.isEmpty()) {
                throw new IllegalArgumentException("기본 구분자의 입력이 형식에 맞지 않습니다.");
            }
        }
    }

    private String makeSeparatorIntoSplitForm(char[] basicSeparators) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < basicSeparators.length; i++) {
            sb.append(basicSeparators[i]);
            if (i < basicSeparators.length - 1) {
                sb.append("|");
            }
        }
        return sb.toString();
    }
    // 커스텀 구분자가 문자열 앞 부분에 위치해 있는지
    // 지정되지 않은 문자열이 입력됐는지
}
