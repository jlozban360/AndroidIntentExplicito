package es.iesoretania.intentexplicito;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import es.iesoretania.intentexplicito.databinding.ActivityMainBinding;
import es.iesoretania.intentexplicito.databinding.ActivityResultadoBinding;

public class Resultado extends AppCompatActivity {
    private ActivityResultadoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding = ActivityResultadoBinding.inflate( getLayoutInflater( ) );
        setContentView( binding.getRoot( ) );
        Bundle bundle = getIntent( ).getExtras( );
        int valor1 = bundle.getInt( "mates" );
        int valor2 = bundle.getInt( "fisica" );
        int valor3 = bundle.getInt( "quimica" );
        int media = bundle.getInt( "media" );

        binding.textView.setText( "Nota de matematicas: " + valor1 );
        binding.textView2.setText( "Nota de fisica: " + valor2 );
        binding.textView3.setText( "Nota de quimica: " + valor3 );

        if( media >= 5 )
            binding.textView4.setText( "Aprobado con " + media + " de media");
        else
            binding.textView4.setText( "Suspenso con " + media + " de media");
    }


}