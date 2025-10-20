package calculator;

public class Parser {
    Validator validator = new Validator();

    // 구분자 기준 분리
    public String[] getNumbers(String s, Character[] basicSeparators, Character customSeparator) {
        String separators = makeSeparatorIntoSplitForm(basicSeparators, customSeparator);
        return s.split(separators);
    }

    public String makeSeparatorIntoSplitForm(Character[] separators, Character customSeparator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < separators.length; i++) {
            sb.append(separators[i]);
            if (i < separators.length - 1) {
                sb.append("|");
            }
        }

        if (customSeparator != null) {
            sb.append("|");
            sb.append(customSeparator);
        }
        return sb.toString();
    }
}
