package mcm.edu.ph.inheritancerpg_sampler.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import mcm.edu.ph.inheritancerpg_sampler.Model.Hero;
import mcm.edu.ph.inheritancerpg_sampler.R;

public class StartingPointAllocation extends AppCompatActivity implements View.OnClickListener {

    int statPoints = 10;
    int statSTR = 0;
    int statAGI = 0;
    int statINT = 0;
    int statLUK = 0;
    int statCON = 0;
    String heroName = "";
    int heroClass;

    Button aSTR,sSTR,aAGI,sAGI,aINT,sINT,aLUK,sLUK,aCON,sCON,start;
    TextView txtSTR,txtAGI,txtINT,txtLUK,txtCON,txtPoints;

    Hero hero;

    Intent i2;
    EditText txtNameInput;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_point_allocation);



        i2 = new Intent(this,TownHall.class);

        Intent i = getIntent();
        heroClass = i.getIntExtra("heroClass",0);

        aSTR = findViewById(R.id.btnAddSTR);
        sSTR = findViewById(R.id.btnSubSTR);
        aAGI = findViewById(R.id.btnAddAGI);
        sAGI = findViewById(R.id.btnSubAGI);
        aINT = findViewById(R.id.btnAddINT);
        sINT = findViewById(R.id.btnSubINT);
        aLUK = findViewById(R.id.btnAddLUK);
        sLUK = findViewById(R.id.btnSubLUK);
        aCON = findViewById(R.id.btnAddCON);
        sCON = findViewById(R.id.btnSubCON);
        start = findViewById(R.id.btnGameStart);
        txtSTR = findViewById(R.id.txtSTR);
        txtAGI = findViewById(R.id.txtAGI);
        txtINT = findViewById(R.id.txtINT);
        txtLUK = findViewById(R.id.txtLUK);
        txtCON = findViewById(R.id.txtCON);
        txtPoints = findViewById(R.id.txtPoints);

        txtNameInput = findViewById(R.id.txtNameInput);

        aSTR.setOnClickListener(this);
        sSTR.setOnClickListener(this);
        aAGI.setOnClickListener(this);
        sAGI.setOnClickListener(this);
        aINT.setOnClickListener(this);
        sINT.setOnClickListener(this);
        aLUK.setOnClickListener(this);
        sLUK.setOnClickListener(this);
        aCON.setOnClickListener(this);
        sCON.setOnClickListener(this);
        start.setOnClickListener(this);



        sSTR.setEnabled(false);
        sAGI.setEnabled(false);
        sINT.setEnabled(false);
        sLUK.setEnabled(false);
        sCON.setEnabled(false);

        if(heroClass == 1){
            Hero hero = new Hero(heroName,"Mage",4,4,10,2,4,20,25,300,300);
            this.hero = hero;
        }
        else if(heroClass == 2){
            Hero hero = new Hero(heroName,"Warrior",10,4,4,2,5,15,20,300,100);
            this.hero = hero;
        }
        else if(heroClass == 3){
            Hero hero = new Hero(heroName,"Ranger",6,7,4,2,5,15,25,300,100);
            this.hero = hero;
        }
        else if(heroClass == 4){
            Hero hero = new Hero(heroName,"Paladin",8,3,3,2,7,15,20,500,80);
            this.hero = hero;;
        }



        txtSTR.setText(String.valueOf(hero.getStatSTR()));
        txtAGI.setText(String.valueOf(hero.getStatAGI()));
        txtINT.setText(String.valueOf(hero.getStatINT()));
        txtLUK.setText(String.valueOf(hero.getStatLUK()));
        txtCON.setText(String.valueOf(hero.getStatCON()));

        txtSTR.setTextColor(Color.parseColor("#eb4132"));
        txtAGI.setTextColor(Color.parseColor("#eb4132"));
        txtINT.setTextColor(Color.parseColor("#eb4132"));
        txtLUK.setTextColor(Color.parseColor("#eb4132"));
        txtCON.setTextColor(Color.parseColor("#eb4132"));



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddSTR:
                statPoints--;
                statSTR++;

                sSTR.setEnabled(true);
                sINT.setEnabled(true);
                sAGI.setEnabled(true);
                sLUK.setEnabled(true);
                sCON.setEnabled(true);



                if( statPoints < 1 ){ //if statpoints is less than one, then disable add btns
                    aSTR.setEnabled(false);
                    aAGI.setEnabled(false);
                    aINT.setEnabled(false);
                    aLUK.setEnabled(false);
                    aCON.setEnabled(false);
                }
                if( statSTR > 9){aSTR.setEnabled(false);} //if str is greater than 10, disable add btns
                if( statAGI > 9){aAGI.setEnabled(false);}
                if( statINT > 9){aINT.setEnabled(false);}
                if( statLUK > 9){aLUK.setEnabled(false);}
                if( statCON > 9){aCON.setEnabled(false);}

                if( statSTR < 1) {sSTR.setEnabled(false); txtSTR.setTextColor(Color.parseColor("#eb4132"));} //if STR is less than 1, then disable sub
                if( statAGI < 1) {sAGI.setEnabled(false); txtAGI.setTextColor(Color.parseColor("#eb4132"));}
                if( statINT < 1) {sINT.setEnabled(false); txtINT.setTextColor(Color.parseColor("#eb4132"));}
                if( statLUK < 1) {sLUK.setEnabled(false); txtLUK.setTextColor(Color.parseColor("#eb4132"));}
                if( statCON < 1) {sCON.setEnabled(false); txtCON.setTextColor(Color.parseColor("#eb4132"));}

                txtSTR.setTextColor(Color.parseColor("#4086f4"));
                txtSTR.setText(String.valueOf(statSTR + hero.getStatSTR()));
                txtPoints.setText(String.valueOf(statPoints));
                break;

            case R.id.btnSubSTR:
                statPoints++;
                statSTR--;

                if(statPoints > 0){ //if statpts is greater than 0, then enable sub btns
                    aSTR.setEnabled(true);
                    aAGI.setEnabled(true);
                    aINT.setEnabled(true);
                    aLUK.setEnabled(true);
                    aCON.setEnabled(true);
                }
                if( statSTR < 1) {sSTR.setEnabled(false); txtSTR.setTextColor(Color.parseColor("#eb4132"));} //if STR is less than 1, then disable sub
                if( statAGI < 1) {sAGI.setEnabled(false); txtAGI.setTextColor(Color.parseColor("#eb4132"));}
                if( statINT < 1) {sINT.setEnabled(false); txtINT.setTextColor(Color.parseColor("#eb4132"));}
                if( statLUK < 1) {sLUK.setEnabled(false); txtLUK.setTextColor(Color.parseColor("#eb4132"));}
                if( statCON < 1) {sCON.setEnabled(false); txtCON.setTextColor(Color.parseColor("#eb4132"));}



                txtSTR.setText(String.valueOf(statSTR + hero.getStatSTR()));
                txtPoints.setText(String.valueOf(statPoints));

                break;
            case R.id.btnAddAGI:
                statPoints--;
                statAGI++;

                sSTR.setEnabled(true);
                sINT.setEnabled(true);
                sAGI.setEnabled(true);
                sLUK.setEnabled(true);
                sCON.setEnabled(true);

                if( statPoints < 1 ){ //if statpoints is less than one, then disable add btns
                    aSTR.setEnabled(false);
                    aAGI.setEnabled(false);
                    aINT.setEnabled(false);
                    aLUK.setEnabled(false);
                    aCON.setEnabled(false);
                }
                if( statSTR > 9){aSTR.setEnabled(false);} //if str is greater than 10, disable add btns
                if( statAGI > 9){aAGI.setEnabled(false);}
                if( statINT > 9){aINT.setEnabled(false);}
                if( statLUK > 9){aLUK.setEnabled(false);}
                if( statCON > 9){aCON.setEnabled(false);}

                if( statSTR < 1) {sSTR.setEnabled(false); txtSTR.setTextColor(Color.parseColor("#eb4132"));} //if STR is less than 1, then disable sub
                if( statAGI < 1) {sAGI.setEnabled(false); txtAGI.setTextColor(Color.parseColor("#eb4132"));}
                if( statINT < 1) {sINT.setEnabled(false); txtINT.setTextColor(Color.parseColor("#eb4132"));}
                if( statLUK < 1) {sLUK.setEnabled(false); txtLUK.setTextColor(Color.parseColor("#eb4132"));}
                if( statCON < 1) {sCON.setEnabled(false); txtCON.setTextColor(Color.parseColor("#eb4132"));}


                txtAGI.setTextColor(Color.parseColor("#4086f4"));
                txtAGI.setText(String.valueOf(statAGI + hero.getStatAGI()));
                txtPoints.setText(String.valueOf(statPoints));
                break;
            case R.id.btnSubAGI:
                statPoints++;
                statAGI--;

                if(statPoints > 0){ //if statpts is greater than 0, then enable sub btns
                    aSTR.setEnabled(true);
                    aAGI.setEnabled(true);
                    aINT.setEnabled(true);
                    aLUK.setEnabled(true);
                    aCON.setEnabled(true);
                }
                if( statSTR < 1) {sSTR.setEnabled(false); txtSTR.setTextColor(Color.parseColor("#eb4132"));} //if STR is less than 1, then disable sub
                if( statAGI < 1) {sAGI.setEnabled(false); txtAGI.setTextColor(Color.parseColor("#eb4132"));}
                if( statINT < 1) {sINT.setEnabled(false); txtINT.setTextColor(Color.parseColor("#eb4132"));}
                if( statLUK < 1) {sLUK.setEnabled(false); txtLUK.setTextColor(Color.parseColor("#eb4132"));}
                if( statCON < 1) {sCON.setEnabled(false); txtCON.setTextColor(Color.parseColor("#eb4132"));}

                txtAGI.setText(String.valueOf(statAGI + hero.getStatAGI()));
                txtPoints.setText(String.valueOf(statPoints));
                break;
            case R.id.btnAddINT:
                statPoints--;
                statINT++;
                sSTR.setEnabled(true);
                sINT.setEnabled(true);
                sAGI.setEnabled(true);
                sLUK.setEnabled(true);
                sCON.setEnabled(true);

                if( statPoints < 1 ){ //if statpoints is less than one, then disable add btns
                    aSTR.setEnabled(false);
                    aAGI.setEnabled(false);
                    aINT.setEnabled(false);
                    aLUK.setEnabled(false);
                    aCON.setEnabled(false);
                }
                if( statSTR > 9){aSTR.setEnabled(false);} //if str is greater than 10, disable add btns
                if( statAGI > 9){aAGI.setEnabled(false);}
                if( statINT > 9){aINT.setEnabled(false);}
                if( statLUK > 9){aLUK.setEnabled(false);}
                if( statCON > 9){aCON.setEnabled(false);}

                if( statSTR < 1) {sSTR.setEnabled(false); txtSTR.setTextColor(Color.parseColor("#eb4132"));} //if STR is less than 1, then disable sub
                if( statAGI < 1) {sAGI.setEnabled(false); txtAGI.setTextColor(Color.parseColor("#eb4132"));}
                if( statINT < 1) {sINT.setEnabled(false); txtINT.setTextColor(Color.parseColor("#eb4132"));}
                if( statLUK < 1) {sLUK.setEnabled(false); txtLUK.setTextColor(Color.parseColor("#eb4132"));}
                if( statCON < 1) {sCON.setEnabled(false); txtCON.setTextColor(Color.parseColor("#eb4132"));}

                txtINT.setTextColor(Color.parseColor("#4086f4"));
                txtINT.setText(String.valueOf(statINT + hero.getStatINT()));
                txtPoints.setText(String.valueOf(statPoints));
                break;
            case R.id.btnSubINT:
                statPoints++;
                statINT--;

                if(statPoints > 0){ //if statpts is greater than 0, then enable sub btns
                    aSTR.setEnabled(true);
                    aAGI.setEnabled(true);
                    aINT.setEnabled(true);
                    aLUK.setEnabled(true);
                    aCON.setEnabled(true);
                }
                if( statSTR < 1) {sSTR.setEnabled(false); txtSTR.setTextColor(Color.parseColor("#eb4132"));} //if STR is less than 1, then disable sub
                if( statAGI < 1) {sAGI.setEnabled(false); txtAGI.setTextColor(Color.parseColor("#eb4132"));}
                if( statINT < 1) {sINT.setEnabled(false); txtINT.setTextColor(Color.parseColor("#eb4132"));}
                if( statLUK < 1) {sLUK.setEnabled(false); txtLUK.setTextColor(Color.parseColor("#eb4132"));}
                if( statCON < 1) {sCON.setEnabled(false); txtCON.setTextColor(Color.parseColor("#eb4132"));}

                txtINT.setText(String.valueOf(statINT + hero.getStatINT()));
                txtPoints.setText(String.valueOf(statPoints));
                break;
            case R.id.btnAddLUK:
                statPoints--;
                statLUK++;

                sSTR.setEnabled(true);
                sINT.setEnabled(true);
                sAGI.setEnabled(true);
                sLUK.setEnabled(true);
                sCON.setEnabled(true);

                if( statPoints < 1 ){ //if statpoints is less than one, then disable add btns
                    aSTR.setEnabled(false);
                    aAGI.setEnabled(false);
                    aINT.setEnabled(false);
                    aLUK.setEnabled(false);
                    aCON.setEnabled(false);
                }
                if( statSTR > 9){aSTR.setEnabled(false);} //if str is greater than 10, disable add btns
                if( statAGI > 9){aAGI.setEnabled(false);}
                if( statINT > 9){aINT.setEnabled(false);}
                if( statLUK > 9){aLUK.setEnabled(false);}
                if( statCON > 9){aCON.setEnabled(false);}

                if( statSTR < 1) {sSTR.setEnabled(false); txtSTR.setTextColor(Color.parseColor("#eb4132"));} //if STR is less than 1, then disable sub
                if( statAGI < 1) {sAGI.setEnabled(false); txtAGI.setTextColor(Color.parseColor("#eb4132"));}
                if( statINT < 1) {sINT.setEnabled(false); txtINT.setTextColor(Color.parseColor("#eb4132"));}
                if( statLUK < 1) {sLUK.setEnabled(false); txtLUK.setTextColor(Color.parseColor("#eb4132"));}
                if( statCON < 1) {sCON.setEnabled(false); txtCON.setTextColor(Color.parseColor("#eb4132"));}

                txtLUK.setTextColor(Color.parseColor("#4086f4"));
                txtLUK.setText(String.valueOf(statLUK+ hero.getStatLUK()));
                txtPoints.setText(String.valueOf(statPoints));
                break;
            case R.id.btnSubLUK:
                statPoints++;
                statLUK--;

                if(statPoints > 0){ //if statpts is greater than 0, then enable sub btns
                    aSTR.setEnabled(true);
                    aAGI.setEnabled(true);
                    aINT.setEnabled(true);
                    aLUK.setEnabled(true);
                    aCON.setEnabled(true);
                }
                if( statSTR < 1) {sSTR.setEnabled(false); txtSTR.setTextColor(Color.parseColor("#eb4132"));} //if STR is less than 1, then disable sub
                if( statAGI < 1) {sAGI.setEnabled(false); txtAGI.setTextColor(Color.parseColor("#eb4132"));}
                if( statINT < 1) {sINT.setEnabled(false); txtINT.setTextColor(Color.parseColor("#eb4132"));}
                if( statLUK < 1) {sLUK.setEnabled(false); txtLUK.setTextColor(Color.parseColor("#eb4132"));}
                if( statCON < 1) {sCON.setEnabled(false); txtCON.setTextColor(Color.parseColor("#eb4132"));}

                txtLUK.setText(String.valueOf(statLUK+ hero.getStatLUK()));
                txtPoints.setText(String.valueOf(statPoints));
                break;
            case R.id.btnAddCON:
                statPoints--;
                statCON++;

                sSTR.setEnabled(true);
                sINT.setEnabled(true);
                sAGI.setEnabled(true);
                sLUK.setEnabled(true);
                sCON.setEnabled(true);

                if( statPoints < 1 ){ //if statpoints is less than one, then disable add btns
                    aSTR.setEnabled(false);
                    aAGI.setEnabled(false);
                    aINT.setEnabled(false);
                    aLUK.setEnabled(false);
                    aCON.setEnabled(false);
                }
                if( statSTR > 9){aSTR.setEnabled(false);} //if str is greater than 10, disable add btns
                if( statAGI > 9){aAGI.setEnabled(false);}
                if( statINT > 9){aINT.setEnabled(false);}
                if( statLUK > 9){aLUK.setEnabled(false);}
                if( statCON > 9){aCON.setEnabled(false);}

                if( statSTR < 1) {sSTR.setEnabled(false); txtSTR.setTextColor(Color.parseColor("#eb4132"));} //if STR is less than 1, then disable sub
                if( statAGI < 1) {sAGI.setEnabled(false); txtAGI.setTextColor(Color.parseColor("#eb4132"));}
                if( statINT < 1) {sINT.setEnabled(false); txtINT.setTextColor(Color.parseColor("#eb4132"));}
                if( statLUK < 1) {sLUK.setEnabled(false); txtLUK.setTextColor(Color.parseColor("#eb4132"));}
                if( statCON < 1) {sCON.setEnabled(false); txtCON.setTextColor(Color.parseColor("#eb4132"));}

                txtCON.setTextColor(Color.parseColor("#4086f4"));
                txtCON.setText(String.valueOf(statCON + hero.getStatCON()));
                txtPoints.setText(String.valueOf(statPoints));
                break;

            case R.id.btnSubCON:
                statPoints++;
                statCON--;

                if(statPoints > 0){ //if statpts is greater than 0, then enable sub btns
                    aSTR.setEnabled(true);
                    aAGI.setEnabled(true);
                    aINT.setEnabled(true);
                    aLUK.setEnabled(true);
                    aCON.setEnabled(true);
                }
                if( statSTR < 1) {sSTR.setEnabled(false); txtSTR.setTextColor(Color.parseColor("#eb4132"));} //if STR is less than 1, then disable sub
                if( statAGI < 1) {sAGI.setEnabled(false); txtAGI.setTextColor(Color.parseColor("#eb4132"));}
                if( statINT < 1) {sINT.setEnabled(false); txtINT.setTextColor(Color.parseColor("#eb4132"));}
                if( statLUK < 1) {sLUK.setEnabled(false); txtLUK.setTextColor(Color.parseColor("#eb4132"));}
                if( statCON < 1) {sCON.setEnabled(false); txtCON.setTextColor(Color.parseColor("#eb4132"));}

                txtCON.setText(String.valueOf(statCON + hero.getStatCON()));
                txtPoints.setText(String.valueOf(statPoints));
                break;

            case R.id.btnGameStart:
                heroName = txtNameInput.getText().toString();

                i2.putExtra("HERO_NAME",heroName);
                i2.putExtra("HERO_CLASS",hero.getTitle());

                startActivity(i2);
                break;
        }


    }
}