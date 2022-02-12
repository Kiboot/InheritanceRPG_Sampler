package mcm.edu.ph.inheritancerpg_sampler.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mcm.edu.ph.inheritancerpg_sampler.R;

public class StartingPointAllocation extends AppCompatActivity implements View.OnClickListener {

    int statPoints = 10;

    int statSTR = 0;
    int statAGI = 0;
    int statINT = 0;
    int statLUK = 0;
    int statCON = 0;

    Button aSTR,sSTR,aAGI,sAGI,aINT,sINT,aLUK,sLUK,aCON,sCON,start;
    TextView txtSTR,txtAGI,txtINT,txtLUK,txtCON,txtPoints;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_point_allocation);
        Intent i = getIntent();
        String heroClass = i.getStringExtra("heroClass");

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

                if( statSTR < 1) {sSTR.setEnabled(false);} //if STR is less than 1, then disable sub
                if( statAGI < 1) {sAGI.setEnabled(false);}
                if( statINT < 1) {sINT.setEnabled(false);}
                if( statLUK < 1) {sLUK.setEnabled(false);}
                if( statCON < 1) {sCON.setEnabled(false);}

                txtSTR.setText(String.valueOf(statSTR));
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
                if( statSTR < 1) {sSTR.setEnabled(false);} //if STR is less than 1, then disable sub
                if( statAGI < 1) {sAGI.setEnabled(false);}
                if( statINT < 1) {sINT.setEnabled(false);}
                if( statLUK < 1) {sLUK.setEnabled(false);}
                if( statCON < 1) {sCON.setEnabled(false);}




                txtSTR.setText(String.valueOf(statSTR));
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

                if( statSTR < 1) {sSTR.setEnabled(false);} //if STR is less than 1, then disable sub
                if( statAGI < 1) {sAGI.setEnabled(false);}
                if( statINT < 1) {sINT.setEnabled(false);}
                if( statLUK < 1) {sLUK.setEnabled(false);}
                if( statCON < 1) {sCON.setEnabled(false);}

                txtAGI.setText(String.valueOf(statAGI));
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
                if( statSTR < 1) {sSTR.setEnabled(false);} //if STR is less than 1, then disable sub
                if( statAGI < 1) {sAGI.setEnabled(false);}
                if( statINT < 1) {sINT.setEnabled(false);}
                if( statLUK < 1) {sLUK.setEnabled(false);}
                if( statCON < 1) {sCON.setEnabled(false);}

                txtAGI.setText(String.valueOf(statAGI));
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

                if( statSTR < 1) {sSTR.setEnabled(false);} //if STR is less than 1, then disable sub
                if( statAGI < 1) {sAGI.setEnabled(false);}
                if( statINT < 1) {sINT.setEnabled(false);}
                if( statLUK < 1) {sLUK.setEnabled(false);}
                if( statCON < 1) {sCON.setEnabled(false);}

                txtINT.setText(String.valueOf(statINT));
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
                if( statSTR < 1) {sSTR.setEnabled(false);} //if STR is less than 1, then disable sub
                if( statAGI < 1) {sAGI.setEnabled(false);}
                if( statINT < 1) {sINT.setEnabled(false);}
                if( statLUK < 1) {sLUK.setEnabled(false);}
                if( statCON < 1) {sCON.setEnabled(false);}

                txtINT.setText(String.valueOf(statINT));
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

                if( statSTR < 1) {sSTR.setEnabled(false);} //if STR is less than 1, then disable sub
                if( statAGI < 1) {sAGI.setEnabled(false);}
                if( statINT < 1) {sINT.setEnabled(false);}
                if( statLUK < 1) {sLUK.setEnabled(false);}
                if( statCON < 1) {sCON.setEnabled(false);}

                txtLUK.setText(String.valueOf(statLUK));
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
                if( statSTR < 1) {sSTR.setEnabled(false);} //if STR is less than 1, then disable sub
                if( statAGI < 1) {sAGI.setEnabled(false);}
                if( statINT < 1) {sINT.setEnabled(false);}
                if( statLUK < 1) {sLUK.setEnabled(false);}
                if( statCON < 1) {sCON.setEnabled(false);}

                txtLUK.setText(String.valueOf(statLUK));
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

                if( statSTR < 1) {sSTR.setEnabled(false);} //if STR is less than 1, then disable sub
                if( statAGI < 1) {sAGI.setEnabled(false);}
                if( statINT < 1) {sINT.setEnabled(false);}
                if( statLUK < 1) {sLUK.setEnabled(false);}
                if( statCON < 1) {sCON.setEnabled(false);}

                txtCON.setText(String.valueOf(statCON));
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
                if( statSTR < 1) {sSTR.setEnabled(false);} //if STR is less than 1, then disable sub
                if( statAGI < 1) {sAGI.setEnabled(false);}
                if( statINT < 1) {sINT.setEnabled(false);}
                if( statLUK < 1) {sLUK.setEnabled(false);}
                if( statCON < 1) {sCON.setEnabled(false);}

                txtCON.setText(String.valueOf(statCON));
                txtPoints.setText(String.valueOf(statPoints));
                break;

        }


    }
}