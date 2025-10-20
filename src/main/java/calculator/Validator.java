package calculator;

public class Validator {

    // 입력이 없을 때 (빈 문자열, null)
    public void validateInputEmpty(String s) {
        if (s == null) {
            throw new IllegalArgumentException("문자열이 입력되지 않았습니다");
        }
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

    private String makeSeparatorIntoSplitForm(char[] separators) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < separators.length; i++) {
            sb.append(separators[i]);
            if (i < separators.length - 1) {
                sb.append("|");
            }
        }
        return sb.toString();
    }

    // 커스텀 구분자가 형식에 맞게 입력됐는지
    public void validateCustomSeparatorForm(String s) {
        // 커스텀 구분자가 문자열 앞 부분에 위치해 있는지
        s = s.replace("\\n", "\n");
        if (s.startsWith("//")) {
            // 커스텀 구분자가 1개인지
            if (s.charAt(3) != '\n') {
                throw new IllegalArgumentException("커스텀 구분자의 입력이 형식에 맞지 않습니다.");
            }

            // 커스텀 문자가 숫자일 때
            char customSeparator = s.charAt(2);
            if (Character.isDigit(customSeparator)) {
                throw new IllegalArgumentException("커스텀 구분자는 숫자가 아닌 문자여야 합니다.");
            }

            // 커스텀 구분자 지정 문자가 커스텀 구분자로 들어온 경우
            if (customSeparator == '\n') {
                throw new IllegalArgumentException("커스텀 구분자는 커스텀 구분자의 지정 문자가 아닌 문자여야 합니다.");
            }
        }
    }

    // 지정되지 않은 문자열이 입력됐는지
    public void validateSeparatorType(String input, char[] basicSeparators, Character customSeparator) {
        String separators = makeSeparatorIntoSplitForm(basicSeparators);
        separators = separators + "|" + customSeparator;

        String[] splitInput = input.split(separators);
        for (String split : splitInput) {
            try {
                int num = Integer.parseInt(split);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구분자 이외의 입력이 들어 있습니다.");
            }
        }
    }
}
