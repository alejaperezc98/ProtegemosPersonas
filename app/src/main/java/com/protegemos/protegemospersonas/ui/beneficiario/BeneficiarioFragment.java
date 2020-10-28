package com.protegemos.protegemospersonas.ui.beneficiario;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.protegemos.protegemospersonas.BeneficiarioService;
import com.protegemos.protegemospersonas.R;
import com.protegemos.protegemospersonas.data.entities.BeneficiariosEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;

public class BeneficiarioFragment extends Fragment {

    private BeneficiarioViewModel beneficiarioViewModel;
    private SharedPreferences preferences;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        beneficiarioViewModel =
                new ViewModelProvider(this).get(BeneficiarioViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        beneficiarioViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    private void consultaBeneficiarios(){

        SharedPreferences prefs = getSharedPreferences("user",MODE_PRIVATE);
        String restoredText = prefs.getString("user", null);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://181.62.161.60/kubica/app/beneficiarios.php")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BeneficiarioService beneficiarioService = retrofit.create(BeneficiarioService.class);
        Call<List<BeneficiariosEntity>> call = beneficiarioService.getBeneficiario("46712");
        call.enqueue(new Callback<List<BeneficiariosEntity>() {
            @Override
            public void onFailure(Call<List<BeneficiariosEntity>> call, Throwable t) {
            }
        });
    }

    public String getSharedPreferences(Context context, String prefKey) {
        SharedPreferences sharedPreferences = PreferenceManager .getDefaultSharedPreferences(context);
        return sharedPreferences.getString(prefKey, ""); }
}