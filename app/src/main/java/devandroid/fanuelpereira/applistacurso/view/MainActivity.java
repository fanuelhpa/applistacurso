package devandroid.fanuelpereira.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import devandroid.fanuelpereira.applistacurso.R;
import devandroid.fanuelpereira.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    pessoa = new Pessoa();

    pessoa.setPrimeiroNome("Fanuel");
    pessoa.setSobreNome("Pereira");
    pessoa.setCursoDesejado("Android");
    pessoa.setTelefoneContato("(31) 99248-6568");

    }
}