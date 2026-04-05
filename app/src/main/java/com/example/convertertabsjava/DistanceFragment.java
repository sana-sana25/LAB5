package com.example.convertertabsjava;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;

import androidx.fragment.app.Fragment;

public class DistanceFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_distance, container, false);

        EditText input = v.findViewById(R.id.etDistInput);
        TextView result = v.findViewById(R.id.tvDistResult);
        RadioButton km = v.findViewById(R.id.rbKmToMiles);
        Button btn = v.findViewById(R.id.btnConvertDist);

        btn.setOnClickListener(view -> {

            if (TextUtils.isEmpty(input.getText())) {
                Toast.makeText(getContext(), "Entrer une valeur", Toast.LENGTH_SHORT).show();
                return;
            }

            double val = Double.parseDouble(input.getText().toString());
            double res;

            if (km.isChecked())
                res = val * 0.6214;
            else
                res = val / 0.6214;

            result.setText("Résultat : " + String.format("%.2f", res));
        });

        return v;
    }
}