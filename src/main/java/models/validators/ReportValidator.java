package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.ReportView;
import constants.MessageConst;

/**
 * 日報インスタンスに設定されている値のバリデーションを行うクラス
 */
public class ReportValidator {

    /**
     * 日報インスタンスの各項目についてバリデーションを行う
     * @param rv 日報インスタンス
     * @return エラーのリスト
     */
    public static List<String> validate(ReportView rv) {
        List<String> errors = new ArrayList<String>();

        //タイトルのチェック
        String titleError = validateTitle(rv.getTitle());
        if (!titleError.equals("")) {
            errors.add(titleError);
        }

        //内容のチェック
        String contentError = validateContent(rv.getContent());
        if (!contentError.equals("")) {
            errors.add(contentError);
        }

        //出勤時間のチェック
        String workedError = validateWorked(rv.getWorked());
        if (!workedError.equals("")) {
            errors.add(workedError);
        }

        //退勤時間のチェック
        String offworkedError = validateOffworked(rv.getOffworked());
        if (!offworkedError.equals("")) {
            errors.add(offworkedError);
        }

        return errors;
    }

    /**
     * タイトルに入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param title タイトル
     * @return エラーメッセージ
     */
    private static String validateTitle(String title) {
        if (title == null || title.equals("")) {
            return MessageConst.E_NOTITLE.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

    /**
     * 内容に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param content 内容
     * @return エラーメッセージ
     */
    private static String validateContent(String content) {
        if (content == null || content.equals("")) {
            return MessageConst.E_NOCONTENT.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

    /**
     * 出勤時間に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param worked 出勤時間
     * @return エラーメッセージ
     */
    private static String validateWorked(String worked) {
        if (worked == null || worked.equals("")) {
            return MessageConst.E_NOTITLE.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

    /**
     * タイトルに入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param offworke 退勤時間
     * @return エラーメッセージ
     */
    private static String validateOffworked(String offworked) {
        if (offworked == null || offworked.equals("")) {
            return MessageConst.E_NOTITLE.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }
}