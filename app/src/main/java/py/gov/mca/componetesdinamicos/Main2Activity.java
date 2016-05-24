package py.gov.mca.componetesdinamicos;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<String> nombreArrayList = new ArrayList<String>();
// Añade el elemento al ArrayList
        nombreArrayList.add("Elemento");
// Añade el elemento al ArrayList en la posición 'n'
        nombreArrayList.add("Elemento 2");
        addChild(nombreArrayList);


    }

    public void addChild(ArrayList<String> arrayListTipoActividad) {
        LayoutInflater inflater = LayoutInflater.from(this);
        int id = R.layout.activity_main2;
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(id, null, false);
        //recorrer el arrayList e ir mostrando los resultados en el TextView
        for (int i = 0; i < arrayListTipoActividad.size(); i++) {
            Log.d("String: ", i + arrayListTipoActividad.get(i));
            LinearLayout linearLayoutHori = new LinearLayout(this);
            linearLayoutHori.setOrientation(LinearLayout.HORIZONTAL);
            TextView textView = new TextView(this);
            textView.setText(arrayListTipoActividad.get(i));
            EditText editText = new EditText(this);

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(
                    this, android.R.layout.simple_list_item_1, arrayListTipoActividad);
            dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            Spinner spinner = new Spinner(dataAdapter.getContext());

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.RIGHT;
            params.topMargin = 15;
            editText.setPadding(5, 3, 5, 3);
            editText.setLayoutParams(params);
            editText.setHint(arrayListTipoActividad.get(i));

            linearLayoutHori.addView(textView);
            linearLayoutHori.addView(editText);
            linearLayoutHori.addView(spinner);

            linearLayout.addView(linearLayoutHori);

        }
        setContentView(linearLayout);

    }
}
