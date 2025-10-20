package calculator;

public class Parser {
    private char[] basicSeperators = {',', ';'};
    private Character customSeperator = null;
    Validator validator = new Validator();

    // 커스텀 구분자 추출
    public void checkCustomSeparator(String s) {
        if (s.startsWith("//")) {
            validator.validateCustomSeparatorForm(s);
        }
        customSeperator = s.charAt(2);
    }

    // 구분자 기준 분리
}
