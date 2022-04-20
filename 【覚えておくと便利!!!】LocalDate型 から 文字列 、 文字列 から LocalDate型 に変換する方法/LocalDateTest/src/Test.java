import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {

    public static void main(String[] args) {

        // 変換する文字列
        String date1 = "2020/07/07";

        // Stringからjava.time.LocalDateに変換する
        LocalDate test1 = LocalDate.parse(date1, DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        // java.time.LocalDateからStringに変換する
        String test2 = test1.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        // 変換内容を表示
        System.out.println(date1 + " → "  + test1);
        System.out.println(test1 + " → "  + test2);

    }

}