package example.com.taschenrechner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private EditText edieren;

    private String NumUndZeichen = "";
    private char Zeichen;
    private double num1 = 0, num2 = 0, sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//对按钮和事件进行初始化
    }

    private void initView() {
        Button plus;
        Button minus;
        Button multiplizieren;
        Button loswerden;
        Button gleich;
        Button wegstreichen;
        Button zruckstellen;
        Button punkt;
        Button eins;
        Button zwei;
        Button drei;
        Button vier;
        Button funf;
        Button sechs;
        Button sieben;
        Button acht;
        Button neun;
        Button zero;
        eins = findViewById(R.id.eins);
        zwei = findViewById(R.id.zwei);
        drei = findViewById(R.id.drei);
        vier = findViewById(R.id.vier);
        funf = findViewById(R.id.funf);
        sechs = findViewById(R.id.sechs);
        sieben = findViewById(R.id.sieben);
        acht = findViewById(R.id.acht);
        neun = findViewById(R.id.neun);
        zero = findViewById(R.id.zero);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiplizieren = findViewById(R.id.multiplizieren);
        loswerden = findViewById(R.id.loswerden);
        wegstreichen = findViewById(R.id.wegstreichen);
        zruckstellen = findViewById(R.id.zruckstellen);
        gleich = findViewById(R.id.gleich);
        punkt = findViewById(R.id.punkt);
        edieren = findViewById(R.id.edieren);
        edieren.setCursorVisible(false);//Wenn Sie auswahlen,ist der Cursor nicht hell;
        //Button Event hinzufugen;
        zero.setOnClickListener(this);
        eins.setOnClickListener(this);
        zwei.setOnClickListener(this);
        drei.setOnClickListener(this);
        vier.setOnClickListener(this);
        funf.setOnClickListener(this);
        sechs.setOnClickListener(this);
        sieben.setOnClickListener(this);
        acht.setOnClickListener(this);
        neun.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiplizieren.setOnClickListener(this);
        loswerden.setOnClickListener(this);
        gleich.setOnClickListener(this);
        wegstreichen.setOnClickListener(this);
        zruckstellen.setOnClickListener(this);
        punkt.setOnClickListener(this);
        edieren.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

       // if(NumUndZeichen.length()>3){Toast.makeText(this, "不能连算", Toast.LENGTH_SHORT).show();

      //  }else{
        switch (v.getId()) {
            case R.id.eins:
                NumUndZeichen = AddSum('1');
                edieren.setText(NumUndZeichen);
                break;
            case R.id.zwei:
                NumUndZeichen = AddSum('2');
                edieren.setText(NumUndZeichen);
                break;
            case R.id.drei:
                NumUndZeichen = AddSum('3');
                edieren.setText(NumUndZeichen);
                break;
            case R.id.vier:
                NumUndZeichen = AddSum('4');
                edieren.setText(NumUndZeichen);
                break;
            case R.id.funf:
                NumUndZeichen = AddSum('5');
                edieren.setText(NumUndZeichen);
                break;
            case R.id.sechs:
                NumUndZeichen = AddSum('6');
                edieren.setText(NumUndZeichen);
                break;
            case R.id.sieben:
                NumUndZeichen = AddSum('7');
                edieren.setText(NumUndZeichen);
                break;
            case R.id.acht:
                NumUndZeichen = AddSum('8');
                edieren.setText(NumUndZeichen);
                break;
            case R.id.neun:
                NumUndZeichen = AddSum('9');
                edieren.setText(NumUndZeichen);
                break;
            case R.id.zero:
                NumUndZeichen = AddSum('0');
                edieren.setText(NumUndZeichen);
                break;
            case R.id.plus:
                NumUndZeichen = AddSum('+');
                Zeichen = '+';

                edieren.setText(NumUndZeichen);
                break;
            case R.id.minus:
                NumUndZeichen = AddSum('-');
                Zeichen = '-';

                edieren.setText(NumUndZeichen);

                break;
            case R.id.multiplizieren:
                NumUndZeichen = AddSum('*');
                Zeichen = '*';

                edieren.setText(NumUndZeichen);
                break;
            case R.id.loswerden:
                NumUndZeichen = AddSum('/');
                Zeichen = '/';

                edieren.setText(NumUndZeichen);
                break;
            case R.id.punkt:
                NumUndZeichen = AddSum('.');
                edieren.setText(NumUndZeichen);
                break;

            //switch (v.getId()){
            case R.id.wegstreichen:
                if (NumUndZeichen.length() >= 1) {
                    NumUndZeichen = NumUndZeichen.substring(0, NumUndZeichen.length() - 1);
                }
                edieren.setText(NumUndZeichen);
                break;
            case R.id.zruckstellen:
                NumUndZeichen = "";
                num1 = 0;
                num2 = 0;
                sum = 0;
                Zeichen = ' ';
                edieren.setText(NumUndZeichen);
                break;
            case R.id.gleich:
                if (CheckInput(NumUndZeichen)) {
                    NumUndZeichen = NumUndZeichen + "=" + String.valueOf(equals(NumUndZeichen));
                    edieren.setText(NumUndZeichen);
                    NumUndZeichen = String.valueOf(sum);
                }

                else {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

                }
                break;
            default:
                break;


        }  }//}


    public String AddSum(char c) {

        NumUndZeichen = NumUndZeichen + String.valueOf(c);
        return NumUndZeichen;
    }



    public boolean CheckInput(String NumUndZeichen) {
        if (NumUndZeichen.length() <= 2) {//至少要分别输入了一个数字和一个运算符和一个数字，输入长度<=2肯定不合理
            return false;
        }
        if (NumUndZeichen.indexOf(Zeichen, 1) == -1) {//没有输入运算符，肯定不合理
            return false;
        }
        if (NumUndZeichen.endsWith(String.valueOf(Zeichen))) {//最后以运算符结尾而不是数字，肯定不合理
            return false;
        }

        return true;

    }

    public double equals(String NumUndZeichen)
    {
        int indexOfZeichen=0;
        indexOfZeichen=NumUndZeichen.indexOf(Zeichen,1);
        if(NumUndZeichen.length()>=3)
        {num1=Double.parseDouble(NumUndZeichen.substring(0,indexOfZeichen));//得到第一个运算数
        num2=Double.parseDouble(NumUndZeichen.substring(indexOfZeichen+1,NumUndZeichen.length()));//得到第二个运算数
    }
    switch (Zeichen)
    {
        case '+':
            sum=num1+num2;
            break;
        case '-':
            sum=num1-num2;
            break;
        case '*':
            sum=num1*num2;
            break;
        case '/':
            if(num2!=0)
            {
                sum=num1/num2;
            }
            else {

            sum=0;
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
            }
            break;
            default:
                break;
            }
            return  sum;
    }
}