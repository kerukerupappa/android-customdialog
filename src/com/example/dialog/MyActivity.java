package com.example.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * ダイアログを表示するアクティビティ
 */
public class MyActivity extends Activity implements View.OnClickListener {


    private CustomDialog mCustomDialog = null;

    /**
     * クリエイト処理
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // ボタン1
        Button button1 = (Button) findViewById(R.id.main_button1);
        button1.setOnClickListener(this);

        // ボタン2
        Button button2 = (Button) findViewById(R.id.main_button2);
        button2.setOnClickListener(this);

        // ボタン3
        Button button3 = (Button) findViewById(R.id.main_button3);
        button3.setOnClickListener(this);

        // ボタン3
        Button button4 = (Button) findViewById(R.id.main_button4);
        button4.setOnClickListener(this);
    }


    public CustomDialog getCustomDialog(){
        return this.mCustomDialog;
    }


    /**
     * クリックイベント
     * @param v
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.main_button1:
                createDialog1();
                break;

            case R.id.main_button2:
                createDialog2();
                break;

            case R.id.main_button3:
                createDialog3();
                break;

            case R.id.main_button4:
                createDialog4();
                break;

            default:
                break;

        }

    }

    /**
     * メッセージだけ
     */
    private void createDialog1(){


        // ダイアログインスタンス作成
        this.mCustomDialog = new CustomDialog(this).setMessage(getString(R.string.custom_dialog_mess1));

        // ダイアログを表示
        this.mCustomDialog.show();

    }

    /**
     * ボタン1個
     */
    private void createDialog2(){


        // ダイアログインスタンス作成
        this.mCustomDialog = new CustomDialog(this).setMessage(getString(R.string.custom_dialog_mess1));

        // No時のボタン設定
        this.mCustomDialog.setNoClickButtonListener(getString(R.string.custom_dialog_close_button),null);

        // ダイアログを表示
        this.mCustomDialog.show();

    }

    /**
     * 標準ダイアログ
     */
    private void createDialog3(){

        // ダイアログインスタンス作成
        this.mCustomDialog = new CustomDialog(this).setTitle(getString(R.string.custom_dialog_title)).setMessage(getString(R.string.custom_dialog_mess1));

        // YES時のボタン設定
        this.mCustomDialog.setYesClickButtonListener(getString(R.string.custom_dialog_yes_button),null);

        // NO時のボタン設定
        this.mCustomDialog.setNoClickButtonListener(getString(R.string.custom_dialog_no_button),null);

        // ダイアログを表示
        this.mCustomDialog.show();

    }

    /**
     * カスタムボディをセット
     */
    private void createDialog4(){

        // ダイアログインスタンス作成
        this.mCustomDialog = new CustomDialog(this).setTitle(getString(R.string.custom_dialog_title)).setMessage(getString(R.string.custom_dialog_mess2));

        // ボディを作成
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.custom_dialog_body, null);
        final EditText editText = (EditText)view.findViewById(R.id.dialog_body_edittext);

        // ボディをセット
        this.mCustomDialog.setView(view);

        // YES時のボタン設定
        this.mCustomDialog.setYesClickButtonListener(getString(R.string.custom_dialog_yes_button),new CustomDialog.ClickButtonListener() {

            @Override
            public void onClickButton(Button button) {

                // テキストの表示
                TextView textView = (TextView) findViewById(R.id.main_textview);
                textView.setText(editText.getText());

            }
        });

        // NO時のボタン設定
        this.mCustomDialog.setNoClickButtonListener(getString(R.string.custom_dialog_no_button),new CustomDialog.ClickButtonListener() {

            @Override
            public void onClickButton(Button button) {

                // 何もしない

            }
        });

        // ダイアログを表示
        this.mCustomDialog.show();

    }

}
