package com.example.dialog;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.example.dialog.MyActivityTest \
 * com.example.dialog.tests/android.test.InstrumentationTestRunner
 */
public class MyActivityTest extends ActivityInstrumentationTestCase2<MyActivity> {

    private MyActivity mActivity;

    public MyActivityTest() {
        super("com.example.dialog", MyActivity.class);

    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        mActivity = null;
    }


    /**
     * フォーカスのチェックとボタンクリック
     *
     * @param button
     */
    private void clickButton(Button button) {

        // ボタンが選択できるかのチェック
        assertTrue(button.isEnabled());

        // ボタンのクリック
        TouchUtils.clickView(this, button);

    }

    /**
     * バックボタンのチェック
     */
    private void checkBackKey(Button button) {
        // バックボタンを押下
        sendKeys(KeyEvent.KEYCODE_BACK);

        // 入力イベントの待機
        getInstrumentation().waitForIdleSync();

        // アクティビティのボタンが選択できるかのチェック
        assertTrue(button.isEnabled());

    }

    /**
     * 背景のクリックチェック
     *
     * @param customDialog
     * @param button
     */
    private void checkBackLayout(CustomDialog customDialog, Button button) {

        // 背景をクリック
        FrameLayout backFrame = (FrameLayout) customDialog.getBackFrameLayout();
        TouchUtils.clickView(this, backFrame);

        // イベントの待機
        getInstrumentation().waitForIdleSync();

        // アクティビティのボタンが選択できるかのチェック
        assertTrue(button.isEnabled());

    }

    /**
     * ダイアログのクリックチェック
     *
     * @param fButton
     * @param bButton
     */
    private void checkDialogButton(Button fButton, Button bButton) {

        // ダイアログのボタンをクリック
        TouchUtils.clickView(this, fButton);

        // イベントの待機
        getInstrumentation().waitForIdleSync();

        // アクティビティのボタンが選択できるかのチェック
        assertTrue(bButton.isEnabled());

    }

    /**
     * ボタン１のメッセージの確認
     *
     * @param customDialog
     */
    public void dialog1Check(CustomDialog customDialog) {

        // タイトルが表示していない事を確認
        TextView textView = customDialog.getTitle();
        assertTrue(textView.getVisibility() == View.GONE);

        // ボディー部が表示している事を確認
        LinearLayout bodyLinear = customDialog.getBodyLinearLayout();
        assertTrue(bodyLinear.getVisibility() == View.VISIBLE);

        // ボタン部が表示していない事を確認
        LinearLayout buttonLinear = customDialog.getButtonLinearLayout();
        assertTrue(buttonLinear.getVisibility() == View.GONE);

        // メッセージの表示の確認と内容
        TextView messageTextView = customDialog.getMessage();
        assertTrue(messageTextView.getVisibility() == View.VISIBLE);
        assertEquals(this.mActivity.getString(R.string.custom_dialog_mess1), messageTextView.getText());

    }

    /**
     * ボタン２のメッセージとボタンの確認
     *
     * @param customDialog
     */
    public void dialog2Check(CustomDialog customDialog) {

        // タイトルが表示していない事を確認
        TextView textView = customDialog.getTitle();
        assertTrue(textView.getVisibility() == View.GONE);

        // ボディー部が表示している事を確認
        LinearLayout bodyLinear = customDialog.getBodyLinearLayout();
        assertTrue(bodyLinear.getVisibility() == View.VISIBLE);

        // ボタン部が表示している事を確認
        LinearLayout buttonLinear = customDialog.getButtonLinearLayout();
        assertTrue(buttonLinear.getVisibility() == View.VISIBLE);

        // YESボタンが表示していない事を確認
        Button yesButton = customDialog.getYesButton();
        assertTrue(yesButton.getVisibility() == View.GONE);

        // NOボタンが表示されている事を確認
        Button noButton = customDialog.getNoButton();
        assertTrue(noButton.getVisibility() == View.VISIBLE);
        assertEquals(noButton.getText(), this.mActivity.getString(R.string.custom_dialog_close_button));

        // メッセージの表示の確認と内容
        TextView messageTextView = customDialog.getMessage();
        assertTrue(messageTextView.getVisibility() == View.VISIBLE);
        assertEquals(this.mActivity.getString(R.string.custom_dialog_mess1), messageTextView.getText());

    }

