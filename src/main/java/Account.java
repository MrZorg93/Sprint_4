import io.qameta.allure.Step;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    @Step("Проверка строки для эмбоссирования")
    public boolean checkNameToEmboss(){

        try {
            char[] nameToArray = name.toCharArray();

            if (name != null &&
                    nameToArray[0] != ' ' &&
                    nameToArray[nameToArray.length - 1] != ' ' &&
                    nameToArray.length >= 3 &&
                    nameToArray.length <= 19 &&
                    nameToArray.length != 0) {
                int countPointer = 0;
                for (char symbol : nameToArray) {
                    if (symbol == ' ') countPointer++;
                }
                return countPointer == 1;
            } else return false;


        } catch (ArrayIndexOutOfBoundsException | NullPointerException a) {
            return false;
        }

    }

}
