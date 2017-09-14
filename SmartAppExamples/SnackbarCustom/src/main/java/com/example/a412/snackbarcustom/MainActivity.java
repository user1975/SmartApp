package com.example.a412.snackbarcustom;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    private Snackbar snackbar;
    CustomSnackbar customSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View contentView = findViewById(android.R.id.content);

        customSnackbar = CustomSnackbar.make((ViewGroup) contentView, CustomSnackbar.LENGTH_INDEFINITE);


        findViewById(R.id.btnSnack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                final ViewGroup viewGroup = (ViewGroup) ((ViewGroup)MainActivity.this.findViewById(android.R.id.content)).getChildAt(0); //constraintLayout
//                CustomSnackbar customSnackbar = CustomSnackbar.make(viewGroup, CustomSnackbar.LENGTH_INDEFINITE);  //상단에 출력
                customSnackbar.setAction("종료", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // handle click here
                        // Now dismiss the Snackbar
                    }
                });

                customSnackbar.show();
            }
        });
    }

//    private static ViewGroup findSuitableParent(View view) {
//        ViewGroup fallback = null;
//        do {
//            if (view instanceof CoordinatorLayout) {
//                // We've found a CoordinatorLayout, use it
//                return (ViewGroup) view;
//            } else if (view instanceof FrameLayout) {
//                if (view.getId() == android.R.id.content) {
//                    // If we've hit the decor content view, then we didn't find a CoL in the hierarchy, so use it.
//                    return (ViewGroup) view;
//                } else {
//                    // It's not the content view but we'll use it as our fallback
//                    fallback = (ViewGroup) view;
//                }
//            }
//
//            if (view != null) {
//                // Else, we will loop and crawl up the view hierarchy and try to find a parent
//                final ViewParent parent = view.getParent();
//                view = parent instanceof View ? (View) parent : null;
//            }
//        } while (view != null);
//
//        // If we reach here then we didn't find a CoL or a suitable content view so we'll fallback
//        return fallback;
//    }
}
