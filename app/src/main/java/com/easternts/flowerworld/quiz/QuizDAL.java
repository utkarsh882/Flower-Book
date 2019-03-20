package com.easternts.flowerworld.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.easternts.flowerworld.R;
import com.easternts.flowerworld.util.Utils;

import java.util.ArrayList;

/**
 * Created by SVF 15213 on 20-06-2016.
 */
public class QuizDAL {

    Context context;
    private SQLiteDatabase sqldb;

    private static final String DATABASE_NAME = "FLOWERS_DB";
    private static final int DATABASE_VERSION = 1;

    //Table-names
    private static final String TABLE_QUESTION = "question";
    private static final String TABLE_ANSWER = "answer";


    // Question Column
    private static final String KEY_ID = "_id";
    private static final String KEY_QUESTION = "question";
    private static final String KEY_TYPE = "type";
    private static final String KEY_RESOURCE = "resource";

    // Answer column names
    private static final String KEY_ANSWER = "answer";
    private static final String KEY_IS_CORRECT = "is_correct";
    private static final String KEY_QUESTION_ID = "question_id";

    public QuizDAL(Context context) {
        this.context = context;
    }

    public void openDB() throws SQLException{
        sqldb = new dbhelper(context).getWritableDatabase();
    }

    public void closeDB() throws SQLException{
        if (sqldb != null && sqldb.isOpen()) {
            sqldb.close();
        }
    }

    class dbhelper extends SQLiteOpenHelper {

        public dbhelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            // create tables
            quesTable(db);
            ansTable(db);

            insertQuesType1(db);//MCQ
            insertQuesType2(db);//Mul Image
            insertQuesType3(db);//Ans_blank
            insertQuesType4(db);//QUES IMAGE
            insertQuesType5(db);//Drag Drop
            insertQuesType6(db);//identify flower name
            insertQuesType7(db);//TrueFalse

            insertAnsType1(db);
            insertAnsType2(db);
            insertAnsType3(db);
            insertAnsType4(db);
            insertAnsType5(db);
            insertAnsType6(db);
            insertAnsType7(db);

        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
    private void quesTable( SQLiteDatabase db){

        db.execSQL(new StringBuilder().append("CREATE TABLE ")
                .append(TABLE_QUESTION).append(" ( ").append(KEY_ID)
                .append(" INTEGER PRIMARY KEY, ")
                .append(KEY_QUESTION).append(" INTEGER, ")
                .append(KEY_TYPE)
                .append(" INTEGER, ").append(KEY_RESOURCE)
                .append(" INTEGER ").append(" )").toString());
    }

    private void ansTable(SQLiteDatabase db){
        db.execSQL(new StringBuilder().append("CREATE TABLE ")
                .append(TABLE_ANSWER).append(" ( ").append(KEY_ID)
                .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(KEY_ANSWER).append(" INTEGER, ").append(KEY_TYPE)
                .append(" INTEGER, ").append(KEY_RESOURCE)
                .append(" INTEGER, ").append(KEY_IS_CORRECT)
                .append(" INTEGER, ").append(KEY_QUESTION_ID)
                .append(" INTEGER ").append(" )").toString());
    }

    private void insertQuesType1(SQLiteDatabase db){

        final int QUESTION_NO_1 = 1;
        final int QUESTION_NO_2 = 2;
        final int QUESTION_NO_3 = 3;
        final int QUESTION_NO_4 = 4;
        final int QUESTION_NO_5 = 5;
        final int QUESTION_NO_6 = 6;
        final int QUESTION_NO_7 = 7;
        final int QUESTION_NO_8 = 8;
        final int QUESTION_NO_9 = 9;
        final int QUESTION_NO_10 = 10;
        final int QUESTION_NO_11 = 11;
        final int QUESTION_NO_12 = 12;
        final int QUESTION_NO_13 = 13;
        final int QUESTION_NO_14 = 14;
        final int QUESTION_NO_15 = 15;
        final int QUESTION_NO_16 = 16;
        final int QUESTION_NO_17 = 17;
        final int QUESTION_NO_18 = 18;
        final int QUESTION_NO_19 = 19;
        final int QUESTION_NO_20 = 20;
        final int QUESTION_NO_21 = 21;
        final int QUESTION_NO_22 = 22;
        final int QUESTION_NO_23 = 23;
        final int QUESTION_NO_24 = 24;
        final int QUESTION_NO_25 = 25;
        final int QUESTION_NO_26 = 26;
        final int QUESTION_NO_27 = 27;
        final int QUESTION_NO_28 = 28;
        final int QUESTION_NO_29 = 29;
        final int QUESTION_NO_30 = 30;
        final int QUESTION_NO_31 = 31;
        final int QUESTION_NO_32 = 32;
        final int QUESTION_NO_33 = 33;
        final int QUESTION_NO_34 = 34;
        final int QUESTION_NO_35 = 35;
        final int QUESTION_NO_36 = 36;
        final int QUESTION_NO_37 = 37;
        final int QUESTION_NO_38 = 38;
        final int QUESTION_NO_39 = 39;
        final int QUESTION_NO_40 = 40;
        final int QUESTION_NO_41 = 41;
        final int QUESTION_NO_42 = 42;
        final int QUESTION_NO_43 = 43;
        final int QUESTION_NO_44 = 44;
        final int QUESTION_NO_45 = 45;
        final int QUESTION_NO_46 = 46;
        final int QUESTION_NO_47 = 47;
        final int QUESTION_NO_48 = 48;
        final int QUESTION_NO_49 = 49;
        final int QUESTION_NO_50 = 50;

        StringBuilder columnStringBuilder = new StringBuilder();
        columnStringBuilder.append(KEY_ID).append(", ").append(KEY_QUESTION).append(", ")
                .append(KEY_TYPE).append(", ").append(KEY_RESOURCE);


        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1).append(", ")
                .append(R.string.question_type1_1).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2).append(", ")
                .append(R.string.question_type1_2).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_3).append(", ")
                .append(R.string.question_type1_3).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_4).append(", ")
                .append(R.string.question_type1_4).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_5).append(", ")
                .append(R.string.question_type1_5).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_6).append(", ")
                .append(R.string.question_type1_6).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_7).append(", ")
                .append(R.string.question_type1_7).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_8).append(", ")
                .append(R.string.question_type1_8).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_9).append(", ")
                .append(R.string.question_type1_9).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_10).append(", ")
                .append(R.string.question_type1_10).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_11).append(", ")
                .append(R.string.question_type1_11).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_12).append(", ")
                .append(R.string.question_type1_12).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_13).append(", ")
                .append(R.string.question_type1_13).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_14).append(", ")
                .append(R.string.question_type1_14).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_15).append(", ")
                .append(R.string.question_type1_15).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_16).append(", ")
                .append(R.string.question_type1_16).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_17).append(", ")
                .append(R.string.question_type1_17).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_18).append(", ")
                .append(R.string.question_type1_18).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_19).append(", ")
                .append(R.string.question_type1_19).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_20).append(", ")
                .append(R.string.question_type1_20).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_21).append(", ")
                .append(R.string.question_type1_21).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_22).append(", ")
                .append(R.string.question_type1_22).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_23).append(", ")
                .append(R.string.question_type1_23).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_24).append(", ")
                .append(R.string.question_type1_24).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_25).append(", ")
                .append(R.string.question_type1_25).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_26).append(", ")
                .append(R.string.question_type1_26).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_27).append(", ")
                .append(R.string.question_type1_27).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_28).append(", ")
                .append(R.string.question_type1_28).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_29).append(", ")
                .append(R.string.question_type1_29).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_30).append(", ")
                .append(R.string.question_type1_30).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_31).append(", ")
                .append(R.string.question_type1_31).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_32).append(", ")
                .append(R.string.question_type1_32).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_33).append(", ")
                .append(R.string.question_type1_33).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_34).append(", ")
                .append(R.string.question_type1_34).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_35).append(", ")
                .append(R.string.question_type1_35).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_36).append(", ")
                .append(R.string.question_type1_36).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_37).append(", ")
                .append(R.string.question_type1_37).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_38).append(", ")
                .append(R.string.question_type1_38).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_39).append(", ")
                .append(R.string.question_type1_39).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_40).append(", ")
                .append(R.string.question_type1_40).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_41).append(", ")
                .append(R.string.question_type1_41).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_42).append(", ")
                .append(R.string.question_type1_42).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_43).append(", ")
                .append(R.string.question_type1_43).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_44).append(", ")
                .append(R.string.question_type1_44).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_45).append(", ")
                .append(R.string.question_type1_45).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_46).append(", ")
                .append(R.string.question_type1_46).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_47).append(", ")
                .append(R.string.question_type1_47).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_48).append(", ")
                .append(R.string.question_type1_48).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_49).append(", ")
                .append(R.string.question_type1_49).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_50).append(", ")
                .append(R.string.question_type1_50).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.MUL_OPTIONS).append(" )").toString());
    }

    private void insertQuesType2(SQLiteDatabase db){
        final int QUESTION_NO_501 = 501;
        final int QUESTION_NO_502 = 502;
        final int QUESTION_NO_503 = 503;
        final int QUESTION_NO_504 = 504;
        final int QUESTION_NO_505 = 505;
        final int QUESTION_NO_506 = 506;
        final int QUESTION_NO_507 = 507;
        final int QUESTION_NO_508 = 508;
        final int QUESTION_NO_509 = 509;
        final int QUESTION_NO_510 = 510;
        final int QUESTION_NO_511 = 511;
        final int QUESTION_NO_512 = 512;
        final int QUESTION_NO_513 = 513;
        final int QUESTION_NO_514 = 514;
        final int QUESTION_NO_515 = 515;
        final int QUESTION_NO_516 = 516;
        final int QUESTION_NO_517 = 517;
        final int QUESTION_NO_518 = 518;
        final int QUESTION_NO_519 = 519;
        final int QUESTION_NO_520 = 520;
        final int QUESTION_NO_521 = 521;
        final int QUESTION_NO_522 = 522;
        final int QUESTION_NO_523 = 523;
        final int QUESTION_NO_524 = 524;
        final int QUESTION_NO_525 = 525;
        final int QUESTION_NO_526 = 526;
        final int QUESTION_NO_527 = 527;
        final int QUESTION_NO_528 = 528;
        final int QUESTION_NO_529 = 529;
        final int QUESTION_NO_530 = 530;
        final int QUESTION_NO_531 = 531;
        final int QUESTION_NO_532 = 532;
        final int QUESTION_NO_533 = 533;
        final int QUESTION_NO_534 = 534;
        final int QUESTION_NO_535 = 535;
        final int QUESTION_NO_536 = 536;
        final int QUESTION_NO_537 = 537;
        final int QUESTION_NO_538 = 538;
        final int QUESTION_NO_539 = 539;
        final int QUESTION_NO_540 = 540;
        final int QUESTION_NO_541 = 541;
        final int QUESTION_NO_542 = 542;
        final int QUESTION_NO_543 = 543;
        final int QUESTION_NO_544 = 544;
        final int QUESTION_NO_545 = 545;
        final int QUESTION_NO_546 = 546;
        final int QUESTION_NO_547 = 547;
        final int QUESTION_NO_548 = 548;
        final int QUESTION_NO_549 = 549;
        final int QUESTION_NO_550 = 550;
        final int QUESTION_NO_551 = 551;
        final int QUESTION_NO_552 = 552;
        final int QUESTION_NO_553 = 553;
        final int QUESTION_NO_554 = 554;
        final int QUESTION_NO_555 = 555;
        final int QUESTION_NO_556 = 556;
        final int QUESTION_NO_557 = 557;
        final int QUESTION_NO_558 = 558;
        final int QUESTION_NO_559 = 559;
        final int QUESTION_NO_560 = 560;
        final int QUESTION_NO_561 = 561;
        final int QUESTION_NO_562 = 562;
        final int QUESTION_NO_563 = 563;
        final int QUESTION_NO_564 = 564;
        final int QUESTION_NO_565 = 565;
        final int QUESTION_NO_566 = 566;
        final int QUESTION_NO_567 = 567;
        final int QUESTION_NO_568 = 568;
        final int QUESTION_NO_569 = 569;
        final int QUESTION_NO_570 = 570;
        final int QUESTION_NO_571 = 571;
        final int QUESTION_NO_572 = 572;
        final int QUESTION_NO_573 = 573;
        final int QUESTION_NO_574 = 574;
        final int QUESTION_NO_575 = 575;
        final int QUESTION_NO_576 = 576;
        final int QUESTION_NO_577 = 577;
        final int QUESTION_NO_578 = 578;
        final int QUESTION_NO_579 = 579;
        final int QUESTION_NO_580 = 580;
        final int QUESTION_NO_581 = 581;
        final int QUESTION_NO_582 = 582;
        final int QUESTION_NO_583 = 583;
        final int QUESTION_NO_584 = 584;
        final int QUESTION_NO_585 = 585;
        final int QUESTION_NO_586 = 586;
        final int QUESTION_NO_587 = 587;
        final int QUESTION_NO_588 = 588;
        final int QUESTION_NO_589 = 589;
        final int QUESTION_NO_590 = 590;
        final int QUESTION_NO_591 = 591;
        final int QUESTION_NO_592 = 592;
        final int QUESTION_NO_593 = 593;
        final int QUESTION_NO_594 = 594;
        final int QUESTION_NO_595 = 595;
        final int QUESTION_NO_596 = 596;
        final int QUESTION_NO_597 = 597;
        final int QUESTION_NO_598 = 598;
        final int QUESTION_NO_599 = 599;
        final int QUESTION_NO_600 = 600;

        StringBuilder columnStringBuilder = new StringBuilder();
        columnStringBuilder.append(KEY_ID).append(", ").append(KEY_QUESTION).append(", ")
                .append(KEY_TYPE).append(", ").append(KEY_RESOURCE);

        //type2
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_501).append(", ")
                .append(R.string.question_type2_1).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_502).append(", ")
                .append(R.string.question_type2_2).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_503).append(", ")
                .append(R.string.question_type2_3).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_504).append(", ")
                .append(R.string.question_type2_4).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_505).append(", ")
                .append(R.string.question_type2_5).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_506).append(", ")
                .append(R.string.question_type2_6).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_507).append(", ")
                .append(R.string.question_type2_7).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_508).append(", ")
                .append(R.string.question_type2_8).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_509).append(", ")
                .append(R.string.question_type2_9).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_510).append(", ")
                .append(R.string.question_type2_10).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_511).append(", ")
                .append(R.string.question_type2_11).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_512).append(", ")
                .append(R.string.question_type2_12).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_513).append(", ")
                .append(R.string.question_type2_13).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_514).append(", ")
                .append(R.string.question_type2_14).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_515).append(", ")
                .append(R.string.question_type2_15).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_516).append(", ")
                .append(R.string.question_type2_16).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_517).append(", ")
                .append(R.string.question_type2_17).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_518).append(", ")
                .append(R.string.question_type2_18).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_519).append(", ")
                .append(R.string.question_type2_19).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_520).append(", ")
                .append(R.string.question_type2_20).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_521).append(", ")
                .append(R.string.question_type2_21).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_522).append(", ")
                .append(R.string.question_type2_22).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_523).append(", ")
                .append(R.string.question_type2_23).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_524).append(", ")
                .append(R.string.question_type2_24).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_525).append(", ")
                .append(R.string.question_type2_25).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_526).append(", ")
                .append(R.string.question_type2_26).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_527).append(", ")
                .append(R.string.question_type2_27).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_528).append(", ")
                .append(R.string.question_type2_28).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_529).append(", ")
                .append(R.string.question_type2_29).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_530).append(", ")
                .append(R.string.question_type2_30).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_531).append(", ")
                .append(R.string.question_type2_31).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_532).append(", ")
                .append(R.string.question_type2_32).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_533).append(", ")
                .append(R.string.question_type2_33).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_534).append(", ")
                .append(R.string.question_type2_34).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_535).append(", ")
                .append(R.string.question_type2_35).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_536).append(", ")
                .append(R.string.question_type2_36).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_537).append(", ")
                .append(R.string.question_type2_37).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_538).append(", ")
                .append(R.string.question_type2_38).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_539).append(", ")
                .append(R.string.question_type2_39).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_540).append(", ")
                .append(R.string.question_type2_40).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_541).append(", ")
                .append(R.string.question_type2_41).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_542).append(", ")
                .append(R.string.question_type2_42).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_543).append(", ")
                .append(R.string.question_type2_43).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_544).append(", ")
                .append(R.string.question_type2_44).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_545).append(", ")
                .append(R.string.question_type2_45).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_546).append(", ")
                .append(R.string.question_type2_46).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_547).append(", ")
                .append(R.string.question_type2_47).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_548).append(", ")
                .append(R.string.question_type2_48).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_549).append(", ")
                .append(R.string.question_type2_49).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_550).append(", ")
                .append(R.string.question_type2_50).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_551).append(", ")
                .append(R.string.question_type2_51).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_552).append(", ")
                .append(R.string.question_type2_52).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_553).append(", ")
                .append(R.string.question_type2_53).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_554).append(", ")
                .append(R.string.question_type2_54).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_555).append(", ")
                .append(R.string.question_type2_55).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_556).append(", ")
                .append(R.string.question_type2_56).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_557).append(", ")
                .append(R.string.question_type2_57).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_558).append(", ")
                .append(R.string.question_type2_58).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_559).append(", ")
                .append(R.string.question_type2_59).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_560).append(", ")
                .append(R.string.question_type2_60).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_561).append(", ")
                .append(R.string.question_type2_61).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_562).append(", ")
                .append(R.string.question_type2_62).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_563).append(", ")
                .append(R.string.question_type2_63).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_564).append(", ")
                .append(R.string.question_type2_64).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_565).append(", ")
                .append(R.string.question_type2_65).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_566).append(", ")
                .append(R.string.question_type2_66).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_567).append(", ")
                .append(R.string.question_type2_67).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_568).append(", ")
                .append(R.string.question_type2_68).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_569).append(", ")
                .append(R.string.question_type2_69).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_570).append(", ")
                .append(R.string.question_type2_70).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_571).append(", ")
                .append(R.string.question_type2_71).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_572).append(", ")
                .append(R.string.question_type2_72).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_573).append(", ")
                .append(R.string.question_type2_73).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_574).append(", ")
                .append(R.string.question_type2_74).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_575).append(", ")
                .append(R.string.question_type2_75).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_576).append(", ")
                .append(R.string.question_type2_76).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_577).append(", ")
                .append(R.string.question_type2_77).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_578).append(", ")
                .append(R.string.question_type2_78).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_579).append(", ")
                .append(R.string.question_type2_79).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_580).append(", ")
                .append(R.string.question_type2_80).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_581).append(", ")
                .append(R.string.question_type2_81).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_582).append(", ")
                .append(R.string.question_type2_82).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_583).append(", ")
                .append(R.string.question_type2_83).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_584).append(", ")
                .append(R.string.question_type2_84).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_585).append(", ")
                .append(R.string.question_type2_85).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_586).append(", ")
                .append(R.string.question_type2_86).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_587).append(", ")
                .append(R.string.question_type2_87).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_588).append(", ")
                .append(R.string.question_type2_88).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_589).append(", ")
                .append(R.string.question_type2_89).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_590).append(", ")
                .append(R.string.question_type2_90).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_591).append(", ")
                .append(R.string.question_type2_91).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_592).append(", ")
                .append(R.string.question_type2_92).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_593).append(", ")
                .append(R.string.question_type2_93).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_594).append(", ")
                .append(R.string.question_type2_94).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_595).append(", ")
                .append(R.string.question_type2_95).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_596).append(", ")
                .append(R.string.question_type2_96).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_597).append(", ")
                .append(R.string.question_type2_97).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_598).append(", ")
                .append(R.string.question_type2_98).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_599).append(", ")
                .append(R.string.question_type2_99).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_600).append(", ")
                .append(R.string.question_type2_100).append(", ")
                .append(Utils.TYPE_IMAGE).append(", ")
                .append(Utils.MUL_IMAGE).append(" )").toString());
    }

    private void insertQuesType3(SQLiteDatabase db){

        final int QUESTION_NO_5001 = 5001;
        final int QUESTION_NO_5002 = 5002;
        final int QUESTION_NO_5003 = 5003;
        final int QUESTION_NO_5004 = 5004;
        final int QUESTION_NO_5005 = 5005;

        StringBuilder columnStringBuilder = new StringBuilder();
        columnStringBuilder.append(KEY_ID).append(", ").append(KEY_QUESTION).append(", ")
                .append(KEY_TYPE).append(", ").append(KEY_RESOURCE);

        //type3
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_5001).append(", ")
                .append(R.string.question_type3_1).append(", ")
                .append(Utils.TYPE_BLANK).append(", ")
                .append(Utils.TEXT).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_5002).append(", ")
                .append(R.string.question_type3_2).append(", ")
                .append(Utils.TYPE_BLANK).append(", ")
                .append(Utils.TEXT).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_5003).append(", ")
                .append(R.string.question_type3_3).append(", ")
                .append(Utils.TYPE_BLANK).append(", ")
                .append(Utils.TEXT).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_5004).append(", ")
                .append(R.string.question_type3_4).append(", ")
                .append(Utils.TYPE_BLANK).append(", ")
                .append(Utils.TEXT).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_5005).append(", ")
                .append(R.string.question_type3_5).append(", ")
                .append(Utils.TYPE_BLANK).append(", ")
                .append(Utils.TEXT).append(" )").toString());
    }

    private void insertQuesType4(SQLiteDatabase db){

        final int QUESTION_NO_1001 = 1001;
        final int QUESTION_NO_1002 = 1002;
        final int QUESTION_NO_1003 = 1003;
        final int QUESTION_NO_1004 = 1004;
        final int QUESTION_NO_1005 = 1005;
        final int QUESTION_NO_1006 = 1006;
        final int QUESTION_NO_1007 = 1007;
        final int QUESTION_NO_1008 = 1008;
        final int QUESTION_NO_1009 = 1009;
        final int QUESTION_NO_1010 = 1010;
        final int QUESTION_NO_1011 = 1011;
        final int QUESTION_NO_1012 = 1012;
        final int QUESTION_NO_1013 = 1013;
        final int QUESTION_NO_1014 = 1014;
        final int QUESTION_NO_1015 = 1015;
        final int QUESTION_NO_1016 = 1016;
        final int QUESTION_NO_1017 = 1017;
        final int QUESTION_NO_1018 = 1018;
        final int QUESTION_NO_1019 = 1019;
        final int QUESTION_NO_1020 = 1020;
        final int QUESTION_NO_1021 = 1021;
        final int QUESTION_NO_1022 = 1022;
        final int QUESTION_NO_1023 = 1023;
        final int QUESTION_NO_1024 = 1024;
        final int QUESTION_NO_1025 = 1025;
        final int QUESTION_NO_1026 = 1026;
        final int QUESTION_NO_1027 = 1027;
        final int QUESTION_NO_1028 = 1028;
        final int QUESTION_NO_1029 = 1029;
        final int QUESTION_NO_1030 = 1030;
        final int QUESTION_NO_1031 = 1031;
        final int QUESTION_NO_1032 = 1032;
        final int QUESTION_NO_1033 = 1033;
        final int QUESTION_NO_1034 = 1034;
        final int QUESTION_NO_1035 = 1035;
        final int QUESTION_NO_1036 = 1036;
        final int QUESTION_NO_1037 = 1037;
        final int QUESTION_NO_1038 = 1038;
        final int QUESTION_NO_1039 = 1039;
        final int QUESTION_NO_1040 = 1040;
        final int QUESTION_NO_1041 = 1041;
        final int QUESTION_NO_1042 = 1042;
        final int QUESTION_NO_1043 = 1043;
        final int QUESTION_NO_1044 = 1044;
        final int QUESTION_NO_1045 = 1045;
        final int QUESTION_NO_1046 = 1046;
        final int QUESTION_NO_1047 = 1047;
        final int QUESTION_NO_1048 = 1048;
        final int QUESTION_NO_1049 = 1049;
        final int QUESTION_NO_1050 = 1050;
        final int QUESTION_NO_1051 = 1051;
        final int QUESTION_NO_1052 = 1052;
        final int QUESTION_NO_1053 = 1053;
        final int QUESTION_NO_1054 = 1054;
        final int QUESTION_NO_1055 = 1055;
        final int QUESTION_NO_1056 = 1056;
        final int QUESTION_NO_1057 = 1057;
        final int QUESTION_NO_1058 = 1058;
        final int QUESTION_NO_1059 = 1059;
        final int QUESTION_NO_1060 = 1060;
        final int QUESTION_NO_1061 = 1061;
        final int QUESTION_NO_1062 = 1062;
        final int QUESTION_NO_1063 = 1063;
        final int QUESTION_NO_1064 = 1064;
        final int QUESTION_NO_1065 = 1065;
        final int QUESTION_NO_1066 = 1066;
        final int QUESTION_NO_1067 = 1067;
        final int QUESTION_NO_1068 = 1068;
        final int QUESTION_NO_1069 = 1069;
        final int QUESTION_NO_1070 = 1070;
        final int QUESTION_NO_1071 = 1071;
        final int QUESTION_NO_1072 = 1072;
        final int QUESTION_NO_1073 = 1073;
        final int QUESTION_NO_1074 = 1074;
        final int QUESTION_NO_1075 = 1075;
        final int QUESTION_NO_1076 = 1076;
        final int QUESTION_NO_1077 = 1077;
        final int QUESTION_NO_1078 = 1078;
        final int QUESTION_NO_1079 = 1079;
        final int QUESTION_NO_1080 = 1080;
        final int QUESTION_NO_1081 = 1081;
        final int QUESTION_NO_1082 = 1082;
        final int QUESTION_NO_1083 = 1083;
        final int QUESTION_NO_1084 = 1084;
        final int QUESTION_NO_1085 = 1085;

        StringBuilder columnStringBuilder = new StringBuilder();
        columnStringBuilder.append(KEY_ID).append(", ").append(KEY_QUESTION).append(", ")
                .append(KEY_TYPE).append(", ").append(KEY_RESOURCE);

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1001).append(", ")
                .append(R.string.question_type4_1).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.asiatic_lily).append(" )").toString());


        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1002).append(", ")
                .append(R.string.question_type4_2).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.bee_orchid).append(" )").toString());


        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1003).append(", ")
                .append(R.string.question_type4_3).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.bicolor_alyce_clover).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1004).append(", ")
                .append(R.string.question_type4_4).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.blue_feltwort).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1005).append(", ")
                .append(R.string.question_type4_5).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.blue_poppy).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1006).append(", ")
                .append(R.string.question_type4_6).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.blue_vanda).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1007).append(", ")
                .append(R.string.question_type4_7).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.calico_flower).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1008).append(", ")
                .append(R.string.question_type4_8).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.chilean_bell_flower).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.question_type4_9).append(", ")
                .append(QUESTION_NO_1009).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.drumstick_primrose).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1010).append(", ")
                .append(R.string.question_type4_10).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.dwarf_powder_puff).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1011).append(", ")
                .append(R.string.question_type4_11).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.flax).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1012).append(", ")
                .append(R.string.question_type4_12).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.fringed_iris).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1013).append(", ")
                .append(R.string.question_type4_13).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.globe_primrose).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1014).append(", ")
                .append(R.string.question_type4_14).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.golden_arch_dendrobium).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1015).append(", ")
                .append(R.string.question_type4_15).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.golden_eyed_primrose).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1016).append(", ")
                .append(R.string.question_type4_16).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.graceful_himalayan_iris).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1017).append(", ")
                .append(R.string.question_type4_17).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.hairy_root_luisia).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1018).append(", ")
                .append(R.string.question_type4_18).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.himalayan_aster).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1019).append(", ")
                .append(R.string.question_type4_19).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.hugel_s_gentian).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1020).append(", ")
                .append(R.string.question_type4_20).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.hungarian_black_chilli).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1021).append(", ")
                .append(R.string.question_type4_21).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.hungarian_iris).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1022).append(", ")
                .append(R.string.question_type4_22).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.johnson_s_amaryllis).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1023).append(", ")
                .append(R.string.question_type4_23).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.kanpet).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1024).append(", ")
                .append(R.string.question_type4_24).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.long_flower_barleria).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1025).append(", ")
                .append(R.string.question_type4_25).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.malabar_hill_borage).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1026).append(", ")
                .append(R.string.question_type4_26).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.mountain_hydrangea).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1027).append(", ")
                .append(R.string.question_type4_27).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.mountain_rose).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1028).append(", ")
                .append(R.string.question_type4_28).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.peruvian_lily).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1029).append(", ")
                .append(R.string.question_type4_29).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.princess_flower).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1030).append(", ")
                .append(R.string.question_type4_30).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.queen_crape_myrtle).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1031).append(", ")
                .append(R.string.question_type4_31).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.red_vanda).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1032).append(", ")
                .append(R.string.question_type4_32).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.red_water_lily).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1033).append(", ")
                .append(R.string.question_type4_33).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.river_anemone).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1034).append(", ")
                .append(R.string.question_type4_34).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.shoofly_plant).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1035).append(", ")
                .append(R.string.question_type4_35).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.trailing_geranium).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1036).append(", ")
                .append(R.string.question_type4_36).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.tulip_tree).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1037).append(", ")
                .append(R.string.question_type4_37).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.yellow_waterlily).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1038).append(", ")
                .append(R.string.question_type4_38).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.chameleon_plant).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1039).append(", ")
                .append(R.string.question_type4_39).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.five_leaf_yam).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1040).append(", ")
                .append(R.string.question_type4_40).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.green_taro).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1041).append(", ")
                .append(R.string.question_type4_41).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.long_flowered_spider_lily).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1042).append(", ")
                .append(R.string.question_type4_42).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.long_leaf_pondweed).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1043).append(", ")
                .append(R.string.question_type4_43).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.bitter_nutmeg).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1044).append(", ")
                .append(R.string.question_type4_44).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.campbell_s_magnolia).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1045).append(", ")
                .append(R.string.question_type4_45).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.hard_fruit_alphonsea).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1046).append(", ")
                .append(R.string.question_type4_46).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.malabar_nutmeg).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1047).append(", ")
                .append(R.string.question_type4_47).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.pond_apple).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1048).append(", ")
                .append(R.string.question_type4_48).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.tulip_tree).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1049).append(", ")
                .append(R.string.question_type4_49).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.beej_karela).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1050).append(", ")
                .append(R.string.question_type4_50).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.cheerful_senecio).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1051).append(", ")
                .append(R.string.question_type4_51).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.himalayan_indigo).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1052).append(", ")
                .append(R.string.question_type4_52).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.indian_oreorchis).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1053).append(", ")
                .append(R.string.question_type4_53).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.kumaon_iris).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1054).append(", ")
                .append(R.string.question_type4_54).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.kut).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1055).append(", ")
                .append(R.string.question_type4_55).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.tall_alplily).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1056).append(", ")
                .append(R.string.question_type4_56).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.trifid_sedum).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1057).append(", ")
                .append(R.string.question_type4_57).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.wallich_s_myriactis).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1058).append(", ")
                .append(R.string.question_type4_58).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.wights_myriactis).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1059).append(", ")
                .append(R.string.question_type4_59).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.yellow_coralroot).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1060).append(", ")
                .append(R.string.question_type4_60).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.yellow_spotted_white_saxifrage).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1061).append(", ")
                .append(R.string.question_type4_61).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.banana_passion_flower).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1062).append(", ")
                .append(R.string.question_type4_62).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.candy_corn_plant).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1063).append(", ")
                .append(R.string.question_type4_63).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.glory_lily).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1064).append(", ")
                .append(R.string.question_type4_64).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.helmet_pepper).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1065).append(", ")
                .append(R.string.question_type4_65).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.love_in_a_mist).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1066).append(", ")
                .append(R.string.question_type4_66).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.maloo_creeper).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1067).append(", ")
                .append(R.string.question_type4_67).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.puncture_vine).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1068).append(", ")
                .append(R.string.question_type4_68).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.purple_passion_flower).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1069).append(", ")
                .append(R.string.question_type4_69).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.ragi).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1070).append(", ")
                .append(R.string.question_type4_70).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.spurred_butterfly_pea).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1071).append(", ")
                .append(R.string.question_type4_71).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.corn_cockle).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1072).append(", ")
                .append(R.string.question_type4_72).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.grape_leaf_wood_rose).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1073).append(", ")
                .append(R.string.question_type4_73).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.nilofar).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1074).append(", ")
                .append(R.string.question_type4_74).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.peach_angel_s_trumpet).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1075).append(", ")
                .append(R.string.question_type4_75).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.prickly_waterlily).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1076).append(", ")
                .append(R.string.question_type4_76).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.purple_heart_glory).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1077).append(", ")
                .append(R.string.question_type4_77).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.railway_creeper).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1078).append(", ")
                .append(R.string.question_type4_78).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.water_morning_glory).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1079).append(", ")
                .append(R.string.question_type4_79).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.yellow_pond_lily).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1080).append(", ")
                .append(R.string.question_type4_80).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.yellow_waterlily).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1081).append(", ")
                .append(R.string.question_type4_81).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.acampe_orchid).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1082).append(", ")
                .append(R.string.question_type4_82).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.ascocenda_krailerk_alba).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1083).append(", ")
                .append(R.string.question_type4_83).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.bamboo_orchid).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1084).append(", ")
                .append(R.string.question_type4_84).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.curled_aerides).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1085).append(", ")
                .append(R.string.question_type4_85).append(", ")
                .append(Utils.TYPE_QUES_IMAGE).append(", ")
                .append(R.drawable.fox_brush_orchid).append(" )").toString());

    }

    private void insertQuesType5(SQLiteDatabase db){

        final int QUESTION_NO_1501 = 1501;
        final int QUESTION_NO_1502 = 1502;
        final int QUESTION_NO_1503 = 1503;
        final int QUESTION_NO_1504 = 1504;
        final int QUESTION_NO_1505 = 1505;
        final int QUESTION_NO_1506 = 1506;
        final int QUESTION_NO_1507 = 1507;
        final int QUESTION_NO_1508 = 1508;
        final int QUESTION_NO_1509 = 1509;
        final int QUESTION_NO_1510 = 1510;
        final int QUESTION_NO_1511 = 1511;
        final int QUESTION_NO_1512 = 1512;
        final int QUESTION_NO_1513 = 1513;
        final int QUESTION_NO_1514 = 1514;
        final int QUESTION_NO_1515 = 1515;
        final int QUESTION_NO_1516 = 1516;
        final int QUESTION_NO_1517 = 1517;
        final int QUESTION_NO_1518 = 1518;
        final int QUESTION_NO_1519 = 1519;
        final int QUESTION_NO_1520 = 1520;
        final int QUESTION_NO_1521 = 1521;
        final int QUESTION_NO_1522 = 1522;
        final int QUESTION_NO_1523 = 1523;
        final int QUESTION_NO_1524 = 1524;
        final int QUESTION_NO_1525 = 1525;
        final int QUESTION_NO_1526 = 1526;
        final int QUESTION_NO_1527 = 1527;
        final int QUESTION_NO_1528 = 1528;
        final int QUESTION_NO_1529 = 1529;
        final int QUESTION_NO_1530 = 1530;
        final int QUESTION_NO_1531 = 1531;
        final int QUESTION_NO_1532 = 1532;
        final int QUESTION_NO_1533 = 1533;
        final int QUESTION_NO_1534 = 1534;
        final int QUESTION_NO_1535 = 1535;
        final int QUESTION_NO_1536 = 1536;
        final int QUESTION_NO_1537 = 1537;
        final int QUESTION_NO_1538 = 1538;
        final int QUESTION_NO_1539 = 1539;
        final int QUESTION_NO_1540 = 1540;
        final int QUESTION_NO_1541 = 1541;
        final int QUESTION_NO_1542 = 1542;
        final int QUESTION_NO_1543 = 1543;
        final int QUESTION_NO_1544 = 1544;
        final int QUESTION_NO_1545 = 1545;
        final int QUESTION_NO_1546 = 1546;
        final int QUESTION_NO_1547 = 1547;
        final int QUESTION_NO_1548 = 1548;
        final int QUESTION_NO_1549 = 1549;
        final int QUESTION_NO_1550 = 1550;
        final int QUESTION_NO_1551 = 1551;
        final int QUESTION_NO_1552 = 1552;
        final int QUESTION_NO_1553 = 1553;
        final int QUESTION_NO_1554 = 1554;
        final int QUESTION_NO_1555 = 1555;
        final int QUESTION_NO_1556 = 1556;
        final int QUESTION_NO_1557 = 1557;
        final int QUESTION_NO_1558 = 1558;
        final int QUESTION_NO_1559 = 1559;
        final int QUESTION_NO_1560 = 1560;
        final int QUESTION_NO_1561 = 1561;
        final int QUESTION_NO_1562 = 1562;
        final int QUESTION_NO_1563 = 1563;
        final int QUESTION_NO_1564 = 1564;
        final int QUESTION_NO_1565 = 1565;
        final int QUESTION_NO_1566 = 1566;
        final int QUESTION_NO_1567 = 1567;
        final int QUESTION_NO_1568 = 1568;
        final int QUESTION_NO_1569 = 1569;
        final int QUESTION_NO_1570 = 1570;
        final int QUESTION_NO_1571 = 1571;
        final int QUESTION_NO_1572 = 1572;
        final int QUESTION_NO_1573 = 1573;
        final int QUESTION_NO_1574 = 1574;
        final int QUESTION_NO_1575 = 1575;
        final int QUESTION_NO_1576 = 1576;
        final int QUESTION_NO_1577 = 1577;
        final int QUESTION_NO_1578 = 1578;
        final int QUESTION_NO_1579 = 1579;
        final int QUESTION_NO_1580 = 1580;
        final int QUESTION_NO_1581 = 1581;
        final int QUESTION_NO_1582 = 1582;
        final int QUESTION_NO_1583 = 1583;
        final int QUESTION_NO_1584 = 1584;
        final int QUESTION_NO_1585 = 1585;
        final int QUESTION_NO_1586 = 1586;
        final int QUESTION_NO_1587 = 1587;
        final int QUESTION_NO_1588 = 1588;
        final int QUESTION_NO_1589 = 1589;
        final int QUESTION_NO_1590 = 1590;
        final int QUESTION_NO_1591 = 1591;
        final int QUESTION_NO_1592 = 1592;
        final int QUESTION_NO_1593 = 1593;
        final int QUESTION_NO_1594 = 1594;
        final int QUESTION_NO_1595 = 1595;
        final int QUESTION_NO_1596 = 1596;
        final int QUESTION_NO_1597 = 1597;
        final int QUESTION_NO_1598 = 1598;
        final int QUESTION_NO_1599 = 1599;
        final int QUESTION_NO_1600 = 1600;
        final int QUESTION_NO_1601 = 1601;
        final int QUESTION_NO_1602 = 1602;
        final int QUESTION_NO_1603 = 1603;
        final int QUESTION_NO_1604 = 1604;
        final int QUESTION_NO_1605 = 1605;
        final int QUESTION_NO_1606 = 1606;
        final int QUESTION_NO_1607 = 1607;
        final int QUESTION_NO_1608 = 1608;
        final int QUESTION_NO_1609 = 1609;
        final int QUESTION_NO_1610 = 1610;
        final int QUESTION_NO_1611 = 1611;
        final int QUESTION_NO_1612 = 1612;
        final int QUESTION_NO_1613 = 1613;
        final int QUESTION_NO_1614 = 1614;
        final int QUESTION_NO_1615 = 1615;
        final int QUESTION_NO_1616 = 1616;
        final int QUESTION_NO_1617 = 1617;
        final int QUESTION_NO_1618 = 1618;
        final int QUESTION_NO_1619 = 1619;
        final int QUESTION_NO_1620 = 1620;
        final int QUESTION_NO_1621 = 1621;
        final int QUESTION_NO_1622 = 1622;
        final int QUESTION_NO_1623 = 1623;
        final int QUESTION_NO_1624 = 1624;
        final int QUESTION_NO_1625 = 1625;
        final int QUESTION_NO_1626 = 1626;
        final int QUESTION_NO_1627 = 1627;
        final int QUESTION_NO_1628 = 1628;
        final int QUESTION_NO_1629 = 1629;
        final int QUESTION_NO_1630 = 1630;
        final int QUESTION_NO_1631 = 1631;
        final int QUESTION_NO_1632 = 1632;
        final int QUESTION_NO_1633 = 1633;
        final int QUESTION_NO_1634 = 1634;
        final int QUESTION_NO_1635 = 1635;
        final int QUESTION_NO_1636 = 1636;
        final int QUESTION_NO_1637 = 1637;
        final int QUESTION_NO_1638 = 1638;
        final int QUESTION_NO_1639 = 1639;
        final int QUESTION_NO_1640 = 1640;
        final int QUESTION_NO_1641 = 1641;
        final int QUESTION_NO_1642 = 1642;
        final int QUESTION_NO_1643 = 1643;
        final int QUESTION_NO_1644 = 1644;
        final int QUESTION_NO_1645 = 1645;
        final int QUESTION_NO_1646 = 1646;
        final int QUESTION_NO_1647 = 1647;
        final int QUESTION_NO_1648 = 1648;
        final int QUESTION_NO_1649 = 1649;
        final int QUESTION_NO_1650 = 1650;

        StringBuilder columnStringBuilder = new StringBuilder();
        columnStringBuilder.append(KEY_ID).append(", ").append(KEY_QUESTION).append(", ")
                .append(KEY_TYPE).append(", ").append(KEY_RESOURCE);

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1501).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1502).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1503).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1504).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1505).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1506).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1507).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1508).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1509).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1510).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1511).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1512).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1513).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1514).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1515).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1516).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1517).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1518).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1519).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1520).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1521).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1522).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1523).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1524).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1525).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1526).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1527).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1528).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1529).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1530).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1531).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1532).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1533).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1534).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1535).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1536).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1537).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1538).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1539).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1540).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1541).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1542).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1543).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1544).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1545).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1546).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1547).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1548).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1549).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1550).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());


        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1551).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1552).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1553).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1554).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1555).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1556).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1557).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1558).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1559).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1560).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1561).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1562).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1563).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1564).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1565).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1566).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1567).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1568).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1569).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1570).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1571).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1572).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1573).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1574).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1575).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1576).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1577).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1578).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1579).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1580).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1581).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1582).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1583).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1584).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1585).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1586).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1587).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1588).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1589).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1590).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1591).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1592).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1593).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1594).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1595).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1596).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1597).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1598).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1599).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1600).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1601).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1602).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1603).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1604).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1605).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1606).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1607).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1608).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1609).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1610).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1611).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1612).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1613).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1614).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1615).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1616).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1617).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1618).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1619).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1620).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1621).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1622).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1623).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1624).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1625).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1626).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1627).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1628).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1629).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1630).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1631).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1632).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1633).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1634).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1635).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1636).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1637).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1638).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1639).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1640).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1641).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1642).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1643).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1644).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1645).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1646).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1647).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1648).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1649).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_1650).append(", ")
                .append(R.string.question_dragndrop).append(", ")
                .append(Utils.TYPE_DRAGDROP).append(", ")
                .append(Utils.NULL).append(" )").toString());
    }

    private void insertQuesType6(SQLiteDatabase db){
        final int QUESTION_NO_2001 = 2001;
        final int QUESTION_NO_2002 = 2002;
        final int QUESTION_NO_2003 = 2003;
        final int QUESTION_NO_2004 = 2004;
        final int QUESTION_NO_2005 = 2005;
        final int QUESTION_NO_2006 = 2006;
        final int QUESTION_NO_2007 = 2007;
        final int QUESTION_NO_2008 = 2008;
        final int QUESTION_NO_2009 = 2009;
        final int QUESTION_NO_2010 = 2010;
        final int QUESTION_NO_2011 = 2011;
        final int QUESTION_NO_2012 = 2012;
        final int QUESTION_NO_2013 = 2013;
        final int QUESTION_NO_2014 = 2014;
        final int QUESTION_NO_2015 = 2015;
        final int QUESTION_NO_2016 = 2016;
        final int QUESTION_NO_2017 = 2017;
        final int QUESTION_NO_2018 = 2018;
        final int QUESTION_NO_2019 = 2019;
        final int QUESTION_NO_2020 = 2020;
        final int QUESTION_NO_2021 = 2021;
        final int QUESTION_NO_2022 = 2022;
        final int QUESTION_NO_2023 = 2023;
        final int QUESTION_NO_2024 = 2024;
        final int QUESTION_NO_2025 = 2025;
        final int QUESTION_NO_2026 = 2026;
        final int QUESTION_NO_2027 = 2027;
        final int QUESTION_NO_2028 = 2028;
        final int QUESTION_NO_2029 = 2029;
        final int QUESTION_NO_2030 = 2030;
        final int QUESTION_NO_2031 = 2031;
        final int QUESTION_NO_2032 = 2032;
        final int QUESTION_NO_2033 = 2033;
        final int QUESTION_NO_2034 = 2034;
        final int QUESTION_NO_2035 = 2035;
        final int QUESTION_NO_2036 = 2036;
        final int QUESTION_NO_2037 = 2037;
        final int QUESTION_NO_2038 = 2038;
        final int QUESTION_NO_2039 = 2039;
        final int QUESTION_NO_2040 = 2040;
        final int QUESTION_NO_2041 = 2041;
        final int QUESTION_NO_2042 = 2042;
        final int QUESTION_NO_2043 = 2043;
        final int QUESTION_NO_2044 = 2044;
        final int QUESTION_NO_2045 = 2045;
        final int QUESTION_NO_2046 = 2046;
        final int QUESTION_NO_2047 = 2047;
        final int QUESTION_NO_2048 = 2048;
        final int QUESTION_NO_2049 = 2049;
        final int QUESTION_NO_2050 = 2050;
        final int QUESTION_NO_2051 = 2051;
        final int QUESTION_NO_2052 = 2052;
        final int QUESTION_NO_2053 = 2053;
        final int QUESTION_NO_2054 = 2054;
        final int QUESTION_NO_2055 = 2055;
        final int QUESTION_NO_2056 = 2056;
        final int QUESTION_NO_2057 = 2057;
        final int QUESTION_NO_2058 = 2058;
        final int QUESTION_NO_2059 = 2059;
        final int QUESTION_NO_2060 = 2060;
        final int QUESTION_NO_2061 = 2061;
        final int QUESTION_NO_2062 = 2062;
        final int QUESTION_NO_2063 = 2063;
        final int QUESTION_NO_2064 = 2064;
        final int QUESTION_NO_2065 = 2065;
        final int QUESTION_NO_2066 = 2066;
        final int QUESTION_NO_2067 = 2067;
        final int QUESTION_NO_2068 = 2068;
        final int QUESTION_NO_2069 = 2069;
        final int QUESTION_NO_2070 = 2070;
        final int QUESTION_NO_2071 = 2071;
        final int QUESTION_NO_2072 = 2072;
        final int QUESTION_NO_2073 = 2073;
        final int QUESTION_NO_2074 = 2074;
        final int QUESTION_NO_2075 = 2075;
        final int QUESTION_NO_2076 = 2076;
        final int QUESTION_NO_2077 = 2077;
        final int QUESTION_NO_2078 = 2078;
        final int QUESTION_NO_2079 = 2079;
        final int QUESTION_NO_2080 = 2080;
        final int QUESTION_NO_2081 = 2081;
        final int QUESTION_NO_2082 = 2082;
        final int QUESTION_NO_2083 = 2083;
        final int QUESTION_NO_2084 = 2084;
        final int QUESTION_NO_2085 = 2085;
        final int QUESTION_NO_2086 = 2086;
        final int QUESTION_NO_2087 = 2087;
        final int QUESTION_NO_2088 = 2088;



        StringBuilder columnStringBuilder = new StringBuilder();
        columnStringBuilder.append(KEY_ID).append(", ").append(KEY_QUESTION).append(", ")
                .append(KEY_TYPE).append(", ").append(KEY_RESOURCE);

        // 6 - Answer with button - Spelling check

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2001).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.asiatic_lily).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2002).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.bee_orchid).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2003).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.common_oat).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2004).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.blue_poppy).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2005).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.blue_vanda).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2006).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.cheatgrass).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2007).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.flax).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2008).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.nilofar).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2009).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.globe_primrose).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2010).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.har_singar).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2011).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.gloxinia).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2012).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.kanpet).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2013).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.ylang_ylang).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2014).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.wax_flower).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2015).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.potato_vine).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2016).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.red_vanda).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2017).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.magnolia).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2018).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.bower_vine).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2019).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.champa).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2020).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.tulip_tree).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2021).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.love_in_a_mist).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2022).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.hari_champa).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2023).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.green_taro).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2024).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.peace_lily).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2025).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.glory_lily).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2026).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.pond_apple).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2027).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.aloe_vera).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2028).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.soursop).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2029).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.kut).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2030).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.kumaon_iris).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2031).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.gasteria).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2032).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.jade_plant).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2033).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.ragi).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2034).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.beej_karela).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2035).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.snake_plant).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2036).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.soap_aloe).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2037).append(", ")
                .append(R.string.quesImageAnsButton).append(", ")
                .append(Utils.QUESTION_IMAGE_ANSWER_BUTTON).append(", ")
                .append(R.drawable.spider_aloe).append(" )").toString());


    }

    private void insertQuesType7(SQLiteDatabase db) {

        final int QUESTION_NO_2501 = 2501;
        final int QUESTION_NO_2502 = 2502;
        final int QUESTION_NO_2503 = 2503;
        final int QUESTION_NO_2504 = 2504;
        final int QUESTION_NO_2505 = 2505;
        final int QUESTION_NO_2506 = 2506;
        final int QUESTION_NO_2507 = 2507;
        final int QUESTION_NO_2508 = 2508;
        final int QUESTION_NO_2509 = 2509;
        final int QUESTION_NO_2510 = 2510;
        final int QUESTION_NO_2511 = 2511;
        final int QUESTION_NO_2512 = 2512;
        final int QUESTION_NO_2513 = 2513;
        final int QUESTION_NO_2514 = 2514;
        final int QUESTION_NO_2515 = 2515;
        final int QUESTION_NO_2516 = 2516;
        final int QUESTION_NO_2517 = 2517;
        final int QUESTION_NO_2518 = 2518;
        final int QUESTION_NO_2519 = 2519;
        final int QUESTION_NO_2520 = 2520;
        final int QUESTION_NO_2521 = 2521;
        final int QUESTION_NO_2522 = 2522;
        final int QUESTION_NO_2523 = 2523;
        final int QUESTION_NO_2524 = 2524;
        final int QUESTION_NO_2525 = 2525;
        final int QUESTION_NO_2526 = 2526;
        final int QUESTION_NO_2527 = 2527;
        final int QUESTION_NO_2528 = 2528;
        final int QUESTION_NO_2529 = 2529;
        final int QUESTION_NO_2530 = 2530;
        final int QUESTION_NO_2531 = 2531;
        final int QUESTION_NO_2532 = 2532;
        final int QUESTION_NO_2533 = 2533;
        final int QUESTION_NO_2534 = 2534;
        final int QUESTION_NO_2535 = 2535;
        final int QUESTION_NO_2536 = 2536;
        final int QUESTION_NO_2537 = 2537;
        final int QUESTION_NO_2538 = 2538;
        final int QUESTION_NO_2539 = 2539;
        final int QUESTION_NO_2540 = 2540;
        final int QUESTION_NO_2541 = 2541;
        final int QUESTION_NO_2542 = 2542;
        final int QUESTION_NO_2543 = 2543;
        final int QUESTION_NO_2544 = 2544;
        final int QUESTION_NO_2545 = 2545;
        final int QUESTION_NO_2546 = 2546;
        final int QUESTION_NO_2547 = 2547;
        final int QUESTION_NO_2548 = 2548;
        final int QUESTION_NO_2549 = 2549;
        final int QUESTION_NO_2550 = 2550;
        final int QUESTION_NO_2551 = 2551;
        final int QUESTION_NO_2552 = 2552;
        final int QUESTION_NO_2553 = 2553;
        final int QUESTION_NO_2554 = 2554;
        final int QUESTION_NO_2555 = 2555;
        final int QUESTION_NO_2556 = 2556;
        final int QUESTION_NO_2557 = 2557;
        final int QUESTION_NO_2558 = 2558;
        final int QUESTION_NO_2559 = 2559;
        final int QUESTION_NO_2560 = 2560;
        final int QUESTION_NO_2561 = 2561;
        final int QUESTION_NO_2562 = 2562;
        final int QUESTION_NO_2563 = 2563;
        final int QUESTION_NO_2564 = 2564;
        final int QUESTION_NO_2565 = 2565;
        final int QUESTION_NO_2566 = 2566;
        final int QUESTION_NO_2567 = 2567;
        final int QUESTION_NO_2568 = 2568;
        final int QUESTION_NO_2569 = 2569;
        final int QUESTION_NO_2570 = 2570;
        final int QUESTION_NO_2571 = 2571;
        final int QUESTION_NO_2572 = 2572;
        final int QUESTION_NO_2573 = 2573;
        final int QUESTION_NO_2574 = 2574;
        final int QUESTION_NO_2575 = 2575;
        final int QUESTION_NO_2576 = 2576;
        final int QUESTION_NO_2577 = 2577;
        final int QUESTION_NO_2578 = 2578;
        final int QUESTION_NO_2579 = 2579;
        final int QUESTION_NO_2580 = 2580;
        final int QUESTION_NO_2581 = 2581;
        final int QUESTION_NO_2582 = 2582;
        final int QUESTION_NO_2583 = 2583;
        final int QUESTION_NO_2584 = 2584;
        final int QUESTION_NO_2585 = 2585;
        final int QUESTION_NO_2586 = 2586;
        final int QUESTION_NO_2587 = 2587;
        final int QUESTION_NO_2588 = 2588;
        final int QUESTION_NO_2589 = 2589;
        final int QUESTION_NO_2590 = 2590;
        final int QUESTION_NO_2591 = 2591;
        final int QUESTION_NO_2592 = 2592;
        final int QUESTION_NO_2593 = 2593;
        final int QUESTION_NO_2594 = 2594;
        final int QUESTION_NO_2595 = 2595;
        final int QUESTION_NO_2596 = 2596;
        final int QUESTION_NO_2597 = 2597;
        final int QUESTION_NO_2598 = 2598;
        final int QUESTION_NO_2599 = 2599;
        final int QUESTION_NO_2600 = 2600;

        StringBuilder columnStringBuilder = new StringBuilder();
        columnStringBuilder.append(KEY_ID).append(", ").append(KEY_QUESTION).append(", ")
                .append(KEY_TYPE).append(", ").append(KEY_RESOURCE);

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2501).append(", ")
                .append(R.string.ques_type7_1).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2502).append(", ")
                .append(R.string.ques_type7_2).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2503).append(", ")
                .append(R.string.ques_type7_3).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2504).append(", ")
                .append(R.string.ques_type7_4).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2505).append(", ")
                .append(R.string.ques_type7_5).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2506).append(", ")
                .append(R.string.ques_type7_6).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2507).append(", ")
                .append(R.string.ques_type7_7).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2508).append(", ")
                .append(R.string.ques_type7_8).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2509).append(", ")
                .append(R.string.ques_type7_9).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2510).append(", ")
                .append(R.string.ques_type7_10).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2511).append(", ")
                .append(R.string.ques_type7_11).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2512).append(", ")
                .append(R.string.ques_type7_12).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2513).append(", ")
                .append(R.string.ques_type7_13).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2514).append(", ")
                .append(R.string.ques_type7_14).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2515).append(", ")
                .append(R.string.ques_type7_15).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2516).append(", ")
                .append(R.string.ques_type7_16).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2517).append(", ")
                .append(R.string.ques_type7_17).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2518).append(", ")
                .append(R.string.ques_type7_18).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2519).append(", ")
                .append(R.string.ques_type7_19).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2520).append(", ")
                .append(R.string.ques_type7_20).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2521).append(", ")
                .append(R.string.ques_type7_21).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2522).append(", ")
                .append(R.string.ques_type7_22).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2523).append(", ")
                .append(R.string.ques_type7_23).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2524).append(", ")
                .append(R.string.ques_type7_24).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2525).append(", ")
                .append(R.string.ques_type7_25).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2526).append(", ")
                .append(R.string.ques_type7_26).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2527).append(", ")
                .append(R.string.ques_type7_27).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2528).append(", ")
                .append(R.string.ques_type7_28).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2529).append(", ")
                .append(R.string.ques_type7_29).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2530).append(", ")
                .append(R.string.ques_type7_30).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2531).append(", ")
                .append(R.string.ques_type7_31).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2532).append(", ")
                .append(R.string.ques_type7_32).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2533).append(", ")
                .append(R.string.ques_type7_33).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2534).append(", ")
                .append(R.string.ques_type7_34).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2535).append(", ")
                .append(R.string.ques_type7_35).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2536).append(", ")
                .append(R.string.ques_type7_36).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2537).append(", ")
                .append(R.string.ques_type7_37).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2538).append(", ")
                .append(R.string.ques_type7_38).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2539).append(", ")
                .append(R.string.ques_type7_39).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2540).append(", ")
                .append(R.string.ques_type7_40).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2541).append(", ")
                .append(R.string.ques_type7_41).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2542).append(", ")
                .append(R.string.ques_type7_42).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2543).append(", ")
                .append(R.string.ques_type7_43).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2544).append(", ")
                .append(R.string.ques_type7_44).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2545).append(", ")
                .append(R.string.ques_type7_45).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2546).append(", ")
                .append(R.string.ques_type7_46).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2547).append(", ")
                .append(R.string.ques_type7_47).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2548).append(", ")
                .append(R.string.ques_type7_48).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2549).append(", ")
                .append(R.string.ques_type7_49).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2550).append(", ")
                .append(R.string.ques_type7_50).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2551).append(", ")
                .append(R.string.ques_type7_51).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2552).append(", ")
                .append(R.string.ques_type7_52).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2553).append(", ")
                .append(R.string.ques_type7_53).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2554).append(", ")
                .append(R.string.ques_type7_54).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2555).append(", ")
                .append(R.string.ques_type7_55).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2556).append(", ")
                .append(R.string.ques_type7_56).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2557).append(", ")
                .append(R.string.ques_type7_57).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2558).append(", ")
                .append(R.string.ques_type7_58).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2559).append(", ")
                .append(R.string.ques_type7_59).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2560).append(", ")
                .append(R.string.ques_type7_60).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2561).append(", ")
                .append(R.string.ques_type7_61).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2562).append(", ")
                .append(R.string.ques_type7_62).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2563).append(", ")
                .append(R.string.ques_type7_63).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2564).append(", ")
                .append(R.string.ques_type7_64).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2565).append(", ")
                .append(R.string.ques_type7_65).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2566).append(", ")
                .append(R.string.ques_type7_66).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2567).append(", ")
                .append(R.string.ques_type7_67).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2568).append(", ")
                .append(R.string.ques_type7_68).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2569).append(", ")
                .append(R.string.ques_type7_69).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2570).append(", ")
                .append(R.string.ques_type7_70).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2571).append(", ")
                .append(R.string.ques_type7_71).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2572).append(", ")
                .append(R.string.ques_type7_72).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2573).append(", ")
                .append(R.string.ques_type7_73).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2574).append(", ")
                .append(R.string.ques_type7_74).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2575).append(", ")
                .append(R.string.ques_type7_75).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2576).append(", ")
                .append(R.string.ques_type7_76).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2577).append(", ")
                .append(R.string.ques_type7_77).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2578).append(", ")
                .append(R.string.ques_type7_78).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2579).append(", ")
                .append(R.string.ques_type7_79).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2580).append(", ")
                .append(R.string.ques_type7_80).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2581).append(", ")
                .append(R.string.ques_type7_81).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2582).append(", ")
                .append(R.string.ques_type7_82).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2583).append(", ")
                .append(R.string.ques_type7_83).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2584).append(", ")
                .append(R.string.ques_type7_84).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2585).append(", ")
                .append(R.string.ques_type7_85).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2586).append(", ")
                .append(R.string.ques_type7_86).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2587).append(", ")
                .append(R.string.ques_type7_87).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2588).append(", ")
                .append(R.string.ques_type7_88).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2589).append(", ")
                .append(R.string.ques_type7_89).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2590).append(", ")
                .append(R.string.ques_type7_90).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2591).append(", ")
                .append(R.string.ques_type7_91).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2592).append(", ")
                .append(R.string.ques_type7_92).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2593).append(", ")
                .append(R.string.ques_type7_93).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2594).append(", ")
                .append(R.string.ques_type7_94).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2595).append(", ")
                .append(R.string.ques_type7_95).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2596).append(", ")
                .append(R.string.ques_type7_96).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2597).append(", ")
                .append(R.string.ques_type7_97).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2598).append(", ")
                .append(R.string.ques_type7_98).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2599).append(", ")
                .append(R.string.ques_type7_99).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_QUESTION).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(QUESTION_NO_2600).append(", ")
                .append(R.string.ques_type7_100).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(" )").toString());


    }

    private void insertAnsType1(SQLiteDatabase db){
        final int QUESTION_NO_1 = 1;
        final int QUESTION_NO_2 = 2;
        final int QUESTION_NO_3 = 3;
        final int QUESTION_NO_4 = 4;
        final int QUESTION_NO_5 = 5;
        final int QUESTION_NO_6 = 6;
        final int QUESTION_NO_7 = 7;
        final int QUESTION_NO_8 = 8;
        final int QUESTION_NO_9 = 9;
        final int QUESTION_NO_10 = 10;
        final int QUESTION_NO_11 = 11;
        final int QUESTION_NO_12 = 12;
        final int QUESTION_NO_13 = 13;
        final int QUESTION_NO_14 = 14;
        final int QUESTION_NO_15 = 15;
        final int QUESTION_NO_16 = 16;
        final int QUESTION_NO_17 = 17;
        final int QUESTION_NO_18 = 18;
        final int QUESTION_NO_19 = 19;
        final int QUESTION_NO_20 = 20;
        final int QUESTION_NO_21 = 21;
        final int QUESTION_NO_22 = 22;
        final int QUESTION_NO_23 = 23;
        final int QUESTION_NO_24 = 24;
        final int QUESTION_NO_25 = 25;
        final int QUESTION_NO_26 = 26;
        final int QUESTION_NO_27 = 27;
        final int QUESTION_NO_28 = 28;
        final int QUESTION_NO_29 = 29;
        final int QUESTION_NO_30 = 30;
        final int QUESTION_NO_31 = 31;
        final int QUESTION_NO_32 = 32;
        final int QUESTION_NO_33 = 33;
        final int QUESTION_NO_34 = 34;
        final int QUESTION_NO_35 = 35;
        final int QUESTION_NO_36 = 36;
        final int QUESTION_NO_37 = 37;
        final int QUESTION_NO_38 = 38;
        final int QUESTION_NO_39 = 39;
        final int QUESTION_NO_40 = 40;
        final int QUESTION_NO_41 = 41;
        final int QUESTION_NO_42 = 42;
        final int QUESTION_NO_43 = 43;
        final int QUESTION_NO_44 = 44;
        final int QUESTION_NO_45 = 45;
        final int QUESTION_NO_46 = 46;
        final int QUESTION_NO_47 = 47;
        final int QUESTION_NO_48 = 48;
        final int QUESTION_NO_49 = 49;
        final int QUESTION_NO_50 = 50;

        StringBuilder columnStringBuilder = new StringBuilder();
        columnStringBuilder.append(KEY_ANSWER).append(", ")
                .append(KEY_TYPE).append(", ").append(KEY_RESOURCE)
                .append(", ").append(KEY_IS_CORRECT).append(", ")
                .append(KEY_QUESTION_ID);

        int[] keyAns1 = {R.string.ans_type1_que1_1,R.string.ans_type1_que1_2,R.string.ans_type1_que1_3,R.string.ans_type1_que1_4};
        ContentValues[] ans1 = new ContentValues[4];
        for(int count=0; count<4; count++){
            ans1[count] = new ContentValues();
            ans1[count].put(KEY_ANSWER, keyAns1[count]);
            ans1[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans1[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if(count == 3)
                ans1[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans1[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans1[count].put(KEY_QUESTION_ID, QUESTION_NO_1);
            db.insert(TABLE_ANSWER, null, ans1[count]);
        }

        int[] keyAns2 = {R.string.ans_type1_que2_1,R.string.ans_type1_que2_2,R.string.ans_type1_que2_3,R.string.ans_type1_que2_4};
        ContentValues[] ans2 = new ContentValues[4];
        for(int count=0; count<4; count++){
            ans2[count] = new ContentValues();
            ans2[count].put(KEY_ANSWER, keyAns2[count]);
            ans2[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans2[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if(count == 1)
                ans2[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans2[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans2[count].put(KEY_QUESTION_ID, QUESTION_NO_2);
            db.insert(TABLE_ANSWER, null, ans2[count]);
        }

        int[] keyAns3 = {R.string.ans_type1_que3_1,R.string.ans_type1_que3_2,R.string.ans_type1_que3_3,R.string.ans_type1_que3_4};
        ContentValues[] ans3 = new ContentValues[4];
        for(int count=0; count<4; count++){
            ans3[count] = new ContentValues();
            ans3[count].put(KEY_ANSWER, keyAns3[count]);
            ans3[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans3[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if(count == 0)
                ans3[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans3[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans3[count].put(KEY_QUESTION_ID, QUESTION_NO_3);
            db.insert(TABLE_ANSWER, null, ans3[count]);
        }

        int[] keyAns4 = {R.string.ans_type1_que4_1,R.string.ans_type1_que4_2,R.string.ans_type1_que4_3,R.string.ans_type1_que4_4};
        ContentValues[] ans4 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans4[count] = new ContentValues();
            ans4[count].put(KEY_ANSWER, keyAns4[count]);
            ans4[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans4[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 2)
                ans4[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans4[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans4[count].put(KEY_QUESTION_ID, QUESTION_NO_4);
            db.insert(TABLE_ANSWER, null, ans4[count]);
        }

        int[] keyAns5 = {R.string.ans_type1_que5_1,R.string.ans_type1_que5_2,R.string.ans_type1_que5_3,R.string.ans_type1_que5_4};
        ContentValues[] ans5 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans5[count] = new ContentValues();
            ans5[count].put(KEY_ANSWER, keyAns5[count]);
            ans5[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans5[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 3)
                ans5[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans5[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans5[count].put(KEY_QUESTION_ID, QUESTION_NO_5);
            db.insert(TABLE_ANSWER, null, ans5[count]);
        }

        int[] keyAns6 = {R.string.ans_type1_que6_1,R.string.ans_type1_que6_2,R.string.ans_type1_que6_3,R.string.ans_type1_que6_4};
        ContentValues[] ans6 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans6[count] = new ContentValues();
            ans6[count].put(KEY_ANSWER, keyAns6[count]);
            ans6[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans6[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 0)
                ans6[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans6[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans6[count].put(KEY_QUESTION_ID, QUESTION_NO_6);
            db.insert(TABLE_ANSWER, null, ans6[count]);
        }

        int[] keyAns7 = {R.string.ans_type1_que7_1,R.string.ans_type1_que7_2,R.string.ans_type1_que7_3,R.string.ans_type1_que7_4};
        ContentValues[] ans7 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans7[count] = new ContentValues();
            ans7[count].put(KEY_ANSWER, keyAns7[count]);
            ans7[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans7[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 0)
                ans7[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans7[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans7[count].put(KEY_QUESTION_ID, QUESTION_NO_7);
            db.insert(TABLE_ANSWER, null, ans7[count]);
        }

        int[] keyAns8 = {R.string.ans_type1_que8_1,R.string.ans_type1_que8_2,R.string.ans_type1_que8_3,R.string.ans_type1_que8_4};
        ContentValues[] ans8 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans8[count] = new ContentValues();
            ans8[count].put(KEY_ANSWER, keyAns8[count]);
            ans8[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans8[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 1)
                ans8[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans8[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans8[count].put(KEY_QUESTION_ID, QUESTION_NO_8);
            db.insert(TABLE_ANSWER, null, ans8[count]);
        }

        int[] keyAns9 = {R.string.ans_type1_que9_1,R.string.ans_type1_que9_2,R.string.ans_type1_que9_3,R.string.ans_type1_que9_4};
        ContentValues[] ans9 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans9[count] = new ContentValues();
            ans9[count].put(KEY_ANSWER, keyAns9[count]);
            ans9[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans9[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 2)
                ans9[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans9[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans9[count].put(KEY_QUESTION_ID, QUESTION_NO_9);
            db.insert(TABLE_ANSWER, null, ans9[count]);
        }

        int[] keyAns10 = {R.string.ans_type1_que10_1,R.string.ans_type1_que10_2,R.string.ans_type1_que10_3,R.string.ans_type1_que10_4};
        ContentValues[] ans10 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans10[count] = new ContentValues();
            ans10[count].put(KEY_ANSWER, keyAns10[count]);
            ans10[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans10[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 0)
                ans10[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans10[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans10[count].put(KEY_QUESTION_ID, QUESTION_NO_10);
            db.insert(TABLE_ANSWER, null, ans10[count]);
        }

        int[] keyAns11 = {R.string.ans_type1_que11_1,R.string.ans_type1_que11_2,R.string.ans_type1_que11_3,R.string.ans_type1_que11_4};
        ContentValues[] ans11 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans11[count] = new ContentValues();
            ans11[count].put(KEY_ANSWER, keyAns11[count]);
            ans11[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans11[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 0)
                ans11[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans11[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans11[count].put(KEY_QUESTION_ID, QUESTION_NO_11);
            db.insert(TABLE_ANSWER, null, ans11[count]);
        }

        int[] keyAns12 = {R.string.ans_type1_que12_1,R.string.ans_type1_que12_2,R.string.ans_type1_que12_3,R.string.ans_type1_que12_4};
        ContentValues[] ans12 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans12[count] = new ContentValues();
            ans12[count].put(KEY_ANSWER, keyAns12[count]);
            ans12[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans12[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 3)
                ans12[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans12[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans12[count].put(KEY_QUESTION_ID, QUESTION_NO_12);
            db.insert(TABLE_ANSWER, null, ans12[count]);
        }

        //cat-3
        int[] keyAns13 = {R.string.ans_type1_que13_1,R.string.ans_type1_que13_2,R.string.ans_type1_que13_3,R.string.ans_type1_que13_4};
        ContentValues[] ans13 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans13[count] = new ContentValues();
            ans13[count].put(KEY_ANSWER, keyAns13[count]);
            ans13[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans13[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 2)
                ans13[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans13[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans13[count].put(KEY_QUESTION_ID, QUESTION_NO_13);
            db.insert(TABLE_ANSWER, null, ans13[count]);
        }

        int[] keyAns14 = {R.string.ans_type1_que14_1,R.string.ans_type1_que14_2,R.string.ans_type1_que14_3,R.string.ans_type1_que14_4};
        ContentValues[] ans14 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans14[count] = new ContentValues();
            ans14[count].put(KEY_ANSWER, keyAns14[count]);
            ans14[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans14[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 1)
                ans14[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans14[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans14[count].put(KEY_QUESTION_ID, QUESTION_NO_14);
            db.insert(TABLE_ANSWER, null, ans14[count]);
        }

        int[] keyAns15 = {R.string.ans_type1_que15_1,R.string.ans_type1_que15_2,R.string.ans_type1_que15_3,R.string.ans_type1_que15_4};
        ContentValues[] ans15 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans15[count] = new ContentValues();
            ans15[count].put(KEY_ANSWER, keyAns15[count]);
            ans15[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans15[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 3)
                ans15[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans15[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans15[count].put(KEY_QUESTION_ID, QUESTION_NO_15);
            db.insert(TABLE_ANSWER, null, ans15[count]);
        }

        int[] keyAns16 = {R.string.ans_type1_que16_1,R.string.ans_type1_que16_2,R.string.ans_type1_que16_3,R.string.ans_type1_que16_4};
        ContentValues[] ans16 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans16[count] = new ContentValues();
            ans16[count].put(KEY_ANSWER, keyAns16[count]);
            ans16[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans16[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 2)
                ans16[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans16[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans16[count].put(KEY_QUESTION_ID, QUESTION_NO_16);
            db.insert(TABLE_ANSWER, null, ans16[count]);
        }

        int[] keyAns17 = {R.string.ans_type1_que17_1,R.string.ans_type1_que17_2,R.string.ans_type1_que17_3,R.string.ans_type1_que17_4};
        ContentValues[] ans17 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans17[count] = new ContentValues();
            ans17[count].put(KEY_ANSWER, keyAns17[count]);
            ans17[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans17[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 1)
                ans17[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans17[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans17[count].put(KEY_QUESTION_ID, QUESTION_NO_17);
            db.insert(TABLE_ANSWER, null, ans17[count]);
        }

        int[] keyAns18 = {R.string.ans_type1_que18_1,R.string.ans_type1_que18_2,R.string.ans_type1_que18_3,R.string.ans_type1_que18_4};
        ContentValues[] ans18 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans18[count] = new ContentValues();
            ans18[count].put(KEY_ANSWER, keyAns18[count]);
            ans18[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans18[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 3)
                ans18[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans18[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans18[count].put(KEY_QUESTION_ID, QUESTION_NO_18);
            db.insert(TABLE_ANSWER, null, ans18[count]);
        }

        int[] keyAns19 = {R.string.ans_type1_que19_1,R.string.ans_type1_que19_2,R.string.ans_type1_que19_3,R.string.ans_type1_que19_4};
        ContentValues[] ans19 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans19[count] = new ContentValues();
            ans19[count].put(KEY_ANSWER, keyAns19[count]);
            ans19[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans19[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 2)
                ans19[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans19[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans19[count].put(KEY_QUESTION_ID, QUESTION_NO_19);
            db.insert(TABLE_ANSWER, null, ans19[count]);
        }

        int[] keyAns20 = {R.string.ans_type1_que20_1,R.string.ans_type1_que20_2,R.string.ans_type1_que20_3,R.string.ans_type1_que20_4};
        ContentValues[] ans20 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans20[count] = new ContentValues();
            ans20[count].put(KEY_ANSWER, keyAns20[count]);
            ans20[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans20[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 0)
                ans20[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans20[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans20[count].put(KEY_QUESTION_ID, QUESTION_NO_20);
            db.insert(TABLE_ANSWER, null, ans20[count]);
        }

        int[] keyAns21 = {R.string.ans_type1_que21_1,R.string.ans_type1_que21_2,R.string.ans_type1_que21_3,R.string.ans_type1_que21_4};
        ContentValues[] ans21 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans21[count] = new ContentValues();
            ans21[count].put(KEY_ANSWER, keyAns21[count]);
            ans21[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans21[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 1)
                ans21[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans21[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans21[count].put(KEY_QUESTION_ID, QUESTION_NO_21);
            db.insert(TABLE_ANSWER, null, ans21[count]);
        }

        int[] keyAns22 = {R.string.ans_type1_que22_1,R.string.ans_type1_que22_2,R.string.ans_type1_que22_3,R.string.ans_type1_que22_4};
        ContentValues[] ans22 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans22[count] = new ContentValues();
            ans22[count].put(KEY_ANSWER, keyAns22[count]);
            ans22[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans22[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 3)
                ans22[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans22[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans22[count].put(KEY_QUESTION_ID, QUESTION_NO_22);
            db.insert(TABLE_ANSWER, null, ans22[count]);
        }

        int[] keyAns23 = {R.string.ans_type1_que23_1,R.string.ans_type1_que23_2,R.string.ans_type1_que23_3,R.string.ans_type1_que23_4};
        ContentValues[] ans23 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans23[count] = new ContentValues();
            ans23[count].put(KEY_ANSWER, keyAns23[count]);
            ans23[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans23[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 0)
                ans23[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans23[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans23[count].put(KEY_QUESTION_ID, QUESTION_NO_23);
            db.insert(TABLE_ANSWER, null, ans23[count]);
        }

        int[] keyAns24 = {R.string.ans_type1_que24_1,R.string.ans_type1_que24_2,R.string.ans_type1_que24_3,R.string.ans_type1_que24_4};
        ContentValues[] ans24 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans24[count] = new ContentValues();
            ans24[count].put(KEY_ANSWER, keyAns24[count]);
            ans24[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans24[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 3)
                ans24[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans24[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans24[count].put(KEY_QUESTION_ID, QUESTION_NO_24);
            db.insert(TABLE_ANSWER, null, ans24[count]);
        }

        int[] keyAns25 = {R.string.ans_type1_que25_1,R.string.ans_type1_que25_2,R.string.ans_type1_que25_3,R.string.ans_type1_que25_4};
        ContentValues[] ans25 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans25[count] = new ContentValues();
            ans25[count].put(KEY_ANSWER, keyAns25[count]);
            ans25[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans25[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 2)
                ans25[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans25[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans25[count].put(KEY_QUESTION_ID, QUESTION_NO_25);
            db.insert(TABLE_ANSWER, null, ans25[count]);
        }

        int[] keyAns26 = {R.string.ans_type1_que26_1,R.string.ans_type1_que26_2,R.string.ans_type1_que26_3,R.string.ans_type1_que26_4};
        ContentValues[] ans26 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans26[count] = new ContentValues();
            ans26[count].put(KEY_ANSWER, keyAns26[count]);
            ans26[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans26[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 0)
                ans26[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans26[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans26[count].put(KEY_QUESTION_ID, QUESTION_NO_26);
            db.insert(TABLE_ANSWER, null, ans26[count]);
        }

        int[] keyAns27 = {R.string.ans_type1_que27_1,R.string.ans_type1_que27_2,R.string.ans_type1_que27_3,R.string.ans_type1_que27_4};
        ContentValues[] ans27 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans27[count] = new ContentValues();
            ans27[count].put(KEY_ANSWER, keyAns27[count]);
            ans27[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans27[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 1)
                ans27[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans27[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans27[count].put(KEY_QUESTION_ID, QUESTION_NO_27);
            db.insert(TABLE_ANSWER, null, ans27[count]);
        }

        int[] keyAns28 = {R.string.ans_type1_que28_1,R.string.ans_type1_que28_2,R.string.ans_type1_que28_3,R.string.ans_type1_que28_4};
        ContentValues[] ans28 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans28[count] = new ContentValues();
            ans28[count].put(KEY_ANSWER, keyAns28[count]);
            ans28[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans28[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 2)
                ans28[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans28[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans28[count].put(KEY_QUESTION_ID, QUESTION_NO_28);
            db.insert(TABLE_ANSWER, null, ans28[count]);
        }

        int[] keyAns29 = {R.string.ans_type1_que29_1,R.string.ans_type1_que29_2,R.string.ans_type1_que29_3,R.string.ans_type1_que29_4};
        ContentValues[] ans29 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans29[count] = new ContentValues();
            ans29[count].put(KEY_ANSWER, keyAns29[count]);
            ans29[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans29[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 0)
                ans29[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans29[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans29[count].put(KEY_QUESTION_ID, QUESTION_NO_29);
            db.insert(TABLE_ANSWER, null, ans29[count]);
        }

        int[] keyAns30 = {R.string.ans_type1_que30_1,R.string.ans_type1_que30_2,R.string.ans_type1_que30_3,R.string.ans_type1_que30_4};
        ContentValues[] ans30 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans30[count] = new ContentValues();
            ans30[count].put(KEY_ANSWER, keyAns30[count]);
            ans30[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans30[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 3)
                ans30[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans30[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans30[count].put(KEY_QUESTION_ID, QUESTION_NO_30);
            db.insert(TABLE_ANSWER, null, ans30[count]);
        }

        int[] keyAns31 = {R.string.ans_type1_que31_1,R.string.ans_type1_que31_2,R.string.ans_type1_que31_3,R.string.ans_type1_que31_4};
        ContentValues[] ans31 = new ContentValues[4];
        for(int count=0; count<4; count++){
            ans31[count] = new ContentValues();
            ans31[count].put(KEY_ANSWER, keyAns31[count]);
            ans31[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans31[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if(count == 3)
                ans31[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans31[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans31[count].put(KEY_QUESTION_ID, QUESTION_NO_31);
            db.insert(TABLE_ANSWER, null, ans31[count]);
        }

        int[] keyAns32 = {R.string.ans_type1_que32_1,R.string.ans_type1_que32_2,R.string.ans_type1_que32_3,R.string.ans_type1_que32_4};
        ContentValues[] ans32 = new ContentValues[4];
        for(int count=0; count<4; count++){
            ans32[count] = new ContentValues();
            ans32[count].put(KEY_ANSWER, keyAns32[count]);
            ans32[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans32[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if(count == 0)
                ans32[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans32[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans32[count].put(KEY_QUESTION_ID, QUESTION_NO_32);
            db.insert(TABLE_ANSWER, null, ans32[count]);
        }

        int[] keyAns33 = {R.string.ans_type1_que33_1,R.string.ans_type1_que33_2,R.string.ans_type1_que33_3,R.string.ans_type1_que33_4};
        ContentValues[] ans33 = new ContentValues[4];
        for(int count=0; count<4; count++){
            ans33[count] = new ContentValues();
            ans33[count].put(KEY_ANSWER, keyAns33[count]);
            ans33[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans33[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if(count == 1)
                ans33[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans33[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans33[count].put(KEY_QUESTION_ID, QUESTION_NO_33);
            db.insert(TABLE_ANSWER, null, ans33[count]);
        }

        int[] keyAns34 = {R.string.ans_type1_que34_1,R.string.ans_type1_que34_2,R.string.ans_type1_que34_3,R.string.ans_type1_que34_4};
        ContentValues[] ans34 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans34[count] = new ContentValues();
            ans34[count].put(KEY_ANSWER, keyAns34[count]);
            ans34[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans34[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 3)
                ans34[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans34[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans34[count].put(KEY_QUESTION_ID, QUESTION_NO_34);
            db.insert(TABLE_ANSWER, null, ans34[count]);
        }

        int[] keyAns35 = {R.string.ans_type1_que35_1,R.string.ans_type1_que35_2,R.string.ans_type1_que35_3,R.string.ans_type1_que35_4};
        ContentValues[] ans35 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans35[count] = new ContentValues();
            ans35[count].put(KEY_ANSWER, keyAns35[count]);
            ans35[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans35[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 3)
                ans35[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans35[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans35[count].put(KEY_QUESTION_ID, QUESTION_NO_35);
            db.insert(TABLE_ANSWER, null, ans35[count]);
        }

        int[] keyAns36 = {R.string.ans_type1_que36_1,R.string.ans_type1_que36_2,R.string.ans_type1_que36_3,R.string.ans_type1_que36_4};
        ContentValues[] ans36 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans36[count] = new ContentValues();
            ans36[count].put(KEY_ANSWER, keyAns36[count]);
            ans36[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans36[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 2)
                ans36[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans36[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans6[count].put(KEY_QUESTION_ID, QUESTION_NO_36);
            db.insert(TABLE_ANSWER, null, ans36[count]);
        }

        int[] keyAns37 = {R.string.ans_type1_que37_1,R.string.ans_type1_que37_2,R.string.ans_type1_que37_3,R.string.ans_type1_que37_4};
        ContentValues[] ans37 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans37[count] = new ContentValues();
            ans37[count].put(KEY_ANSWER, keyAns37[count]);
            ans37[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans37[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 0)
                ans37[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans37[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans37[count].put(KEY_QUESTION_ID, QUESTION_NO_37);
            db.insert(TABLE_ANSWER, null, ans37[count]);
        }

        int[] keyAns38 = {R.string.ans_type1_que38_1,R.string.ans_type1_que38_2,R.string.ans_type1_que38_3,R.string.ans_type1_que38_4};
        ContentValues[] ans38 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans38[count] = new ContentValues();
            ans38[count].put(KEY_ANSWER, keyAns38[count]);
            ans38[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans38[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 1)
                ans38[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans38[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans38[count].put(KEY_QUESTION_ID, QUESTION_NO_38);
            db.insert(TABLE_ANSWER, null, ans38[count]);
        }

        int[] keyAns39 = {R.string.ans_type1_que39_1,R.string.ans_type1_que39_2,R.string.ans_type1_que39_3,R.string.ans_type1_que39_4};
        ContentValues[] ans39 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans39[count] = new ContentValues();
            ans39[count].put(KEY_ANSWER, keyAns39[count]);
            ans39[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans39[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 0)
                ans39[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans39[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans39[count].put(KEY_QUESTION_ID, QUESTION_NO_39);
            db.insert(TABLE_ANSWER, null, ans39[count]);
        }

        int[] keyAns40 = {R.string.ans_type1_que40_1,R.string.ans_type1_que40_2,R.string.ans_type1_que40_3,R.string.ans_type1_que40_4};
        ContentValues[] ans40 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans40[count] = new ContentValues();
            ans40[count].put(KEY_ANSWER, keyAns40[count]);
            ans40[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans40[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 0)
                ans40[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans40[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans40[count].put(KEY_QUESTION_ID, QUESTION_NO_40);
            db.insert(TABLE_ANSWER, null, ans40[count]);
        }

        int[] keyAns41 = {R.string.ans_type1_que41_1,R.string.ans_type1_que41_2,R.string.ans_type1_que41_3,R.string.ans_type1_que41_4};
        ContentValues[] ans41 = new ContentValues[4];
        for(int count=0; count<4; count++){
            ans41[count] = new ContentValues();
            ans41[count].put(KEY_ANSWER, keyAns41[count]);
            ans41[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans41[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if(count == 1)
                ans41[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans41[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans41[count].put(KEY_QUESTION_ID, QUESTION_NO_41);
            db.insert(TABLE_ANSWER, null, ans41[count]);
        }

        int[] keyAns42 = {R.string.ans_type1_que42_1,R.string.ans_type1_que42_2,R.string.ans_type1_que42_3,R.string.ans_type1_que42_4};
        ContentValues[] ans42 = new ContentValues[4];
        for(int count=0; count<4; count++){
            ans42[count] = new ContentValues();
            ans42[count].put(KEY_ANSWER, keyAns42[count]);
            ans42[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans42[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if(count == 1)
                ans42[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans42[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans42[count].put(KEY_QUESTION_ID, QUESTION_NO_42);
            db.insert(TABLE_ANSWER, null, ans42[count]);
        }

        int[] keyAns43 = {R.string.ans_type1_que43_1,R.string.ans_type1_que43_2,R.string.ans_type1_que43_3,R.string.ans_type1_que43_4};
        ContentValues[] ans43 = new ContentValues[4];
        for(int count=0; count<4; count++){
            ans43[count] = new ContentValues();
            ans43[count].put(KEY_ANSWER, keyAns43[count]);
            ans43[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans43[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if(count == 1)
                ans43[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans43[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans43[count].put(KEY_QUESTION_ID, QUESTION_NO_43);
            db.insert(TABLE_ANSWER, null, ans43[count]);
        }

        int[] keyAns44 = {R.string.ans_type1_que44_1,R.string.ans_type1_que44_2,R.string.ans_type1_que44_3,R.string.ans_type1_que44_4};
        ContentValues[] ans44 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans44[count] = new ContentValues();
            ans44[count].put(KEY_ANSWER, keyAns44[count]);
            ans44[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans44[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 2)
                ans44[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans44[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans44[count].put(KEY_QUESTION_ID, QUESTION_NO_44);
            db.insert(TABLE_ANSWER, null, ans44[count]);
        }

        int[] keyAns45 = {R.string.ans_type1_que45_1,R.string.ans_type1_que45_2,R.string.ans_type1_que45_3,R.string.ans_type1_que45_4};
        ContentValues[] ans45 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans45[count] = new ContentValues();
            ans45[count].put(KEY_ANSWER, keyAns45[count]);
            ans45[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans45[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 1)
                ans45[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans45[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans45[count].put(KEY_QUESTION_ID, QUESTION_NO_45);
            db.insert(TABLE_ANSWER, null, ans45[count]);
        }

        int[] keyAns46 = {R.string.ans_type1_que46_1,R.string.ans_type1_que46_2,R.string.ans_type1_que46_3,R.string.ans_type1_que46_4};
        ContentValues[] ans46 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans46[count] = new ContentValues();
            ans46[count].put(KEY_ANSWER, keyAns46[count]);
            ans46[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans46[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 0)
                ans46[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans46[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans46[count].put(KEY_QUESTION_ID, QUESTION_NO_46);
            db.insert(TABLE_ANSWER, null, ans46[count]);
        }

        int[] keyAns47 = {R.string.ans_type1_que47_1,R.string.ans_type1_que47_2,R.string.ans_type1_que47_3,R.string.ans_type1_que47_4};
        ContentValues[] ans47 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans47[count] = new ContentValues();
            ans47[count].put(KEY_ANSWER, keyAns47[count]);
            ans47[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans47[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 3)
                ans47[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans47[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans47[count].put(KEY_QUESTION_ID, QUESTION_NO_47);
            db.insert(TABLE_ANSWER, null, ans47[count]);
        }

        int[] keyAns48 = {R.string.ans_type1_que48_1,R.string.ans_type1_que48_2,R.string.ans_type1_que48_3,R.string.ans_type1_que48_4};
        ContentValues[] ans48 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans48[count] = new ContentValues();
            ans48[count].put(KEY_ANSWER, keyAns48[count]);
            ans48[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans48[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 3)
                ans48[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans48[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans48[count].put(KEY_QUESTION_ID, QUESTION_NO_48);
            db.insert(TABLE_ANSWER, null, ans48[count]);
        }

        int[] keyAns49 = {R.string.ans_type1_que49_1,R.string.ans_type1_que49_2,R.string.ans_type1_que49_3,R.string.ans_type1_que49_4};
        ContentValues[] ans49 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans49[count] = new ContentValues();
            ans49[count].put(KEY_ANSWER, keyAns49[count]);
            ans49[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans49[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 1)
                ans49[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans49[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans49[count].put(KEY_QUESTION_ID, QUESTION_NO_49);
            db.insert(TABLE_ANSWER, null, ans49[count]);
        }

        int[] keyAns50 = {R.string.ans_type1_que50_1,R.string.ans_type1_que50_2,R.string.ans_type1_que50_3,R.string.ans_type1_que50_4};
        ContentValues[] ans50 = new ContentValues[4];
        for(int count=0; count<4; count++) {
            ans50[count] = new ContentValues();
            ans50[count].put(KEY_ANSWER, keyAns50[count]);
            ans50[count].put(KEY_TYPE, Utils.TYPE_NORMAL);
            ans50[count].put(KEY_RESOURCE, Utils.MUL_OPTIONS);
            if (count == 0)
                ans50[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans50[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans50[count].put(KEY_QUESTION_ID, QUESTION_NO_50);
            db.insert(TABLE_ANSWER, null, ans50[count]);
        }


    }

    private void insertAnsType2(SQLiteDatabase db) {
        final int QUESTION_NO_501 = 501;
        final int QUESTION_NO_502 = 502;
        final int QUESTION_NO_503 = 503;
        final int QUESTION_NO_504 = 504;
        final int QUESTION_NO_505 = 505;
        final int QUESTION_NO_506 = 506;
        final int QUESTION_NO_507 = 507;
        final int QUESTION_NO_508 = 508;
        final int QUESTION_NO_509 = 509;
        final int QUESTION_NO_510 = 510;
        final int QUESTION_NO_511 = 511;
        final int QUESTION_NO_512 = 512;
        final int QUESTION_NO_513 = 513;
        final int QUESTION_NO_514 = 514;
        final int QUESTION_NO_515 = 515;
        final int QUESTION_NO_516 = 516;
        final int QUESTION_NO_517 = 517;
        final int QUESTION_NO_518 = 518;
        final int QUESTION_NO_519 = 519;
        final int QUESTION_NO_520 = 520;
        final int QUESTION_NO_521 = 521;
        final int QUESTION_NO_522 = 522;
        final int QUESTION_NO_523 = 523;
        final int QUESTION_NO_524 = 524;
        final int QUESTION_NO_525 = 525;
        final int QUESTION_NO_526 = 526;
        final int QUESTION_NO_527 = 527;
        final int QUESTION_NO_528 = 528;
        final int QUESTION_NO_529 = 529;
        final int QUESTION_NO_530 = 530;
        final int QUESTION_NO_531 = 531;
        final int QUESTION_NO_532 = 532;
        final int QUESTION_NO_533 = 533;
        final int QUESTION_NO_534 = 534;
        final int QUESTION_NO_535 = 535;
        final int QUESTION_NO_536 = 536;
        final int QUESTION_NO_537 = 537;
        final int QUESTION_NO_538 = 538;
        final int QUESTION_NO_539 = 539;
        final int QUESTION_NO_540 = 540;
        final int QUESTION_NO_541 = 541;
        final int QUESTION_NO_542 = 542;
        final int QUESTION_NO_543 = 543;
        final int QUESTION_NO_544 = 544;
        final int QUESTION_NO_545 = 545;
        final int QUESTION_NO_546 = 546;
        final int QUESTION_NO_547 = 547;
        final int QUESTION_NO_548 = 548;
        final int QUESTION_NO_549 = 549;
        final int QUESTION_NO_550 = 550;
        final int QUESTION_NO_551 = 551;
        final int QUESTION_NO_552 = 552;
        final int QUESTION_NO_553 = 553;
        final int QUESTION_NO_554 = 554;
        final int QUESTION_NO_555 = 555;
        final int QUESTION_NO_556 = 556;
        final int QUESTION_NO_557 = 557;
        final int QUESTION_NO_558 = 558;
        final int QUESTION_NO_559 = 559;
        final int QUESTION_NO_560 = 560;
        final int QUESTION_NO_561 = 561;
        final int QUESTION_NO_562 = 562;
        final int QUESTION_NO_563 = 563;
        final int QUESTION_NO_564 = 564;
        final int QUESTION_NO_565 = 565;
        final int QUESTION_NO_566 = 566;
        final int QUESTION_NO_567 = 567;
        final int QUESTION_NO_568 = 568;
        final int QUESTION_NO_569 = 569;
        final int QUESTION_NO_570 = 570;
        final int QUESTION_NO_571 = 571;
        final int QUESTION_NO_572 = 572;
        final int QUESTION_NO_573 = 573;
        final int QUESTION_NO_574 = 574;
        final int QUESTION_NO_575 = 575;
        final int QUESTION_NO_576 = 576;
        final int QUESTION_NO_577 = 577;
        final int QUESTION_NO_578 = 578;
        final int QUESTION_NO_579 = 579;
        final int QUESTION_NO_580 = 580;
        final int QUESTION_NO_581 = 581;
        final int QUESTION_NO_582 = 582;
        final int QUESTION_NO_583 = 583;
        final int QUESTION_NO_584 = 584;
        final int QUESTION_NO_585 = 585;
        final int QUESTION_NO_586 = 586;
        final int QUESTION_NO_587 = 587;
        final int QUESTION_NO_588 = 588;
        final int QUESTION_NO_589 = 589;
        final int QUESTION_NO_590 = 590;
        final int QUESTION_NO_591 = 591;
        final int QUESTION_NO_592 = 592;
        final int QUESTION_NO_593 = 593;
        final int QUESTION_NO_594 = 594;
        final int QUESTION_NO_595 = 595;
        final int QUESTION_NO_596 = 596;
        final int QUESTION_NO_597 = 597;
        final int QUESTION_NO_598 = 598;
        final int QUESTION_NO_599 = 599;
        final int QUESTION_NO_600 = 600;

        StringBuilder columnStringBuilder = new StringBuilder();
        columnStringBuilder.append(KEY_ANSWER).append(", ")
                .append(KEY_TYPE).append(", ").append(KEY_RESOURCE)
                .append(", ").append(KEY_IS_CORRECT).append(", ")
                .append(KEY_QUESTION_ID);

        int[] keyAns1 = {R.drawable.asiatic_lily, R.drawable.bee_orchid, R.drawable.bicolor_alyce_clover, R.drawable.dwarf_powder_puff};
        ContentValues[] ans1 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans1[count] = new ContentValues();
            ans1[count].put(KEY_ANSWER, keyAns1[count]);
            ans1[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans1[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans1[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans1[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans1[count].put(KEY_QUESTION_ID, QUESTION_NO_501);
            db.insert(TABLE_ANSWER, null, ans1[count]);
        }

        int[] keyAns2 = {R.drawable.flax, R.drawable.bee_orchid, R.drawable.bicolor_alyce_clover, R.drawable.dwarf_powder_puff};
        ContentValues[] ans2 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans2[count] = new ContentValues();
            ans2[count].put(KEY_ANSWER, keyAns2[count]);
            ans2[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans2[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans2[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans2[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans2[count].put(KEY_QUESTION_ID, QUESTION_NO_502);
            db.insert(TABLE_ANSWER, null, ans2[count]);
        }

        int[] keyAns3 = {R.drawable.flax, R.drawable.golden_arch_dendrobium, R.drawable.johnson_s_amaryllis, R.drawable.hungarian_black_chilli};
        ContentValues[] ans3 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans3[count] = new ContentValues();
            ans3[count].put(KEY_ANSWER, keyAns3[count]);
            ans3[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans3[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 3)
                ans3[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans3[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans3[count].put(KEY_QUESTION_ID, QUESTION_NO_503);
            db.insert(TABLE_ANSWER, null, ans3[count]);
        }

        int[] keyAns4 = {R.drawable.princess_flower, R.drawable.queen_crape_myrtle, R.drawable.red_vanda, R.drawable.shoofly_plant};
        ContentValues[] ans4 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans4[count] = new ContentValues();
            ans4[count].put(KEY_ANSWER, keyAns4[count]);
            ans4[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans4[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans4[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans4[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans4[count].put(KEY_QUESTION_ID, QUESTION_NO_504);
            db.insert(TABLE_ANSWER, null, ans4[count]);
        }

        int[] keyAns5 = {R.drawable.chameleon_plant,R.drawable.green_taro,R.drawable.peace_lily,R.drawable.wild_daffodil};
        ContentValues[] ans5 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans5[count] = new ContentValues();
            ans5[count].put(KEY_ANSWER, keyAns5[count]);
            ans5[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans5[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans5[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans5[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans5[count].put(KEY_QUESTION_ID, QUESTION_NO_505);
            db.insert(TABLE_ANSWER, null, ans5[count]);
        }

        int[] keyAns6 = {R.drawable.wights_myriactis,R.drawable.stepladder_ginger,R.drawable.peace_lily,R.drawable.long_leaf_pondweed};
        ContentValues[] ans6 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans6[count] = new ContentValues();
            ans6[count].put(KEY_ANSWER, keyAns6[count]);
            ans6[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans6[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans6[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans6[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans6[count].put(KEY_QUESTION_ID, QUESTION_NO_506);
            db.insert(TABLE_ANSWER, null, ans6[count]);
        }

        int[] keyAns7 = {R.drawable.wights_myriactis,R.drawable.wights_twisted_arum,R.drawable.long_flowered_spider_lily,R.drawable.long_leaf_pondweed};
        ContentValues[] ans7 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans7[count] = new ContentValues();
            ans7[count].put(KEY_ANSWER, keyAns7[count]);
            ans7[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans7[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans7[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans7[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans7[count].put(KEY_QUESTION_ID, QUESTION_NO_507);
            db.insert(TABLE_ANSWER, null, ans7[count]);
        }

        int[] keyAns8 = {R.drawable.malabar_nutmeg,R.drawable.pond_apple,R.drawable.bitter_nutmeg,R.drawable.hard_fruit_alphonsea};
        ContentValues[] ans8 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans8[count] = new ContentValues();
            ans8[count].put(KEY_ANSWER, keyAns8[count]);
            ans8[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans8[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans8[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans8[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans8[count].put(KEY_QUESTION_ID, QUESTION_NO_508);
            db.insert(TABLE_ANSWER, null, ans8[count]);
        }

        int[] keyAns9 = {R.drawable.champa,R.drawable.angelwing_jasmine,R.drawable.bower_vine,R.drawable.japanese_honeysuckle};
        ContentValues[] ans9 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans9[count] = new ContentValues();
            ans9[count].put(KEY_ANSWER, keyAns9[count]);
            ans9[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans9[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 3)
                ans9[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans9[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans9[count].put(KEY_QUESTION_ID, QUESTION_NO_509);
            db.insert(TABLE_ANSWER, null, ans9[count]);
        }

        int[] keyAns10 = {R.drawable.magnolia,R.drawable.angelwing_jasmine,R.drawable.wax_flower,R.drawable.ylang_ylang};
        ContentValues[] ans10 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans10[count] = new ContentValues();
            ans10[count].put(KEY_ANSWER, keyAns10[count]);
            ans10[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans10[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans10[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans10[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans10[count].put(KEY_QUESTION_ID, QUESTION_NO_510);
            db.insert(TABLE_ANSWER, null, ans10[count]);
        }

        int[] keyAns11 = {R.drawable.wax_flower, R.drawable.bee_orchid, R.drawable.ylang_ylang, R.drawable.wax_flower};
        ContentValues[] ans11 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans11[count] = new ContentValues();
            ans11[count].put(KEY_ANSWER, keyAns11[count]);
            ans11[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans11[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans11[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans11[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans11[count].put(KEY_QUESTION_ID, QUESTION_NO_511);
            db.insert(TABLE_ANSWER, null, ans11[count]);
        }

        int[] keyAns12 = {R.drawable.tulip_tree, R.drawable.himalayan_aster, R.drawable.creeping_zinnia, R.drawable.wax_flower};
        ContentValues[] ans12 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans12[count] = new ContentValues();
            ans12[count].put(KEY_ANSWER, keyAns12[count]);
            ans12[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans12[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 3)
                ans12[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans12[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans12[count].put(KEY_QUESTION_ID, QUESTION_NO_512);
            db.insert(TABLE_ANSWER, null, ans12[count]);
        }

        int[] keyAns13 = {R.drawable.nilofar, R.drawable.sunset_bells, R.drawable.mexican_oleander, R.drawable.aloe_vera};
        ContentValues[] ans13 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans13[count] = new ContentValues();
            ans13[count].put(KEY_ANSWER, keyAns13[count]);
            ans13[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans13[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans13[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans13[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans13[count].put(KEY_QUESTION_ID, QUESTION_NO_513);
            db.insert(TABLE_ANSWER, null, ans13[count]);
        }

        int[] keyAns14 = {R.drawable.gloxinia, R.drawable.yellow_pond_lily, R.drawable.mexican_oleander, R.drawable.creeping_zinnia};
        ContentValues[] ans14 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans14[count] = new ContentValues();
            ans14[count].put(KEY_ANSWER, keyAns14[count]);
            ans14[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans14[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans14[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans14[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans14[count].put(KEY_QUESTION_ID, QUESTION_NO_514);
            db.insert(TABLE_ANSWER, null, ans14[count]);
        }

        int[] keyAns15 = {R.drawable.egg_magnolia,R.drawable.fragrant_yellow_geranium,R.drawable.himalayan_melastome,R.drawable.wallich_geranium};
        ContentValues[] ans15 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans15[count] = new ContentValues();
            ans15[count].put(KEY_ANSWER, keyAns15[count]);
            ans15[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans15[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans15[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans15[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans15[count].put(KEY_QUESTION_ID, QUESTION_NO_515);
            db.insert(TABLE_ANSWER, null, ans15[count]);
        }

        int[] keyAns16 = {R.drawable.campbell_s_magnolia,R.drawable.trailing_geranium,R.drawable.tibetan_willow_herb,R.drawable.long_leaf_pondweed};
        ContentValues[] ans16 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans16[count] = new ContentValues();
            ans16[count].put(KEY_ANSWER, keyAns16[count]);
            ans16[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans16[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans16[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans16[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans16[count].put(KEY_QUESTION_ID, QUESTION_NO_516);
            db.insert(TABLE_ANSWER, null, ans16[count]);
        }

        int[] keyAns17 = {R.drawable.campbell_s_magnolia,R.drawable.tibetan_willow_herb,R.drawable.devil_s_tongue,R.drawable.long_leaf_pondweed};
        ContentValues[] ans17 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans17[count] = new ContentValues();
            ans17[count].put(KEY_ANSWER, keyAns17[count]);
            ans17[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans17[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans17[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans17[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans17[count].put(KEY_QUESTION_ID, QUESTION_NO_517);
            db.insert(TABLE_ANSWER, null, ans17[count]);
        }

        int[] keyAns18 = {R.drawable.small_flowered_willow_herb,R.drawable.himalayan_peony,R.drawable.egg_magnolia,R.drawable.hard_fruit_alphonsea};
        ContentValues[] ans18 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans18[count] = new ContentValues();
            ans18[count].put(KEY_ANSWER, keyAns18[count]);
            ans18[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans18[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans18[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans18[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans18[count].put(KEY_QUESTION_ID, QUESTION_NO_518);
            db.insert(TABLE_ANSWER, null, ans18[count]);
        }

        int[] keyAns19 = {R.drawable.bitter_nutmeg,R.drawable.malabar_nutmeg,R.drawable.tulip_tree,R.drawable.pond_apple};
        ContentValues[] ans19 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans19[count] = new ContentValues();
            ans19[count].put(KEY_ANSWER, keyAns19[count]);
            ans19[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans19[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 3)
                ans19[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans19[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans19[count].put(KEY_QUESTION_ID, QUESTION_NO_519);
            db.insert(TABLE_ANSWER, null, ans19[count]);
        }

        int[] keyAns20 = {R.drawable.long_leaf_pondweed,R.drawable.stepladder_ginger,R.drawable.peace_lily,R.drawable.green_taro};
        ContentValues[] ans20 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans20[count] = new ContentValues();
            ans20[count].put(KEY_ANSWER, keyAns20[count]);
            ans20[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans20[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans20[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans20[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans20[count].put(KEY_QUESTION_ID, QUESTION_NO_520);
            db.insert(TABLE_ANSWER, null, ans20[count]);
        }

        int[] keyAns21 = {R.drawable.peace_lily,R.drawable.wights_twisted_arum,R.drawable.chameleon_plant,R.drawable.wild_daffodil};
        ContentValues[] ans21 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans21[count] = new ContentValues();
            ans21[count].put(KEY_ANSWER, keyAns21[count]);
            ans21[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans21[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans21[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans21[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans21[count].put(KEY_QUESTION_ID, QUESTION_NO_521);
            db.insert(TABLE_ANSWER, null, ans21[count]);
        }

        int[] keyAns22 = {R.drawable.campbell_s_magnolia,R.drawable.malabar_nutmeg,R.drawable.bitter_nutmeg,R.drawable.tulip_tree};
        ContentValues[] ans22 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans22[count] = new ContentValues();
            ans22[count].put(KEY_ANSWER, keyAns22[count]);
            ans22[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans22[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans22[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans22[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans22[count].put(KEY_QUESTION_ID, QUESTION_NO_522);
            db.insert(TABLE_ANSWER, null, ans22[count]);
        }

        int[] keyAns23 = {R.drawable.hard_fruit_alphonsea,R.drawable.malabar_nutmeg,R.drawable.pond_apple,R.drawable.campbell_s_magnolia};
        ContentValues[] ans23 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans23[count] = new ContentValues();
            ans23[count].put(KEY_ANSWER, keyAns23[count]);
            ans23[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans23[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 3)
                ans23[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans23[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans23[count].put(KEY_QUESTION_ID, QUESTION_NO_523);
            db.insert(TABLE_ANSWER, null, ans23[count]);
        }

        int[] keyAns24 = {R.drawable.hard_fruit_alphonsea,R.drawable.malabar_nutmeg,R.drawable.pond_apple,R.drawable.campbell_s_magnolia};
        ContentValues[] ans24 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans24[count] = new ContentValues();
            ans24[count].put(KEY_ANSWER, keyAns24[count]);
            ans24[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans24[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans24[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans24[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans24[count].put(KEY_QUESTION_ID, QUESTION_NO_524);
            db.insert(TABLE_ANSWER, null, ans24[count]);
        }

        int[] keyAns25 = {R.drawable.campbell_s_magnolia,R.drawable.bitter_nutmeg,R.drawable.pond_apple,R.drawable.tulip_tree};
        ContentValues[] ans25 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans25[count] = new ContentValues();
            ans25[count].put(KEY_ANSWER, keyAns25[count]);
            ans25[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans25[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans25[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans25[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans25[count].put(KEY_QUESTION_ID, QUESTION_NO_525);
            db.insert(TABLE_ANSWER, null, ans25[count]);
        }

        int[] keyAns26 = {R.drawable.campbell_s_magnolia,R.drawable.bitter_nutmeg,R.drawable.pond_apple,R.drawable.tulip_tree};
        ContentValues[] ans26 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans26[count] = new ContentValues();
            ans26[count].put(KEY_ANSWER, keyAns26[count]);
            ans26[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans26[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 3)
                ans26[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans26[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans26[count].put(KEY_QUESTION_ID, QUESTION_NO_526);
            db.insert(TABLE_ANSWER, null, ans26[count]);
        }

        int[] keyAns27 = {R.drawable.campbell_s_magnolia,R.drawable.hard_fruit_alphonsea,R.drawable.pond_apple,R.drawable.malabar_nutmeg};
        ContentValues[] ans27 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans27[count] = new ContentValues();
            ans27[count].put(KEY_ANSWER, keyAns27[count]);
            ans27[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans27[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 3)
                ans27[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans27[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans27[count].put(KEY_QUESTION_ID, QUESTION_NO_527);
            db.insert(TABLE_ANSWER, null, ans27[count]);
        }

        int[] keyAns28 = {R.drawable.bower_vine,R.drawable.common_white_frangipani,R.drawable.wax_flower,R.drawable.angelwing_jasmine};
        ContentValues[] ans28 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans28[count] = new ContentValues();
            ans28[count].put(KEY_ANSWER, keyAns28[count]);
            ans28[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans28[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans28[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans28[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans28[count].put(KEY_QUESTION_ID, QUESTION_NO_528);
            db.insert(TABLE_ANSWER, null, ans28[count]);
        }

        int[] keyAns29 = {R.drawable.dwarf_magnolia,R.drawable.champa,R.drawable.wax_flower,R.drawable.common_white_frangipani};
        ContentValues[] ans29 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans29[count] = new ContentValues();
            ans29[count].put(KEY_ANSWER, keyAns29[count]);
            ans29[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans29[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans29[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans29[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans29[count].put(KEY_QUESTION_ID, QUESTION_NO_529);
            db.insert(TABLE_ANSWER, null, ans29[count]);
        }

        int[] keyAns30 = {R.drawable.dwarf_magnolia,R.drawable.champa,R.drawable.wax_flower,R.drawable.common_white_frangipani};
        ContentValues[] ans30 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans30[count] = new ContentValues();
            ans30[count].put(KEY_ANSWER, keyAns30[count]);
            ans30[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans30[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans30[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans30[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans30[count].put(KEY_QUESTION_ID, QUESTION_NO_530);
            db.insert(TABLE_ANSWER, null, ans30[count]);
        }

        int[] keyAns31 = {R.drawable.champa,R.drawable.bower_vine,R.drawable.hari_champa,R.drawable.common_white_frangipani};
        ContentValues[] ans31 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans31[count] = new ContentValues();
            ans31[count].put(KEY_ANSWER, keyAns31[count]);
            ans31[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans31[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans31[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans31[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans31[count].put(KEY_QUESTION_ID, QUESTION_NO_531);
            db.insert(TABLE_ANSWER, null, ans31[count]);
        }

        int[] keyAns32 = {R.drawable.champa,R.drawable.bower_vine,R.drawable.dwarf_magnolia,R.drawable.wax_flower};
        ContentValues[] ans32 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans32[count] = new ContentValues();
            ans32[count].put(KEY_ANSWER, keyAns32[count]);
            ans32[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans32[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans32[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans32[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans32[count].put(KEY_QUESTION_ID, QUESTION_NO_532);
            db.insert(TABLE_ANSWER, null, ans32[count]);
        }

        int[] keyAns33 = {R.drawable.champa,R.drawable.dwarf_magnolia,R.drawable.hari_champa,R.drawable.common_white_frangipani};
        ContentValues[] ans33 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans33[count] = new ContentValues();
            ans33[count].put(KEY_ANSWER, keyAns33[count]);
            ans33[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans33[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans33[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans33[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans33[count].put(KEY_QUESTION_ID, QUESTION_NO_533);
            db.insert(TABLE_ANSWER, null, ans33[count]);
        }

        int[] keyAns34 = {R.drawable.champa,R.drawable.dwarf_magnolia,R.drawable.hari_champa,R.drawable.wax_flower};
        ContentValues[] ans34 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans34[count] = new ContentValues();
            ans34[count].put(KEY_ANSWER, keyAns34[count]);
            ans34[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans34[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 3)
                ans34[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans34[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans34[count].put(KEY_QUESTION_ID, QUESTION_NO_534);
            db.insert(TABLE_ANSWER, null, ans34[count]);
        }

        int[] keyAns35 = {R.drawable.dwarf_magnolia,R.drawable.hari_champa,R.drawable.ylang_ylang,R.drawable.wax_flower};
        ContentValues[] ans35 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans35[count] = new ContentValues();
            ans35[count].put(KEY_ANSWER, keyAns35[count]);
            ans35[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans35[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans35[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans35[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans35[count].put(KEY_QUESTION_ID, QUESTION_NO_535);
            db.insert(TABLE_ANSWER, null, ans35[count]);
        }

        int[] keyAns36 = {R.drawable.dwarf_magnolia,R.drawable.hari_champa,R.drawable.potato_vine,R.drawable.wax_flower};
        ContentValues[] ans36 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans36[count] = new ContentValues();
            ans36[count].put(KEY_ANSWER, keyAns36[count]);
            ans36[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans36[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans36[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans36[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans36[count].put(KEY_QUESTION_ID, QUESTION_NO_536);
            db.insert(TABLE_ANSWER, null, ans36[count]);
        }

        int[] keyAns37 = {R.drawable.mexican_oleander,R.drawable.nilofar,R.drawable.potato_vine,R.drawable.creeping_zinnia};
        ContentValues[] ans37 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans37[count] = new ContentValues();
            ans37[count].put(KEY_ANSWER, keyAns37[count]);
            ans37[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans37[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans37[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans37[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans37[count].put(KEY_QUESTION_ID, QUESTION_NO_537);
            db.insert(TABLE_ANSWER, null, ans37[count]);
        }

        int[] keyAns38 = {R.drawable.sunset_bells,R.drawable.nilofar,R.drawable.potato_vine,R.drawable.marigold_yellow};
        ContentValues[] ans38 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans38[count] = new ContentValues();
            ans38[count].put(KEY_ANSWER, keyAns38[count]);
            ans38[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans38[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans38[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans38[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans38[count].put(KEY_QUESTION_ID, QUESTION_NO_538);
            db.insert(TABLE_ANSWER, null, ans38[count]);
        }

        int[] keyAns39 = {R.drawable.mexican_oleander,R.drawable.nilofar,R.drawable.creeping_zinnia,R.drawable.gloxinia};
        ContentValues[] ans39 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans39[count] = new ContentValues();
            ans39[count].put(KEY_ANSWER, keyAns39[count]);
            ans39[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans39[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans39[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans39[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans39[count].put(KEY_QUESTION_ID, QUESTION_NO_539);
            db.insert(TABLE_ANSWER, null, ans39[count]);
        }

        int[] keyAns40 = {R.drawable.nilofar,R.drawable.gloxinia,R.drawable.creeping_zinnia,R.drawable.yellow_pond_lily};
        ContentValues[] ans40 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans40[count] = new ContentValues();
            ans40[count].put(KEY_ANSWER, keyAns40[count]);
            ans40[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans40[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 3)
                ans40[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans40[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans40[count].put(KEY_QUESTION_ID, QUESTION_NO_540);
            db.insert(TABLE_ANSWER, null, ans40[count]);
        }

        int[] keyAns41 = {R.drawable.sunset_bells,R.drawable.nilofar,R.drawable.potato_vine,R.drawable.marigold_yellow};
        ContentValues[] ans41 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans41[count] = new ContentValues();
            ans41[count].put(KEY_ANSWER, keyAns41[count]);
            ans41[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans41[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans41[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans41[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans41[count].put(KEY_QUESTION_ID, QUESTION_NO_541);
            db.insert(TABLE_ANSWER, null, ans41[count]);
        }

        int[] keyAns42 = {R.drawable.sunset_bells,R.drawable.marigold_yellow,R.drawable.yellow_pond_lily,R.drawable.gloxinia};
        ContentValues[] ans42 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans42[count] = new ContentValues();
            ans42[count].put(KEY_ANSWER, keyAns42[count]);
            ans42[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans42[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans42[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans42[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans42[count].put(KEY_QUESTION_ID, QUESTION_NO_542);
            db.insert(TABLE_ANSWER, null, ans42[count]);
        }

        int[] keyAns43 = {R.drawable.mexican_oleander,R.drawable.nilofar,R.drawable.white_water_lily,R.drawable.gloxinia};
        ContentValues[] ans43 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans43[count] = new ContentValues();
            ans43[count].put(KEY_ANSWER, keyAns43[count]);
            ans43[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans43[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans43[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans43[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans43[count].put(KEY_QUESTION_ID, QUESTION_NO_543);
            db.insert(TABLE_ANSWER, null, ans43[count]);
        }

        int[] keyAns44 = {R.drawable.nilofar,R.drawable.gloxinia,R.drawable.creeping_zinnia,R.drawable.yellow_pond_lily};
        ContentValues[] ans44 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans44[count] = new ContentValues();
            ans44[count].put(KEY_ANSWER, keyAns44[count]);
            ans44[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans44[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans44[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans44[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans44[count].put(KEY_QUESTION_ID, QUESTION_NO_544);
            db.insert(TABLE_ANSWER, null, ans44[count]);
        }

        int[] keyAns45 = {R.drawable.thread_leaved_water_crowfoot,R.drawable.tibetan_willow_herb,R.drawable.wallich_geranium,R.drawable.small_flowered_willow_herb};
        ContentValues[] ans45 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans45[count] = new ContentValues();
            ans45[count].put(KEY_ANSWER, keyAns45[count]);
            ans45[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans45[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans45[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans45[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans45[count].put(KEY_QUESTION_ID, QUESTION_NO_545);
            db.insert(TABLE_ANSWER, null, ans45[count]);
        }

        int[] keyAns46 = {R.drawable.tibetan_willow_herb,R.drawable.devil_s_tongue,R.drawable.himalayan_peony,R.drawable.small_flowered_willow_herb};
        ContentValues[] ans46 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans46[count] = new ContentValues();
            ans46[count].put(KEY_ANSWER, keyAns46[count]);
            ans46[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans46[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans46[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans46[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans46[count].put(KEY_QUESTION_ID, QUESTION_NO_546);
            db.insert(TABLE_ANSWER, null, ans46[count]);
        }

        int[] keyAns47 = {R.drawable.himalayan_melastome,R.drawable.devil_s_tongue,R.drawable.fragrant_yellow_geranium,R.drawable.thread_leaved_water_crowfoot};
        ContentValues[] ans47 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans47[count] = new ContentValues();
            ans47[count].put(KEY_ANSWER, keyAns47[count]);
            ans47[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans47[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans47[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans47[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans47[count].put(KEY_QUESTION_ID, QUESTION_NO_547);
            db.insert(TABLE_ANSWER, null, ans47[count]);
        }

        int[] keyAns48 = {R.drawable.thread_leaved_water_crowfoot,R.drawable.tibetan_willow_herb,R.drawable.wallich_geranium,R.drawable.fragrant_yellow_geranium};
        ContentValues[] ans48 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans48[count] = new ContentValues();
            ans48[count].put(KEY_ANSWER, keyAns48[count]);
            ans48[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans48[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 3)
                ans48[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans48[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans48[count].put(KEY_QUESTION_ID, QUESTION_NO_548);
            db.insert(TABLE_ANSWER, null, ans48[count]);
        }

        int[] keyAns49 = {R.drawable.wallich_geranium,R.drawable.devil_s_tongue,R.drawable.himalayan_peony,R.drawable.small_flowered_willow_herb};
        ContentValues[] ans49 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans49[count] = new ContentValues();
            ans49[count].put(KEY_ANSWER, keyAns49[count]);
            ans49[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans49[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans49[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans49[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans49[count].put(KEY_QUESTION_ID, QUESTION_NO_549);
            db.insert(TABLE_ANSWER, null, ans49[count]);
        }

        int[] keyAns50 = {R.drawable.himalayan_melastome,R.drawable.devil_s_tongue,R.drawable.himalayan_peony,R.drawable.fragrant_yellow_geranium};
        ContentValues[] ans50 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans50[count] = new ContentValues();
            ans50[count].put(KEY_ANSWER, keyAns50[count]);
            ans50[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans50[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans50[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans50[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans50[count].put(KEY_QUESTION_ID, QUESTION_NO_550);
            db.insert(TABLE_ANSWER, null, ans50[count]);
        }

        int[] keyAns51 = {R.drawable.asiatic_lily,R.drawable.century_plant,R.drawable.himalayan_peony,R.drawable.fragrant_yellow_geranium};
        ContentValues[] ans51 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans51[count] = new ContentValues();
            ans51[count].put(KEY_ANSWER, keyAns51[count]);
            ans51[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans51[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans51[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans51[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans51[count].put(KEY_QUESTION_ID, QUESTION_NO_551);
            db.insert(TABLE_ANSWER, null, ans51[count]);
        }

        int[] keyAns52 = {R.drawable.gasteria,R.drawable.century_plant,R.drawable.spider_aloe,R.drawable.trifid_sedum};
        ContentValues[] ans52 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans52[count] = new ContentValues();
            ans52[count].put(KEY_ANSWER, keyAns52[count]);
            ans52[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans52[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans52[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans52[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans52[count].put(KEY_QUESTION_ID, QUESTION_NO_552);
            db.insert(TABLE_ANSWER, null, ans52[count]);
        }

        int[] keyAns53 = {R.drawable.jade_plant,R.drawable.century_plant,R.drawable.aloe_vera,R.drawable.trifid_sedum};
        ContentValues[] ans53 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans53[count] = new ContentValues();
            ans53[count].put(KEY_ANSWER, keyAns53[count]);
            ans53[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans53[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans53[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans53[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans53[count].put(KEY_QUESTION_ID, QUESTION_NO_553);
            db.insert(TABLE_ANSWER, null, ans53[count]);
        }

        int[] keyAns54 = {R.drawable.gasteria,R.drawable.century_plant,R.drawable.silver_vase_bromeliad,R.drawable.soap_aloe};
        ContentValues[] ans54 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans54[count] = new ContentValues();
            ans54[count].put(KEY_ANSWER, keyAns54[count]);
            ans54[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans54[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 3)
                ans54[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans54[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans54[count].put(KEY_QUESTION_ID, QUESTION_NO_554);
            db.insert(TABLE_ANSWER, null, ans54[count]);
        }

        int[] keyAns55 = {R.drawable.jade_plant,R.drawable.spider_aloe,R.drawable.aloe_vera,R.drawable.trifid_sedum};
        ContentValues[] ans55 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans55[count] = new ContentValues();
            ans55[count].put(KEY_ANSWER, keyAns55[count]);
            ans55[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans55[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans55[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans55[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans55[count].put(KEY_QUESTION_ID, QUESTION_NO_555);
            db.insert(TABLE_ANSWER, null, ans55[count]);
        }

        int[] keyAns56 = {R.drawable.jade_plant,R.drawable.delta_shaped_aloe,R.drawable.flax,R.drawable.foolproof_plant};
        ContentValues[] ans56 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans56[count] = new ContentValues();
            ans56[count].put(KEY_ANSWER, keyAns56[count]);
            ans56[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans56[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans56[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans56[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans56[count].put(KEY_QUESTION_ID, QUESTION_NO_556);
            db.insert(TABLE_ANSWER, null, ans56[count]);
        }

        int[] keyAns57 = {R.drawable.soap_aloe,R.drawable.delta_shaped_aloe,R.drawable.trifid_sedum,R.drawable.spider_aloe};
        ContentValues[] ans57 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans57[count] = new ContentValues();
            ans57[count].put(KEY_ANSWER, keyAns57[count]);
            ans57[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans57[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans57[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans57[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans57[count].put(KEY_QUESTION_ID, QUESTION_NO_557);
            db.insert(TABLE_ANSWER, null, ans57[count]);
        }

        int[] keyAns58 = {R.drawable.brazilian_vaseplant,R.drawable.jade_plant,R.drawable.foolproof_plant,R.drawable.spider_aloe};
        ContentValues[] ans58 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans58[count] = new ContentValues();
            ans58[count].put(KEY_ANSWER, keyAns58[count]);
            ans58[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans58[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans58[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans58[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans58[count].put(KEY_QUESTION_ID, QUESTION_NO_558);
            db.insert(TABLE_ANSWER, null, ans58[count]);
        }

        int[] keyAns59 = {R.drawable.silver_leaved_earth_star,R.drawable.gasteria,R.drawable.delta_shaped_aloe,R.drawable.spider_aloe};
        ContentValues[] ans59 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans59[count] = new ContentValues();
            ans59[count].put(KEY_ANSWER, keyAns59[count]);
            ans59[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans59[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans59[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans59[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans59[count].put(KEY_QUESTION_ID, QUESTION_NO_559);
            db.insert(TABLE_ANSWER, null, ans59[count]);
        }

        int[] keyAns60 = {R.drawable.jade_plant,R.drawable.delta_shaped_aloe,R.drawable.foolproof_plant,R.drawable.foolproof_plant};
        ContentValues[] ans60 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans60[count] = new ContentValues();
            ans60[count].put(KEY_ANSWER, keyAns60[count]);
            ans60[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans60[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans60[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans60[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans60[count].put(KEY_QUESTION_ID, QUESTION_NO_560);
            db.insert(TABLE_ANSWER, null, ans60[count]);
        }

        int[] keyAns61 = {R.drawable.gasteria ,R.drawable.delta_shaped_aloe,R.drawable.silver_vase_bromeliad,R.drawable.ascocenda_krailerk_alba};
        ContentValues[] ans61 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans61[count] = new ContentValues();
            ans61[count].put(KEY_ANSWER, keyAns61[count]);
            ans61[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans61[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans61[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans61[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans61[count].put(KEY_QUESTION_ID, QUESTION_NO_561);
            db.insert(TABLE_ANSWER, null, ans61[count]);
        }

        int[] keyAns62 = {R.drawable.cheerful_senecio ,R.drawable.wallich_geranium,R.drawable.tall_alplily,R.drawable.himalayan_indigo};
        ContentValues[] ans62 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans62[count] = new ContentValues();
            ans62[count].put(KEY_ANSWER, keyAns62[count]);
            ans62[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans62[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans62[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans62[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans62[count].put(KEY_QUESTION_ID, QUESTION_NO_562);
            db.insert(TABLE_ANSWER, null, ans62[count]);
        }

        int[] keyAns63 = {R.drawable.trifid_sedum ,R.drawable.kumaon_iris,R.drawable.yellow_coralroot,R.drawable.beej_karela};
        ContentValues[] ans63 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans63[count] = new ContentValues();
            ans63[count].put(KEY_ANSWER, keyAns63[count]);
            ans63[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans63[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans63[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans63[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans63[count].put(KEY_QUESTION_ID, QUESTION_NO_563);
            db.insert(TABLE_ANSWER, null, ans63[count]);
        }

        int[] keyAns64 = {R.drawable.trifid_sedum ,R.drawable.wallich_geranium,R.drawable.wights_myriactis,R.drawable.beej_karela};
        ContentValues[] ans64 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans64[count] = new ContentValues();
            ans64[count].put(KEY_ANSWER, keyAns64[count]);
            ans64[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans64[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans64[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans64[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans64[count].put(KEY_QUESTION_ID, QUESTION_NO_564);
            db.insert(TABLE_ANSWER, null, ans64[count]);
        }

        int[] keyAns65 = {R.drawable.cheerful_senecio ,R.drawable.wallich_geranium,R.drawable.tall_alplily,R.drawable.himalayan_indigo};
        ContentValues[] ans65 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans65[count] = new ContentValues();
            ans65[count].put(KEY_ANSWER, keyAns65[count]);
            ans65[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans65[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans65[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans65[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans65[count].put(KEY_QUESTION_ID, QUESTION_NO_565);
            db.insert(TABLE_ANSWER, null, ans65[count]);
        }

        int[] keyAns66 = {R.drawable.trifid_sedum ,R.drawable.kumaon_iris,R.drawable.wights_myriactis,R.drawable.beej_karela};
        ContentValues[] ans66 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans66[count] = new ContentValues();
            ans66[count].put(KEY_ANSWER, keyAns66[count]);
            ans66[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans66[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans66[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans66[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans66[count].put(KEY_QUESTION_ID, QUESTION_NO_566);
            db.insert(TABLE_ANSWER, null, ans66[count]);
        }

        int[] keyAns67 = {R.drawable.beej_karela ,R.drawable.yellow_coralroot,R.drawable.yellow_spotted_white_saxifrage,R.drawable.beej_karela};
        ContentValues[] ans67 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans67[count] = new ContentValues();
            ans67[count].put(KEY_ANSWER, keyAns67[count]);
            ans67[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans67[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans67[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans67[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans67[count].put(KEY_QUESTION_ID, QUESTION_NO_567);
            db.insert(TABLE_ANSWER, null, ans67[count]);
        }

        int[] keyAns68 = {R.drawable.cheerful_senecio ,R.drawable.wallich_geranium,R.drawable.tall_alplily,R.drawable.himalayan_indigo};
        ContentValues[] ans68 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans68[count] = new ContentValues();
            ans68[count].put(KEY_ANSWER, keyAns68[count]);
            ans68[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans68[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 3)
                ans68[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans68[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans68[count].put(KEY_QUESTION_ID, QUESTION_NO_568);
            db.insert(TABLE_ANSWER, null, ans68[count]);
        }

        int[] keyAns69 = {R.drawable.trifid_sedum ,R.drawable.tall_alplily,R.drawable.wights_myriactis,R.drawable.beej_karela};
        ContentValues[] ans69 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans69[count] = new ContentValues();
            ans69[count].put(KEY_ANSWER, keyAns69[count]);
            ans69[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans69[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 3)
                ans69[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans69[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans69[count].put(KEY_QUESTION_ID, QUESTION_NO_569);
            db.insert(TABLE_ANSWER, null, ans69[count]);
        }

        int[] keyAns70 = {R.drawable.beej_karela ,R.drawable.yellow_coralroot,R.drawable.yellow_spotted_white_saxifrage,R.drawable.beej_karela};
        ContentValues[] ans70 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans70[count] = new ContentValues();
            ans70[count].put(KEY_ANSWER, keyAns70[count]);
            ans70[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans70[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans70[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans70[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans70[count].put(KEY_QUESTION_ID, QUESTION_NO_570);
            db.insert(TABLE_ANSWER, null, ans70[count]);
        }

        int[] keyAns71 = {R.drawable.trifid_sedum ,R.drawable.kumaon_iris,R.drawable.wights_myriactis,R.drawable.beej_karela};
        ContentValues[] ans71 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans71[count] = new ContentValues();
            ans71[count].put(KEY_ANSWER, keyAns71[count]);
            ans71[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans71[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans71[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans71[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans71[count].put(KEY_QUESTION_ID, QUESTION_NO_571);
            db.insert(TABLE_ANSWER, null, ans71[count]);
        }

        int[] keyAns72 = {R.drawable.barley_brome ,R.drawable.cheatgrass,R.drawable.golden_bamboo,R.drawable.beej_karela};
        ContentValues[] ans72 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans72[count] = new ContentValues();
            ans72[count].put(KEY_ANSWER, keyAns72[count]);
            ans72[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans72[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans72[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans72[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans72[count].put(KEY_QUESTION_ID, QUESTION_NO_572);
            db.insert(TABLE_ANSWER, null, ans72[count]);
        }

        int[] keyAns73= {R.drawable.barley_brome ,R.drawable.cheatgrass,R.drawable.summer_grass,R.drawable.fringed_bulbophyllum};
        ContentValues[] ans73 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans73[count] = new ContentValues();
            ans73[count].put(KEY_ANSWER, keyAns73[count]);
            ans73[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans73[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans73[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans73[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans73[count].put(KEY_QUESTION_ID, QUESTION_NO_573);
            db.insert(TABLE_ANSWER, null, ans73[count]);
        }

        int[] keyAns74= {R.drawable.bengal_bamboo ,R.drawable.indian_thorny_bamboo,R.drawable.summer_grass,R.drawable.barley_brome};
        ContentValues[] ans74 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans74[count] = new ContentValues();
            ans74[count].put(KEY_ANSWER, keyAns74[count]);
            ans74[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans74[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 3)
                ans74[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans74[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans74[count].put(KEY_QUESTION_ID, QUESTION_NO_574);
            db.insert(TABLE_ANSWER, null, ans74[count]);
        }

        int[] keyAns75 = {R.drawable.golden_bamboo ,R.drawable.cheatgrass,R.drawable.bengal_bamboo,R.drawable.yellow_bluestem_grass};
        ContentValues[] ans75 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans75[count] = new ContentValues();
            ans75[count].put(KEY_ANSWER, keyAns75[count]);
            ans75[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans75[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 3)
                ans75[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans75[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans75[count].put(KEY_QUESTION_ID, QUESTION_NO_575);
            db.insert(TABLE_ANSWER, null, ans75[count]);
        }

        int[] keyAns76 = {R.drawable.golden_bamboo ,R.drawable.cheatgrass,R.drawable.summer_grass,R.drawable.indian_thorny_bamboo};
        ContentValues[] ans76 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans76[count] = new ContentValues();
            ans76[count].put(KEY_ANSWER, keyAns76[count]);
            ans76[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans76[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans76[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans76[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans76[count].put(KEY_QUESTION_ID, QUESTION_NO_576);
            db.insert(TABLE_ANSWER, null, ans76[count]);
        }

        int[] keyAns77= {R.drawable.bengal_bamboo ,R.drawable.indian_thorny_bamboo,R.drawable.buddha_belly_bamboo,R.drawable.barley_brome};
        ContentValues[] ans77= new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans77[count] = new ContentValues();
            ans77[count].put(KEY_ANSWER, keyAns77[count]);
            ans77[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans77[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans77[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans77[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans77[count].put(KEY_QUESTION_ID, QUESTION_NO_577);
            db.insert(TABLE_ANSWER, null, ans77[count]);
        }
        int[] keyAns78 = {R.drawable.barley_brome ,R.drawable.cheatgrass,R.drawable.bengal_bamboo,R.drawable.yellow_bluestem_grass};
        ContentValues[] ans78 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans78[count] = new ContentValues();
            ans78[count].put(KEY_ANSWER, keyAns78[count]);
            ans78[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans78[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans78[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans78[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans78[count].put(KEY_QUESTION_ID, QUESTION_NO_578);
            db.insert(TABLE_ANSWER, null, ans78[count]);
        }

        int[] keyAns79 = {R.drawable.golden_bamboo ,R.drawable.cheatgrass,R.drawable.summer_grass,R.drawable.indian_thorny_bamboo};
        ContentValues[] ans79 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans79[count] = new ContentValues();
            ans79[count].put(KEY_ANSWER, keyAns79[count]);
            ans79[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans79[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 3)
                ans79[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans79[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans79[count].put(KEY_QUESTION_ID, QUESTION_NO_579);
            db.insert(TABLE_ANSWER, null, ans79[count]);
        }

        int[] keyAns80 = {R.drawable.balcooa_bamboo ,R.drawable.dwarf_reedgrass,R.drawable.nepal_foxtail_grass,R.drawable.yellow_bluestem_grass};
        ContentValues[] ans80 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans80[count] = new ContentValues();
            ans80[count].put(KEY_ANSWER, keyAns80[count]);
            ans80[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans80[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans80[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans80[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans80[count].put(KEY_QUESTION_ID, QUESTION_NO_580);
            db.insert(TABLE_ANSWER, null, ans80[count]);
        }

        int[] keyAns81 = {R.drawable.golden_bamboo ,R.drawable.common_oat,R.drawable.summer_grass,R.drawable.mangrove_grass};
        ContentValues[] ans81 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans81[count] = new ContentValues();
            ans81[count].put(KEY_ANSWER, keyAns81[count]);
            ans81[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans81[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans81[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans81[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans81[count].put(KEY_QUESTION_ID, QUESTION_NO_581);
            db.insert(TABLE_ANSWER, null, ans81[count]);
        }

        int[] keyAns82 = {R.drawable.balcooa_bamboo ,R.drawable.dwarf_reedgrass,R.drawable.nepal_foxtail_grass,R.drawable.yellow_bluestem_grass};
        ContentValues[] ans82 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans82[count] = new ContentValues();
            ans82[count].put(KEY_ANSWER, keyAns82[count]);
            ans82[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans82[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans82[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans82[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans82[count].put(KEY_QUESTION_ID, QUESTION_NO_582);
            db.insert(TABLE_ANSWER, null, ans82[count]);
        }

        int[] keyAns83 = {R.drawable.mauritian_grass ,R.drawable.dwarf_reedgrass,R.drawable.nepal_foxtail_grass,R.drawable.tausch_s_goat_grass};
        ContentValues[] ans83 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans83[count] = new ContentValues();
            ans83[count].put(KEY_ANSWER, keyAns83[count]);
            ans83[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans83[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans83[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans83[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans83[count].put(KEY_QUESTION_ID, QUESTION_NO_583);
            db.insert(TABLE_ANSWER, null, ans83[count]);
        }

        int[] keyAns84 = {R.drawable.nepal_foxtail_grass ,R.drawable.dwarf_reedgrass,R.drawable.summer_grass,R.drawable.yellow_bluestem_grass};
        ContentValues[] ans84 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans84[count] = new ContentValues();
            ans84[count].put(KEY_ANSWER, keyAns84[count]);
            ans84[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans84[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans84[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans84[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans84[count].put(KEY_QUESTION_ID, QUESTION_NO_584);
            db.insert(TABLE_ANSWER, null, ans84[count]);
        }

        int[] keyAns85 = {R.drawable.dwarf_reedgrass ,R.drawable.yellow_bluestem_grass,R.drawable.summer_grass,R.drawable.mangrove_grass};
        ContentValues[] ans85 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans85[count] = new ContentValues();
            ans85[count].put(KEY_ANSWER, keyAns85[count]);
            ans85[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans85[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans85[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans85[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans85[count].put(KEY_QUESTION_ID, QUESTION_NO_585);
            db.insert(TABLE_ANSWER, null, ans85[count]);
        }

        int[] keyAns86 = {R.drawable.mangrove_grass ,R.drawable.dwarf_reedgrass,R.drawable.summer_grass,R.drawable.annual_blu_eyed_grass};
        ContentValues[] ans86 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans86[count] = new ContentValues();
            ans86[count].put(KEY_ANSWER, keyAns86[count]);
            ans86[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans86[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans86[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans86[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans86[count].put(KEY_QUESTION_ID, QUESTION_NO_586);
            db.insert(TABLE_ANSWER, null, ans86[count]);
        }

        int[] keyAns87 = {R.drawable.nepal_foxtail_grass ,R.drawable.alpine_sedge,R.drawable.summer_grass,R.drawable.annual_blu_eyed_grass};
        ContentValues[] ans87 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans87[count] = new ContentValues();
            ans87[count].put(KEY_ANSWER, keyAns87[count]);
            ans87[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans87[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans87[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans87[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans87[count].put(KEY_QUESTION_ID, QUESTION_NO_587);
            db.insert(TABLE_ANSWER, null, ans87[count]);
        }

        int[] keyAns88 = {R.drawable.mauritian_grass ,R.drawable.dwarf_reedgrass,R.drawable.nepal_foxtail_grass,R.drawable.swollen_finger_grass};
        ContentValues[] ans88 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans88[count] = new ContentValues();
            ans88[count].put(KEY_ANSWER, keyAns88[count]);
            ans88[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans88[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 3)
                ans88[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans88[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans88[count].put(KEY_QUESTION_ID, QUESTION_NO_588);
            db.insert(TABLE_ANSWER, null, ans88[count]);
        }

        int[] keyAns89 = {R.drawable.grass_of_the_dew ,R.drawable.dwarf_reedgrass,R.drawable.nepal_foxtail_grass,R.drawable.swollen_finger_grass};
        ContentValues[] ans89 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans89[count] = new ContentValues();
            ans89[count].put(KEY_ANSWER, keyAns89[count]);
            ans89[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans89[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans89[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans89[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans89[count].put(KEY_QUESTION_ID, QUESTION_NO_589);
            db.insert(TABLE_ANSWER, null, ans89[count]);
        }

        int[] keyAns90 = {R.drawable.grass_of_the_dew ,R.drawable.dwarf_reedgrass,R.drawable.south_indian_uvaria,R.drawable.swollen_finger_grass};
        ContentValues[] ans90 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans90[count] = new ContentValues();
            ans90[count].put(KEY_ANSWER, keyAns90[count]);
            ans90[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans90[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans90[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans90[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans90[count].put(KEY_QUESTION_ID, QUESTION_NO_590);
            db.insert(TABLE_ANSWER, null, ans90[count]);
        }

        int[] keyAns91 = {R.drawable.himalaya_onion ,R.drawable.south_indian_uvaria,R.drawable.rosy_orchid_ginger,R.drawable.elephant_foot_yam};
        ContentValues[] ans91 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans91[count] = new ContentValues();
            ans91[count].put(KEY_ANSWER, keyAns91[count]);
            ans91[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans91[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans91[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans91[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans91[count].put(KEY_QUESTION_ID, QUESTION_NO_591);
            db.insert(TABLE_ANSWER, null, ans91[count]);
        }

        int[] keyAns92 = {R.drawable.grass_of_the_dew ,R.drawable.south_indian_uvaria,R.drawable.soursop,R.drawable.chameleon_plant};
        ContentValues[] ans92 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans92[count] = new ContentValues();
            ans92[count].put(KEY_ANSWER, keyAns92[count]);
            ans92[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans92[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans92[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans92[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans92[count].put(KEY_QUESTION_ID, QUESTION_NO_592);
            db.insert(TABLE_ANSWER, null, ans92[count]);
        }

        int[] keyAns93 = {R.drawable.wintersweet ,R.drawable.rosy_orchid_ginger,R.drawable.soursop,R.drawable.chameleon_plant};
        ContentValues[] ans93 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans93[count] = new ContentValues();
            ans93[count].put(KEY_ANSWER, keyAns93[count]);
            ans93[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans93[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans93[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans93[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans93[count].put(KEY_QUESTION_ID, QUESTION_NO_593);
            db.insert(TABLE_ANSWER, null, ans93[count]);
        }

        int[] keyAns94 = {R.drawable.wintersweet ,R.drawable.elephant_foot_yam,R.drawable.soursop,R.drawable.himalaya_onion};
        ContentValues[] ans94 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans94[count] = new ContentValues();
            ans94[count].put(KEY_ANSWER, keyAns94[count]);
            ans94[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans94[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 0)
                ans94[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans94[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans94[count].put(KEY_QUESTION_ID, QUESTION_NO_594);
            db.insert(TABLE_ANSWER, null, ans94[count]);
        }

        int[] keyAns95 = {R.drawable.grass_of_the_dew ,R.drawable.south_indian_uvaria,R.drawable.soursop,R.drawable.himalaya_onion};
        ContentValues[] ans95 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans95[count] = new ContentValues();
            ans95[count].put(KEY_ANSWER, keyAns95[count]);
            ans95[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans95[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 3)
                ans95[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans95[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans95[count].put(KEY_QUESTION_ID, QUESTION_NO_595);
            db.insert(TABLE_ANSWER, null, ans95[count]);
        }

        int[] keyAns96 = {R.drawable.wintersweet ,R.drawable.elephant_foot_yam,R.drawable.soursop,R.drawable.himalaya_onion};
        ContentValues[] ans96 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans96[count] = new ContentValues();
            ans96[count].put(KEY_ANSWER, keyAns96[count]);
            ans96[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans96[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans96[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans96[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans96[count].put(KEY_QUESTION_ID, QUESTION_NO_596);
            db.insert(TABLE_ANSWER, null, ans96[count]);
        }

        int[] keyAns97 = {R.drawable.wintersweet ,R.drawable.rosy_orchid_ginger,R.drawable.soursop,R.drawable.elephant_foot_yam};
        ContentValues[] ans97 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans97[count] = new ContentValues();
            ans97[count].put(KEY_ANSWER, keyAns97[count]);
            ans97[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans97[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 3)
                ans97[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans97[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans97[count].put(KEY_QUESTION_ID, QUESTION_NO_597);
            db.insert(TABLE_ANSWER, null, ans97[count]);
        }

        int[] keyAns98 = {R.drawable.soursop ,R.drawable.elephant_foot_yam,R.drawable.rosy_orchid_ginger,R.drawable.himalaya_onion};
        ContentValues[] ans98 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans98[count] = new ContentValues();
            ans98[count].put(KEY_ANSWER, keyAns98[count]);
            ans98[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans98[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans98[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans98[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans98[count].put(KEY_QUESTION_ID, QUESTION_NO_598);
            db.insert(TABLE_ANSWER, null, ans98[count]);
        }

        int[] keyAns99 = {R.drawable.soursop ,R.drawable.wintersweet,R.drawable.elephant_foot_yam,R.drawable.himalaya_onion};
        ContentValues[] ans99 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans99[count] = new ContentValues();
            ans99[count].put(KEY_ANSWER, keyAns99[count]);
            ans99[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans99[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 2)
                ans99[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans99[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans99[count].put(KEY_QUESTION_ID, QUESTION_NO_599);
            db.insert(TABLE_ANSWER, null, ans99[count]);
        }

        int[] keyAns100 = {R.drawable.wintersweet ,R.drawable.elephant_foot_yam,R.drawable.soursop,R.drawable.himalaya_onion};
        ContentValues[] ans100 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans100[count] = new ContentValues();
            ans100[count].put(KEY_ANSWER, keyAns100[count]);
            ans100[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans100[count].put(KEY_RESOURCE, Utils.MUL_IMAGE);
            if (count == 1)
                ans100[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans100[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans100[count].put(KEY_QUESTION_ID, QUESTION_NO_600);
            db.insert(TABLE_ANSWER, null, ans100[count]);
        }

    }

    private void insertAnsType3(SQLiteDatabase db){
        final int QUESTION_NO_5001 = 5001;
        final int QUESTION_NO_5002 = 5002;
        final int QUESTION_NO_5003 = 5003;
        final int QUESTION_NO_5004 = 5004;
        final int QUESTION_NO_5005 = 5005;

        StringBuilder columnStringBuilder = new StringBuilder();
        columnStringBuilder.append(KEY_ANSWER).append(", ")
                .append(KEY_TYPE).append(", ").append(KEY_RESOURCE)
                .append(", ").append(KEY_IS_CORRECT).append(", ")
                .append(KEY_QUESTION_ID);


        //ans41
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append("(")
                .append(columnStringBuilder).append(") VALUES (")
                .append(R.string.ans_blank_1).append(", ")
                .append(Utils.TYPE_BLANK).append(", ")
                .append(Utils.TEXT).append(", ")
                .append(Utils.CORRECT).append(", ")
                .append(QUESTION_NO_5001).append(" ) ").toString());
        //ans42
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append("(")
                .append(columnStringBuilder).append(") VALUES (")
                .append(R.string.ans_blank_2).append(", ")
                .append(Utils.TYPE_BLANK).append(", ")
                .append(Utils.TEXT).append(", ")
                .append(Utils.CORRECT).append(", ")
                .append(QUESTION_NO_5002).append(" ) ").toString());
        //ans43
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append("(")
                .append(columnStringBuilder).append(") VALUES (")
                .append(R.string.ans_blank_3).append(", ")
                .append(Utils.TYPE_BLANK).append(", ")
                .append(Utils.TEXT).append(", ")
                .append(Utils.CORRECT).append(", ")
                .append(QUESTION_NO_5003).append(" ) ").toString());
        //ans44
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append("(")
                .append(columnStringBuilder).append(") VALUES (")
                .append(R.string.ans_blank_4).append(", ")
                .append(Utils.TYPE_BLANK).append(", ")
                .append(Utils.TEXT).append(", ")
                .append(Utils.CORRECT).append(", ")
                .append(QUESTION_NO_5004).append(" ) ").toString());
        //ans44
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append("(")
                .append(columnStringBuilder).append(") VALUES (")
                .append(R.string.ans_blank_5).append(", ")
                .append(Utils.TYPE_BLANK).append(", ")
                .append(Utils.TEXT).append(", ")
                .append(Utils.CORRECT).append(", ")
                .append(QUESTION_NO_5005).append(" ) ").toString());
    }

    private void insertAnsType4(SQLiteDatabase db) {

        final int QUESTION_NO_1001 = 1001;
        final int QUESTION_NO_1002 = 1002;
        final int QUESTION_NO_1003 = 1003;
        final int QUESTION_NO_1004 = 1004;
        final int QUESTION_NO_1005 = 1005;
        final int QUESTION_NO_1006 = 1006;
        final int QUESTION_NO_1007 = 1007;
        final int QUESTION_NO_1008 = 1008;
        final int QUESTION_NO_1009 = 1009;
        final int QUESTION_NO_1010 = 1010;
        final int QUESTION_NO_1011 = 1011;
        final int QUESTION_NO_1012 = 1012;
        final int QUESTION_NO_1013 = 1013;
        final int QUESTION_NO_1014 = 1014;
        final int QUESTION_NO_1015 = 1015;
        final int QUESTION_NO_1016 = 1016;
        final int QUESTION_NO_1017 = 1017;
        final int QUESTION_NO_1018 = 1018;
        final int QUESTION_NO_1019 = 1019;
        final int QUESTION_NO_1020 = 1020;
        final int QUESTION_NO_1021 = 1021;
        final int QUESTION_NO_1022 = 1022;
        final int QUESTION_NO_1023 = 1023;
        final int QUESTION_NO_1024 = 1024;
        final int QUESTION_NO_1025 = 1025;
        final int QUESTION_NO_1026 = 1026;
        final int QUESTION_NO_1027 = 1027;
        final int QUESTION_NO_1028 = 1028;
        final int QUESTION_NO_1029 = 1029;
        final int QUESTION_NO_1030 = 1030;
        final int QUESTION_NO_1031 = 1031;
        final int QUESTION_NO_1032 = 1032;
        final int QUESTION_NO_1033 = 1033;
        final int QUESTION_NO_1034 = 1034;
        final int QUESTION_NO_1035 = 1035;
        final int QUESTION_NO_1036 = 1036;
        final int QUESTION_NO_1037 = 1037;
        final int QUESTION_NO_1038 = 1038;
        final int QUESTION_NO_1039 = 1039;
        final int QUESTION_NO_1040 = 1040;
        final int QUESTION_NO_1041 = 1041;
        final int QUESTION_NO_1042 = 1042;
        final int QUESTION_NO_1043 = 1043;
        final int QUESTION_NO_1044 = 1044;
        final int QUESTION_NO_1045 = 1045;
        final int QUESTION_NO_1046 = 1046;
        final int QUESTION_NO_1047 = 1047;
        final int QUESTION_NO_1048 = 1048;
        final int QUESTION_NO_1049 = 1049;
        final int QUESTION_NO_1050 = 1050;
        final int QUESTION_NO_1051 = 1051;
        final int QUESTION_NO_1052 = 1052;
        final int QUESTION_NO_1053 = 1053;
        final int QUESTION_NO_1054 = 1054;
        final int QUESTION_NO_1055 = 1055;
        final int QUESTION_NO_1056 = 1056;
        final int QUESTION_NO_1057 = 1057;
        final int QUESTION_NO_1058 = 1058;
        final int QUESTION_NO_1059 = 1059;
        final int QUESTION_NO_1060 = 1060;
        final int QUESTION_NO_1061 = 1061;
        final int QUESTION_NO_1062 = 1062;
        final int QUESTION_NO_1063 = 1063;
        final int QUESTION_NO_1064 = 1064;
        final int QUESTION_NO_1065 = 1065;
        final int QUESTION_NO_1066 = 1066;
        final int QUESTION_NO_1067 = 1067;
        final int QUESTION_NO_1068 = 1068;
        final int QUESTION_NO_1069 = 1069;
        final int QUESTION_NO_1070 = 1070;
        final int QUESTION_NO_1071 = 1071;
        final int QUESTION_NO_1072 = 1072;
        final int QUESTION_NO_1073 = 1073;
        final int QUESTION_NO_1074 = 1074;
        final int QUESTION_NO_1075 = 1075;
        final int QUESTION_NO_1076 = 1076;
        final int QUESTION_NO_1077 = 1077;
        final int QUESTION_NO_1078 = 1078;
        final int QUESTION_NO_1079 = 1079;
        final int QUESTION_NO_1080 = 1080;
        final int QUESTION_NO_1081 = 1081;
        final int QUESTION_NO_1082 = 1082;
        final int QUESTION_NO_1083 = 1083;
        final int QUESTION_NO_1084 = 1084;
        final int QUESTION_NO_1085 = 1085;


        StringBuilder columnStringBuilder = new StringBuilder();
        columnStringBuilder.append(KEY_ANSWER).append(", ")
                .append(KEY_TYPE).append(", ").append(KEY_RESOURCE)
                .append(", ").append(KEY_IS_CORRECT).append(", ")
                .append(KEY_QUESTION_ID);

        //ans-1001
        int[] keyAns1 = {R.string.ans_type4_que1_1,R.string.ans_type4_que1_2,R.string.ans_type4_que1_3,R.string.ans_type4_que1_4};
        ContentValues[] ans1 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans1[count] = new ContentValues();
            ans1[count].put(KEY_ANSWER, keyAns1[count]);
            ans1[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans1[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans1[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans1[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans1[count].put(KEY_QUESTION_ID, QUESTION_NO_1001);
            db.insert(TABLE_ANSWER, null, ans1[count]);
        }

        //ans-1002
        int[] keyAns2 = {R.string.ans_type4_que2_1,R.string.ans_type4_que2_2,R.string.ans_type4_que2_3,R.string.ans_type4_que2_4};
        ContentValues[] ans2 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans2[count] = new ContentValues();
            ans2[count].put(KEY_ANSWER, keyAns2[count]);
            ans2[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans2[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans2[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans2[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans2[count].put(KEY_QUESTION_ID, QUESTION_NO_1002);
            db.insert(TABLE_ANSWER, null, ans2[count]);
        }

        //ans-1003
        int[] keyAns3 = {R.string.ans_type4_que3_1,R.string.ans_type4_que3_2,R.string.ans_type4_que3_3,R.string.ans_type4_que3_4};
        ContentValues[] ans3 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans3[count] = new ContentValues();
            ans3[count].put(KEY_ANSWER, keyAns3[count]);
            ans3[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans3[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans3[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans3[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans3[count].put(KEY_QUESTION_ID, QUESTION_NO_1003);
            db.insert(TABLE_ANSWER, null, ans3[count]);
        }

        //ans-1004
        int[] keyAns4 = {R.string.ans_type4_que4_1,R.string.ans_type4_que4_2,R.string.ans_type4_que4_3,R.string.ans_type4_que4_4};
        ContentValues[] ans4 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans4[count] = new ContentValues();
            ans4[count].put(KEY_ANSWER, keyAns4[count]);
            ans4[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans4[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans4[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans4[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans4[count].put(KEY_QUESTION_ID, QUESTION_NO_1004);
            db.insert(TABLE_ANSWER, null, ans4[count]);
        }

        //ans-1005
        int[] keyAns5 = {R.string.ans_type4_que5_1,R.string.ans_type4_que5_2,R.string.ans_type4_que5_3,R.string.ans_type4_que5_4};
        ContentValues[] ans5 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans5[count] = new ContentValues();
            ans5[count].put(KEY_ANSWER, keyAns5[count]);
            ans5[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans5[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 3)
                ans5[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans5[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans5[count].put(KEY_QUESTION_ID, QUESTION_NO_1005);
            db.insert(TABLE_ANSWER, null, ans5[count]);
        }

        //ans-1006
        int[] keyAns6 = {R.string.ans_type4_que6_1,R.string.ans_type4_que6_2,R.string.ans_type4_que6_3,R.string.ans_type4_que6_4};
        ContentValues[] ans6 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans6[count] = new ContentValues();
            ans6[count].put(KEY_ANSWER, keyAns6[count]);
            ans6[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans6[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 3)
                ans6[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans6[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans6[count].put(KEY_QUESTION_ID, QUESTION_NO_1006);
            db.insert(TABLE_ANSWER, null, ans6[count]);
        }

        //ans-1007
        int[] keyAns7 = {R.string.ans_type4_que7_1,R.string.ans_type4_que7_2,R.string.ans_type4_que7_3,R.string.ans_type4_que7_4};
        ContentValues[] ans7 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans7[count] = new ContentValues();
            ans7[count].put(KEY_ANSWER, keyAns7[count]);
            ans7[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans7[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans7[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans7[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans7[count].put(KEY_QUESTION_ID, QUESTION_NO_1007);
            db.insert(TABLE_ANSWER, null, ans7[count]);
        }

        //ans-1008
        int[] keyAns8 = {R.string.ans_type4_que8_1,R.string.ans_type4_que8_2,R.string.ans_type4_que8_3,R.string.ans_type4_que8_4};
        ContentValues[] ans8 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans8[count] = new ContentValues();
            ans8[count].put(KEY_ANSWER, keyAns8[count]);
            ans8[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans8[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 3)
                ans8[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans8[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans8[count].put(KEY_QUESTION_ID, QUESTION_NO_1008);
            db.insert(TABLE_ANSWER, null, ans8[count]);
        }

        //ans-1009
        int[] keyAns9 = {R.string.ans_type4_que9_1,R.string.ans_type4_que9_2,R.string.ans_type4_que9_3,R.string.ans_type4_que9_4};
        ContentValues[] ans9 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans9[count] = new ContentValues();
            ans9[count].put(KEY_ANSWER, keyAns9[count]);
            ans9[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans9[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans9[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans9[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans9[count].put(KEY_QUESTION_ID, QUESTION_NO_1009);
            db.insert(TABLE_ANSWER, null, ans9[count]);
        }

        //ans-1010
        int[] keyAns10 = {R.string.ans_type4_que10_1,R.string.ans_type4_que10_2,R.string.ans_type4_que10_3,R.string.ans_type4_que10_4};
        ContentValues[] ans10 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans10[count] = new ContentValues();
            ans10[count].put(KEY_ANSWER, keyAns10[count]);
            ans10[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans10[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans10[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans10[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans10[count].put(KEY_QUESTION_ID, QUESTION_NO_1010);
            db.insert(TABLE_ANSWER, null, ans10[count]);
        }

        //ans-1011
        int[] keyAns11 = {R.string.ans_type4_que11_1,R.string.ans_type4_que11_2,R.string.ans_type4_que11_3,R.string.ans_type4_que11_4};
        ContentValues[] ans11 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans11[count] = new ContentValues();
            ans11[count].put(KEY_ANSWER, keyAns11[count]);
            ans11[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans11[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 3)
                ans11[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans11[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans11[count].put(KEY_QUESTION_ID, QUESTION_NO_1011);
            db.insert(TABLE_ANSWER, null, ans11[count]);
        }

        //ans-1012
        int[] keyAns12 = {R.string.ans_type4_que12_1,R.string.ans_type4_que12_2,R.string.ans_type4_que12_3,R.string.ans_type4_que12_4};
        ContentValues[] ans12 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans12[count] = new ContentValues();
            ans12[count].put(KEY_ANSWER, keyAns12[count]);
            ans12[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans12[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans12[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans12[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans12[count].put(KEY_QUESTION_ID, QUESTION_NO_1012);
            db.insert(TABLE_ANSWER, null, ans12[count]);
        }

        //ans-1013
        int[] keyAns13 = {R.string.ans_type4_que13_1,R.string.ans_type4_que13_2,R.string.ans_type4_que13_3,R.string.ans_type4_que13_4};
        ContentValues[] ans13 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans13[count] = new ContentValues();
            ans13[count].put(KEY_ANSWER, keyAns13[count]);
            ans13[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans13[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 3)
                ans13[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans13[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans13[count].put(KEY_QUESTION_ID, QUESTION_NO_1013);
            db.insert(TABLE_ANSWER, null, ans13[count]);
        }

        //ans-1014
        int[] keyAns14 = {R.string.ans_type4_que14_1,R.string.ans_type4_que14_2,R.string.ans_type4_que14_3,R.string.ans_type4_que14_4};
        ContentValues[] ans14 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans14[count] = new ContentValues();
            ans14[count].put(KEY_ANSWER, keyAns14[count]);
            ans14[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans14[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans14[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans14[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans14[count].put(KEY_QUESTION_ID, QUESTION_NO_1014);
            db.insert(TABLE_ANSWER, null, ans14[count]);
        }

        //ans-1015
        int[] keyAns15 = {R.string.ans_type4_que15_1,R.string.ans_type4_que15_2,R.string.ans_type4_que15_3,R.string.ans_type4_que15_4};
        ContentValues[] ans15 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans15[count] = new ContentValues();
            ans15[count].put(KEY_ANSWER, keyAns15[count]);
            ans15[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans15[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans15[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans15[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans15[count].put(KEY_QUESTION_ID, QUESTION_NO_1015);
            db.insert(TABLE_ANSWER, null, ans15[count]);
        }

        //ans-1016
        int[] keyAns16 = {R.string.ans_type4_que16_1,R.string.ans_type4_que16_2,R.string.ans_type4_que16_3,R.string.ans_type4_que16_4};
        ContentValues[] ans16 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans16[count] = new ContentValues();
            ans16[count].put(KEY_ANSWER, keyAns16[count]);
            ans16[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans16[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans16[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans16[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans16[count].put(KEY_QUESTION_ID, QUESTION_NO_1016);
            db.insert(TABLE_ANSWER, null, ans16[count]);
        }

        //ans-1017
        int[] keyAns17 = {R.string.ans_type4_que17_1,R.string.ans_type4_que17_2,R.string.ans_type4_que17_3,R.string.ans_type4_que17_4};
        ContentValues[] ans17 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans17[count] = new ContentValues();
            ans17[count].put(KEY_ANSWER, keyAns17[count]);
            ans17[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans17[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans17[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans17[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans17[count].put(KEY_QUESTION_ID, QUESTION_NO_1017);
            db.insert(TABLE_ANSWER, null, ans17[count]);
        }

        //ans-1018
        int[] keyAns18 = {R.string.ans_type4_que18_1,R.string.ans_type4_que18_2,R.string.ans_type4_que18_3,R.string.ans_type4_que18_4};
        ContentValues[] ans18 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans18[count] = new ContentValues();
            ans18[count].put(KEY_ANSWER, keyAns18[count]);
            ans18[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans18[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans18[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans18[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans18[count].put(KEY_QUESTION_ID, QUESTION_NO_1018);
            db.insert(TABLE_ANSWER, null, ans18[count]);
        }

        //ans-1019
        int[] keyAns19 = {R.string.ans_type4_que19_1,R.string.ans_type4_que19_2,R.string.ans_type4_que19_3,R.string.ans_type4_que19_4};
        ContentValues[] ans19 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans19[count] = new ContentValues();
            ans19[count].put(KEY_ANSWER, keyAns19[count]);
            ans19[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans19[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans19[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans19[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans19[count].put(KEY_QUESTION_ID, QUESTION_NO_1019);
            db.insert(TABLE_ANSWER, null, ans19[count]);
        }

        //ans-1020
        int[] keyAns20 = {R.string.ans_type4_que20_1,R.string.ans_type4_que20_2,R.string.ans_type4_que20_3,R.string.ans_type4_que20_4};
        ContentValues[] ans20 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans20[count] = new ContentValues();
            ans20[count].put(KEY_ANSWER, keyAns20[count]);
            ans20[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans20[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 3)
                ans20[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans20[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans20[count].put(KEY_QUESTION_ID, QUESTION_NO_1020);
            db.insert(TABLE_ANSWER, null, ans20[count]);
        }

        //ans-1021
        int[] keyAns21 = {R.string.ans_type4_que21_1,R.string.ans_type4_que21_2,R.string.ans_type4_que21_3,R.string.ans_type4_que21_4};
        ContentValues[] ans21 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans21[count] = new ContentValues();
            ans21[count].put(KEY_ANSWER, keyAns21[count]);
            ans21[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans21[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans21[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans21[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans21[count].put(KEY_QUESTION_ID, QUESTION_NO_1021);
            db.insert(TABLE_ANSWER, null, ans21[count]);
        }

        //ans-1022
        int[] keyAns22 = {R.string.ans_type4_que22_1,R.string.ans_type4_que22_2,R.string.ans_type4_que22_3,R.string.ans_type4_que22_4};
        ContentValues[] ans22 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans22[count] = new ContentValues();
            ans22[count].put(KEY_ANSWER, keyAns22[count]);
            ans22[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans22[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans22[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans22[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans22[count].put(KEY_QUESTION_ID, QUESTION_NO_1022);
            db.insert(TABLE_ANSWER, null, ans22[count]);
        }

        //ans-1023
        int[] keyAns23 = {R.string.ans_type4_que23_1,R.string.ans_type4_que23_2,R.string.ans_type4_que23_3,R.string.ans_type4_que23_4};
        ContentValues[] ans23 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans23[count] = new ContentValues();
            ans23[count].put(KEY_ANSWER, keyAns23[count]);
            ans23[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans23[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans23[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans23[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans23[count].put(KEY_QUESTION_ID, QUESTION_NO_1023);
            db.insert(TABLE_ANSWER, null, ans23[count]);
        }

        //ans-1024
        int[] keyAns24 = {R.string.ans_type4_que24_1,R.string.ans_type4_que24_2,R.string.ans_type4_que24_3,R.string.ans_type4_que24_4};
        ContentValues[] ans24 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans24[count] = new ContentValues();
            ans24[count].put(KEY_ANSWER, keyAns24[count]);
            ans24[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans24[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 3)
                ans24[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans24[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans24[count].put(KEY_QUESTION_ID, QUESTION_NO_1024);
            db.insert(TABLE_ANSWER, null, ans24[count]);
        }

        //ans-1025
        int[] keyAns25= {R.string.ans_type4_que25_1,R.string.ans_type4_que25_2,R.string.ans_type4_que25_3,R.string.ans_type4_que25_4};
        ContentValues[] ans25 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans25[count] = new ContentValues();
            ans25[count].put(KEY_ANSWER, keyAns25[count]);
            ans25[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans25[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans25[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans25[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans25[count].put(KEY_QUESTION_ID, QUESTION_NO_1025);
            db.insert(TABLE_ANSWER, null, ans25[count]);
        }

        //ans-1026
        int[] keyAns26= {R.string.ans_type4_que26_1,R.string.ans_type4_que26_2,R.string.ans_type4_que26_3,R.string.ans_type4_que26_4};
        ContentValues[] ans26 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans26[count] = new ContentValues();
            ans26[count].put(KEY_ANSWER, keyAns26[count]);
            ans26[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans26[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans26[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans26[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans26[count].put(KEY_QUESTION_ID, QUESTION_NO_1026);
            db.insert(TABLE_ANSWER, null, ans26[count]);
        }

        //ans-1027
        int[] keyAns27= {R.string.ans_type4_que27_1,R.string.ans_type4_que27_2,R.string.ans_type4_que27_3,R.string.ans_type4_que27_4};
        ContentValues[] ans27 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans27[count] = new ContentValues();
            ans27[count].put(KEY_ANSWER, keyAns27[count]);
            ans27[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans27[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans27[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans27[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans27[count].put(KEY_QUESTION_ID, QUESTION_NO_1027);
            db.insert(TABLE_ANSWER, null, ans27[count]);
        }

        //ans-1028
        int[] keyAns28= {R.string.ans_type4_que28_1,R.string.ans_type4_que28_2,R.string.ans_type4_que28_3,R.string.ans_type4_que28_4};
        ContentValues[] ans28 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans28[count] = new ContentValues();
            ans28[count].put(KEY_ANSWER, keyAns28[count]);
            ans28[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans28[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans28[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans28[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans28[count].put(KEY_QUESTION_ID, QUESTION_NO_1028);
            db.insert(TABLE_ANSWER, null, ans28[count]);
        }

        //ans-1029
        int[] keyAns29= {R.string.ans_type4_que29_1,R.string.ans_type4_que29_2,R.string.ans_type4_que29_3,R.string.ans_type4_que29_4};
        ContentValues[] ans29 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans29[count] = new ContentValues();
            ans29[count].put(KEY_ANSWER, keyAns29[count]);
            ans29[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans29[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 3)
                ans29[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans29[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans29[count].put(KEY_QUESTION_ID, QUESTION_NO_1029);
            db.insert(TABLE_ANSWER, null, ans29[count]);
        }

        //ans-1030
        int[] keyAns30= {R.string.ans_type4_que30_1,R.string.ans_type4_que30_2,R.string.ans_type4_que30_3,R.string.ans_type4_que30_4};
        ContentValues[] ans30 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans30[count] = new ContentValues();
            ans30[count].put(KEY_ANSWER, keyAns30[count]);
            ans30[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans30[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans30[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans30[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans30[count].put(KEY_QUESTION_ID, QUESTION_NO_1030);
            db.insert(TABLE_ANSWER, null, ans30[count]);
        }

        //ans-1031
        int[] keyAns31= {R.string.ans_type4_que31_1,R.string.ans_type4_que31_2,R.string.ans_type4_que31_3,R.string.ans_type4_que31_4};
        ContentValues[] ans31 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans31[count] = new ContentValues();
            ans31[count].put(KEY_ANSWER, keyAns31[count]);
            ans31[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans31[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans31[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans31[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans31[count].put(KEY_QUESTION_ID, QUESTION_NO_1031);
            db.insert(TABLE_ANSWER, null, ans31[count]);
        }

        //ans-1032
        int[] keyAns32= {R.string.ans_type4_que32_1,R.string.ans_type4_que32_2,R.string.ans_type4_que32_3,R.string.ans_type4_que32_4};
        ContentValues[] ans32 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans32[count] = new ContentValues();
            ans32[count].put(KEY_ANSWER, keyAns32[count]);
            ans32[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans32[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans32[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans32[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans32[count].put(KEY_QUESTION_ID, QUESTION_NO_1032);
            db.insert(TABLE_ANSWER, null, ans32[count]);
        }

        //ans-1033
        int[] keyAns33= {R.string.ans_type4_que33_1,R.string.ans_type4_que33_2,R.string.ans_type4_que33_3,R.string.ans_type4_que33_4};
        ContentValues[] ans33 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans33[count] = new ContentValues();
            ans33[count].put(KEY_ANSWER, keyAns33[count]);
            ans33[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans33[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 3)
                ans33[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans33[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans33[count].put(KEY_QUESTION_ID, QUESTION_NO_1033);
            db.insert(TABLE_ANSWER, null, ans33[count]);
        }

        //ans-1034
        int[] keyAns34= {R.string.ans_type4_que34_1,R.string.ans_type4_que34_2,R.string.ans_type4_que34_3,R.string.ans_type4_que34_4};
        ContentValues[] ans34 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans34[count] = new ContentValues();
            ans34[count].put(KEY_ANSWER, keyAns34[count]);
            ans34[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans34[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans34[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans34[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans34[count].put(KEY_QUESTION_ID, QUESTION_NO_1034);
            db.insert(TABLE_ANSWER, null, ans34[count]);
        }

        //ans-1035
        int[] keyAns35= {R.string.ans_type4_que35_1,R.string.ans_type4_que35_2,R.string.ans_type4_que35_3,R.string.ans_type4_que35_4};
        ContentValues[] ans35 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans35[count] = new ContentValues();
            ans35[count].put(KEY_ANSWER, keyAns35[count]);
            ans35[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans35[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans35[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans35[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans35[count].put(KEY_QUESTION_ID, QUESTION_NO_1035);
            db.insert(TABLE_ANSWER, null, ans35[count]);
        }

        //ans-1036
        int[] keyAns36= {R.string.ans_type4_que36_1,R.string.ans_type4_que36_2,R.string.ans_type4_que36_3,R.string.ans_type4_que36_4};
        ContentValues[] ans36 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans36[count] = new ContentValues();
            ans36[count].put(KEY_ANSWER, keyAns36[count]);
            ans36[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans36[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans36[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans36[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans36[count].put(KEY_QUESTION_ID, QUESTION_NO_1036);
            db.insert(TABLE_ANSWER, null, ans36[count]);
        }

        //ans-1037
        int[] keyAns37= {R.string.ans_type4_que37_1,R.string.ans_type4_que37_2,R.string.ans_type4_que37_3,R.string.ans_type4_que37_4};
        ContentValues[] ans37 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans37[count] = new ContentValues();
            ans37[count].put(KEY_ANSWER, keyAns37[count]);
            ans37[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans37[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans37[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans37[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans37[count].put(KEY_QUESTION_ID, QUESTION_NO_1037);
            db.insert(TABLE_ANSWER, null, ans37[count]);
        }

        //ans-1038
        int[] keyAns38= {R.string.ans_type4_que38_1,R.string.ans_type4_que38_2,R.string.ans_type4_que38_3,R.string.ans_type4_que38_4};
        ContentValues[] ans38 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans38[count] = new ContentValues();
            ans38[count].put(KEY_ANSWER, keyAns38[count]);
            ans38[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans38[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans38[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans38[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans38[count].put(KEY_QUESTION_ID, QUESTION_NO_1038);
            db.insert(TABLE_ANSWER, null, ans38[count]);
        }

        //ans-1039
        int[] keyAns39= {R.string.ans_type4_que39_1,R.string.ans_type4_que39_2,R.string.ans_type4_que39_3,R.string.ans_type4_que39_4};
        ContentValues[] ans39 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans39[count] = new ContentValues();
            ans39[count].put(KEY_ANSWER, keyAns39[count]);
            ans39[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans39[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans39[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans39[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans39[count].put(KEY_QUESTION_ID, QUESTION_NO_1039);
            db.insert(TABLE_ANSWER, null, ans39[count]);
        }

        //ans-1040
        int[] keyAns40= {R.string.ans_type4_que40_1,R.string.ans_type4_que40_2,R.string.ans_type4_que40_3,R.string.ans_type4_que40_4};
        ContentValues[] ans40 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans40[count] = new ContentValues();
            ans40[count].put(KEY_ANSWER, keyAns40[count]);
            ans40[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans40[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 3)
                ans40[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans40[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans40[count].put(KEY_QUESTION_ID, QUESTION_NO_1040);
            db.insert(TABLE_ANSWER, null, ans40[count]);
        }

        //ans-1041
        int[] keyAns41= {R.string.ans_type4_que41_1,R.string.ans_type4_que41_2,R.string.ans_type4_que41_3,R.string.ans_type4_que41_4};
        ContentValues[] ans41 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans41[count] = new ContentValues();
            ans41[count].put(KEY_ANSWER, keyAns41[count]);
            ans41[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans41[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans41[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans41[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans41[count].put(KEY_QUESTION_ID, QUESTION_NO_1041);
            db.insert(TABLE_ANSWER, null, ans41[count]);
        }

        //ans-1042
        int[] keyAns42= {R.string.ans_type4_que42_1,R.string.ans_type4_que42_2,R.string.ans_type4_que42_3,R.string.ans_type4_que42_4};
        ContentValues[] ans42 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans42[count] = new ContentValues();
            ans42[count].put(KEY_ANSWER, keyAns42[count]);
            ans42[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans42[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans42[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans42[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans42[count].put(KEY_QUESTION_ID, QUESTION_NO_1042);
            db.insert(TABLE_ANSWER, null, ans42[count]);
        }

        //ans-1043
        int[] keyAns43= {R.string.ans_type4_que43_1,R.string.ans_type4_que43_2,R.string.ans_type4_que43_3,R.string.ans_type4_que43_4};
        ContentValues[] ans43 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans43[count] = new ContentValues();
            ans43[count].put(KEY_ANSWER, keyAns43[count]);
            ans43[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans43[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans43[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans43[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans43[count].put(KEY_QUESTION_ID, QUESTION_NO_1043);
            db.insert(TABLE_ANSWER, null, ans43[count]);
        }

        //ans-1044
        int[] keyAns44= {R.string.ans_type4_que44_1,R.string.ans_type4_que44_2,R.string.ans_type4_que44_3,R.string.ans_type4_que44_4};
        ContentValues[] ans44 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans44[count] = new ContentValues();
            ans44[count].put(KEY_ANSWER, keyAns44[count]);
            ans44[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans44[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans44[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans44[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans44[count].put(KEY_QUESTION_ID, QUESTION_NO_1044);
            db.insert(TABLE_ANSWER, null, ans44[count]);
        }

        //ans-1045
        int[] keyAns45= {R.string.ans_type4_que45_1,R.string.ans_type4_que45_2,R.string.ans_type4_que45_3,R.string.ans_type4_que45_4};
        ContentValues[] ans45 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans45[count] = new ContentValues();
            ans45[count].put(KEY_ANSWER, keyAns45[count]);
            ans45[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans45[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans45[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans45[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans45[count].put(KEY_QUESTION_ID, QUESTION_NO_1045);
            db.insert(TABLE_ANSWER, null, ans45[count]);
        }

        //ans-1046
        int[] keyAns46= {R.string.ans_type4_que46_1,R.string.ans_type4_que46_2,R.string.ans_type4_que46_3,R.string.ans_type4_que46_4};
        ContentValues[] ans46 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans46[count] = new ContentValues();
            ans46[count].put(KEY_ANSWER, keyAns46[count]);
            ans46[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans46[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 3)
                ans46[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans46[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans46[count].put(KEY_QUESTION_ID, QUESTION_NO_1046);
            db.insert(TABLE_ANSWER, null, ans46[count]);
        }

        //ans-1047
        int[] keyAns47= {R.string.ans_type4_que47_1,R.string.ans_type4_que47_2,R.string.ans_type4_que47_3,R.string.ans_type4_que47_4};
        ContentValues[] ans47 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans47[count] = new ContentValues();
            ans47[count].put(KEY_ANSWER, keyAns47[count]);
            ans47[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans47[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans47[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans47[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans47[count].put(KEY_QUESTION_ID, QUESTION_NO_1047);
            db.insert(TABLE_ANSWER, null, ans47[count]);
        }

        //ans-1048
        int[] keyAns48= {R.string.ans_type4_que48_1,R.string.ans_type4_que48_2,R.string.ans_type4_que48_3,R.string.ans_type4_que48_4};
        ContentValues[] ans48 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans48[count] = new ContentValues();
            ans48[count].put(KEY_ANSWER, keyAns48[count]);
            ans48[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans48[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans48[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans48[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans48[count].put(KEY_QUESTION_ID, QUESTION_NO_1048);
            db.insert(TABLE_ANSWER, null, ans48[count]);
        }

        //ans-1049
        int[] keyAns49= {R.string.ans_type4_que49_1,R.string.ans_type4_que49_2,R.string.ans_type4_que49_3,R.string.ans_type4_que49_4};
        ContentValues[] ans49 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans49[count] = new ContentValues();
            ans49[count].put(KEY_ANSWER, keyAns49[count]);
            ans49[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans49[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans49[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans49[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans49[count].put(KEY_QUESTION_ID, QUESTION_NO_1049);
            db.insert(TABLE_ANSWER, null, ans49[count]);
        }

        //ans-1050
        int[] keyAns50= {R.string.ans_type4_que50_1,R.string.ans_type4_que50_2,R.string.ans_type4_que50_3,R.string.ans_type4_que50_4};
        ContentValues[] ans50 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans50[count] = new ContentValues();
            ans50[count].put(KEY_ANSWER, keyAns50[count]);
            ans50[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans50[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans50[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans50[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans50[count].put(KEY_QUESTION_ID, QUESTION_NO_1050);
            db.insert(TABLE_ANSWER, null, ans50[count]);
        }

        //ans-1051
        int[] keyAns51= {R.string.ans_type4_que51_1,R.string.ans_type4_que51_2,R.string.ans_type4_que51_3,R.string.ans_type4_que51_4};
        ContentValues[] ans51 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans51[count] = new ContentValues();
            ans51[count].put(KEY_ANSWER, keyAns51[count]);
            ans51[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans51[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans51[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans51[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans51[count].put(KEY_QUESTION_ID, QUESTION_NO_1051);
            db.insert(TABLE_ANSWER, null, ans51[count]);
        }

        //ans-1052
        int[] keyAns52= {R.string.ans_type4_que52_1,R.string.ans_type4_que52_2,R.string.ans_type4_que52_3,R.string.ans_type4_que52_4};
        ContentValues[] ans52 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans52[count] = new ContentValues();
            ans52[count].put(KEY_ANSWER, keyAns52[count]);
            ans52[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans52[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 3)
                ans52[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans52[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans52[count].put(KEY_QUESTION_ID, QUESTION_NO_1052);
            db.insert(TABLE_ANSWER, null, ans52[count]);
        }

        //ans-1053
        int[] keyAns53= {R.string.ans_type4_que53_1,R.string.ans_type4_que53_2,R.string.ans_type4_que53_3,R.string.ans_type4_que53_4};
        ContentValues[] ans53 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans53[count] = new ContentValues();
            ans53[count].put(KEY_ANSWER, keyAns53[count]);
            ans53[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans53[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans53[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans53[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans53[count].put(KEY_QUESTION_ID, QUESTION_NO_1053);
            db.insert(TABLE_ANSWER, null, ans53[count]);
        }

        //ans-1054
        int[] keyAns54= {R.string.ans_type4_que54_1,R.string.ans_type4_que54_2,R.string.ans_type4_que54_3,R.string.ans_type4_que54_4};
        ContentValues[] ans54 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans54[count] = new ContentValues();
            ans54[count].put(KEY_ANSWER, keyAns54[count]);
            ans54[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans54[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans54[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans54[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans54[count].put(KEY_QUESTION_ID, QUESTION_NO_1054);
            db.insert(TABLE_ANSWER, null, ans54[count]);
        }

        //ans-1055
        int[] keyAns55= {R.string.ans_type4_que55_1,R.string.ans_type4_que55_2,R.string.ans_type4_que55_3,R.string.ans_type4_que55_4};
        ContentValues[] ans55 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans55[count] = new ContentValues();
            ans55[count].put(KEY_ANSWER, keyAns55[count]);
            ans55[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans55[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 3)
                ans55[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans55[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans55[count].put(KEY_QUESTION_ID, QUESTION_NO_1055);
            db.insert(TABLE_ANSWER, null, ans55[count]);
        }

        //ans-1056
        int[] keyAns56= {R.string.ans_type4_que56_1,R.string.ans_type4_que56_2,R.string.ans_type4_que56_3,R.string.ans_type4_que56_4};
        ContentValues[] ans56 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans56[count] = new ContentValues();
            ans56[count].put(KEY_ANSWER, keyAns56[count]);
            ans56[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans56[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans56[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans56[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans56[count].put(KEY_QUESTION_ID, QUESTION_NO_1056);
            db.insert(TABLE_ANSWER, null, ans56[count]);
        }

        //ans-1057
        int[] keyAns57= {R.string.ans_type4_que57_1,R.string.ans_type4_que57_2,R.string.ans_type4_que57_3,R.string.ans_type4_que57_4};
        ContentValues[] ans57 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans57[count] = new ContentValues();
            ans57[count].put(KEY_ANSWER, keyAns57[count]);
            ans57[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans57[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans57[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans57[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans57[count].put(KEY_QUESTION_ID, QUESTION_NO_1057);
            db.insert(TABLE_ANSWER, null, ans57[count]);
        }

        //ans-1058
        int[] keyAns58= {R.string.ans_type4_que58_1,R.string.ans_type4_que58_2,R.string.ans_type4_que58_3,R.string.ans_type4_que58_4};
        ContentValues[] ans58 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans58[count] = new ContentValues();
            ans58[count].put(KEY_ANSWER, keyAns58[count]);
            ans58[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans58[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans58[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans58[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans58[count].put(KEY_QUESTION_ID, QUESTION_NO_1058);
            db.insert(TABLE_ANSWER, null, ans58[count]);
        }

        //ans-1059
        int[] keyAns59= {R.string.ans_type4_que59_1,R.string.ans_type4_que59_2,R.string.ans_type4_que59_3,R.string.ans_type4_que59_4};
        ContentValues[] ans59 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans59[count] = new ContentValues();
            ans59[count].put(KEY_ANSWER, keyAns59[count]);
            ans59[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans59[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans59[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans59[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans59[count].put(KEY_QUESTION_ID, QUESTION_NO_1059);
            db.insert(TABLE_ANSWER, null, ans59[count]);
        }

        //ans-1060
        int[] keyAns60= {R.string.ans_type4_que60_1,R.string.ans_type4_que60_2,R.string.ans_type4_que60_3,R.string.ans_type4_que60_4};
        ContentValues[] ans60 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans60[count] = new ContentValues();
            ans60[count].put(KEY_ANSWER, keyAns60[count]);
            ans60[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans60[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans60[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans60[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans60[count].put(KEY_QUESTION_ID, QUESTION_NO_1060);
            db.insert(TABLE_ANSWER, null, ans60[count]);
        }

        //ans-1061
        int[] keyAns61= {R.string.ans_type4_que61_1,R.string.ans_type4_que61_2,R.string.ans_type4_que61_3,R.string.ans_type4_que61_4};
        ContentValues[] ans61 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans61[count] = new ContentValues();
            ans61[count].put(KEY_ANSWER, keyAns61[count]);
            ans61[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans61[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans61[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans61[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans61[count].put(KEY_QUESTION_ID, QUESTION_NO_1061);
            db.insert(TABLE_ANSWER, null, ans61[count]);
        }

        //ans-1062
        int[] keyAns62= {R.string.ans_type4_que62_1,R.string.ans_type4_que62_2,R.string.ans_type4_que62_3,R.string.ans_type4_que62_4};
        ContentValues[] ans62 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans62[count] = new ContentValues();
            ans62[count].put(KEY_ANSWER, keyAns62[count]);
            ans62[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans62[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans62[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans62[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans62[count].put(KEY_QUESTION_ID, QUESTION_NO_1062);
            db.insert(TABLE_ANSWER, null, ans62[count]);
        }

        //ans-1063
        int[] keyAns63= {R.string.ans_type4_que63_1,R.string.ans_type4_que63_2,R.string.ans_type4_que63_3,R.string.ans_type4_que63_4};
        ContentValues[] ans63 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans63[count] = new ContentValues();
            ans63[count].put(KEY_ANSWER, keyAns63[count]);
            ans63[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans63[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 3)
                ans63[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans63[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans63[count].put(KEY_QUESTION_ID, QUESTION_NO_1063);
            db.insert(TABLE_ANSWER, null, ans63[count]);
        }

        //ans-1064
        int[] keyAns64= {R.string.ans_type4_que64_1,R.string.ans_type4_que64_2,R.string.ans_type4_que64_3,R.string.ans_type4_que64_4};
        ContentValues[] ans64 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans64[count] = new ContentValues();
            ans64[count].put(KEY_ANSWER, keyAns64[count]);
            ans64[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans64[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans64[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans64[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans64[count].put(KEY_QUESTION_ID, QUESTION_NO_1064);
            db.insert(TABLE_ANSWER, null, ans64[count]);
        }

        //ans-1065
        int[] keyAns65= {R.string.ans_type4_que65_1,R.string.ans_type4_que65_2,R.string.ans_type4_que65_3,R.string.ans_type4_que65_4};
        ContentValues[] ans65 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans65[count] = new ContentValues();
            ans65[count].put(KEY_ANSWER, keyAns65[count]);
            ans65[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans65[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans65[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans65[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans65[count].put(KEY_QUESTION_ID, QUESTION_NO_1065);
            db.insert(TABLE_ANSWER, null, ans65[count]);
        }

        //ans-1066
        int[] keyAns66= {R.string.ans_type4_que66_1,R.string.ans_type4_que66_2,R.string.ans_type4_que66_3,R.string.ans_type4_que66_4};
        ContentValues[] ans66 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans66[count] = new ContentValues();
            ans66[count].put(KEY_ANSWER, keyAns66[count]);
            ans66[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans66[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans66[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans66[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans66[count].put(KEY_QUESTION_ID, QUESTION_NO_1066);
            db.insert(TABLE_ANSWER, null, ans66[count]);
        }

        //ans-1067
        int[] keyAns67= {R.string.ans_type4_que67_1,R.string.ans_type4_que67_2,R.string.ans_type4_que67_3,R.string.ans_type4_que67_4};
        ContentValues[] ans67 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans67[count] = new ContentValues();
            ans67[count].put(KEY_ANSWER, keyAns67[count]);
            ans67[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans67[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 3)
                ans67[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans67[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans67[count].put(KEY_QUESTION_ID, QUESTION_NO_1067);
            db.insert(TABLE_ANSWER, null, ans67[count]);
        }

        //ans-1068
        int[] keyAns68= {R.string.ans_type4_que68_1,R.string.ans_type4_que68_2,R.string.ans_type4_que68_3,R.string.ans_type4_que68_4};
        ContentValues[] ans68 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans68[count] = new ContentValues();
            ans68[count].put(KEY_ANSWER, keyAns68[count]);
            ans68[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans68[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans68[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans68[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans68[count].put(KEY_QUESTION_ID, QUESTION_NO_1068);
            db.insert(TABLE_ANSWER, null, ans68[count]);
        }

        //ans-1069
        int[] keyAns69= {R.string.ans_type4_que69_1,R.string.ans_type4_que69_2,R.string.ans_type4_que69_3,R.string.ans_type4_que69_4};
        ContentValues[] ans69 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans69[count] = new ContentValues();
            ans69[count].put(KEY_ANSWER, keyAns69[count]);
            ans69[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans69[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 3)
                ans69[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans69[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans69[count].put(KEY_QUESTION_ID, QUESTION_NO_1069);
            db.insert(TABLE_ANSWER, null, ans69[count]);
        }

        //ans-1070
        int[] keyAns70= {R.string.ans_type4_que70_1,R.string.ans_type4_que70_2,R.string.ans_type4_que70_3,R.string.ans_type4_que70_4};
        ContentValues[] ans70 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans70[count] = new ContentValues();
            ans70[count].put(KEY_ANSWER, keyAns70[count]);
            ans70[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans70[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans70[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans70[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans70[count].put(KEY_QUESTION_ID, QUESTION_NO_1070);
            db.insert(TABLE_ANSWER, null, ans70[count]);
        }

        //ans-1071
        int[] keyAns71= {R.string.ans_type4_que71_1,R.string.ans_type4_que71_2,R.string.ans_type4_que71_3,R.string.ans_type4_que71_4};
        ContentValues[] ans71 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans71[count] = new ContentValues();
            ans71[count].put(KEY_ANSWER, keyAns71[count]);
            ans71[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans71[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans71[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans71[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans71[count].put(KEY_QUESTION_ID, QUESTION_NO_1071);
            db.insert(TABLE_ANSWER, null, ans71[count]);
        }

        //ans-1072
        int[] keyAns72= {R.string.ans_type4_que72_1,R.string.ans_type4_que72_2,R.string.ans_type4_que72_3,R.string.ans_type4_que72_4};
        ContentValues[] ans72 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans72[count] = new ContentValues();
            ans72[count].put(KEY_ANSWER, keyAns72[count]);
            ans72[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans72[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans72[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans72[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans72[count].put(KEY_QUESTION_ID, QUESTION_NO_1072);
            db.insert(TABLE_ANSWER, null, ans72[count]);
        }

        //ans-1073
        int[] keyAns73= {R.string.ans_type4_que73_1,R.string.ans_type4_que73_2,R.string.ans_type4_que73_3,R.string.ans_type4_que73_4};
        ContentValues[] ans73 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans73[count] = new ContentValues();
            ans73[count].put(KEY_ANSWER, keyAns73[count]);
            ans73[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans73[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans73[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans73[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans73[count].put(KEY_QUESTION_ID, QUESTION_NO_1073);
            db.insert(TABLE_ANSWER, null, ans73[count]);
        }

        //ans-1074
        int[] keyAns74= {R.string.ans_type4_que74_1,R.string.ans_type4_que74_2,R.string.ans_type4_que74_3,R.string.ans_type4_que74_4};
        ContentValues[] ans74 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans74[count] = new ContentValues();
            ans74[count].put(KEY_ANSWER, keyAns74[count]);
            ans74[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans74[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans74[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans74[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans74[count].put(KEY_QUESTION_ID, QUESTION_NO_1074);
            db.insert(TABLE_ANSWER, null, ans74[count]);
        }

        //ans-1075
        int[] keyAns75= {R.string.ans_type4_que75_1,R.string.ans_type4_que75_2,R.string.ans_type4_que75_3,R.string.ans_type4_que75_4};
        ContentValues[] ans75 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans75[count] = new ContentValues();
            ans75[count].put(KEY_ANSWER, keyAns75[count]);
            ans75[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans75[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans75[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans75[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans75[count].put(KEY_QUESTION_ID, QUESTION_NO_1075);
            db.insert(TABLE_ANSWER, null, ans75[count]);
        }

        //ans-1076
        int[] keyAns76= {R.string.ans_type4_que76_1,R.string.ans_type4_que76_2,R.string.ans_type4_que76_3,R.string.ans_type4_que76_4};
        ContentValues[] ans76 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans76[count] = new ContentValues();
            ans76[count].put(KEY_ANSWER, keyAns76[count]);
            ans76[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans76[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans76[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans76[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans76[count].put(KEY_QUESTION_ID, QUESTION_NO_1076);
            db.insert(TABLE_ANSWER, null, ans76[count]);
        }

        //ans-1077
        int[] keyAns77= {R.string.ans_type4_que77_1,R.string.ans_type4_que77_2,R.string.ans_type4_que77_3,R.string.ans_type4_que77_4};
        ContentValues[] ans77 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans77[count] = new ContentValues();
            ans77[count].put(KEY_ANSWER, keyAns77[count]);
            ans77[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans77[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 3)
                ans77[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans77[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans77[count].put(KEY_QUESTION_ID, QUESTION_NO_1077);
            db.insert(TABLE_ANSWER, null, ans77[count]);
        }

        //ans-1078
        int[] keyAns78= {R.string.ans_type4_que78_1,R.string.ans_type4_que78_2,R.string.ans_type4_que78_3,R.string.ans_type4_que78_4};
        ContentValues[] ans78 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans78[count] = new ContentValues();
            ans78[count].put(KEY_ANSWER, keyAns78[count]);
            ans78[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans78[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans78[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans78[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans78[count].put(KEY_QUESTION_ID, QUESTION_NO_1078);
            db.insert(TABLE_ANSWER, null, ans78[count]);
        }

        //ans-1079
        int[] keyAns79= {R.string.ans_type4_que79_1,R.string.ans_type4_que79_2,R.string.ans_type4_que79_3,R.string.ans_type4_que79_4};
        ContentValues[] ans79 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans79[count] = new ContentValues();
            ans79[count].put(KEY_ANSWER, keyAns79[count]);
            ans79[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans79[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans79[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans79[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans79[count].put(KEY_QUESTION_ID, QUESTION_NO_1079);
            db.insert(TABLE_ANSWER, null, ans79[count]);
        }

        //ans-1080
        int[] keyAns80= {R.string.ans_type4_que80_1,R.string.ans_type4_que80_2,R.string.ans_type4_que80_3,R.string.ans_type4_que80_4};
        ContentValues[] ans80 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans80[count] = new ContentValues();
            ans80[count].put(KEY_ANSWER, keyAns80[count]);
            ans80[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans80[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 3)
                ans80[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans80[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans80[count].put(KEY_QUESTION_ID, QUESTION_NO_1080);
            db.insert(TABLE_ANSWER, null, ans80[count]);
        }

        //ans-1081
        int[] keyAns81= {R.string.ans_type4_que81_1,R.string.ans_type4_que81_2,R.string.ans_type4_que81_3,R.string.ans_type4_que81_4};
        ContentValues[] ans81 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans81[count] = new ContentValues();
            ans81[count].put(KEY_ANSWER, keyAns81[count]);
            ans81[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans81[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 3)
                ans81[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans81[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans81[count].put(KEY_QUESTION_ID, QUESTION_NO_1081);
            db.insert(TABLE_ANSWER, null, ans81[count]);
        }

        //ans-1082
        int[] keyAns82= {R.string.ans_type4_que82_1,R.string.ans_type4_que82_2,R.string.ans_type4_que82_3,R.string.ans_type4_que82_4};
        ContentValues[] ans82 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans82[count] = new ContentValues();
            ans82[count].put(KEY_ANSWER, keyAns82[count]);
            ans82[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans82[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 2)
                ans82[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans82[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans82[count].put(KEY_QUESTION_ID, QUESTION_NO_1082);
            db.insert(TABLE_ANSWER, null, ans82[count]);
        }

        //ans-1083
        int[] keyAns83= {R.string.ans_type4_que83_1,R.string.ans_type4_que83_2,R.string.ans_type4_que83_3,R.string.ans_type4_que83_4};
        ContentValues[] ans83 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans83[count] = new ContentValues();
            ans83[count].put(KEY_ANSWER, keyAns83[count]);
            ans83[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans83[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 3)
                ans83[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans83[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans83[count].put(KEY_QUESTION_ID, QUESTION_NO_1083);
            db.insert(TABLE_ANSWER, null, ans83[count]);
        }

        //ans-1084
        int[] keyAns84= {R.string.ans_type4_que84_1,R.string.ans_type4_que84_2,R.string.ans_type4_que84_3,R.string.ans_type4_que84_4};
        ContentValues[] ans84 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans84[count] = new ContentValues();
            ans84[count].put(KEY_ANSWER, keyAns84[count]);
            ans84[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans84[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 0)
                ans84[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans84[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans84[count].put(KEY_QUESTION_ID, QUESTION_NO_1084);
            db.insert(TABLE_ANSWER, null, ans84[count]);
        }

        //ans-1085
        int[] keyAns85= {R.string.ans_type4_que85_1,R.string.ans_type4_que85_2,R.string.ans_type4_que85_3,R.string.ans_type4_que85_4};
        ContentValues[] ans85 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans85[count] = new ContentValues();
            ans85[count].put(KEY_ANSWER, keyAns85[count]);
            ans85[count].put(KEY_TYPE, Utils.TYPE_QUES_IMAGE);
            ans85[count].put(KEY_RESOURCE, Utils.NULL);
            if (count == 1)
                ans85[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            else
                ans85[count].put(KEY_IS_CORRECT, Utils.INCORRECT);
            ans85[count].put(KEY_QUESTION_ID, QUESTION_NO_1085);
            db.insert(TABLE_ANSWER, null, ans85[count]);
        }
    }

    private void insertAnsType5(SQLiteDatabase db) {

        final int QUESTION_NO_1501 = 1501;
        final int QUESTION_NO_1502 = 1502;
        final int QUESTION_NO_1503 = 1503;
        final int QUESTION_NO_1504 = 1504;
        final int QUESTION_NO_1505 = 1505;
        final int QUESTION_NO_1506 = 1506;
        final int QUESTION_NO_1507 = 1507;
        final int QUESTION_NO_1508 = 1508;
        final int QUESTION_NO_1509 = 1509;
        final int QUESTION_NO_1510 = 1510;
        final int QUESTION_NO_1511 = 1511;
        final int QUESTION_NO_1512 = 1512;
        final int QUESTION_NO_1513 = 1513;
        final int QUESTION_NO_1514 = 1514;
        final int QUESTION_NO_1515 = 1515;
        final int QUESTION_NO_1516 = 1516;
        final int QUESTION_NO_1517 = 1517;
        final int QUESTION_NO_1518 = 1518;
        final int QUESTION_NO_1519 = 1519;
        final int QUESTION_NO_1520 = 1520;
        final int QUESTION_NO_1521 = 1521;
        final int QUESTION_NO_1522 = 1522;
        final int QUESTION_NO_1523 = 1523;
        final int QUESTION_NO_1524 = 1524;
        final int QUESTION_NO_1525 = 1525;
        final int QUESTION_NO_1526 = 1526;
        final int QUESTION_NO_1527 = 1527;
        final int QUESTION_NO_1528 = 1528;
        final int QUESTION_NO_1529 = 1529;
        final int QUESTION_NO_1530 = 1530;
        final int QUESTION_NO_1531 = 1531;
        final int QUESTION_NO_1532 = 1532;
        final int QUESTION_NO_1533 = 1533;
        final int QUESTION_NO_1534 = 1534;
        final int QUESTION_NO_1535 = 1535;
        final int QUESTION_NO_1536 = 1536;
        final int QUESTION_NO_1537 = 1537;
        final int QUESTION_NO_1538 = 1538;
        final int QUESTION_NO_1539 = 1539;
        final int QUESTION_NO_1540 = 1540;
        final int QUESTION_NO_1541 = 1541;
        final int QUESTION_NO_1542 = 1542;
        final int QUESTION_NO_1543 = 1543;
        final int QUESTION_NO_1544 = 1544;
        final int QUESTION_NO_1545 = 1545;
        final int QUESTION_NO_1546 = 1546;
        final int QUESTION_NO_1547 = 1547;
        final int QUESTION_NO_1548 = 1548;
        final int QUESTION_NO_1549 = 1549;
        final int QUESTION_NO_1550 = 1550;
        final int QUESTION_NO_1551 = 1551;
        final int QUESTION_NO_1552 = 1552;
        final int QUESTION_NO_1553 = 1553;
        final int QUESTION_NO_1554 = 1554;
        final int QUESTION_NO_1555 = 1555;
        final int QUESTION_NO_1556 = 1556;
        final int QUESTION_NO_1557 = 1557;
        final int QUESTION_NO_1558 = 1558;
        final int QUESTION_NO_1559 = 1559;
        final int QUESTION_NO_1560 = 1560;
        final int QUESTION_NO_1561 = 1561;
        final int QUESTION_NO_1562 = 1562;
        final int QUESTION_NO_1563 = 1563;
        final int QUESTION_NO_1564 = 1564;
        final int QUESTION_NO_1565 = 1565;
        final int QUESTION_NO_1566 = 1566;
        final int QUESTION_NO_1567 = 1567;
        final int QUESTION_NO_1568 = 1568;
        final int QUESTION_NO_1569 = 1569;
        final int QUESTION_NO_1570 = 1570;
        final int QUESTION_NO_1571 = 1571;
        final int QUESTION_NO_1572 = 1572;
        final int QUESTION_NO_1573 = 1573;
        final int QUESTION_NO_1574 = 1574;
        final int QUESTION_NO_1575 = 1575;
        final int QUESTION_NO_1576 = 1576;
        final int QUESTION_NO_1577 = 1577;
        final int QUESTION_NO_1578 = 1578;
        final int QUESTION_NO_1579 = 1579;
        final int QUESTION_NO_1580 = 1580;
        final int QUESTION_NO_1581 = 1581;
        final int QUESTION_NO_1582 = 1582;
        final int QUESTION_NO_1583 = 1583;
        final int QUESTION_NO_1584 = 1584;
        final int QUESTION_NO_1585 = 1585;
        final int QUESTION_NO_1586 = 1586;
        final int QUESTION_NO_1587 = 1587;
        final int QUESTION_NO_1588 = 1588;
        final int QUESTION_NO_1589 = 1589;
        final int QUESTION_NO_1590 = 1590;
        final int QUESTION_NO_1591 = 1591;
        final int QUESTION_NO_1592 = 1592;
        final int QUESTION_NO_1593 = 1593;
        final int QUESTION_NO_1594 = 1594;
        final int QUESTION_NO_1595 = 1595;
        final int QUESTION_NO_1596 = 1596;
        final int QUESTION_NO_1597 = 1597;
        final int QUESTION_NO_1598 = 1598;
        final int QUESTION_NO_1599 = 1599;
        final int QUESTION_NO_1600 = 1600;
        final int QUESTION_NO_1601 = 1601;
        final int QUESTION_NO_1602 = 1602;
        final int QUESTION_NO_1603 = 1603;
        final int QUESTION_NO_1604 = 1604;
        final int QUESTION_NO_1605 = 1605;
        final int QUESTION_NO_1606 = 1606;
        final int QUESTION_NO_1607 = 1607;
        final int QUESTION_NO_1608 = 1608;
        final int QUESTION_NO_1609 = 1609;
        final int QUESTION_NO_1610 = 1610;
        final int QUESTION_NO_1611 = 1611;
        final int QUESTION_NO_1612 = 1612;
        final int QUESTION_NO_1613 = 1613;
        final int QUESTION_NO_1614 = 1614;
        final int QUESTION_NO_1615 = 1615;
        final int QUESTION_NO_1616 = 1616;
        final int QUESTION_NO_1617 = 1617;
        final int QUESTION_NO_1618 = 1618;
        final int QUESTION_NO_1619 = 1619;
        final int QUESTION_NO_1620 = 1620;
        final int QUESTION_NO_1621 = 1621;
        final int QUESTION_NO_1622 = 1622;
        final int QUESTION_NO_1623 = 1623;
        final int QUESTION_NO_1624 = 1624;
        final int QUESTION_NO_1625 = 1625;
        final int QUESTION_NO_1626 = 1626;
        final int QUESTION_NO_1627 = 1627;
        final int QUESTION_NO_1628 = 1628;
        final int QUESTION_NO_1629 = 1629;
        final int QUESTION_NO_1630 = 1630;
        final int QUESTION_NO_1631 = 1631;
        final int QUESTION_NO_1632 = 1632;
        final int QUESTION_NO_1633 = 1633;
        final int QUESTION_NO_1634 = 1634;
        final int QUESTION_NO_1635 = 1635;
        final int QUESTION_NO_1636 = 1636;
        final int QUESTION_NO_1637 = 1637;
        final int QUESTION_NO_1638 = 1638;
        final int QUESTION_NO_1639 = 1639;
        final int QUESTION_NO_1640 = 1640;
        final int QUESTION_NO_1641 = 1641;
        final int QUESTION_NO_1642 = 1642;
        final int QUESTION_NO_1643 = 1643;
        final int QUESTION_NO_1644 = 1644;
        final int QUESTION_NO_1645 = 1645;
        final int QUESTION_NO_1646 = 1646;
        final int QUESTION_NO_1647 = 1647;
        final int QUESTION_NO_1648 = 1648;
        final int QUESTION_NO_1649 = 1649;
        final int QUESTION_NO_1650 = 1650;

        StringBuilder columnStringBuilder = new StringBuilder();
        columnStringBuilder.append(KEY_ANSWER).append(", ")
                .append(KEY_TYPE).append(", ").append(KEY_RESOURCE)
                .append(", ").append(KEY_IS_CORRECT).append(", ")
                .append(KEY_QUESTION_ID);

        //ans-1
        int[] keyAns1 = {R.string.ans_type5_que1_1,R.string.ans_type5_que1_2,R.string.ans_type5_que1_3,R.string.ans_type5_que1_4};
        int[] keyRes1 = {R.drawable.asiatic_lily,R.drawable.bee_orchid,R.drawable.blue_poppy,R.drawable.blue_feltwort};
        ContentValues[] ans1 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans1[count] = new ContentValues();
            ans1[count].put(KEY_ANSWER, keyAns1[count]);
            ans1[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans1[count].put(KEY_RESOURCE,keyRes1[count]);
            ans1[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans1[count].put(KEY_QUESTION_ID, QUESTION_NO_1501);
            db.insert(TABLE_ANSWER, null, ans1[count]);
        }

        //ans-2
        int[] keyAns2 = {R.string.ans_type5_que2_1,R.string.ans_type5_que2_2,R.string.ans_type5_que2_3,R.string.ans_type5_que2_4};
        int[] keyRes2 = {R.drawable.wax_flower,R.drawable.fringed_iris,R.drawable.globe_primrose,R.drawable.flax};
        ContentValues[] ans2 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans2[count] = new ContentValues();
            ans2[count].put(KEY_ANSWER, keyAns2[count]);
            ans2[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans2[count].put(KEY_RESOURCE,keyRes2[count]);
            ans2[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans2[count].put(KEY_QUESTION_ID, QUESTION_NO_1502);
            db.insert(TABLE_ANSWER, null, ans2[count]);
        }

        //ans-3
        int[] keyAns3 = {R.string.ans_type5_que3_1,R.string.ans_type5_que3_2,R.string.ans_type5_que3_3,R.string.ans_type5_que3_4};
        int[] keyRes3 = {R.drawable.bicolor_alyce_clover,R.drawable.blue_vanda,R.drawable.drumstick_primrose,R.drawable.chilean_bell_flower};
        ContentValues[] ans3 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans3[count] = new ContentValues();
            ans3[count].put(KEY_ANSWER, keyAns3[count]);
            ans3[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans3[count].put(KEY_RESOURCE,keyRes3[count]);
            ans3[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans3[count].put(KEY_QUESTION_ID, QUESTION_NO_1503);
            db.insert(TABLE_ANSWER, null, ans3[count]);
        }

        //ans-4
        int[] keyAns4 = {R.string.ans_type5_que4_1,R.string.ans_type5_que4_2,R.string.ans_type5_que4_3,R.string.ans_type5_que4_4};
        int[] keyRes4 = {R.drawable.dwarf_powder_puff,R.drawable.golden_arch_dendrobium,R.drawable.golden_eyed_primrose,R.drawable.graceful_himalayan_iris};
        ContentValues[] ans4 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans4[count] = new ContentValues();
            ans4[count].put(KEY_ANSWER, keyAns4[count]);
            ans4[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans4[count].put(KEY_RESOURCE,keyRes4[count]);
            ans4[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans4[count].put(KEY_QUESTION_ID, QUESTION_NO_1504);
            db.insert(TABLE_ANSWER, null, ans4[count]);
        }

        //ans-5
        int[] keyAns5 = {R.string.ans_type5_que5_1,R.string.ans_type5_que5_2,R.string.ans_type5_que5_3,R.string.ans_type5_que5_4};
        int[] keyRes5 = {R.drawable.hairy_root_luisia,R.drawable.hungarian_black_chilli,R.drawable.hugel_s_gentian,R.drawable.himalayan_aster};
        ContentValues[] ans5 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans5[count] = new ContentValues();
            ans5[count].put(KEY_ANSWER, keyAns5[count]);
            ans5[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans5[count].put(KEY_RESOURCE,keyRes5[count]);
            ans5[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans5[count].put(KEY_QUESTION_ID, QUESTION_NO_1505);
            db.insert(TABLE_ANSWER, null, ans5[count]);
        }

        //ans-6
        int[] keyAns6 = {R.string.ans_type5_que6_1,R.string.ans_type5_que6_2,R.string.ans_type5_que6_3,R.string.ans_type5_que6_4};
        int[] keyRes6 = {R.drawable.kanpet,R.drawable.hungarian_iris,R.drawable.long_flower_barleria,R.drawable.johnson_s_amaryllis};
        ContentValues[] ans6 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans6[count] = new ContentValues();
            ans6[count].put(KEY_ANSWER, keyAns6[count]);
            ans6[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans6[count].put(KEY_RESOURCE,keyRes6[count]);
            ans6[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans6[count].put(KEY_QUESTION_ID, QUESTION_NO_1506);
            db.insert(TABLE_ANSWER, null, ans6[count]);
        }

        //ans-7
        int[] keyAns7 = {R.string.ans_type5_que7_1,R.string.ans_type5_que7_2,R.string.ans_type5_que7_3,R.string.ans_type5_que7_4};
        int[] keyRes7 = {R.drawable.malabar_hill_borage,R.drawable.mountain_rose,R.drawable.mountain_hydrangea,R.drawable.peruvian_lily};
        ContentValues[] ans7 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans7[count] = new ContentValues();
            ans7[count].put(KEY_ANSWER, keyAns7[count]);
            ans7[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans7[count].put(KEY_RESOURCE,keyRes7[count]);
            ans7[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans7[count].put(KEY_QUESTION_ID, QUESTION_NO_1507);
            db.insert(TABLE_ANSWER, null, ans7[count]);
        }

        //ans-8
        int[] keyAns8 = {R.string.ans_type5_que8_1,R.string.ans_type5_que8_2,R.string.ans_type5_que8_3,R.string.ans_type5_que8_4};
        int[] keyRes8 = {R.drawable.queen_crape_myrtle,R.drawable.red_vanda,R.drawable.red_water_lily,R.drawable.princess_flower};
        ContentValues[] ans8 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans8[count] = new ContentValues();
            ans8[count].put(KEY_ANSWER, keyAns8[count]);
            ans8[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans8[count].put(KEY_RESOURCE,keyRes8[count]);
            ans8[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans8[count].put(KEY_QUESTION_ID, QUESTION_NO_1508);
            db.insert(TABLE_ANSWER, null, ans8[count]);
        }

        //ans-9
        int[] keyAns9 = {R.string.ans_type5_que9_1,R.string.ans_type5_que9_2,R.string.ans_type5_que9_3,R.string.ans_type5_que9_4};
        int[] keyRes9 = {R.drawable.trailing_geranium,R.drawable.river_anemone,R.drawable.shoofly_plant,R.drawable.tulip_tree};
        ContentValues[] ans9 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans9[count] = new ContentValues();
            ans9[count].put(KEY_ANSWER, keyAns9[count]);
            ans9[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans9[count].put(KEY_RESOURCE,keyRes9[count]);
            ans9[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans9[count].put(KEY_QUESTION_ID, QUESTION_NO_1509);
            db.insert(TABLE_ANSWER, null, ans9[count]);
        }

        //ans-10
        int[] keyAns10 = {R.string.ans_type5_que10_1,R.string.ans_type5_que10_2,R.string.ans_type5_que10_3,R.string.ans_type5_que10_4};
        int[] keyRes10 = {R.drawable.yellow_waterlily,R.drawable.flax,R.drawable.graceful_himalayan_iris,R.drawable.hungarian_iris};
        ContentValues[] ans10 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans10[count] = new ContentValues();
            ans10[count].put(KEY_ANSWER, keyAns10[count]);
            ans10[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans10[count].put(KEY_RESOURCE,keyRes10[count]);
            ans10[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans10[count].put(KEY_QUESTION_ID, QUESTION_NO_1510);
            db.insert(TABLE_ANSWER, null, ans10[count]);
        }

        //ans-11
        int[] keyAns11 = {R.string.ans_type5_que11_1,R.string.ans_type5_que11_2,R.string.ans_type5_que11_3,R.string.ans_type5_que11_4};
        int[] keyRes11 = {R.drawable.chameleon_plant,R.drawable.green_taro,R.drawable.long_flowered_spider_lily,R.drawable.five_leaf_yam};
        ContentValues[] ans11 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans11[count] = new ContentValues();
            ans11[count].put(KEY_ANSWER, keyAns11[count]);
            ans11[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans11[count].put(KEY_RESOURCE,keyRes11[count]);
            ans11[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans11[count].put(KEY_QUESTION_ID, QUESTION_NO_1511);
            db.insert(TABLE_ANSWER, null, ans11[count]);
        }

        //ans-12
        int[] keyAns12 = {R.string.ans_type5_que12_1,R.string.ans_type5_que12_2,R.string.ans_type5_que12_3,R.string.ans_type5_que12_4};
        int[] keyRes12 = {R.drawable.long_leaf_pondweed,R.drawable.peace_lily,R.drawable.wights_twisted_arum,R.drawable.stepladder_ginger};
        ContentValues[] ans12 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans12[count] = new ContentValues();
            ans12[count].put(KEY_ANSWER, keyAns12[count]);
            ans12[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans12[count].put(KEY_RESOURCE,keyRes12[count]);
            ans12[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans12[count].put(KEY_QUESTION_ID, QUESTION_NO_1512);
            db.insert(TABLE_ANSWER, null, ans12[count]);
        }

        //ans-13
        int[] keyAns13 = {R.string.ans_type5_que13_1,R.string.ans_type5_que13_2,R.string.ans_type5_que13_3,R.string.ans_type5_que13_4};
        int[] keyRes13 = {R.drawable.wild_daffodil,R.drawable.blue_vanda,R.drawable.chameleon_plant,R.drawable.chilean_bell_flower};
        ContentValues[] ans13 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans13[count] = new ContentValues();
            ans13[count].put(KEY_ANSWER, keyAns13[count]);
            ans13[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans13[count].put(KEY_RESOURCE,keyRes13[count]);
            ans13[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans13[count].put(KEY_QUESTION_ID, QUESTION_NO_1513);
            db.insert(TABLE_ANSWER, null, ans13[count]);
        }

        //ans-14
        int[] keyAns14 = {R.string.ans_type5_que14_1,R.string.ans_type5_que14_2,R.string.ans_type5_que14_3,R.string.ans_type5_que14_4};
        int[] keyRes14 = {R.drawable.dwarf_powder_puff,R.drawable.five_leaf_yam,R.drawable.green_taro,R.drawable.graceful_himalayan_iris};
        ContentValues[] ans14 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans14[count] = new ContentValues();
            ans14[count].put(KEY_ANSWER, keyAns14[count]);
            ans14[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans14[count].put(KEY_RESOURCE,keyRes14[count]);
            ans14[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans14[count].put(KEY_QUESTION_ID, QUESTION_NO_1514);
            db.insert(TABLE_ANSWER, null, ans14[count]);
        }

        //ans-15
        int[] keyAns15 = {R.string.ans_type5_que15_1,R.string.ans_type5_que15_2,R.string.ans_type5_que15_3,R.string.ans_type5_que15_4};
        int[] keyRes15 = {R.drawable.wights_twisted_arum,R.drawable.stepladder_ginger,R.drawable.long_flowered_spider_lily,R.drawable.himalayan_aster};
        ContentValues[] ans15 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans15[count] = new ContentValues();
            ans15[count].put(KEY_ANSWER, keyAns15[count]);
            ans15[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans15[count].put(KEY_RESOURCE,keyRes15[count]);
            ans15[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans15[count].put(KEY_QUESTION_ID, QUESTION_NO_1515);
            db.insert(TABLE_ANSWER, null, ans15[count]);
        }

        //ans-16
        int[] keyAns16 = {R.string.ans_type5_que16_1,R.string.ans_type5_que16_2,R.string.ans_type5_que16_3,R.string.ans_type5_que16_4};
        int[] keyRes16 = {R.drawable.kanpet,R.drawable.hungarian_iris,R.drawable.wild_daffodil,R.drawable.long_leaf_pondweed};
        ContentValues[] ans16 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans16[count] = new ContentValues();
            ans16[count].put(KEY_ANSWER, keyAns16[count]);
            ans16[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans16[count].put(KEY_RESOURCE,keyRes16[count]);
            ans16[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans16[count].put(KEY_QUESTION_ID, QUESTION_NO_1516);
            db.insert(TABLE_ANSWER, null, ans16[count]);
        }

        //ans-17
        int[] keyAns17 = {R.string.ans_type5_que17_1,R.string.ans_type5_que17_2,R.string.ans_type5_que17_3,R.string.ans_type5_que17_4};
        int[] keyRes17 = {R.drawable.malabar_hill_borage,R.drawable.peace_lily,R.drawable.mountain_hydrangea,R.drawable.peruvian_lily};
        ContentValues[] ans17 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans17[count] = new ContentValues();
            ans17[count].put(KEY_ANSWER, keyAns17[count]);
            ans17[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans17[count].put(KEY_RESOURCE,keyRes17[count]);
            ans17[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans17[count].put(KEY_QUESTION_ID, QUESTION_NO_1517);
            db.insert(TABLE_ANSWER, null, ans17[count]);
        }

        //ans-18
        int[] keyAns18 = {R.string.ans_type5_que18_1,R.string.ans_type5_que18_2,R.string.ans_type5_que18_3,R.string.ans_type5_que18_4};
        int[] keyRes18 = {R.drawable.red_vanda,R.drawable.queen_crape_myrtle,R.drawable.five_leaf_yam,R.drawable.princess_flower};
        ContentValues[] ans18 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans18[count] = new ContentValues();
            ans18[count].put(KEY_ANSWER, keyAns18[count]);
            ans18[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans18[count].put(KEY_RESOURCE,keyRes18[count]);
            ans18[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans18[count].put(KEY_QUESTION_ID, QUESTION_NO_1518);
            db.insert(TABLE_ANSWER, null, ans18[count]);
        }

        //ans-19
        int[] keyAns19 = {R.string.ans_type5_que19_1,R.string.ans_type5_que19_2,R.string.ans_type5_que19_3,R.string.ans_type5_que19_4};
        int[] keyRes19 = {R.drawable.trailing_geranium,R.drawable.yellow_waterlily,R.drawable.long_leaf_pondweed,R.drawable.tulip_tree};
        ContentValues[] ans19 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans19[count] = new ContentValues();
            ans19[count].put(KEY_ANSWER, keyAns19[count]);
            ans19[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans19[count].put(KEY_RESOURCE,keyRes19[count]);
            ans19[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans19[count].put(KEY_QUESTION_ID, QUESTION_NO_1519);
            db.insert(TABLE_ANSWER, null, ans19[count]);
        }

        //ans-20
        int[] keyAns20 = {R.string.ans_type5_que20_1,R.string.ans_type5_que20_2,R.string.ans_type5_que20_3,R.string.ans_type5_que20_4};
        int[] keyRes20 = {R.drawable.shoofly_plant,R.drawable.flax,R.drawable.graceful_himalayan_iris,R.drawable.stepladder_ginger};
        ContentValues[] ans20 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans20[count] = new ContentValues();
            ans20[count].put(KEY_ANSWER, keyAns20[count]);
            ans20[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans20[count].put(KEY_RESOURCE,keyRes20[count]);
            ans20[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans20[count].put(KEY_QUESTION_ID, QUESTION_NO_1520);
            db.insert(TABLE_ANSWER, null, ans20[count]);
        }

        //ans-21
        int[] keyAns21 = {R.string.ans_type5_que21_1,R.string.ans_type5_que21_2,R.string.ans_type5_que21_3,R.string.ans_type5_que21_4};
        int[] keyRes21 = {R.drawable.bitter_nutmeg,R.drawable.hard_fruit_alphonsea,R.drawable.campbell_s_magnolia,R.drawable.malabar_nutmeg};
        ContentValues[] ans21 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans21[count] = new ContentValues();
            ans21[count].put(KEY_ANSWER, keyAns21[count]);
            ans21[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans21[count].put(KEY_RESOURCE,keyRes21[count]);
            ans21[count].put(KEY_RESOURCE,keyRes21[count]);
            ans21[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans21[count].put(KEY_QUESTION_ID, QUESTION_NO_1521);
            db.insert(TABLE_ANSWER, null, ans21[count]);
        }

        //ans-22
        int[] keyAns22 = {R.string.ans_type5_que22_1,R.string.ans_type5_que22_2,R.string.ans_type5_que22_3,R.string.ans_type5_que22_4};
        int[] keyRes22 = {R.drawable.calico_flower,R.drawable.pond_apple,R.drawable.globe_primrose,R.drawable.tulip_tree};
        ContentValues[] ans22 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans22[count] = new ContentValues();
            ans22[count].put(KEY_ANSWER, keyAns22[count]);
            ans22[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans22[count].put(KEY_RESOURCE,keyRes22[count]);
            ans22[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans22[count].put(KEY_QUESTION_ID, QUESTION_NO_1522);
            db.insert(TABLE_ANSWER, null, ans22[count]);
        }

        //ans-23
        int[] keyAns23 = {R.string.ans_type5_que23_1,R.string.ans_type5_que23_2,R.string.ans_type5_que23_3,R.string.ans_type5_que23_4};
        int[] keyRes23 = {R.drawable.bicolor_alyce_clover,R.drawable.bitter_nutmeg,R.drawable.drumstick_primrose,R.drawable.campbell_s_magnolia};
        ContentValues[] ans23 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans23[count] = new ContentValues();
            ans23[count].put(KEY_ANSWER, keyAns23[count]);
            ans23[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans23[count].put(KEY_RESOURCE,keyRes23[count]);
            ans23[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans23[count].put(KEY_QUESTION_ID, QUESTION_NO_1523);
            db.insert(TABLE_ANSWER, null, ans23[count]);
        }

        //ans-24
        int[] keyAns24 = {R.string.ans_type5_que24_1,R.string.ans_type5_que24_2,R.string.ans_type5_que24_3,R.string.ans_type5_que24_4};
        int[] keyRes24 = {R.drawable.hard_fruit_alphonsea,R.drawable.golden_arch_dendrobium,R.drawable.golden_eyed_primrose,R.drawable.malabar_nutmeg};
        ContentValues[] ans24 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans24[count] = new ContentValues();
            ans24[count].put(KEY_ANSWER, keyAns24[count]);
            ans24[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans24[count].put(KEY_RESOURCE,keyRes24[count]);
            ans24[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans24[count].put(KEY_QUESTION_ID, QUESTION_NO_1524);
            db.insert(TABLE_ANSWER, null, ans24[count]);
        }

        //ans-25
        int[] keyAns25 = {R.string.ans_type5_que25_1,R.string.ans_type5_que25_2,R.string.ans_type5_que25_3,R.string.ans_type5_que25_4};
        int[] keyRes25 = {R.drawable.hairy_root_luisia,R.drawable.pond_apple,R.drawable.hugel_s_gentian,R.drawable.himalayan_aster};
        ContentValues[] ans25 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans25[count] = new ContentValues();
            ans25[count].put(KEY_ANSWER, keyAns25[count]);
            ans25[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans25[count].put(KEY_RESOURCE,keyRes25[count]);
            ans25[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans25[count].put(KEY_QUESTION_ID, QUESTION_NO_1525);
            db.insert(TABLE_ANSWER, null, ans25[count]);
        }

        //ans-26
        int[] keyAns26 = {R.string.ans_type5_que26_1,R.string.ans_type5_que26_2,R.string.ans_type5_que26_3,R.string.ans_type5_que26_4};
        int[] keyRes26 = {R.drawable.kanpet,R.drawable.mountain_rose,R.drawable.tulip_tree,R.drawable.johnson_s_amaryllis};
        ContentValues[] ans26 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans26[count] = new ContentValues();
            ans26[count].put(KEY_ANSWER, keyAns26[count]);
            ans26[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans26[count].put(KEY_RESOURCE,keyRes26[count]);
            ans26[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans26[count].put(KEY_QUESTION_ID, QUESTION_NO_1526);
            db.insert(TABLE_ANSWER, null, ans26[count]);
        }

        //ans-27
        int[] keyAns27 = {R.string.ans_type5_que27_1,R.string.ans_type5_que27_2,R.string.ans_type5_que27_3,R.string.ans_type5_que27_4};
        int[] keyRes27 = {R.drawable.hungarian_iris,R.drawable.malabar_hill_borage,R.drawable.mountain_hydrangea,R.drawable.hard_fruit_alphonsea};
        ContentValues[] ans27 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans27[count] = new ContentValues();
            ans27[count].put(KEY_ANSWER, keyAns27[count]);
            ans27[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans27[count].put(KEY_RESOURCE,keyRes27[count]);
            ans27[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans27[count].put(KEY_QUESTION_ID, QUESTION_NO_1527);
            db.insert(TABLE_ANSWER, null, ans27[count]);
        }

        //ans-28
        int[] keyAns28 = {R.string.ans_type5_que28_1,R.string.ans_type5_que28_2,R.string.ans_type5_que28_3,R.string.ans_type5_que28_4};
        int[] keyRes28 = {R.drawable.shoofly_plant,R.drawable.malabar_nutmeg,R.drawable.red_water_lily,R.drawable.princess_flower};
        ContentValues[] ans28 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans28[count] = new ContentValues();
            ans28[count].put(KEY_ANSWER, keyAns28[count]);
            ans28[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans28[count].put(KEY_RESOURCE,keyRes28[count]);
            ans28[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans28[count].put(KEY_QUESTION_ID, QUESTION_NO_1528);
            db.insert(TABLE_ANSWER, null, ans28[count]);
        }

        //ans-29
        int[] keyAns29 = {R.string.ans_type5_que29_1,R.string.ans_type5_que29_2,R.string.ans_type5_que29_3,R.string.ans_type5_que29_4};
        int[] keyRes29 = {R.drawable.red_vanda,R.drawable.river_anemone,R.drawable.trailing_geranium,R.drawable.tulip_tree};
        ContentValues[] ans29 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans29[count] = new ContentValues();
            ans29[count].put(KEY_ANSWER, keyAns29[count]);
            ans29[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans29[count].put(KEY_RESOURCE,keyRes29[count]);
            ans29[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans29[count].put(KEY_QUESTION_ID, QUESTION_NO_1529);
            db.insert(TABLE_ANSWER, null, ans29[count]);
        }

        //ans-30
        int[] keyAns30 = {R.string.ans_type5_que30_1,R.string.ans_type5_que30_2,R.string.ans_type5_que30_3,R.string.ans_type5_que30_4};
        int[] keyRes30 = {R.drawable.flax,R.drawable.bitter_nutmeg,R.drawable.graceful_himalayan_iris,R.drawable.yellow_waterlily};
        ContentValues[] ans30 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans30[count] = new ContentValues();
            ans30[count].put(KEY_ANSWER, keyAns30[count]);
            ans30[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans30[count].put(KEY_RESOURCE,keyRes30[count]);
            ans30[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans30[count].put(KEY_QUESTION_ID, QUESTION_NO_1530);
            db.insert(TABLE_ANSWER, null, ans30[count]);
        }

        //ans-31
        int[] keyAns31 = {R.string.ans_type5_que31_1,R.string.ans_type5_que31_2,R.string.ans_type5_que31_3,R.string.ans_type5_que31_4};
        int[] keyRes31 = {R.drawable.angelwing_jasmine,R.drawable.bower_vine,R.drawable.champa,R.drawable.common_white_frangipani};
        ContentValues[] ans31 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans31[count] = new ContentValues();
            ans31[count].put(KEY_ANSWER, keyAns31[count]);
            ans31[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans31[count].put(KEY_RESOURCE,keyRes31[count]);
            ans31[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans31[count].put(KEY_QUESTION_ID, QUESTION_NO_1531);
            db.insert(TABLE_ANSWER, null, ans31[count]);
        }

        //ans-32
        int[] keyAns32 = {R.string.ans_type5_que32_1,R.string.ans_type5_que32_2,R.string.ans_type5_que32_3,R.string.ans_type5_que32_4};
        int[] keyRes32 = {R.drawable.dwarf_magnolia,R.drawable.hari_champa,R.drawable.japanese_honeysuckle,R.drawable.magnolia};
        ContentValues[] ans32 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans32[count] = new ContentValues();
            ans32[count].put(KEY_ANSWER, keyAns32[count]);
            ans32[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans32[count].put(KEY_RESOURCE,keyRes32[count]);
            ans32[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans32[count].put(KEY_QUESTION_ID, QUESTION_NO_1532);
            db.insert(TABLE_ANSWER, null, ans32[count]);
        }

        //ans-33
        int[] keyAns33 = {R.string.ans_type5_que33_1,R.string.ans_type5_que33_2,R.string.ans_type5_que33_3,R.string.ans_type5_que33_4};
        int[] keyRes33 = {R.drawable.potato_vine,R.drawable.wax_flower,R.drawable.ylang_ylang,R.drawable.bower_vine};
        ContentValues[] ans33 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans33[count] = new ContentValues();
            ans33[count].put(KEY_ANSWER, keyAns33[count]);
            ans33[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans33[count].put(KEY_RESOURCE,keyRes33[count]);
            ans33[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans33[count].put(KEY_QUESTION_ID, QUESTION_NO_1533);
            db.insert(TABLE_ANSWER, null, ans33[count]);
        }

        //ans-34
        int[] keyAns34 = {R.string.ans_type5_que34_1,R.string.ans_type5_que34_2,R.string.ans_type5_que34_3,R.string.ans_type5_que34_4};
        int[] keyRes34 = {R.drawable.bower_vine,R.drawable.five_leaf_yam,R.drawable.green_taro,R.drawable.angelwing_jasmine};
        ContentValues[] ans34 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans34[count] = new ContentValues();
            ans34[count].put(KEY_ANSWER, keyAns34[count]);
            ans34[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans34[count].put(KEY_RESOURCE,keyRes34[count]);
            ans34[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans34[count].put(KEY_QUESTION_ID, QUESTION_NO_1534);
            db.insert(TABLE_ANSWER, null, ans34[count]);
        }

        //ans-35
        int[] keyAns35 = {R.string.ans_type5_que35_1,R.string.ans_type5_que35_2,R.string.ans_type5_que35_3,R.string.ans_type5_que35_4};
        int[] keyRes35 = {R.drawable.wights_twisted_arum,R.drawable.champa,R.drawable.hari_champa,R.drawable.himalayan_aster};
        ContentValues[] ans35 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans35[count] = new ContentValues();
            ans35[count].put(KEY_ANSWER, keyAns35[count]);
            ans35[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans35[count].put(KEY_RESOURCE,keyRes35[count]);
            ans35[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans35[count].put(KEY_QUESTION_ID, QUESTION_NO_1535);
            db.insert(TABLE_ANSWER, null, ans35[count]);
        }

        //ans-36
        int[] keyAns36 = {R.string.ans_type5_que36_1,R.string.ans_type5_que36_2,R.string.ans_type5_que36_3,R.string.ans_type5_que36_4};
        int[] keyRes36 = {R.drawable.dwarf_magnolia,R.drawable.hungarian_iris,R.drawable.wild_daffodil,R.drawable.common_white_frangipani};
        ContentValues[] ans36 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans36[count] = new ContentValues();
            ans36[count].put(KEY_ANSWER, keyAns36[count]);
            ans36[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans36[count].put(KEY_RESOURCE,keyRes36[count]);
            ans36[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans36[count].put(KEY_QUESTION_ID, QUESTION_NO_1536);
            db.insert(TABLE_ANSWER, null, ans36[count]);
        }

        //ans-37
        int[] keyAns37 = {R.string.ans_type5_que37_1,R.string.ans_type5_que37_2,R.string.ans_type5_que37_3,R.string.ans_type5_que37_4};
        int[] keyRes37 = {R.drawable.malabar_hill_borage,R.drawable.magnolia,R.drawable.mountain_hydrangea,R.drawable.peruvian_lily};
        ContentValues[] ans37 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans37[count] = new ContentValues();
            ans37[count].put(KEY_ANSWER, keyAns37[count]);
            ans37[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans37[count].put(KEY_RESOURCE,keyRes37[count]);
            ans37[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans37[count].put(KEY_QUESTION_ID, QUESTION_NO_1537);
            db.insert(TABLE_ANSWER, null, ans37[count]);
        }

        //ans-38
        int[] keyAns38 = {R.string.ans_type5_que38_1,R.string.ans_type5_que38_2,R.string.ans_type5_que38_3,R.string.ans_type5_que38_4};
        int[] keyRes38 = {R.drawable.red_vanda,R.drawable.wax_flower,R.drawable.japanese_honeysuckle,R.drawable.princess_flower};
        ContentValues[] ans38 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans38[count] = new ContentValues();
            ans38[count].put(KEY_ANSWER, keyAns38[count]);
            ans38[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans38[count].put(KEY_RESOURCE,keyRes38[count]);
            ans38[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans38[count].put(KEY_QUESTION_ID, QUESTION_NO_1538);
            db.insert(TABLE_ANSWER, null, ans38[count]);
        }

        //ans-39
        int[] keyAns39 = {R.string.ans_type5_que39_1,R.string.ans_type5_que39_2,R.string.ans_type5_que39_3,R.string.ans_type5_que39_4};
        int[] keyRes39 = {R.drawable.trailing_geranium,R.drawable.potato_vine,R.drawable.long_leaf_pondweed,R.drawable.ylang_ylang};
        ContentValues[] ans39 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans39[count] = new ContentValues();
            ans39[count].put(KEY_ANSWER, keyAns39[count]);
            ans39[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans39[count].put(KEY_RESOURCE,keyRes39[count]);
            ans39[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans39[count].put(KEY_QUESTION_ID, QUESTION_NO_1539);
            db.insert(TABLE_ANSWER, null, ans39[count]);
        }

        //ans-40
        int[] keyAns40 = {R.string.ans_type5_que40_1,R.string.ans_type5_que40_2,R.string.ans_type5_que40_3,R.string.ans_type5_que40_4};
        int[] keyRes40 = {R.drawable.japanese_honeysuckle,R.drawable.flax,R.drawable.hari_champa,R.drawable.stepladder_ginger};
        ContentValues[] ans40 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans40[count] = new ContentValues();
            ans40[count].put(KEY_ANSWER, keyAns40[count]);
            ans40[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans40[count].put(KEY_RESOURCE,keyRes40[count]);
            ans40[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans40[count].put(KEY_QUESTION_ID, QUESTION_NO_1540);
            db.insert(TABLE_ANSWER, null, ans40[count]);
        }

        //ans-41
        int[] keyAns41 = {R.string.ans_type5_que41_1,R.string.ans_type5_que41_2,R.string.ans_type5_que41_3,R.string.ans_type5_que41_4};
        int[] keyRes41 = {R.drawable.calico_flower,R.drawable.creeping_zinnia,R.drawable.gloxinia,R.drawable.har_singar};
        ContentValues[] ans41 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans41[count] = new ContentValues();
            ans41[count].put(KEY_ANSWER, keyAns41[count]);
            ans41[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans41[count].put(KEY_RESOURCE,keyRes41[count]);
            ans41[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans41[count].put(KEY_QUESTION_ID, QUESTION_NO_1541);
            db.insert(TABLE_ANSWER, null, ans41[count]);
        }

        //ans-42
        int[] keyAns42 = {R.string.ans_type5_que42_1,R.string.ans_type5_que42_2,R.string.ans_type5_que42_3,R.string.ans_type5_que42_4};
        int[] keyRes42 = {R.drawable.large_yellow_foxglove,R.drawable.lily_magnolia,R.drawable.marigold_yellow,R.drawable.mexican_oleander};
        ContentValues[] ans42 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans42[count] = new ContentValues();
            ans42[count].put(KEY_ANSWER, keyAns42[count]);
            ans42[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans42[count].put(KEY_RESOURCE,keyRes42[count]);
            ans42[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans42[count].put(KEY_QUESTION_ID, QUESTION_NO_1542);
            db.insert(TABLE_ANSWER, null, ans42[count]);
        }

        //ans-43
        int[] keyAns43 = {R.string.ans_type5_que43_1,R.string.ans_type5_que43_2,R.string.ans_type5_que43_3,R.string.ans_type5_que43_4};
        int[] keyRes43 = {R.drawable.nilofar,R.drawable.stinging_wigandia,R.drawable.striped_philippine_violet,R.drawable.sunset_bells};
        ContentValues[] ans43 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans43[count] = new ContentValues();
            ans43[count].put(KEY_ANSWER, keyAns43[count]);
            ans43[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans43[count].put(KEY_RESOURCE,keyRes43[count]);
            ans43[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans43[count].put(KEY_QUESTION_ID, QUESTION_NO_1543);
            db.insert(TABLE_ANSWER, null, ans43[count]);
        }

        //ans-44
        int[] keyAns44 = {R.string.ans_type5_que44_1,R.string.ans_type5_que44_2,R.string.ans_type5_que44_3,R.string.ans_type5_que44_4};
        int[] keyRes44 = {R.drawable.white_water_lily,R.drawable.yellow_pond_lily,R.drawable.creeping_zinnia,R.drawable.marigold_yellow};
        ContentValues[] ans44 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans44[count] = new ContentValues();
            ans44[count].put(KEY_ANSWER, keyAns44[count]);
            ans44[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans44[count].put(KEY_RESOURCE,keyRes44[count]);
            ans44[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans44[count].put(KEY_QUESTION_ID, QUESTION_NO_1544);
            db.insert(TABLE_ANSWER, null, ans44[count]);
        }

        //ans-45
        int[] keyAns45 = {R.string.ans_type5_que45_1,R.string.ans_type5_que45_2,R.string.ans_type5_que45_3,R.string.ans_type5_que45_4};
        int[] keyRes45 = {R.drawable.calico_flower,R.drawable.hungarian_black_chilli,R.drawable.creeping_zinnia,R.drawable.himalayan_aster};
        ContentValues[] ans45 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans45[count] = new ContentValues();
            ans45[count].put(KEY_ANSWER, keyAns45[count]);
            ans45[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans45[count].put(KEY_RESOURCE,keyRes45[count]);
            ans45[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans45[count].put(KEY_QUESTION_ID, QUESTION_NO_1545);
            db.insert(TABLE_ANSWER, null, ans45[count]);
        }

        //ans-46
        int[] keyAns46 = {R.string.ans_type5_que46_1,R.string.ans_type5_que46_2,R.string.ans_type5_que46_3,R.string.ans_type5_que46_4};
        int[] keyRes46 = {R.drawable.kanpet,R.drawable.gloxinia,R.drawable.long_flower_barleria,R.drawable.har_singar};
        ContentValues[] ans46 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans46[count] = new ContentValues();
            ans46[count].put(KEY_ANSWER, keyAns46[count]);
            ans46[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans46[count].put(KEY_RESOURCE,keyRes46[count]);
            ans46[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans46[count].put(KEY_QUESTION_ID, QUESTION_NO_1546);
            db.insert(TABLE_ANSWER, null, ans46[count]);
        }

        //ans-47
        int[] keyAns47 = {R.string.ans_type5_que47_1,R.string.ans_type5_que47_2,R.string.ans_type5_que47_3,R.string.ans_type5_que47_4};
        int[] keyRes47 = {R.drawable.large_yellow_foxglove,R.drawable.mountain_rose,R.drawable.lily_magnolia,R.drawable.peruvian_lily};
        ContentValues[] ans47 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans47[count] = new ContentValues();
            ans47[count].put(KEY_ANSWER, keyAns47[count]);
            ans47[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans47[count].put(KEY_RESOURCE,keyRes47[count]);
            ans47[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans47[count].put(KEY_QUESTION_ID, QUESTION_NO_1547);
            db.insert(TABLE_ANSWER, null, ans47[count]);
        }

        //ans-48
        int[] keyAns48 = {R.string.ans_type5_que48_1,R.string.ans_type5_que48_2,R.string.ans_type5_que48_3,R.string.ans_type5_que48_4};
        int[] keyRes48 = {R.drawable.queen_crape_myrtle,R.drawable.marigold_yellow,R.drawable.red_water_lily,R.drawable.mexican_oleander};
        ContentValues[] ans48 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans48[count] = new ContentValues();
            ans48[count].put(KEY_ANSWER, keyAns48[count]);
            ans48[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans48[count].put(KEY_RESOURCE,keyRes48[count]);
            ans48[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans48[count].put(KEY_QUESTION_ID, QUESTION_NO_1548);
            db.insert(TABLE_ANSWER, null, ans48[count]);
        }

        //ans-49
        int[] keyAns49 = {R.string.ans_type5_que49_1,R.string.ans_type5_que49_2,R.string.ans_type5_que49_3,R.string.ans_type5_que49_4};
        int[] keyRes49 = {R.drawable.nilofar,R.drawable.river_anemone,R.drawable.stinging_wigandia,R.drawable.tulip_tree};
        ContentValues[] ans49 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans49[count] = new ContentValues();
            ans49[count].put(KEY_ANSWER, keyAns49[count]);
            ans49[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans49[count].put(KEY_RESOURCE,keyRes49[count]);
            ans49[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans49[count].put(KEY_QUESTION_ID, QUESTION_NO_1549);
            db.insert(TABLE_ANSWER, null, ans49[count]);
        }

        //ans-50
        int[] keyAns50 = {R.string.ans_type5_que50_1,R.string.ans_type5_que50_2,R.string.ans_type5_que50_3,R.string.ans_type5_que50_4};
        int[] keyRes50 = {R.drawable.yellow_waterlily,R.drawable.striped_philippine_violet,R.drawable.graceful_himalayan_iris,R.drawable.sunset_bells};
        ContentValues[] ans50 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans50[count] = new ContentValues();
            ans50[count].put(KEY_ANSWER, keyAns50[count]);
            ans50[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans50[count].put(KEY_RESOURCE,keyRes50[count]);
            ans50[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans50[count].put(KEY_QUESTION_ID, QUESTION_NO_1550);
            db.insert(TABLE_ANSWER, null, ans50[count]);
        }

        //ans-51
        int[] keyAns51 = {R.string.ans_type5_que51_1,R.string.ans_type5_que51_2,R.string.ans_type5_que51_3,R.string.ans_type5_que51_4};
        int[] keyRes51 = {R.drawable.white_water_lily,R.drawable.green_taro,R.drawable.yellow_pond_lily,R.drawable.five_leaf_yam};
        ContentValues[] ans51 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans51[count] = new ContentValues();
            ans51[count].put(KEY_ANSWER, keyAns51[count]);
            ans51[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans51[count].put(KEY_RESOURCE,keyRes51[count]);
            ans51[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans51[count].put(KEY_QUESTION_ID, QUESTION_NO_1551);
            db.insert(TABLE_ANSWER, null, ans51[count]);
        }

        //ans-52
        int[] keyAns52 = {R.string.ans_type5_que52_1,R.string.ans_type5_que52_2,R.string.ans_type5_que52_3,R.string.ans_type5_que52_4};
        int[] keyRes52 = {R.drawable.campbell_s_magnolia,R.drawable.devil_s_tongue,R.drawable.egg_magnolia,R.drawable.fragrant_yellow_geranium};
        ContentValues[] ans52 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans52[count] = new ContentValues();
            ans52[count].put(KEY_ANSWER, keyAns52[count]);
            ans52[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans52[count].put(KEY_RESOURCE,keyRes52[count]);
            ans52[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans52[count].put(KEY_QUESTION_ID, QUESTION_NO_1552);
            db.insert(TABLE_ANSWER, null, ans52[count]);
        }

        //ans-53
        int[] keyAns53 = {R.string.ans_type5_que53_1,R.string.ans_type5_que53_2,R.string.ans_type5_que53_3,R.string.ans_type5_que53_4};
        int[] keyRes53 = {R.drawable.himalayan_melastome,R.drawable.himalayan_peony,R.drawable.egg_magnolia,R.drawable.small_flowered_willow_herb};
        ContentValues[] ans53 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans53[count] = new ContentValues();
            ans53[count].put(KEY_ANSWER, keyAns53[count]);
            ans53[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans53[count].put(KEY_RESOURCE,keyRes53[count]);
            ans53[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans53[count].put(KEY_QUESTION_ID, QUESTION_NO_1553);
            db.insert(TABLE_ANSWER, null, ans53[count]);
        }

        //ans-54
        int[] keyAns54 = {R.string.ans_type5_que54_1,R.string.ans_type5_que54_2,R.string.ans_type5_que54_3,R.string.ans_type5_que54_4};
        int[] keyRes54 = {R.drawable.thread_leaved_water_crowfoot,R.drawable.tibetan_willow_herb,R.drawable.wallich_geranium,R.drawable.graceful_himalayan_iris};
        ContentValues[] ans54 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans54[count] = new ContentValues();
            ans54[count].put(KEY_ANSWER, keyAns54[count]);
            ans54[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans54[count].put(KEY_RESOURCE,keyRes54[count]);
            ans54[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans54[count].put(KEY_QUESTION_ID, QUESTION_NO_1554);
            db.insert(TABLE_ANSWER, null, ans54[count]);
        }

        //ans-55
        int[] keyAns55 = {R.string.ans_type5_que55_1,R.string.ans_type5_que55_2,R.string.ans_type5_que55_3,R.string.ans_type5_que55_4};
        int[] keyRes55 = {R.drawable.campbell_s_magnolia,R.drawable.stepladder_ginger,R.drawable.long_flowered_spider_lily,R.drawable.devil_s_tongue};
        ContentValues[] ans55 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans55[count] = new ContentValues();
            ans55[count].put(KEY_ANSWER, keyAns55[count]);
            ans55[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans55[count].put(KEY_RESOURCE,keyRes55[count]);
            ans55[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans55[count].put(KEY_QUESTION_ID, QUESTION_NO_1555);
            db.insert(TABLE_ANSWER, null, ans55[count]);
        }

        //ans-56
        int[] keyAns56 = {R.string.ans_type5_que56_1,R.string.ans_type5_que56_2,R.string.ans_type5_que16_3,R.string.ans_type5_que56_4};
        int[] keyRes56 = {R.drawable.kanpet,R.drawable.egg_magnolia,R.drawable.wild_daffodil,R.drawable.long_leaf_pondweed};
        ContentValues[] ans56 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans56[count] = new ContentValues();
            ans56[count].put(KEY_ANSWER, keyAns56[count]);
            ans56[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans56[count].put(KEY_RESOURCE,keyRes56[count]);
            ans56[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans56[count].put(KEY_QUESTION_ID, QUESTION_NO_1556);
            db.insert(TABLE_ANSWER, null, ans56[count]);
        }

        //ans-57
        int[] keyAns57 = {R.string.ans_type5_que57_1,R.string.ans_type5_que57_2,R.string.ans_type5_que57_3,R.string.ans_type5_que57_4};
        int[] keyRes57 = {R.drawable.himalayan_melastome,R.drawable.peace_lily,R.drawable.himalayan_peony,R.drawable.peruvian_lily};
        ContentValues[] ans57 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans57[count] = new ContentValues();
            ans57[count].put(KEY_ANSWER, keyAns57[count]);
            ans57[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans57[count].put(KEY_RESOURCE,keyRes57[count]);
            ans57[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans57[count].put(KEY_QUESTION_ID, QUESTION_NO_1557);
            db.insert(TABLE_ANSWER, null, ans57[count]);
        }

        //ans-58
        int[] keyAns58 = {R.string.ans_type5_que58_1,R.string.ans_type5_que58_2,R.string.ans_type5_que58_3,R.string.ans_type5_que58_4};
        int[] keyRes58 = {R.drawable.red_vanda,R.drawable.thread_leaved_water_crowfoot,R.drawable.five_leaf_yam,R.drawable.small_flowered_willow_herb};
        ContentValues[] ans58 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans58[count] = new ContentValues();
            ans58[count].put(KEY_ANSWER, keyAns58[count]);
            ans58[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans58[count].put(KEY_RESOURCE,keyRes58[count]);
            ans58[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans58[count].put(KEY_QUESTION_ID, QUESTION_NO_1558);
            db.insert(TABLE_ANSWER, null, ans58[count]);
        }

        //ans-59
        int[] keyAns59 = {R.string.ans_type5_que59_1,R.string.ans_type5_que59_2,R.string.ans_type5_que59_3,R.string.ans_type5_que59_4};
        int[] keyRes59 = {R.drawable.thread_leaved_water_crowfoot,R.drawable.yellow_waterlily,R.drawable.long_leaf_pondweed,R.drawable.tibetan_willow_herb};
        ContentValues[] ans59 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans59[count] = new ContentValues();
            ans59[count].put(KEY_ANSWER, keyAns59[count]);
            ans59[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans59[count].put(KEY_RESOURCE,keyRes59[count]);
            ans59[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans59[count].put(KEY_QUESTION_ID, QUESTION_NO_1559);
            db.insert(TABLE_ANSWER, null, ans59[count]);
        }

        //ans-60
        int[] keyAns60 = {R.string.ans_type5_que60_1,R.string.ans_type5_que60_2,R.string.ans_type5_que60_3,R.string.ans_type5_que60_4};
        int[] keyRes60 = {R.drawable.shoofly_plant,R.drawable.wallich_geranium,R.drawable.graceful_himalayan_iris,R.drawable.stepladder_ginger};
        ContentValues[] ans60 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans60[count] = new ContentValues();
            ans60[count].put(KEY_ANSWER, keyAns60[count]);
            ans60[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans60[count].put(KEY_RESOURCE,keyRes60[count]);
            ans60[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans60[count].put(KEY_QUESTION_ID, QUESTION_NO_1560);
            db.insert(TABLE_ANSWER, null, ans60[count]);
        }

        //ans-61
        int[] keyAns61 = {R.string.ans_type5_que61_1,R.string.ans_type5_que61_2,R.string.ans_type5_que61_3,R.string.ans_type5_que61_4};
        int[] keyRes61 = {R.drawable.aloe_vera,R.drawable.brazilian_vaseplant,R.drawable.caribbean_century_plant,R.drawable.century_plant};
        ContentValues[] ans61 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans61[count] = new ContentValues();
            ans61[count].put(KEY_ANSWER, keyAns61[count]);
            ans61[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans61[count].put(KEY_RESOURCE,keyRes61[count]);
            ans61[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans61[count].put(KEY_QUESTION_ID, QUESTION_NO_1561);
            db.insert(TABLE_ANSWER, null, ans61[count]);
        }

        //ans-62
        int[] keyAns62 = {R.string.ans_type5_que62_1,R.string.ans_type5_que62_2,R.string.ans_type5_que62_3,R.string.ans_type5_que62_4};
        int[] keyRes62 = {R.drawable.creeping_cradle_plant,R.drawable.delta_shaped_aloe,R.drawable.foolproof_plant,R.drawable.gasteria};
        ContentValues[] ans62 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans62[count] = new ContentValues();
            ans62[count].put(KEY_ANSWER, keyAns62[count]);
            ans62[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans62[count].put(KEY_RESOURCE,keyRes62[count]);
            ans62[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans62[count].put(KEY_QUESTION_ID, QUESTION_NO_1562);
            db.insert(TABLE_ANSWER, null, ans62[count]);
        }

        //ans-63
        int[] keyAns63 = {R.string.ans_type5_que63_1,R.string.ans_type5_que63_2,R.string.ans_type5_que63_3,R.string.ans_type5_que63_4};
        int[] keyRes63 = {R.drawable.hawaiian_ti_plant,R.drawable.jade_plant,R.drawable.kenya_hyacinth,R.drawable.marsh_dewflower};
        ContentValues[] ans63 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans63[count] = new ContentValues();
            ans63[count].put(KEY_ANSWER, keyAns63[count]);
            ans63[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans63[count].put(KEY_RESOURCE,keyRes63[count]);
            ans63[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans63[count].put(KEY_QUESTION_ID, QUESTION_NO_1563);
            db.insert(TABLE_ANSWER, null, ans63[count]);
        }

        //ans-64
        int[] keyAns64 = {R.string.ans_type5_que64_1,R.string.ans_type5_que64_2,R.string.ans_type5_que64_3,R.string.ans_type5_que64_4};
        int[] keyRes64 = {R.drawable.silver_leaved_earth_star,R.drawable.silver_vase_bromeliad,R.drawable.snake_plant,R.drawable.soap_aloe};
        ContentValues[] ans64 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans64[count] = new ContentValues();
            ans64[count].put(KEY_ANSWER, keyAns64[count]);
            ans64[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans64[count].put(KEY_RESOURCE,keyRes64[count]);
            ans64[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans64[count].put(KEY_QUESTION_ID, QUESTION_NO_1564);
            db.insert(TABLE_ANSWER, null, ans64[count]);
        }

        //ans-65
        int[] keyAns65 = {R.string.ans_type5_que65_1,R.string.ans_type5_que65_2,R.string.ans_type5_que65_3,R.string.ans_type5_que65_4};
        int[] keyRes65 = {R.drawable.spanish_dagger,R.drawable.spider_aloe,R.drawable.swan_s_neck_agave,R.drawable.trifid_sedum};
        ContentValues[] ans65 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans65[count] = new ContentValues();
            ans65[count].put(KEY_ANSWER, keyAns65[count]);
            ans65[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans65[count].put(KEY_RESOURCE,keyRes65[count]);
            ans65[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans65[count].put(KEY_QUESTION_ID, QUESTION_NO_1565);
            db.insert(TABLE_ANSWER, null, ans65[count]);
        }

        //ans-66
        int[] keyAns66 = {R.string.ans_type5_que66_1,R.string.ans_type5_que66_2,R.string.ans_type5_que66_3,R.string.ans_type5_que66_4};
        int[] keyRes66 = {R.drawable.aloe_vera,R.drawable.mountain_rose,R.drawable.tulip_tree,R.drawable.brazilian_vaseplant};
        ContentValues[] ans66 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans66[count] = new ContentValues();
            ans66[count].put(KEY_ANSWER, keyAns66[count]);
            ans66[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans66[count].put(KEY_RESOURCE,keyRes66[count]);
            ans66[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans66[count].put(KEY_QUESTION_ID, QUESTION_NO_1566);
            db.insert(TABLE_ANSWER, null, ans66[count]);
        }

        //ans-67
        int[] keyAns67 = {R.string.ans_type5_que67_1,R.string.ans_type5_que67_2,R.string.ans_type5_que67_3,R.string.ans_type5_que67_4};
        int[] keyRes67 = {R.drawable.hungarian_iris,R.drawable.caribbean_century_plant,R.drawable.mountain_hydrangea,R.drawable.century_plant};
        ContentValues[] ans67 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans67[count] = new ContentValues();
            ans67[count].put(KEY_ANSWER, keyAns67[count]);
            ans67[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans67[count].put(KEY_RESOURCE,keyRes67[count]);
            ans67[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans67[count].put(KEY_QUESTION_ID, QUESTION_NO_1567);
            db.insert(TABLE_ANSWER, null, ans67[count]);
        }

        //ans-68
        int[] keyAns68 = {R.string.ans_type5_que68_1,R.string.ans_type5_que68_2,R.string.ans_type5_que68_3,R.string.ans_type5_que68_4};
        int[] keyRes68 = {R.drawable.shoofly_plant,R.drawable.creeping_cradle_plant,R.drawable.delta_shaped_aloe,R.drawable.princess_flower};
        ContentValues[] ans68 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans68[count] = new ContentValues();
            ans68[count].put(KEY_ANSWER, keyAns68[count]);
            ans68[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans68[count].put(KEY_RESOURCE,keyRes68[count]);
            ans68[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans68[count].put(KEY_QUESTION_ID, QUESTION_NO_1568);
            db.insert(TABLE_ANSWER, null, ans68[count]);
        }

        //ans-69
        int[] keyAns69 = {R.string.ans_type5_que69_1,R.string.ans_type5_que69_2,R.string.ans_type5_que69_3,R.string.ans_type5_que69_4};
        int[] keyRes69 = {R.drawable.foolproof_plant,R.drawable.river_anemone,R.drawable.trailing_geranium,R.drawable.gasteria};
        ContentValues[] ans69 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans69[count] = new ContentValues();
            ans69[count].put(KEY_ANSWER, keyAns69[count]);
            ans69[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans69[count].put(KEY_RESOURCE,keyRes69[count]);
            ans69[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans69[count].put(KEY_QUESTION_ID, QUESTION_NO_1569);
            db.insert(TABLE_ANSWER, null, ans69[count]);
        }

        //ans-70
        int[] keyAns70 = {R.string.ans_type5_que70_1,R.string.ans_type5_que70_2,R.string.ans_type5_que70_3,R.string.ans_type5_que70_4};
        int[] keyRes70 = {R.drawable.hawaiian_ti_plant,R.drawable.bitter_nutmeg,R.drawable.jade_plant,R.drawable.yellow_waterlily};
        ContentValues[] ans70 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans70[count] = new ContentValues();
            ans70[count].put(KEY_ANSWER, keyAns70[count]);
            ans70[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans70[count].put(KEY_RESOURCE,keyRes70[count]);
            ans70[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans70[count].put(KEY_QUESTION_ID, QUESTION_NO_1570);
            db.insert(TABLE_ANSWER, null, ans70[count]);
        }

        //ans-71
        int[] keyAns71 = {R.string.ans_type5_que71_1,R.string.ans_type5_que71_2,R.string.ans_type5_que71_3,R.string.ans_type5_que71_4};
        int[] keyRes71 = {R.drawable.angelwing_jasmine,R.drawable.kenya_hyacinth,R.drawable.champa,R.drawable.marsh_dewflower};
        ContentValues[] ans71 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans71[count] = new ContentValues();
            ans71[count].put(KEY_ANSWER, keyAns71[count]);
            ans71[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans71[count].put(KEY_RESOURCE,keyRes71[count]);
            ans71[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans71[count].put(KEY_QUESTION_ID, QUESTION_NO_1571);
            db.insert(TABLE_ANSWER, null, ans71[count]);
        }

        //ans-72
        int[] keyAns72 = {R.string.ans_type5_que72_1,R.string.ans_type5_que72_2,R.string.ans_type5_que72_3,R.string.ans_type5_que72_4};
        int[] keyRes72 = {R.drawable.silver_leaved_earth_star,R.drawable.hari_champa,R.drawable.japanese_honeysuckle,R.drawable.silver_vase_bromeliad};
        ContentValues[] ans72 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans72[count] = new ContentValues();
            ans72[count].put(KEY_ANSWER, keyAns72[count]);
            ans72[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans72[count].put(KEY_RESOURCE,keyRes72[count]);
            ans72[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans72[count].put(KEY_QUESTION_ID, QUESTION_NO_1572);
            db.insert(TABLE_ANSWER, null, ans72[count]);
        }

        //ans-73
        int[] keyAns73 = {R.string.ans_type5_que73_1,R.string.ans_type5_que73_2,R.string.ans_type5_que73_3,R.string.ans_type5_que73_4};
        int[] keyRes73 = {R.drawable.potato_vine,R.drawable.snake_plant,R.drawable.soap_aloe,R.drawable.bower_vine};
        ContentValues[] ans73 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans73[count] = new ContentValues();
            ans73[count].put(KEY_ANSWER, keyAns73[count]);
            ans73[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans73[count].put(KEY_RESOURCE,keyRes73[count]);
            ans73[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans73[count].put(KEY_QUESTION_ID, QUESTION_NO_1573);
            db.insert(TABLE_ANSWER, null, ans73[count]);
        }

        //ans-74
        int[] keyAns74 = {R.string.ans_type5_que74_1,R.string.ans_type5_que74_2,R.string.ans_type5_que74_3,R.string.ans_type5_que74_4};
        int[] keyRes74 = {R.drawable.spanish_dagger,R.drawable.five_leaf_yam,R.drawable.spider_aloe,R.drawable.angelwing_jasmine};
        ContentValues[] ans74 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans74[count] = new ContentValues();
            ans74[count].put(KEY_ANSWER, keyAns74[count]);
            ans74[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans74[count].put(KEY_RESOURCE,keyRes74[count]);
            ans74[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans74[count].put(KEY_QUESTION_ID, QUESTION_NO_1574);
            db.insert(TABLE_ANSWER, null, ans74[count]);
        }

        //ans-75
        int[] keyAns75 = {R.string.ans_type5_que75_1,R.string.ans_type5_que75_2,R.string.ans_type5_que75_3,R.string.ans_type5_que75_4};
        int[] keyRes75 = {R.drawable.wights_twisted_arum,R.drawable.swan_s_neck_agave,R.drawable.hari_champa,R.drawable.trifid_sedum};
        ContentValues[] ans75 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans75[count] = new ContentValues();
            ans75[count].put(KEY_ANSWER, keyAns75[count]);
            ans75[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans75[count].put(KEY_RESOURCE,keyRes75[count]);
            ans75[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans75[count].put(KEY_QUESTION_ID, QUESTION_NO_1575);
            db.insert(TABLE_ANSWER, null, ans75[count]);
        }

        //ans-76
        int[] keyAns76 = {R.string.ans_type5_que76_1,R.string.ans_type5_que76_2,R.string.ans_type5_que76_3,R.string.ans_type5_que76_4};
        int[] keyRes76 = {R.drawable.beej_karela,R.drawable.cheerful_senecio,R.drawable.himalayan_indigo,R.drawable.indian_oreorchis};
        ContentValues[] ans76 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans76[count] = new ContentValues();
            ans76[count].put(KEY_ANSWER, keyAns76[count]);
            ans76[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans76[count].put(KEY_RESOURCE,keyRes76[count]);
            ans76[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans76[count].put(KEY_QUESTION_ID, QUESTION_NO_1576);
            db.insert(TABLE_ANSWER, null, ans76[count]);
        }

        //ans-77
        int[] keyAns77 = {R.string.ans_type5_que77_1,R.string.ans_type5_que77_2,R.string.ans_type5_que77_3,R.string.ans_type5_que77_4};
        int[] keyRes77 = {R.drawable.kumaon_iris,R.drawable.kut,R.drawable.tall_alplily,R.drawable.trifid_sedum};
        ContentValues[] ans77 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans77[count] = new ContentValues();
            ans77[count].put(KEY_ANSWER, keyAns77[count]);
            ans77[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans77[count].put(KEY_RESOURCE,keyRes77[count]);
            ans77[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans77[count].put(KEY_QUESTION_ID, QUESTION_NO_1577);
            db.insert(TABLE_ANSWER, null, ans77[count]);
        }

        //ans-78
        int[] keyAns78 = {R.string.ans_type5_que78_1,R.string.ans_type5_que78_2,R.string.ans_type5_que78_3,R.string.ans_type5_que78_4};
        int[] keyRes78 = {R.drawable.wallich_s_myriactis,R.drawable.wights_myriactis,R.drawable.yellow_coralroot,R.drawable.yellow_spotted_white_saxifrage};
        ContentValues[] ans78 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans78[count] = new ContentValues();
            ans78[count].put(KEY_ANSWER, keyAns78[count]);
            ans78[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans78[count].put(KEY_RESOURCE,keyRes78[count]);
            ans78[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans78[count].put(KEY_QUESTION_ID, QUESTION_NO_1578);
            db.insert(TABLE_ANSWER, null, ans78[count]);
        }

        //ans-79
        int[] keyAns79 = {R.string.ans_type5_que79_1,R.string.ans_type5_que79_2,R.string.ans_type5_que79_3,R.string.ans_type5_que79_4};
        int[] keyRes79 = {R.drawable.cheerful_senecio,R.drawable.potato_vine,R.drawable.tall_alplily,R.drawable.ylang_ylang};
        ContentValues[] ans79 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans79[count] = new ContentValues();
            ans79[count].put(KEY_ANSWER, keyAns79[count]);
            ans79[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans79[count].put(KEY_RESOURCE,keyRes79[count]);
            ans79[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans79[count].put(KEY_QUESTION_ID, QUESTION_NO_1579);
            db.insert(TABLE_ANSWER, null, ans79[count]);
        }

        //ans-80
        int[] keyAns80 = {R.string.ans_type5_que80_1,R.string.ans_type5_que80_2,R.string.ans_type5_que80_3,R.string.ans_type5_que80_4};
        int[] keyRes80 = {R.drawable.japanese_honeysuckle,R.drawable.kut,R.drawable.hari_champa,R.drawable.beej_karela};
        ContentValues[] ans80 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans80[count] = new ContentValues();
            ans80[count].put(KEY_ANSWER, keyAns80[count]);
            ans80[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans80[count].put(KEY_RESOURCE,keyRes80[count]);
            ans80[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans80[count].put(KEY_QUESTION_ID, QUESTION_NO_1580);
            db.insert(TABLE_ANSWER, null, ans80[count]);
        }

        //ans-81
        int[] keyAns81 = {R.string.ans_type5_que81_1,R.string.ans_type5_que81_2,R.string.ans_type5_que81_3,R.string.ans_type5_que81_4};
        int[] keyRes81 = {R.drawable.alpine_sedge,R.drawable.annual_blu_eyed_grass,R.drawable.balcooa_bamboo,R.drawable.barley_brome};
        ContentValues[] ans81 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans81[count] = new ContentValues();
            ans81[count].put(KEY_ANSWER, keyAns81[count]);
            ans81[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans81[count].put(KEY_RESOURCE,keyRes81[count]);
            ans81[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans81[count].put(KEY_QUESTION_ID, QUESTION_NO_1581);
            db.insert(TABLE_ANSWER, null, ans81[count]);
        }

        //ans-82
        int[] keyAns82 = {R.string.ans_type5_que82_1,R.string.ans_type5_que82_2,R.string.ans_type5_que82_3,R.string.ans_type5_que82_4};
        int[] keyRes82 = {R.drawable.bengal_bamboo,R.drawable.buddha_belly_bamboo,R.drawable.cheatgrass,R.drawable.common_oat};
        ContentValues[] ans82 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans82[count] = new ContentValues();
            ans82[count].put(KEY_ANSWER, keyAns82[count]);
            ans82[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans82[count].put(KEY_RESOURCE,keyRes82[count]);
            ans82[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans82[count].put(KEY_QUESTION_ID, QUESTION_NO_1582);
            db.insert(TABLE_ANSWER, null, ans82[count]);
        }

        //ans-83
        int[] keyAns83 = {R.string.ans_type5_que83_1,R.string.ans_type5_que83_2,R.string.ans_type5_que83_3,R.string.ans_type5_que83_4};
        int[] keyRes83 = {R.drawable.dwarf_reedgrass,R.drawable.golden_bamboo,R.drawable.indian_thorny_bamboo,R.drawable.mangrove_grass};
        ContentValues[] ans83 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans83[count] = new ContentValues();
            ans83[count].put(KEY_ANSWER, keyAns83[count]);
            ans83[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans83[count].put(KEY_RESOURCE,keyRes83[count]);
            ans83[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans83[count].put(KEY_QUESTION_ID, QUESTION_NO_1583);
            db.insert(TABLE_ANSWER, null, ans83[count]);
        }

        //ans-84
        int[] keyAns84 = {R.string.ans_type5_que84_1,R.string.ans_type5_que84_2,R.string.ans_type5_que84_3,R.string.ans_type5_que84_4};
        int[] keyRes84 = {R.drawable.mauritian_grass,R.drawable.nepal_foxtail_grass,R.drawable.rescue_grass,R.drawable.summer_grass};
        ContentValues[] ans84 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans84[count] = new ContentValues();
            ans84[count].put(KEY_ANSWER, keyAns84[count]);
            ans84[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans84[count].put(KEY_RESOURCE,keyRes84[count]);
            ans84[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans84[count].put(KEY_QUESTION_ID, QUESTION_NO_1584);
            db.insert(TABLE_ANSWER, null, ans84[count]);
        }

        //ans-85
        int[] keyAns85 = {R.string.ans_type5_que85_1,R.string.ans_type5_que85_2,R.string.ans_type5_que85_3,R.string.ans_type5_que85_4};
        int[] keyRes85 = {R.drawable.summer_grass,R.drawable.swollen_finger_grass,R.drawable.tausch_s_goat_grass,R.drawable.yellow_bluestem_grass};
        ContentValues[] ans85 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans85[count] = new ContentValues();
            ans85[count].put(KEY_ANSWER, keyAns85[count]);
            ans85[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans85[count].put(KEY_RESOURCE,keyRes85[count]);
            ans85[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans85[count].put(KEY_QUESTION_ID, QUESTION_NO_1585);
            db.insert(TABLE_ANSWER, null, ans85[count]);
        }

        //ans-86
        int[] keyAns86 = {R.string.ans_type5_que86_1,R.string.ans_type5_que86_2,R.string.ans_type5_que86_3,R.string.ans_type5_que86_4};
        int[] keyRes86 = {R.drawable.alpine_sedge,R.drawable.hungarian_iris,R.drawable.annual_blu_eyed_grass,R.drawable.johnson_s_amaryllis};
        ContentValues[] ans86 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans86[count] = new ContentValues();
            ans86[count].put(KEY_ANSWER, keyAns86[count]);
            ans86[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans86[count].put(KEY_RESOURCE,keyRes86[count]);
            ans86[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans86[count].put(KEY_QUESTION_ID, QUESTION_NO_1586);
            db.insert(TABLE_ANSWER, null, ans86[count]);
        }

        //ans-87
        int[] keyAns87 = {R.string.ans_type5_que87_1,R.string.ans_type5_que87_2,R.string.ans_type5_que87_3,R.string.ans_type5_que87_4};
        int[] keyRes87 = {R.drawable.malabar_hill_borage,R.drawable.balcooa_bamboo,R.drawable.mountain_hydrangea,R.drawable.barley_brome};
        ContentValues[] ans87 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans87[count] = new ContentValues();
            ans87[count].put(KEY_ANSWER, keyAns87[count]);
            ans87[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans87[count].put(KEY_RESOURCE,keyRes87[count]);
            ans87[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans87[count].put(KEY_QUESTION_ID, QUESTION_NO_1587);
            db.insert(TABLE_ANSWER, null, ans87[count]);
        }

        //ans-88
        int[] keyAns88 = {R.string.ans_type5_que88_1,R.string.ans_type5_que88_2,R.string.ans_type5_que88_3,R.string.ans_type5_que88_4};
        int[] keyRes88 = {R.drawable.bengal_bamboo,R.drawable.red_vanda,R.drawable.red_water_lily,R.drawable.buddha_belly_bamboo};
        ContentValues[] ans88 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans88[count] = new ContentValues();
            ans88[count].put(KEY_ANSWER, keyAns88[count]);
            ans88[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans88[count].put(KEY_RESOURCE,keyRes88[count]);
            ans88[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans88[count].put(KEY_QUESTION_ID, QUESTION_NO_1588);
            db.insert(TABLE_ANSWER, null, ans88[count]);
        }

        //ans-89
        int[] keyAns89 = {R.string.ans_type5_que89_1,R.string.ans_type5_que89_2,R.string.ans_type5_que89_3,R.string.ans_type5_que89_4};
        int[] keyRes89 = {R.drawable.trailing_geranium,R.drawable.cheatgrass,R.drawable.common_oat,R.drawable.tulip_tree};
        ContentValues[] ans89 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans89[count] = new ContentValues();
            ans89[count].put(KEY_ANSWER, keyAns89[count]);
            ans89[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans89[count].put(KEY_RESOURCE,keyRes89[count]);
            ans89[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans89[count].put(KEY_QUESTION_ID, QUESTION_NO_1589);
            db.insert(TABLE_ANSWER, null, ans89[count]);
        }

        //ans-90
        int[] keyAns90 = {R.string.ans_type5_que90_1,R.string.ans_type5_que90_2,R.string.ans_type5_que90_3,R.string.ans_type5_que90_4};
        int[] keyRes90 = {R.drawable.dwarf_reedgrass,R.drawable.flax,R.drawable.graceful_himalayan_iris,R.drawable.golden_bamboo};
        ContentValues[] ans90 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans90[count] = new ContentValues();
            ans90[count].put(KEY_ANSWER, keyAns90[count]);
            ans90[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans90[count].put(KEY_RESOURCE,keyRes90[count]);
            ans90[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans90[count].put(KEY_QUESTION_ID, QUESTION_NO_1590);
            db.insert(TABLE_ANSWER, null, ans90[count]);
        }

        //ans-91
        int[] keyAns91 = {R.string.ans_type5_que91_1,R.string.ans_type5_que91_2,R.string.ans_type5_que91_3,R.string.ans_type5_que91_4};
        int[] keyRes91 = {R.drawable.indian_thorny_bamboo,R.drawable.green_taro,R.drawable.mangrove_grass,R.drawable.five_leaf_yam};
        ContentValues[] ans91 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans91[count] = new ContentValues();
            ans91[count].put(KEY_ANSWER, keyAns91[count]);
            ans91[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans91[count].put(KEY_RESOURCE,keyRes91[count]);
            ans91[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans91[count].put(KEY_QUESTION_ID, QUESTION_NO_1591);
            db.insert(TABLE_ANSWER, null, ans91[count]);
        }

        //ans-92
        int[] keyAns92 = {R.string.ans_type5_que92_1,R.string.ans_type5_que92_2,R.string.ans_type5_que92_3,R.string.ans_type5_que92_4};
        int[] keyRes92 = {R.drawable.long_leaf_pondweed,R.drawable.mauritian_grass,R.drawable.wights_twisted_arum,R.drawable.nepal_foxtail_grass};
        ContentValues[] ans92 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans92[count] = new ContentValues();
            ans92[count].put(KEY_ANSWER, keyAns92[count]);
            ans92[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans92[count].put(KEY_RESOURCE,keyRes92[count]);
            ans92[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans92[count].put(KEY_QUESTION_ID, QUESTION_NO_1592);
            db.insert(TABLE_ANSWER, null, ans92[count]);
        }

        //ans-93
        int[] keyAns93 = {R.string.ans_type5_que93_1,R.string.ans_type5_que93_2,R.string.ans_type5_que93_3,R.string.ans_type5_que93_4};
        int[] keyRes93 = {R.drawable.rescue_grass,R.drawable.blue_vanda,R.drawable.chameleon_plant,R.drawable.summer_grass};
        ContentValues[] ans93 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans93[count] = new ContentValues();
            ans93[count].put(KEY_ANSWER, keyAns93[count]);
            ans93[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans93[count].put(KEY_RESOURCE,keyRes93[count]);
            ans93[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans93[count].put(KEY_QUESTION_ID, QUESTION_NO_1593);
            db.insert(TABLE_ANSWER, null, ans93[count]);
        }

        //ans-94
        int[] keyAns94 = {R.string.ans_type5_que94_1,R.string.ans_type5_que94_2,R.string.ans_type5_que94_3,R.string.ans_type5_que94_4};
        int[] keyRes94 = {R.drawable.dwarf_powder_puff,R.drawable.summer_grass,R.drawable.swollen_finger_grass,R.drawable.graceful_himalayan_iris};
        ContentValues[] ans94 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans94[count] = new ContentValues();
            ans94[count].put(KEY_ANSWER, keyAns94[count]);
            ans94[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans94[count].put(KEY_RESOURCE,keyRes94[count]);
            ans94[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans94[count].put(KEY_QUESTION_ID, QUESTION_NO_1594);
            db.insert(TABLE_ANSWER, null, ans94[count]);
        }

        //ans-95
        int[] keyAns95 = {R.string.ans_type5_que95_1,R.string.ans_type5_que95_2,R.string.ans_type5_que95_3,R.string.ans_type5_que95_4};
        int[] keyRes95 = {R.drawable.tausch_s_goat_grass,R.drawable.stepladder_ginger,R.drawable.yellow_bluestem_grass,R.drawable.himalayan_aster};
        ContentValues[] ans95 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans95[count] = new ContentValues();
            ans95[count].put(KEY_ANSWER, keyAns95[count]);
            ans95[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans95[count].put(KEY_RESOURCE,keyRes95[count]);
            ans95[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans95[count].put(KEY_QUESTION_ID, QUESTION_NO_1595);
            db.insert(TABLE_ANSWER, null, ans15[count]);
        }

        //ans-96
        int[] keyAns96 = {R.string.ans_type5_que96_1,R.string.ans_type5_que96_2,R.string.ans_type5_que96_3,R.string.ans_type5_que96_4};
        int[] keyRes96 = {R.drawable.chameleon_plant,R.drawable.elephant_foot_yam,R.drawable.grass_of_the_dew,R.drawable.himalaya_onion};
        ContentValues[] ans96 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans96[count] = new ContentValues();
            ans96[count].put(KEY_ANSWER, keyAns96[count]);
            ans96[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans96[count].put(KEY_RESOURCE,keyRes96[count]);
            ans96[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans96[count].put(KEY_QUESTION_ID, QUESTION_NO_1596);
            db.insert(TABLE_ANSWER, null, ans96[count]);
        }

        //ans-97
        int[] keyAns97 = {R.string.ans_type5_que97_1,R.string.ans_type5_que97_2,R.string.ans_type5_que97_3,R.string.ans_type5_que97_4};
        int[] keyRes97 = {R.drawable.rosy_orchid_ginger,R.drawable.soursop,R.drawable.south_indian_uvaria,R.drawable.wintersweet};
        ContentValues[] ans97 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans97[count] = new ContentValues();
            ans97[count].put(KEY_ANSWER, keyAns97[count]);
            ans97[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans97[count].put(KEY_RESOURCE,keyRes97[count]);
            ans97[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans97[count].put(KEY_QUESTION_ID, QUESTION_NO_1597);
            db.insert(TABLE_ANSWER, null, ans97[count]);
        }

        //ans-98
        int[] keyAns98 = {R.string.ans_type5_que98_1,R.string.ans_type5_que98_2,R.string.ans_type5_que98_3,R.string.ans_type5_que98_4};
        int[] keyRes98 = {R.drawable.red_vanda,R.drawable.wintersweet,R.drawable.five_leaf_yam,R.drawable.south_indian_uvaria};
        ContentValues[] ans98 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans98[count] = new ContentValues();
            ans98[count].put(KEY_ANSWER, keyAns98[count]);
            ans98[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans98[count].put(KEY_RESOURCE,keyRes98[count]);
            ans98[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans98[count].put(KEY_QUESTION_ID, QUESTION_NO_1598);
            db.insert(TABLE_ANSWER, null, ans98[count]);
        }

        //ans-99
        int[] keyAns99 = {R.string.ans_type5_que99_1,R.string.ans_type5_que99_2,R.string.ans_type5_que99_3,R.string.ans_type5_que99_4};
        int[] keyRes99 = {R.drawable.soursop,R.drawable.yellow_waterlily,R.drawable.rosy_orchid_ginger,R.drawable.tulip_tree};
        ContentValues[] ans99 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans99[count] = new ContentValues();
            ans99[count].put(KEY_ANSWER, keyAns99[count]);
            ans99[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans99[count].put(KEY_RESOURCE,keyRes99[count]);
            ans99[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans99[count].put(KEY_QUESTION_ID, QUESTION_NO_1599);
            db.insert(TABLE_ANSWER, null, ans99[count]);
        }

        //ans-100
        int[] keyAns100 = {R.string.ans_type5_que100_1,R.string.ans_type5_que100_2,R.string.ans_type5_que100_3,R.string.ans_type5_que100_4};
        int[] keyRes100 = {R.drawable.himalaya_onion,R.drawable.flax,R.drawable.graceful_himalayan_iris,R.drawable.grass_of_the_dew};
        ContentValues[] ans100 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans100[count] = new ContentValues();
            ans100[count].put(KEY_ANSWER, keyAns100[count]);
            ans100[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans100[count].put(KEY_RESOURCE,keyRes100[count]);
            ans100[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans100[count].put(KEY_QUESTION_ID, QUESTION_NO_1600);
            db.insert(TABLE_ANSWER, null, ans100[count]);
        }

        //ans-101
        int[] keyAns101 = {R.string.ans_type5_que101_1,R.string.ans_type5_que101_2,R.string.ans_type5_que101_3,R.string.ans_type5_que101_4};
        int[] keyRes101 = {R.drawable.elephant_foot_yam,R.drawable.hard_fruit_alphonsea,R.drawable.chameleon_plant,R.drawable.malabar_nutmeg};
        ContentValues[] ans101 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans101[count] = new ContentValues();
            ans101[count].put(KEY_ANSWER, keyAns101[count]);
            ans101[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans101[count].put(KEY_RESOURCE,keyRes101[count]);
            ans101[count].put(KEY_RESOURCE,keyRes101[count]);
            ans101[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans101[count].put(KEY_QUESTION_ID, QUESTION_NO_1601);
            db.insert(TABLE_ANSWER, null, ans101[count]);
        }

        //ans-102
        int[] keyAns102 = {R.string.ans_type5_que102_1,R.string.ans_type5_que102_2,R.string.ans_type5_que102_3,R.string.ans_type5_que102_4};
        int[] keyRes102 = {R.drawable.dusky_fire_brand_teak,R.drawable.hairy_root_luisia,R.drawable.hornbeam_leaved_crossberry,R.drawable.nilgiri_gastrochilus};
        ContentValues[] ans102 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans102[count] = new ContentValues();
            ans102[count].put(KEY_ANSWER, keyAns102[count]);
            ans102[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans102[count].put(KEY_RESOURCE,keyRes102[count]);
            ans102[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans102[count].put(KEY_QUESTION_ID, QUESTION_NO_1602);
            db.insert(TABLE_ANSWER, null, ans102[count]);
        }

        //ans-103
        int[] keyAns103 = {R.string.ans_type5_que103_1,R.string.ans_type5_que103_2,R.string.ans_type5_que103_3,R.string.ans_type5_que103_4};
        int[] keyRes103 = {R.drawable.schimpers_sida,R.drawable.spherical_rattlepod,R.drawable.strawberry_fields_gomphrena,R.drawable.campbell_s_magnolia};
        ContentValues[] ans103 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans103[count] = new ContentValues();
            ans103[count].put(KEY_ANSWER, keyAns103[count]);
            ans103[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans103[count].put(KEY_RESOURCE,keyRes103[count]);
            ans103[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans103[count].put(KEY_QUESTION_ID, QUESTION_NO_1603);
            db.insert(TABLE_ANSWER, null, ans103[count]);
        }

        //ans-104
        int[] keyAns104 = {R.string.ans_type5_que104_1,R.string.ans_type5_que104_2,R.string.ans_type5_que104_3,R.string.ans_type5_que104_4};
        int[] keyRes104 = {R.drawable.dusky_fire_brand_teak,R.drawable.golden_arch_dendrobium,R.drawable.hairy_root_luisia,R.drawable.malabar_nutmeg};
        ContentValues[] ans104 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans104[count] = new ContentValues();
            ans104[count].put(KEY_ANSWER, keyAns104[count]);
            ans104[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans104[count].put(KEY_RESOURCE,keyRes104[count]);
            ans104[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans104[count].put(KEY_QUESTION_ID, QUESTION_NO_1604);
            db.insert(TABLE_ANSWER, null, ans104[count]);
        }

        //ans-105
        int[] keyAns105 = {R.string.ans_type5_que105_1,R.string.ans_type5_que105_2,R.string.ans_type5_que105_3,R.string.ans_type5_que105_4};
        int[] keyRes105 = {R.drawable.hairy_root_luisia,R.drawable.hornbeam_leaved_crossberry,R.drawable.hugel_s_gentian,R.drawable.nilgiri_gastrochilus};
        ContentValues[] ans105 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans105[count] = new ContentValues();
            ans105[count].put(KEY_ANSWER, keyAns105[count]);
            ans105[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans105[count].put(KEY_RESOURCE,keyRes105[count]);
            ans105[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans105[count].put(KEY_QUESTION_ID, QUESTION_NO_1605);
            db.insert(TABLE_ANSWER, null, ans105[count]);
        }

        //ans-106
        int[] keyAns106 = {R.string.ans_type5_que106_1,R.string.ans_type5_que106_2,R.string.ans_type5_que106_3,R.string.ans_type5_que106_4};
        int[] keyRes106 = {R.drawable.kanpet,R.drawable.schimpers_sida,R.drawable.tulip_tree,R.drawable.spherical_rattlepod};
        ContentValues[] ans106 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans106[count] = new ContentValues();
            ans106[count].put(KEY_ANSWER, keyAns106[count]);
            ans106[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans106[count].put(KEY_RESOURCE,keyRes106[count]);
            ans106[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans106[count].put(KEY_QUESTION_ID, QUESTION_NO_1606);
            db.insert(TABLE_ANSWER, null, ans106[count]);
        }

        //ans-107
        int[] keyAns107 = {R.string.ans_type5_que107_1,R.string.ans_type5_que107_2,R.string.ans_type5_que107_3,R.string.ans_type5_que107_4};
        int[] keyRes107 = {R.drawable.hungarian_iris,R.drawable.strawberry_fields_gomphrena,R.drawable.mountain_hydrangea,R.drawable.hard_fruit_alphonsea};
        ContentValues[] ans107 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans107[count] = new ContentValues();
            ans107[count].put(KEY_ANSWER, keyAns107[count]);
            ans107[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans107[count].put(KEY_RESOURCE,keyRes107[count]);
            ans107[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans107[count].put(KEY_QUESTION_ID, QUESTION_NO_1607);
            db.insert(TABLE_ANSWER, null, ans107[count]);
        }

        //ans-108
        int[] keyAns108 = {R.string.ans_type5_que108_1,R.string.ans_type5_que108_2,R.string.ans_type5_que108_3,R.string.ans_type5_que108_4};
        int[] keyRes108 = {R.drawable.acampe_orchid,R.drawable.ascocenda_krailerk_alba,R.drawable.bamboo_orchid,R.drawable.curled_aerides};
        ContentValues[] ans108 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans108[count] = new ContentValues();
            ans108[count].put(KEY_ANSWER, keyAns108[count]);
            ans108[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans108[count].put(KEY_RESOURCE,keyRes108[count]);
            ans108[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans108[count].put(KEY_QUESTION_ID, QUESTION_NO_1608);
            db.insert(TABLE_ANSWER, null, ans108[count]);
        }

        //ans-109
        int[] keyAns109 = {R.string.ans_type5_que109_1,R.string.ans_type5_que109_2,R.string.ans_type5_que109_3,R.string.ans_type5_que109_4};
        int[] keyRes109 = {R.drawable.fox_brush_orchid,R.drawable.fringed_bulbophyllum,R.drawable.ochre_yellow_acampe,R.drawable.small_warty_acampe};
        ContentValues[] ans109 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans109[count] = new ContentValues();
            ans109[count].put(KEY_ANSWER, keyAns109[count]);
            ans109[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans109[count].put(KEY_RESOURCE,keyRes109[count]);
            ans109[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans109[count].put(KEY_QUESTION_ID, QUESTION_NO_1609);
            db.insert(TABLE_ANSWER, null, ans109[count]);
        }

        //ans-110
        int[] keyAns110 = {R.string.ans_type5_que110_1,R.string.ans_type5_que110_2,R.string.ans_type5_que110_3,R.string.ans_type5_que110_4};
        int[] keyRes110 = {R.drawable.acampe_orchid,R.drawable.bitter_nutmeg,R.drawable.graceful_himalayan_iris,R.drawable.ascocenda_krailerk_alba};
        ContentValues[] ans110 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans110[count] = new ContentValues();
            ans110[count].put(KEY_ANSWER, keyAns110[count]);
            ans110[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans110[count].put(KEY_RESOURCE,keyRes110[count]);
            ans110[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans110[count].put(KEY_QUESTION_ID, QUESTION_NO_1610);
            db.insert(TABLE_ANSWER, null, ans110[count]);
        }

        //ans-111
        int[] keyAns111 = {R.string.ans_type5_que111_1,R.string.ans_type5_que111_2,R.string.ans_type5_que111_3,R.string.ans_type5_que111_4};
        int[] keyRes111 = {R.drawable.angelwing_jasmine,R.drawable.bamboo_orchid,R.drawable.curled_aerides,R.drawable.common_white_frangipani};
        ContentValues[] ans111 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans111[count] = new ContentValues();
            ans111[count].put(KEY_ANSWER, keyAns111[count]);
            ans111[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans111[count].put(KEY_RESOURCE,keyRes111[count]);
            ans111[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans111[count].put(KEY_QUESTION_ID, QUESTION_NO_1611);
            db.insert(TABLE_ANSWER, null, ans111[count]);
        }

        //ans-112
        int[] keyAns112 = {R.string.ans_type5_que112_1,R.string.ans_type5_que112_2,R.string.ans_type5_que112_3,R.string.ans_type5_que112_4};
        int[] keyRes112 = {R.drawable.fox_brush_orchid,R.drawable.hari_champa,R.drawable.fringed_bulbophyllum,R.drawable.magnolia};
        ContentValues[] ans112 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans112[count] = new ContentValues();
            ans112[count].put(KEY_ANSWER, keyAns112[count]);
            ans112[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans112[count].put(KEY_RESOURCE,keyRes112[count]);
            ans112[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans112[count].put(KEY_QUESTION_ID, QUESTION_NO_1612);
            db.insert(TABLE_ANSWER, null, ans112[count]);
        }

        //ans-113
        int[] keyAns113 = {R.string.ans_type5_que113_1,R.string.ans_type5_que113_2,R.string.ans_type5_que113_3,R.string.ans_type5_que113_4};
        int[] keyRes113 = {R.drawable.potato_vine,R.drawable.ochre_yellow_acampe,R.drawable.ylang_ylang,R.drawable.small_warty_acampe};
        ContentValues[] ans113 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans113[count] = new ContentValues();
            ans113[count].put(KEY_ANSWER, keyAns113[count]);
            ans113[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans113[count].put(KEY_RESOURCE,keyRes113[count]);
            ans113[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans113[count].put(KEY_QUESTION_ID, QUESTION_NO_1613);
            db.insert(TABLE_ANSWER, null, ans113[count]);
        }

        //ans-114
        int[] keyAns114 = {R.string.ans_type5_que114_1,R.string.ans_type5_que114_2,R.string.ans_type5_que114_3,R.string.ans_type5_que114_4};
        int[] keyRes114 = {R.drawable.corn_cockle,R.drawable.grape_leaf_wood_rose,R.drawable.nilofar,R.drawable.peach_angel_s_trumpet};
        ContentValues[] ans114 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans114[count] = new ContentValues();
            ans114[count].put(KEY_ANSWER, keyAns114[count]);
            ans114[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans114[count].put(KEY_RESOURCE,keyRes114[count]);
            ans114[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans114[count].put(KEY_QUESTION_ID, QUESTION_NO_1614);
            db.insert(TABLE_ANSWER, null, ans114[count]);
        }

        //ans-115
        int[] keyAns115 = {R.string.ans_type5_que115_1,R.string.ans_type5_que115_2,R.string.ans_type5_que115_3,R.string.ans_type5_que115_4};
        int[] keyRes115 = {R.drawable.prickly_waterlily,R.drawable.purple_heart_glory,R.drawable.railway_creeper,R.drawable.water_morning_glory};
        ContentValues[] ans115 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans115[count] = new ContentValues();
            ans115[count].put(KEY_ANSWER, keyAns115[count]);
            ans115[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans115[count].put(KEY_RESOURCE,keyRes115[count]);
            ans115[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans115[count].put(KEY_QUESTION_ID, QUESTION_NO_1615);
            db.insert(TABLE_ANSWER, null, ans115[count]);
        }

        //ans-116
        int[] keyAns116 = {R.string.ans_type5_que116_1,R.string.ans_type5_que116_2,R.string.ans_type5_que116_3,R.string.ans_type5_que116_4};
        int[] keyRes116 = {R.drawable.yellow_pond_lily,R.drawable.yellow_waterlily,R.drawable.wild_daffodil,R.drawable.common_white_frangipani};
        ContentValues[] ans116 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans116[count] = new ContentValues();
            ans116[count].put(KEY_ANSWER, keyAns116[count]);
            ans116[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans116[count].put(KEY_RESOURCE,keyRes116[count]);
            ans116[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans116[count].put(KEY_QUESTION_ID, QUESTION_NO_1616);
            db.insert(TABLE_ANSWER, null, ans116[count]);
        }

        //ans-117
        int[] keyAns117 = {R.string.ans_type5_que117_1,R.string.ans_type5_que117_2,R.string.ans_type5_que117_3,R.string.ans_type5_que117_4};
        int[] keyRes117 = {R.drawable.corn_cockle,R.drawable.magnolia,R.drawable.grape_leaf_wood_rose,R.drawable.peruvian_lily};
        ContentValues[] ans117 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans117[count] = new ContentValues();
            ans117[count].put(KEY_ANSWER, keyAns117[count]);
            ans117[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans117[count].put(KEY_RESOURCE,keyRes117[count]);
            ans117[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans117[count].put(KEY_QUESTION_ID, QUESTION_NO_1617);
            db.insert(TABLE_ANSWER, null, ans117[count]);
        }

        //ans-118
        int[] keyAns118 = {R.string.ans_type5_que118_1,R.string.ans_type5_que118_2,R.string.ans_type5_que118_3,R.string.ans_type5_que118_4};
        int[] keyRes118 = {R.drawable.red_vanda,R.drawable.nilofar,R.drawable.japanese_honeysuckle,R.drawable.peach_angel_s_trumpet};
        ContentValues[] ans118 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans118[count] = new ContentValues();
            ans118[count].put(KEY_ANSWER, keyAns118[count]);
            ans118[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans118[count].put(KEY_RESOURCE,keyRes118[count]);
            ans118[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans118[count].put(KEY_QUESTION_ID, QUESTION_NO_1618);
            db.insert(TABLE_ANSWER, null, ans118[count]);
        }

        //ans-119
        int[] keyAns119 = {R.string.ans_type5_que119_1,R.string.ans_type5_que119_2,R.string.ans_type5_que119_3,R.string.ans_type5_que119_4};
        int[] keyRes119 = {R.drawable.trailing_geranium,R.drawable.prickly_waterlily,R.drawable.purple_heart_glory,R.drawable.ylang_ylang};
        ContentValues[] ans119 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans119[count] = new ContentValues();
            ans119[count].put(KEY_ANSWER, keyAns119[count]);
            ans119[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans119[count].put(KEY_RESOURCE,keyRes119[count]);
            ans119[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans119[count].put(KEY_QUESTION_ID, QUESTION_NO_1619);
            db.insert(TABLE_ANSWER, null, ans119[count]);
        }

        //ans-120
        int[] keyAns120 = {R.string.ans_type5_que120_1,R.string.ans_type5_que120_2,R.string.ans_type5_que120_3,R.string.ans_type5_que120_4};
        int[] keyRes120 = {R.drawable.railway_creeper,R.drawable.flax,R.drawable.hari_champa,R.drawable.water_morning_glory};
        ContentValues[] ans120 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans120[count] = new ContentValues();
            ans120[count].put(KEY_ANSWER, keyAns120[count]);
            ans120[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans120[count].put(KEY_RESOURCE,keyRes120[count]);
            ans120[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans120[count].put(KEY_QUESTION_ID, QUESTION_NO_1620);
            db.insert(TABLE_ANSWER, null, ans120[count]);
        }

        //ans-121
        int[] keyAns121 = {R.string.ans_type5_que121_1,R.string.ans_type5_que121_2,R.string.ans_type5_que121_3,R.string.ans_type5_que121_4};
        int[] keyRes121 = {R.drawable.calico_flower,R.drawable.yellow_pond_lily,R.drawable.gloxinia,R.drawable.har_singar};
        ContentValues[] ans121 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans121[count] = new ContentValues();
            ans121[count].put(KEY_ANSWER, keyAns121[count]);
            ans121[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans121[count].put(KEY_RESOURCE,keyRes121[count]);
            ans121[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans121[count].put(KEY_QUESTION_ID, QUESTION_NO_1621);
            db.insert(TABLE_ANSWER, null, ans121[count]);
        }

        //ans-122
        int[] keyAns122 = {R.string.ans_type5_que122_1,R.string.ans_type5_que122_2,R.string.ans_type5_que122_3,R.string.ans_type5_que122_4};
        int[] keyRes122 = {R.drawable.yellow_waterlily,R.drawable.lily_magnolia,R.drawable.marigold_yellow,R.drawable.mexican_oleander};
        ContentValues[] ans122 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans122[count] = new ContentValues();
            ans122[count].put(KEY_ANSWER, keyAns122[count]);
            ans122[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans122[count].put(KEY_RESOURCE,keyRes122[count]);
            ans122[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans122[count].put(KEY_QUESTION_ID, QUESTION_NO_1622);
            db.insert(TABLE_ANSWER, null, ans122[count]);
        }

        //ans-123
        int[] keyAns123 = {R.string.ans_type5_que123_1,R.string.ans_type5_que123_2,R.string.ans_type5_que123_3,R.string.ans_type5_que123_4};
        int[] keyRes123 = {R.drawable.banana_passion_flower,R.drawable.candy_corn_plant,R.drawable.glory_lily,R.drawable.helmet_pepper};
        ContentValues[] ans123 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans123[count] = new ContentValues();
            ans123[count].put(KEY_ANSWER, keyAns123[count]);
            ans123[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans123[count].put(KEY_RESOURCE,keyRes123[count]);
            ans123[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans123[count].put(KEY_QUESTION_ID, QUESTION_NO_1623);
            db.insert(TABLE_ANSWER, null, ans123[count]);
        }

        //ans-124
        int[] keyAns124 = {R.string.ans_type5_que124_1,R.string.ans_type5_que124_2,R.string.ans_type5_que124_3,R.string.ans_type5_que124_4};
        int[] keyRes124 = {R.drawable.love_in_a_mist,R.drawable.maloo_creeper,R.drawable.puncture_vine,R.drawable.purple_passion_flower};
        ContentValues[] ans124 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans124[count] = new ContentValues();
            ans124[count].put(KEY_ANSWER, keyAns124[count]);
            ans124[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans124[count].put(KEY_RESOURCE,keyRes124[count]);
            ans124[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans124[count].put(KEY_QUESTION_ID, QUESTION_NO_1624);
            db.insert(TABLE_ANSWER, null, ans124[count]);
        }

        //ans-125
        int[] keyAns125 = {R.string.ans_type5_que125_1,R.string.ans_type5_que125_2,R.string.ans_type5_que125_3,R.string.ans_type5_que125_4};
        int[] keyRes125 = {R.drawable.calico_flower,R.drawable.hungarian_black_chilli,R.drawable.spurred_butterfly_pea,R.drawable.ragi};
        ContentValues[] ans125 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans125[count] = new ContentValues();
            ans125[count].put(KEY_ANSWER, keyAns125[count]);
            ans125[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans125[count].put(KEY_RESOURCE,keyRes125[count]);
            ans125[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans125[count].put(KEY_QUESTION_ID, QUESTION_NO_1625);
            db.insert(TABLE_ANSWER, null, ans125[count]);
        }

        //ans-126
        int[] keyAns126 = {R.string.ans_type5_que126_1,R.string.ans_type5_que126_2,R.string.ans_type5_que126_3,R.string.ans_type5_que126_4};
        int[] keyRes126 = {R.drawable.kanpet,R.drawable.banana_passion_flower,R.drawable.long_flower_barleria,R.drawable.candy_corn_plant};
        ContentValues[] ans126 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans126[count] = new ContentValues();
            ans126[count].put(KEY_ANSWER, keyAns126[count]);
            ans126[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans126[count].put(KEY_RESOURCE,keyRes126[count]);
            ans126[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans126[count].put(KEY_QUESTION_ID, QUESTION_NO_1626);
            db.insert(TABLE_ANSWER, null, ans126[count]);
        }

        //ans-127
        int[] keyAns127 = {R.string.ans_type5_que127_1,R.string.ans_type5_que127_2,R.string.ans_type5_que127_3,R.string.ans_type5_que127_4};
        int[] keyRes127 = {R.drawable.glory_lily,R.drawable.mountain_rose,R.drawable.helmet_pepper,R.drawable.peruvian_lily};
        ContentValues[] ans127 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans127[count] = new ContentValues();
            ans127[count].put(KEY_ANSWER, keyAns127[count]);
            ans127[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans127[count].put(KEY_RESOURCE,keyRes127[count]);
            ans127[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans127[count].put(KEY_QUESTION_ID, QUESTION_NO_1627);
            db.insert(TABLE_ANSWER, null, ans127[count]);
        }

        //ans-128
        int[] keyAns128 = {R.string.ans_type5_que128_1,R.string.ans_type5_que128_2,R.string.ans_type5_que128_3,R.string.ans_type5_que128_4};
        int[] keyRes128 = {R.drawable.love_in_a_mist,R.drawable.marigold_yellow,R.drawable.red_water_lily,R.drawable.maloo_creeper};
        ContentValues[] ans128 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans128[count] = new ContentValues();
            ans128[count].put(KEY_ANSWER, keyAns128[count]);
            ans128[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans128[count].put(KEY_RESOURCE,keyRes128[count]);
            ans128[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans128[count].put(KEY_QUESTION_ID, QUESTION_NO_1628);
            db.insert(TABLE_ANSWER, null, ans128[count]);
        }

        //ans-129
        int[] keyAns129 = {R.string.ans_type5_que129_1,R.string.ans_type5_que129_2,R.string.ans_type5_que129_3,R.string.ans_type5_que129_4};
        int[] keyRes129 = {R.drawable.nilofar,R.drawable.puncture_vine,R.drawable.purple_passion_flower,R.drawable.tulip_tree};
        ContentValues[] ans129 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans129[count] = new ContentValues();
            ans129[count].put(KEY_ANSWER, keyAns129[count]);
            ans129[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans129[count].put(KEY_RESOURCE,keyRes129[count]);
            ans129[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans129[count].put(KEY_QUESTION_ID, QUESTION_NO_1629);
            db.insert(TABLE_ANSWER, null, ans129[count]);
        }

        //ans-130
        int[] keyAns130 = {R.string.ans_type5_que130_1,R.string.ans_type5_que130_2,R.string.ans_type5_que130_3,R.string.ans_type5_que130_4};
        int[] keyRes130 = {R.drawable.ragi,R.drawable.striped_philippine_violet,R.drawable.graceful_himalayan_iris,R.drawable.spurred_butterfly_pea};
        ContentValues[] ans130 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans130[count] = new ContentValues();
            ans130[count].put(KEY_ANSWER, keyAns130[count]);
            ans130[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans130[count].put(KEY_RESOURCE,keyRes130[count]);
            ans130[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans130[count].put(KEY_QUESTION_ID, QUESTION_NO_1630);
            db.insert(TABLE_ANSWER, null, ans130[count]);
        }

        //ans-131
        int[] keyAns131 = {R.string.ans_type5_que131_1,R.string.ans_type5_que131_2,R.string.ans_type5_que131_3,R.string.ans_type5_que131_4};
        int[] keyRes131 = {R.drawable.bee_orchid,R.drawable.green_taro,R.drawable.yellow_pond_lily,R.drawable.blue_feltwort};
        ContentValues[] ans131 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans131[count] = new ContentValues();
            ans131[count].put(KEY_ANSWER, keyAns131[count]);
            ans131[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans131[count].put(KEY_RESOURCE,keyRes131[count]);
            ans131[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans131[count].put(KEY_QUESTION_ID, QUESTION_NO_1631);
            db.insert(TABLE_ANSWER, null, ans131[count]);
        }

        //ans-132
        int[] keyAns132 = {R.string.ans_type5_que132_1,R.string.ans_type5_que132_2,R.string.ans_type5_que132_3,R.string.ans_type5_que132_4};
        int[] keyRes132 = {R.drawable.blue_vanda,R.drawable.devil_s_tongue,R.drawable.chilean_bell_flower,R.drawable.fragrant_yellow_geranium};
        ContentValues[] ans132 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans132[count] = new ContentValues();
            ans132[count].put(KEY_ANSWER, keyAns132[count]);
            ans132[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans132[count].put(KEY_RESOURCE,keyRes132[count]);
            ans132[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans132[count].put(KEY_QUESTION_ID, QUESTION_NO_1632);
            db.insert(TABLE_ANSWER, null, ans132[count]);
        }

        //ans-133
        int[] keyAns133 = {R.string.ans_type5_que133_1,R.string.ans_type5_que133_2,R.string.ans_type5_que133_3,R.string.ans_type5_que133_4};
        int[] keyRes133 = {R.drawable.himalayan_melastome,R.drawable.dwarf_powder_puff,R.drawable.fringed_iris,R.drawable.small_flowered_willow_herb};
        ContentValues[] ans133 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans133[count] = new ContentValues();
            ans133[count].put(KEY_ANSWER, keyAns133[count]);
            ans133[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans133[count].put(KEY_RESOURCE,keyRes133[count]);
            ans133[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans133[count].put(KEY_QUESTION_ID, QUESTION_NO_1633);
            db.insert(TABLE_ANSWER, null, ans133[count]);
        }

        //ans-134
        int[] keyAns134 = {R.string.ans_type5_que134_1,R.string.ans_type5_que134_2,R.string.ans_type5_que134_3,R.string.ans_type5_que134_4};
        int[] keyRes134 = {R.drawable.thread_leaved_water_crowfoot,R.drawable.himalayan_aster,R.drawable.wallich_geranium,R.drawable.hungarian_iris};
        ContentValues[] ans134 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans134[count] = new ContentValues();
            ans134[count].put(KEY_ANSWER, keyAns134[count]);
            ans134[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans134[count].put(KEY_RESOURCE,keyRes134[count]);
            ans134[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans134[count].put(KEY_QUESTION_ID, QUESTION_NO_1634);
            db.insert(TABLE_ANSWER, null, ans134[count]);
        }

        //ans-135
        int[] keyAns135 = {R.string.ans_type5_que135_1,R.string.ans_type5_que135_2,R.string.ans_type5_que135_3,R.string.ans_type5_que135_4};
        int[] keyRes135 = {R.drawable.peruvian_lily,R.drawable.stepladder_ginger,R.drawable.long_flowered_spider_lily,R.drawable.river_anemone};
        ContentValues[] ans135 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans135[count] = new ContentValues();
            ans135[count].put(KEY_ANSWER, keyAns135[count]);
            ans135[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans135[count].put(KEY_RESOURCE,keyRes135[count]);
            ans135[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans135[count].put(KEY_QUESTION_ID, QUESTION_NO_1635);
            db.insert(TABLE_ANSWER, null, ans135[count]);
        }

        //ans-136
        int[] keyAns136 = {R.string.ans_type5_que136_1,R.string.ans_type5_que136_2,R.string.ans_type5_que16_3,R.string.ans_type5_que136_4};
        int[] keyRes136 = {R.drawable.queen_crape_myrtle,R.drawable.egg_magnolia,R.drawable.wild_daffodil,R.drawable.long_leaf_pondweed};
        ContentValues[] ans136 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans136[count] = new ContentValues();
            ans136[count].put(KEY_ANSWER, keyAns136[count]);
            ans136[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans136[count].put(KEY_RESOURCE,keyRes136[count]);
            ans136[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans136[count].put(KEY_QUESTION_ID, QUESTION_NO_1636);
            db.insert(TABLE_ANSWER, null, ans136[count]);
        }

        //ans-137
        int[] keyAns137 = {R.string.ans_type5_que137_1,R.string.ans_type5_que137_2,R.string.ans_type5_que137_3,R.string.ans_type5_que137_4};
        int[] keyRes137 = {R.drawable.five_leaf_yam,R.drawable.peace_lily,R.drawable.himalayan_peony,R.drawable.long_flowered_spider_lily};
        ContentValues[] ans137 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans137[count] = new ContentValues();
            ans137[count].put(KEY_ANSWER, keyAns137[count]);
            ans137[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans137[count].put(KEY_RESOURCE,keyRes137[count]);
            ans137[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans137[count].put(KEY_QUESTION_ID, QUESTION_NO_1637);
            db.insert(TABLE_ANSWER, null, ans137[count]);
        }

        //ans-138
        int[] keyAns138 = {R.string.ans_type5_que138_1,R.string.ans_type5_que138_2,R.string.ans_type5_que138_3,R.string.ans_type5_que138_4};
        int[] keyRes138 = {R.drawable.red_vanda,R.drawable.peace_lily,R.drawable.five_leaf_yam,R.drawable.wild_daffodil};
        ContentValues[] ans138 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans138[count] = new ContentValues();
            ans138[count].put(KEY_ANSWER, keyAns138[count]);
            ans138[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans138[count].put(KEY_RESOURCE,keyRes138[count]);
            ans138[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans138[count].put(KEY_QUESTION_ID, QUESTION_NO_1638);
            db.insert(TABLE_ANSWER, null, ans138[count]);
        }

        //ans-139
        int[] keyAns139 = {R.string.ans_type5_que139_1,R.string.ans_type5_que139_2,R.string.ans_type5_que139_3,R.string.ans_type5_que139_4};
        int[] keyRes139 = {R.drawable.bitter_nutmeg,R.drawable.yellow_waterlily,R.drawable.hard_fruit_alphonsea,R.drawable.tibetan_willow_herb};
        ContentValues[] ans139 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans139[count] = new ContentValues();
            ans139[count].put(KEY_ANSWER, keyAns139[count]);
            ans139[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans139[count].put(KEY_RESOURCE,keyRes139[count]);
            ans139[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans139[count].put(KEY_QUESTION_ID, QUESTION_NO_1639);
            db.insert(TABLE_ANSWER, null, ans139[count]);
        }

        //ans-140
        int[] keyAns140 = {R.string.ans_type5_que140_1,R.string.ans_type5_que140_2,R.string.ans_type5_que140_3,R.string.ans_type5_que140_4};
        int[] keyRes140 = {R.drawable.shoofly_plant,R.drawable.champa,R.drawable.graceful_himalayan_iris,R.drawable.magnolia};
        ContentValues[] ans140 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans140[count] = new ContentValues();
            ans140[count].put(KEY_ANSWER, keyAns140[count]);
            ans140[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans140[count].put(KEY_RESOURCE,keyRes140[count]);
            ans140[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans140[count].put(KEY_QUESTION_ID, QUESTION_NO_1640);
            db.insert(TABLE_ANSWER, null, ans140[count]);
        }

        //ans-141
        int[] keyAns141 = {R.string.ans_type5_que141_1,R.string.ans_type5_que141_2,R.string.ans_type5_que141_3,R.string.ans_type5_que141_4};
        int[] keyRes141 = {R.drawable.aloe_vera,R.drawable.hari_champa,R.drawable.ylang_ylang,R.drawable.century_plant};
        ContentValues[] ans141 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans141[count] = new ContentValues();
            ans141[count].put(KEY_ANSWER, keyAns141[count]);
            ans141[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans141[count].put(KEY_RESOURCE,keyRes141[count]);
            ans141[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans141[count].put(KEY_QUESTION_ID, QUESTION_NO_1641);
            db.insert(TABLE_ANSWER, null, ans141[count]);
        }

        //ans-142
        int[] keyAns142 = {R.string.ans_type5_que142_1,R.string.ans_type5_que142_2,R.string.ans_type5_que142_3,R.string.ans_type5_que142_4};
        int[] keyRes142 = {R.drawable.calico_flower,R.drawable.delta_shaped_aloe,R.drawable.foolproof_plant,R.drawable.gloxinia};
        ContentValues[] ans142 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans142[count] = new ContentValues();
            ans142[count].put(KEY_ANSWER, keyAns142[count]);
            ans142[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans142[count].put(KEY_RESOURCE,keyRes142[count]);
            ans142[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans142[count].put(KEY_QUESTION_ID, QUESTION_NO_1642);
            db.insert(TABLE_ANSWER, null, ans142[count]);
        }

        //ans-143
        int[] keyAns143 = {R.string.ans_type5_que143_1,R.string.ans_type5_que143_2,R.string.ans_type5_que143_3,R.string.ans_type5_que143_4};
        int[] keyRes143 = {R.drawable.hawaiian_ti_plant,R.drawable.large_yellow_foxglove,R.drawable.marigold_yellow,R.drawable.marsh_dewflower};
        ContentValues[] ans143 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans143[count] = new ContentValues();
            ans143[count].put(KEY_ANSWER, keyAns143[count]);
            ans143[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans143[count].put(KEY_RESOURCE,keyRes143[count]);
            ans143[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans143[count].put(KEY_QUESTION_ID, QUESTION_NO_1643);
            db.insert(TABLE_ANSWER, null, ans143[count]);
        }

        //ans-144
        int[] keyAns144 = {R.string.ans_type5_que144_1,R.string.ans_type5_que144_2,R.string.ans_type5_que144_3,R.string.ans_type5_que144_4};
        int[] keyRes144 = {R.drawable.silver_leaved_earth_star,R.drawable.nilofar,R.drawable.snake_plant,R.drawable.sunset_bells};
        ContentValues[] ans144 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans144[count] = new ContentValues();
            ans144[count].put(KEY_ANSWER, keyAns144[count]);
            ans144[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans144[count].put(KEY_RESOURCE,keyRes144[count]);
            ans144[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans144[count].put(KEY_QUESTION_ID, QUESTION_NO_1644);
            db.insert(TABLE_ANSWER, null, ans144[count]);
        }

        //ans-145
        int[] keyAns145 = {R.string.ans_type5_que145_1,R.string.ans_type5_que145_2,R.string.ans_type5_que145_3,R.string.ans_type5_que145_4};
        int[] keyRes145 = {R.drawable.egg_magnolia,R.drawable.spider_aloe,R.drawable.himalayan_melastome,R.drawable.trifid_sedum};
        ContentValues[] ans145 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans145[count] = new ContentValues();
            ans145[count].put(KEY_ANSWER, keyAns145[count]);
            ans145[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans145[count].put(KEY_RESOURCE,keyRes145[count]);
            ans145[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans145[count].put(KEY_QUESTION_ID, QUESTION_NO_1645);
            db.insert(TABLE_ANSWER, null, ans145[count]);
        }

        //ans-146
        int[] keyAns146 = {R.string.ans_type5_que146_1,R.string.ans_type5_que146_2,R.string.ans_type5_que146_3,R.string.ans_type5_que146_4};
        int[] keyRes146 = {R.drawable.aloe_vera,R.drawable.mountain_rose,R.drawable.tulip_tree,R.drawable.tibetan_willow_herb};
        ContentValues[] ans146 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans146[count] = new ContentValues();
            ans146[count].put(KEY_ANSWER, keyAns146[count]);
            ans146[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans146[count].put(KEY_RESOURCE,keyRes146[count]);
            ans146[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans146[count].put(KEY_QUESTION_ID, QUESTION_NO_1646);
            db.insert(TABLE_ANSWER, null, ans146[count]);
        }

        //ans-147
        int[] keyAns147 = {R.string.ans_type5_que147_1,R.string.ans_type5_que147_2,R.string.ans_type5_que147_3,R.string.ans_type5_que147_4};
        int[] keyRes147 = {R.drawable.hungarian_iris,R.drawable.creeping_cradle_plant,R.drawable.silver_vase_bromeliad,R.drawable.century_plant};
        ContentValues[] ans147 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans147[count] = new ContentValues();
            ans147[count].put(KEY_ANSWER, keyAns147[count]);
            ans147[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans147[count].put(KEY_RESOURCE,keyRes147[count]);
            ans147[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans147[count].put(KEY_QUESTION_ID, QUESTION_NO_1647);
            db.insert(TABLE_ANSWER, null, ans147[count]);
        }

        //ans-148
        int[] keyAns148 = {R.string.ans_type5_que148_1,R.string.ans_type5_que148_2,R.string.ans_type5_que148_3,R.string.ans_type5_que148_4};
        int[] keyRes148 = {R.drawable.shoofly_plant,R.drawable.indian_oreorchis,R.drawable.delta_shaped_aloe,R.drawable.princess_flower};
        ContentValues[] ans148 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans148[count] = new ContentValues();
            ans148[count].put(KEY_ANSWER, keyAns148[count]);
            ans148[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans148[count].put(KEY_RESOURCE,keyRes148[count]);
            ans148[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans148[count].put(KEY_QUESTION_ID, QUESTION_NO_1648);
            db.insert(TABLE_ANSWER, null, ans148[count]);
        }

        //ans-149
        int[] keyAns149 = {R.string.ans_type5_que149_1,R.string.ans_type5_que149_2,R.string.ans_type5_que149_3,R.string.ans_type5_que149_4};
        int[] keyRes149 = {R.drawable.trifid_sedum,R.drawable.river_anemone,R.drawable.trailing_geranium,R.drawable.kut};
        ContentValues[] ans149 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans149[count] = new ContentValues();
            ans149[count].put(KEY_ANSWER, keyAns149[count]);
            ans149[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans149[count].put(KEY_RESOURCE,keyRes149[count]);
            ans149[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans149[count].put(KEY_QUESTION_ID, QUESTION_NO_1649);
            db.insert(TABLE_ANSWER, null, ans149[count]);
        }

        //ans-150
        int[] keyAns150 = {R.string.ans_type5_que150_1,R.string.ans_type5_que150_2,R.string.ans_type5_que150_3,R.string.ans_type5_que150_4};
        int[] keyRes150 = {R.drawable.barley_brome,R.drawable.bitter_nutmeg,R.drawable.jade_plant,R.drawable.cheatgrass};
        ContentValues[] ans150 = new ContentValues[4];
        for (int count = 0; count < 4; count++) {
            ans150[count] = new ContentValues();
            ans150[count].put(KEY_ANSWER, keyAns150[count]);
            ans150[count].put(KEY_TYPE, Utils.TYPE_IMAGE);
            ans150[count].put(KEY_RESOURCE,keyRes150[count]);
            ans150[count].put(KEY_IS_CORRECT, Utils.CORRECT);
            ans150[count].put(KEY_QUESTION_ID, QUESTION_NO_1650);
            db.insert(TABLE_ANSWER, null, ans150[count]);
        }
    }


    private void insertAnsType6(SQLiteDatabase db){
        final int QUESTION_NO_2001 = 2001;
        final int QUESTION_NO_2002 = 2002;
        final int QUESTION_NO_2003 = 2003;
        final int QUESTION_NO_2004 = 2004;
        final int QUESTION_NO_2005 = 2005;
        final int QUESTION_NO_2006 = 2006;
        final int QUESTION_NO_2007 = 2007;
        final int QUESTION_NO_2008 = 2008;
        final int QUESTION_NO_2009 = 2009;
        final int QUESTION_NO_2010 = 2010;
        final int QUESTION_NO_2011 = 2011;
        final int QUESTION_NO_2012 = 2012;
        final int QUESTION_NO_2013 = 2013;
        final int QUESTION_NO_2014 = 2014;
        final int QUESTION_NO_2015 = 2015;
        final int QUESTION_NO_2016 = 2016;
        final int QUESTION_NO_2017 = 2017;
        final int QUESTION_NO_2018 = 2018;
        final int QUESTION_NO_2019 = 2019;
        final int QUESTION_NO_2020 = 2020;
        final int QUESTION_NO_2021 = 2021;
        final int QUESTION_NO_2022 = 2022;
        final int QUESTION_NO_2023 = 2023;
        final int QUESTION_NO_2024 = 2024;
        final int QUESTION_NO_2025 = 2025;
        final int QUESTION_NO_2026 = 2026;
        final int QUESTION_NO_2027 = 2027;
        final int QUESTION_NO_2028 = 2028;
        final int QUESTION_NO_2029 = 2029;
        final int QUESTION_NO_2030 = 2030;
        final int QUESTION_NO_2031 = 2031;
        final int QUESTION_NO_2032 = 2032;
        final int QUESTION_NO_2033 = 2033;
        final int QUESTION_NO_2034 = 2034;
        final int QUESTION_NO_2035 = 2035;
        final int QUESTION_NO_2036 = 2036;
        final int QUESTION_NO_2037 = 2037;
        final int QUESTION_NO_2038 = 2038;
        final int QUESTION_NO_2039 = 2039;
        final int QUESTION_NO_2040 = 2040;
        final int QUESTION_NO_2041 = 2041;
        final int QUESTION_NO_2042 = 2042;
        final int QUESTION_NO_2043 = 2043;
        final int QUESTION_NO_2044 = 2044;
        final int QUESTION_NO_2045 = 2045;
        final int QUESTION_NO_2046 = 2046;
        final int QUESTION_NO_2047 = 2047;
        final int QUESTION_NO_2048 = 2048;
        final int QUESTION_NO_2049 = 2049;
        final int QUESTION_NO_2050 = 2050;
        final int QUESTION_NO_2051 = 2061;
        final int QUESTION_NO_2052 = 2052;
        final int QUESTION_NO_2053 = 2053;
        final int QUESTION_NO_2054 = 2054;
        final int QUESTION_NO_2055 = 2055;
        final int QUESTION_NO_2056 = 2056;
        final int QUESTION_NO_2057 = 2057;
        final int QUESTION_NO_2058 = 2058;
        final int QUESTION_NO_2059 = 2059;
        final int QUESTION_NO_2060 = 2060;
        final int QUESTION_NO_2061 = 2061;
        final int QUESTION_NO_2062 = 2062;
        final int QUESTION_NO_2063 = 2063;
        final int QUESTION_NO_2064 = 2064;
        final int QUESTION_NO_2065 = 2065;
        final int QUESTION_NO_2066 = 2066;
        final int QUESTION_NO_2067 = 2067;
        final int QUESTION_NO_2068 = 2068;
        final int QUESTION_NO_2069 = 2069;
        final int QUESTION_NO_2070 = 2070;
        final int QUESTION_NO_2071 = 2071;
        final int QUESTION_NO_2072 = 2072;
        final int QUESTION_NO_2073 = 2073;
        final int QUESTION_NO_2074 = 2074;
        final int QUESTION_NO_2075 = 2075;
        final int QUESTION_NO_2076 = 2076;
        final int QUESTION_NO_2077 = 2077;
        final int QUESTION_NO_2078 = 2078;
        final int QUESTION_NO_2079 = 2079;
        final int QUESTION_NO_2080 = 2080;
        final int QUESTION_NO_2081 = 2081;
        final int QUESTION_NO_2082 = 2082;
        final int QUESTION_NO_2083 = 2083;
        final int QUESTION_NO_2084 = 2084;
        final int QUESTION_NO_2085 = 2085;
        final int QUESTION_NO_2086 = 2086;
        final int QUESTION_NO_2087 = 2087;
        final int QUESTION_NO_2088 = 2088;
        final int QUESTION_NO_2089 = 2089;
        final int QUESTION_NO_2090 = 2090;
        final int QUESTION_NO_2091 = 2091;
        final int QUESTION_NO_2092 = 2092;
        final int QUESTION_NO_2093 = 2093;
        final int QUESTION_NO_2094 = 2094;
        final int QUESTION_NO_2095 = 2095;
        final int QUESTION_NO_2096 = 2096;
        final int QUESTION_NO_2097 = 2097;
        final int QUESTION_NO_2098 = 2098;
        final int QUESTION_NO_2099 = 2099;
        final int QUESTION_NO_2100 = 2100;

        // column name query formation
        StringBuilder columnStringBuilder = new StringBuilder();
        columnStringBuilder.append(KEY_ANSWER).append(", ")
                .append(KEY_TYPE).append(", ").append(KEY_RESOURCE)
                .append(", ").append(KEY_IS_CORRECT).append(", ")
                .append(KEY_QUESTION_ID);

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que1).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2001)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que2).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2002)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que3).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2003)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que4).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2004)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que5).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2005)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que6).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2006)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que7).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2007)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que8).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2008)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que9).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2009)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que10).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2010)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que11).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2011)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que12).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2012)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que13).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2003)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que14).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2014)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que15).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2015)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que16).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2016)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que17).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2017)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que18).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2018)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que19).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2019)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que20).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2020)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que21).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2021)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que22).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2022)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que23).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2023)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que24).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2024)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que25).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2025)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que26).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2026)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que27).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2027)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que28).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2028)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que29).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2029)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que30).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2030)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que31).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2031)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que32).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2032)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que33).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2033)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que34).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2034)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que35).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2035)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que36).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2036)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ans_type6_que37).append(", ")
                .append(Utils.TYPE_NORMAL).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2037)
                .append(" )").toString());


    }

    private void insertAnsType7(SQLiteDatabase db){

        final int QUESTION_NO_2501 = 2501;
        final int QUESTION_NO_2502 = 2502;
        final int QUESTION_NO_2503 = 2503;
        final int QUESTION_NO_2504 = 2504;
        final int QUESTION_NO_2505 = 2505;
        final int QUESTION_NO_2506 = 2506;
        final int QUESTION_NO_2507 = 2507;
        final int QUESTION_NO_2508 = 2508;
        final int QUESTION_NO_2509 = 2509;
        final int QUESTION_NO_2510 = 2510;
        final int QUESTION_NO_2511 = 2511;
        final int QUESTION_NO_2512 = 2512;
        final int QUESTION_NO_2513 = 2513;
        final int QUESTION_NO_2514 = 2514;
        final int QUESTION_NO_2515 = 2515;
        final int QUESTION_NO_2516 = 2516;
        final int QUESTION_NO_2517 = 2517;
        final int QUESTION_NO_2518 = 2518;
        final int QUESTION_NO_2519 = 2519;
        final int QUESTION_NO_2520 = 2520;
        final int QUESTION_NO_2521 = 2521;
        final int QUESTION_NO_2522 = 2522;
        final int QUESTION_NO_2523 = 2523;
        final int QUESTION_NO_2524 = 2524;
        final int QUESTION_NO_2525 = 2525;
        final int QUESTION_NO_2526 = 2526;
        final int QUESTION_NO_2527 = 2527;
        final int QUESTION_NO_2528 = 2528;
        final int QUESTION_NO_2529 = 2529;
        final int QUESTION_NO_2530 = 2530;
        final int QUESTION_NO_2531 = 2531;
        final int QUESTION_NO_2532 = 2532;
        final int QUESTION_NO_2533 = 2533;
        final int QUESTION_NO_2534 = 2534;
        final int QUESTION_NO_2535 = 2535;
        final int QUESTION_NO_2536 = 2536;
        final int QUESTION_NO_2537 = 2537;
        final int QUESTION_NO_2538 = 2538;
        final int QUESTION_NO_2539 = 2539;
        final int QUESTION_NO_2540 = 2540;
        final int QUESTION_NO_2541 = 2541;
        final int QUESTION_NO_2542 = 2542;
        final int QUESTION_NO_2543 = 2543;
        final int QUESTION_NO_2544 = 2544;
        final int QUESTION_NO_2545 = 2545;
        final int QUESTION_NO_2546 = 2546;
        final int QUESTION_NO_2547 = 2547;
        final int QUESTION_NO_2548 = 2548;
        final int QUESTION_NO_2549 = 2549;
        final int QUESTION_NO_2550 = 2550;
        final int QUESTION_NO_2551 = 2551;
        final int QUESTION_NO_2552 = 2552;
        final int QUESTION_NO_2553 = 2553;
        final int QUESTION_NO_2554 = 2554;
        final int QUESTION_NO_2555 = 2555;
        final int QUESTION_NO_2556 = 2556;
        final int QUESTION_NO_2557 = 2557;
        final int QUESTION_NO_2558 = 2558;
        final int QUESTION_NO_2559 = 2559;
        final int QUESTION_NO_2560 = 2560;
        final int QUESTION_NO_2561 = 2561;
        final int QUESTION_NO_2562 = 2562;
        final int QUESTION_NO_2563 = 2563;
        final int QUESTION_NO_2564 = 2564;
        final int QUESTION_NO_2565 = 2565;
        final int QUESTION_NO_2566 = 2566;
        final int QUESTION_NO_2567 = 2567;
        final int QUESTION_NO_2568 = 2568;
        final int QUESTION_NO_2569 = 2569;
        final int QUESTION_NO_2570 = 2570;
        final int QUESTION_NO_2571 = 2571;
        final int QUESTION_NO_2572 = 2572;
        final int QUESTION_NO_2573 = 2573;
        final int QUESTION_NO_2574 = 2574;
        final int QUESTION_NO_2575 = 2575;
        final int QUESTION_NO_2576 = 2576;
        final int QUESTION_NO_2577 = 2577;
        final int QUESTION_NO_2578 = 2578;
        final int QUESTION_NO_2579 = 2579;
        final int QUESTION_NO_2580 = 2580;
        final int QUESTION_NO_2581 = 2581;
        final int QUESTION_NO_2582 = 2582;
        final int QUESTION_NO_2583 = 2583;
        final int QUESTION_NO_2584 = 2584;
        final int QUESTION_NO_2585 = 2585;
        final int QUESTION_NO_2586 = 2586;
        final int QUESTION_NO_2587 = 2587;
        final int QUESTION_NO_2588 = 2588;
        final int QUESTION_NO_2589 = 2589;
        final int QUESTION_NO_2590 = 2590;
        final int QUESTION_NO_2591 = 2591;
        final int QUESTION_NO_2592 = 2592;
        final int QUESTION_NO_2593 = 2593;
        final int QUESTION_NO_2594 = 2594;
        final int QUESTION_NO_2595 = 2595;
        final int QUESTION_NO_2596 = 2596;
        final int QUESTION_NO_2597 = 2597;
        final int QUESTION_NO_2598 = 2598;
        final int QUESTION_NO_2599 = 2599;
        final int QUESTION_NO_2600 = 2600;

        // column name query formation
        StringBuilder columnStringBuilder = new StringBuilder();
        columnStringBuilder.append(KEY_ANSWER).append(", ")
                .append(KEY_TYPE).append(", ").append(KEY_RESOURCE)
                .append(", ").append(KEY_IS_CORRECT).append(", ")
                .append(KEY_QUESTION_ID);

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2501)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2502)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2503)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2504)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2505)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2506)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2507)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2508)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2509)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2510)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2511)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2512)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2513)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2514)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2515)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2516)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2517)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2518)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2519)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2520)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2521)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2522)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2523)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2524)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2525)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2526)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2527)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2528)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2529)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2530)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2531)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2532)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2533)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2534)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2535)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2536)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2537)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2538)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2539)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2540)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2541)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2542)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2543)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2544)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2545)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2546)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2547)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2548)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2549)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2550)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2551)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2552)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2553)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2554)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2555)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2556)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2557)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2558)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2559)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2560)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2561)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2562)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2563)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2564)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2565)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2566)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2567)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2568)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2569)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2570)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2571)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2572)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2573)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2574)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2575)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2576)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2577)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2578)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2579)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2580)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2581)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2582)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2583)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2584)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2585)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2586)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2587)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2588)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2589)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2590)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2591)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2592)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2593)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2594)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2595)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2596)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2597)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2598)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.CORRECT).append(", ").append(QUESTION_NO_2599)
                .append(" )").toString());

        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_ANSWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(Utils.KEY_ANSWER_NULL).append(", ")
                .append(Utils.QUESTION_TRUE_FALSE).append(", ")
                .append(Utils.NULL).append(", ")
                .append(Utils.INCORRECT).append(", ").append(QUESTION_NO_2600)
                .append(" )").toString());
    }






    public Question getQuestionByType(int type) {
        // generate random question based on type
        Log.e("type","" +type);
//        String query = "SELECT * FROM " + TABLE_QUESTION + " WHERE " + KEY_TYPE
//                + " = " + type;

        String query = "SELECT * FROM " + TABLE_QUESTION + " WHERE " + KEY_TYPE
                + " = " + type + " ORDER BY RANDOM() LIMIT 1";

        Cursor cursor = sqldb.rawQuery(query, null);

        if (cursor.moveToNext()) {
            return new Question(cursor.getInt(cursor.getColumnIndex(KEY_ID)),
                    cursor.getInt(cursor.getColumnIndex(KEY_QUESTION)),
                    cursor.getInt(cursor.getColumnIndex(KEY_TYPE)),
                    cursor.getInt(cursor.getColumnIndex(KEY_RESOURCE)));
        }
        cursor.close();
        return null;
    }


    public ArrayList<Answer> getAnswersByQuestionId(int questionId) {

        ArrayList<Answer> answerList = new ArrayList<Answer>();
        Cursor cursor = sqldb.query(TABLE_ANSWER, null, KEY_QUESTION_ID
                + " = " + questionId, null, null, null, null);

        while (cursor.moveToNext()) {
            answerList.add(new Answer(
                    cursor.getInt(cursor.getColumnIndex(KEY_ID)),
                    cursor.getInt(cursor.getColumnIndex(KEY_ANSWER)),
                    cursor.getInt(cursor.getColumnIndex(KEY_TYPE)),
                    cursor.getInt(cursor.getColumnIndex(KEY_RESOURCE)),
                    cursor.getInt(cursor.getColumnIndex(KEY_IS_CORRECT)),
                    cursor.getInt(cursor.getColumnIndex(KEY_QUESTION_ID))

            ));
        }

        cursor.close();

        return answerList;
    }
}
