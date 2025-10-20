package calculator;

public class Parser {
    Validator validator = new Validator();

    // 커스텀 구분자 추출
    public Character getCustomSeparator(String s) {
        if (s.startsWith("//")) {
            validator.validateCustomSeparatorForm(s);
            return s.charAt(2);
        }
        return null;
    }

    // 구분자 기준 분리
    public String[] getNumbers(String s, char[] basicSeperators, Character customSeperator) {
        StringBuilder sb = new StringBuilder();
        sb.append(basicSeperators[0] + '|');
        sb.append(basicSeperators[1] + '|');
        if (customSeperator != null) {
            sb.append(customSeperator);
        }

        String separators = sb.toString();
        return s.split(separators);
    }
}
