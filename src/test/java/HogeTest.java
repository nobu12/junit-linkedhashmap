import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HogeTest {
    @Test
    void LinkedHashMapのデータ登録順が同じであること() {
        // 期待値の作成
        Map<String, String> expected = new LinkedHashMap<>();
        // 意図的に実測値とはデータ登録順を逆にしてテストが失敗することを予想するが、実行するとテスト成功してしまう
        expected.put("b1", "b2");
        expected.put("a1", "a2");

        // 実測値の作成
        Map<String, String> actual = new LinkedHashMap<>();
        actual.put("a1", "a2");
        actual.put("b1", "b2");

        // 確認
        assertEquals(expected, actual);
    }

    @Test
    void LinkedHashMapをArrayListに変換してデータ登録順が同じであること() {
        // 期待値の作成
        Map<String, String> expected = new LinkedHashMap<>();
        // 意図的に実測値とはデータ登録順を逆にしてテストが失敗することを予想し、実行するとテスト失敗する
        expected.put("b1", "b2");
        expected.put("a1", "a2");

        // 実測値の作成
        Map<String, String> actual = new LinkedHashMap<>();
        actual.put("a1", "a2");
        actual.put("b1", "b2");

        // 確認
        assertEquals(new ArrayList<>(expected.entrySet()), new ArrayList<>(actual.entrySet()));
    }
}