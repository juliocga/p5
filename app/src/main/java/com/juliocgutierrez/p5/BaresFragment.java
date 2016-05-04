
package com.juliocgutierrez.p5;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BaresFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public BaresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bares, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs3);
        viewPager = (ViewPager) view.findViewById(R.id.pager3);
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        tabLayout.post(new Runnable() {

            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return view;
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: return new SexyFragment();
                case 1: return new SanFragment();
                case 2: return new CuFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "MILLENIUM";
                case 1:
                    return "PIPATON";
                case 2:
                    return "LA CIUDAD";
            }
            return null;
        }
    }

}
