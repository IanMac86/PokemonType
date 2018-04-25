package com.example.ian.poketype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Menu1 extends MainActivity implements AdapterView.OnItemSelectedListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

    Spinner spinner = (Spinner) findViewById(R.id.spinner);

    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.poketype, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears

adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Apply the adapter to the spinner
spinner.setAdapter(adapter);

spinner.setOnItemSelectedListener(this);

        //https://codedocu.com/Details?d=1722&a=12&f=238&l=0 for the spinner onclick and barry helped with the switch.. kinda :-)

    }
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String sSelected=parent.getItemAtPosition(position).toString();
        Toast.makeText(this,sSelected,Toast.LENGTH_SHORT).show();
        switch (sSelected){
            case "Bug":{Intent intent = new Intent (this,bugType.class
            );
                startActivity(intent);
                break;
            }
            case "Dark":{Intent intent = new Intent (this,darkType.class
            );
                startActivity(intent);
                break;
            }
            case "Dragon":{Intent intent = new Intent (this,dragonType.class
            );
                startActivity(intent);
                break;
            }
            case "Electric":{Intent intent = new Intent (this,electricType.class
            );
                startActivity(intent);
                break;
            }
            case "Fairy":{Intent intent = new Intent (this,fairyType.class
            );
                startActivity(intent);
                break;
            }
            case "Fighting":{Intent intent = new Intent (this,fightingType.class
            );
                startActivity(intent);
                break;
            }
            case "Fire":{Intent intent = new Intent (this,fireType.class
            );
                startActivity(intent);
                break;
            }
            case "Fly":{Intent intent = new Intent (this,flyType.class
            );
                startActivity(intent);
                break;
            }
            case "Ghost":{Intent intent = new Intent (this,ghostType.class
            );
                startActivity(intent);
                break;
            }
            case "Grass":{Intent intent = new Intent (this,grassType.class
            );
                startActivity(intent);
                break;
            }
            case "Ground":{Intent intent = new Intent (this,groundType.class
            );
                startActivity(intent);
                break;
            }
            case "Ice":{Intent intent = new Intent (this,iceType.class
            );
                startActivity(intent);
                break;
            }
            case "Normal":{Intent intent = new Intent (this,normalType.class
            );
                startActivity(intent);
                break;
            }
            case "Poison":{Intent intent;
                intent = new Intent(this,poisonType.class
                );
                startActivity(intent);
                break;
            }

            case "Psychic":{Intent intent;
                intent = new Intent(this,psychicType.class
                );
                startActivity(intent);
                break;
            }

            case "Rock":{Intent intent = new Intent (this,rockType.class
            );
                startActivity(intent);
                break;
            }

            case "Steel":{Intent intent = new Intent (this,steelType.class
            );
                startActivity(intent);
                break;
            }
            case "Water":{Intent intent = new Intent (this,waterType.class
            );
                startActivity(intent);
                break;
            }


        }//Switch for spinner to link to the "Pokemon"Class
        //Intent intent = new Intent (this,sSelected.Class);
        //startActivity(intent);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}