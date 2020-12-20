package loginsignup;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import loginsignup.FragmentPhone;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.mekparknew.MainActivity;
import com.example.mekparknew.R;


public class Fragmentlogin extends Fragment {

    private final String TAG = "FragmentLogin";
    private MainActivity activity;
    public Fragmentlogin(){

    }

    Button b1;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity=(MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG,"onCreateView");
        View view=inflater.inflate(R.layout.fragment_login,container,false);

        Button b1=(Button) view.findViewById(R.id.buttonlogin);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment=new FragmentPhone();
                FragmentManager fm=getActivity().getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.fragment_container,fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });


//
//        CheckBox checkBox= (CheckBox) view.findViewById(R.id.checkboxvisible);
//        final LinearLayout linearLayout=(LinearLayout) view.findViewById(R.id.linearcheck);
//        boolean isChecked=checkBox.isChecked();
//        if(isChecked){
//            linearLayout.setVisibility(View.VISIBLE);
//        }else {
//            linearLayout.setVisibility(View.GONE);
//        }
//        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//
//                if(isChecked){
//                    linearLayout.setVisibility(View.VISIBLE);
//                }else {
//                    linearLayout.setVisibility(View.GONE);
//                }
//            }
//        });


        return view;
    }




}
