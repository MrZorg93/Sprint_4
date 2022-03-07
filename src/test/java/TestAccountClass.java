import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestAccountClass {

    @DisplayName("Проверяем имя/фамилию нулевой длинны")
    @Description("Успешное выполнение теста при срабатывании валидатора и возвращении false от checkNameToEmboss")
    @Test
    public void checkCheckNameToEmbossReturnFalseWhenNameIsVoid(){
        String name = "";
        Account account = new Account(name);
        assertFalse(account.checkNameToEmboss(), "Неверное имя прошло валидацию!");
    }

    @DisplayName("Проверяем пустое имя/фамилию")
    @Description("Успешное выполнение теста при срабатывании валидатора и возвращении false от checkNameToEmboss")
    @Test
    public void checkCheckNameToEmbossReturnFalseWhenNameIsNull(){
        String name = null;
        Account account = new Account(name);
        assertFalse(account.checkNameToEmboss(), "Неверное имя прошло валидацию!");
    }

    @DisplayName("Проверяем НЕ корректные по длине имя/фамилию")
    @Description("Успешное выполнение теста при срабатывании валидатора и возвращении false от checkNameToEmboss")
    @ParameterizedTest(name = "#{index} - Проверка на длину имени/фамилии: {0} символов")
    @ValueSource(ints = {2,20,30})
    public void checkCheckNameToEmbossReturnFalseWhenNameIsIncorrectLength(Integer arg){
        String name = RandomStringUtils.randomAlphabetic(arg/2) + " " + RandomStringUtils.randomAlphabetic(arg - arg/2 - 1);
        Account account = new Account(name);
        System.out.println("Тестируемое имя: " + "\'" + name + "\'");
        assertFalse(account.checkNameToEmboss(), "Неверное имя прошло валидацию!");
    }

    @DisplayName("Проверяем корректные по длине имя/фамилию")
    @Description("Успешное выполнение теста при возвращении true от checkNameToEmboss")
    @ParameterizedTest(name = "#{index} - Проверка на длину имени/фамилии: {0} символов")
    @ValueSource(ints = {3,4,10,18,19})
    public void checkCheckNameToEmbossReturnTrueWhenNameIsCorrectLength(Integer arg){
        String name = RandomStringUtils.randomAlphabetic(arg/2) + " " + RandomStringUtils.randomAlphabetic(arg - arg/2 - 1);
        Account account = new Account(name);
        System.out.println("Тестируемое имя: " +  "\'" + name + "\'");
        assertTrue(account.checkNameToEmboss(), "Верное имя НЕ прошло валидацию!");
    }

    @DisplayName("Проверяем имя/фамилию с пробелами перед именем")
    @Description("Успешное выполнение теста при возвращении false от checkNameToEmboss")
    @ParameterizedTest(name = "#{index} - Проверка на пробелы перед именем: {0} символов")
    @ValueSource(ints = {1, 2})
    public void checkCheckNameToEmbossReturnFalseWhenNameHasSpaseInFront(Integer arg){
        String name = StringUtils.repeat(" ", arg) + RandomStringUtils.randomAlphabetic(10);
        Account account = new Account(name);
        System.out.println("Тестируемое имя: " + "\'" + name + "\'");
        assertFalse(account.checkNameToEmboss(), "Неверное имя прошло валидацию!");
    }

    @DisplayName("Проверяем имя/фамилию с пробелами после имени")
    @Description("Успешное выполнение теста при возвращении false от checkNameToEmboss")
    @ParameterizedTest(name = "#{index} - Проверка на пробелы после имени: {0} символов")
    @ValueSource(ints = {1, 2})
    public void checkCheckNameToEmbossReturnFalseWhenNameHasSpaseInBack(Integer arg){
        String name = RandomStringUtils.randomAlphabetic(10) + StringUtils.repeat(" ", arg);
        Account account = new Account(name);
        System.out.println("Тестируемое имя: " + "\'" + name + "\'");
        assertFalse(account.checkNameToEmboss(), "Неверное имя прошло валидацию!");
    }

    @DisplayName("Проверяем имя/фамилию с пробелами 2шт подряд внутри имени")
    @Description("Успешное выполнение теста при возвращении false от checkNameToEmboss")
    @Test
    public void checkCheckNameToEmbossReturnFalseWhenNameHas2SpaseTogether(){
        String name = RandomStringUtils.randomAlphabetic(3) + "  " + RandomStringUtils.randomAlphabetic(4);
        Account account = new Account(name);
        System.out.println("Тестируемое имя: " + "\'" + name + "\'");
        assertFalse(account.checkNameToEmboss(), "Неверное имя прошло валидацию!");
    }

    @DisplayName("Проверяем имя/фамилию с пробелами 2шт подряд внутри имени")
    @Description("Успешное выполнение теста при возвращении false от checkNameToEmboss")
    @Test
    public void checkCheckNameToEmbossReturnFalseWhenNameHas2SpaseShared(){
        String name = RandomStringUtils.randomAlphabetic(3) + " " + RandomStringUtils.randomAlphabetic(2) + " " + RandomStringUtils.randomAlphabetic(2);
        Account account = new Account(name);
        System.out.println("Тестируемое имя: " + "\'" + name + "\'");
        assertFalse(account.checkNameToEmboss(), "Неверное имя прошло валидацию!");
    }
}
