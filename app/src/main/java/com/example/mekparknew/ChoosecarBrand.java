package com.example.mekparknew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentManager;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChoosecarBrand extends AppCompatActivity {

    private int Images[]={R.drawable.suzuki,R.drawable.herologo,R.drawable.tvs,R.drawable.bajaj,R.drawable.honda,R.drawable.suzuki,R.drawable.honda,R.drawable.bajaj,R.drawable.tvs,R.drawable.herologo};
    private String name[]={"Suzuki","Hero","Tvs","Bajaj","Honda","Suzuki,","Honda","Bajaj","Tvs","Hero"};

    private List<BrandItemModel> brandItemModellist =new ArrayList<>();


    GridView gridView;
    CustomAdapter customAdapter;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosecar_brand);
        searchView=findViewById(R.id.searchview1);

        //loop through and add to our list
        for(int i=0;i<name.length;i++){
            BrandItemModel brandItemModel=new BrandItemModel(Images[i],name[i]);
            brandItemModellist.add(brandItemModel);
        }

        gridView=findViewById(R.id.gridview);
        customAdapter=new CustomAdapter(brandItemModellist,this);
        gridView.setAdapter(customAdapter);

    searchView.setMaxWidth(Integer.MAX_VALUE);
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            Log.e("TAG","new Text ==>"+newText);

            customAdapter.getFilter().filter(newText);
            return true;
        }
    });
    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.menu,menu);
//        MenuItem menuItem=menu.findItem(R.id.searchview);
//        SearchView searchView= (SearchView) menuItem.getActionView();
//        searchView.setMaxWidth(Integer.MAX_VALUE);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                Log.e("TAG","new text ==>"+newText);
//                return true;
//            }
//        });
//        return true;
//    }


    public class CustomAdapter extends BaseAdapter implements Filterable {


        private List<BrandItemModel> brandItemModelList;
        private List<BrandItemModel> brandItemModelListFilter;
        private Context context;

        public CustomAdapter(List<BrandItemModel> brandItemModelList, Context context) {
            this.brandItemModelList=brandItemModelList;
            this.brandItemModelListFilter = brandItemModelList;
            this.context = context;
        }

        public CustomAdapter(List<BrandItemModel> brandItemModelList) {
            this.brandItemModelList = brandItemModelList;
        }

        @Override
        public int getCount() {
            return brandItemModelList.size();
        }

        @Override
        public Object getItem(int i) {
            return brandItemModelList;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1=view;
            final BrandItemModel brandItemModel=brandItemModelList.get(i);

            if(view1==null) {
                view1 = LayoutInflater.from(context).inflate(R.layout.row_car_item, viewGroup, false);
            }
            ImageView imageName=view1.findViewById(R.id.imageName);
            TextView tvname = view1.findViewById(R.id.tvname);

            String name=brandItemModel.getName();
            int image=brandItemModel.getImage();

            imageName.setImageResource(image);
            tvname.setText(name);


            view1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("Clicked Item","==>"+brandItemModel.getName());
                    startActivity(new Intent(ChoosecarBrand.this,carModel.class).putExtra("data",brandItemModel));
                }
            });
            return view1;
        }

        @Override
        public Filter getFilter() {
            Filter filter=new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence charSequence) {
                    FilterResults filterResults=new FilterResults();
                    if(charSequence==null || charSequence.length()==0){

                        filterResults.count=brandItemModelListFilter.size();
                        filterResults.values=brandItemModelListFilter;
                    }else {
                        String searcher=charSequence.toString().toLowerCase();
                        List<BrandItemModel> searchResult=new ArrayList<>();
                        for (BrandItemModel brandItemModel:brandItemModelListFilter){
                            if(brandItemModel.getName().toLowerCase().contains(searcher)){
                                searchResult.add(brandItemModel);
                            }
                        }
                        filterResults.count=searchResult.size();
                        filterResults.values=searchResult;
                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                    brandItemModelList= (List<BrandItemModel>) filterResults.values;
                    notifyDataSetChanged();
                }
            };

            return filter;
        }
    }
}
