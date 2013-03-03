package com.example.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.view.View.OnClickListener;

/**
 * カスタムダイアログ
 */
public class CustomDialog extends Dialog implements OnClickListener {

    /**
     * 背景のレイアウト
     */
    private FrameLayout mBackFrameLayout = null;
    /**
     * タイトルビュー
     */
    private TextView mTitleTextView = null;
    private String mTitle = null;
    /**
     * テキストビュー
     */
    private TextView mMessTextView = null;
    private String mMessage = null;
    /**
     * ボディーライナーレイアウト
     */
    private LinearLayout mBodyLinearLayout = null;
    private View mView = null;
    /**
     * ボタンライナーレイアウト
     */
    private LinearLayout mButtonLinearLayout = null;
     /**
     * ボタンビュー
     */
    private Button mYesButton = null;
    private Button mNoButton = null;
    private String mYesText = null;
    private String mNoText = null;
    /**
     * ボタンリスナー
     */
    private ClickButtonListener mYesClickButtonListener = null;
    private ClickButtonListener mNoClickButtonListener = null;


    /**
     * コンストラクタ
     *
     * @param context
     */
    public CustomDialog(Context context) {
        super(context, R.style.Theme_CustomDialog);

    }

    /**
     * タイトルをセット
     *
     * @param title
     * @return
     */
    public CustomDialog setTitle(String title) {
        this.mTitle = title;
        return this;

    }

    /**
     * メッセージをセット
     *
     * @param mess
     * @return
     */
    public CustomDialog setMessage(String mess) {
        this.mMessage = mess;
        return this;

    }

    /**
     * YESクリックリスナーのセット
     *
     * @param clickButtonListener
     * @return
     */
    public CustomDialog setYesClickButtonListener(String buttonText, ClickButtonListener clickButtonListener) {
        this.mYesClickButtonListener = clickButtonListener;
        this.mYesText = buttonText;
        return this;

    }

    /**
     * Noクリックリスナーのセット
     *
     * @param clickButtonListener
     * @return
     */
    public CustomDialog setNoClickButtonListener(String buttonText, ClickButtonListener clickButtonListener) {
        this.mNoClickButtonListener = clickButtonListener;
        this.mNoText = buttonText;
        return this;

    }

    /**
     * スクロールビューにセット
     *
     * @param v
     * @return
     */
    public CustomDialog setView(View v) {
        this.mView = v;
        return this;

    }

    /**
     * 画面作成処理
     *
     * @param bundle
     */
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        // レイアウトを決定
        setContentView(R.layout.custom_dialog_laytout);

        // 背景ビューの取得
        mBackFrameLayout = (FrameLayout) findViewById(R.id.custom_dialog_background);
        mBackFrameLayout.setOnClickListener(this);

        // タイトルビューを取得
        this.mTitleTextView = (TextView) findViewById(R.id.custom_dialog_title);
        this.mTitleTextView.setText(this.mTitle);
        this.mTitleTextView.setVisibility(this.mTitle != null ? View.VISIBLE : View.GONE);

        // テキストビューを取得
        this.mMessTextView = (TextView) findViewById(R.id.custom_dialog_message);
        this.mMessTextView.setText(this.mMessage);
        this.mMessTextView.setVisibility(this.mMessage != null ? View.VISIBLE : View.GONE);

        // ボディーライナーレイアウトを取得
        this.mBodyLinearLayout = (LinearLayout) findViewById(R.id.custom_dialog_body_linearlayout);
        if (this.mView != null) this.mBodyLinearLayout.addView(this.mView);

        // YESボタンビューを取得
        this.mYesButton = (Button) findViewById(R.id.custom_dialog_yes);
        this.mYesButton.setOnClickListener(this);
        this.mYesButton.setText(this.mYesText);
        this.mYesButton.setVisibility(this.mYesText != null ? View.VISIBLE : View.GONE);

        // NOボタンビューを取得
        this.mNoButton = (Button) findViewById(R.id.custom_dialog_no);
        this.mNoButton.setOnClickListener(this);
        this.mNoButton.setText(this.mNoText);
        this.mNoButton.setVisibility(this.mNoText != null ? View.VISIBLE : View.GONE);

        // ボタンのセパレータの取得
        View view = (View) findViewById(R.id.custom_dialog_button_side_divider);
        view.setVisibility(this.mYesText != null && this.mNoText != null ? View.VISIBLE : View.GONE);

        // ボタンのレイアウト取得
        mButtonLinearLayout = (LinearLayout) findViewById(R.id.custom_dialog_button_linearlayout);
        mButtonLinearLayout.setVisibility(this.mYesText != null || this.mNoText != null ? View.VISIBLE : View.GONE);

    }

    /**
     * 終了処理
     */
    @Override
    protected void onStop() {
        super.onStop();
        dismiss();

    }

    /**
     * ボタンクリックイベント
     *
     * @param v
     */
    @Override
    public void onClick(View v) {

        // ボタンイベント
        switch (v.getId()) {
            case R.id.custom_dialog_yes:
                if (this.mYesClickButtonListener != null) this.mYesClickButtonListener.onClickButton(this.mYesButton);
                break;

            case R.id.custom_dialog_no:
                if (this.mNoClickButtonListener != null) this.mNoClickButtonListener.onClickButton(this.mNoButton);
                break;

            default:
                break;

        }

        dismiss();

    }

    /**
     * ボタンクリックのリスナー
     */
    public interface ClickButtonListener {

        // クリックイベント
        void onClickButton(Button button);

    }

    /**
     * 背景ビューを返却
     * @return FrameLayout
     */
    public FrameLayout getBackFrameLayout(){
        return this.mBackFrameLayout;

    }

    /**
     * タイトルビューを返却
     * @return TextView
     */
    public TextView getTitle(){
        return this.mTitleTextView;

    }

    /**
     * メッセージビューを返却
     * @return TextView
     */
    public TextView getMessage(){
        return this.mMessTextView;

    }

    /**
     * ボディーを返却
     * @return LinearLayout
     */
    public LinearLayout getBodyLinearLayout(){
        return this.mBodyLinearLayout;

    }

    /**
     * ボタン部のレイアウトを返却
     * @return LinearLayout
     */
    public LinearLayout getButtonLinearLayout(){
        return this.mButtonLinearLayout;

    }

    /**
     * YESボタンを返却
     * @return Button
     */
    public Button getYesButton(){
        return this.mYesButton;

    }

    /**
     * NOボタンを返却
     * @return Button
     */
    public Button getNoButton(){
        return this.mNoButton;

    }

}
