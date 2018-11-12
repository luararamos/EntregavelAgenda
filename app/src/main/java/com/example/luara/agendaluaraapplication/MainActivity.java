package com.example.luara.agendaluaraapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.luara.agendaluaraapplication.adapter.RecyclerViewAdapter;
import com.example.luara.agendaluaraapplication.fragment.AdicionarContatoFragment;
import com.example.luara.agendaluaraapplication.interfac.AdicionatContato;
import com.example.luara.agendaluaraapplication.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdicionatContato {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    // adicionei para conseguir remover depois que cadastrar
    private AdicionarContatoFragment fragmentAddContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RecyclerView (comeca aqui)

        recyclerView = findViewById(R.id.recyclerViewPessoas);

//        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getListPessoas());
        adapter = new RecyclerViewAdapter();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(layoutManager);
        // RecyclerView (termina aqui)

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aqui, deve-se mudar para o outro fragment
                irParaAddContato();
            }
        });






    }
    // crio metodo para confirmar que o recyclerView esta funcionando
    // o metodo e privado para apenas a classe usar o metodo
    // E funcionoooou ebaa
    private List<Pessoa> getListPessoas(){
        List<Pessoa> list = new ArrayList<>();

//        list.add(new Pessoa("Luara", "(11) 94493-2944"));
//        list.add(new Pessoa("Jessica","(21) 99742-5556"));
//        list.add(new Pessoa("Fabi", "(11) 96437-8996"));
//        list.add(new Pessoa("TestePessoa","(xx)xxxxx-xxxx"));
//        list.add(new Pessoa("TestePessoa","(xx)xxxxx-xxxx"));
//        list.add(new Pessoa("TestePessoa","(xx)xxxxx-xxxx"));
//        list.add(new Pessoa("TestePessoa","(xx)xxxxx-xxxx"));

        return list;
    }

    public void irParaAddContato(){
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.frameAddContato, new AdicionarContatoFragment());
//        transaction.commit();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        // mudei para conseguir remover o fragment apos cadastro -
        // criei o metodo fora como atributo  que recebeu um new fragment dentro do metodo
        fragmentAddContato = new AdicionarContatoFragment();
        transaction.replace(R.id.frameAddContato, fragmentAddContato);
        transaction.commit();



    }

    @Override
    public void criarContatoAcao(Pessoa pessoa) {
        // precisei criar o metodo addContato no RecyclerViewAdapter e declarar o adapter fora do onCreate
        adapter.addContato(pessoa);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        // remover o fragment depois que cadastrar
        transaction.remove(fragmentAddContato);

        transaction.commit();
    }
}
