package com.example.convertertabsjava;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;

import androidx.fragment.app.Fragment;

public class TempFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_temp, container, false);

        EditText input = v.findViewById(R.id.etTempInput);
        TextView result = v.findViewById(R.id.tvTempResult);
        RadioButton ctof = v.findViewById(R.id.rbCtoF);
        Button btn = v.findViewById(R.id.btnConvertTemp);

        btn.setOnClickListener(view -> {

            if (TextUtils.isEmpty(input.getText())) {
                Toast.makeText(getContext(), "Entrer une valeur", Toast.LENGTH_SHORT).show();
                return;
            }

            double val = Double.parseDouble(input.getText().toString());
            double res;

            if (ctof.isChecked())
                res = (1.8 * val) + 32;
            else
                res = (val - 32) / 1.8;

            result.setText("Résultat : " + String.format("%.2f", res));
        });

        return v;
    }
}