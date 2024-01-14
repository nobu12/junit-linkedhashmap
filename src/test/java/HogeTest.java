import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HogeTest {
    @Test
    void LinkedHashMapのデータ順序が同じであること() {
        // 準備
        Map<String, String> expected = new LinkedHashMap<>();
        // 意図的に実測値とは順序を逆にしてテストが失敗することを予想するが、実行するとテスト成功してしまう
        expected.put("b1", "b2");
        expected.put("a1", "a2");

        // 実行
        Map<String, String> actual = new LinkedHashMap<>();
        actual.put("a1", "a2");
        actual.put("b1", "b2");

        // 確認
        assertEquals(expected, actual);
    }

    @Test
    void LinkedHashMapをArrayListに変換してデータ順序が同じであること() {
        // 準備
        Map<String, String> expected = new LinkedHashMap<>();
        // 意図的に実測値とは順序を逆にしてテストが失敗することを予想し、実行するとテスト失敗する
        expected.put("b1", "b2");
        expected.put("a1", "a2");

        // 実行
        Map<String, String> actual = new LinkedHashMap<>();
        actual.put("a1", "a2");
        actual.put("b1", "b2");

        // 確認
        assertEquals(new ArrayList<>(expected.entrySet()), new ArrayList<>(actual.entrySet()));
    }
}