    /**
     * ボタン３のメッセージとボタンの確認
     *
     * @param customDialog
     */
    public void dialog3Check(CustomDialog customDialog) {

        // タイトルが表示している事を確認
        TextView textView = customDialog.getTitle();
        assertTrue(textView.getVisibility() == View.VISIBLE);
        assertEquals(textView.getText(), this.mActivity.getString(R.string.custom_dialog_title));

        // ボディー部が表示している事を確認
        LinearLayout bodyLinear = customDialog.getBodyLinearLayout();
        assertTrue(bodyLinear.getVisibility() == View.VISIBLE);

        // ボタン部が表示している事を確認
        LinearLayout buttonLinear = customDialog.getButtonLinearLayout();
        assertTrue(buttonLinear.getVisibility() == View.VISIBLE);

        // YESボタンが表示していない事を確認
        Button yesButton = customDialog.getYesButton();
        assertTrue(yesButton.getVisibility() == View.VISIBLE);
        assertEquals(yesButton.getText(), this.mActivity.getString(R.string.custom_dialog_yes_button));

        // NOボタンが表示されている事を確認
        Button noButton = customDialog.getNoButton();
        assertTrue(noButton.getVisibility() == View.VISIBLE);
        assertEquals(noButton.getText(), this.mActivity.getString(R.string.custom_dialog_no_button));

        // メッセージの表示の確認と内容
        TextView messageTextView = customDialog.getMessage();
        assertTrue(messageTextView.getVisibility() == View.VISIBLE);
        assertEquals(this.mActivity.getString(R.string.custom_dialog_mess1), messageTextView.getText());

    }

    /**
     * ボタン４のメッセージとボタンの確認
     *
     * @param customDialog
     */
    public void dialog4Check(CustomDialog customDialog) {

        // タイトルが表示している事を確認
        TextView textView = customDialog.getTitle();
        assertTrue(textView.getVisibility() == View.VISIBLE);
        assertEquals(textView.getText(), this.mActivity.getString(R.string.custom_dialog_title));

        // ボディー部が表示している事を確認
        LinearLayout bodyLinear = customDialog.getBodyLinearLayout();
        assertTrue(bodyLinear.getVisibility() == View.VISIBLE);

        // ボタン部が表示している事を確認
        LinearLayout buttonLinear = customDialog.getButtonLinearLayout();
        assertTrue(buttonLinear.getVisibility() == View.VISIBLE);

        // YESボタンが表示していない事を確認
        Button yesButton = customDialog.getYesButton();
        assertTrue(yesButton.getVisibility() == View.VISIBLE);
        assertEquals(yesButton.getText(), this.mActivity.getString(R.string.custom_dialog_yes_button));

        // NOボタンが表示されている事を確認
        Button noButton = customDialog.getNoButton();
        assertTrue(noButton.getVisibility() == View.VISIBLE);
        assertEquals(noButton.getText(), this.mActivity.getString(R.string.custom_dialog_no_button));

        // メッセージが表示しない事を確認
        TextView messageTextView = customDialog.getMessage();
        assertTrue(messageTextView.getVisibility() == View.VISIBLE);
        assertEquals(this.mActivity.getString(R.string.custom_dialog_mess2), messageTextView.getText());

    }


    /**
     * ダイアログ１のチェックと確認
     */
    public void testDialog1のメッセージ表示_背景タップ() {

        // インスタンス取得
        Button button = (Button) this.mActivity.findViewById(R.id.main_button1);

        // 表示処理
        clickButton(button);

        // ダイアログのインスタンスを取得
        CustomDialog customDialog = this.mActivity.getCustomDialog();

        // チェック
        dialog1Check(customDialog);

        // 背景のタップ確認
        checkBackLayout(customDialog, button);

    }


    /**
     * ダイアログ１のチェックと確認
     */
    public void testDialog1のメッセージ表示_バックボタン() {

        // インスタンス取得
        Button button = (Button) this.mActivity.findViewById(R.id.main_button1);

        // 表示処理
        clickButton(button);

        // ダイアログのインスタンスを取得
        CustomDialog customDialog = this.mActivity.getCustomDialog();

        // チェック
        dialog1Check(customDialog);

        // バックボタンのチェック
        checkBackKey(button);

    }

    /**
     * ダイアログ2のチェックと確認
     */
    public void testDialog2のメッセージ表示_背景タップ() {

        // インスタンス取得
        Button button = (Button) this.mActivity.findViewById(R.id.main_button2);

        // 表示処理
        clickButton(button);

        // ダイアログのインスタンスを取得
        CustomDialog customDialog = this.mActivity.getCustomDialog();

        // チェック
        dialog2Check(customDialog);

        // バックボタンのチェック
        checkBackLayout(customDialog, button);

    }

    /**
     * ダイアログ2のチェックと確認
     */
    public void testDialog2のメッセージ表示_バックボタン() {

        // インスタンス取得
        Button button = (Button) this.mActivity.findViewById(R.id.main_button2);

        // 表示処理
        clickButton(button);

        // ダイアログのインスタンスを取得
        CustomDialog customDialog = this.mActivity.getCustomDialog();

        // チェック
        dialog2Check(customDialog);

        // バックボタンのチェック
        checkBackKey(button);

    }

    /**
     * ダイアログ2の閉じるボタンチェック
     */
    public void testDialog2のメッセージ表示_閉じるボタン() {

        // インスタンス取得
        Button button = (Button) this.mActivity.findViewById(R.id.main_button2);

        // 表示処理
        clickButton(button);

        // ダイアログのインスタンスを取得
        CustomDialog customDialog = this.mActivity.getCustomDialog();

        // チェック
        dialog2Check(customDialog);

        // 閉じるボタンのチェック
        Button dialogButton = customDialog.getNoButton();
        checkDialogButton(dialogButton, button);

    }

