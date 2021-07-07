package com.example.collegenews;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class FacultyActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FacultyAdapter facultyAdapter;
    private Context context;
    private CseFacultyFragment cseFacultyFragment;
    private EceFacultyFragment eceFacultyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>=21)
        {
            Window window=this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorAccent));
        }
        setContentView(R.layout.activity_faculty);
        ViewPager viewPager=findViewById(R.id.faculty_viewpager);
        TabLayout tabLayout=findViewById(R.id.tab_layout);
        cseFacultyFragment=new CseFacultyFragment();
        eceFacultyFragment=new EceFacultyFragment();

        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(cseFacultyFragment,"CSE");
        viewPagerAdapter.addFragments(eceFacultyFragment,"ECE");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);



//        recyclerView=findViewById(R.id.faculty_recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(FacultyActivity.this));
//        recyclerView.setHasFixedSize(true);
//
//        ArrayList<FacultyInfo> newInfo=new ArrayList<>();
//
//        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("Faculty").child("CSE");
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                newInfo.clear();
//                for (DataSnapshot snapshot : dataSnapshot.getChildren())
//                {
//                    String snapEmail=snapshot.child("Email").getValue().toString();
//                    String snapName=snapshot.child("Name").getValue().toString();
//                    String snapImage=snapshot.child("Image").getValue().toString();
//                    FacultyInfo data=new FacultyInfo(snapName,snapEmail,snapImage);
//                    newInfo.add(data);
//                }
//                facultyAdapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//        facultyAdapter =new FacultyAdapter(context,newInfo);
//        recyclerView.setAdapter(facultyAdapter);

    }

    public static  class ViewPagerAdapter extends FragmentPagerAdapter{
        private ArrayList<Fragment> fragments;
        private ArrayList<String> titles;

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
            this.fragments=new ArrayList<>();
            this.titles=new ArrayList<>();
        }

        void  addFragments(Fragment fragment,String title)
        {
            fragments.add(fragment);
            titles.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

}