package org.wikipedia.overhaul;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.wikipedia.R;
import org.wikipedia.history.HistoryEntry;
import org.wikipedia.history.HistoryFragment;
import org.wikipedia.nearby.NearbyFragment;
import org.wikipedia.overhaul.navtab.NavViewPagerAdapter;
import org.wikipedia.page.PageTitle;
import org.wikipedia.readinglist.ReadingListsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class OverhaulFragment extends Fragment implements NearbyFragment.Callback,
        HistoryFragment.Callback, ReadingListsFragment.Callback {
    @BindView(R.id.fragment_overhaul_view_pager) ViewPager viewPager;
    private Unbinder unbinder;

    public static OverhaulFragment newInstance() {
        return new OverhaulFragment();
    }

    @Nullable @Override public View onCreateView(LayoutInflater inflater,
                                                 @Nullable ViewGroup container,
                                                 @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_overhaul, container, false);
        unbinder = ButterKnife.bind(this, view);
        viewPager.setAdapter(new NavViewPagerAdapter(getFragmentManager()));

        return view;
    }

    @Override public void onDestroyView() {
        unbinder.unbind();
        unbinder = null;
        super.onDestroyView();
    }

    @Override public void onLoading() {
        // todo: [overhaul] update loading indicator.
    }

    @Override public void onLoaded() {
        // todo: [overhaul] update loading indicator.
    }

    @Override public void onLoadPage(PageTitle title, int entrySource, @Nullable Location location) {
        // todo: [overhaul] show link preview.
    }

    @Override public void onLoadPage(PageTitle title, HistoryEntry entry) {
        // todo: [overhaul] show link preview.
    }

    @Override public void onClearHistory() {
        // todo: [overhaul] clear history.
    }
}