package com.example.a412.snackbarcustom;

import android.support.annotation.NonNull;
import android.support.design.widget.BaseTransientBottomBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by User on 2017-09-06.
 */

public class CustomSnackbar extends BaseTransientBottomBar<CustomSnackbar> {  //스낵바의 상위 클래스인 BaseTransientBottomBar를 이용해 스낵바 커스터마이징(design support)


    protected CustomSnackbar(@NonNull ViewGroup parent, @NonNull View content, @NonNull ContentViewCallback contentViewCallback) { //ContentViewCallback: TransientBottomBar의 main content의 behavior(animation) 정의하는 인터페이스
        super(parent, content, contentViewCallback);
    }

    public static CustomSnackbar make(ViewGroup parent, int duration) {
        // inflate custom layout
        LayoutInflater inflater = LayoutInflater.from(parent.getContext()); //from(): getSystemService를 호출해 LayoutInflater 생성
        View view = inflater.inflate(R.layout.custom_snackbar, parent, false);

        // create with custom view
        ContentViewCallback callback= new ContentViewCallback(view);
        CustomSnackbar customSnackbar = new CustomSnackbar(parent, view, callback); //스낵바를 (애니메이션이 정의된) ContentViewCallback 객체로 생성

        customSnackbar.setDuration(duration);

        return customSnackbar;
    }

    // set action in custom layout
    public CustomSnackbar setAction(CharSequence text, final View.OnClickListener listener) { //setAction 정의
        Button actionView = (Button) getView().findViewById(R.id.snackbar_action);
        actionView.setText(text);
        actionView.setVisibility(View.VISIBLE);
        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(view);
                // Now dismiss the Snackbar
                dismiss();
            }
        });
        return this;
    }

    private static class ContentViewCallback implements BaseTransientBottomBar.ContentViewCallback {

        // view inflated from custom layout
        private View view;

        public ContentViewCallback(View view) {
            this.view = view;
        }

        @Override
        public void animateContentIn(int delay, int duration) {
            // TODO: handle enter animation
        }

        @Override
        public void animateContentOut(int delay, int duration) {
            // TODO: handle exit animation
        }
    }

}