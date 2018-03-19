package relax.sn.com.relax.view.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * Created by John on 2018/3/18.
 */
public abstract class BaseFragment extends RxFragment{
    protected boolean mIsCreateView=false;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser){
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&mIsCreateView){
            lazyLoad();
        }
    }
    /**
     * 加载数据操作,在视图创建之前初始化
     */
    protected abstract void lazyLoad();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getUserVisibleHint()) {
            lazyLoad();
        }
    }

}
