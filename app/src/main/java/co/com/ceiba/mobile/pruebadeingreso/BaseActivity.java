package co.com.ceiba.mobile.pruebadeingreso;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import co.com.ceiba.mobile.pruebadeingreso.di.component.AppComponent;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract String getActivityName();

    private Toast mToast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector(getAppComponent());
    }

    protected void showToastMsg(@StringRes int msg) {

        if (mToast != null) {
            mToast.cancel();
        }

        mToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        mToast.show();
    }

    protected void showToastExpectionMsg(String msg) {

        if (mToast != null) {
            mToast.cancel();
        }

        mToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        mToast.show();
    }

    protected AppComponent getAppComponent() {
        return ((App) getApplication()).getApplicationComponent();
    }

    protected abstract void initializeInjector(AppComponent applicationComponent);

    protected void showToolbar(Toolbar toolbar, String tittle, boolean upButton) {
        this.setSupportActionBar(toolbar);
        setToolbarTitle(toolbar, tittle);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    protected void showToolbar(Toolbar toolbar, @StringRes int tittle, boolean upButton) {
        this.setSupportActionBar(toolbar);
        setToolbarTitle(toolbar, getString(tittle));
        //this.getSupportActionBar().setTitle(tittle);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    protected void setToolbarTitle(Toolbar toolbar, String tittle) {
        TextView title = ButterKnife.findById(toolbar, R.id.toolbar_title);
        title.setText(tittle);
    }
}
