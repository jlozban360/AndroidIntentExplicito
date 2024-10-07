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

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding = ActivityMainBinding.inflate( getLayoutInflater( ) );
        setContentView( binding.getRoot( ) );
    }

    public void media( View view ) {
        int valorMatematicas = Integer.parseInt( binding.editTextNumber.getText( ).toString( ) );
        int valorFisica = Integer.parseInt( binding.editTextNumber2.getText( ).toString( ) );
        int valorQuimica = Integer.parseInt( binding.editTextNumber3.getText( ).toString( ) );
        int calcMedia = ( valorMatematicas + valorFisica + valorQuimica ) / 3;

        Intent intent = new Intent( this, Resultado.class );

        intent.putExtra( "mates", valorMatematicas );
        intent.putExtra( "fisica", valorFisica );
        intent.putExtra( "quimica", valorQuimica );
        intent.putExtra( "media", calcMedia );

        startActivity( intent );
    }
}