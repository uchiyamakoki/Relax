package relax.sn.com.relax.view.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;
import relax.sn.com.relax.R;
import relax.sn.com.relax.adapter.HomePagerAdapter;
import relax.sn.com.relax.view.activity.base.BaseActivity;
import relax.sn.com.relax.view.fragment.MainFragment;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    private MainFragment mMainFragment,mMainFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initDrawer();

    }

    private void initDrawer() {
            if(mNavView!=null){
                mNavView.setNavigationItemSelectedListener(this);
                mNavView.inflateHeaderView(R.layout.nav_header_main);
                ActionBarDrawerToggle toggle =
                        new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open,
                                R.string.navigation_drawer_close);
                mDrawerLayout.addDrawerListener(toggle);
                toggle.syncState();
            }
    }

    /*
    布局id传值
     */
    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    /**
     * 初始化基础View
     */
    private void initView() {
        setSupportActionBar(mToolbar);
        HomePagerAdapter mAdapter=new HomePagerAdapter(getSupportFragmentManager());
        mMainFragment=new MainFragment();
        mMainFragment2=new MainFragment();
        mAdapter.addTab(mMainFragment,"主页面");
        mAdapter.addTab(mMainFragment2,"时间胶囊");
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager,false);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
