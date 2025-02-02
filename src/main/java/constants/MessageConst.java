package constants;

/**
 * 各出力メッセージを定義するEnumクラス
 *
 */
public enum MessageConst {

    //認証
    I_LOGINED("ログインしました"),
    E_LOGINED("ログインに失敗しました。"),
    I_LOGOUT("ログアウトしました。"),

    //DB更新
    I_REGISTERED("登録が完了しました。"),
    I_UPDATED("更新が完了しました。"),
    I_DELETED("削除が完了しました。"),

    //バリデーション
    E_NONAME("氏名を入力してください。"),
    E_NOPASSWORD("パスワードを入力してください。"),
    E_NOEMP_CODE("社員番号を入力してください。"),
    E_EMP_CODE_EXIST("入力された社員番号の情報は既に存在しています。"),
    E_NOTITLE("タイトルを入力してください。"),
    E_NOCONTENT("内容を入力してください。"),

    //出勤退勤
    E_WRONGWORKEDEARLY("出勤日は日報作成日の昨日より前です。"),
    E_WRONGWORKEDLATE("出勤日は日報作成日の明日以降です。"),
    E_WRONGOFFWORKED("出勤日は退勤日より前にしてください。"),
    E_WRONGTIME("出勤時間は退勤時間より前にしてください。"),
    E_NONWORKEDDATE("出勤日を選んでください"),
    E_NONWORKEDTIME("出勤時間を選んでください"),
    E_NONOFFWORKEDDATE("退勤日を選んでください"),
    E_NONOFFWORKEDTIME("退勤時間を選んでください");


    /**
     * 文字列
     */
    private final String text;

    /**
     * コンストラクタ
     */
    private MessageConst(final String text) {
        this.text = text;
    }

    /**
     * 値(文字列)取得
     */
    public String getMessage() {
        return this.text;
    }
}