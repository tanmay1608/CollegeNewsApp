package com.example.collegenews;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class ClubsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ClubsAdapter clubsAdapter;
    ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);

        recyclerView=findViewById(R.id.clubs_viewpager);


        String[] clubsNames={"Algorithms","ARC","Artive","Capture","Fit India","DSC","Incognito","Odyssey","Codechef"};
      //  int[] img={R.drawable.algo,R.drawable.arc,R.drawable.art_and,R.drawable.capture,R.drawable.fit_india,R.drawable.download,R.drawable.incognito,R.drawable.od,R.drawable.codechef};


        recyclerView.setLayoutManager(new LinearLayoutManager(ClubsActivity.this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setHasFixedSize(true);
       // clubsAdapter=new ClubsAdapter(ClubsActivity.this,img);
        recyclerView.setAdapter(clubsAdapter);
        //  viewPager.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        //viewPager.setAdapter(clubsAdapter);
//        viewPager.setClipToPadding(false);
        // viewPager.setAdapter(new ClubsAdapter(list,viewPager) );
//        viewPager.setClipChildren(false);
//        viewPager.setOffscreenPageLimit(3);
//        viewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
//
//        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
//        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
//        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
//            @Override
//            public void transformPage(@NonNull View page, float position) {
//                float r=1-Math.abs(position);
//                page.setScaleY(0.85f+r*0.15f);
//            }
//        });
//        viewPager.setPageTransformer(compositePageTransformer);


    }
}