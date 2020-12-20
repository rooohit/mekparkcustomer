package com.example.mekparknew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class carModel extends AppCompatActivity {

    private int[] images1={R.drawable.car1,R.drawable.car2,R.drawable.car3,R.drawable.ca4,R.drawable.ca5,R.drawable.car6,R.drawable.car7,R.drawable.car8,R.drawable.car9,R.drawable.car10,R.drawable.car11,R.drawable.car12};
    private String[] name1={"Alto","Alto800","AltoK10","A-Star","Baleno","Celerio","Ciaz","Eeco","Ertiga","Gypsy","Kizashi","800"};

    private BrandItemModel brandItemModel;
    ImageView imageView;

private List<carItemModel> carItemModelList=new ArrayList<>();
    GridView gridView;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_model);
        imageView=findViewById(R.id.imageviewclicked);

        //loop to add item to our list
        for(int i=0;i<name1.length;i++){
            carItemModel carItemModel=new carItemModel(images1[i],name1[i]);
            carItemModelList.add(carItemModel);
        }

        gridView=findViewById(R.id.gridviewmodel);
        customAdapter=new CustomAdapter(carItemModelList,this);
        gridView.setAdapter(customAdapter);


        Intent intent=getIntent();
        if(intent.getExtras()!=null){
            brandItemModel= (BrandItemModel) intent.getSerializableExtra("data");

            int image=brandItemModel.getImage();

            imageView.setImageResource(image);

          //  Log.e("PASSED","===>"+brandItemModel.getName());
        }
    }

    public class CustomAdapter extends BaseAdapter{
        private List<carItemModel> carItemModelList;
        private Context context;

        public CustomAdapter(List<carItemModel> carItemModelList, Context context) {
            this.carItemModelList = carItemModelList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return carItemModelList.size();
        }

        @Override
        public Object getItem(int i) {
            return carItemModelList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2=view;

            final carItemModel carItemModel=carItemModelList.get(i);
            if (view2==null) {
                view2 = LayoutInflater.from(context).inflate(R.layout.row_model_item, viewGroup, false);
            }
            ImageView imageName1= view2.findViewById(R.id.imageNamemodel);
            TextView textView1=view2.findViewById(R.id.tvnamemodel);

            String name1= carItemModel.getName();
            int image1=carItemModel.getImage();

            imageName1.setImageResource(image1);
            textView1.setText(name1);

            view2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("Clicked Item","==>"+carItemModel.getName());


                }
            });
            return view2;
        }
    }
}