    /**
     * ダイアログ3のチェックと確認
     */
    public void testDialog3のメッセージ表示_背景タップ() {

        // インスタンス取得
        Button button = (Button) this.mActivity.findViewById(R.id.main_button3);

        // 表示処理
        clickButton(button);

        // ダイアログのインスタンスを取得
        CustomDialog customDialog = this.mActivity.getCustomDialog();

        // チェック
        dialog3Check(customDialog);

        // バックボタンのチェック
        checkBackLayout(customDialog, button);

    }

    /**
     * ダイアログ3のチェックと確認
     */
    public void testDialog3のメッセージ表示_バックボタン() {

        // インスタンス取得
        Button button = (Button) this.mActivity.findViewById(R.id.main_button3);

        // 表示処理
        clickButton(button);

        // ダイアログのインスタンスを取得
        CustomDialog customDialog = this.mActivity.getCustomDialog();

        // チェック
        dialog3Check(customDialog);

        // バックボタンのチェック
        checkBackKey(button);

    }

    /**
     * ダイアログ3のはいボタンチェック
     */
    public void testDialog3のメッセージ表示_はいボタン() {

        // インスタンス取得
        Button button = (Button) this.mActivity.findViewById(R.id.main_button3);

        // 表示処理
        clickButton(button);

        // ダイアログのインスタンスを取得
        CustomDialog customDialog = this.mActivity.getCustomDialog();

        // チェック
        dialog3Check(customDialog);

        // はいボタンのチェック
        Button dialogButton = customDialog.getYesButton();
        checkDialogButton(dialogButton, button);

    }

    /**
     * ダイアログ3のいいえボタンチェック
     */
    public void testDialog3のメッセージ表示_いいえボタン() {

        // インスタンス取得
        Button button = (Button) this.mActivity.findViewById(R.id.main_button3);

        // 表示処理
        clickButton(button);

        // ダイアログのインスタンスを取得
        CustomDialog customDialog = this.mActivity.getCustomDialog();

        // チェック
        dialog3Check(customDialog);

        // 閉じるボタンのチェック
        Button dialogButton = customDialog.getNoButton();
        checkDialogButton(dialogButton, button);

    }

    /**
     * ダイアログ４のチェックと確認
     */
    public void testDialog4のメッセージ表示_背景タップ() {

        // インスタンス取得
        Button button = (Button) this.mActivity.findViewById(R.id.main_button4);

        // 表示処理
        clickButton(button);

        // ダイアログのインスタンスを取得
        CustomDialog customDialog = this.mActivity.getCustomDialog();

        // チェック
        dialog4Check(customDialog);

        // バックボタンのチェック
        checkBackLayout(customDialog, button);

    }
    /**
     * ダイアログ４のチェックと確認
     */
    public void testDialog4のメッセージ表示_バックボタン() {

        // インスタンス取得
        Button button = (Button) this.mActivity.findViewById(R.id.main_button4);

        // 表示処理
        clickButton(button);

        // ダイアログのインスタンスを取得
        CustomDialog customDialog = this.mActivity.getCustomDialog();

        // チェック
        dialog4Check(customDialog);

        // バックボタンのチェック
        checkBackKey(button);

    }

    /**
     * ダイアログ4のはいボタンチェック
     */
    public void testDialog4のメッセージ表示_はいボタン() {

        // インスタンス取得
        Button button = (Button) this.mActivity.findViewById(R.id.main_button4);

        // 表示処理
        clickButton(button);

        // ダイアログのインスタンスを取得
        CustomDialog customDialog = this.mActivity.getCustomDialog();

        // チェック
        dialog4Check(customDialog);

        // インスタンス取得
        TextView textView = (TextView) this.mActivity.findViewById(R.id.main_textview);
        LinearLayout linearLayout = (LinearLayout)customDialog.getBodyLinearLayout().getChildAt(1);
        final EditText editText = (EditText)linearLayout.getChildAt(0);

        // テキストビューにフォーカスを移す
        this.mActivity.runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                editText.requestFocus();
            }
        });
        // フォーカスが移る処理を待つ
        getInstrumentation().waitForIdleSync();

        // キーイベントを起こす
        sendKeys(KeyEvent.KEYCODE_1);

        // キーイベントが終了するのを待つ。
        getInstrumentation().waitForIdleSync();

        // はいボタンのチェック
        Button dialogButton = customDialog.getYesButton();
        checkDialogButton(dialogButton, button);

        // ビューのチェック
        assertEquals(textView.getText().toString(), editText.getText().toString());

    }

    /**
     * ダイアログ4のいいえボタンチェック
     */
    public void testDialog4のメッセージ表示_いいえボタン() {

        // インスタンス取得
        final Button button = (Button) this.mActivity.findViewById(R.id.main_button4);

        // 表示処理
        clickButton(button);

        // ダイアログのインスタンスを取得
        CustomDialog customDialog = this.mActivity.getCustomDialog();

        // チェック
        dialog4Check(customDialog);

        // 閉じるボタンのチェック
        Button dialogButton = customDialog.getNoButton();
        checkDialogButton(dialogButton, button);

    }

}

