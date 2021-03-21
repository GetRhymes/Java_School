1) Класс Unpacker: 
    1) private static Boolean checkString(String str)
    Метод который проверяет валидность строки, в случае ошибки выбросит illegalArgumentException()
    2) private static Pair<String, Integer> unpacking(String str)
    Метод который рекурсивно распаковывает строку и возвращает Pair, где key есть результат работы программы
    3) public static String unpackingString(String str) 
    Главный публичный метод, который использует два предыдущих и возвращет результирующую строку
2) Класс TestUnpacker:
    Класс, который тестирует логику класса Unpacker на правильность распаковки строки и выброса ошибки в случае неправильных данных.