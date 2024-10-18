package com.example.grados;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import nav.celsius;
import nav.fahrenheit;
import nav.kelvin;

public class MainActivity extends AppCompatActivity {
    private EditText degreeInput;
    private RadioGroup radioGroup;
    private RadioButton radioFahren, radioCels, radioKelv;
    private Button convertButton;
    private TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Inicializar los componentes de la interfaz
        degreeInput = findViewById(R.id.degreeInput);
        radioGroup = findViewById(R.id.radioGroup);
        radioFahren = findViewById(R.id.radiofahren);
        radioCels = findViewById(R.id.radiocels);
        radioKelv = findViewById(R.id.radiokelv);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);
        // Configurar el botón de conversión
        convertButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String inputText = degreeInput.getText().toString();

                if (inputText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Ingresa un valor válido", Toast.LENGTH_SHORT).show();
                    return;
                }

                Double inputValue = Double.parseDouble(inputText);

                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == radioFahren.getId()) {
                    // Convertir desde Fahrenheit
                    fahrenheit fahrenheitValue = new fahrenheit(inputValue);
                    fahrenheit celsiusResult = fahrenheitValue.parse(new celsius(inputValue));
                    fahrenheit kelvinResult = fahrenheitValue.parse(new kelvin(inputValue));
                    resultText.setText("Celsius: " + celsiusResult.getValor() + "\nKelvin: " + kelvinResult.getValor());

                } else if (selectedId == radioCels.getId()) {
                    // Convertir desde Celsius
                    celsius celsiusValue = new celsius(inputValue);
                    celsius fahrenheitResult = celsiusValue.parse(new fahrenheit(inputValue));
                    celsius kelvinResult = celsiusValue.parse(new kelvin(inputValue));
                    resultText.setText("Fahrenheit: " + fahrenheitResult.getValor() + "\nKelvin: " + kelvinResult.getValor());

                } else if (selectedId == radioKelv.getId()) {
                    // Convertir desde Kelvin
                    kelvin kelvinValue = new kelvin(inputValue);
                    kelvin celsiusResult = kelvinValue.parse(new celsius(inputValue));
                    kelvin fahrenheitResult = kelvinValue.parse(new fahrenheit(inputValue));
                    resultText.setText("Celsius: " + celsiusResult.getValor() + "\nFahrenheit: " + fahrenheitResult.getValor());

                } else {
                    Toast.makeText(MainActivity.this, "Selecciona una unidad para convertir", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
}