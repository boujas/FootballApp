package com.test.footballapp.ui;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.test.footballapp.R;
import com.test.footballapp.ui.base.BaseActivity;
import com.test.footballapp.ui.fragment.LeaguesFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.container)
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getFragmentManager().beginTransaction()
                .replace(R.id.container, new LeaguesFragment())
                .commit();

    }

}