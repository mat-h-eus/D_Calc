package com.example.d_calc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cadastro_D extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView tvNome;
    TextView tvEq;
    TextView tvNota;
    EditText etNome;
    EditText etEq;
    EditText etNota;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tvNome = findViewById(R.id.tvNome);
        tvEq = findViewById(R.id.tvEq);
        etNome = findViewById(R.id.etNome);
        etEq = findViewById(R.id.etEq);
        tvNota = findViewById(R.id.tvNota);
        etNota = findViewById(R.id.etNota);
        btnAdd = findViewById(R.id.btnAdd);

        setContentView(R.layout.activity_cadastro__d);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }
    public void salvaMateria(View v) {
        //Roda o controlador aqui
        //Salva no banco se tudo der certo

        EditText etNome;
        EditText etEq;
        EditText etNota;
        etNome = (EditText) findViewById(R.id.etNome);
        etEq = (EditText)findViewById(R.id.etEq);
        etNota = (EditText)findViewById(R.id.etNota);
        Dao dao = new Dao(getBaseContext());
        String nome = etNome.getText().toString();
        String equacao = etEq.getText().toString();
        String nota = etNota.getText().toString();
        String resultado;
        resultado = dao.insereDadoMateria(nome, equacao, nota);
        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

        Intent intent = new Intent();
        intent.putExtra("nome",nome);
        setResult(RESULT_OK,intent);
        Cadastro_D.this.finish();

        /*Intent intent = new Intent();
        intent.putExtra("nome",nome);
        setResult(RESULT_OK,intent);
        Cadastro_D.this.finish();*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cadastro__d, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
