package calculator;

public class Parser {
    Validator validator = new Validator();

    // 구분자 기준 분리
    public String[] getNumbers(String s, char[] basicSeparators, Character customSeparator) {
        StringBuilder sb = new StringBuilder();
        sb.append(basicSeparators[0]);
        sb.append("|" + basicSeparators[1]);
        if (customSeparator != null) {
            sb.append("|" + customSeparator);
        }

        String separators = sb.toString();
        return s.split(separators);
    }
}
