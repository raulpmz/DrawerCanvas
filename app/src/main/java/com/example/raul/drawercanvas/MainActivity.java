package com.example.raul.drawercanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;



public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RelativeLayout rl;
    Lienzo fondo;
    char grosor, colorfondo, colorPincel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        rl = (RelativeLayout) findViewById(R.id.content_main);
        fondo = new Lienzo(this);
        rl.addView(fondo);

    }

    class Lienzo extends View{

        float x = 50;
        float y = 50;
        Path path = new Path();
        String accion = "nada";
        Paint paint;

        public Lienzo(Context context){
            super(context);
            paint = new Paint();

        }

        protected void onDraw(Canvas canvas){
            canvas.drawColor(colorFondo());
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(grosor());
            paint.setColor(colorPincel());

            if(accion.equals("dawn")){
                path.moveTo(x,y);
            }
            if(accion.equals("move")){
                path.lineTo(x,y);
            }

            canvas.drawPath(path, paint);

        }



        @Override
        public boolean onTouchEvent(MotionEvent event) {

            int a = event.getAction();
            x = event.getX();
            y = event.getY();
            if(a == MotionEvent.ACTION_DOWN){
                accion = "dawn";
            }
            if(a == MotionEvent.ACTION_MOVE){
                accion = "move";
            }
            invalidate();

            return true;
        }

        public void limpiar(Canvas canvas){
            canvas.drawColor(Color.WHITE);
        }

        public int colorFondo(){

            if(colorfondo == 'b'){
                return Color.WHITE;
            }else if(colorfondo == 'n'){
                return Color.BLACK;
            }else if(colorfondo == 'a'){
                return Color.BLUE;
            }else if(colorfondo == 'r'){
                return Color.RED;
            }else if(colorfondo == 'v'){
                return Color.GREEN;
            }else if(colorfondo == 'm'){
                return Color.YELLOW;
            }
            return Color.WHITE;
        }

        public int colorPincel(){

            if(colorPincel == 'b'){
                return Color.WHITE;
            }else if(colorPincel == 'n'){
                return Color.BLACK;
            }else if(colorPincel == 'a'){
                return Color.BLUE;
            }else if(colorPincel == 'r'){
                return Color.RED;
            }else if(colorPincel == 'v'){
                return Color.GREEN;
            }else if(colorPincel == 'm'){
                return Color.YELLOW;
            }
            return Color.BLACK;
        }

        public int grosor(){

            if(grosor == 'f'){
                return 4;
            }else if(grosor == 'm'){
                return 8;
            }else if(grosor == 'g') {
                return 12;
            }
            return 6;
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_nuevo) {
            colorfondo = 'b';
            Lienzo fondo = new Lienzo(this);
            rl.addView(fondo);
        } else if (id == R.id.nav_salir) {
            finish();
        } else if (id == R.id.nav_fino) {
            grosor = 'f';
        } else if (id == R.id.nav_medio) {
            grosor = 'm';
        } else if (id == R.id.nav_grueso){
            grosor = 'g';
        } else if (id == R.id.nav_negro) {
            colorPincel = 'n';
        } else if (id == R.id.nav_blanco) {
            colorPincel = 'b';
        } else if (id == R.id.nav_azul) {
            colorPincel = 'a';
        } else if (id == R.id.nav_rojo) {
            colorPincel = 'r';
        } else if (id == R.id.nav_verde) {
            colorPincel = 'v';
        } else if (id == R.id.nav_amarillo) {
            colorPincel = 'm';
        } else if (id == R.id.nav_fnegro) {
            colorfondo = 'n';
        } else if (id == R.id.nav_fblanco) {
            colorfondo = 'b';
        } else if (id == R.id.nav_fazul) {
            colorfondo = 'a';
        } else if (id == R.id.nav_frojo) {
            colorfondo = 'r';
        } else if (id == R.id.nav_fverde) {
            colorfondo = 'v';
        } else if (id == R.id.nav_famarillo) {
            colorfondo = 'm';
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
