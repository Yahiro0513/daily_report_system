package models.validators;

import java.time.LocalDate;
import java.time.LocalTime;
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

        //日けのチェック
        String workedError=validateWorked(rv.getReportDate(),rv.getWorkedDate());
        if (!workedError.equals("")) {
            errors.add(workedError);
        }
        String offworkedError=validateOffworked(rv.getWorkedDate(),rv.getOffworkedDate());
        if (!offworkedError.equals("")) {
            errors.add(offworkedError);
        }

        //出退勤のチェック
        String timeError=validateTime(rv.getWorkedDate(),rv.getOffworkedDate(),rv.getWorkedTime(),rv.getOffworkedTime());
        if (!timeError.equals("")) {
            errors.add(timeError);
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
     * 日けをチェックし、入力値がなければエラーメッセージを返却
     * @param worked 出勤
     * @return エラーメッセージ
     */
    private static String validateWorked(LocalDate day,LocalDate workedDate) {

        if (workedDate.isBefore(day.minusDays(1))) {
            return MessageConst.E_WRONGWORKEDEARLY.getMessage();
        }
        if(workedDate.isAfter(day)) {
            return MessageConst.E_WRONGWORKEDLATE.getMessage();
        }
        //入力値がある場合は空文字を返却
        return "";
    }

    /**
     * 日けをチェックし、入力値がなければエラーメッセージを返却
     * @param offworked 退勤
     * @return エラーメッセージ
     */
    private static String validateOffworked(LocalDate workedDate,LocalDate offworkedDate) {

        if (workedDate.isAfter(offworkedDate) ) {

            return MessageConst.E_WRONGOFFWORKED.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

    /**
     * 出退勤時間をチェックし、エラーメッセージを返却
     * @param time 出退勤時間
     * @return エラーメッセージ
     */
    private static String validateTime(LocalDate workedDate,LocalDate offworkedDate,LocalTime workedTime,LocalTime offworkedTime) {

//        if(offworkedDate.isBefore(workedDate)) {
//            return MessageConst.E_WRONGTIME.getMessage();
//        }
        if (workedDate.equals(offworkedDate)&&offworkedTime.isBefore(workedTime)) {
            return MessageConst.E_WRONGTIME.getMessage();
        }
        return "";


    }



}