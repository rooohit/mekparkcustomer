package com.example.mekparknew;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class vehicleDetail extends Fragment {

    BrandItemModel brandItemModel;

CardView c1,c2,c3,c4;
    public vehicleDetail() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_vehicle_detail, container, false);

        TextView textView=view.findViewById(R.id.carbrand1);
        TextView textView1=view.findViewById(R.id.carmodel);

        Button button=view.findViewById(R.id.proceed);

        final Button car=view.findViewById(R.id.carbutton);
        final Button bike=view.findViewById(R.id.bikebutton);
        c1=view.findViewById(R.id.petrol);
        c2=view.findViewById(R.id.diesle);
        c3=view.findViewById(R.id.cng);
        c4=view.findViewById(R.id.gas);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c1.setBackground(getResources().getDrawable(R.drawable.outlined_button));
                c2.setBackground(getResources().getDrawable(R.drawable.outlined_button1));
                c3.setBackground(getResources().getDrawable(R.drawable.outlined_button1));
                c4.setBackground(getResources().getDrawable(R.drawable.outlined_button1));
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c1.setBackground(getResources().getDrawable(R.drawable.outlined_button1));
                c2.setBackground(getResources().getDrawable(R.drawable.outlined_button));
                c3.setBackground(getResources().getDrawable(R.drawable.outlined_button1));
                c4.setBackground(getResources().getDrawable(R.drawable.outlined_button1));
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c3.setBackground(getResources().getDrawable(R.drawable.outlined_button));
                c1.setBackground(getResources().getDrawable(R.drawable.outlined_button1));
                c2.setBackground(getResources().getDrawable(R.drawable.outlined_button1));
                c4.setBackground(getResources().getDrawable(R.drawable.outlined_button1));
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c4.setBackground(getResources().getDrawable(R.drawable.outlined_button));

                c1.setBackground(getResources().getDrawable(R.drawable.outlined_button));
                c2.setBackground(getResources().getDrawable(R.drawable.outlined_button1));
                c3.setBackground(getResources().getDrawable(R.drawable.outlined_button1));

            }
        });

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                car.setBackground(getResources().getDrawable(R.drawable.background_button1));
                car.setTextColor(getResources().getColor(R.color.white));
                bike.setBackground(getResources().getDrawable(R.drawable.white_background));
                bike.setTextColor(getResources().getColor(R.color.black));
            }
        });
        bike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bike.setBackground(getResources().getDrawable(R.drawable.background_button1));
                bike.setTextColor(getResources().getColor(R.color.white));

                car.setBackground(getResources().getDrawable(R.drawable.white_background));
                car.setTextColor(getResources().getColor(R.color.black));

            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),ChoosecarBrand.class));
                 }
        });

        textView1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),carModel.class));
            }
        });
        return view;

    }
}
