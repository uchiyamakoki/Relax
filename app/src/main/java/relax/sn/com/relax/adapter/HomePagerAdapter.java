package relax.sn.com.relax.adapter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 2018/3/18.
 */
public class HomePagerAdapter extends FragmentPagerAdapter{

    private List<Fragment> fragments=new ArrayList<>();
    private List<String> titles=new ArrayList<>();
    /*
    初始的构造方法
     */
    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public HomePagerAdapter(FragmentManager fm, TabLayout tabLayout) {
        super(fm);
    }

    public void addTab(Fragment fragment,String title){
        fragments.add(fragment);
        titles.add(title);
    }

    /**
     * Return the Fragment associated with a specified position.
     */
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }
    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return fragments.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
