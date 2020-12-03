package generator;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Generator {
    private Random index = new Random();

    private final List<String> maleNames = Arrays.asList("Антон", "Борис", "Владимир", "Глеб", "Дмитрий", "Евгений", "Жаб","Захар",
            "Иван", "Кайо", "Леонид", "Михаил", "Николай", "Олег", "Петр", "Роман", "Сергей", "Тимофей", "Увайс",
            "Фазиль", "Хабиб", "Цветимир", "Чеслав", "Шавкат", "Щеслав", "Эдуард", "Юлий", "Яков");

    private final List<String> femaleNames = Arrays.asList("Алина", "Богдана", "Влада", "Галина", "Динара", "Евгения", "Жозефина",
            "Зарине", "Ивана", "Карина", "Людмила", "Милена", "Нина", "Ольга", "Полина", "Роза", "Светлана", "Томара",
            "Ульяна", "Фатима", "Хельга", "Циля", "Чита", "Шейла", "Эмилия", "Юлия", "Яна");


    public String getName() {
        return maleNames.get(index.nextInt(maleNames.size()));
    }

    public String getName(String gender) {
        String name = null;
        Random index = new Random();
        if (gender.equals("male")) {
            name = maleNames.get(index.nextInt(maleNames.size()));
        }
        if (gender.equals("female")) {
            name = femaleNames.get(index.nextInt(femaleNames.size()));
        }
        return name;
    }

    private String parseName(String name, String gender, String type) {
        String endingOne = null;
        String endingTwo = null;
        if (gender.equals("male") && type.equals("surname")) {
            endingOne = "ев";
            endingTwo = "ов";
        }
        if (gender.equals("female") && type.equals("surname")) {
            endingOne = "ева";
            endingTwo = "ова";
        }
        if (gender.equals("male") && type.equals("middleName")) {
            endingOne = "евич";
            endingTwo = "ович";
        }
        if (gender.equals("female") && type.equals("middleName")) {
            endingOne = "евна";
            endingTwo = "овна";
        }
        if (name.endsWith("й")) {
            name = name.substring(0, name.length() - 1);
            name = name.concat(endingOne);
        }
        else {
            name = name.concat(endingTwo);
        }
        return name;
    }

    public String getSurname() {
        String name = getName();
        return parseName(name, "male", "surname");
    }

    public String getSurname(String gender) {
        String name = getName();
        return parseName(name, gender, "surname");
    }

    public String getMiddleName() {
        String name = getName();
        return parseName(name, "male", "middleName");
    }

    public String getMiddleName(String gender) {
        String name = getName();
        return parseName(name, gender, "middleName");
    }

    public String getMail() {
        String number = Integer.toString(index.nextInt(999999) + 100000);
        return "test".concat("+").concat(number).concat("@techranch.ru");
    }

    public String getPhone() {
        String number = Integer.toString(index.nextInt(9999999) + 1000000);
        return "926".concat(number);
    }

    public String getPhone(String code) {
        String number = Integer.toString(index.nextInt(9999999) + 1000000);
        return code.concat(number);
    }

    public String getPhone(String prefix, String code) {
        String number = Integer.toString(index.nextInt(9999999) + 1000000);
        return prefix.concat(code).concat(number);
    }
}
