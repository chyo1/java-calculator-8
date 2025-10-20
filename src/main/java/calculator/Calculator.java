package calculator;

public class Calculator {
    private IOController ioController = new IOController();
    private Parser parser = new Parser();
    private Operator operator = new Operator();
    private Validator validator = new Validator();

    private char[] basicSeperators = {',', ';'};
    private Character customSeparator = null;

    public void execute() {
        // 입력 받기
        String inputStr = ioController.input();

        // 입력이 형식에 맞게 들어왔는지 확인
        validator.validateInputEmpty(inputStr);
        validator.validateBasicSeparator(inputStr, basicSeperators);

        // 커스텀 구분자 확인
        if (isCustomSeparatorExisted(inputStr)) {
            inputStr = inputStr.substring(5);
        }

        // 문자열 형식 오류 확인
        validator.validateSeparatorType(inputStr, basicSeperators, customSeparator);

        // 계산
        String[] inputs = parser.getNumbers(inputStr, basicSeperators, customSeparator);
        int total = 0;
        for (String input : inputs) {
            total = operator.sum(total, Integer.parseInt(input));
        }

        // 출력
        ioController.print(total);
    }

    // 커스텀 구분자 추출
    public boolean isCustomSeparatorExisted(String s) {
        if (s.startsWith("//")) {
            validator.validateCustomSeparatorForm(s);
        } else {
            return false;
        }
        customSeparator = s.charAt(2);
        return true;
    }

}
