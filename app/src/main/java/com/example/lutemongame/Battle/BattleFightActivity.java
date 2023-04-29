package com.example.lutemongame.Battle;

import static com.example.lutemongame.Inventory.getBattleLutemons;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.lutemongame.CombatArenas;
import com.example.lutemongame.Lutemon;
import com.example.lutemongame.MainActivity;
import com.example.lutemongame.R;

public class BattleFightActivity extends AppCompatActivity {
    ImageView lutemon1Image, lutemon1ImageSmall, lutemon2Image, playerLutemonImage, ability1Image, ability2Image, imageUseAbility1, imageDoge;
    TextView lutemon1Name, lutemon2Name, lutemon1Health, lutemon2Health;
    public static TextView txtWinner, txtLvlUp;
    Button inventory, btnReturn;
    ProgressBar progressBar1, progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fight_view);
        Lutemon lutemon1 = getBattleLutemons().get(0);
        Lutemon lutemon2 = getBattleLutemons().get(1);
        playerLutemonImage = findViewById(R.id.playerLutemonImage);
        ability1Image = findViewById(R.id.ability1Image);
        ability2Image = findViewById(R.id.ability2Image);
        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);
        lutemon1Health = findViewById(R.id.txtHP);
        lutemon2Health = findViewById(R.id.txtHP2);
        inventory = findViewById(R.id.btnInventory);
        lutemon1Name = findViewById(R.id.txtLutemon1Name);
        lutemon2Name = findViewById(R.id.txtLutemon2Name);
        lutemon1ImageSmall = findViewById(R.id.imageLutemon1Small);
        lutemon1Image = findViewById(R.id.playerLutemonImage);
        lutemon2Image = findViewById(R.id.imageLutemon2);
        btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setVisibility(View.GONE);
        txtWinner = findViewById(R.id.txtWinner);
        txtWinner.setVisibility(View.GONE);
        txtLvlUp = findViewById(R.id.txtLvlUp);
        txtLvlUp.setVisibility(View.GONE);
        imageUseAbility1 = findViewById(R.id.imgUseAblility1);
        imageUseAbility1.setVisibility(View.GONE);
        imageDoge = findViewById(R.id.imageDogeAttack);
        imageDoge.setVisibility(View.GONE);


        resetView(lutemon1, lutemon2);

        ability1Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationFart(lutemon2, lutemon1);
                ability1Image.setClickable(false);
                ability2Image.setClickable(false);
                inventory.setClickable(false);
                Boolean FightOver = CombatArenas.trainingArena(0);

                if (FightOver) {
                    btnReturn.setVisibility(View.VISIBLE);
                    txtWinner.setVisibility(View.VISIBLE);
                    ability1Image.setClickable(false);
                    ability2Image.setClickable(false);
                    lutemon1.setBattles(+1);
                    lutemon2.setBattles(+1);
                }
            }
        });


        ability2Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                animationDoge(lutemon2, lutemon1);
                ability1Image.setClickable(false);
                ability2Image.setClickable(false);
                inventory.setClickable(false);

                //calculating proggressbar status and health text
                Boolean FightOver = CombatArenas.trainingArena(1);

                if (FightOver) {
                    btnReturn.setVisibility(View.VISIBLE);
                    ability1Image.setClickable(false);
                    ability2Image.setClickable(false);
                    inventory.setClickable(false);
                    lutemon1.setBattles(+1);
                    lutemon2.setBattles(+1);


                }
            }
        });
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetView(lutemon1, lutemon2);
                Intent intent = new Intent(BattleFightActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }


    public int progressBarChange(int hp, int maxhp) {

        float percentageHP = ((float) hp / (float) maxhp) * 100;
        return Math.round(percentageHP);
    }

    public void resetView(Lutemon lutemon1, Lutemon lutemon2) {

        playerLutemonImage.setImageResource(lutemon1.getImage());
        ability1Image.setImageResource(R.drawable.meatmallet_transparent);
        if (lutemon1.getColor() == Lutemon.ColorType.WHITE) {
            ability2Image.setImageResource(R.drawable.poisonous_fart);
        } else if (lutemon1.getColor() == Lutemon.ColorType.GREEN) {
            ability2Image.setImageResource(R.drawable.awkward_stare);
        } else if (lutemon1.getColor() == Lutemon.ColorType.PINK) {
            ability2Image.setImageResource(R.drawable.fit_of_rage);
        } else if (lutemon1.getColor() == Lutemon.ColorType.ORANGE) {
            ability2Image.setImageResource(R.drawable.infectious_bite_of_syphilis);
        } else if (lutemon1.getColor() == Lutemon.ColorType.BLACK) {
            ability2Image.setImageResource(R.drawable.disruptive_meme);
        }

        //ability1Image.setImageResource(R.drawable.poisonous_fart);
        //ability2Image.setImageResource(R.drawable.awkward_stare);
        lutemon1Health.setText(lutemon1.getHealth() + "/" + lutemon1.getmaxHP());
        lutemon2Health.setText(lutemon2.getHealth() + "/" + lutemon2.getmaxHP());
        lutemon1Name.setText(lutemon1.getName());
        lutemon2Name.setText(lutemon2.getName());
        lutemon1Image.setImageResource(lutemon1.getImage());
        lutemon2Image.setImageResource(lutemon2.getImage());
        lutemon1ImageSmall.setImageResource(lutemon1.getImage());
        progressBar1.setProgress(100);
        progressBar2.setProgress(100);
        txtWinner.setText("Winner is");
    }

    public static void updateStats(Lutemon winner, Lutemon loser) {
        txtWinner.setText("Winner is " + winner.getName() + "!");
        if (winner.getColor() == Lutemon.ColorType.DUMMY || loser.getColor() == Lutemon.ColorType.DUMMY) {
            winner.setTrainingDays(+1);
            loser.setTrainingDays(+1);
        } else {
            winner.setBattles(+1);
            loser.setBattles(+1);
            winner.setVictories(+1);
            loser.setDefeats(+1);
        }
    }

    public static void levelUp(int oldLevel, int newLevel, String lutemonName){
        if (oldLevel!=newLevel){
            txtLvlUp.setVisibility(View.VISIBLE);
            txtLvlUp.setText(lutemonName+" Level has increased!\n"+lutemonName+" is now level "+newLevel);
        }
    }
    public void animationFart(Lutemon lutemon2, Lutemon lutemon1){
        //animating attacks for lutemon and opponent/dummy
        ImageView imageView = findViewById(R.id.imageLutemon1Small);
        Animation animationForward = new TranslateAnimation(0, 200, 0, -800);
        animationForward.setDuration(500);
        animationForward.setFillAfter(true);
        imageView.startAnimation(animationForward);

        animationForward.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {

                //waiting 1s after moving towards opponent
                Animation animationWait = new TranslateAnimation(200, 200, -800, -800);
                animationWait.setDuration(500);
                animationWait.setFillAfter(true);
                imageView.startAnimation(animationWait);
                animationWait.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        //showing attack image for 1s
                        imageUseAbility1.setVisibility(View.VISIBLE);
                    }
                    @Override
                    public void onAnimationEnd(Animation animation) {

                        //updating hp and progressbars
                        lutemon2Health.setText(lutemon2.getHealth()+"/"+lutemon2.getmaxHP());
                        progressBar2.setProgress(progressBarChange(lutemon2.getHealth(),lutemon2.getmaxHP()));
                        imageUseAbility1.setVisibility(View.GONE);

                        //moving back to start position
                        Animation animationBackward = new TranslateAnimation(200, 0, -800, 0);
                        animationBackward.setDuration(1000);
                        animationBackward.setFillAfter(true);
                        imageView.startAnimation(animationBackward);

                        animationBackward.setAnimationListener(new Animation.AnimationListener() {


                            @Override
                            public void onAnimationStart(Animation animation) {
                                imageUseAbility1.setVisibility(View.GONE);
                            }
                            @Override
                            public void onAnimationEnd(Animation animation) {
                                //starting opponent/dummys turn to attack
                                lutemon2Name.setVisibility(View.GONE);
                                //removing useless animation if opponent is already dead
                                if (lutemon2.getHealth() > 0) {
                                    animationPunch(lutemon1);
                                }
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });


                    }
                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
    public void animationPunch(Lutemon lutemon1) {

            ImageView imageView = findViewById(R.id.imageLutemon2);
            Animation animationForward = new TranslateAnimation(0, -300, 0, 900);
            animationForward.setDuration(500);
            imageView.startAnimation(animationForward);

            animationForward.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    ProgressBar imageViewHp = findViewById(R.id.progressBar2);
                    TextView imageViewTxt = findViewById(R.id.txtHP2);
                    Animation animationForwardHp = new TranslateAnimation(0, -300, 0, 900);
                    Animation animationForwardTxt = new TranslateAnimation(0, -300, 0, 900);
                    animationForwardHp.setDuration(500);
                    animationForwardTxt.setDuration(500);
                    animationForwardHp.setFillAfter(true);
                    animationForwardTxt.setFillAfter(true);
                    imageViewHp.startAnimation(animationForwardHp);
                    imageViewTxt.startAnimation(animationForwardTxt);
                }

                @Override
                public void onAnimationEnd(Animation animation) {

                    lutemon1Health.setText(lutemon1.getHealth() + "/" + lutemon1.getmaxHP());
                    progressBar1.setProgress(progressBarChange(lutemon1.getHealth(), lutemon1.getmaxHP()));

                    imageUseAbility1.setVisibility(View.GONE);
                    Animation animationBackward = new TranslateAnimation(-300, 0, 900, 0);
                    animationBackward.setDuration(1000);
                    animationBackward.setFillAfter(true);

                    ProgressBar imageViewHp = findViewById(R.id.progressBar2);
                    TextView imageViewTxt = findViewById(R.id.txtHP2);
                    Animation animationBackwardHp = new TranslateAnimation(-300, 0, 900, 0);
                    Animation animationBackwardTxt = new TranslateAnimation(-300, 0, 900, 0);
                    animationBackwardHp.setDuration(1000);
                    animationBackwardTxt.setDuration(1000);
                    animationBackwardHp.setFillAfter(true);
                    animationBackwardTxt.setFillAfter(true);
                    imageViewHp.startAnimation(animationBackwardHp);
                    imageViewTxt.startAnimation(animationBackwardTxt);
                    imageView.startAnimation(animationBackward);

                    animationBackward.setAnimationListener(new Animation.AnimationListener() {

                        @Override
                        public void onAnimationStart(Animation animation) {
                            imageUseAbility1.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            ability1Image.setClickable(true);
                            ability2Image.setClickable(true);
                            inventory.setClickable(true);
                            lutemon2Name.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                            // Animation repeated
                        }
                    });
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

        }

    public void animationDoge(Lutemon lutemon2, Lutemon lutemon1) {

        //animating attacks for lutemon and opponent/dummy

        lutemon1ImageSmall.setVisibility(View.GONE);
        ImageView imageViewLutemon1 = findViewById(R.id.imageLutemon1Small);

        Animation animationWait = new TranslateAnimation(0, 0, 0, 0);
        animationWait.setDuration(1000);
        animationWait.setFillAfter(true);
        imageViewLutemon1.startAnimation(animationWait);

        animationWait.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                lutemon1ImageSmall.setVisibility(View.GONE);
                imageDoge.setVisibility(View.VISIBLE);

                ImageView imageViewDoge = imageDoge;
                Animation animationDoge = new TranslateAnimation(0, 0, -1500, 0);
                animationDoge.setDuration(1000);
                animationDoge.setFillAfter(true);
                imageViewDoge.startAnimation(animationDoge);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                lutemon1ImageSmall.setVisibility(View.VISIBLE);

                ImageView imageViewDoge = imageDoge;
                AnimationSet animationSet = new AnimationSet(true);

                Animation animationMove = new TranslateAnimation(0, 0, 0, 0);
                animationMove.setDuration(1500);
                animationMove.setFillAfter(true);
                animationSet.addAnimation(animationMove);

                Animation animationFadeOut = new AlphaAnimation(1.0f, 0.0f);
                animationFadeOut.setDuration(1500);
                animationFadeOut.setFillAfter(true);
                animationSet.addAnimation(animationFadeOut);

                imageViewDoge.startAnimation(animationSet);
                animationSet.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        imageDoge.setVisibility(View.GONE);
                        lutemon1ImageSmall.setVisibility(View.VISIBLE);

                        //updating hp and progressbars
                        lutemon2Health.setText(lutemon2.getHealth() + "/" + lutemon2.getmaxHP());
                        progressBar2.setProgress(progressBarChange(lutemon2.getHealth(), lutemon2.getmaxHP()));
                        imageUseAbility1.setVisibility(View.GONE);
                        lutemon2Name.setVisibility(View.GONE);

                        //removing useless animation if opponent is already dead
                        if (lutemon2.getHealth() > 0) {
                            animationPunch(lutemon1);
                        }
                    }
                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do nothing
            }
        }, 500);
    }



}



