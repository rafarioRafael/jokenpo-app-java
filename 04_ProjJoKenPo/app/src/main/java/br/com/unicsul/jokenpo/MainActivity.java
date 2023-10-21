package br.com.unicsul.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int pontosJogador = 0;
    private int pontosApp = 0;
    private int rodadas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {

        ImageView imagemResultado = findViewById(R.id.imagemResultado);
        TextView textoResultado = findViewById(R.id.textoResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        ImageView imagemResultadox3 = findViewById(R.id.imagemResultadox3);

        switch (opcaoApp) {
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (opcaoApp == "tesoura" && opcaoSelecionada == "papel") ||
                        (opcaoApp == "papel" && opcaoSelecionada == "pedra") ||
                        (opcaoApp == "pedra" && opcaoSelecionada == "tesoura")
        ) {
            imagemResultadox3.setImageResource(R.drawable.gato_perdeu);
            pontosApp++;
        } else if (
                (opcaoSelecionada == "tesoura" && opcaoApp == "papel") ||
                        (opcaoSelecionada == "papel" && opcaoApp == "pedra") ||
                        (opcaoSelecionada == "pedra" && opcaoApp == "tesoura")
        ) {
            imagemResultadox3.setImageResource(R.drawable.gato_ganhou);
            pontosJogador++;
        } else {
            imagemResultadox3.setImageResource(R.drawable.gato_empatou);
        }

        rodadas++;

        if (rodadas >= 3) {
            if (pontosJogador > pontosApp) {
                textoResultado.setText("Ganhou! pontos: " + pontosJogador + " - " + pontosApp);
            } else if (pontosJogador < pontosApp) {
                textoResultado.setText("Perdeu.. pontos: " + pontosJogador + " - " + pontosApp);
            } else if (pontosJogador == pontosApp) {
                textoResultado.setText("Empate... ");
            }

            pontosJogador = 0;
            pontosApp = 0;
            rodadas = 0;
        }
    }
}











