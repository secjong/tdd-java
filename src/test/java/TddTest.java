import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class TddTest {

    private static int cnt = 10;

    @Test
    void main() {
//        String referer = "http://ktostay.interpark.com:8082/area";
//        String[] splitReferer = referer.split("\\/");
//        String pageName = splitReferer[splitReferer.length - 1];
//
//        String result = String.format("//ktostay.interpark.com/main/%s/authConfirm/", pageName);
//
//        assertEquals("//ktostay.interpark.com/main/area/authConfirm/", result);

        boolean isDiscounted = false;

        while (true) {
            if (cnt > 0) {
                cnt--;
                isDiscounted = true; // 재고 1개 이상일때는 차감됨
                System.out.println("재고차감됨 cnt : " + String.valueOf(cnt));
            } else if (cnt == 0) {
                isDiscounted = false; // 재고 0개일때는 차감안됨
                break;
            }
        }

        System.out.println("cnt : " + String.valueOf(cnt));

        try {
            String[] stringArr = new String[10];
            if (!isDiscounted) {
                System.out.println("재고 차감이 안됐으며");
                System.out.println("여기서 예외발생!!!");
                stringArr[11] = "못넣는 값"; // 여기서 예외발생!!!
            }

            // 여기는 실행되지도 않음
            System.out.println("여기는 실행되지도 않음");
            int top = 10;
            int bottom = 0;
            int result = top / bottom;

        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("ArrayIndexOutOfBoundsException 부");
            System.out.println(aioobe.getMessage());
            cnt++;
            System.out.println("재고증가 cnt : " + String.valueOf(cnt));
            throw aioobe;
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("IndexOutOfBoundsException 부");
            System.out.println(ioobe.getMessage());
            cnt++;
            System.out.println("재고증가 cnt : " + String.valueOf(cnt));
            throw ioobe;
        } catch (ArithmeticException ae) {
            System.out.println("ArithmeticException 부");
            System.out.println(ae.getMessage());
            cnt++;
            System.out.println("재고증가 cnt : " + String.valueOf(cnt));
            throw ae;
        } catch (Exception e) {
            System.out.println("Exception 부");
            System.out.println(e.getMessage());
            cnt++;
            System.out.println("재고증가 cnt : " + String.valueOf(cnt));
            throw e;
        }

        try {
            System.out.println("베네피아 쿠폰발급 시작");
        } catch (Exception e) {
            System.out.println("베네피아 쿠폰발급 예외");
            cnt++;
            System.out.println("재고증가 cnt : " + String.valueOf(cnt));
            throw e;
        }
        
        System.out.println("베네피아 쿠폰발급 후");

    }

    @Test
    void main2() {

        String genderData = "1";
        String ageData = "70";

        // 성별이 1, 2, 3, 4 중에 포함되어야 정상
        // 나이가 70 미만인 숫자이어야 정상
        // 나머지 경우는 user.sex, user.age 둘다 세팅하지 않음
        String genderPattern = "^[1-4]$";
        String agePattern = "^[1-9]|[1-6][0-9]$"; // 0 ~ 69

        boolean isGenderValid = Pattern.matches(genderPattern, genderData);
        boolean isAgeValid = Pattern.matches(agePattern, ageData);

        Assert.assertEquals(isGenderValid, true);
        Assert.assertEquals(isAgeValid, true);

    }

}